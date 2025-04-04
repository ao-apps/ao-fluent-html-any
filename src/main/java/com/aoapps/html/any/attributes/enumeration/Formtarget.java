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
 * <li>See <a href="https://html.spec.whatwg.org/multipage/form-control-infrastructure.html#attr-fs-formtarget">4.10.18.6 Form submission attributes</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/form#attr-target">&lt;form&gt;: The Form element / target</a>.</li>
 * </ul>
 *
 * @param  <E>   This element type
 * @param  <V>   This enum type to use for this attribute
 *
 * @since HTML 5
 *
 * @author  AO Industries, Inc.
 */
public interface Formtarget<
    E extends Element<?, ?, E> & Formtarget<E, V>,
    V extends Enum<V> & Function<? super AnyDocument<?>, String>
    > {

  /**
   * Utility class for working with {@link Formtarget}.
   *
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/form-control-infrastructure.html#attr-fs-formtarget">4.10.18.6 Form submission attributes</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/form#attr-target">&lt;form&gt;: The Form element / target</a>.</li>
   * </ul>
   *
   * @since HTML 5
   */
  public static final class formtarget {
    /** Make no instances. */
    private formtarget() {
      throw new AssertionError();
    }

    /**
     * Normalizes a formtarget attribute.
     *
     * @see  Strings#trimNullIfEmpty(java.lang.String)
     */
    public static String normalize(String formtarget) {
      return Strings.trimNullIfEmpty(formtarget);
    }
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/form-control-infrastructure.html#attr-fs-formtarget">4.10.18.6 Form submission attributes</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/form#attr-target">&lt;form&gt;: The Form element / target</a>.</li>
   * </ul>
   *
   * @since HTML 5
   */
  @Attributes.Funnel
  default E formtarget(String formtarget) throws IOException {
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return Attributes.String.attribute(element, "formtarget", MarkupType.NONE, formtarget,
        Formtarget.formtarget::normalize, value -> Attributes.validateInHtml5(element, "formtarget"));
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/form-control-infrastructure.html#attr-fs-formtarget">4.10.18.6 Form submission attributes</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/form#attr-target">&lt;form&gt;: The Form element / target</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @since HTML 5
   *
   * @see #formtarget(java.lang.String)
   */
  @SuppressWarnings("overloads")
  default <Ex extends Throwable> E formtarget(Suppliers.String<Ex> formtarget) throws IOException, Ex {
    return formtarget((formtarget == null) ? null : formtarget.get());
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/form-control-infrastructure.html#attr-fs-formtarget">4.10.18.6 Form submission attributes</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/form#attr-target">&lt;form&gt;: The Form element / target</a>.</li>
   * </ul>
   *
   * @since HTML 5
   *
   * @see #formtarget(java.lang.String)
   */
  default E formtarget(V formtarget) throws IOException {
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return formtarget((formtarget == null) ? null : formtarget.apply(element.getDocument()));
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/form-control-infrastructure.html#attr-fs-formtarget">4.10.18.6 Form submission attributes</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/form#attr-target">&lt;form&gt;: The Form element / target</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @since HTML 5
   *
   * @see #formtarget(java.lang.Enum)
   */
  @SuppressWarnings("overloads")
  default <Ex extends Throwable> E formtarget(IOSupplierE<V, Ex> formtarget) throws IOException, Ex {
    return formtarget((formtarget == null) ? null : formtarget.get());
  }
}
