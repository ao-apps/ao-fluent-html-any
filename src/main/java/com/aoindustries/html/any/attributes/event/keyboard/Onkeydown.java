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
package com.aoindustries.html.any.attributes.event.keyboard;

import com.aoindustries.encoding.MediaWritable;
import com.aoindustries.html.any.Attributes;
import com.aoindustries.html.any.Element;
import com.aoindustries.io.function.IOSupplierE;
import java.io.IOException;

/**
 * See <a href="https://www.w3schools.com/tags/ev_onkeydown.asp">HTML onkeydown Event Attribute</a>.
 *
 * @param  <E>   This element type
 *
 * @author  AO Industries, Inc.
 */
public interface Onkeydown<E extends Element<?, ?, E> & Onkeydown<E>> {

	/**
	 * See <a href="https://www.w3schools.com/tags/ev_onkeydown.asp">HTML onkeydown Event Attribute</a>.
	 */
	@Attributes.Funnel
	default E onkeydown(Object onkeydown) throws IOException {
		@SuppressWarnings("unchecked") E element = (E)this;
		return Attributes.Event.attribute(element, "onkeydown", onkeydown);
	}

	/**
	 * See <a href="https://www.w3schools.com/tags/ev_onkeydown.asp">HTML onkeydown Event Attribute</a>.
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 *
	 * @see #onkeydown(java.lang.Object)
	 */
	default <Ex extends Throwable> E onkeydown(IOSupplierE<?, Ex> onkeydown) throws IOException, Ex {
		return onkeydown((onkeydown == null) ? null : onkeydown.get());
	}

	/**
	 * See <a href="https://www.w3schools.com/tags/ev_onkeydown.asp">HTML onkeydown Event Attribute</a>.
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 *
	 * @see #onkeydown(java.lang.Object)
	 */
	default <Ex extends Throwable> E onkeydown(MediaWritable<Ex> onkeydown) throws IOException, Ex {
		return onkeydown((Object)onkeydown);
	}
}
