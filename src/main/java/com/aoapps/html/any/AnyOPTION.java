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
 * along with ao-fluent-html-any.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.aoapps.html.any;

import com.aoapps.encoding.MediaWritable;
import static com.aoapps.encoding.TextInXhtmlEncoder.textInXhtmlEncoder;
import com.aoapps.hodgepodge.i18n.MarkupCoercion;
import com.aoapps.hodgepodge.i18n.MarkupType;
import com.aoapps.lang.Throwables;
import com.aoapps.lang.io.NoCloseWriter;
import com.aoapps.lang.io.function.IOSupplierE;
import java.io.IOException;
import java.io.Writer;
import java.util.Optional;

/**
 * <ul>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/form-elements.html#the-option-element">4.10.10 The option element</a>.</li>
 * <li>See <a href="https://www.w3schools.com/tags/tag_option.asp">HTML option tag</a>.</li>
 * </ul>
 *
 * @param  <D>   This document type
 * @param  <PC>  The parent content model this element is within
 * @param  <E>   This element type
 *
 * @author  AO Industries, Inc.
 */
public abstract class AnyOPTION<
	D  extends AnyDocument<D>,
	PC extends AnyUnion_DATALIST_OPTGROUP<D, PC>,
	E  extends AnyOPTION<D, PC, E>
> extends Element<D, PC, E> implements
	com.aoapps.html.any.attributes.Boolean.Disabled<E>,
	com.aoapps.html.any.attributes.Text.Label<E>,
	com.aoapps.html.any.attributes.Boolean.Selected<E>,
	com.aoapps.html.any.attributes.Text.Value<E>,
	// Global Event Attributes: https://www.w3schools.com/tags/ref_eventattributes.asp
	AlmostGlobalAttributes<E>
{

	protected AnyOPTION(D document, PC pc) {
		super(document, pc);
	}

	@Override
	protected E writeOpen(Writer out) throws IOException {
		document.autoNli(out).unsafe(out, "<option", false);
		@SuppressWarnings("unchecked") E element = (E)this;
		return element;
	}

	/**
	 * See <a href="https://www.w3schools.com/tags/att_option_label.asp">HTML option label Attribute</a>.
	 *
	 * @deprecated  Although still part of the HTML specification, there is a
	 *              <a href="https://bugzilla.mozilla.org/show_bug.cgi?id=40545">20-year old Firefox bug</a>
	 *              that the label attribute is not supported.  We are deprecating
	 *              this method to make it clear it should probably not be used, as the
	 *              effect of label can be attained through the value attribute and
	 *              tag body anyway.
	 */
	@Deprecated
	@Override
	public E label(Object label) throws IOException {
		return com.aoapps.html.any.attributes.Text.Label.super.label(label);
	}

	/**
	 * See <a href="https://www.w3schools.com/tags/att_option_label.asp">HTML option label Attribute</a>.
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 *
	 * @see #label(java.lang.Object)
	 *
	 * @deprecated  Although still part of the HTML specification, there is a
	 *              <a href="https://bugzilla.mozilla.org/show_bug.cgi?id=40545">20-year old Firefox bug</a>
	 *              that the label attribute is not supported.  We are deprecating
	 *              this method to make it clear it should probably not be used, as the
	 *              effect of label can be attained through the value attribute and
	 *              tag body anyway.
	 */
	@Deprecated
	@Override
	public <Ex extends Throwable> E label(IOSupplierE<?, Ex> label) throws IOException, Ex {
		return com.aoapps.html.any.attributes.Text.Label.super.label(label);
	}

	/**
	 * See <a href="https://www.w3schools.com/tags/att_option_label.asp">HTML option label Attribute</a>.
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 *
	 * @see #label(java.lang.Object)
	 *
	 * @deprecated  Although still part of the HTML specification, there is a
	 *              <a href="https://bugzilla.mozilla.org/show_bug.cgi?id=40545">20-year old Firefox bug</a>
	 *              that the label attribute is not supported.  We are deprecating
	 *              this method to make it clear it should probably not be used, as the
	 *              effect of label can be attained through the value attribute and
	 *              tag body anyway.
	 */
	@Deprecated
	@Override
	public <Ex extends Throwable> E label(MediaWritable<Ex> label) throws IOException, Ex {
		return com.aoapps.html.any.attributes.Text.Label.super.label(label);
	}

	/**
	 * See <a href="https://www.w3schools.com/tags/att_option_value.asp">HTML option value Attribute</a>.
	 * <p>
	 * An empty value must still be specified for &lt;option&gt;, as it overrides the
	 * default behavior of using the tag's text content as the value.
	 * </p>
	 */
	@Override
	public E value(Object value) throws IOException {
		return com.aoapps.html.any.attributes.Text.Value.super.value(value);
	}

	/**
	 * Writes the text body then closes this element.
	 * Supports translation markup type {@link MarkupType#TEXT}.
	 *
	 * @return  The parent content model this element is within
	 */
	@SuppressWarnings("UseSpecificCatch")
	public PC __(Object text) throws IOException {
		// Support Optional
		while(text instanceof Optional) {
			text = ((Optional<?>)text).orElse(null);
		}
		while(text instanceof IOSupplierE<?, ?>) {
			try {
				text = ((IOSupplierE<?, ?>)text).get();
			} catch(Throwable t) {
				throw Throwables.wrap(t, IOException.class, IOException::new);
			}
		}
		if(text instanceof MediaWritable) {
			try {
				return __((MediaWritable<?>)text);
			} catch(Throwable t) {
				throw Throwables.wrap(t, IOException.class, IOException::new);
			}
		}
		if(text == null) {
			return __();
		} else {
			Writer out = document.getUnsafe(null);
			document.autoIndent(out).unsafe(out, '>').incDepth();
			boolean oldAutonli = document.getAutonli();
			if(oldAutonli) document.setAutonli(false);
			boolean oldIndent = document.getIndent();
			if(oldIndent) document.setIndent(false);
			try {
				// TODO: Only allow markup when the value has been set (auto-set value from text like ao-taglib?)
				// Allow text markup from translations
				MarkupCoercion.write(text, MarkupType.TEXT, true, textInXhtmlEncoder, false, out);
			} finally {
				document
					.setIndent(oldIndent)
					.setAutonli(oldAutonli);
			}
			document
				// Set in "unsafe" below: .clearAtnl() // Unknown, safe to assume not at newline
				.decDepth()
				// Assumed not at newline: .autoIndent()
				.unsafe(out, "</option>", false)
				.autoNl(out);
			return pc;
		}
	}

	/**
	 * Writes the text body then closes this element.
	 * Supports translation markup type {@link MarkupType#TEXT}.
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 *
	 * @return  The parent content model this element is within
	 */
	public <Ex extends Throwable> PC __(IOSupplierE<?, Ex> text) throws IOException, Ex {
		return __((text == null) ? null : text.get());
	}

	/**
	 * Writes the text body then closes this element.
	 * Does not perform any translation markups.
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 *
	 * @return  The parent content model this element is within
	 */
	public <Ex extends Throwable> PC __(MediaWritable<Ex> text) throws IOException, Ex {
		if(text == null) {
			return __();
		} else {
			Writer out = document.getUnsafe(null);
			document.autoIndent(out).unsafe(out, '>').incDepth();
			boolean oldAutonli = document.getAutonli();
			if(oldAutonli) document.setAutonli(false);
			boolean oldIndent = document.getIndent();
			if(oldIndent) document.setIndent(false);
			try {
				text.writeTo(
					new DocumentMediaWriter<>(
						document,
						textInXhtmlEncoder,
						new NoCloseWriter(out)
					)
				);
			} finally {
				document
					.setIndent(oldIndent)
					.setAutonli(oldAutonli);
			}
			document
				// Set in "unsafe" below: .clearAtnl() // Unknown, safe to assume not at newline
				.decDepth()
				// Assumed not at newline: .autoIndent()
				.unsafe(out, "</option>", false).
				autoNl(out);
			return pc;
		}
	}

	/**
	 * Writes a text body then closes this element.
	 * Does not perform any translation markups.
	 * This is well suited for use in a try-with-resources block.
	 */
	// TODO: __() method on DocumentMediaWriter to end text?  Call it "ContentWriter"?
	public DocumentMediaWriter<D> _c() throws IOException {
		Writer out = document.getUnsafe(null);
		document.autoIndent(out).unsafe(out, '>').incDepth();
		boolean oldAutonli = document.getAutonli();
		if(oldAutonli) document.setAutonli(false);
		boolean oldIndent = document.getIndent();
		if(oldIndent) document.setIndent(false);
		return new DocumentMediaWriter<D>(document, textInXhtmlEncoder, out) {
			@Override
			public void close() throws IOException {
				// Get a new "out", just in case changed before closing, such as in legacy JSP taglibs
				Writer out2 = document.getUnsafe(null);
				document
					.setIndent(oldIndent)
					.setAutonli(oldAutonli)
					// Set in "unsafe" below: .clearAtnl() // Unknown, safe to assume not at newline
					.decDepth()
					// Assumed not at newline: .autoIndent()
					.unsafe(out2, "</option>", false)
					.autoNl(out2);
			}
		};
	}

	/**
	 * Closes this element to form an empty option.
	 *
	 * @return  The parent content model this element is within
	 */
	public PC __() throws IOException {
		Writer out = document.getUnsafe(null);
		document.autoIndent(out).unsafe(out, "></option>", false).autoNl(out);
		return pc;
	}
}
