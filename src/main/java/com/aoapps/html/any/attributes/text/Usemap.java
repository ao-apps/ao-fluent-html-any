/*
 * ao-fluent-html-any - Base abstract classes and interfaces for Fluent Java DSL for high-performance HTML generation.
 * Copyright (C) 2019, 2020, 2021, 2022  AO Industries, Inc.
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

package com.aoapps.html.any.attributes.text;

import com.aoapps.hodgepodge.i18n.MarkupType;
import com.aoapps.html.any.Attributes;
import com.aoapps.html.any.Element;
import com.aoapps.lang.Strings;
import com.aoapps.lang.io.function.IOSupplierE;
import java.io.IOException;

/**
 * See <a href="https://www.w3schools.com/tags/att_usemap.asp">HTML usemap Attribute</a>.
 *
 * @param  <E>   This element type
 *
 * @author  AO Industries, Inc.
 */
public interface Usemap<E extends Element<?, ?, E> & Usemap<E>> {

  /**
   * See <a href="https://www.w3schools.com/tags/att_usemap.asp">HTML usemap Attribute</a>.
   * <p>
   * Automatically prefixes '#' to any non-null and non-empty (after trimming)
   * value that does not already begin with '#'.
   * </p>
   */
  @Attributes.Funnel
  default E usemap(String usemap) throws IOException {
    @SuppressWarnings("unchecked")
    E element = (E) this;
    usemap = Strings.trimNullIfEmpty(usemap);
    if (usemap != null) {
      if (!usemap.startsWith("#")) {
        usemap = '#' + usemap;
      }
      return Attributes.String.attribute(
          element,
          "usemap",
          MarkupType.NONE,
          usemap,
          false, // already trimmed
          false  // already nullIfEmpty
      );
    } else {
      return element;
    }
  }

  /**
   * See <a href="https://www.w3schools.com/tags/att_usemap.asp">HTML usemap Attribute</a>.
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @see #usemap(java.lang.String)
   */
  default <Ex extends Throwable> E usemap(IOSupplierE<? extends String, Ex> usemap) throws IOException, Ex {
    return usemap((usemap == null) ? null : usemap.get());
  }
}
