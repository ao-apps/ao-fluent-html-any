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

import static com.aoapps.encoding.TextInXhtmlAttributeEncoder.textInXhtmlAttributeEncoder;

import com.aoapps.encoding.TextWritable;
import com.aoapps.hodgepodge.i18n.MarkupType;
import com.aoapps.html.any.Attributes;
import com.aoapps.html.any.Element;
import com.aoapps.lang.Coercion;
import com.aoapps.lang.io.function.IOSupplierE;
import java.io.IOException;

/**
 * See <a href="https://www.w3schools.com/tags/att_content.asp">HTML content Attribute</a>.
 *
 * @param  <E>   This element type
 *
 * @author  AO Industries, Inc.
 */
public interface Content<E extends Element<?, ?, E> & Content<E>> {

  /**
   * Utility class for working with {@link Content}.
   *
   * <p>See <a href="https://www.w3schools.com/tags/att_content.asp">HTML content Attribute</a>.</p>
   */
  public static final class content {
    /** Make no instances. */
    private content() {
      throw new AssertionError();
    }

    /**
     * Normalizes a content attribute.
     *
     * @see  Coercion#nullIfEmpty(java.lang.Object)
     */
    public static Object normalize(Object content) {
      return Coercion.nullIfEmpty(content);
    }
  }

  /**
   * See <a href="https://www.w3schools.com/tags/att_content.asp">HTML content Attribute</a>.
   */
  @Attributes.Funnel
  default E content(Object content) throws IOException {
    @SuppressWarnings("unchecked")
    E element = (E) this;
    // TODO: Might be able to perform markup for some types of content (keywords, description, ...)?
    return Attributes.Text.attribute(element, "content", MarkupType.NONE, content, Content.content::normalize,
        textInXhtmlAttributeEncoder);
  }

  /**
   * See <a href="https://www.w3schools.com/tags/att_content.asp">HTML content Attribute</a>.
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @see #content(java.lang.Object)
   */
  default <Ex extends Throwable> E content(IOSupplierE<?, Ex> content) throws IOException, Ex {
    return content((content == null) ? null : content.get());
  }

  /**
   * See <a href="https://www.w3schools.com/tags/att_content.asp">HTML content Attribute</a>.
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @see #content(java.lang.Object)
   */
  default <Ex extends Throwable> E content(TextWritable<Ex> content) throws IOException, Ex {
    return content((Object) content);
  }
}
