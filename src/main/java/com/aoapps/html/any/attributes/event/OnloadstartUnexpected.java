/*
 * ao-fluent-html-any - Base abstract classes and interfaces for Fluent Java DSL for high-performance HTML generation.
 * Copyright (C) 2022, 2023, 2025  AO Industries, Inc.
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
 * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-onloadstart">3.2.6 Global attributes / onloadstart</a>.</li>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-onloadstart">8.1.7.2 Event handlers on elements, Document objects, and Window objects / onloadstart</a>.</li>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-onloadstart">8.1.7.2.1 IDL definitions / onloadstart</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/onloadstart">GlobalEventHandlers.onloadstart</a>.</li>
 * <li>See <a href="https://www.w3schools.com/jsref/event_onloadstart.asp">onloadstart Event</a>.</li>
 * </ul>
 *
 * @param  <E>   This element type
 *
 * @since HTML 5
 *
 * @deprecated  Although the onloadstart attribute is global, it is only expected on
 *              {@linkplain AnyAUDIO &lt;audio&gt;} and {@linkplain AnyVIDEO &lt;video&gt;}.
 *
 * @author  AO Industries, Inc.
 */
// Matches Onloadstart
@Deprecated(forRemoval = false)
public interface OnloadstartUnexpected<E extends Element<?, ?, E> & OnloadstartUnexpected<E>> {

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-onloadstart">3.2.6 Global attributes / onloadstart</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-onloadstart">8.1.7.2 Event handlers on elements, Document objects, and Window objects / onloadstart</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-onloadstart">8.1.7.2.1 IDL definitions / onloadstart</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/onloadstart">GlobalEventHandlers.onloadstart</a>.</li>
   * <li>See <a href="https://www.w3schools.com/jsref/event_onloadstart.asp">onloadstart Event</a>.</li>
   * </ul>
   *
   * @since HTML 5
   *
   * @deprecated  Although the onloadstart attribute is global, it is only expected on
   *              {@linkplain AnyAUDIO &lt;audio&gt;} and {@linkplain AnyVIDEO &lt;video&gt;}.
   */
  @Deprecated(forRemoval = false)
  @Attributes.Funnel
  default E onloadstart(Object onloadstart) throws IOException {
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return Attributes.Event.attribute(element, "onloadstart", onloadstart, Onloadstart.onloadstart::normalize,
        value -> Attributes.validateInHtml5(element, "onloadstart"));
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-onloadstart">3.2.6 Global attributes / onloadstart</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-onloadstart">8.1.7.2 Event handlers on elements, Document objects, and Window objects / onloadstart</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-onloadstart">8.1.7.2.1 IDL definitions / onloadstart</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/onloadstart">GlobalEventHandlers.onloadstart</a>.</li>
   * <li>See <a href="https://www.w3schools.com/jsref/event_onloadstart.asp">onloadstart Event</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @since HTML 5
   *
   * @see #onloadstart(java.lang.Object)
   *
   * @deprecated  Although the onloadstart attribute is global, it is only expected on
   *              {@linkplain AnyAUDIO &lt;audio&gt;} and {@linkplain AnyVIDEO &lt;video&gt;}.
   */
  @Deprecated(forRemoval = false)
  default <Ex extends Throwable> E onloadstart(IOSupplierE<?, Ex> onloadstart) throws IOException, Ex {
    return onloadstart((onloadstart == null) ? null : onloadstart.get());
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-onloadstart">3.2.6 Global attributes / onloadstart</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-onloadstart">8.1.7.2 Event handlers on elements, Document objects, and Window objects / onloadstart</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-onloadstart">8.1.7.2.1 IDL definitions / onloadstart</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/onloadstart">GlobalEventHandlers.onloadstart</a>.</li>
   * <li>See <a href="https://www.w3schools.com/jsref/event_onloadstart.asp">onloadstart Event</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @since HTML 5
   *
   * @see #onloadstart(java.lang.Object)
   *
   * @deprecated  Although the onloadstart attribute is global, it is only expected on
   *              {@linkplain AnyAUDIO &lt;audio&gt;} and {@linkplain AnyVIDEO &lt;video&gt;}.
   */
  @Deprecated(forRemoval = false)
  default <Ex extends Throwable> E onloadstart(JavaScriptWritable<Ex> onloadstart) throws IOException, Ex {
    return onloadstart((Object) onloadstart);
  }
}
