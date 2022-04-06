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

import com.aoapps.encoding.JavaScriptWritable;
import com.aoapps.html.any.AnyAUDIO;
import com.aoapps.html.any.AnyVIDEO;
import com.aoapps.html.any.Attributes;
import com.aoapps.html.any.Element;
import com.aoapps.lang.io.function.IOSupplierE;
import java.io.IOException;

/**
 * <ul>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-onloadedmetadata">3.2.6 Global attributes / onloadedmetadata</a>.</li>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-onloadedmetadata">8.1.7.2 Event handlers on elements, Document objects, and Window objects / onloadedmetadata</a>.</li>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-onloadedmetadata">8.1.7.2.1 IDL definitions / onloadedmetadata</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/onloadedmetadata">GlobalEventHandlers.onloadedmetadata</a>.</li>
 * <li>See <a href="https://www.w3schools.com/jsref/event_onloadedmetadata.asp">onloadedmetadata Event</a>.</li>
 * </ul>
 *
 * @param  <E>   This element type
 *
 * @since HTML 5
 *
 * @deprecated  Although the onloadedmetadata attribute is global, it is only expected on
 *              {@linkplain AnyAUDIO &lt;audio&gt;} and {@linkplain AnyVIDEO &lt;video&gt;}.
 *
 * @author  AO Industries, Inc.
 */
// Matches Onloadedmetadata
@Deprecated
public interface OnloadedmetadataUnexpected<E extends Element<?, ?, E> & OnloadedmetadataUnexpected<E>> {

	/**
	 * <ul>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-onloadedmetadata">3.2.6 Global attributes / onloadedmetadata</a>.</li>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-onloadedmetadata">8.1.7.2 Event handlers on elements, Document objects, and Window objects / onloadedmetadata</a>.</li>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-onloadedmetadata">8.1.7.2.1 IDL definitions / onloadedmetadata</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/onloadedmetadata">GlobalEventHandlers.onloadedmetadata</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/jsref/event_onloadedmetadata.asp">onloadedmetadata Event</a>.</li>
	 * </ul>
	 *
	 * @since HTML 5
	 *
	 * @deprecated  Although the onloadedmetadata attribute is global, it is only expected on
	 *              {@linkplain AnyAUDIO &lt;audio&gt;} and {@linkplain AnyVIDEO &lt;video&gt;}.
	 */
	@Deprecated
	@Attributes.Funnel
	default E onloadedmetadata(Object onloadedmetadata) throws IOException {
		@SuppressWarnings("unchecked") E element = (E)this;
		Attributes.onlySupportedInHtml5(element, "onloadedmetadata");
		return Attributes.Event.attribute(element, "onloadedmetadata", onloadedmetadata);
	}

	/**
	 * <ul>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-onloadedmetadata">3.2.6 Global attributes / onloadedmetadata</a>.</li>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-onloadedmetadata">8.1.7.2 Event handlers on elements, Document objects, and Window objects / onloadedmetadata</a>.</li>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-onloadedmetadata">8.1.7.2.1 IDL definitions / onloadedmetadata</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/onloadedmetadata">GlobalEventHandlers.onloadedmetadata</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/jsref/event_onloadedmetadata.asp">onloadedmetadata Event</a>.</li>
	 * </ul>
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 *
	 * @since HTML 5
	 *
	 * @see #onloadedmetadata(java.lang.Object)
	 *
	 * @deprecated  Although the onloadedmetadata attribute is global, it is only expected on
	 *              {@linkplain AnyAUDIO &lt;audio&gt;} and {@linkplain AnyVIDEO &lt;video&gt;}.
	 */
	@Deprecated
	default <Ex extends Throwable> E onloadedmetadata(IOSupplierE<?, Ex> onloadedmetadata) throws IOException, Ex {
		return onloadedmetadata((onloadedmetadata == null) ? null : onloadedmetadata.get());
	}

	/**
	 * <ul>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-onloadedmetadata">3.2.6 Global attributes / onloadedmetadata</a>.</li>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-onloadedmetadata">8.1.7.2 Event handlers on elements, Document objects, and Window objects / onloadedmetadata</a>.</li>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-onloadedmetadata">8.1.7.2.1 IDL definitions / onloadedmetadata</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/onloadedmetadata">GlobalEventHandlers.onloadedmetadata</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/jsref/event_onloadedmetadata.asp">onloadedmetadata Event</a>.</li>
	 * </ul>
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 *
	 * @since HTML 5
	 *
	 * @see #onloadedmetadata(java.lang.Object)
	 *
	 * @deprecated  Although the onloadedmetadata attribute is global, it is only expected on
	 *              {@linkplain AnyAUDIO &lt;audio&gt;} and {@linkplain AnyVIDEO &lt;video&gt;}.
	 */
	@Deprecated
	default <Ex extends Throwable> E onloadedmetadata(JavaScriptWritable<Ex> onloadedmetadata) throws IOException, Ex {
		return onloadedmetadata((Object)onloadedmetadata);
	}
}
