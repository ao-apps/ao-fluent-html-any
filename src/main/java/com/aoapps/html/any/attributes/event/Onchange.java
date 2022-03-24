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
 * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-onchange">3.2.6 Global attributes / onchange</a>.</li>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-onchange">8.1.7.2 Event handlers on elements, Document objects, and Window objects / onchange</a>.</li>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-onchange">8.1.7.2.1 IDL definitions / onchange</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/onchange">GlobalEventHandlers.onchange</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/change_event">HTMLElement: change event</a>.</li>
 * <li>See <a href="https://www.w3schools.com/jsref/event_onchange.asp">onchange Event</a>.</li>
 * </ul>
 *
 * @param  <E>   This element type
 *
 * @author  AO Industries, Inc.
 */
// Matches OnchangeUnexpected
@SuppressWarnings("deprecation")
public interface Onchange<E extends Element<?, ?, E> & Onchange<E>> extends OnchangeUnexpected<E> {

	/**
	 * <ul>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-onchange">3.2.6 Global attributes / onchange</a>.</li>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-onchange">8.1.7.2 Event handlers on elements, Document objects, and Window objects / onchange</a>.</li>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-onchange">8.1.7.2.1 IDL definitions / onchange</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/onchange">GlobalEventHandlers.onchange</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/change_event">HTMLElement: change event</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/jsref/event_onchange.asp">onchange Event</a>.</li>
	 * </ul>
	 */
	@Override
	@Attributes.Funnel
	default E onchange(Object onchange) throws IOException {
		// Not calling super: overridden to support HTML 4
		@SuppressWarnings("unchecked") E element = (E)this;
		return Attributes.Event.attribute(element, "onchange", onchange);
	}

	/**
	 * <ul>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-onchange">3.2.6 Global attributes / onchange</a>.</li>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-onchange">8.1.7.2 Event handlers on elements, Document objects, and Window objects / onchange</a>.</li>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-onchange">8.1.7.2.1 IDL definitions / onchange</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/onchange">GlobalEventHandlers.onchange</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/change_event">HTMLElement: change event</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/jsref/event_onchange.asp">onchange Event</a>.</li>
	 * </ul>
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 *
	 * @see #onchange(java.lang.Object)
	 */
	@Override
	default <Ex extends Throwable> E onchange(IOSupplierE<?, Ex> onchange) throws IOException, Ex {
		return OnchangeUnexpected.super.onchange(onchange);
	}

	/**
	 * <ul>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-onchange">3.2.6 Global attributes / onchange</a>.</li>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-onchange">8.1.7.2 Event handlers on elements, Document objects, and Window objects / onchange</a>.</li>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-onchange">8.1.7.2.1 IDL definitions / onchange</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/onchange">GlobalEventHandlers.onchange</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/change_event">HTMLElement: change event</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/jsref/event_onchange.asp">onchange Event</a>.</li>
	 * </ul>
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 *
	 * @see #onchange(java.lang.Object)
	 */
	@Override
	default <Ex extends Throwable> E onchange(MediaWritable<Ex> onchange) throws IOException, Ex {
		return OnchangeUnexpected.super.onchange(onchange);
	}
}
