/*
 * ao-fluent-html-any - Base abstract classes and interfaces for Fluent Java DSL for high-performance HTML generation.
 * Copyright (C) 2019, 2020, 2021, 2022, 2023  AO Industries, Inc.
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
 * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-oncut">3.2.6 Global attributes / oncut</a>.</li>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-oncut">8.1.7.2 Event handlers on elements, Document objects, and Window objects / oncut</a>.</li>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-oncut">8.1.7.2.1 IDL definitions / oncut</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/oncut">HTMLElement.oncut</a>.</li>
 * <li>See <a href="https://www.w3schools.com/jsref/event_oncut.asp">oncut Event</a>.</li>
 * </ul>
 *
 * @param  <E>   This element type
 *
 * @author  AO Industries, Inc.
 */
// Matches OncutUnexpected
public interface Oncut<E extends Element<?, ?, E> & Oncut<E>> {

  /**
   * <p>
   * Utility class for working with {@link Oncut}.
   * </p>
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-oncut">3.2.6 Global attributes / oncut</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-oncut">8.1.7.2 Event handlers on elements, Document objects, and Window objects / oncut</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-oncut">8.1.7.2.1 IDL definitions / oncut</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/oncut">HTMLElement.oncut</a>.</li>
   * <li>See <a href="https://www.w3schools.com/jsref/event_oncut.asp">oncut Event</a>.</li>
   * </ul>
   */
  public static final class oncut {
    /** Make no instances. */
    private oncut() {
      throw new AssertionError();
    }

    /**
     * Normalizes an oncut attribute.
     *
     * @see  Coercion#trimNullIfEmpty(java.lang.Object)
     */
    public static Object normalize(Object oncut) {
      return Coercion.trimNullIfEmpty(oncut);
    }
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-oncut">3.2.6 Global attributes / oncut</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-oncut">8.1.7.2 Event handlers on elements, Document objects, and Window objects / oncut</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-oncut">8.1.7.2.1 IDL definitions / oncut</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/oncut">HTMLElement.oncut</a>.</li>
   * <li>See <a href="https://www.w3schools.com/jsref/event_oncut.asp">oncut Event</a>.</li>
   * </ul>
   */
  @Attributes.Funnel
  default E oncut(Object oncut) throws IOException {
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return Attributes.Event.attribute(element, "oncut", oncut, Oncut.oncut::normalize);
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-oncut">3.2.6 Global attributes / oncut</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-oncut">8.1.7.2 Event handlers on elements, Document objects, and Window objects / oncut</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-oncut">8.1.7.2.1 IDL definitions / oncut</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/oncut">HTMLElement.oncut</a>.</li>
   * <li>See <a href="https://www.w3schools.com/jsref/event_oncut.asp">oncut Event</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @see #oncut(java.lang.Object)
   */
  default <Ex extends Throwable> E oncut(IOSupplierE<?, Ex> oncut) throws IOException, Ex {
    return oncut((oncut == null) ? null : oncut.get());
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-oncut">3.2.6 Global attributes / oncut</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-oncut">8.1.7.2 Event handlers on elements, Document objects, and Window objects / oncut</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-oncut">8.1.7.2.1 IDL definitions / oncut</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/oncut">HTMLElement.oncut</a>.</li>
   * <li>See <a href="https://www.w3schools.com/jsref/event_oncut.asp">oncut Event</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @see #oncut(java.lang.Object)
   */
  default <Ex extends Throwable> E oncut(JavaScriptWritable<Ex> oncut) throws IOException, Ex {
    return oncut((Object) oncut);
  }
}
