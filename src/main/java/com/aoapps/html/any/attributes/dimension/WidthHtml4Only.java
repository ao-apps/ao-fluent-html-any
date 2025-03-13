/*
 * ao-fluent-html-any - Base abstract classes and interfaces for Fluent Java DSL for high-performance HTML generation.
 * Copyright (C) 2019, 2020, 2021, 2022, 2025  AO Industries, Inc.
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

package com.aoapps.html.any.attributes.dimension;

import com.aoapps.html.any.Attributes;
import com.aoapps.html.any.Element;
import com.aoapps.html.any.Suppliers;
import com.aoapps.lang.io.function.IOSupplierE;
import java.io.IOException;

/**
 * See <a href="https://www.w3schools.com/tags/att_width.asp">HTML width Attribute</a>.
 *
 * @param  <E>   This element type
 *
 * @deprecated  The width attribute is not supported in HTML5. Use CSS instead.
 *
 * @author  AO Industries, Inc.
 */
// Matches Width
@Deprecated(forRemoval = false)
public interface WidthHtml4Only<E extends Element<?, ?, E> & WidthHtml4Only<E>> extends Width<E> {

  /**
   * See <a href="https://www.w3schools.com/tags/att_width.asp">HTML width Attribute</a>.
   *
   * @deprecated  The width attribute is not supported in HTML5. Use CSS instead.
   */
  @Deprecated(forRemoval = false)
  @Override
  @Attributes.Funnel
  default E width(int pixels) throws IOException {
    return Width.super.width(pixels);
  }

  /**
   * See <a href="https://www.w3schools.com/tags/att_width.asp">HTML width Attribute</a>.
   *
   * @deprecated  The width attribute is not supported in HTML5. Use CSS instead.
   */
  @Deprecated(forRemoval = false)
  @Override
  @Attributes.Funnel
  default E width(Integer pixels) throws IOException {
    return Width.super.width(pixels);
  }

  /**
   * See <a href="https://www.w3schools.com/tags/att_width.asp">HTML width Attribute</a>.
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @deprecated  The width attribute is not supported in HTML5. Use CSS instead.
   */
  @Deprecated(forRemoval = false)
  @Override
  @SuppressWarnings("overloads")
  default <Ex extends Throwable> E width(IOSupplierE<? extends Integer, Ex> pixels) throws IOException, Ex {
    return Width.super.width(pixels);
  }

  /**
   * See <a href="https://www.w3schools.com/tags/att_width.asp">HTML width Attribute</a>.
   *
   * @deprecated  The width attribute is not supported in HTML5. Use CSS instead.
   */
  @Deprecated(forRemoval = false)
  @Override
  @Attributes.Funnel
  default E width(String pixelsOrPercent) throws IOException {
    return Width.super.width(pixelsOrPercent);
  }

  /**
   * See <a href="https://www.w3schools.com/tags/att_width.asp">HTML width Attribute</a>.
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @see #width(java.lang.String)
   *
   * @deprecated  The width attribute is not supported in HTML5. Use CSS instead.
   */
  @Deprecated(forRemoval = false)
  @Override
  @SuppressWarnings("overloads")
  default <Ex extends Throwable> E width(Suppliers.String<Ex> pixelsOrPercent) throws IOException, Ex {
    return Width.super.width(pixelsOrPercent);
  }
}
