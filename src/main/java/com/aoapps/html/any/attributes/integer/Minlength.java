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

package com.aoapps.html.any.attributes.integer;

import com.aoapps.html.any.Attributes;
import com.aoapps.html.any.Element;
import com.aoapps.lang.io.function.IOSupplierE;
import java.io.IOException;

/**
 * See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input#htmlattrdefminlength">&lt;input&gt;: The Input (Form Input) element</a>.
 *
 * @param  <E>   This element type
 *
 * @since HTML 5
 *
 * @author  AO Industries, Inc.
 */
public interface Minlength<E extends Element<?, ?, E> & Minlength<E>> {

  /**
   * See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input#htmlattrdefminlength">&lt;input&gt;: The Input (Form Input) element</a>.
   *
   * @since HTML 5
   */
  @Attributes.Funnel
  default E minlength(int minlength) throws IOException {
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return Attributes.Integer.attribute(element, "minlength", minlength,
        value -> Attributes.validateInHtml5(element, "minlength"));
  }

  /**
   * See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input#htmlattrdefminlength">&lt;input&gt;: The Input (Form Input) element</a>.
   *
   * @since HTML 5
   */
  @Attributes.Funnel
  default E minlength(Integer minlength) throws IOException {
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return Attributes.Integer.attribute(element, "minlength", minlength,
        value -> Attributes.validateInHtml5(element, "minlength"));
  }

  /**
   * See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input#htmlattrdefminlength">&lt;input&gt;: The Input (Form Input) element</a>.
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @since HTML 5
   *
   * @see #minlength(java.lang.Integer)
   */
  default <Ex extends Throwable> E minlength(IOSupplierE<? extends Integer, Ex> minlength) throws IOException, Ex {
    return minlength((minlength == null) ? null : minlength.get());
  }
}
