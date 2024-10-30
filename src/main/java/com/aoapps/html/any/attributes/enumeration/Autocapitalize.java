/*
 * ao-fluent-html-any - Base abstract classes and interfaces for Fluent Java DSL for high-performance HTML generation.
 * Copyright (C) 2022, 2023, 2024  AO Industries, Inc.
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

import com.aoapps.html.any.AnyDocument;
import com.aoapps.html.any.Attributes;
import com.aoapps.html.any.Element;
import com.aoapps.html.any.GlobalAttributes;
import com.aoapps.html.any.Suppliers;
import com.aoapps.lang.Strings;
import com.aoapps.lang.io.function.IOSupplierE;
import java.io.IOException;
import java.util.function.Function;

/**
 * <ul>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/interaction.html#autocapitalization">6.8.6 Autocapitalization</a>.</li>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:attr-autocapitalize">3.2.6 Global attributes / autocapitalize</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/autocapitalize">Global attributes / autocapitalize</a>.</li>
 * </ul>
 *
 * <p>Note: Enum type cannot be parameterized because this is a {@linkplain GlobalAttributes global attribute}.</p>
 *
 * @param  <E>   This element type
 *
 * @since HTML 5
 *
 * @author  AO Industries, Inc.
 */
// Matches AutocapitalizeUnexpected
@SuppressWarnings("deprecation")
public interface Autocapitalize<E extends Element<?, ?, E> & Autocapitalize<E>> extends AutocapitalizeUnexpected<E> {

  /**
   * Utility class for working with {@link Autocapitalize}.
   *
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/interaction.html#autocapitalization">6.8.6 Autocapitalization</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:attr-autocapitalize">3.2.6 Global attributes / autocapitalize</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/autocapitalize">Global attributes / autocapitalize</a>.</li>
   * </ul>
   *
   * @since HTML 5
   */
  public static final class autocapitalize {
    /** Make no instances. */
    private autocapitalize() {
      throw new AssertionError();
    }

    /**
     * Normalizes an autocapitalize attribute.
     *
     * @see  Strings#trimNullIfEmpty(java.lang.String)
     */
    public static String normalize(String autocapitalize) {
      return Strings.trimNullIfEmpty(autocapitalize);
    }
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/interaction.html#autocapitalization">6.8.6 Autocapitalization</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:attr-autocapitalize">3.2.6 Global attributes / autocapitalize</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/autocapitalize">Global attributes / autocapitalize</a>.</li>
   * </ul>
   *
   * @since HTML 5
   */
  @Override
  @Attributes.Funnel
  default E autocapitalize(String autocapitalize) throws IOException {
    return AutocapitalizeUnexpected.super.autocapitalize(autocapitalize);
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/interaction.html#autocapitalization">6.8.6 Autocapitalization</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:attr-autocapitalize">3.2.6 Global attributes / autocapitalize</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/autocapitalize">Global attributes / autocapitalize</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @since HTML 5
   *
   * @see #autocapitalize(java.lang.String)
   */
  @Override
  @SuppressWarnings("overloads")
  default <Ex extends Throwable> E autocapitalize(Suppliers.String<Ex> autocapitalize) throws IOException, Ex {
    return AutocapitalizeUnexpected.super.autocapitalize(autocapitalize);
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/interaction.html#autocapitalization">6.8.6 Autocapitalization</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:attr-autocapitalize">3.2.6 Global attributes / autocapitalize</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/autocapitalize">Global attributes / autocapitalize</a>.</li>
   * </ul>
   *
   * @since HTML 5
   *
   * @see #autocapitalize(java.lang.String)
   */
  @Override
  default E autocapitalize(Value autocapitalize) throws IOException {
    return AutocapitalizeUnexpected.super.autocapitalize(autocapitalize);
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/interaction.html#autocapitalization">6.8.6 Autocapitalization</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:attr-autocapitalize">3.2.6 Global attributes / autocapitalize</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/autocapitalize">Global attributes / autocapitalize</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @since HTML 5
   *
   * @see #autocapitalize(com.aoapps.html.any.attributes.enumeration.Autocapitalize.Value)
   */
  @Override
  @SuppressWarnings("overloads")
  default <Ex extends Throwable> E autocapitalize(IOSupplierE<? extends Value, Ex> autocapitalize) throws IOException, Ex {
    return AutocapitalizeUnexpected.super.autocapitalize(autocapitalize);
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/interaction.html#autocapitalization">6.8.6 Autocapitalization</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:attr-autocapitalize">3.2.6 Global attributes / autocapitalize</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/autocapitalize">Global attributes / autocapitalize</a>.</li>
   * </ul>
   *
   * @since HTML 5
   */
  public enum Value implements Function<AnyDocument<?>, String> {
    /**
     * No autocapitalization is applied (all letters default to lowercase).
     *
     * @deprecated  Please use {@link #NONE} as it is more descriptive
     */
    @Deprecated
      OFF("off"),

    /**
     * No autocapitalization is applied (all letters default to lowercase).
     */
    NONE("none"),

    /**
     * The first letter of each sentence defaults to a capital letter; all other letters default to lowercase.
     *
     * @deprecated  Please use {@link #SENTENCES} as it is more descriptive
     */
    @Deprecated
        ON("on"),

    /**
     * The first letter of each sentence defaults to a capital letter; all other letters default to lowercase.
     */
    SENTENCES("sentences"),

    /**
     * The first letter of each word defaults to a capital letter; all other letters default to lowercase.
     */
    WORDS("words"),

    /**
     * All letters should default to uppercase.
     */
    CHARACTERS("characters");

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
  }
}
