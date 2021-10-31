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
package com.aoapps.html.any.attributes.event.mouse;

import com.aoapps.encoding.MediaWritable;
import com.aoapps.html.any.Attributes;
import com.aoapps.html.any.Element;
import com.aoapps.lang.io.function.IOSupplierE;
import java.io.IOException;

/**
 * See <a href="https://www.w3schools.com/tags/ev_onmouseout.asp">HTML onmouseout Event Attribute</a>.
 *
 * @param  <E>   This element type
 *
 * @author  AO Industries, Inc.
 */
public interface Onmouseout<E extends Element<?, ?, E> & Onmouseout<E>> {

	/**
	 * See <a href="https://www.w3schools.com/tags/ev_onmouseout.asp">HTML onmouseout Event Attribute</a>.
	 */
	@Attributes.Funnel
	default E onmouseout(Object onmouseout) throws IOException {
		@SuppressWarnings("unchecked") E element = (E)this;
		return Attributes.Event.attribute(element, "onmouseout", onmouseout);
	}

	/**
	 * See <a href="https://www.w3schools.com/tags/ev_onmouseout.asp">HTML onmouseout Event Attribute</a>.
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 *
	 * @see #onmouseout(java.lang.Object)
	 */
	default <Ex extends Throwable> E onmouseout(IOSupplierE<?, Ex> onmouseout) throws IOException, Ex {
		return onmouseout((onmouseout == null) ? null : onmouseout.get());
	}

	/**
	 * See <a href="https://www.w3schools.com/tags/ev_onmouseout.asp">HTML onmouseout Event Attribute</a>.
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 *
	 * @see #onmouseout(java.lang.Object)
	 */
	default <Ex extends Throwable> E onmouseout(MediaWritable<Ex> onmouseout) throws IOException, Ex {
		return onmouseout((Object)onmouseout);
	}
}
