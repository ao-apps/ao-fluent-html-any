/*
 * ao-fluent-html-any - Base abstract classes and interfaces for Fluent Java DSL for high-performance HTML generation.
 * Copyright (C) 2022, 2023, 2024, 2025  AO Industries, Inc.
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

import static com.aoapps.html.any.Attributes.RESOURCES;

import com.aoapps.hodgepodge.i18n.MarkupType;
import com.aoapps.html.any.AnyDocument;
import com.aoapps.html.any.Attributes;
import com.aoapps.html.any.Element;
import com.aoapps.html.any.Suppliers;
import com.aoapps.lang.Strings;
import com.aoapps.lang.io.function.IOSupplierE;
import com.aoapps.lang.validation.InvalidResult;
import com.aoapps.lang.validation.ValidResult;
import com.aoapps.lang.validation.ValidationResult;
import java.io.IOException;
import java.util.Locale;
import java.util.function.Function;

/**
 * See <a href="https://html.spec.whatwg.org/multipage/form-elements.html#attr-textarea-wrap">4.10.11 The textarea element / wrap</a>.
 *
 * @param  <E>   This element type
 * @param  <V>   This enum type to use for this attribute
 *
 * @author  AO Industries, Inc.
 */
public interface Wrap<
    E extends Element<?, ?, E> & Wrap<E, V>,
    V extends Enum<V> & Function<? super AnyDocument<?>, String>
    > {

  /**
   * Utility class for working with {@link Wrap}.
   *
   * <p>See <a href="https://html.spec.whatwg.org/multipage/form-elements.html#attr-textarea-wrap">4.10.11 The textarea element / wrap</a>.</p>
   */
  public static final class wrap {

    /** Make no instances. */
    private wrap() {
      throw new AssertionError();
    }

    /**
     * Normalizes a wrap attribute.
     *
     * @see  Strings#trimNullIfEmpty(java.lang.String)
     * @see  java.lang.String#toLowerCase(java.util.Locale)
     * @see  Locale#ROOT
     */
    public static String normalize(String wrap) {
      wrap = Strings.trimNullIfEmpty(wrap);
      if (wrap != null) {
        wrap = wrap.toLowerCase(Locale.ROOT);
      }
      return wrap;
    }

    /**
     * Validates a wrap attribute.
     * The value should already be {@linkplain wrap#normalize(java.lang.String) normalized}.
     *
     * @see wrap#normalize(java.lang.String)
     */
    public static ValidationResult validate(String wrap) {
      if (
          wrap != null
              && Wrap.Value.getByValue(wrap) == null
      ) {
        return new InvalidResult(
            RESOURCES,
            "Enum.Wrap.invalid",
            wrap
        );
      } else {
        return ValidResult.getInstance();
      }
    }
  }

  /**
   * See <a href="https://html.spec.whatwg.org/multipage/form-elements.html#attr-textarea-wrap">4.10.11 The textarea element / wrap</a>.
   */
  @Attributes.Funnel
  default E wrap(String wrap) throws IOException {
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return Attributes.String.attribute(
        element,
        "wrap",
        MarkupType.NONE,
        wrap,
        Wrap.wrap::normalize,
        Wrap.wrap::validate
    );
  }

  /**
   * See <a href="https://html.spec.whatwg.org/multipage/form-elements.html#attr-textarea-wrap">4.10.11 The textarea element / wrap</a>.
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @see Wrap#wrap(java.lang.String)
   */
  @SuppressWarnings("overloads")
  default <Ex extends Throwable> E wrap(Suppliers.String<Ex> wrap) throws IOException, Ex {
    return wrap((wrap == null) ? null : wrap.get());
  }

  /**
   * See <a href="https://html.spec.whatwg.org/multipage/form-elements.html#attr-textarea-wrap">4.10.11 The textarea element / wrap</a>.
   *
   * @see Wrap#wrap(java.lang.String)
   */
  default E wrap(V wrap) throws IOException {
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return wrap((wrap == null) ? null : wrap.apply(element.getDocument()));
  }

  /**
   * See <a href="https://html.spec.whatwg.org/multipage/form-elements.html#attr-textarea-wrap">4.10.11 The textarea element / wrap</a>.
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @see Wrap#wrap(java.lang.Enum)
   */
  @SuppressWarnings("overloads")
  default <Ex extends Throwable> E wrap(IOSupplierE<V, Ex> wrap) throws IOException, Ex {
    return wrap((wrap == null) ? null : wrap.get());
  }

  /**
   * See <a href="https://html.spec.whatwg.org/multipage/form-elements.html#attr-textarea-wrap">4.10.11 The textarea element / wrap</a>.
   */
  public enum Value implements Function<AnyDocument<?>, String> {
    SOFT("soft"),
    HARD("hard");

    private final String value;

    private Value(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }

    @Override
    public String apply(AnyDocument<?> document) {
      return value;
    }

    public String getValue() {
      return value;
    }

    private static final Value[] values = values();

    /**
     * Gets the enum by value, case-sensitive.
     *
     * @return  The enum or {@code null} when not found.
     */
    public static Value getByValue(String wrap) {
      if (wrap != null) {
        for (Value value : values) {
          if (value.value.equals(wrap)) {
            return value;
          }
        }
      }
      return null;
    }
  }
}
