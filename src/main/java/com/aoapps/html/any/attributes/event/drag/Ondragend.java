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
package com.aoapps.html.any.attributes.event.drag;

import com.aoapps.encoding.Doctype;
import com.aoapps.encoding.MediaWritable;
import com.aoapps.html.any.Attributes;
import static com.aoapps.html.any.Attributes.RESOURCES;
import com.aoapps.html.any.Element;
import com.aoapps.lang.LocalizedIllegalArgumentException;
import com.aoapps.lang.io.function.IOSupplierE;
import java.io.IOException;

/**
 * See <a href="https://www.w3schools.com/tags/ev_ondragend.asp">HTML ondragend Event Attribute</a>.
 *
 * @param  <E>   This element type
 *
 * @author  AO Industries, Inc.
 */
public interface Ondragend<E extends Element<?, ?, E> & Ondragend<E>> {

	/**
	 * See <a href="https://www.w3schools.com/tags/ev_ondragend.asp">HTML ondragend Event Attribute</a>.
	 */
	@Attributes.Funnel
	default E ondragend(Object ondragend) throws IOException {
		@SuppressWarnings("unchecked") E element = (E)this;
		if(element.getDocument().doctype != Doctype.HTML5) {
			throw new LocalizedIllegalArgumentException(
				RESOURCES,
				"onlySupportedInHtml5",
				element.getDocument().doctype,
				"ondragend"
			);
		}
		return Attributes.Event.attribute(element, "ondragend", ondragend);
	}

	/**
	 * See <a href="https://www.w3schools.com/tags/ev_ondragend.asp">HTML ondragend Event Attribute</a>.
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 *
	 * @see #ondragend(java.lang.Object)
	 */
	default <Ex extends Throwable> E ondragend(IOSupplierE<?, Ex> ondragend) throws IOException, Ex {
		return ondragend((ondragend == null) ? null : ondragend.get());
	}

	/**
	 * See <a href="https://www.w3schools.com/tags/ev_ondragend.asp">HTML ondragend Event Attribute</a>.
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 *
	 * @see #ondragend(java.lang.Object)
	 */
	default <Ex extends Throwable> E ondragend(MediaWritable<Ex> ondragend) throws IOException, Ex {
		return ondragend((Object)ondragend);
	}
}
