/*
 * ao-fluent-html-any - Base abstract classes and interfaces for Fluent Java DSL for high-performance HTML generation.
 * Copyright (C) 2021, 2022, 2025  AO Industries, Inc.
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
 * See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/table#attr-border">&lt;table&gt;: The Table element / border</a>.
 *
 * @param  <E>   This element type
 *
 * @deprecated  The border attribute is not supported in HTML5. Use CSS instead.
 *
 * @author  AO Industries, Inc.
 */
@Deprecated(forRemoval = false)
public interface Border<E extends Element<?, ?, E> & Border<E>> {

  /**
   * See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/table#attr-border">&lt;table&gt;: The Table element / border</a>.
   *
   * @deprecated  The border attribute is not supported in HTML5. Use CSS instead.
   */
  @Deprecated(forRemoval = false)
  @Attributes.Funnel
  default E border(int border) throws IOException {
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return Attributes.Dimension.attribute(element, "border", border);
  }

  /**
   * See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/table#attr-border">&lt;table&gt;: The Table element / border</a>.
   *
   * @deprecated  The border attribute is not supported in HTML5. Use CSS instead.
   */
  @Deprecated(forRemoval = false)
  @Attributes.Funnel
  default E border(Integer border) throws IOException {
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return Attributes.Dimension.attribute(element, "border", border);
  }

  /**
   * See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/table#attr-border">&lt;table&gt;: The Table element / border</a>.
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @deprecated  The border attribute is not supported in HTML5. Use CSS instead.
   */
  @Deprecated(forRemoval = false)
  @SuppressWarnings("overloads")
  default <Ex extends Throwable> E border(IOSupplierE<Integer, Ex> border) throws IOException, Ex {
    return border((border == null) ? null : border.get());
  }
}
