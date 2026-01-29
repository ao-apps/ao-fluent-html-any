/*
 * ao-fluent-html-any - Base abstract classes and interfaces for Fluent Java DSL for high-performance HTML generation.
 * Copyright (C) 2019, 2020, 2021, 2022, 2023, 2024  AO Industries, Inc.
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
import com.aoapps.html.any.Attributes;
import com.aoapps.html.any.Element;
import com.aoapps.lang.Coercion;
import com.aoapps.lang.io.function.IOSupplierE;
import java.io.IOException;

/**
 * <ul>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-onwheel">3.2.6 Global attributes / onwheel</a>.</li>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-onwheel">8.1.7.2 Event handlers on elements, Document objects, and Window objects / onwheel</a>.</li>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-onwheel">8.1.7.2.1 IDL definitions / onwheel</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/onwheel">GlobalEventHandlers.onwheel</a>.</li>
 * <li>See <a href="https://www.w3schools.com/jsref/event_onwheel.asp">onwheel Event</a>.</li>
 * </ul>
 *
 * @param  <E>   This element type
 *
 * @since HTML 5
 *
 * @author  AO Industries, Inc.
 */
// Matches OnwheelUnexpected
public interface Onwheel<E extends Element<?, ?, E> & Onwheel<E>> {

  /**
   * Utility class for working with {@link Onwheel}.
   *
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-onwheel">3.2.6 Global attributes / onwheel</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-onwheel">8.1.7.2 Event handlers on elements, Document objects, and Window objects / onwheel</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-onwheel">8.1.7.2.1 IDL definitions / onwheel</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/onwheel">GlobalEventHandlers.onwheel</a>.</li>
   * <li>See <a href="https://www.w3schools.com/jsref/event_onwheel.asp">onwheel Event</a>.</li>
   * </ul>
   *
   * @since HTML 5
   */
  public static final class onwheel {
    /** Make no instances. */
    private onwheel() {
      throw new AssertionError();
    }

    /**
     * Normalizes an onwheel attribute.
     *
     * @see  Coercion#trimNullIfEmpty(java.lang.Object)
     */
    public static Object normalize(Object onwheel) {
      return Coercion.trimNullIfEmpty(onwheel);
    }
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-onwheel">3.2.6 Global attributes / onwheel</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-onwheel">8.1.7.2 Event handlers on elements, Document objects, and Window objects / onwheel</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-onwheel">8.1.7.2.1 IDL definitions / onwheel</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/onwheel">GlobalEventHandlers.onwheel</a>.</li>
   * <li>See <a href="https://www.w3schools.com/jsref/event_onwheel.asp">onwheel Event</a>.</li>
   * </ul>
   *
   * @since HTML 5
   */
  @Attributes.Funnel
  default E onwheel(Object onwheel) throws IOException {
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return Attributes.Event.attribute(element, "onwheel", onwheel, Onwheel.onwheel::normalize,
        value -> Attributes.validateInHtml5(element, "onwheel"));
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-onwheel">3.2.6 Global attributes / onwheel</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-onwheel">8.1.7.2 Event handlers on elements, Document objects, and Window objects / onwheel</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-onwheel">8.1.7.2.1 IDL definitions / onwheel</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/onwheel">GlobalEventHandlers.onwheel</a>.</li>
   * <li>See <a href="https://www.w3schools.com/jsref/event_onwheel.asp">onwheel Event</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @since HTML 5
   *
   * @see Onwheel#onwheel(java.lang.Object)
   */
  default <Ex extends Throwable> E onwheel(IOSupplierE<?, Ex> onwheel) throws IOException, Ex {
    return onwheel((onwheel == null) ? null : onwheel.get());
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-onwheel">3.2.6 Global attributes / onwheel</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-onwheel">8.1.7.2 Event handlers on elements, Document objects, and Window objects / onwheel</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-onwheel">8.1.7.2.1 IDL definitions / onwheel</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/onwheel">GlobalEventHandlers.onwheel</a>.</li>
   * <li>See <a href="https://www.w3schools.com/jsref/event_onwheel.asp">onwheel Event</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @since HTML 5
   *
   * @see Onwheel#onwheel(java.lang.Object)
   */
  default <Ex extends Throwable> E onwheel(JavaScriptWritable<Ex> onwheel) throws IOException, Ex {
    return onwheel((Object) onwheel);
  }
}
