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

import java.io.IOException;
import java.io.Writer;
import java.util.function.Function;

/**
 * <ul>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/forms.html#the-form-element">4.10.3 The form element</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/form">&lt;form&gt;</a>.</li>
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
// TODO: Flow content, but with no form element descendants.
public abstract class AnyFORM<
	D  extends AnyDocument<D>,
	PC extends AnyPalpableContent<D, PC>,
	E  extends AnyFORM<D, PC, E, __, _c>,
	__ extends AnyFORM__<D, PC, __>,
	// Would prefer "_c extends __ & Closeable<D, PC>", but "a type variable may not be followed by other bounds"
	_c extends AnyFORM_c<D, PC, _c>
> extends NormalText<D, PC, E, __, _c> implements
	// TODO: accept (MDN only, HTML-4 only)
	// TODO: accept-charset
	com.aoapps.html.any.attributes.Url.Action<E>,
	com.aoapps.html.any.attributes.Enum.Autocomplete<E, AnyFORM.Autocomplete>,
	com.aoapps.html.any.attributes.Enum.Enctype<E, com.aoapps.html.any.attributes.Enum.Enctype.Value>,
	com.aoapps.html.any.attributes.Enum.Method<E, com.aoapps.html.any.attributes.Enum.Method.Value>,
	// TODO: name (only support Id, and do name like <ao:iframe>?)  Deprecated as of html 4
	com.aoapps.html.any.attributes.Boolean.Novalidate<E>,
	com.aoapps.html.any.attributes.Enum.Target<E, com.aoapps.html.any.attributes.Enum.Target.Value>,
	// TODO: rel
	// Global Event Attributes overrides
	com.aoapps.html.any.attributes.event.Onreset<E>,
	com.aoapps.html.any.attributes.event.Onsubmit<E>
{

	protected AnyFORM(D document, PC pc) {
		super(document, pc);
	}

	/**
	 * See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/form#attr-autocomplete">&lt;select&gt;: The Form element / autocomplete</a>.
	 *
	 * @since HTML 5
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

	@Override
	protected E writeOpen(Writer unsafe) throws IOException {
		document.autoNli(unsafe).unsafe(unsafe, "<form", false); // TODO: Is whitespace around <form> ok? autoIndent() instead like AnySELECT?
		@SuppressWarnings("unchecked") E element = (E)this;
		return element;
	}

	@Override
	protected void doBeforeBody(Writer unsafe) throws IOException {
		document.autoNl(unsafe);
	}

	@Override
	protected void writeClose(Writer unsafe, boolean closeAttributes) throws IOException {
		if(closeAttributes) {
			document.autoIndent(unsafe).unsafe(unsafe, "></form>", false);
		} else {
			document.autoNli(unsafe).unsafe(unsafe, "</form>", false);
		}
		document.autoNl(unsafe); // TODO: Is whitespace around <form> ok? No final autoNl() like AnySELECT?
	}
}
