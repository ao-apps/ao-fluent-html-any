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

package com.aoapps.html.any.attributes.Integer;

import com.aoapps.html.any.Attributes;
import com.aoapps.html.any.Element;
import com.aoapps.lang.io.function.IOSupplierE;
import java.io.IOException;

/**
 * See <a href="https://html.spec.whatwg.org/multipage/tables.html#attr-tdth-rowspan">4.9.11 Attributes common to td and th elements / rowspan</a>.
 *
 * @param  <E>   This element type
 *
 * @author  AO Industries, Inc.
 */
public interface Rowspan<E extends Element<?, ?, E> & Rowspan<E>> {

	/**
	 * See <a href="https://html.spec.whatwg.org/multipage/tables.html#attr-tdth-rowspan">4.9.11 Attributes common to td and th elements / rowspan</a>.
	 *
	 * @param  rowspan  Will not write the attribute when is {@code 1}.
	 */
	@Attributes.Funnel
	default E rowspan(int rowspan) throws IOException {
		@SuppressWarnings("unchecked") E element = (E)this;
		if(rowspan != 1) Attributes.Integer.attribute(element, "rowspan", rowspan);
		return element;
	}

	/**
	 * See <a href="https://html.spec.whatwg.org/multipage/tables.html#attr-tdth-rowspan">4.9.11 Attributes common to td and th elements / rowspan</a>.
	 *
	 * @param  rowspan  Will not write the attribute when is {@code null} or {@code 1}.
	 */
	@Attributes.Funnel
	default E rowspan(Integer rowspan) throws IOException {
		@SuppressWarnings("unchecked") E element = (E)this;
		if(rowspan != null && rowspan != 1) Attributes.Integer.attribute(element, "rowspan", rowspan);
		return element;
	}

	/**
	 * See <a href="https://html.spec.whatwg.org/multipage/tables.html#attr-tdth-rowspan">4.9.11 Attributes common to td and th elements / rowspan</a>.
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 * @param  rowspan  Will not write the attribute when is {@code null} or {@code 1}.
	 *
	 * @see #rowspan(java.lang.Integer)
	 */
	default <Ex extends Throwable> E rowspan(IOSupplierE<? extends Integer, Ex> rowspan) throws IOException, Ex {
		return rowspan((rowspan == null) ? null : rowspan.get());
	}
}
