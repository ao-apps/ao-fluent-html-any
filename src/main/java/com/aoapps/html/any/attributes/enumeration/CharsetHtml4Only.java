/*
 * ao-fluent-html-any - Base abstract classes and interfaces for Fluent Java DSL for high-performance HTML generation.
 * Copyright (C) 2022, 2023, 2025  AO Industries, Inc.
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
 * @deprecated  Not supported in HTML5.
 *
 * @author  AO Industries, Inc.
 */
// Matches Charset
@Deprecated(forRemoval = false)
public interface CharsetHtml4Only<
    E extends Element<?, ?, E> & CharsetHtml4Only<E, V>,
    V extends Enum<V> & Function<? super AnyDocument<?>, String>
    >
    extends Charset<E, V> {

  /**
   * <ul>
   * <li>See <a href="https://www.w3schools.com/tags/att_charset.asp">HTML charset Attribute</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/meta#attr-charset">&lt;meta&gt;: The metadata element / charset</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/ref_charactersets.asp">HTML Character Sets</a>.</li>
   * </ul>
   *
   * @deprecated  Not supported in HTML5.
   */
  @Deprecated(forRemoval = false)
  @Override
  @Attributes.Funnel
  default E charset(String charset) throws IOException {
    // Not calling super: overridden to support HTML 4
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return Attributes.String.attribute(element, "charset", MarkupType.NONE, charset, Charset.charset::normalize);
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
   * @see #charset(java.lang.String)
   *
   * @deprecated  Not supported in HTML5.
   */
  @Deprecated(forRemoval = false)
  @Override
  @SuppressWarnings("overloads")
  default <Ex extends Throwable> E charset(Suppliers.String<Ex> charset) throws IOException, Ex {
    return Charset.super.charset(charset);
  }

  /**
   * <ul>
   * <li>See <a href="https://www.w3schools.com/tags/att_charset.asp">HTML charset Attribute</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/meta#attr-charset">&lt;meta&gt;: The metadata element / charset</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/ref_charactersets.asp">HTML Character Sets</a>.</li>
   * </ul>
   *
   * @see #charset(java.lang.String)
   *
   * @deprecated  Not supported in HTML5.
   */
  @Deprecated(forRemoval = false)
  @Override
  default E charset(java.nio.charset.Charset charset) throws IOException {
    return Charset.super.charset(charset);
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
   * @see #charset(java.nio.charset.Charset)
   *
   * @deprecated  Not supported in HTML5.
   */
  @Deprecated(forRemoval = false)
  @Override
  @SuppressWarnings("overloads")
  default <Ex extends Throwable> E charset(Suppliers.Charset<Ex> charset) throws IOException, Ex {
    return Charset.super.charset(charset);
  }

  /**
   * <ul>
   * <li>See <a href="https://www.w3schools.com/tags/att_charset.asp">HTML charset Attribute</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/meta#attr-charset">&lt;meta&gt;: The metadata element / charset</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/ref_charactersets.asp">HTML Character Sets</a>.</li>
   * </ul>
   *
   * @see #charset(java.lang.String)
   *
   * @deprecated  Not supported in HTML5.
   */
  @Deprecated(forRemoval = false)
  @Override
  default E charset(V charset) throws IOException {
    return Charset.super.charset(charset);
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
   * @see #charset(java.lang.Enum)
   *
   * @deprecated  Not supported in HTML5.
   */
  @Deprecated(forRemoval = false)
  @Override
  @SuppressWarnings("overloads")
  default <Ex extends Throwable> E charset(IOSupplierE<? extends V, Ex> charset) throws IOException, Ex {
    return Charset.super.charset(charset);
  }
}
