/*
 * ao-fluent-html-any - Base abstract classes and interfaces for Fluent Java DSL for high-performance HTML generation.
 * Copyright (C) 2021, 2022, 2023, 2024, 2025  AO Industries, Inc.
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
 * <ul>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/form-control-infrastructure.html#attr-fs-formenctype">4.10.18.6 Form submission attributes</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/form#attr-enctype">&lt;form&gt;: The Form element / enctype</a>.</li>
 * </ul>
 *
 * @param  <E>   This element type
 * @param  <V>   This enum type to use for this attribute
 *
 * @since HTML 5
 *
 * @author  AO Industries, Inc.
 */
public interface Formenctype<
    E extends Element<?, ?, E> & Formenctype<E, V>,
    V extends Enum<V> & Function<? super AnyDocument<?>, String>
    > {

  /**
   * Utility class for working with {@link Formenctype}.
   *
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/form-control-infrastructure.html#attr-fs-formenctype">4.10.18.6 Form submission attributes</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/form#attr-enctype">&lt;form&gt;: The Form element / enctype</a>.</li>
   * </ul>
   *
   * @since HTML 5
   */
  public static final class formenctype {
    /** Make no instances. */
    private formenctype() {
      throw new AssertionError();
    }

    /**
     * Normalizes a formenctype attribute.
     *
     * @see  Strings#trimNullIfEmpty(java.lang.String)
     */
    public static String normalize(String formenctype) {
      return Strings.trimNullIfEmpty(formenctype);
    }
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/form-control-infrastructure.html#attr-fs-formenctype">4.10.18.6 Form submission attributes</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/form#attr-enctype">&lt;form&gt;: The Form element / enctype</a>.</li>
   * </ul>
   *
   * @since HTML 5
   */
  @Attributes.Funnel
  default E formenctype(String formenctype) throws IOException {
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return Attributes.String.attribute(element, "formenctype", MarkupType.NONE, formenctype,
        Formenctype.formenctype::normalize, value -> Attributes.validateInHtml5(element, "formenctype"));
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/form-control-infrastructure.html#attr-fs-formenctype">4.10.18.6 Form submission attributes</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/form#attr-enctype">&lt;form&gt;: The Form element / enctype</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @since HTML 5
   *
   * @see Formenctype#formenctype(java.lang.String)
   */
  @SuppressWarnings("overloads")
  default <Ex extends Throwable> E formenctype(Suppliers.String<Ex> formenctype) throws IOException, Ex {
    return formenctype((formenctype == null) ? null : formenctype.get());
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/form-control-infrastructure.html#attr-fs-formenctype">4.10.18.6 Form submission attributes</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/form#attr-enctype">&lt;form&gt;: The Form element / enctype</a>.</li>
   * </ul>
   *
   * @since HTML 5
   *
   * @see Formenctype#formenctype(java.lang.String)
   */
  default E formenctype(V formenctype) throws IOException {
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return formenctype((formenctype == null) ? null : formenctype.apply(element.getDocument()));
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/form-control-infrastructure.html#attr-fs-formenctype">4.10.18.6 Form submission attributes</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/form#attr-enctype">&lt;form&gt;: The Form element / enctype</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @since HTML 5
   *
   * @see Formenctype#formenctype(java.lang.Enum)
   */
  @SuppressWarnings("overloads")
  default <Ex extends Throwable> E formenctype(IOSupplierE<V, Ex> formenctype) throws IOException, Ex {
    return formenctype((formenctype == null) ? null : formenctype.get());
  }
}
