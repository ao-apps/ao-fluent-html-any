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

package com.aoapps.html.any;

import com.aoapps.encoding.Doctype;
import com.aoapps.lang.LocalizedUnsupportedOperationException;
import com.aoapps.lang.i18n.Resources;
import java.util.ResourceBundle;

/**
 * Internal utilities for working with {@link Element}.
 *
 * @author  AO Industries, Inc.
 */
// TODO: Move to a private impl package?
final class Elements {

  /** Make no instances. */
  private Elements() {
    throw new AssertionError();
  }

  private static final Resources RESOURCES = Resources.getResources(ResourceBundle::getBundle, Elements.class);

  /**
   * Enforces that the document type is HTML 5 for the given attribute.
   *
   * @throws  UnsupportedOperationException when {@link EncodingContext#getDoctype()} is not {@link Doctype#HTML5}.
   */
  static void onlySupportedInHtml5(AnyDocument<?> document, String element) throws UnsupportedOperationException {
    Doctype doctype = document.encodingContext.getDoctype();
    if (doctype != Doctype.HTML5) {
      throw new LocalizedUnsupportedOperationException(
        RESOURCES,
        "onlySupportedInHtml5",
        doctype,
        element
      );
    }
  }
}
