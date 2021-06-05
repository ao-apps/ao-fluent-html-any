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
 * <ul>
 * <li>See <a href="https://www.w3schools.com/tags/att_http-equiv.asp">HTML http-equiv Attribute</a>.</li>
 * <li>See <a href="https://www.w3schools.com/tags/att_meta_http_equiv.asp">HTML meta http-equiv Attribute</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/meta#attr-http-equiv">&lt;meta&gt;: The Document-level Metadata element</a>.</li>
 * </ul>
 *
 * @param  <E>   This element type
 * @param  <V>   This enum type to use for this attribute
 *
 * @author  AO Industries, Inc.
 */
public interface HttpEquiv<
	E extends Element<?, ?, E> & HttpEquiv<E, V>,
	V extends Enum<V> & Function<AnyDocument<?>, String>
> {

	/**
	 * <ul>
	 * <li>See <a href="https://www.w3schools.com/tags/att_http-equiv.asp">HTML http-equiv Attribute</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/tags/att_meta_http_equiv.asp">HTML meta http-equiv Attribute</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/meta#attr-http-equiv">&lt;meta&gt;: The Document-level Metadata element</a>.</li>
	 * </ul>
	 */
	@Attributes.Funnel
	default E httpEquiv(String httpEquiv) throws IOException {
		@SuppressWarnings("unchecked") E element = (E)this;
		return Attributes.String.attribute(element, "http-equiv", MarkupType.NONE, httpEquiv, true, false);
	}

	/**
	 * <ul>
	 * <li>See <a href="https://www.w3schools.com/tags/att_http-equiv.asp">HTML http-equiv Attribute</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/tags/att_meta_http_equiv.asp">HTML meta http-equiv Attribute</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/meta#attr-http-equiv">&lt;meta&gt;: The Document-level Metadata element</a>.</li>
	 * </ul>
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 */
	@SuppressWarnings("overloads")
	default <Ex extends Throwable> E httpEquiv(Suppliers.String<Ex> httpEquiv) throws IOException, Ex {
		return httpEquiv((httpEquiv == null) ? null : httpEquiv.get());
	}

	/**
	 * <ul>
	 * <li>See <a href="https://www.w3schools.com/tags/att_http-equiv.asp">HTML http-equiv Attribute</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/tags/att_meta_http_equiv.asp">HTML meta http-equiv Attribute</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/meta#attr-http-equiv">&lt;meta&gt;: The Document-level Metadata element</a>.</li>
	 * </ul>
	 */
	default E httpEquiv(V httpEquiv) throws IOException {
		@SuppressWarnings("unchecked") E element = (E)this;
		return httpEquiv((httpEquiv == null) ? null : httpEquiv.apply(element.getDocument()));
	}

	/**
	 * <ul>
	 * <li>See <a href="https://www.w3schools.com/tags/att_http-equiv.asp">HTML http-equiv Attribute</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/tags/att_meta_http_equiv.asp">HTML meta http-equiv Attribute</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/meta#attr-http-equiv">&lt;meta&gt;: The Document-level Metadata element</a>.</li>
	 * </ul>
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 */
	@SuppressWarnings("overloads")
	default <Ex extends Throwable> E httpEquiv(IOSupplierE<? extends V, Ex> httpEquiv) throws IOException, Ex {
		return httpEquiv((httpEquiv== null) ? (V)null : httpEquiv.get());
	}
}
