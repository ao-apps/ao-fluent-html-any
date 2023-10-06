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
 * See <a href="https://www.w3schools.com/tags/att_name.asp">HTML name Attribute</a>.
 *
 * @param  <E>   This element type
 *
 * @author  AO Industries, Inc.
 */
public interface Name<E extends Element<?, ?, E> & Name<E>> {

  /**
   * <p>
   * Utility class for working with {@link Name}.
   * </p>
   * <p>
   * See <a href="https://www.w3schools.com/tags/att_name.asp">HTML name Attribute</a>.
   * </p>
   */
  public static final class name {
    /** Make no instances. */
    private name() {
      throw new AssertionError();
    }

    /**
     * Normalizes a name attribute.
     * <p>
     * TODO: Review if trim-to-null is the best default.
     * Maybe default to {@code false} and override where should be {@code true} instead.
     * Any change to textarea/input name attribute would also need to be reflected in dirname attribute.
     * </p>
     *
     * @see  Coercion#nullIfEmpty(java.lang.Object)
     */
    // Note: Dirname.dirname.normalize delegates to this method
    public static Object normalize(Object name) {
      return Coercion.nullIfEmpty(name);
    }
  }

  /**
   * See <a href="https://www.w3schools.com/tags/att_name.asp">HTML name Attribute</a>.
   */
  @Attributes.Funnel
  default E name(Object name) throws IOException {
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return Attributes.Text.attribute(element, "name", MarkupType.NONE, name, Name.name::normalize,
        textInXhtmlAttributeEncoder);
  }

  /**
   * See <a href="https://www.w3schools.com/tags/att_name.asp">HTML name Attribute</a>.
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @see #name(java.lang.Object)
   */
  default <Ex extends Throwable> E name(IOSupplierE<?, Ex> name) throws IOException, Ex {
    return name((name == null) ? null : name.get());
  }

  /**
   * See <a href="https://www.w3schools.com/tags/att_name.asp">HTML name Attribute</a>.
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @see #name(java.lang.Object)
   */
  default <Ex extends Throwable> E name(TextWritable<Ex> name) throws IOException, Ex {
    return name((Object) name);
  }
}
