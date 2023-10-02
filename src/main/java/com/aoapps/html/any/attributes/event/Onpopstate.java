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
 * See <a href="https://www.w3schools.com/tags/ev_onpopstate.asp">HTML onpopstate Event Attribute</a>.
 *
 * @param  <E>   This element type
 *
 * @since HTML 5
 *
 * @author  AO Industries, Inc.
 */
public interface Onpopstate<E extends Element<?, ?, E> & Onpopstate<E>> {

  /**
   * <p>
   * Utility class for working with {@link Onpopstate}.
   * </p>
   * <p>
   * See <a href="https://www.w3schools.com/tags/ev_onpopstate.asp">HTML onpopstate Event Attribute</a>.
   * </p>
   *
   * @since HTML 5
   */
  public static final class onpopstate {
    /** Make no instances. */
    private onpopstate() {
      throw new AssertionError();
    }

    /**
     * Normalizes an onpopstate attribute.
     *
     * @see  Coercion#trimNullIfEmpty(java.lang.Object)
     */
    public static Object normalize(Object onpopstate) throws IOException {
      return Coercion.trimNullIfEmpty(onpopstate);
    }
  }

  /**
   * See <a href="https://www.w3schools.com/tags/ev_onpopstate.asp">HTML onpopstate Event Attribute</a>.
   *
   * @since HTML 5
   */
  @Attributes.Funnel
  default E onpopstate(Object onpopstate) throws IOException {
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return Attributes.Event.attribute(element, "onpopstate", onpopstate, Onpopstate.onpopstate::normalize,
        value -> Attributes.validateInHtml5(element, "onpopstate"));
  }

  /**
   * See <a href="https://www.w3schools.com/tags/ev_onpopstate.asp">HTML onpopstate Event Attribute</a>.
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @since HTML 5
   *
   * @see #onpopstate(java.lang.Object)
   */
  default <Ex extends Throwable> E onpopstate(IOSupplierE<?, Ex> onpopstate) throws IOException, Ex {
    return onpopstate((onpopstate == null) ? null : onpopstate.get());
  }

  /**
   * See <a href="https://www.w3schools.com/tags/ev_onpopstate.asp">HTML onpopstate Event Attribute</a>.
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @since HTML 5
   *
   * @see #onpopstate(java.lang.Object)
   */
  default <Ex extends Throwable> E onpopstate(JavaScriptWritable<Ex> onpopstate) throws IOException, Ex {
    return onpopstate((Object) onpopstate);
  }
}
