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
 * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-onprogress">3.2.6 Global attributes / onprogress</a>.</li>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-onprogress">8.1.7.2 Event handlers on elements, Document objects, and Window objects / onprogress</a>.</li>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-onprogress">8.1.7.2.1 IDL definitions / onprogress</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/onprogress">GlobalEventHandlers.onprogress</a>.</li>
 * <li>See <a href="https://www.w3schools.com/jsref/event_onprogress.asp">onprogress Event</a>.</li>
 * </ul>
 *
 * @param  <E>   This element type
 *
 * @since HTML 5
 *
 * @author  AO Industries, Inc.
 */
// Matches OnprogressUnexpected
@SuppressWarnings("deprecation")
public interface Onprogress<E extends Element<?, ?, E> & Onprogress<E>> extends OnprogressUnexpected<E> {

  /**
   * Utility class for working with {@link Onprogress}.
   *
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-onprogress">3.2.6 Global attributes / onprogress</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-onprogress">8.1.7.2 Event handlers on elements, Document objects, and Window objects / onprogress</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-onprogress">8.1.7.2.1 IDL definitions / onprogress</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/onprogress">GlobalEventHandlers.onprogress</a>.</li>
   * <li>See <a href="https://www.w3schools.com/jsref/event_onprogress.asp">onprogress Event</a>.</li>
   * </ul>
   *
   * @since HTML 5
   */
  public static final class onprogress {
    /** Make no instances. */
    private onprogress() {
      throw new AssertionError();
    }

    /**
     * Normalizes an onprogress attribute.
     *
     * @see  Coercion#trimNullIfEmpty(java.lang.Object)
     */
    public static Object normalize(Object onprogress) {
      return Coercion.trimNullIfEmpty(onprogress);
    }
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-onprogress">3.2.6 Global attributes / onprogress</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-onprogress">8.1.7.2 Event handlers on elements, Document objects, and Window objects / onprogress</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-onprogress">8.1.7.2.1 IDL definitions / onprogress</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/onprogress">GlobalEventHandlers.onprogress</a>.</li>
   * <li>See <a href="https://www.w3schools.com/jsref/event_onprogress.asp">onprogress Event</a>.</li>
   * </ul>
   *
   * @since HTML 5
   */
  @Override
  @Attributes.Funnel
  default E onprogress(Object onprogress) throws IOException {
    return OnprogressUnexpected.super.onprogress(onprogress);
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-onprogress">3.2.6 Global attributes / onprogress</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-onprogress">8.1.7.2 Event handlers on elements, Document objects, and Window objects / onprogress</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-onprogress">8.1.7.2.1 IDL definitions / onprogress</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/onprogress">GlobalEventHandlers.onprogress</a>.</li>
   * <li>See <a href="https://www.w3schools.com/jsref/event_onprogress.asp">onprogress Event</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @since HTML 5
   *
   * @see #onprogress(java.lang.Object)
   */
  @Override
  default <Ex extends Throwable> E onprogress(IOSupplierE<?, Ex> onprogress) throws IOException, Ex {
    return OnprogressUnexpected.super.onprogress(onprogress);
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-onprogress">3.2.6 Global attributes / onprogress</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-onprogress">8.1.7.2 Event handlers on elements, Document objects, and Window objects / onprogress</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-onprogress">8.1.7.2.1 IDL definitions / onprogress</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/onprogress">GlobalEventHandlers.onprogress</a>.</li>
   * <li>See <a href="https://www.w3schools.com/jsref/event_onprogress.asp">onprogress Event</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @since HTML 5
   *
   * @see #onprogress(java.lang.Object)
   */
  @Override
  default <Ex extends Throwable> E onprogress(JavaScriptWritable<Ex> onprogress) throws IOException, Ex {
    return OnprogressUnexpected.super.onprogress(onprogress);
  }
}
