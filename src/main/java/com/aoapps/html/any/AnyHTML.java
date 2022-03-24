/*
 * ao-fluent-html-any - Base abstract classes and interfaces for Fluent Java DSL for high-performance HTML generation.
 * Copyright (C) 2021, 2022  AO Industries, Inc.
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

import com.aoapps.encoding.Serialization;
import static com.aoapps.encoding.TextInXhtmlAttributeEncoder.textInXhtmlAttributeEncoder;
import com.aoapps.hodgepodge.i18n.MarkupType;
import com.aoapps.lang.io.function.IOSupplierE;
import java.io.IOException;
import java.io.Writer;
import java.util.Locale;

/**
 * See <a href="https://html.spec.whatwg.org/multipage/semantics.html#the-html-element">4.1.1 The html element</a>.
 *
 * @param  <D>   This document type
 * @param  <PC>  The parent content model this element is within
 * @param  <E>   This element type
 * @param  <__>  This content model, which will be the parent content model of child elements
 * @param  <_c>  This content model as {@link Closeable}, which will be the parent content model of child elements
 *
 * @author  AO Industries, Inc.
 */
@SuppressWarnings("deprecation")
public abstract class AnyHTML<
	D  extends AnyDocument<D>,
	PC extends Content<D, PC>,
	E  extends AnyHTML<D, PC, E, __, _c>,
	__ extends AnyHTML__<D, PC, __>,
	// Would prefer "_c extends __ & Closeable<D, PC>", but "a type variable may not be followed by other bounds"
	_c extends AnyHTML_c<D, PC, _c>
> extends Normal<D, PC, E, __, _c> implements
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
	com.aoapps.html.any.attributes.event.OndblclickUnexpected<E>,
	com.aoapps.html.any.attributes.event.OnfocusUnexpected<E>,
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
	com.aoapps.html.any.attributes.event.OnwheelUnexpected<E>
{

	protected AnyHTML(D document, PC pc) {
		super(document, pc);
	}

	/**
	 * Does not have indented content.
	 *
	 * @return {@code false} - does not indent
	 */
	@Override
	protected boolean isContentIndented() {
		return false;
	}

	@Override
	protected E writeOpen(Writer out) throws IOException {
		document.autoNli(out).unsafe(
			out,
			(document.serialization == Serialization.XML)
				? "<html xmlns=\"http://www.w3.org/1999/xhtml\""
				: "<html",
			false
		);
		@SuppressWarnings("unchecked") E element = (E)this;
		return element;
	}

	@Override
	protected void doBeforeBody(Writer out) throws IOException {
		document.autoNl(out);
	}

	@Override
	protected void writeClose(Writer out, boolean closeAttributes) throws IOException {
		if(closeAttributes) {
			document.autoIndent(out).unsafe(out, "></html>", false);
		} else {
			document.autoNli(out).unsafe(out, "</html>", false);
		}
		document.autoNl(out);
	}

	/**
	 * <p>
	 * In addition to the default <code>lang="…"</code>, also adds <code>xml:lang="…"</code> when the
	 * {@link AnyDocument#serialization} is {@link Serialization#XML}.
	 * </p>
	 * <ul>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes#attr-xml:lang">Global attributes - HTML: HyperText Markup Language | MDN</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/tags/ref_language_codes.asp">HTML ISO Language Code Reference</a>.</li>
	 * </ul>
	 * <hr>
	 * {@inheritDoc}
	 */
	@Override
	public E lang(Object lang) throws IOException {
		// Write default lang="…"
		super.lang(lang);
		@SuppressWarnings("unchecked") E element = (E)this;
		if(document.serialization == Serialization.XML) {
			// Add xml:lang="…"
			Attributes.Text.attribute(element, "xml:lang", MarkupType.NONE, lang, true, true, textInXhtmlAttributeEncoder);
		}
		return element;
	}

	/**
	 * <p>
	 * In addition to the default <code>lang="…"</code>, also adds <code>xml:lang="…"</code> when the
	 * {@link AnyDocument#serialization} is {@link Serialization#XML}.
	 * </p>
	 * <ul>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes#attr-xml:lang">Global attributes - HTML: HyperText Markup Language | MDN</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/tags/ref_language_codes.asp">HTML ISO Language Code Reference</a>.</li>
	 * </ul>
	 * <hr>
	 * {@inheritDoc}
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 *
	 * @see #lang(java.lang.Object)
	 */
	@Override
	public <Ex extends Throwable> E lang(IOSupplierE<?, Ex> lang) throws IOException, Ex {
		return super.lang(lang);
	}

	/**
	 * <p>
	 * In addition to the default <code>lang="…"</code>, also adds <code>xml:lang="…"</code> when the
	 * {@link AnyDocument#serialization} is {@link Serialization#XML}.
	 * </p>
	 * <ul>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes#attr-xml:lang">Global attributes - HTML: HyperText Markup Language | MDN</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/tags/ref_language_codes.asp">HTML ISO Language Code Reference</a>.</li>
	 * </ul>
	 * <hr>
	 * {@inheritDoc}
	 *
	 * @see #lang(java.lang.Object)
	 */
	@Override
	public E lang(Locale lang) throws IOException {
		return super.lang(lang);
	}

	/**
	 * <p>
	 * In addition to the default <code>lang="…"</code>, also adds <code>xml:lang="…"</code> when the
	 * {@link AnyDocument#serialization} is {@link Serialization#XML}.
	 * </p>
	 * <ul>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes#attr-xml:lang">Global attributes - HTML: HyperText Markup Language | MDN</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/tags/ref_language_codes.asp">HTML ISO Language Code Reference</a>.</li>
	 * </ul>
	 * <hr>
	 * {@inheritDoc}
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 *
	 * @see #lang(java.util.Locale)
	 */
	@Override
	public <Ex extends Throwable> E lang(Suppliers.Locale<Ex> lang) throws IOException, Ex {
		return super.lang(lang);
	}
}
