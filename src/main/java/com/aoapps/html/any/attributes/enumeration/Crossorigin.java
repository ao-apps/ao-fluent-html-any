/*
 * ao-fluent-html-any - Base abstract classes and interfaces for Fluent Java DSL for high-performance HTML generation.
 * Copyright (C) 2019, 2020, 2021, 2022, 2023  AO Industries, Inc.
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

import com.aoapps.encoding.Serialization;
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
 * See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Attributes/crossorigin">The crossorigin attribute: Requesting CORS access to content</a>.
 *
 * @param  <E>   This element type
 *
 * @since HTML 5
 *
 * @author  AO Industries, Inc.
 */
public interface Crossorigin<E extends Element<?, ?, E> & Crossorigin<E>> {

  /**
   * <p>
   * Utility class for working with {@link Crossorigin}.
   * </p>
   * <p>
   * See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Attributes/crossorigin">The crossorigin attribute: Requesting CORS access to content</a>.
   * </p>
   *
   * @since HTML 5
   */
  public static final class crossorigin {
    /** Make no instances. */
    private crossorigin() {
      throw new AssertionError();
    }

    /**
     * Normalizes a crossorigin attribute.
     *
     * @see  Strings#trimNullIfEmpty(java.lang.String)
     */
    public static String normalize(String crossorigin) {
      return Strings.trimNullIfEmpty(crossorigin);
    }
  }

  /**
   * See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Attributes/crossorigin">The crossorigin attribute: Requesting CORS access to content</a>.
   *
   * @since HTML 5
   */
  @Attributes.Funnel
  default E crossorigin(String crossorigin) throws IOException {
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return Attributes.String.attribute(element, "crossorigin", MarkupType.NONE, crossorigin,
        Crossorigin.crossorigin::normalize, value -> Attributes.validateInHtml5(element, "crossorigin"));
  }

  /**
   * See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Attributes/crossorigin">The crossorigin attribute: Requesting CORS access to content</a>.
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @since HTML 5
   *
   * @see #crossorigin(java.lang.String)
   */
  @SuppressWarnings("overloads")
  default <Ex extends Throwable> E crossorigin(Suppliers.String<Ex> crossorigin) throws IOException, Ex {
    return crossorigin((crossorigin == null) ? null : crossorigin.get());
  }

  /**
   * See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Attributes/crossorigin">The crossorigin attribute: Requesting CORS access to content</a>.
   *
   * @since HTML 5
   *
   * @see #crossorigin(java.lang.String)
   */
  default E crossorigin(Value crossorigin) throws IOException {
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return crossorigin((crossorigin == null) ? null : crossorigin.apply(element.getDocument()));
  }

  /**
   * See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Attributes/crossorigin">The crossorigin attribute: Requesting CORS access to content</a>.
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @since HTML 5
   *
   * @see #crossorigin(com.aoapps.html.any.attributes.enumeration.Crossorigin.Value)
   */
  @SuppressWarnings("overloads")
  default <Ex extends Throwable> E crossorigin(IOSupplierE<? extends Value, Ex> crossorigin) throws IOException, Ex {
    return crossorigin((crossorigin == null) ? null : crossorigin.get());
  }

  /**
   * See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Attributes/crossorigin">The crossorigin attribute: Requesting CORS access to content</a>.
   *
   * @since HTML 5
   */
  public enum Value implements Function<AnyDocument<?>, String> {
    ANONYMOUS(
      Attributes.NO_VALUE,
      "anonymous"
  ),
    USE_CREDENTIALS(
        "use-credentials",
        "use-credentials"
    );

    private final String sgml;
    private final String xml;

    private Value(String sgml, String xml) {
      this.sgml = sgml;
      this.xml = xml;
    }

    @Override
    public String toString() {
      return xml;
    }

    @Override
    public String apply(AnyDocument<?> document) {
      Serialization serialization = document.encodingContext.getSerialization();
      if (serialization == Serialization.SGML) {
        return sgml;
      } else {
        assert serialization == Serialization.XML;
        return xml;
      }
    }
  }
}
