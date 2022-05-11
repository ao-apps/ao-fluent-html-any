/*
 * ao-fluent-html-any - Base abstract classes and interfaces for Fluent Java DSL for high-performance HTML generation.
 * Copyright (C) 2019, 2020, 2021, 2022  AO Industries, Inc.
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
import com.aoapps.lang.io.function.IOSupplierE;
import java.io.IOException;
import java.util.function.Function;

/**
 * <ul>
 * <li>See <a href="https://www.w3schools.com/tags/att_charset.asp">HTML charset Attribute</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/meta#attr-charset">&lt;meta&gt;: The metadata element / charset</a>.</li>
 * <li>See <a href="https://www.w3schools.com/tags/ref_charactersets.asp">HTML Character Sets</a>.</li>
 * </ul>
 *
 * @param  <E>   This element type
 * @param  <V>   This enum type to use for this attribute
 *
 * @since HTML 5
 *
 * @author  AO Industries, Inc.
 */
// Matches CharsetHtml4Only
public interface Charset<
    E extends Element<?, ?, E> & Charset<E, V>,
    V extends Enum<V> & Function<? super AnyDocument<?>, String>
    > {

  /**
   * <ul>
   * <li>See <a href="https://www.w3schools.com/tags/att_charset.asp">HTML charset Attribute</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/meta#attr-charset">&lt;meta&gt;: The metadata element / charset</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/ref_charactersets.asp">HTML Character Sets</a>.</li>
   * </ul>
   *
   * @since HTML 5
   */
  @Attributes.Funnel
  default E charset(String charset) throws IOException {
    @SuppressWarnings("unchecked")
    E element = (E) this;
    Attributes.onlySupportedInHtml5(element, "charset");
    return Attributes.String.attribute(element, "charset", MarkupType.NONE, charset, true, true);
  }

  /**
   * <ul>
   * <li>See <a href="https://www.w3schools.com/tags/att_charset.asp">HTML charset Attribute</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/meta#attr-charset">&lt;meta&gt;: The metadata element / charset</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/ref_charactersets.asp">HTML Character Sets</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @since HTML 5
   *
   * @see #charset(java.lang.String)
   */
  @SuppressWarnings("overloads")
  default <Ex extends Throwable> E charset(Suppliers.String<Ex> charset) throws IOException, Ex {
    return charset((charset == null) ? null : charset.get());
  }

  /**
   * <ul>
   * <li>See <a href="https://www.w3schools.com/tags/att_charset.asp">HTML charset Attribute</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/meta#attr-charset">&lt;meta&gt;: The metadata element / charset</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/ref_charactersets.asp">HTML Character Sets</a>.</li>
   * </ul>
   *
   * @since HTML 5
   *
   * @see #charset(java.lang.String)
   */
  default E charset(java.nio.charset.Charset charset) throws IOException {
    return charset((charset == null) ? null : charset.name());
  }

  /**
   * <ul>
   * <li>See <a href="https://www.w3schools.com/tags/att_charset.asp">HTML charset Attribute</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/meta#attr-charset">&lt;meta&gt;: The metadata element / charset</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/ref_charactersets.asp">HTML Character Sets</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @since HTML 5
   *
   * @see #charset(java.nio.charset.Charset)
   */
  @SuppressWarnings("overloads")
  default <Ex extends Throwable> E charset(Suppliers.Charset<Ex> charset) throws IOException, Ex {
    return charset((charset == null) ? null : charset.get());
  }

  /**
   * <ul>
   * <li>See <a href="https://www.w3schools.com/tags/att_charset.asp">HTML charset Attribute</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/meta#attr-charset">&lt;meta&gt;: The metadata element / charset</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/ref_charactersets.asp">HTML Character Sets</a>.</li>
   * </ul>
   *
   * @since HTML 5
   *
   * @see #charset(java.lang.String)
   */
  default E charset(V charset) throws IOException {
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return charset((charset == null) ? null : charset.apply(element.getDocument()));
  }

  /**
   * <ul>
   * <li>See <a href="https://www.w3schools.com/tags/att_charset.asp">HTML charset Attribute</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/meta#attr-charset">&lt;meta&gt;: The metadata element / charset</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/ref_charactersets.asp">HTML Character Sets</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @since HTML 5
   *
   * @see #charset(java.lang.Enum)
   */
  @SuppressWarnings("overloads")
  default <Ex extends Throwable> E charset(IOSupplierE<? extends V, Ex> charset) throws IOException, Ex {
    return charset((charset == null) ? null : charset.get());
  }

  /**
   * <ul>
   * <li>See <a href="https://www.w3schools.com/tags/ref_charactersets.asp">HTML Character Sets</a>.</li>
   * <li>See <a href="https://www.iana.org/assignments/character-sets/character-sets.xhtml">Character Sets</a>.</li>
   * </ul>
   */
  public enum Value implements Function<AnyDocument<?>, String> {
    // TODO: Add other charsets here?
    US_ASCII("US-ASCII"),
    ISO_8859_1("ISO-8859-1"),
    UTF_8("UTF-8"),
    WINDOWS_1252("windows-1252");

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
