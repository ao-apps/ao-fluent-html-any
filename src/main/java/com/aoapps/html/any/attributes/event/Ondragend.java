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
package com.aoapps.html.any.attributes.event;

import com.aoapps.encoding.MediaWritable;
import com.aoapps.html.any.Attributes;
import com.aoapps.html.any.Element;
import com.aoapps.lang.io.function.IOSupplierE;
import java.io.IOException;

/**
 * <ul>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-ondragend">3.2.6 Global attributes / ondragend</a>.</li>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-ondragend">8.1.7.2 Event handlers on elements, Document objects, and Window objects / ondragend</a>.</li>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-ondragend">8.1.7.2.1 IDL definitions / ondragend</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/ondragend">GlobalEventHandlers.ondragend</a>.</li>
 * <li>See <a href="https://www.w3schools.com/jsref/event_ondragend.asp">ondragend Event</a>.</li>
 * </ul>
 *
 * @param  <E>   This element type
 *
 * @since HTML 5
 *
 * @author  AO Industries, Inc.
 */
// Matches OndragendUnexpected
public interface Ondragend<E extends Element<?, ?, E> & Ondragend<E>> {

	/**
	 * <ul>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-ondragend">3.2.6 Global attributes / ondragend</a>.</li>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-ondragend">8.1.7.2 Event handlers on elements, Document objects, and Window objects / ondragend</a>.</li>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-ondragend">8.1.7.2.1 IDL definitions / ondragend</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/ondragend">GlobalEventHandlers.ondragend</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/jsref/event_ondragend.asp">ondragend Event</a>.</li>
	 * </ul>
	 *
	 * @since HTML 5
	 */
	@Attributes.Funnel
	default E ondragend(Object ondragend) throws IOException {
		@SuppressWarnings("unchecked") E element = (E)this;
		Attributes.onlySupportedInHtml5(element, "ondragend");
		return Attributes.Event.attribute(element, "ondragend", ondragend);
	}

	/**
	 * <ul>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-ondragend">3.2.6 Global attributes / ondragend</a>.</li>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-ondragend">8.1.7.2 Event handlers on elements, Document objects, and Window objects / ondragend</a>.</li>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-ondragend">8.1.7.2.1 IDL definitions / ondragend</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/ondragend">GlobalEventHandlers.ondragend</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/jsref/event_ondragend.asp">ondragend Event</a>.</li>
	 * </ul>
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 *
	 * @since HTML 5
	 *
	 * @see #ondragend(java.lang.Object)
	 */
	default <Ex extends Throwable> E ondragend(IOSupplierE<?, Ex> ondragend) throws IOException, Ex {
		return ondragend((ondragend == null) ? null : ondragend.get());
	}

	/**
	 * <ul>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-ondragend">3.2.6 Global attributes / ondragend</a>.</li>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-ondragend">8.1.7.2 Event handlers on elements, Document objects, and Window objects / ondragend</a>.</li>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-ondragend">8.1.7.2.1 IDL definitions / ondragend</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/ondragend">GlobalEventHandlers.ondragend</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/jsref/event_ondragend.asp">ondragend Event</a>.</li>
	 * </ul>
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 *
	 * @since HTML 5
	 *
	 * @see #ondragend(java.lang.Object)
	 */
	default <Ex extends Throwable> E ondragend(MediaWritable<Ex> ondragend) throws IOException, Ex {
		return ondragend((Object)ondragend);
	}
}
