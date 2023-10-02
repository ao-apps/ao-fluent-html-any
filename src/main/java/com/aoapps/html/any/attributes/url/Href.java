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

package com.aoapps.html.any.attributes.url;

import com.aoapps.html.any.Attributes;
import com.aoapps.html.any.Element;
import com.aoapps.lang.Strings;
import com.aoapps.lang.io.function.IOSupplierE;
import java.io.IOException;

/**
 * See <a href="https://www.w3schools.com/tags/att_href.asp">HTML href Attribute</a>.
 *
 * @param  <E>   This element type
 *
 * @author  AO Industries, Inc.
 */
public interface Href<E extends Element<?, ?, E> & Href<E>> {

  /**
   * <p>
   * Utility class for working with {@link Href}.
   * </p>
   * <p>
   * See <a href="https://www.w3schools.com/tags/att_href.asp">HTML href Attribute</a>.
   * </p>
   */
  public static final class href {
    /** Make no instances. */
    private href() {
      throw new AssertionError();
    }

    /**
     * Normalizes an href attribute.
     *
     * @see  Strings#trimNullIfEmpty(java.lang.String)
     */
    public static String normalize(String href) {
      return Strings.trimNullIfEmpty(href);
    }
  }

  /**
   * See <a href="https://www.w3schools.com/tags/att_href.asp">HTML href Attribute</a>.
   */
  @Attributes.Funnel
  default E href(String href) throws IOException {
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return Attributes.Url.attribute(element, "href", href, Href.href::normalize);
  }

  /**
   * See <a href="https://www.w3schools.com/tags/att_href.asp">HTML href Attribute</a>.
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @see #href(java.lang.String)
   */
  default <Ex extends Throwable> E href(IOSupplierE<? extends String, Ex> href) throws IOException, Ex {
    return href((href == null) ? null : href.get());
  }
}
