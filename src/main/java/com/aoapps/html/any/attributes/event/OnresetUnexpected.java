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
import com.aoapps.html.any.AnyFORM;
import com.aoapps.html.any.Attributes;
import com.aoapps.html.any.Element;
import com.aoapps.lang.io.function.IOSupplierE;
import java.io.IOException;

/**
 * <ul>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-onreset">3.2.6 Global attributes / onreset</a>.</li>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-onreset">8.1.7.2 Event handlers on elements, Document objects, and Window objects / onreset</a>.</li>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-onreset">8.1.7.2.1 IDL definitions / onreset</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/onreset">GlobalEventHandlers.onreset</a>.</li>
 * <li>See <a href="https://www.w3schools.com/jsref/event_onreset.asp">onreset Event</a>.</li>
 * </ul>
 *
 * @param  <E>   This element type
 *
 * @since HTML 5
 *
 * @deprecated  Although the onreset attribute is global, it is only expected on
 *              {@linkplain AnyFORM &lt;form&gt;}.
 *
 * @author  AO Industries, Inc.
 */
// Matches Onreset
@Deprecated(forRemoval = false)
public interface OnresetUnexpected<E extends Element<?, ?, E> & OnresetUnexpected<E>> {

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-onreset">3.2.6 Global attributes / onreset</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-onreset">8.1.7.2 Event handlers on elements, Document objects, and Window objects / onreset</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-onreset">8.1.7.2.1 IDL definitions / onreset</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/onreset">GlobalEventHandlers.onreset</a>.</li>
   * <li>See <a href="https://www.w3schools.com/jsref/event_onreset.asp">onreset Event</a>.</li>
   * </ul>
   *
   * @since HTML 5
   *
   * @deprecated  Although the onreset attribute is global, it is only expected on
   *              {@linkplain AnyFORM &lt;form&gt;}.
   */
  @Deprecated(forRemoval = false)
  @Attributes.Funnel
  default E onreset(Object onreset) throws IOException {
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return Attributes.Event.attribute(element, "onreset", onreset, Onreset.onreset::normalize,
        value -> Attributes.validateInHtml5(element, "onreset"));
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-onreset">3.2.6 Global attributes / onreset</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-onreset">8.1.7.2 Event handlers on elements, Document objects, and Window objects / onreset</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-onreset">8.1.7.2.1 IDL definitions / onreset</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/onreset">GlobalEventHandlers.onreset</a>.</li>
   * <li>See <a href="https://www.w3schools.com/jsref/event_onreset.asp">onreset Event</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @since HTML 5
   *
   * @see #onreset(java.lang.Object)
   *
   * @deprecated  Although the onreset attribute is global, it is only expected on
   *              {@linkplain AnyFORM &lt;form&gt;}.
   */
  @Deprecated(forRemoval = false)
  default <Ex extends Throwable> E onreset(IOSupplierE<?, Ex> onreset) throws IOException, Ex {
    return onreset((onreset == null) ? null : onreset.get());
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-onreset">3.2.6 Global attributes / onreset</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-onreset">8.1.7.2 Event handlers on elements, Document objects, and Window objects / onreset</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-onreset">8.1.7.2.1 IDL definitions / onreset</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/onreset">GlobalEventHandlers.onreset</a>.</li>
   * <li>See <a href="https://www.w3schools.com/jsref/event_onreset.asp">onreset Event</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @since HTML 5
   *
   * @see #onreset(java.lang.Object)
   *
   * @deprecated  Although the onreset attribute is global, it is only expected on
   *              {@linkplain AnyFORM &lt;form&gt;}.
   */
  @Deprecated(forRemoval = false)
  default <Ex extends Throwable> E onreset(JavaScriptWritable<Ex> onreset) throws IOException, Ex {
    return onreset((Object) onreset);
  }
}
