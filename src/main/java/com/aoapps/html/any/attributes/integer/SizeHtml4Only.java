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

package com.aoapps.html.any.attributes.integer;

import com.aoapps.html.any.Attributes;
import com.aoapps.html.any.Element;
import com.aoapps.lang.io.function.IOSupplierE;
import java.io.IOException;

/**
 * See <a href="https://www.w3schools.com/tags/att_size.asp">HTML size Attribute</a>.
 *
 * @param  <E>   This element type
 *
 * @deprecated  Not supported in HTML5.
 *
 * @author  AO Industries, Inc.
 */
// Matches Size
@Deprecated(forRemoval = false)
public interface SizeHtml4Only<E extends Element<?, ?, E> & SizeHtml4Only<E>> extends Size<E> {

  /**
   * {@inheritDoc}
   *
   * @deprecated  Not supported in HTML5.
   */
  @Deprecated(forRemoval = false)
  @Override
  @Attributes.Funnel
  default E size(int size) throws IOException {
    return Size.super.size(size);
  }

  /**
   * {@inheritDoc}
   *
   * @deprecated  Not supported in HTML5.
   */
  @Deprecated(forRemoval = false)
  @Override
  @Attributes.Funnel
  default E size(Integer size) throws IOException {
    return Size.super.size(size);
  }

  /**
   * {@inheritDoc}
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @see #size(java.lang.Integer)
   *
   * @deprecated  Not supported in HTML5.
   */
  @Deprecated(forRemoval = false)
  @Override
  default <Ex extends Throwable> E size(IOSupplierE<Integer, Ex> size) throws IOException, Ex {
    return Size.super.size(size);
  }
}
