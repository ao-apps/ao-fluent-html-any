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
 * See <a href="https://www.w3schools.com/tags/ev_onunload.asp">HTML onunload Event Attribute</a>.
 *
 * @param  <E>   This element type
 *
 * @author  AO Industries, Inc.
 */
public interface Onunload<E extends Element<?, ?, E> & Onunload<E>> {

  /**
   * <p>
   * Utility class for working with {@link Onunload}.
   * </p>
   * <p>
   * See <a href="https://www.w3schools.com/tags/ev_onunload.asp">HTML onunload Event Attribute</a>.
   * </p>
   *
   * @since HTML 5
   */
  public static final class onunload {
    /** Make no instances. */
    private onunload() {
      throw new AssertionError();
    }

    /**
     * Normalizes an onunload attribute.
     *
     * @see  Coercion#trimNullIfEmpty(java.lang.Object)
     */
    public static Object normalize(Object onunload) {
      return Coercion.trimNullIfEmpty(onunload);
    }
  }

  /**
   * See <a href="https://www.w3schools.com/tags/ev_onunload.asp">HTML onunload Event Attribute</a>.
   */
  @Attributes.Funnel
  default E onunload(Object onunload) throws IOException {
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return Attributes.Event.attribute(element, "onunload", onunload, Onunload.onunload::normalize);
  }

  /**
   * See <a href="https://www.w3schools.com/tags/ev_onunload.asp">HTML onunload Event Attribute</a>.
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @see #onunload(java.lang.Object)
   */
  default <Ex extends Throwable> E onunload(IOSupplierE<?, Ex> onunload) throws IOException, Ex {
    return onunload((onunload == null) ? null : onunload.get());
  }

  /**
   * See <a href="https://www.w3schools.com/tags/ev_onunload.asp">HTML onunload Event Attribute</a>.
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @see #onunload(java.lang.Object)
   */
  default <Ex extends Throwable> E onunload(JavaScriptWritable<Ex> onunload) throws IOException, Ex {
    return onunload((Object) onunload);
  }
}
