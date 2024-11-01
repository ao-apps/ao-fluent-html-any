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
 * See <a href="https://www.w3schools.com/tags/ev_onpagehide.asp">HTML onpagehide Event Attribute</a>.
 *
 * @param  <E>   This element type
 *
 * @since HTML 5
 *
 * @author  AO Industries, Inc.
 */
public interface Onpagehide<E extends Element<?, ?, E> & Onpagehide<E>> {

  /**
   * Utility class for working with {@link Onpagehide}.
   *
   * <p>See <a href="https://www.w3schools.com/tags/ev_onpagehide.asp">HTML onpagehide Event Attribute</a>.</p>
   *
   * @since HTML 5
   */
  public static final class onpagehide {
    /** Make no instances. */
    private onpagehide() {
      throw new AssertionError();
    }

    /**
     * Normalizes an onpagehide attribute.
     *
     * @see  Coercion#trimNullIfEmpty(java.lang.Object)
     */
    public static Object normalize(Object onpagehide) {
      return Coercion.trimNullIfEmpty(onpagehide);
    }
  }

  /**
   * See <a href="https://www.w3schools.com/tags/ev_onpagehide.asp">HTML onpagehide Event Attribute</a>.
   *
   * @since HTML 5
   */
  @Attributes.Funnel
  default E onpagehide(Object onpagehide) throws IOException {
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return Attributes.Event.attribute(element, "onpagehide", onpagehide, Onpagehide.onpagehide::normalize,
        value -> Attributes.validateInHtml5(element, "onpagehide"));
  }

  /**
   * See <a href="https://www.w3schools.com/tags/ev_onpagehide.asp">HTML onpagehide Event Attribute</a>.
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @since HTML 5
   *
   * @see #onpagehide(java.lang.Object)
   */
  default <Ex extends Throwable> E onpagehide(IOSupplierE<?, Ex> onpagehide) throws IOException, Ex {
    return onpagehide((onpagehide == null) ? null : onpagehide.get());
  }

  /**
   * See <a href="https://www.w3schools.com/tags/ev_onpagehide.asp">HTML onpagehide Event Attribute</a>.
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @since HTML 5
   *
   * @see #onpagehide(java.lang.Object)
   */
  default <Ex extends Throwable> E onpagehide(JavaScriptWritable<Ex> onpagehide) throws IOException, Ex {
    return onpagehide((Object) onpagehide);
  }
}
