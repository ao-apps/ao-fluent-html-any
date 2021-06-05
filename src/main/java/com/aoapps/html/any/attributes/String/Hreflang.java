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
package com.aoapps.html.any.attributes.String;

import com.aoapps.hodgepodge.i18n.MarkupType;
import com.aoapps.html.any.Attributes;
import com.aoapps.html.any.Element;
import com.aoapps.html.any.Suppliers;
import com.aoapps.lang.io.function.IOSupplierE;
import java.io.IOException;
import java.util.Locale;

/**
 * See <a href="https://www.w3schools.com/tags/att_hreflang.asp">HTML hreflang Attribute</a>.
 *
 * @param  <E>   This element type
 *
 * @author  AO Industries, Inc.
 */
public interface Hreflang<E extends Element<?, ?, E> & Hreflang<E>> {

	/**
	 * See <a href="https://www.w3schools.com/tags/att_hreflang.asp">HTML hreflang Attribute</a>.
	 */
	@Attributes.Funnel
	default E hreflang(String hreflang) throws IOException {
		@SuppressWarnings("unchecked") E element = (E)this;
		return Attributes.String.attribute(element, "hreflang", MarkupType.NONE, hreflang, true, true);
	}

	/**
	 * See <a href="https://www.w3schools.com/tags/att_hreflang.asp">HTML hreflang Attribute</a>.
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 *
	 * @see #hreflang(java.lang.String)
	 */
	@SuppressWarnings("overloads")
	default <Ex extends Throwable> E hreflang(IOSupplierE<? extends String, Ex> hreflang) throws IOException, Ex {
		return hreflang((hreflang == null) ? null : hreflang.get());
	}

	/**
	 * See <a href="https://www.w3schools.com/tags/att_hreflang.asp">HTML hreflang Attribute</a>.
	 *
	 * @see #hreflang(java.lang.String)
	 */
	default E hreflang(Locale hreflang) throws IOException {
		return hreflang((hreflang == null) ? null : hreflang.toLanguageTag());
	}

	/**
	 * See <a href="https://www.w3schools.com/tags/att_hreflang.asp">HTML hreflang Attribute</a>.
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 *
	 * @see #hreflang(java.util.Locale)
	 */
	@SuppressWarnings("overloads")
	default <Ex extends Throwable> E hreflang(Suppliers.Locale<Ex> hreflang) throws IOException, Ex {
		return hreflang((hreflang == null) ? null : hreflang.get());
	}
}
