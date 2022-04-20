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
import com.aoapps.html.any.AnyINPUT;
import com.aoapps.html.any.AnySELECT;
import com.aoapps.html.any.AnyTEXTAREA;
import com.aoapps.html.any.AnyTRACK;
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
 * @since HTML 5
 *
 * @deprecated  Although the onchange attribute is global as of HTML5, it is only expected on
 *              {@linkplain AnyINPUT &lt;input&gt;}, {@linkplain AnySELECT &lt;select&gt;},
 *              {@linkplain AnyTEXTAREA &lt;textarea&gt;}, and {@linkplain AnyTRACK &lt;track&gt;}.
 *
 * @author  AO Industries, Inc.
 */
// Matches Onchange
@Deprecated
public interface OnchangeUnexpected<E extends Element<?, ?, E> & OnchangeUnexpected<E>> {

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
   * @since HTML 5
   *
   * @deprecated  Although the onchange attribute is global as of HTML5, it is only expected on
   *              {@linkplain AnyINPUT &lt;input&gt;}, {@linkplain AnySELECT &lt;select&gt;},
   *              {@linkplain AnyTEXTAREA &lt;textarea&gt;}, and {@linkplain AnyTRACK &lt;track&gt;}.
   */
  @Deprecated
  @Attributes.Funnel
  default E onchange(Object onchange) throws IOException {
    @SuppressWarnings("unchecked") E element = (E)this;
    Attributes.onlySupportedInHtml5(element, "onchange");
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
   * @since HTML 5
   *
   * @see #onchange(java.lang.Object)
   *
   * @deprecated  Although the onchange attribute is global as of HTML5, it is only expected on
   *              {@linkplain AnyINPUT &lt;input&gt;}, {@linkplain AnySELECT &lt;select&gt;},
   *              {@linkplain AnyTEXTAREA &lt;textarea&gt;}, and {@linkplain AnyTRACK &lt;track&gt;}.
   */
  @Deprecated
  default <Ex extends Throwable> E onchange(IOSupplierE<?, Ex> onchange) throws IOException, Ex {
    return onchange((onchange == null) ? null : onchange.get());
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
   * @since HTML 5
   *
   * @see #onchange(java.lang.Object)
   *
   * @deprecated  Although the onchange attribute is global as of HTML5, it is only expected on
   *              {@linkplain AnyINPUT &lt;input&gt;}, {@linkplain AnySELECT &lt;select&gt;},
   *              {@linkplain AnyTEXTAREA &lt;textarea&gt;}, and {@linkplain AnyTRACK &lt;track&gt;}.
   */
  @Deprecated
  default <Ex extends Throwable> E onchange(JavaScriptWritable<Ex> onchange) throws IOException, Ex {
    return onchange((Object)onchange);
  }
}
