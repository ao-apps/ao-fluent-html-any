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

package com.aoapps.html.any.attributes.url;

import com.aoapps.html.any.Attributes;
import com.aoapps.html.any.Element;
import com.aoapps.lang.Strings;
import com.aoapps.lang.io.function.IOSupplierE;
import java.io.IOException;

/**
 * <ul>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/grouping-content.html#attr-blockquote-cite">4.4.4 The blockquote element / cite</a>.</li>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/text-level-semantics.html#attr-q-cite">4.5.7 The q element / cite</a>.</li>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/edits.html#attr-mod-cite">4.7.3 Attributes common to ins and del elements / cite</a>.</li>
 * </ul>
 *
 * @param  <E>   This element type
 *
 * @author  AO Industries, Inc.
 */
public interface Cite<E extends Element<?, ?, E> & Cite<E>> {

  /**
   * Utility class for working with {@link Cite}.
   *
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/grouping-content.html#attr-blockquote-cite">4.4.4 The blockquote element / cite</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/text-level-semantics.html#attr-q-cite">4.5.7 The q element / cite</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/edits.html#attr-mod-cite">4.7.3 Attributes common to ins and del elements / cite</a>.</li>
   * </ul>
   */
  public static final class cite {
    /** Make no instances. */
    private cite() {
      throw new AssertionError();
    }

    /**
     * Normalizes a cite attribute.
     *
     * @see  Strings#trimNullIfEmpty(java.lang.String)
     */
    public static String normalize(String cite) {
      return Strings.trimNullIfEmpty(cite);
    }
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/grouping-content.html#attr-blockquote-cite">4.4.4 The blockquote element / cite</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/text-level-semantics.html#attr-q-cite">4.5.7 The q element / cite</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/edits.html#attr-mod-cite">4.7.3 Attributes common to ins and del elements / cite</a>.</li>
   * </ul>
   */
  @Attributes.Funnel
  default E cite(String cite) throws IOException {
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return Attributes.Url.attribute(element, "cite", cite, Cite.cite::normalize);
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/grouping-content.html#attr-blockquote-cite">4.4.4 The blockquote element / cite</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/text-level-semantics.html#attr-q-cite">4.5.7 The q element / cite</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/edits.html#attr-mod-cite">4.7.3 Attributes common to ins and del elements / cite</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @see #cite(java.lang.String)
   */
  default <Ex extends Throwable> E cite(IOSupplierE<? extends String, Ex> cite) throws IOException, Ex {
    return cite((cite == null) ? null : cite.get());
  }
}
