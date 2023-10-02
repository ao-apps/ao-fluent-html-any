/*
 * ao-fluent-html-any - Base abstract classes and interfaces for Fluent Java DSL for high-performance HTML generation.
 * Copyright (C) 2022, 2023  AO Industries, Inc.
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
 * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-ondurationchange">3.2.6 Global attributes / ondurationchange</a>.</li>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-ondurationchange">8.1.7.2 Event handlers on elements, Document objects, and Window objects / ondurationchange</a>.</li>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-ondurationchange">8.1.7.2.1 IDL definitions / ondurationchange</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/ondurationchange">GlobalEventHandlers.ondurationchange</a>.</li>
 * <li>See <a href="https://www.w3schools.com/jsref/event_ondurationchange.asp">ondurationchange Event</a>.</li>
 * </ul>
 *
 * @param  <E>   This element type
 *
 * @since HTML 5
 *
 * @deprecated  Although the ondurationchange attribute is global, it is only expected on
 *              {@linkplain AnyAUDIO &lt;audio&gt;} and {@linkplain AnyVIDEO &lt;video&gt;}.
 *
 * @author  AO Industries, Inc.
 */
// Matches Ondurationchange
@Deprecated
public interface OndurationchangeUnexpected<E extends Element<?, ?, E> & OndurationchangeUnexpected<E>> {

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-ondurationchange">3.2.6 Global attributes / ondurationchange</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-ondurationchange">8.1.7.2 Event handlers on elements, Document objects, and Window objects / ondurationchange</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-ondurationchange">8.1.7.2.1 IDL definitions / ondurationchange</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/ondurationchange">GlobalEventHandlers.ondurationchange</a>.</li>
   * <li>See <a href="https://www.w3schools.com/jsref/event_ondurationchange.asp">ondurationchange Event</a>.</li>
   * </ul>
   *
   * @since HTML 5
   *
   * @deprecated  Although the ondurationchange attribute is global, it is only expected on
   *              {@linkplain AnyAUDIO &lt;audio&gt;} and {@linkplain AnyVIDEO &lt;video&gt;}.
   */
  @Deprecated
  @Attributes.Funnel
  default E ondurationchange(Object ondurationchange) throws IOException {
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return Attributes.Event.attribute(element, "ondurationchange", ondurationchange,
        Ondurationchange.ondurationchange::normalize, value -> Attributes.validateInHtml5(element, "ondurationchange"));
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-ondurationchange">3.2.6 Global attributes / ondurationchange</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-ondurationchange">8.1.7.2 Event handlers on elements, Document objects, and Window objects / ondurationchange</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-ondurationchange">8.1.7.2.1 IDL definitions / ondurationchange</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/ondurationchange">GlobalEventHandlers.ondurationchange</a>.</li>
   * <li>See <a href="https://www.w3schools.com/jsref/event_ondurationchange.asp">ondurationchange Event</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @since HTML 5
   *
   * @see #ondurationchange(java.lang.Object)
   *
   * @deprecated  Although the ondurationchange attribute is global, it is only expected on
   *              {@linkplain AnyAUDIO &lt;audio&gt;} and {@linkplain AnyVIDEO &lt;video&gt;}.
   */
  @Deprecated
  default <Ex extends Throwable> E ondurationchange(IOSupplierE<?, Ex> ondurationchange) throws IOException, Ex {
    return ondurationchange((ondurationchange == null) ? null : ondurationchange.get());
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-ondurationchange">3.2.6 Global attributes / ondurationchange</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-ondurationchange">8.1.7.2 Event handlers on elements, Document objects, and Window objects / ondurationchange</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-ondurationchange">8.1.7.2.1 IDL definitions / ondurationchange</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/ondurationchange">GlobalEventHandlers.ondurationchange</a>.</li>
   * <li>See <a href="https://www.w3schools.com/jsref/event_ondurationchange.asp">ondurationchange Event</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @since HTML 5
   *
   * @see #ondurationchange(java.lang.Object)
   *
   * @deprecated  Although the ondurationchange attribute is global, it is only expected on
   *              {@linkplain AnyAUDIO &lt;audio&gt;} and {@linkplain AnyVIDEO &lt;video&gt;}.
   */
  @Deprecated
  default <Ex extends Throwable> E ondurationchange(JavaScriptWritable<Ex> ondurationchange) throws IOException, Ex {
    return ondurationchange((Object) ondurationchange);
  }
}
