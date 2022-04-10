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
 * <li>See <a href="https://html.spec.whatwg.org/multipage/tables.html#the-table-element">4.9.1 The table element</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/table">&lt;table&gt;: The Table element</a>.</li>
 * <li>See <a href="https://www.w3schools.com/tags/tag_table.asp">HTML table tag</a>.</li>
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
@SuppressWarnings("deprecation")
public abstract class AnyTABLE<
	D  extends AnyDocument<D>,
	PC extends AnyPalpableContent<D, PC>,
	E  extends AnyTABLE<D, PC, E, __, _c>,
	__ extends AnyTABLE__<D, PC, __>,
	// Would prefer "_c extends __ & Closeable<D, PC>", but "a type variable may not be followed by other bounds"
	_c extends AnyTABLE_c<D, PC, _c>
> extends Normal<D, PC, E, __, _c> implements
	com.aoapps.html.any.attributes.Enum.Align<E, AnyTABLE.Align>,
	// TODO: bgcolor (deprecated)
	com.aoapps.html.any.attributes.Integer.Border<E>,
	com.aoapps.html.any.attributes.Dimension.Cellpadding<E>,
	com.aoapps.html.any.attributes.Dimension.Cellspacing<E>,
	// TODO: frame (deprecated)
	// TODO: rules (deprecated)
	// TODO: summary (deprecated)
	com.aoapps.html.any.attributes.Dimension.WidthHtml4Only<E>
{

	protected AnyTABLE(D document, PC pc) {
		super(document, pc);
	}

	@Override
	protected E writeOpen(Writer unsafe) throws IOException {
		document.autoNli(unsafe).unsafe(unsafe, "<table", false);
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
			document.autoIndent(unsafe).unsafe(unsafe, "></table>", false);
		} else {
			document.autoNli(unsafe).unsafe(unsafe, "</table>", false);
		}
		document.autoNl(unsafe);
	}

	/**
	 * See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/table#attr-align">&lt;table&gt;: The Table element / align</a>.
	 *
	 * @deprecated  The align attribute of &lt;table&gt; is not supported in HTML5. Use CSS instead.
	 */
	@Deprecated
	public enum Align implements Function<AnyDocument<?>, String> {

		/**
		 * the table is displayed on the left side of the document
		 */
		LEFT("left"),

		/**
		 * the table is displayed in the center of the document
		 */
		CENTER("center"),

		/**
		 * the table is displayed on the right side of the document
		 */
		RIGHT("right");

		private final String value;

		private Align(String value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return value;
		}

		@Override
		public String apply(AnyDocument<?> document) {
			return value;
		}
	}
}
