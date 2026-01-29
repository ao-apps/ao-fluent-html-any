/*
 * ao-fluent-html-any - Base abstract classes and interfaces for Fluent Java DSL for high-performance HTML generation.
 * Copyright (C) 2021, 2022, 2023, 2024  AO Industries, Inc.
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
 * See <a href="https://html.spec.whatwg.org/multipage/iframe-embed-object.html#attr-object-type">4.8.7 The object element / type</a>.
 *
 * @param  <E>   This element type
 *
 * @author  AO Industries, Inc.
 */
public interface Type<E extends Element<?, ?, E> & Type<E>> {

  /**
   * Utility class for working with {@link Type}.
   *
   * <p>See <a href="https://html.spec.whatwg.org/multipage/iframe-embed-object.html#attr-object-type">4.8.7 The object element / type</a>.</p>
   */
  public static final class type {
    /** Make no instances. */
    private type() {
      throw new AssertionError();
    }

    /**
     * Normalizes a type attribute.
     *
     * @see  Coercion#trimNullIfEmpty(java.lang.Object)
     */
    public static Object normalize(Object type) {
      return Coercion.trimNullIfEmpty(type);
    }
  }

  /**
   * See <a href="https://html.spec.whatwg.org/multipage/iframe-embed-object.html#attr-object-type">4.8.7 The object element / type</a>.
   */
  @Attributes.Funnel
  default E type(Object type) throws IOException {
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return Attributes.Text.attribute(element, "type", MarkupType.NONE, type, Type.type::normalize,
        textInXhtmlAttributeEncoder);
  }

  /**
   * See <a href="https://html.spec.whatwg.org/multipage/iframe-embed-object.html#attr-object-type">4.8.7 The object element / type</a>.
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @see Type#type(java.lang.Object)
   */
  default <Ex extends Throwable> E type(IOSupplierE<?, Ex> type) throws IOException, Ex {
    return type((type == null) ? null : type.get());
  }

  /**
   * See <a href="https://html.spec.whatwg.org/multipage/iframe-embed-object.html#attr-object-type">4.8.7 The object element / type</a>.
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @see Type#type(java.lang.Object)
   */
  default <Ex extends Throwable> E type(TextWritable<Ex> type) throws IOException, Ex {
    return type((Object) type);
  }
}
