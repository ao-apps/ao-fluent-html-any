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
package com.aoindustries.html.any;

import java.io.IOException;
import java.io.Writer;

/**
 * See <a href="https://html.spec.whatwg.org/multipage/iframe-embed-object.html#the-object-element">4.8.7 The object element</a>.
 *
 * @param  <D>   This document type
 * @param  <PC>  The parent content model this element is within
 * @param  <E>   This element type
 * @param  <__>  This content model, which will be the parent content model of child elements
 * @param  <_c>  This content model as {@link Closeable}, which will be the parent content model of child elements
 *
 * @author  AO Industries, Inc.
 */
abstract public class AnyOBJECT<
	D  extends AnyDocument<D>,
	PC extends AnyUnion_Embedded_Interactive<D, PC>,
	E  extends AnyOBJECT<D, PC, E, __, _c>,
	__ extends AnyOBJECT__<D, PC, __>,
	// Would prefer "_c extends __ & Closeable<D, PC>", but "a type variable may not be followed by other bounds"
	_c extends AnyOBJECT_c<D, PC, _c>
> extends
	Normal<D, PC, E, __, _c> implements
	com.aoindustries.html.any.attributes.Url.Data<E>,
	com.aoindustries.html.any.attributes.Text.Type<E>,
	com.aoindustries.html.any.attributes.Text.Name<E>,
	com.aoindustries.html.any.attributes.Text.Form<E>,
	com.aoindustries.html.any.attributes.Integer.Width<E>,
	com.aoindustries.html.any.attributes.Integer.Height<E>,
	// Global Event Attributes: https://www.w3schools.com/tags/ref_eventattributes.asp
	AlmostGlobalAttributes<E>
{

	protected AnyOBJECT(D document, PC pc) {
		super(document, pc);
	}

	@Override
	protected E writeOpen(Writer out) throws IOException {
		document.autoIndent(out).unsafe(out, "<object", false);
		@SuppressWarnings("unchecked") E element = (E)this;
		return element;
	}

	@Override
	protected void writeClose(Writer out, boolean closeAttributes) throws IOException {
		document.autoIndent(out).unsafe(out, closeAttributes ? "></object>" : "</object>", false);
	}
}
