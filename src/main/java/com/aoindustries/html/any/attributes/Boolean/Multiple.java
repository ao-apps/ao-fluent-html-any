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
 * along with ao-fluent-html-any.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.aoindustries.html.any.attributes.Boolean;

import com.aoindustries.encoding.Doctype;
import com.aoindustries.html.any.Attributes;
import static com.aoindustries.html.any.Attributes.RESOURCES;
import com.aoindustries.html.any.Element;
import com.aoindustries.io.function.IOSupplierE;
import com.aoindustries.lang.LocalizedIllegalArgumentException;
import java.io.IOException;

/**
 * See <a href="https://www.w3schools.com/tags/att_multiple.asp">HTML multiple Attribute</a>.
 *
 * @param  <E>   This element type
 *
 * @author  AO Industries, Inc.
 */
public interface Multiple<E extends Element<?, ?, E> & Multiple<E>> {

	/**
	 * See <a href="https://www.w3schools.com/tags/att_multiple.asp">HTML multiple Attribute</a>.
	 */
	@Attributes.Funnel
	default E multiple(boolean multiple) throws IOException {
		@SuppressWarnings("unchecked") E element = (E)this;
		if(element.getDocument().doctype != Doctype.HTML5) {
			throw new LocalizedIllegalArgumentException(
				RESOURCES,
				"onlySupportedInHtml5",
				element.getDocument().doctype,
				"multiple"
			);
		}
		return Attributes.Boolean.attribute(element, "multiple", multiple);
	}

	/**
	 * See <a href="https://www.w3schools.com/tags/att_multiple.asp">HTML multiple Attribute</a>.
	 *
	 * @see #multiple(boolean)
	 */
	default E multiple(Boolean multiple) throws IOException {
		return multiple(multiple != null && multiple);
	}

	/**
	 * See <a href="https://www.w3schools.com/tags/att_multiple.asp">HTML multiple Attribute</a>.
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 *
	 * @see #multiple(java.lang.Boolean)
	 */
	default <Ex extends Throwable> E multiple(IOSupplierE<? extends Boolean, Ex> multiple) throws IOException, Ex {
		return multiple((multiple == null) ? null : multiple.get());
	}
}
