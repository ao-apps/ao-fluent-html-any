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
 * along with ao-fluent-html-any.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.aoapps.html.any.attributes.Enum;

import com.aoapps.hodgepodge.i18n.MarkupType;
import com.aoapps.html.any.AnyDocument;
import com.aoapps.html.any.Attributes;
import com.aoapps.html.any.Element;
import com.aoapps.html.any.Suppliers;
import com.aoapps.lang.io.function.IOSupplierE;
import java.io.IOException;
import java.util.function.Function;

/**
 * See <a href="https://www.w3schools.com/tags/att_type.asp">HTML type Attribute</a>.
 *
 * @param  <E>   This element type
 * @param  <V>   This enum type to use for this attribute
 *
 * @author  AO Industries, Inc.
 */
public interface Type<
	E extends Element<?, ?, E> & Type<E, V>,
	V extends Enum<V> & Function<AnyDocument<?>, String>
> {

	/**
	 * See <a href="https://www.w3schools.com/tags/att_type.asp">HTML type Attribute</a>.
	 */
	@Attributes.Funnel
	default E type(String type) throws IOException {
		@SuppressWarnings("unchecked") E element = (E)this;
		return Attributes.String.attribute(element, "type", MarkupType.NONE, type, true, true);
	}

	/**
	 * See <a href="https://www.w3schools.com/tags/att_type.asp">HTML type Attribute</a>.
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 *
	 * @see #type(java.lang.String)
	 */
	@SuppressWarnings("overloads")
	default <Ex extends Throwable> E type(Suppliers.String<Ex> type) throws IOException, Ex {
		return type((type == null) ? null : type.get());
	}

	/**
	 * See <a href="https://www.w3schools.com/tags/att_type.asp">HTML type Attribute</a>.
	 *
	 * @see #type(java.lang.String)
	 */
	default E type(V type) throws IOException {
		@SuppressWarnings("unchecked") E element = (E)this;
		return type((type == null) ? null : type.apply(element.getDocument()));
	}

	/**
	 * See <a href="https://www.w3schools.com/tags/att_type.asp">HTML type Attribute</a>.
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 *
	 * @see #type(java.lang.Enum)
	 */
	@SuppressWarnings("overloads")
	default <Ex extends Throwable> E type(IOSupplierE<? extends V, Ex> type) throws IOException, Ex {
		return type((type== null) ? (V)null : type.get());
	}
}
