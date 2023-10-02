/*
 * ao-fluent-html-any - Base abstract classes and interfaces for Fluent Java DSL for high-performance HTML generation.
 * Copyright (C) 2021, 2022, 2023  AO Industries, Inc.
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
 * <li>See <a href="https://html.spec.whatwg.org/multipage/form-control-infrastructure.html#attr-fs-target">4.10.18.6 Form submission attributes</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/form#attr-target">&lt;form&gt;: The Form element / target</a>.</li>
 * <li>See <a href="https://www.w3schools.com/tags/att_target.asp">HTML target Attribute</a>.</li>
 * </ul>
 *
 * @param  <E>   This element type
 * @param  <V>   This enum type to use for this attribute
 *
 * @author  AO Industries, Inc.
 */
public interface Target<
    E extends Element<?, ?, E> & Target<E, V>,
    V extends Enum<V> & Function<? super AnyDocument<?>, String>
    > {

  /**
   * <p>
   * Utility class for working with {@link Target}.
   * </p>
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/form-control-infrastructure.html#attr-fs-target">4.10.18.6 Form submission attributes</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/form#attr-target">&lt;form&gt;: The Form element / target</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/att_target.asp">HTML target Attribute</a>.</li>
   * </ul>
   */
  public static final class target {
    /** Make no instances. */
    private target() {
      throw new AssertionError();
    }

    /**
     * Normalizes a target attribute.
     *
     * @see  Strings#trimNullIfEmpty(java.lang.String)
     */
    public static String normalize(String target) {
      return Strings.trimNullIfEmpty(target);
    }
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/form-control-infrastructure.html#attr-fs-target">4.10.18.6 Form submission attributes</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/form#attr-target">&lt;form&gt;: The Form element / target</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/att_target.asp">HTML target Attribute</a>.</li>
   * </ul>
   */
  @Attributes.Funnel
  default E target(String target) throws IOException {
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return Attributes.String.attribute(element, "target", MarkupType.NONE, target, Target.target::normalize);
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/form-control-infrastructure.html#attr-fs-target">4.10.18.6 Form submission attributes</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/form#attr-target">&lt;form&gt;: The Form element / target</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/att_target.asp">HTML target Attribute</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @see #target(java.lang.String)
   */
  @SuppressWarnings("overloads")
  default <Ex extends Throwable> E target(Suppliers.String<Ex> target) throws IOException, Ex {
    return target((target == null) ? null : target.get());
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/form-control-infrastructure.html#attr-fs-target">4.10.18.6 Form submission attributes</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/form#attr-target">&lt;form&gt;: The Form element / target</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/att_target.asp">HTML target Attribute</a>.</li>
   * </ul>
   *
   * @see #target(java.lang.String)
   */
  default E target(V target) throws IOException {
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return target((target == null) ? null : target.apply(element.getDocument()));
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/form-control-infrastructure.html#attr-fs-target">4.10.18.6 Form submission attributes</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/form#attr-target">&lt;form&gt;: The Form element / target</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/att_target.asp">HTML target Attribute</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @see #target(java.lang.Enum)
   */
  @SuppressWarnings("overloads")
  default <Ex extends Throwable> E target(IOSupplierE<? extends V, Ex> target) throws IOException, Ex {
    return target((target == null) ? null : target.get());
  }

  /**
   * See <a href="https://html.spec.whatwg.org/multipage/browsers.html#valid-browsing-context-name-or-keyword">7.1.5 Browsing context names</a>.
   */
  public enum Value implements Function<AnyDocument<?>, String> {
    _BLANK("_blank"),
    _SELF("_self"),
    _PARENT("_parent"),
    _TOP("_top");

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
