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
import com.aoapps.html.any.AnyINPUT;
import com.aoapps.html.any.AnyTEXTAREA;
import com.aoapps.html.any.Attributes;
import com.aoapps.html.any.Element;
import com.aoapps.lang.io.function.IOSupplierE;
import java.io.IOException;

/**
 * <ul>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-onselect">3.2.6 Global attributes / onselect</a>.</li>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-onselect">8.1.7.2 Event handlers on elements, Document objects, and Window objects / onselect</a>.</li>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-onselect">8.1.7.2.1 IDL definitions / onselect</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/onselect">GlobalEventHandlers.onselect</a>.</li>
 * <li>See <a href="https://www.w3schools.com/jsref/event_onselect.asp">onselect Event</a>.</li>
 * </ul>
 *
 * @param  <E>   This element type
 *
 * @since HTML 5
 *
 * @deprecated  Although the onselect attribute is global as of HTML5, it is only expected on
 *              {@linkplain AnyINPUT &lt;input&gt;} and {@linkplain AnyTEXTAREA &lt;textarea&gt;}.
 *
 * @author  AO Industries, Inc.
 */
// Matches Onselect
@Deprecated(forRemoval = false)
public interface OnselectUnexpected<E extends Element<?, ?, E> & OnselectUnexpected<E>> {

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-onselect">3.2.6 Global attributes / onselect</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-onselect">8.1.7.2 Event handlers on elements, Document objects, and Window objects / onselect</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-onselect">8.1.7.2.1 IDL definitions / onselect</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/onselect">GlobalEventHandlers.onselect</a>.</li>
   * <li>See <a href="https://www.w3schools.com/jsref/event_onselect.asp">onselect Event</a>.</li>
   * </ul>
   *
   * @since HTML 5
   *
   * @deprecated  Although the onselect attribute is global as of HTML5, it is only expected on
   *              {@linkplain AnyINPUT &lt;input&gt;} and {@linkplain AnyTEXTAREA &lt;textarea&gt;}.
   */
  @Deprecated(forRemoval = false)
  @Attributes.Funnel
  default E onselect(Object onselect) throws IOException {
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return Attributes.Event.attribute(element, "onselect", onselect, Onselect.onselect::normalize,
        value -> Attributes.validateInHtml5(element, "onselect"));
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-onselect">3.2.6 Global attributes / onselect</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-onselect">8.1.7.2 Event handlers on elements, Document objects, and Window objects / onselect</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-onselect">8.1.7.2.1 IDL definitions / onselect</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/onselect">GlobalEventHandlers.onselect</a>.</li>
   * <li>See <a href="https://www.w3schools.com/jsref/event_onselect.asp">onselect Event</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @since HTML 5
   *
   * @see OnselectUnexpected#onselect(java.lang.Object)
   *
   * @deprecated  Although the onselect attribute is global as of HTML5, it is only expected on
   *              {@linkplain AnyINPUT &lt;input&gt;} and {@linkplain AnyTEXTAREA &lt;textarea&gt;}.
   */
  @Deprecated(forRemoval = false)
  default <Ex extends Throwable> E onselect(IOSupplierE<?, Ex> onselect) throws IOException, Ex {
    return onselect((onselect == null) ? null : onselect.get());
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-onselect">3.2.6 Global attributes / onselect</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-onselect">8.1.7.2 Event handlers on elements, Document objects, and Window objects / onselect</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-onselect">8.1.7.2.1 IDL definitions / onselect</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/onselect">GlobalEventHandlers.onselect</a>.</li>
   * <li>See <a href="https://www.w3schools.com/jsref/event_onselect.asp">onselect Event</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @since HTML 5
   *
   * @see OnselectUnexpected#onselect(java.lang.Object)
   *
   * @deprecated  Although the onselect attribute is global as of HTML5, it is only expected on
   *              {@linkplain AnyINPUT &lt;input&gt;} and {@linkplain AnyTEXTAREA &lt;textarea&gt;}.
   */
  @Deprecated(forRemoval = false)
  default <Ex extends Throwable> E onselect(JavaScriptWritable<Ex> onselect) throws IOException, Ex {
    return onselect((Object) onselect);
  }
}
