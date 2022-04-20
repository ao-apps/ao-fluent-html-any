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
import com.aoapps.html.any.AnyBODY;
import com.aoapps.html.any.AnyEMBED;
import com.aoapps.html.any.AnyFRAME;
import com.aoapps.html.any.AnyFRAMESET;
import com.aoapps.html.any.AnyIFRAME;
import com.aoapps.html.any.AnyIMG;
import com.aoapps.html.any.AnyINPUT;
import com.aoapps.html.any.AnyLINK;
import com.aoapps.html.any.AnyOBJECT;
import com.aoapps.html.any.AnySCRIPT;
import com.aoapps.html.any.AnySTYLE;
import com.aoapps.html.any.AnyTRACK;
import com.aoapps.html.any.Attributes;
import com.aoapps.html.any.Element;
import com.aoapps.lang.io.function.IOSupplierE;
import java.io.IOException;

/**
 * <ul>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-onload">3.2.6 Global attributes / onload</a>.</li>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-onload">8.1.7.2 Event handlers on elements, Document objects, and Window objects / onload</a>.</li>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-onload">8.1.7.2.1 IDL definitions / onload</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/onload">GlobalEventHandlers.onload</a>.</li>
 * <li>See <a href="https://www.w3schools.com/jsref/event_onload.asp">onload Event</a>.</li>
 * </ul>
 *
 * @param  <E>   This element type
 *
 * @since HTML 5
 *
 * @deprecated  Although the onload attribute is global as of HTML5, it is only expected on
 *              {@linkplain AnyBODY &lt;body&gt;}, {@linkplain AnyEMBED &lt;embed&gt;}, {@linkplain AnyFRAME &lt;frame&gt;},
 *              {@linkplain AnyFRAMESET &lt;frameset&gt;}, {@linkplain AnyIFRAME &lt;iframe&gt;}, {@linkplain AnyIMG &lt;img&gt;},
 *              {@linkplain AnyINPUT &lt;input&gt;}, {@linkplain AnyLINK &lt;link&gt;}, {@linkplain AnyOBJECT &lt;object&gt;},
 *              {@linkplain AnySCRIPT &lt;script&gt;}, {@linkplain AnySTYLE &lt;style&gt;}, and {@linkplain AnyTRACK &lt;track&gt;}.
 *
 * @author  AO Industries, Inc.
 */
// Matches Onload
@Deprecated
public interface OnloadUnexpected<E extends Element<?, ?, E> & OnloadUnexpected<E>> {

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-onload">3.2.6 Global attributes / onload</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-onload">8.1.7.2 Event handlers on elements, Document objects, and Window objects / onload</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-onload">8.1.7.2.1 IDL definitions / onload</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/onload">GlobalEventHandlers.onload</a>.</li>
   * <li>See <a href="https://www.w3schools.com/jsref/event_onload.asp">onload Event</a>.</li>
   * </ul>
   *
   * @since HTML 5
   *
   * @deprecated  Although the onload attribute is global as of HTML5, it is only expected on
   *              {@linkplain AnyBODY &lt;body&gt;}, {@linkplain AnyEMBED &lt;embed&gt;}, {@linkplain AnyFRAME &lt;frame&gt;},
   *              {@linkplain AnyFRAMESET &lt;frameset&gt;}, {@linkplain AnyIFRAME &lt;iframe&gt;}, {@linkplain AnyIMG &lt;img&gt;},
   *              {@linkplain AnyINPUT &lt;input&gt;}, {@linkplain AnyLINK &lt;link&gt;}, {@linkplain AnyOBJECT &lt;object&gt;},
   *              {@linkplain AnySCRIPT &lt;script&gt;}, {@linkplain AnySTYLE &lt;style&gt;}, and {@linkplain AnyTRACK &lt;track&gt;}.
   */
  @Deprecated
  @Attributes.Funnel
  default E onload(Object onload) throws IOException {
    @SuppressWarnings("unchecked") E element = (E)this;
    Attributes.onlySupportedInHtml5(element, "onload");
    return Attributes.Event.attribute(element, "onload", onload);
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-onload">3.2.6 Global attributes / onload</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-onload">8.1.7.2 Event handlers on elements, Document objects, and Window objects / onload</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-onload">8.1.7.2.1 IDL definitions / onload</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/onload">GlobalEventHandlers.onload</a>.</li>
   * <li>See <a href="https://www.w3schools.com/jsref/event_onload.asp">onload Event</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @since HTML 5
   *
   * @see #onload(java.lang.Object)
   *
   * @deprecated  Although the onload attribute is global as of HTML5, it is only expected on
   *              {@linkplain AnyBODY &lt;body&gt;}, {@linkplain AnyEMBED &lt;embed&gt;}, {@linkplain AnyFRAME &lt;frame&gt;},
   *              {@linkplain AnyFRAMESET &lt;frameset&gt;}, {@linkplain AnyIFRAME &lt;iframe&gt;}, {@linkplain AnyIMG &lt;img&gt;},
   *              {@linkplain AnyINPUT &lt;input&gt;}, {@linkplain AnyLINK &lt;link&gt;}, {@linkplain AnyOBJECT &lt;object&gt;},
   *              {@linkplain AnySCRIPT &lt;script&gt;}, {@linkplain AnySTYLE &lt;style&gt;}, and {@linkplain AnyTRACK &lt;track&gt;}.
   */
  @Deprecated
  default <Ex extends Throwable> E onload(IOSupplierE<?, Ex> onload) throws IOException, Ex {
    return onload((onload == null) ? null : onload.get());
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-onload">3.2.6 Global attributes / onload</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-onload">8.1.7.2 Event handlers on elements, Document objects, and Window objects / onload</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-onload">8.1.7.2.1 IDL definitions / onload</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/onload">GlobalEventHandlers.onload</a>.</li>
   * <li>See <a href="https://www.w3schools.com/jsref/event_onload.asp">onload Event</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @since HTML 5
   *
   * @see #onload(java.lang.Object)
   *
   * @deprecated  Although the onload attribute is global as of HTML5, it is only expected on
   *              {@linkplain AnyBODY &lt;body&gt;}, {@linkplain AnyEMBED &lt;embed&gt;}, {@linkplain AnyFRAME &lt;frame&gt;},
   *              {@linkplain AnyFRAMESET &lt;frameset&gt;}, {@linkplain AnyIFRAME &lt;iframe&gt;}, {@linkplain AnyIMG &lt;img&gt;},
   *              {@linkplain AnyINPUT &lt;input&gt;}, {@linkplain AnyLINK &lt;link&gt;}, {@linkplain AnyOBJECT &lt;object&gt;},
   *              {@linkplain AnySCRIPT &lt;script&gt;}, {@linkplain AnySTYLE &lt;style&gt;}, and {@linkplain AnyTRACK &lt;track&gt;}.
   */
  @Deprecated
  default <Ex extends Throwable> E onload(JavaScriptWritable<Ex> onload) throws IOException, Ex {
    return onload((Object)onload);
  }
}
