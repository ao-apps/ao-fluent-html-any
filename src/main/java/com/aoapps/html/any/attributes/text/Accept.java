/*
 * ao-fluent-html-any - Base abstract classes and interfaces for Fluent Java DSL for high-performance HTML generation.
 * Copyright (C) 2019, 2020, 2021, 2022, 2023, 2024  AO Industries, Inc.
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

import static com.aoapps.encoding.TextInXhtmlAttributeEncoder.textInXhtmlAttributeEncoder;

import com.aoapps.encoding.TextWritable;
import com.aoapps.hodgepodge.i18n.MarkupType;
import com.aoapps.html.any.Attributes;
import com.aoapps.html.any.Element;
import com.aoapps.lang.Coercion;
import com.aoapps.lang.io.function.IOSupplierE;
import java.io.IOException;

/**
 * See <a href="https://www.w3schools.com/tags/att_accept.asp">HTML accept Attribute</a>.
 *
 * @param  <E>   This element type
 *
 * @author  AO Industries, Inc.
 */
public interface Accept<E extends Element<?, ?, E> & Accept<E>> {

  /**
   * Utility class for working with {@link Accept}.
   *
   * <p>See <a href="https://www.w3schools.com/tags/att_accept.asp">HTML accept Attribute</a>.</p>
   */
  public static final class accept {
    /** Make no instances. */
    private accept() {
      throw new AssertionError();
    }

    /**
     * Normalizes an accept attribute.
     *
     * @see  Coercion#trimNullIfEmpty(java.lang.Object)
     */
    public static Object normalize(Object accept) {
      return Coercion.trimNullIfEmpty(accept);
    }
  }

  /**
   * See <a href="https://www.w3schools.com/tags/att_accept.asp">HTML accept Attribute</a>.
   */
  @Attributes.Funnel
  default E accept(Object accept) throws IOException {
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return Attributes.Text.attribute(element, "accept", MarkupType.NONE, accept, Accept.accept::normalize,
        textInXhtmlAttributeEncoder);
  }

  /**
   * See <a href="https://www.w3schools.com/tags/att_accept.asp">HTML accept Attribute</a>.
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @see #accept(java.lang.Object)
   */
  default <Ex extends Throwable> E accept(IOSupplierE<?, Ex> accept) throws IOException, Ex {
    return accept((accept == null) ? null : accept.get());
  }

  /**
   * See <a href="https://www.w3schools.com/tags/att_accept.asp">HTML accept Attribute</a>.
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @see #accept(java.lang.Object)
   */
  default <Ex extends Throwable> E accept(TextWritable<Ex> accept) throws IOException, Ex {
    return accept((Object) accept);
  }
}
