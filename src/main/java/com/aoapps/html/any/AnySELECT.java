/*
 * ao-fluent-html-any - Base abstract classes and interfaces for Fluent Java DSL for high-performance HTML generation.
 * Copyright (C) 2021  AO Industries, Inc.
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

import java.io.IOException;
import java.io.Writer;

/**
 * See <a href="https://html.spec.whatwg.org/multipage/form-elements.html#the-select-element">4.10.7 The select element</a>.
 *
 * @param  <D>   This document type
 * @param  <PC>  The parent content model this element is within
 * @param  <E>   This element type
 * @param  <__>  This content model, which will be the parent content model of child elements
 * @param  <_c>  This content model as {@link Closeable}, which will be the parent content model of child elements
 *
 * @author  AO Industries, Inc.
 */
// TODO: indent before, and newline after?  Review whitespace rules.  (this decision will affect AnyFORM, too)
//       https://developer.mozilla.org/en-US/docs/Web/API/Document_Object_Model/Whitespace
abstract public class AnySELECT<
	D  extends AnyDocument<D>,
	PC extends AnyUnion_Interactive_Phrasing<D, PC>,
	E  extends AnySELECT<D, PC, E, __, _c>,
	__ extends AnySELECT__<D, PC, __>,
	// Would prefer "_c extends __ & Closeable<D, PC>", but "a type variable may not be followed by other bounds"
	_c extends AnySELECT_c<D, PC, _c>
> extends
	Normal<D, PC, E, __, _c> implements
	// Global Event Attributes: https://www.w3schools.com/tags/ref_eventattributes.asp
	// TODO: autocomplete
	com.aoapps.html.any.attributes.Boolean.Disabled<E>,
	com.aoapps.html.any.attributes.Text.Form<E>,
	com.aoapps.html.any.attributes.Boolean.Multiple<E>,
	com.aoapps.html.any.attributes.Text.Name<E>,
	com.aoapps.html.any.attributes.Boolean.Required<E>,
	com.aoapps.html.any.attributes.Integer.Size<E>,
	AlmostGlobalAttributes<E>
{

	protected AnySELECT(D document, PC pc) {
		super(document, pc);
	}

	@Override
	protected E writeOpen(Writer out) throws IOException {
		document.autoIndent(out).unsafe(out, "<select", false);
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
			document.autoIndent(out).unsafe(out, "></select>", false);
		} else {
			document.autoNli(out).unsafe(out, "</select>", false);
		}
	}
}
