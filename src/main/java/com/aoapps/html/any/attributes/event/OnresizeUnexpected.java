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
import com.aoapps.html.any.AnyBODY;
import com.aoapps.html.any.AnyFRAMESET;
import com.aoapps.html.any.AnyVIDEO;
import com.aoapps.html.any.Attributes;
import com.aoapps.html.any.Element;
import com.aoapps.lang.io.function.IOSupplierE;
import java.io.IOException;

/**
 * <ul>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-onresize">3.2.6 Global attributes / onresize</a>.</li>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-onresize">8.1.7.2 Event handlers on elements, Document objects, and Window objects / onresize</a>.</li>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-onresize">8.1.7.2.1 IDL definitions / onresize</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/onresize">GlobalEventHandlers.onresize</a>.</li>
 * <li>See <a href="https://www.w3schools.com/jsref/event_onresize.asp">onresize Event</a>.</li>
 * </ul>
 *
 * @param  <E>   This element type
 *
 * @since HTML 5
 *
 * @deprecated  Although the onresize attribute is global, it is only expected on
 *              {@linkplain AnyBODY &lt;body&gt;}, {@linkplain AnyFRAMESET &lt;frameset&gt;}, and {@linkplain AnyVIDEO &lt;video&gt;}.
 *
 * @author  AO Industries, Inc.
 */
// Matches Onresize
@Deprecated
public interface OnresizeUnexpected<E extends Element<?, ?, E> & OnresizeUnexpected<E>> {

	/**
	 * <ul>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-onresize">3.2.6 Global attributes / onresize</a>.</li>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-onresize">8.1.7.2 Event handlers on elements, Document objects, and Window objects / onresize</a>.</li>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-onresize">8.1.7.2.1 IDL definitions / onresize</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/onresize">GlobalEventHandlers.onresize</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/jsref/event_onresize.asp">onresize Event</a>.</li>
	 * </ul>
	 *
	 * @since HTML 5
	 *
	 * @deprecated  Although the onresize attribute is global, it is only expected on
	 *              {@linkplain AnyBODY &lt;body&gt;}, {@linkplain AnyFRAMESET &lt;frameset&gt;}, and {@linkplain AnyVIDEO &lt;video&gt;}.
	 */
	@Deprecated
	@Attributes.Funnel
	default E onresize(Object onresize) throws IOException {
		@SuppressWarnings("unchecked") E element = (E)this;
		Attributes.onlySupportedInHtml5(element, "onresize");
		return Attributes.Event.attribute(element, "onresize", onresize);
	}

	/**
	 * <ul>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-onresize">3.2.6 Global attributes / onresize</a>.</li>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-onresize">8.1.7.2 Event handlers on elements, Document objects, and Window objects / onresize</a>.</li>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-onresize">8.1.7.2.1 IDL definitions / onresize</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/onresize">GlobalEventHandlers.onresize</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/jsref/event_onresize.asp">onresize Event</a>.</li>
	 * </ul>
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 *
	 * @since HTML 5
	 *
	 * @see #onresize(java.lang.Object)
	 *
	 * @deprecated  Although the onresize attribute is global, it is only expected on
	 *              {@linkplain AnyBODY &lt;body&gt;}, {@linkplain AnyFRAMESET &lt;frameset&gt;}, and {@linkplain AnyVIDEO &lt;video&gt;}.
	 */
	@Deprecated
	default <Ex extends Throwable> E onresize(IOSupplierE<?, Ex> onresize) throws IOException, Ex {
		return onresize((onresize == null) ? null : onresize.get());
	}

	/**
	 * <ul>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-onresize">3.2.6 Global attributes / onresize</a>.</li>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-onresize">8.1.7.2 Event handlers on elements, Document objects, and Window objects / onresize</a>.</li>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-onresize">8.1.7.2.1 IDL definitions / onresize</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/onresize">GlobalEventHandlers.onresize</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/jsref/event_onresize.asp">onresize Event</a>.</li>
	 * </ul>
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 *
	 * @since HTML 5
	 *
	 * @see #onresize(java.lang.Object)
	 *
	 * @deprecated  Although the onresize attribute is global, it is only expected on
	 *              {@linkplain AnyBODY &lt;body&gt;}, {@linkplain AnyFRAMESET &lt;frameset&gt;}, and {@linkplain AnyVIDEO &lt;video&gt;}.
	 */
	@Deprecated
	default <Ex extends Throwable> E onresize(JavaScriptWritable<Ex> onresize) throws IOException, Ex {
		return onresize((Object)onresize);
	}
}
