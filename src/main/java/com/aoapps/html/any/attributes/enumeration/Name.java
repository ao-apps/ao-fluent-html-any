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

package com.aoapps.html.any.attributes.enumeration;

import com.aoapps.hodgepodge.i18n.MarkupType;
import com.aoapps.html.any.AnyDocument;
import com.aoapps.html.any.Attributes;
import com.aoapps.html.any.Element;
import com.aoapps.html.any.Suppliers;
import com.aoapps.lang.Strings;
import com.aoapps.lang.io.function.IOSupplierE;
import java.io.IOException;
import java.util.function.Function;

/**
 * See <a href="https://www.w3schools.com/tags/att_name.asp">HTML name Attribute</a>.
 *
 * @param  <E>   This element type
 * @param  <V>   This enum type to use for this attribute
 *
 * @author  AO Industries, Inc.
 */
public interface Name<
    E extends Element<?, ?, E> & Name<E, V>,
    V extends Enum<V> & Function<? super AnyDocument<?>, String>
    > {

  /**
   * Utility class for working with {@link Name}.
   *
   * <p>See <a href="https://www.w3schools.com/tags/att_name.asp">HTML name Attribute</a>.</p>
   */
  public static final class name {
    /** Make no instances. */
    private name() {
      throw new AssertionError();
    }

    /**
     * Normalizes a name attribute.
     *
     * @see  Strings#trimNullIfEmpty(java.lang.String)
     */
    public static String normalize(String name) {
      // TODO: Is nullIfEmpty correct?  Is an empty name ever valid?
      return Strings.trimNullIfEmpty(name);
    }
  }

  /**
   * See <a href="https://www.w3schools.com/tags/att_name.asp">HTML name Attribute</a>.
   */
  @Attributes.Funnel
  default E name(String name) throws IOException {
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return Attributes.String.attribute(element, "name", MarkupType.NONE, name, Name.name::normalize);
  }

  /**
   * See <a href="https://www.w3schools.com/tags/att_name.asp">HTML name Attribute</a>.
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @see #name(java.lang.String)
   */
  @SuppressWarnings("overloads")
  default <Ex extends Throwable> E name(Suppliers.String<Ex> name) throws IOException, Ex {
    return name((name == null) ? null : name.get());
  }

  /**
   * See <a href="https://www.w3schools.com/tags/att_name.asp">HTML name Attribute</a>.
   *
   * @see #name(java.lang.String)
   */
  default E name(V name) throws IOException {
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return name((name == null) ? null : name.apply(element.getDocument()));
  }

  /**
   * See <a href="https://www.w3schools.com/tags/att_name.asp">HTML name Attribute</a>.
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @see #name(java.lang.Enum)
   */
  @SuppressWarnings("overloads")
  default <Ex extends Throwable> E name(IOSupplierE<V, Ex> name) throws IOException, Ex {
    return name((name == null) ? null : name.get());
  }
}
