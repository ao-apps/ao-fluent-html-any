/*
 * ao-fluent-html-any - Base abstract classes and interfaces for Fluent Java DSL for high-performance HTML generation.
 * Copyright (C) 2021, 2022  AO Industries, Inc.
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

package com.aoapps.html.any.attributes.Enum;

import com.aoapps.hodgepodge.i18n.MarkupType;
import com.aoapps.html.any.AnyDocument;
import com.aoapps.html.any.Attributes;
import com.aoapps.html.any.Element;
import com.aoapps.html.any.Suppliers;
import com.aoapps.lang.io.ContentType;
import com.aoapps.lang.io.function.IOSupplierE;
import java.io.IOException;
import java.util.function.Function;

/**
 * <ul>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/form-control-infrastructure.html#attr-fs-enctype">4.10.18.6 Form submission attributes</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/form#attr-enctype">&lt;form&gt;: The Form element / enctype</a>.</li>
 * <li>See <a href="https://www.w3schools.com/tags/att_enctype.asp">HTML enctype Attribute</a>.</li>
 * </ul>
 *
 * @param  <E>   This element type
 * @param  <V>   This enum type to use for this attribute
 *
 * @author  AO Industries, Inc.
 */
public interface Enctype<
    E extends Element<?, ?, E> & Enctype<E, V>,
    V extends Enum<V> & Function<? super AnyDocument<?>, String>
> {

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/form-control-infrastructure.html#attr-fs-enctype">4.10.18.6 Form submission attributes</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/form#attr-enctype">&lt;form&gt;: The Form element / enctype</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/att_enctype.asp">HTML enctype Attribute</a>.</li>
   * </ul>
   */
  @Attributes.Funnel
  default E enctype(String enctype) throws IOException {
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return Attributes.String.attribute(element, "enctype", MarkupType.NONE, enctype, true, true);
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/form-control-infrastructure.html#attr-fs-enctype">4.10.18.6 Form submission attributes</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/form#attr-enctype">&lt;form&gt;: The Form element / enctype</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/att_enctype.asp">HTML enctype Attribute</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @see #enctype(java.lang.String)
   */
  @SuppressWarnings("overloads")
  default <Ex extends Throwable> E enctype(Suppliers.String<Ex> enctype) throws IOException, Ex {
    return enctype((enctype == null) ? null : enctype.get());
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/form-control-infrastructure.html#attr-fs-enctype">4.10.18.6 Form submission attributes</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/form#attr-enctype">&lt;form&gt;: The Form element / enctype</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/att_enctype.asp">HTML enctype Attribute</a>.</li>
   * </ul>
   *
   * @see #enctype(java.lang.String)
   */
  default E enctype(V enctype) throws IOException {
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return enctype((enctype == null) ? null : enctype.apply(element.getDocument()));
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/form-control-infrastructure.html#attr-fs-enctype">4.10.18.6 Form submission attributes</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/form#attr-enctype">&lt;form&gt;: The Form element / enctype</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/att_enctype.asp">HTML enctype Attribute</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @see #enctype(java.lang.Enum)
   */
  @SuppressWarnings("overloads")
  default <Ex extends Throwable> E enctype(IOSupplierE<? extends V, Ex> enctype) throws IOException, Ex {
    return enctype((enctype == null) ? null : enctype.get());
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/form-control-infrastructure.html#attr-fs-enctype">4.10.18.6 Form submission attributes</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/form#attr-enctype">&lt;form&gt;: The Form element / enctype</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/att_enctype.asp">HTML enctype Attribute</a>.</li>
   * </ul>
   */
  public enum Value implements Function<AnyDocument<?>, String> {
    X_WWW_FORM_URLENCODED(ContentType.X_WWW_FORM_URLENCODED),
    FORM_DATA(ContentType.FORM_DATA),
    /**
     * See <a href="https://html.spec.whatwg.org/multipage/form-control-infrastructure.html#plain-text-form-data">4.10.21.8 Plain text form data</a>.
     */
    TEXT(ContentType.TEXT);

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
