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

package com.aoapps.html.any.attributes.integer;

import com.aoapps.html.any.Attributes;
import com.aoapps.html.any.Element;
import com.aoapps.lang.io.function.IOSupplierE;
import java.io.IOException;

/**
 * See <a href="https://www.w3schools.com/tags/att_height.asp">HTML height Attribute</a>.
 *
 * @param  <E>   This element type
 *
 * @since HTML 5
 *
 * @author  AO Industries, Inc.
 */
// Matches Height
public interface HeightHtml5Only<E extends Element<?, ?, E> & HeightHtml5Only<E>> extends Height<E> {

  /**
   * {@inheritDoc}
   *
   * <p>The height attribute is new in HTML5.</p>
   *
   * @since HTML 5
   */
  @Override
  @Attributes.Funnel
  default E height(int pixels) throws IOException {
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return Attributes.Integer.attribute(element, "height", pixels,
        value -> Attributes.validateInHtml5(element, "height"));
  }

  /**
   * {@inheritDoc}
   *
   * <p>The height attribute is new in HTML5.</p>
   *
   * @since HTML 5
   */
  @Override
  @Attributes.Funnel
  default E height(Integer pixels) throws IOException {
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return Attributes.Integer.attribute(element, "height", pixels,
        value -> Attributes.validateInHtml5(element, "height"));
  }

  /**
   * {@inheritDoc}
   *
   * <p>The height attribute is new in HTML5.</p>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @since HTML 5
   *
   * @see #height(java.lang.Integer)
   */
  @Override
  default <Ex extends Throwable> E height(IOSupplierE<Integer, Ex> pixels) throws IOException, Ex {
    return Height.super.height(pixels);
  }
}
