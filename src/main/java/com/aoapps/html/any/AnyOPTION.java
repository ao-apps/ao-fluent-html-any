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

import com.aoapps.encoding.TextWritable;
import com.aoapps.lang.io.function.IOSupplierE;
import java.io.IOException;
import java.io.Writer;

/**
 * <ul>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/form-elements.html#the-option-element">4.10.10 The option element</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/option">&lt;option&gt;: The HTML Option element</a>.</li>
 * <li>See <a href="https://www.w3schools.com/tags/tag_option.asp">HTML option tag</a>.</li>
 * </ul>
 *
 * @param  <D>   This document type
 * @param  <PC>  The parent content model this element is within
 * @param  <E>   This element type
 * @param  <__>  This content model, which will be the parent content model of child elements
 * @param  <_c>  This content model as {@link Closeable}, which will be the parent content model of child elements
 *
 * @author  AO Industries, Inc.
 */
public abstract class AnyOPTION<
	D  extends AnyDocument<D>,
	PC extends AnyUnion_DATALIST_OPTGROUP<D, PC>,
	E  extends AnyOPTION<D, PC, E, __, _c>,
	__ extends AnyOPTION__<D, PC, __>,
	// Would prefer "_c extends __ & Closeable<D, PC>", but "a type variable may not be followed by other bounds"
	_c extends AnyOPTION_c<D, PC, _c>
> extends NormalText<D, PC, E, __, _c> implements
	com.aoapps.html.any.attributes.Boolean.Disabled<E>,
	com.aoapps.html.any.attributes.Text.Label<E>,
	com.aoapps.html.any.attributes.Boolean.Selected<E>,
	com.aoapps.html.any.attributes.Text.Value<E>
{

	private boolean oldAutonli;
	private boolean oldIndent;
	private int oldDepth;

	protected AnyOPTION(D document, PC pc) {
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
	protected E writeOpen(Writer unsafe) throws IOException {
		document.autoNli(unsafe).unsafe(unsafe, "<option", false);
		@SuppressWarnings("unchecked") E element = (E)this;
		return element;
	}

	@Override
	protected void doBeforeBody(Writer unsafe) throws IOException {
		oldAutonli = document.getAutonli();
		if(oldAutonli) document.setAutonli(false);
		oldIndent = document.getIndent();
		if(oldIndent) document.setIndent(false);
		oldDepth = document.getDepth();
		if(oldDepth != 0) document.setDepth(0);
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
	public <Ex extends Throwable> E label(TextWritable<Ex> label) throws IOException, Ex {
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

	// TODO: How to ensure markup type NONE when no value set or TEXT when set?
	@Override
	protected void writeClose(Writer unsafe, boolean closeAttributes) throws IOException {
		document
			.setDepth(oldDepth)
			.setIndent(oldIndent)
			.setAutonli(oldAutonli);
		if(closeAttributes) {
			document.autoIndent(unsafe).unsafe(unsafe, "></option>", false);
		} else {
			document.unsafe(unsafe, "</option>", false);
		}
		document.autoNl(unsafe);
	}
}
