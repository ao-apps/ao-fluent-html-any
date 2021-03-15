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
package com.aoindustries.html.any.attributes.Dimension;

import com.aoindustries.html.any.Attributes;
import com.aoindustries.html.any.Element;
import com.aoindustries.html.any.Suppliers;
import com.aoindustries.io.function.IOSupplierE;
import java.io.IOException;

/**
 * See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/table#attr-cellspacing">&lt;table&gt;: The Table element / cellspacing</a>.
 *
 * @param  <E>   This element type
 *
 * @deprecated  The cellspacing attribute is not supported in HTML5. Use CSS instead.
 *
 * @author  AO Industries, Inc.
 */
@Deprecated
public interface Cellspacing<E extends Element<?, ?, E> & Cellspacing<E>> {

	/**
	 * See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/table#attr-cellspacing">&lt;table&gt;: The Table element / cellspacing</a>.
	 *
	 * @deprecated  The cellspacing attribute is not supported in HTML5. Use CSS instead.
	 */
	@Deprecated
	@Attributes.Funnel
	default E cellspacing(int pixels) throws IOException {
		@SuppressWarnings("unchecked") E element = (E)this;
		return Attributes.Dimension.attribute(element, "cellspacing", pixels);
	}

	/**
	 * See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/table#attr-cellspacing">&lt;table&gt;: The Table element / cellspacing</a>.
	 *
	 * @deprecated  The cellspacing attribute is not supported in HTML5. Use CSS instead.
	 */
	@Deprecated
	@Attributes.Funnel
	default E cellspacing(Integer pixels) throws IOException {
		@SuppressWarnings("unchecked") E element = (E)this;
		return Attributes.Dimension.attribute(element, "cellspacing", pixels);
	}

	/**
	 * See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/table#attr-cellspacing">&lt;table&gt;: The Table element / cellspacing</a>.
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 *
	 * @deprecated  The cellspacing attribute is not supported in HTML5. Use CSS instead.
	 */
	@Deprecated
	@SuppressWarnings("overloads")
	default <Ex extends Throwable> E cellspacing(IOSupplierE<? extends Integer, Ex> pixels) throws IOException, Ex {
		return cellspacing((pixels == null) ? null : pixels.get());
	}

	/**
	 * See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/table#attr-cellspacing">&lt;table&gt;: The Table element / cellspacing</a>.
	 *
	 * @deprecated  The cellspacing attribute is not supported in HTML5. Use CSS instead.
	 */
	@Deprecated
	@Attributes.Funnel
	default E cellspacing(String pixelsOrPercent) throws IOException {
		@SuppressWarnings("unchecked") E element = (E)this;
		return Attributes.Dimension.attribute(element, "cellspacing", pixelsOrPercent);
	}

	/**
	 * See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/table#attr-cellspacing">&lt;table&gt;: The Table element / cellspacing</a>.
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 *
	 * @see #cellspacing(java.lang.String)
	 *
	 * @deprecated  The cellspacing attribute is not supported in HTML5. Use CSS instead.
	 */
	@Deprecated
	@SuppressWarnings("overloads")
	default <Ex extends Throwable> E cellspacing(Suppliers.String<Ex> pixelsOrPercent) throws IOException, Ex {
		return cellspacing((pixelsOrPercent == null) ? null : pixelsOrPercent.get());
	}
}
