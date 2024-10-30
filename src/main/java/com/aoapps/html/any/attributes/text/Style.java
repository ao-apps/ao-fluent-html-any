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

import static com.aoapps.encoding.StyleInXhtmlAttributeEncoder.styleInXhtmlAttributeEncoder;

import com.aoapps.encoding.StyleWritable;
import com.aoapps.hodgepodge.i18n.MarkupType;
import com.aoapps.html.any.Attributes;
import com.aoapps.html.any.Element;
import com.aoapps.lang.Coercion;
import com.aoapps.lang.io.function.IOSupplierE;
import java.io.IOException;

/**
 * <ul>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#the-style-attribute">3.2.6.5 The style attribute</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/style">Global attributes / style</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/style">HTMLElement.style</a>.</li>
 * <li>See <a href="https://www.w3schools.com/tags/att_global_style.asp">HTML style Attribute</a>.</li>
 * </ul>
 * <blockquote>
 * In HTML5, the style attribute can be used on <b>any</b> HTML element (it will validate on any HTML element. However, it is not necessarily useful).
 * </blockquote>
 *
 * @param  <E>   This element type
 *
 * @author  AO Industries, Inc.
 */
// Matches StyleNoHtml4
public interface Style<E extends Element<?, ?, E> & Style<E>> {

  /**
   * Utility class for working with {@link Style}.
   *
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#the-style-attribute">3.2.6.5 The style attribute</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/style">Global attributes / style</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/style">HTMLElement.style</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/att_global_style.asp">HTML style Attribute</a>.</li>
   * </ul>
   */
  public static final class style {
    /** Make no instances. */
    private style() {
      throw new AssertionError();
    }

    /**
     * Normalizes a style attribute.
     *
     * @see  Coercion#trimNullIfEmpty(java.lang.Object)
     */
    public static Object normalize(Object style) {
      return Coercion.trimNullIfEmpty(style);
    }
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#the-style-attribute">3.2.6.5 The style attribute</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/style">Global attributes / style</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/style">HTMLElement.style</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/att_global_style.asp">HTML style Attribute</a>.</li>
   * </ul>
   * <blockquote>
   * In HTML5, the style attribute can be used on <b>any</b> HTML element (it will validate on any HTML element. However, it is not necessarily useful).
   * </blockquote>
   */
  @Attributes.Funnel
  default E style(Object style) throws IOException {
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return Attributes.Text.attribute(element, "style", MarkupType.CSS, style, Style.style::normalize,
        styleInXhtmlAttributeEncoder);
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#the-style-attribute">3.2.6.5 The style attribute</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/style">Global attributes / style</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/style">HTMLElement.style</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/att_global_style.asp">HTML style Attribute</a>.</li>
   * </ul>
   * <blockquote>
   * In HTML5, the style attribute can be used on <b>any</b> HTML element (it will validate on any HTML element. However, it is not necessarily useful).
   * </blockquote>
   *
   * @param  style  Multiple styles will be semicolon-separated.
   */
  @Attributes.Funnel
  default E style(Object ... style) throws IOException {
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return Attributes.Text.attribute(element, "style", MarkupType.CSS, style, ";", Style.style::normalize,
        styleInXhtmlAttributeEncoder);
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#the-style-attribute">3.2.6.5 The style attribute</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/style">Global attributes / style</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/style">HTMLElement.style</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/att_global_style.asp">HTML style Attribute</a>.</li>
   * </ul>
   * <blockquote>
   * In HTML5, the style attribute can be used on <b>any</b> HTML element (it will validate on any HTML element. However, it is not necessarily useful).
   * </blockquote>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @see #style(java.lang.Object)
   */
  default <Ex extends Throwable> E style(IOSupplierE<?, Ex> style) throws IOException, Ex {
    return style((style == null) ? null : style.get());
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#the-style-attribute">3.2.6.5 The style attribute</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/style">Global attributes / style</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/style">HTMLElement.style</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/att_global_style.asp">HTML style Attribute</a>.</li>
   * </ul>
   * <blockquote>
   * In HTML5, the style attribute can be used on <b>any</b> HTML element (it will validate on any HTML element. However, it is not necessarily useful).
   * </blockquote>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @see #style(java.lang.Object)
   */
  default <Ex extends Throwable> E style(StyleWritable<Ex> style) throws IOException, Ex {
    return style((Object) style);
  }
}
