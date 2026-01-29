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
 * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-ondrag">3.2.6 Global attributes / ondrag</a>.</li>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-ondrag">8.1.7.2 Event handlers on elements, Document objects, and Window objects / ondrag</a>.</li>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-ondrag">8.1.7.2.1 IDL definitions / ondrag</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/ondrag">GlobalEventHandlers.ondrag</a>.</li>
 * <li>See <a href="https://www.w3schools.com/jsref/event_ondrag.asp">ondrag Event</a>.</li>
 * </ul>
 *
 * @param  <E>   This element type
 *
 * @since HTML 5
 *
 * @author  AO Industries, Inc.
 */
// Matches OndragUnexpected
public interface Ondrag<E extends Element<?, ?, E> & Ondrag<E>> {

  /**
   * Utility class for working with {@link Ondrag}.
   *
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-ondrag">3.2.6 Global attributes / ondrag</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-ondrag">8.1.7.2 Event handlers on elements, Document objects, and Window objects / ondrag</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-ondrag">8.1.7.2.1 IDL definitions / ondrag</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/ondrag">GlobalEventHandlers.ondrag</a>.</li>
   * <li>See <a href="https://www.w3schools.com/jsref/event_ondrag.asp">ondrag Event</a>.</li>
   * </ul>
   *
   * @since HTML 5
   */
  public static final class ondrag {
    /** Make no instances. */
    private ondrag() {
      throw new AssertionError();
    }

    /**
     * Normalizes an ondrag attribute.
     *
     * @see  Coercion#trimNullIfEmpty(java.lang.Object)
     */
    public static Object normalize(Object ondrag) {
      return Coercion.trimNullIfEmpty(ondrag);
    }
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-ondrag">3.2.6 Global attributes / ondrag</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-ondrag">8.1.7.2 Event handlers on elements, Document objects, and Window objects / ondrag</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-ondrag">8.1.7.2.1 IDL definitions / ondrag</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/ondrag">GlobalEventHandlers.ondrag</a>.</li>
   * <li>See <a href="https://www.w3schools.com/jsref/event_ondrag.asp">ondrag Event</a>.</li>
   * </ul>
   *
   * @since HTML 5
   */
  @Attributes.Funnel
  default E ondrag(Object ondrag) throws IOException {
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return Attributes.Event.attribute(element, "ondrag", ondrag, Ondrag.ondrag::normalize,
        value -> Attributes.validateInHtml5(element, "ondrag"));
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-ondrag">3.2.6 Global attributes / ondrag</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-ondrag">8.1.7.2 Event handlers on elements, Document objects, and Window objects / ondrag</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-ondrag">8.1.7.2.1 IDL definitions / ondrag</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/ondrag">GlobalEventHandlers.ondrag</a>.</li>
   * <li>See <a href="https://www.w3schools.com/jsref/event_ondrag.asp">ondrag Event</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @since HTML 5
   *
   * @see Ondrag#ondrag(java.lang.Object)
   */
  default <Ex extends Throwable> E ondrag(IOSupplierE<?, Ex> ondrag) throws IOException, Ex {
    return ondrag((ondrag == null) ? null : ondrag.get());
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-ondrag">3.2.6 Global attributes / ondrag</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-ondrag">8.1.7.2 Event handlers on elements, Document objects, and Window objects / ondrag</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-ondrag">8.1.7.2.1 IDL definitions / ondrag</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/ondrag">GlobalEventHandlers.ondrag</a>.</li>
   * <li>See <a href="https://www.w3schools.com/jsref/event_ondrag.asp">ondrag Event</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @since HTML 5
   *
   * @see Ondrag#ondrag(java.lang.Object)
   */
  default <Ex extends Throwable> E ondrag(JavaScriptWritable<Ex> ondrag) throws IOException, Ex {
    return ondrag((Object) ondrag);
  }
}
