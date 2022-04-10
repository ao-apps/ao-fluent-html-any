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

/**
 * A transparent element that can have textual content.
 * <p>
 * See <a href="https://html.spec.whatwg.org/multipage/dom.html#transparent-content-models">3.2.5.3 Transparent content models</a>.
 * </p>
 *
 * @param  <D>   This document type
 * @param  <PC>  The parent content model this element is within,
 *               which may also be the parent content model of child elements
 * @param  <E>   This element type
 * @param  <_c>  This content model as {@link Closeable}, which will be the parent content model of child elements
 *
 * @author  AO Industries, Inc.
 */
public abstract class TransparentText<
	D  extends AnyDocument<D>,
	PC extends Content<D, PC>,
	E  extends TransparentText<D, PC, E, _c>,
	// Would prefer "_c extends PC & Closeable<D, PC>", but "a type variable may not be followed by other bounds"
	_c extends TransparentText_c<D, PC, _c>
> extends Transparent<D, PC, E, _c> {

	protected TransparentText(D document, PC pc) {
		super(document, pc);
	}

	/**
	 * Ends attributes, writes a text body, then closes this element.
	 *
	 * @return  The parent content model this element is within
	 *
	 * @see  AnyDocument#text(java.lang.Object)
	 */
	// Matches NormalText.__(Object)
	// TODO: More overrides, such as IOSupplier and such?
	public PC __(Object text) throws IOException {
		@SuppressWarnings("deprecation")
		Writer unsafe = document.getRawUnsafe(null);
		if(text != null) {
			document.autoIndent(unsafe).unsafe(unsafe, '>').incDepth();
			doBeforeBody(unsafe);
			document.text(unsafe, text).decDepth();
			writeClose(unsafe, false);
		} else {
			writeClose(unsafe, true);
		}
		return pc;
	}
}
