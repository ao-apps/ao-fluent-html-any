/*
 * ao-fluent-html-any - Base abstract classes and interfaces for Fluent Java DSL for high-performance HTML generation.
 * Copyright (C) 2021, 2022  AO Industries, Inc.
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
import com.aoapps.lang.io.function.IOSupplierE;
import java.io.IOException;

/**
 * <ul>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/form-control-infrastructure.html#association-of-controls-and-forms">4.10.17.3 Association of controls and forms</a>.</li>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/forms.html#form-associated-element">4.10.2 Categories</a>.</li>
 * </ul>
 *
 * @param  <E>   This element type
 *
 * @since HTML 5
 *
 * @author  AO Industries, Inc.
 */
public interface Form<E extends Element<?, ?, E> & Form<E>> {

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/form-control-infrastructure.html#association-of-controls-and-forms">4.10.17.3 Association of controls and forms</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/forms.html#form-associated-element">4.10.2 Categories</a>.</li>
   * </ul>
   *
   * @since HTML 5
   */
  @Attributes.Funnel
  default E form(Object form) throws IOException {
    @SuppressWarnings("unchecked")
    E element = (E) this;
    Attributes.onlySupportedInHtml5(element, "form");
    return Attributes.Text.attribute(element, "form", MarkupType.NONE, form, true, true, textInXhtmlAttributeEncoder);
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/form-control-infrastructure.html#association-of-controls-and-forms">4.10.17.3 Association of controls and forms</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/forms.html#form-associated-element">4.10.2 Categories</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @since HTML 5
   *
   * @see #form(java.lang.Object)
   */
  default <Ex extends Throwable> E form(IOSupplierE<?, Ex> form) throws IOException, Ex {
    return form((form == null) ? null : form.get());
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/form-control-infrastructure.html#association-of-controls-and-forms">4.10.17.3 Association of controls and forms</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/forms.html#form-associated-element">4.10.2 Categories</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @since HTML 5
   *
   * @see #form(java.lang.Object)
   */
  default <Ex extends Throwable> E form(TextWritable<Ex> form) throws IOException, Ex {
    return form((Object) form);
  }
}
