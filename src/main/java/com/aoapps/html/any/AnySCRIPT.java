/*
 * ao-fluent-html-any - Base abstract classes and interfaces for Fluent Java DSL for high-performance HTML generation.
 * Copyright (C) 2019, 2020, 2021, 2022  AO Industries, Inc.
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
 * along with ao-fluent-html-any.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.aoapps.html.any;

import com.aoapps.encoding.Doctype;
import com.aoapps.encoding.JavaScriptWritable;
import com.aoapps.encoding.JavaScriptWriter;
import com.aoapps.encoding.MediaEncoder;
import com.aoapps.encoding.MediaType;
import com.aoapps.encoding.Serialization;
import static com.aoapps.encoding.TextInXhtmlAttributeEncoder.encodeTextInXhtmlAttribute;
import com.aoapps.hodgepodge.i18n.MarkupCoercion;
import com.aoapps.lang.Coercion;
import com.aoapps.lang.Strings;
import com.aoapps.lang.Throwables;
import com.aoapps.lang.io.ContentType;
import com.aoapps.lang.io.function.IOSupplierE;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Locale;

/**
 * <ul>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/scripting.html#the-script-element">4.12.1 The script element</a>.</li>
 * <li>See <a href="https://www.w3schools.com/tags/tag_script.asp">HTML script tag</a>.</li>
 * </ul>
 *
 * @param  <D>   This document type
 * @param  <PC>  The parent content model this element is within
 * @param  <E>   This element type
 *
 * @author  AO Industries, Inc.
 */
// TODO: Extend RawTextElement: https://html.spec.whatwg.org/multipage/syntax.html#raw-text-elements
@SuppressWarnings("deprecation")
public abstract class AnySCRIPT<
	D  extends AnyDocument<D>,
	PC extends AnyScriptSupportingContent<D, PC>,
	E  extends AnySCRIPT<D, PC, E>
> extends Element<D, PC, E> implements
	com.aoapps.html.any.attributes.Boolean.Async<E>,
	com.aoapps.html.any.attributes.Enum.Charset<E, com.aoapps.html.any.attributes.Enum.Charset.Value>,
	com.aoapps.html.any.attributes.Boolean.Defer<E>,
	com.aoapps.html.any.attributes.Url.Src<E>,
	// TODO: type
	// TODO: xmlSpace
	// Global Attributes overrides
	com.aoapps.html.any.attributes.Text.AccesskeyUnexpected<E>,
	com.aoapps.html.any.attributes.Boolean.AutofocusUnexpected<E>,
	com.aoapps.html.any.attributes.Text.ClassNoHtml4<E>,
	com.aoapps.html.any.attributes.Enum.DirUnexpected<E>,
	com.aoapps.html.any.attributes.Text.IdNoHtml4<E>,
	com.aoapps.html.any.attributes.Text.StyleNoHtml4<E>,
	com.aoapps.html.any.attributes.Text.TitleNoHtml4<E>,
	// Global Event Attributes overrides
	com.aoapps.html.any.attributes.event.OnblurUnexpected<E>,
	com.aoapps.html.any.attributes.event.OnclickUnexpected<E>,
	com.aoapps.html.any.attributes.event.OncontextmenuUnexpected<E>,
	com.aoapps.html.any.attributes.event.OncopyUnexpected<E>,
	com.aoapps.html.any.attributes.event.OncutUnexpected<E>,
	com.aoapps.html.any.attributes.event.OndblclickUnexpected<E>,
	com.aoapps.html.any.attributes.event.OndragUnexpected<E>,
	com.aoapps.html.any.attributes.event.OndragendUnexpected<E>,
	com.aoapps.html.any.attributes.event.OndragenterUnexpected<E>,
	com.aoapps.html.any.attributes.event.OndragleaveUnexpected<E>,
	com.aoapps.html.any.attributes.event.OndragoverUnexpected<E>,
	com.aoapps.html.any.attributes.event.OndragstartUnexpected<E>,
	com.aoapps.html.any.attributes.event.OndropUnexpected<E>,
	com.aoapps.html.any.attributes.event.Onerror<E>,
	com.aoapps.html.any.attributes.event.OnfocusUnexpected<E>,
	com.aoapps.html.any.attributes.event.Onload<E>,
	com.aoapps.html.any.attributes.event.OnkeydownUnexpected<E>,
	com.aoapps.html.any.attributes.event.OnkeypressUnexpected<E>,
	com.aoapps.html.any.attributes.event.OnkeyupUnexpected<E>,
	com.aoapps.html.any.attributes.event.OnmousedownUnexpected<E>,
	com.aoapps.html.any.attributes.event.OnmouseenterUnexpected<E>,
	com.aoapps.html.any.attributes.event.OnmouseleaveUnexpected<E>,
	com.aoapps.html.any.attributes.event.OnmousemoveUnexpected<E>,
	com.aoapps.html.any.attributes.event.OnmouseoutUnexpected<E>,
	com.aoapps.html.any.attributes.event.OnmouseoverUnexpected<E>,
	com.aoapps.html.any.attributes.event.OnmouseupUnexpected<E>,
	com.aoapps.html.any.attributes.event.OnpasteUnexpected<E>,
	com.aoapps.html.any.attributes.event.OnscrollUnexpected<E>,
	com.aoapps.html.any.attributes.event.OnwheelUnexpected<E>
{

	/**
	 * See <a href="https://www.w3schools.com/tags/att_script_type.asp">HTML script type Attribute</a>.
	 */
	public enum Type {
		/**
		 * The default type for (X)HTML 5.
		 */
		APPLICATION_JAVASCRIPT(ContentType.JAVASCRIPT),

		/**
		 * The default type for XHTML 1.0 / HTML 4.
		 *
		 * @deprecated  Use {@link #APPLICATION_JAVASCRIPT} in HTML 5.
		 */
		@Deprecated
		TEXT_JAVASCRIPT(ContentType.JAVASCRIPT_OLD),

		/**
		 * A JSON object graph.
		 */
		APPLICATION_JSON(ContentType.JSON),

		/**
		 * JSON linked data.
		 */
		APPLICATION_JD_JSON(ContentType.LD_JSON),

		APPLICATION_ECMASCRIPT(ContentType.ECMASCRIPT);

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

	protected AnySCRIPT(D document, PC pc) {
		super(document, pc);
		this.type = null;
	}

	protected AnySCRIPT(D document, PC pc, String type) {
		super(document, pc);
		type = Strings.trimNullIfEmpty(type);
		this.type = (type == null) ? null : type.toLowerCase(Locale.ROOT);
	}

	protected AnySCRIPT(D document, PC pc, Type type) {
		super(document, pc);
		this.type = (type == null) ? null : type.getContentType();
	}

	@Override
	protected E writeOpen(Writer out) throws IOException {
		document.autoNli(out).unsafe(out, "<script", false);
		E s = type();
		assert s == this;
		@SuppressWarnings("unchecked") E element = (E)this;
		return element;
	}

	/**
	 * See <a href="https://www.w3schools.com/tags/att_script_type.asp">HTML script type Attribute</a>.
	 *
	 * @see Doctype#scriptType(java.lang.Appendable)
	 */
	protected E type() throws IOException {
		Writer out = document.getRawUnsafe(null);
		// TODO: Check didBody here and other attributes, perhaps in some central attribute registry that detects duplicate attributes, too
		if(
			type == null
			|| type.equals(ContentType.JAVASCRIPT)
			|| type.equals(ContentType.JAVASCRIPT_OLD)
		) {
			String typeAttr = document.encodingContext.getDoctype().getScriptType();
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

	protected MediaType getMediaType() throws UnsupportedEncodingException {
		return type == null ? MediaType.JAVASCRIPT : MediaType.getMediaTypeForContentType(type);
	}

	protected MediaEncoder getMediaEncoder(MediaType mediaType) throws UnsupportedEncodingException {
		return MediaEncoder.getInstance(document.encodingContext, mediaType, MediaType.XHTML);
	}

	protected boolean doCdata() {
		return
			document.encodingContext.getSerialization() == Serialization.XML
			&& (
				type == null
				|| type.equals(ContentType.JAVASCRIPT)
				|| type.equals(ContentType.JAVASCRIPT_OLD)
				|| type.equals(ContentType.ECMASCRIPT)
				|| type.equals(ContentType.ECMASCRIPT_OLD)
			);
	}

	private boolean didBody;

	protected void startBody(Writer out) throws IOException {
		if(!didBody) {
			document
				.autoIndent(out)
				.unsafe(out, doCdata() ? (">//<![CDATA[" + NL) : (">" + NL), true)
				.incDepth();
			didBody = true;
		}
	}

	// TODO: Return a "Body" / "ScriptBody" that only allows additional out or closing the tag.
	// TODO:     Setting attributes after startBody() would create invalid HTML.
	// TODO:     Similar for "text", too.
	// TODO: Interface for "out" with default methods? (Another for "text", too)
	@SuppressWarnings("UseSpecificCatch")
	// TODO: No "out", just closing "__"?
	public E out(Object script) throws IOException {
		while(script instanceof IOSupplierE<?, ?>) {
			try {
				script = ((IOSupplierE<?, ?>)script).get();
			} catch(Throwable t) {
				throw Throwables.wrap(t, IOException.class, IOException::new);
			}
		}
		if(script instanceof JavaScriptWritable) {
			try {
				@SuppressWarnings("unchecked") JavaScriptWritable<?> writable = (JavaScriptWritable<?>)script;
				return out(writable);
			} catch(Throwable t) {
				throw Throwables.wrap(t, IOException.class, IOException::new);
			}
		}
		script = Coercion.nullIfEmpty(script);
		if(script != null) {
			Writer out = document.getRawUnsafe(null);
			startBody(out);
			// Allow text markup from translations
			MediaType mediaType = getMediaType();
			MarkupCoercion.write(
				script,
				mediaType.getMarkupType(),
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
	public <Ex extends Throwable> E out(IOSupplierE<?, Ex> script) throws IOException, Ex {
		return out((script == null) ? null : script.get());
	}

	/**
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 */
	// TODO: No "out", just closing "__"?
	public <Ex extends Throwable> E out(JavaScriptWritable<Ex> script) throws IOException, Ex {
		if(script != null) {
			MediaType newOutputType = getMediaType();
			MediaEncoder encoder = getMediaEncoder(newOutputType);
			Writer out = document.getRawUnsafe(null);
			startBody(out);
			script.writeTo(
				newOutputType.newMediaWriter(
					document.encodingContext,
					encoder,
					document.getRawUnsafe(null),
					false,
					document,
					mediaWriter -> true, // isNoClose
					null // Ignore close
				)
			);
			document.clearAtnl(); // Unknown, safe to assume not at newline
		}
		@SuppressWarnings("unchecked") E element = (E)this;
		return element;
	}

	/**
	 * Writes the script, automatically closing the script via
	 * {@link #__()} on {@link JavaScriptWriter#close()}.
	 * This is well suited for use in a try-with-resources block.
	 */
	// TODO: __() method to end text?  Call it "ContentWriter"?
	public JavaScriptWriter _c() throws IOException {
		MediaType newOutputType = getMediaType();
		MediaEncoder encoder = getMediaEncoder(newOutputType);
		Writer out = document.getRawUnsafe(null);
		startBody(out);
		// Invoking via newMediaWriter to support subclasses of JavaScriptWriter
		return (JavaScriptWriter)newOutputType.newMediaWriter(
			document.encodingContext,
			encoder,
			out,
			false,
			document,
			mediaWriter -> false, // !isNoClose
			closing -> __()
		);
	}

	/**
	 * Closes this element.
	 *
	 * @return  The parent content model this element is within
	 */
	public PC __() throws IOException {
		Writer out = document.getRawUnsafe(null);
		if(!didBody) {
			document.autoIndent(out).unsafe(out, "></script>", false);
		} else {
			document.decDepth().nli(out).unsafe(out, doCdata() ? "//]]></script>" : "</script>", false);
		}
		document.autoNl(out);
		return pc;
	}
}
