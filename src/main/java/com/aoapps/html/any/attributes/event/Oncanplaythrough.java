/*
 * ao-fluent-html-any - Base abstract classes and interfaces for Fluent Java DSL for high-performance HTML generation.
 * Copyright (C) 2022, 2023, 2024  AO Industries, Inc.
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
 * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-oncanplaythrough">3.2.6 Global attributes / oncanplaythrough</a>.</li>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-oncanplaythrough">8.1.7.2 Event handlers on elements, Document objects, and Window objects / oncanplaythrough</a>.</li>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-oncanplaythrough">8.1.7.2.1 IDL definitions / oncanplaythrough</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/oncanplaythrough">GlobalEventHandlers.oncanplaythrough</a>.</li>
 * <li>See <a href="https://www.w3schools.com/jsref/event_oncanplaythrough.asp">oncanplaythrough Event</a>.</li>
 * </ul>
 *
 * @param  <E>   This element type
 *
 * @since HTML 5
 *
 * @author  AO Industries, Inc.
 */
// Matches OncanplaythroughUnexpected
@SuppressWarnings("deprecation")
public interface Oncanplaythrough<E extends Element<?, ?, E> & Oncanplaythrough<E>> extends OncanplaythroughUnexpected<E> {

  /**
   * Utility class for working with {@link Oncanplaythrough}.
   *
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-oncanplaythrough">3.2.6 Global attributes / oncanplaythrough</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-oncanplaythrough">8.1.7.2 Event handlers on elements, Document objects, and Window objects / oncanplaythrough</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-oncanplaythrough">8.1.7.2.1 IDL definitions / oncanplaythrough</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/oncanplaythrough">GlobalEventHandlers.oncanplaythrough</a>.</li>
   * <li>See <a href="https://www.w3schools.com/jsref/event_oncanplaythrough.asp">oncanplaythrough Event</a>.</li>
   * </ul>
   *
   * @since HTML 5
   */
  public static final class oncanplaythrough {
    /** Make no instances. */
    private oncanplaythrough() {
      throw new AssertionError();
    }

    /**
     * Normalizes an oncanplaythrough attribute.
     *
     * @see  Coercion#trimNullIfEmpty(java.lang.Object)
     */
    public static Object normalize(Object oncanplaythrough) {
      return Coercion.trimNullIfEmpty(oncanplaythrough);
    }
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-oncanplaythrough">3.2.6 Global attributes / oncanplaythrough</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-oncanplaythrough">8.1.7.2 Event handlers on elements, Document objects, and Window objects / oncanplaythrough</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-oncanplaythrough">8.1.7.2.1 IDL definitions / oncanplaythrough</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/oncanplaythrough">GlobalEventHandlers.oncanplaythrough</a>.</li>
   * <li>See <a href="https://www.w3schools.com/jsref/event_oncanplaythrough.asp">oncanplaythrough Event</a>.</li>
   * </ul>
   *
   * @since HTML 5
   */
  @Override
  @Attributes.Funnel
  default E oncanplaythrough(Object oncanplaythrough) throws IOException {
    return OncanplaythroughUnexpected.super.oncanplaythrough(oncanplaythrough);
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-oncanplaythrough">3.2.6 Global attributes / oncanplaythrough</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-oncanplaythrough">8.1.7.2 Event handlers on elements, Document objects, and Window objects / oncanplaythrough</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-oncanplaythrough">8.1.7.2.1 IDL definitions / oncanplaythrough</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/oncanplaythrough">GlobalEventHandlers.oncanplaythrough</a>.</li>
   * <li>See <a href="https://www.w3schools.com/jsref/event_oncanplaythrough.asp">oncanplaythrough Event</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @since HTML 5
   *
   * @see #oncanplaythrough(java.lang.Object)
   */
  @Override
  default <Ex extends Throwable> E oncanplaythrough(IOSupplierE<?, Ex> oncanplaythrough) throws IOException, Ex {
    return OncanplaythroughUnexpected.super.oncanplaythrough(oncanplaythrough);
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-oncanplaythrough">3.2.6 Global attributes / oncanplaythrough</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-oncanplaythrough">8.1.7.2 Event handlers on elements, Document objects, and Window objects / oncanplaythrough</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-oncanplaythrough">8.1.7.2.1 IDL definitions / oncanplaythrough</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/oncanplaythrough">GlobalEventHandlers.oncanplaythrough</a>.</li>
   * <li>See <a href="https://www.w3schools.com/jsref/event_oncanplaythrough.asp">oncanplaythrough Event</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @since HTML 5
   *
   * @see #oncanplaythrough(java.lang.Object)
   */
  @Override
  default <Ex extends Throwable> E oncanplaythrough(JavaScriptWritable<Ex> oncanplaythrough) throws IOException, Ex {
    return OncanplaythroughUnexpected.super.oncanplaythrough(oncanplaythrough);
  }
}
