/*
 * ao-fluent-html-any - Base abstract classes and interfaces for Fluent Java DSL for high-performance HTML generation.
 * Copyright (C) 2022  AO Industries, Inc.
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

import java.io.IOException;
import java.io.Writer;
import java.util.function.Function;

/**
 * <ul>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/form-elements.html#the-textarea-element">4.10.11 The textarea element</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/textarea">&lt;textarea&gt;: The Textarea element</a>.</li>
 * <li>See <a href="https://www.w3schools.com/tags/tag_textarea.asp">HTML textarea tag</a>.</li>
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
public abstract class AnyTEXTAREA<
	D  extends AnyDocument<D>,
	PC extends AnyUnion_Interactive_Phrasing<D, PC>,
	E  extends AnyTEXTAREA<D, PC, E, __, _c>,
	__ extends AnyTEXTAREA__<D, PC, __>,
	// Would prefer "_c extends __ & Closeable<D, PC>", but "a type variable may not be followed by other bounds"
	_c extends AnyTEXTAREA_c<D, PC, _c>
> extends NormalText<D, PC, E, __, _c> implements
	com.aoapps.html.any.attributes.Enum.Autocomplete<E, AnyTEXTAREA.Autocomplete>,
	com.aoapps.html.any.attributes.Integer.Cols<E>,
	// TODO: dirname
	com.aoapps.html.any.attributes.Boolean.Disabled<E>,
	com.aoapps.html.any.attributes.Text.Form<E>,
	com.aoapps.html.any.attributes.Integer.Maxlength<E>,
	com.aoapps.html.any.attributes.Integer.Minlength<E>,
	com.aoapps.html.any.attributes.Text.Name<E>,
	com.aoapps.html.any.attributes.Text.Placeholder<E>,
	com.aoapps.html.any.attributes.Boolean.Readonly<E>,
	com.aoapps.html.any.attributes.Boolean.Required<E>,
	com.aoapps.html.any.attributes.Integer.Rows<E>,
	com.aoapps.html.any.attributes.Enum.Wrap<E, com.aoapps.html.any.attributes.Enum.Wrap.Value>,
	// Global Attributes: https://www.w3schools.com/tags/ref_standardattributes.asp
	com.aoapps.html.any.attributes.Integer.TabindexHtml4<E>,
	// Global Event Attributes: https://www.w3schools.com/tags/ref_eventattributes.asp
	AlmostGlobalAttributes<E>,
	com.aoapps.html.any.attributes.event.Onchange<E>
{

	private boolean oldAutonli;
	private boolean oldIndent;
	private int oldDepth;

	protected AnyTEXTAREA(D document, PC pc) {
		super(document, pc);
	}

	/**
	 * See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/textarea#attr-autocomplete">&lt;textarea&gt;: The Textarea element / autocomplete</a>.
	 *
	 * @see AnyINPUT.Autocomplete
	 */
	public enum Autocomplete implements Function<AnyDocument<?>, String> {
		OFF(AnyINPUT.Autocomplete.OFF),
		ON(AnyINPUT.Autocomplete.ON);

		private final AnyINPUT.Autocomplete value;

		private Autocomplete(AnyINPUT.Autocomplete value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return value.toString();
		}

		@Override
		public String apply(AnyDocument<?> document) {
			return value.apply(document);
		}

		public AnyINPUT.Autocomplete getValue() {
			return value;
		}

		static {
			for(Autocomplete value : values()) {
				if(!value.name().equals(value.value.name())) throw new AssertionError("Enum name mismatch");
			}
		}
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
		document.autoNli(out).unsafe(out, "<textarea", false);
		@SuppressWarnings("unchecked") E element = (E)this;
		return element;
	}

	@Override
	protected void doBeforeBody(Writer out) throws IOException {
		oldAutonli = document.getAutonli();
		if(oldAutonli) document.setAutonli(false);
		oldIndent = document.getIndent();
		if(oldIndent) document.setIndent(false);
		oldDepth = document.getDepth();
		if(oldDepth != 0) document.setDepth(0);
	}

	@Override
	protected void writeClose(Writer out, boolean closeAttributes) throws IOException {
		document
			.setDepth(oldDepth)
			.setIndent(oldIndent)
			.setAutonli(oldAutonli);
		if(closeAttributes) {
			document.autoIndent(out).unsafe(out, "></textarea>", false);
		} else {
			document.unsafe(out, "</textarea>", false);
		}
		document.autoNl(out);
	}
}
