/*
 * ao-fluent-html-any - Base abstract classes and interfaces for Fluent Java DSL for high-performance HTML generation.
 * Copyright (C) 2022  AO Industries, Inc.
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
 * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-onstalled">3.2.6 Global attributes / onstalled</a>.</li>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-onstalled">8.1.7.2 Event handlers on elements, Document objects, and Window objects / onstalled</a>.</li>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-onstalled">8.1.7.2.1 IDL definitions / onstalled</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/onstalled">GlobalEventHandlers.onstalled</a>.</li>
 * <li>See <a href="https://www.w3schools.com/jsref/event_onstalled.asp">onstalled Event</a>.</li>
 * </ul>
 *
 * @param  <E>   This element type
 *
 * @since HTML 5
 *
 * @author  AO Industries, Inc.
 */
// Matches OnstalledUnexpected
@SuppressWarnings("deprecation")
public interface Onstalled<E extends Element<?, ?, E> & Onstalled<E>> extends OnstalledUnexpected<E> {

	/**
	 * <ul>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-onstalled">3.2.6 Global attributes / onstalled</a>.</li>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-onstalled">8.1.7.2 Event handlers on elements, Document objects, and Window objects / onstalled</a>.</li>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-onstalled">8.1.7.2.1 IDL definitions / onstalled</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/onstalled">GlobalEventHandlers.onstalled</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/jsref/event_onstalled.asp">onstalled Event</a>.</li>
	 * </ul>
	 *
	 * @since HTML 5
	 */
	@Override
	@Attributes.Funnel
	default E onstalled(Object onstalled) throws IOException {
		return OnstalledUnexpected.super.onstalled(onstalled);
	}

	/**
	 * <ul>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-onstalled">3.2.6 Global attributes / onstalled</a>.</li>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-onstalled">8.1.7.2 Event handlers on elements, Document objects, and Window objects / onstalled</a>.</li>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-onstalled">8.1.7.2.1 IDL definitions / onstalled</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/onstalled">GlobalEventHandlers.onstalled</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/jsref/event_onstalled.asp">onstalled Event</a>.</li>
	 * </ul>
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 *
	 * @since HTML 5
	 *
	 * @see #onstalled(java.lang.Object)
	 */
	@Override
	default <Ex extends Throwable> E onstalled(IOSupplierE<?, Ex> onstalled) throws IOException, Ex {
		return OnstalledUnexpected.super.onstalled(onstalled);
	}

	/**
	 * <ul>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-onstalled">3.2.6 Global attributes / onstalled</a>.</li>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-onstalled">8.1.7.2 Event handlers on elements, Document objects, and Window objects / onstalled</a>.</li>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-onstalled">8.1.7.2.1 IDL definitions / onstalled</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/onstalled">GlobalEventHandlers.onstalled</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/jsref/event_onstalled.asp">onstalled Event</a>.</li>
	 * </ul>
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 *
	 * @since HTML 5
	 *
	 * @see #onstalled(java.lang.Object)
	 */
	@Override
	default <Ex extends Throwable> E onstalled(MediaWritable<Ex> onstalled) throws IOException, Ex {
		return OnstalledUnexpected.super.onstalled(onstalled);
	}
}
