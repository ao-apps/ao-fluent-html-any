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
 * <ul>
 * <li>See <a href="https://www.w3schools.com/tags/att_maxlength.asp">HTML maxlength Attribute</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input#htmlattrdefmaxlength">&lt;input&gt;: The Input (Form Input) element</a>.</li>
 * </ul>
 *
 * @param  <E>   This element type
 *
 * @author  AO Industries, Inc.
 */
public interface Maxlength<E extends Element<?, ?, E> & Maxlength<E>> {

  /**
   * See <a href="https://www.w3schools.com/tags/att_maxlength.asp">HTML maxlength Attribute</a>.
   */
  @Attributes.Funnel
  default E maxlength(int maxlength) throws IOException {
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return Attributes.Integer.attribute(element, "maxlength", maxlength);
  }

  /**
   * See <a href="https://www.w3schools.com/tags/att_maxlength.asp">HTML maxlength Attribute</a>.
   */
  @Attributes.Funnel
  default E maxlength(Integer maxlength) throws IOException {
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return Attributes.Integer.attribute(element, "maxlength", maxlength);
  }

  /**
   * See <a href="https://www.w3schools.com/tags/att_maxlength.asp">HTML maxlength Attribute</a>.
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @see #maxlength(java.lang.Integer)
   */
  default <Ex extends Throwable> E maxlength(IOSupplierE<Integer, Ex> maxlength) throws IOException, Ex {
    return maxlength((maxlength == null) ? null : maxlength.get());
  }
}
