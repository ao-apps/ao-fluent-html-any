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
import com.aoapps.html.any.AnyBODY;
import com.aoapps.html.any.AnyIMG;
import com.aoapps.html.any.AnyINPUT;
import com.aoapps.html.any.AnyLINK;
import com.aoapps.html.any.AnySCRIPT;
import com.aoapps.html.any.AnySOURCE;
import com.aoapps.html.any.AnySTYLE;
import com.aoapps.html.any.AnyTRACK;
import com.aoapps.html.any.AnyVIDEO;
import com.aoapps.html.any.Attributes;
import com.aoapps.html.any.Element;
import com.aoapps.lang.io.function.IOSupplierE;
import java.io.IOException;

/**
 * <ul>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-onerror">3.2.6 Global attributes / onerror</a>.</li>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-onerror">8.1.7.2 Event handlers on elements, Document objects, and Window objects / onerror</a>.</li>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-onerror">8.1.7.2.1 IDL definitions / onerror</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/onerror">GlobalEventHandlers.onerror</a>.</li>
 * <li>See <a href="https://www.w3schools.com/jsref/event_onerror.asp">onerror Event</a>.</li>
 * </ul>
 *
 * @param  <E>   This element type
 *
 * @since HTML 5
 *
 * @deprecated  Although the onerror attribute is global, it is only expected on
 *              {@linkplain AnyAUDIO &lt;audio&gt;}, {@linkplain AnyBODY &lt;body&gt;}, {@linkplain com.aoapps.html.any.AnyFRAMESET &lt;frameset&gt;},
 *              {@linkplain AnyIMG &lt;img&gt;}, {@linkplain AnyINPUT &lt;input&gt;}, {@linkplain AnyLINK &lt;link&gt;},
 *              {@linkplain AnySCRIPT &lt;script&gt;}, {@linkplain AnySOURCE &lt;source&gt;}, {@linkplain AnySTYLE &lt;style&gt;},
 *              {@linkplain AnyTRACK &lt;track&gt;}, and {@linkplain AnyVIDEO &lt;video&gt;}.
 *
 * @author  AO Industries, Inc.
 */
// Matches Onerror
@Deprecated(forRemoval = false)
public interface OnerrorUnexpected<E extends Element<?, ?, E> & OnerrorUnexpected<E>> {

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-onerror">3.2.6 Global attributes / onerror</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-onerror">8.1.7.2 Event handlers on elements, Document objects, and Window objects / onerror</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-onerror">8.1.7.2.1 IDL definitions / onerror</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/onerror">GlobalEventHandlers.onerror</a>.</li>
   * <li>See <a href="https://www.w3schools.com/jsref/event_onerror.asp">onerror Event</a>.</li>
   * </ul>
   *
   * @since HTML 5
   *
   * @deprecated  Although the onerror attribute is global, it is only expected on
   *              {@linkplain AnyAUDIO &lt;audio&gt;}, {@linkplain AnyBODY &lt;body&gt;}, {@linkplain com.aoapps.html.any.AnyFRAMESET &lt;frameset&gt;},
   *              {@linkplain AnyIMG &lt;img&gt;}, {@linkplain AnyINPUT &lt;input&gt;}, {@linkplain AnyLINK &lt;link&gt;},
   *              {@linkplain AnySCRIPT &lt;script&gt;}, {@linkplain AnySOURCE &lt;source&gt;}, {@linkplain AnySTYLE &lt;style&gt;},
   *              {@linkplain AnyTRACK &lt;track&gt;}, and {@linkplain AnyVIDEO &lt;video&gt;}.
   */
  @Deprecated(forRemoval = false)
  @Attributes.Funnel
  default E onerror(Object onerror) throws IOException {
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return Attributes.Event.attribute(element, "onerror", onerror, Onerror.onerror::normalize,
        value -> Attributes.validateInHtml5(element, "onerror"));
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-onerror">3.2.6 Global attributes / onerror</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-onerror">8.1.7.2 Event handlers on elements, Document objects, and Window objects / onerror</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-onerror">8.1.7.2.1 IDL definitions / onerror</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/onerror">GlobalEventHandlers.onerror</a>.</li>
   * <li>See <a href="https://www.w3schools.com/jsref/event_onerror.asp">onerror Event</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @since HTML 5
   *
   * @see OnerrorUnexpected#onerror(java.lang.Object)
   *
   * @deprecated  Although the onerror attribute is global, it is only expected on
   *              {@linkplain AnyAUDIO &lt;audio&gt;}, {@linkplain AnyBODY &lt;body&gt;}, {@linkplain com.aoapps.html.any.AnyFRAMESET &lt;frameset&gt;},
   *              {@linkplain AnyIMG &lt;img&gt;}, {@linkplain AnyINPUT &lt;input&gt;}, {@linkplain AnyLINK &lt;link&gt;},
   *              {@linkplain AnySCRIPT &lt;script&gt;}, {@linkplain AnySOURCE &lt;source&gt;}, {@linkplain AnySTYLE &lt;style&gt;},
   *              {@linkplain AnyTRACK &lt;track&gt;}, and {@linkplain AnyVIDEO &lt;video&gt;}.
   */
  @Deprecated(forRemoval = false)
  default <Ex extends Throwable> E onerror(IOSupplierE<?, Ex> onerror) throws IOException, Ex {
    return onerror((onerror == null) ? null : onerror.get());
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-onerror">3.2.6 Global attributes / onerror</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-onerror">8.1.7.2 Event handlers on elements, Document objects, and Window objects / onerror</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-onerror">8.1.7.2.1 IDL definitions / onerror</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/onerror">GlobalEventHandlers.onerror</a>.</li>
   * <li>See <a href="https://www.w3schools.com/jsref/event_onerror.asp">onerror Event</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @since HTML 5
   *
   * @see OnerrorUnexpected#onerror(java.lang.Object)
   *
   * @deprecated  Although the onerror attribute is global, it is only expected on
   *              {@linkplain AnyAUDIO &lt;audio&gt;}, {@linkplain AnyBODY &lt;body&gt;}, {@linkplain com.aoapps.html.any.AnyFRAMESET &lt;frameset&gt;},
   *              {@linkplain AnyIMG &lt;img&gt;}, {@linkplain AnyINPUT &lt;input&gt;}, {@linkplain AnyLINK &lt;link&gt;},
   *              {@linkplain AnySCRIPT &lt;script&gt;}, {@linkplain AnySOURCE &lt;source&gt;}, {@linkplain AnySTYLE &lt;style&gt;},
   *              {@linkplain AnyTRACK &lt;track&gt;}, and {@linkplain AnyVIDEO &lt;video&gt;}.
   */
  @Deprecated(forRemoval = false)
  default <Ex extends Throwable> E onerror(JavaScriptWritable<Ex> onerror) throws IOException, Ex {
    return onerror((Object) onerror);
  }
}
