/*
 * ao-fluent-html-any - Base abstract classes and interfaces for Fluent Java DSL for high-performance HTML generation.
 * Copyright (C) 2021, 2022, 2023, 2024, 2025  AO Industries, Inc.
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

package com.aoapps.html.any.attributes.url;

import com.aoapps.html.any.Attributes;
import com.aoapps.html.any.Element;
import com.aoapps.lang.Strings;
import com.aoapps.lang.io.function.IOSupplierE;
import java.io.IOException;

/**
 * See <a href="https://html.spec.whatwg.org/multipage/iframe-embed-object.html#attr-object-data">4.8.7 The object element / data</a>.
 *
 * @param  <E>   This element type
 *
 * @author  AO Industries, Inc.
 */
public interface Data<E extends Element<?, ?, E> & Data<E>> {

  /**
   * Utility class for working with {@link Data}.
   *
   * <p>See <a href="https://html.spec.whatwg.org/multipage/iframe-embed-object.html#attr-object-data">4.8.7 The object element / data</a>.</p>
   */
  public static final class data {
    /** Make no instances. */
    private data() {
      throw new AssertionError();
    }

    /**
     * Normalizes a data attribute.
     *
     * @see  Strings#trimNullIfEmpty(java.lang.String)
     */
    public static String normalize(String data) {
      return Strings.trimNullIfEmpty(data);
    }
  }

  /**
   * See <a href="https://html.spec.whatwg.org/multipage/iframe-embed-object.html#attr-object-data">4.8.7 The object element / data</a>.
   */
  @Attributes.Funnel
  default E data(String data) throws IOException {
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return Attributes.Url.attribute(element, "data", data, Data.data::normalize);
  }

  /**
   * See <a href="https://html.spec.whatwg.org/multipage/iframe-embed-object.html#attr-object-data">4.8.7 The object element / data</a>.
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @see #data(java.lang.String)
   */
  default <Ex extends Throwable> E data(IOSupplierE<String, Ex> data) throws IOException, Ex {
    return data((data == null) ? null : data.get());
  }
}
