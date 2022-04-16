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

package com.aoapps.html.any.attributes.Boolean;

import com.aoapps.html.any.Attributes;
import com.aoapps.html.any.Element;
import com.aoapps.lang.io.function.IOSupplierE;
import java.io.IOException;

/**
 * See <a href="https://www.w3schools.com/tags/att_hr_noshade.asp">HTML hr noshade Attribute</a>.
 *
 * @deprecated  The noshade attribute of <code>&lt;hr&gt;</code> is not supported in HTML5. Use CSS instead.
 *
 * @param  <E>   This element type
 *
 * @author  AO Industries, Inc.
 */
@Deprecated
public interface Noshade<E extends Element<?, ?, E> & Noshade<E>> {

	/**
	 * See <a href="https://www.w3schools.com/tags/att_hr_noshade.asp">HTML hr noshade Attribute</a>.
	 *
	 * @deprecated  The noshade attribute of <code>&lt;hr&gt;</code> is not supported in HTML5. Use CSS instead.
	 */
	@Deprecated
	@Attributes.Funnel
	default E noshade(boolean noshade) throws IOException {
		@SuppressWarnings("unchecked") E element = (E)this;
		return Attributes.Boolean.attribute(element, "noshade", noshade);
	}

	/**
	 * See <a href="https://www.w3schools.com/tags/att_hr_noshade.asp">HTML hr noshade Attribute</a>.
	 *
	 * @see #noshade(boolean)
	 *
	 * @deprecated  The noshade attribute of <code>&lt;hr&gt;</code> is not supported in HTML5. Use CSS instead.
	 */
	@Deprecated
	default E noshade(Boolean noshade) throws IOException {
		return noshade(noshade != null && noshade);
	}

	/**
	 * See <a href="https://www.w3schools.com/tags/att_hr_noshade.asp">HTML hr noshade Attribute</a>.
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 *
	 * @see #noshade(java.lang.Boolean)
	 *
	 * @deprecated  The noshade attribute of <code>&lt;hr&gt;</code> is not supported in HTML5. Use CSS instead.
	 */
	@Deprecated
	default <Ex extends Throwable> E noshade(IOSupplierE<? extends Boolean, Ex> noshade) throws IOException, Ex {
		return noshade((noshade == null) ? null : noshade.get());
	}
}
