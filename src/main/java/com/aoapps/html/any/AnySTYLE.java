/*
 * ao-fluent-html-any - Base abstract classes and interfaces for Fluent Java DSL for high-performance HTML generation.
 * Copyright (C) 2019, 2020, 2021  AO Industries, Inc.
 *     support@aoindustries.com
 *     7262 Bull Pen Cir
 *     Mobile, AL 36695
 *
 * This file is part of ao-fluent-html-any.
 *
 * ao-fluent-html-any is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * ao-fluent-html-any is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with ao-fluent-html-any.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.aoapps.html.any;

import com.aoapps.encoding.Doctype;
import com.aoapps.encoding.MediaEncoder;
import com.aoapps.encoding.MediaType;
import com.aoapps.encoding.Serialization;
import static com.aoapps.encoding.TextInXhtmlAttributeEncoder.encodeTextInXhtmlAttribute;
import static com.aoapps.encoding.TextInXhtmlEncoder.textInXhtmlEncoder;
import com.aoapps.hodgepodge.i18n.MarkupCoercion;
import com.aoapps.hodgepodge.i18n.MarkupType;
import com.aoapps.lang.Coercion;
import com.aoapps.lang.Strings;
import com.aoapps.lang.Throwables;
import com.aoapps.lang.io.ContentType;
import com.aoapps.lang.io.NoCloseWriter;
import com.aoapps.lang.io.function.IOSupplierE;
import java.io.IOException;
import java.io.Writer;
import java.util.Locale;

/**
 * <ul>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/semantics.html#the-style-element">4.2.6 The style element</a>.</li>
 * <li>See <a href="https://www.w3schools.com/tags/tag_style.asp">HTML style tag</a>.</li>
 * </ul>
 *
 * @param  <D>   This document type
 * @param  <PC>  The parent content model this element is within
 * @param  <E>   This element type
 *
 * @author  AO Industries, Inc.
 */
// TODO: Extend RawTextElement: https://html.spec.whatwg.org/multipage/syntax.html#raw-text-elements
abstract public class AnySTYLE<
	D  extends AnyDocument<D>,
	PC extends AnyMetadataContent<D, PC>,
	E  extends AnySTYLE<D, PC, E>
> extends Element<D, PC, E> implements
	com.aoapps.html.any.attributes.Text.Media<E>,
	// Global Attributes: https://www.w3schools.com/tags/ref_standardattributes.asp
	com.aoapps.html.any.attributes.Text.ClassNoHtml4<E>,
	com.aoapps.html.any.attributes.Text.IdNoHtml4<E>,
	com.aoapps.html.any.attributes.Text.StyleNoHtml4<E>,
	com.aoapps.html.any.attributes.Text.TitleNoHtml4<E>,
	// Global Event Attributes: https://www.w3schools.com/tags/ref_eventattributes.asp
	// Not on <style>: AlmostGlobalAttributes<E>
	com.aoapps.html.any.attributes.event.window.Onerror<E>, // Only listed at https://www.w3schools.com/tags/ref_attributes.asp
	com.aoapps.html.any.attributes.event.window.Onload<E>
{

	/**
	 * See <a href="https://www.w3schools.com/tags/att_script_type.asp">HTML script type Attribute</a>.
	 */
	public enum Type {
		/**
		 * The default type.
		 */
		TEXT_CSS(ContentType.CSS);

		private final String contentType;

		private Type(String contentType) {
			this.contentType = contentType;
		}

		@Override
		public String toString() {
			return contentType;
		}

		public String getContentType() {
			return contentType;
		}

		private static boolean assertAllLowerCaseAndTrimmed() {
			for(Type type : values()) {
				if(!type.contentType.equals(type.contentType.toLowerCase(Locale.ROOT))) throw new AssertionError("Content types must be lowercase as looked-up later");
				if(!type.contentType.equals(type.contentType.trim())) throw new AssertionError("Content types must be trimmed as looked-up later");
			}
			return true;
		}
		static {
			assert assertAllLowerCaseAndTrimmed();
		}
	}

	private final String type;

	public AnySTYLE(D document, PC pc) {
		super(document, pc);
		this.type = null;
	}

	public AnySTYLE(D document, PC pc, String type) {
		super(document, pc);
		type = Strings.trimNullIfEmpty(type);
		this.type = (type == null) ? null : type.toLowerCase(Locale.ROOT);
	}

	public AnySTYLE(D document, PC pc, Type type) {
		super(document, pc);
		this.type = (type == null) ? null : type.getContentType();
	}

	@Override
	protected E writeOpen(Writer out) throws IOException {
		document.autoNli(out).unsafe(out, "<style", false);
		return type();
	}

	/**
	 * See <a href="https://www.w3schools.com/tags/att_style_type.asp">HTML style type Attribute</a>.
	 *
	 * @see Doctype#styleType(java.lang.Appendable)
	 */
	protected E type() throws IOException {
		Writer out = document.getUnsafe(null);
		if(
			type == null
			|| type.equals(ContentType.CSS)
		) {
			String typeAttr = document.doctype.getStyleType();
			int len = typeAttr.length();
			if(len > 0) {
				if(document.getAtnl()) {
					assert typeAttr.charAt(0) == ' ';
					document.autoIndent(out, 1);
					out.write(typeAttr, 1, len - 1);
					document.clearAtnl();
				} else {
					out.write(typeAttr);
				}
			}
		} else {
			if(document.getAtnl()) {
				document.autoIndent(out, 1);
				out.write("type=\"");
				document.clearAtnl();
			} else {
				out.write(" type=\"");
			}
			encodeTextInXhtmlAttribute(type, out);
			out.append('"');
		}
		@SuppressWarnings("unchecked") E element = (E)this;
		return element;
	}

	protected MediaType getMediaType() throws IOException {
		return MediaType.TEXT; // TODO: Version for CSS (with automatic URL rewriting?)
	}

	protected MediaEncoder getMediaEncoder(MediaType mediaType) throws IOException {
		// TODO: This is in a CDATA context, is this the correct way?  Probably not, but how to protect close CDATA ]]>?
		// TODO: Make CSS a fully-supported MediaType, then so this similar to AnySCRIPT.java
		return textInXhtmlEncoder;
	}

	protected boolean doCdata() {
		return document.serialization == Serialization.XML;
	}

	private boolean didBody;

	protected void startBody(Writer out) throws IOException {
		if(!didBody) {
			document
				.autoIndent(out)
				.unsafe(out, doCdata() ? (">/*<![CDATA[*/" + NL) : (">" + NL), true)
				.incDepth();
			didBody = true;
		}
	}

	// TODO: Out parameter with MediaType, that automatically picks the encoder
	// TODO: Separate "Write" for direct writing (no encoding)?
	@SuppressWarnings("UseSpecificCatch")
	// TODO: No "out", just closing "__"?
	public E out(Object style) throws IOException {
		while(style instanceof IOSupplierE<?, ?>) {
			try {
				style = ((IOSupplierE<?, ?>)style).get();
			} catch(Throwable t) {
				throw Throwables.wrap(t, IOException.class, IOException::new);
			}
		}
		if(style instanceof StyleWriter) {
			try {
				@SuppressWarnings("unchecked") StyleWriter<D, ?> writer = (StyleWriter<D, ?>)style;
				return out(writer);
			} catch(Throwable t) {
				throw Throwables.wrap(t, IOException.class, IOException::new);
			}
		}
		style = Coercion.nullIfEmpty(style);
		if(style != null) {
			Writer out = document.getUnsafe(null);
			startBody(out);
			// Allow text markup from translations
			MediaType mediaType = getMediaType();
			MarkupCoercion.write(
				style,
				// TODO: Find and fix other uses of MarkupType.JAVASCRIPT that should be CSS
				MarkupType.CSS, // TODO: Once CSS is a full-on media type: mediaType.getMarkupType(),
				true,
				getMediaEncoder(mediaType),
				false,
				out
			);
			document.clearAtnl(); // Unknown, safe to assume not at newline
		}
		@SuppressWarnings("unchecked") E element = (E)this;
		return element;
	}

	/**
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 */
	// TODO: No "out", just closing "__"?
	public <Ex extends Throwable> E out(IOSupplierE<?, Ex> style) throws IOException, Ex {
		return out((style == null) ? null : style.get());
	}

	/**
	 * @param  <D>   This document type
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 */
	// TODO: Consolidate with AttributeWriter?
	@FunctionalInterface
	public static interface StyleWriter<
		D  extends AnyDocument<D>,
		Ex extends Throwable
	> {
		void writeStyle(DocumentMediaWriter<D> style) throws IOException, Ex;
	}

	/**
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 */
	// TODO: No "out", just closing "__"?
	public <Ex extends Throwable> E out(StyleWriter<D, Ex> style) throws IOException, Ex {
		if(style != null) {
			MediaEncoder encoder = getMediaEncoder(getMediaType());
			Writer out = document.getUnsafe(null);
			startBody(out);
			style.writeStyle(
				new DocumentMediaWriter<>(
					document,
					encoder,
					new NoCloseWriter(out)
				)
			);
			document.clearAtnl(); // Unknown, safe to assume not at newline
		}
		@SuppressWarnings("unchecked") E element = (E)this;
		return element;
	}

	/**
	 * Writes the style, automatically closing the style via
	 * {@link #__()} on {@link DocumentMediaWriter#close()}.
	 * This is well suited for use in a try-with-resources block.
	 */
	// TODO: __() method to end text?  Call it "ContentWriter"?
	public DocumentMediaWriter<D> _c() throws IOException {
		MediaEncoder encoder = getMediaEncoder(getMediaType());
		Writer out = document.getUnsafe(null);
		startBody(out);
		return new DocumentMediaWriter<D>(document, encoder, out) {
			@Override
			public void close() throws IOException {
				__();
			}
		};
	}

	/**
	 * Closes this element.
	 *
	 * @return  The parent content model this element is within
	 */
	public PC __() throws IOException {
		Writer out = document.getUnsafe(null);
		if(!didBody) {
			document.autoIndent(out).unsafe(out, "></style>", false);
		} else {
			document.decDepth().nli(out).unsafe(out, doCdata() ? "/*]]>*/</style>" : "</style>", false);
		}
		document.autoNl(out);
		return pc;
	}
}
