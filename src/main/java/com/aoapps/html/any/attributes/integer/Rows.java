/*
 * ao-fluent-html-any - Base abstract classes and interfaces for Fluent Java DSL for high-performance HTML generation.
 * Copyright (C) 2022, 2025  AO Industries, Inc.
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
 * See <a href="https://html.spec.whatwg.org/multipage/form-elements.html#attr-textarea-rows">4.10.11 The textarea element / rows</a>.
 *
 * @param  <E>   This element type
 *
 * @author  AO Industries, Inc.
 */
public interface Rows<E extends Element<?, ?, E> & Rows<E>> {

  /**
   * See <a href="https://html.spec.whatwg.org/multipage/form-elements.html#attr-textarea-rows">4.10.11 The textarea element / rows</a>.
   */
  @Attributes.Funnel
  default E rows(int rows) throws IOException {
    @SuppressWarnings("unchecked")
    E element = (E) this;
    Attributes.Integer.attribute(element, "rows", rows);
    return element;
  }

  /**
   * See <a href="https://html.spec.whatwg.org/multipage/form-elements.html#attr-textarea-rows">4.10.11 The textarea element / rows</a>.
   */
  @Attributes.Funnel
  default E rows(Integer rows) throws IOException {
    @SuppressWarnings("unchecked")
    E element = (E) this;
    if (rows != null) {
      Attributes.Integer.attribute(element, "rows", rows);
    }
    return element;
  }

  /**
   * See <a href="https://html.spec.whatwg.org/multipage/form-elements.html#attr-textarea-rows">4.10.11 The textarea element / rows</a>.
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @see #rows(java.lang.Integer)
   */
  default <Ex extends Throwable> E rows(IOSupplierE<Integer, Ex> rows) throws IOException, Ex {
    return rows((rows == null) ? null : rows.get());
  }
}
