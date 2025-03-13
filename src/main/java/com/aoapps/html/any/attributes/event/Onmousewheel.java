/*
 * ao-fluent-html-any - Base abstract classes and interfaces for Fluent Java DSL for high-performance HTML generation.
 * Copyright (C) 2019, 2020, 2021, 2022, 2023, 2024, 2025  AO Industries, Inc.
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
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/onmousewheel">GlobalEventHandlers.onmousewheel</a>.</li>
 * <li>See <a href="https://www.w3schools.com/tags/att_onmousewheel.asp">HTML onmousewheel Attribute</a>.</li>
 * </ul>
 *
 * @param  <E>   This element type
 *
 * @deprecated  The onmousewheel attribute is deprecated, you should use the {@linkplain Onwheel onwheel} attribute in HTML5.
 *
 * @author  AO Industries, Inc.
 */
@Deprecated(forRemoval = false)
public interface Onmousewheel<E extends Element<?, ?, E> & Onmousewheel<E>> {

  /**
   * Utility class for working with {@link Onmousewheel}.
   *
   * <ul>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/onmousewheel">GlobalEventHandlers.onmousewheel</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/att_onmousewheel.asp">HTML onmousewheel Attribute</a>.</li>
   * </ul>
   *
   * @deprecated  The onmousewheel attribute is deprecated, you should use the {@linkplain Onwheel#onwheel(java.lang.Object) onwheel} attribute in HTML5.
   */
  @Deprecated(forRemoval = false)
  public static final class onmousewheel {
    /** Make no instances. */
    private onmousewheel() {
      throw new AssertionError();
    }

    /**
     * Normalizes an onmousewheel attribute.
     *
     * @see  Coercion#trimNullIfEmpty(java.lang.Object)
     *
     * @deprecated  The onmousewheel attribute is deprecated, you should use the {@linkplain Onwheel#onwheel(java.lang.Object) onwheel} attribute in HTML5.
     */
    @Deprecated(forRemoval = false)
    public static Object normalize(Object onmousewheel) {
      return Coercion.trimNullIfEmpty(onmousewheel);
    }
  }

  /**
   * <ul>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/onmousewheel">GlobalEventHandlers.onmousewheel</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/att_onmousewheel.asp">HTML onmousewheel Attribute</a>.</li>
   * </ul>
   *
   * @deprecated  The onmousewheel attribute is deprecated, you should use the {@linkplain Onwheel#onwheel(java.lang.Object) onwheel} attribute in HTML5.
   */
  @Deprecated(forRemoval = false)
  @Attributes.Funnel
  default E onmousewheel(Object onmousewheel) throws IOException {
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return Attributes.Event.attribute(element, "onmousewheel", onmousewheel, Onmousewheel.onmousewheel::normalize);
  }

  /**
   * <ul>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/onmousewheel">GlobalEventHandlers.onmousewheel</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/att_onmousewheel.asp">HTML onmousewheel Attribute</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @see #onmousewheel(java.lang.Object)
   *
   * @deprecated  The onmousewheel attribute is deprecated, you should use the {@linkplain Onwheel#onwheel(com.aoapps.lang.io.function.IOSupplierE) onwheel} attribute in HTML5.
   */
  @Deprecated(forRemoval = false)
  default <Ex extends Throwable> E onmousewheel(IOSupplierE<?, Ex> onmousewheel) throws IOException, Ex {
    return onmousewheel((onmousewheel == null) ? null : onmousewheel.get());
  }

  /**
   * <ul>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/onmousewheel">GlobalEventHandlers.onmousewheel</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/att_onmousewheel.asp">HTML onmousewheel Attribute</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @see #onmousewheel(java.lang.Object)
   *
   * @deprecated  The onmousewheel attribute is deprecated, you should use the {@linkplain Onwheel#onwheel(com.aoapps.encoding.JavaScriptWritable) onwheel} attribute in HTML5.
   */
  @Deprecated(forRemoval = false)
  default <Ex extends Throwable> E onmousewheel(JavaScriptWritable<Ex> onmousewheel) throws IOException, Ex {
    return onmousewheel((Object) onmousewheel);
  }
}
