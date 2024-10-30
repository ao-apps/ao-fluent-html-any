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
 * <ul>
 * <li>See <a href="https://www.w3schools.com/tags/att_list.asp">HTML list Attribute</a>.</li>
 * <li>See <a href="https://www.w3schools.com/tags/att_input_list.asp">HTML input list Attribute</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input#htmlattrdeflist">&lt;input&gt;: The Input (Form Input) element</a>.</li>
 * </ul>
 *
 * @param  <E>   This element type
 *
 * @since HTML 5
 *
 * @author  AO Industries, Inc.
 */
public interface List<E extends Element<?, ?, E> & List<E>> {

  /**
   * Utility class for working with {@link List}.
   *
   * <ul>
   * <li>See <a href="https://www.w3schools.com/tags/att_list.asp">HTML list Attribute</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/att_input_list.asp">HTML input list Attribute</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input#htmlattrdeflist">&lt;input&gt;: The Input (Form Input) element</a>.</li>
   * </ul>
   *
   * @since HTML 5
   */
  public static final class list {
    /** Make no instances. */
    private list() {
      throw new AssertionError();
    }

    /**
     * Normalizes a list attribute.
     *
     * @see  Coercion#trimNullIfEmpty(java.lang.Object)
     */
    public static Object normalize(Object list) {
      return Coercion.trimNullIfEmpty(list);
    }
  }

  /**
   * <ul>
   * <li>See <a href="https://www.w3schools.com/tags/att_list.asp">HTML list Attribute</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/att_input_list.asp">HTML input list Attribute</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input#htmlattrdeflist">&lt;input&gt;: The Input (Form Input) element</a>.</li>
   * </ul>
   *
   * @since HTML 5
   */
  @Attributes.Funnel
  default E list(Object list) throws IOException {
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return Attributes.Text.attribute(element, "list", MarkupType.NONE, list, List.list::normalize,
        value -> Attributes.validateInHtml5(element, "list"), textInXhtmlAttributeEncoder);
  }

  /**
   * <ul>
   * <li>See <a href="https://www.w3schools.com/tags/att_list.asp">HTML list Attribute</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/att_input_list.asp">HTML input list Attribute</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input#htmlattrdeflist">&lt;input&gt;: The Input (Form Input) element</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @since HTML 5
   *
   * @see #list(java.lang.Object)
   */
  default <Ex extends Throwable> E list(IOSupplierE<?, Ex> list) throws IOException, Ex {
    return list((list == null) ? null : list.get());
  }

  /**
   * <ul>
   * <li>See <a href="https://www.w3schools.com/tags/att_list.asp">HTML list Attribute</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/att_input_list.asp">HTML input list Attribute</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input#htmlattrdeflist">&lt;input&gt;: The Input (Form Input) element</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @since HTML 5
   *
   * @see #list(java.lang.Object)
   */
  default <Ex extends Throwable> E list(TextWritable<Ex> list) throws IOException, Ex {
    return list((Object) list);
  }
}
