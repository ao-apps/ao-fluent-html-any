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

package com.aoapps.html.any.attributes.text;

import static com.aoapps.encoding.TextInXhtmlAttributeEncoder.textInXhtmlAttributeEncoder;

import com.aoapps.encoding.TextWritable;
import com.aoapps.hodgepodge.i18n.MarkupType;
import com.aoapps.html.any.Attributes;
import com.aoapps.html.any.Element;
import com.aoapps.html.any.Suppliers;
import com.aoapps.lang.Coercion;
import com.aoapps.lang.io.function.IOSupplierE;
import java.io.IOException;
import java.util.Locale;

/**
 * <ul>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#the-lang-and-xml:lang-attributes">3.2.6.2 The lang and xml:lang attributes</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/lang">Global attributes / lang</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/lang">HTMLElement.lang</a>.</li>
 * <li>See <a href="https://www.w3schools.com/tags/att_global_lang.asp">HTML lang Attribute</a>.</li>
 * </ul>
 *
 * @param  <E>   This element type
 *
 * @author  AO Industries, Inc.
 */
// Idea: ThreadLocale could be leveraged to automatically add lang attributes when current language has changed.
//       But this would begin to change the nature of this API.
public interface Lang<E extends Element<?, ?, E> & Lang<E>> {

  /**
   * <p>
   * Utility class for working with {@link Lang}.
   * </p>
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#the-lang-and-xml:lang-attributes">3.2.6.2 The lang and xml:lang attributes</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/lang">Global attributes / lang</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/lang">HTMLElement.lang</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/att_global_lang.asp">HTML lang Attribute</a>.</li>
   * </ul>
   */
  public static final class lang {
    /** Make no instances. */
    private lang() {
      throw new AssertionError();
    }

    /**
     * Normalizes a lang attribute.
     *
     * @see  Coercion#trimNullIfEmpty(java.lang.Object)
     */
    public static Object normalize(Object lang) {
      return Coercion.trimNullIfEmpty(lang);
    }
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#the-lang-and-xml:lang-attributes">3.2.6.2 The lang and xml:lang attributes</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/lang">Global attributes / lang</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/lang">HTMLElement.lang</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/att_global_lang.asp">HTML lang Attribute</a>.</li>
   * </ul>
   */
  @Attributes.Funnel
  default E lang(Object lang) throws IOException {
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return Attributes.Text.attribute(element, "lang", MarkupType.NONE, lang, Lang.lang::normalize,
        textInXhtmlAttributeEncoder);
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#the-lang-and-xml:lang-attributes">3.2.6.2 The lang and xml:lang attributes</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/lang">Global attributes / lang</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/lang">HTMLElement.lang</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/att_global_lang.asp">HTML lang Attribute</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @see #lang(java.lang.Object)
   */
  @SuppressWarnings("overloads")
  default <Ex extends Throwable> E lang(IOSupplierE<?, Ex> lang) throws IOException, Ex {
    return lang((lang == null) ? null : lang.get());
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#the-lang-and-xml:lang-attributes">3.2.6.2 The lang and xml:lang attributes</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/lang">Global attributes / lang</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/lang">HTMLElement.lang</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/att_global_lang.asp">HTML lang Attribute</a>.</li>
   * </ul>
   *
   * @see #lang(java.lang.Object)
   */
  default E lang(Locale lang) throws IOException {
    return lang((lang == null) ? null : lang.toLanguageTag());
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#the-lang-and-xml:lang-attributes">3.2.6.2 The lang and xml:lang attributes</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/lang">Global attributes / lang</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/lang">HTMLElement.lang</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/att_global_lang.asp">HTML lang Attribute</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @see #lang(java.util.Locale)
   */
  @SuppressWarnings("overloads")
  default <Ex extends Throwable> E lang(Suppliers.Locale<Ex> lang) throws IOException, Ex {
    return lang((lang == null) ? null : lang.get());
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#the-lang-and-xml:lang-attributes">3.2.6.2 The lang and xml:lang attributes</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/lang">Global attributes / lang</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/lang">HTMLElement.lang</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/att_global_lang.asp">HTML lang Attribute</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @see #lang(java.lang.Object)
   */
  default <Ex extends Throwable> E lang(TextWritable<Ex> lang) throws IOException, Ex {
    return lang((Object) lang);
  }
}
