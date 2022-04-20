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

package com.aoapps.html.any.attributes.Integer;

import com.aoapps.html.any.Attributes;
import com.aoapps.html.any.Element;
import com.aoapps.lang.io.function.IOSupplierE;
import java.io.IOException;

/**
 * <ul>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/interaction.html#the-tabindex-attribute">6.6.3 The tabindex attribute</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/tabindex">Global attributes / tabindex</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/tabIndex">HTMLElement.tabIndex</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Learn/Accessibility/HTML#building_keyboard_accessibility_back_in">Building keyboard accessibility back in</a>.</li>
 * <li>See <a href="https://www.w3schools.com/tags/att_global_tabindex.asp">HTML tabindex Attribute</a>.</li>
 * </ul>
 * <blockquote>
 * In HTML 4.01, the tabindex attribute can be used with: &lt;a&gt;, &lt;area&gt;, &lt;button&gt;, &lt;input&gt;, &lt;object&gt;, &lt;select&gt;, and &lt;textarea&gt;.
 * </blockquote>
 *
 * @param  <E>   This element type
 *
 * @author  AO Industries, Inc.
 */
// Matches Tabindex
public interface TabindexHtml4<E extends Element<?, ?, E> & TabindexHtml4<E>> extends Tabindex<E> {

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/interaction.html#the-tabindex-attribute">6.6.3 The tabindex attribute</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/tabindex">Global attributes / tabindex</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/tabIndex">HTMLElement.tabIndex</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Learn/Accessibility/HTML#building_keyboard_accessibility_back_in">Building keyboard accessibility back in</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/att_global_tabindex.asp">HTML tabindex Attribute</a>.</li>
   * </ul>
   * <blockquote>
   * In HTML 4.01, the tabindex attribute can be used with: &lt;a&gt;, &lt;area&gt;, &lt;button&gt;, &lt;input&gt;, &lt;object&gt;, &lt;select&gt;, and &lt;textarea&gt;.
   * </blockquote>
   */
  @Override
  @Attributes.Funnel
  default E tabindex(int tabindex) throws IOException {
    // Not calling super: overridden to support HTML 4
    @SuppressWarnings("unchecked") E element = (E)this;
    return Attributes.Integer.attribute(element, "tabindex", tabindex);
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/interaction.html#the-tabindex-attribute">6.6.3 The tabindex attribute</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/tabindex">Global attributes / tabindex</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/tabIndex">HTMLElement.tabIndex</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Learn/Accessibility/HTML#building_keyboard_accessibility_back_in">Building keyboard accessibility back in</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/att_global_tabindex.asp">HTML tabindex Attribute</a>.</li>
   * </ul>
   * <blockquote>
   * In HTML 4.01, the tabindex attribute can be used with: &lt;a&gt;, &lt;area&gt;, &lt;button&gt;, &lt;input&gt;, &lt;object&gt;, &lt;select&gt;, and &lt;textarea&gt;.
   * </blockquote>
   */
  @Override
  @Attributes.Funnel
  default E tabindex(Integer tabindex) throws IOException {
    return Tabindex.super.tabindex(tabindex);
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/interaction.html#the-tabindex-attribute">6.6.3 The tabindex attribute</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/tabindex">Global attributes / tabindex</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/tabIndex">HTMLElement.tabIndex</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Learn/Accessibility/HTML#building_keyboard_accessibility_back_in">Building keyboard accessibility back in</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/att_global_tabindex.asp">HTML tabindex Attribute</a>.</li>
   * </ul>
   * <blockquote>
   * In HTML 4.01, the tabindex attribute can be used with: &lt;a&gt;, &lt;area&gt;, &lt;button&gt;, &lt;input&gt;, &lt;object&gt;, &lt;select&gt;, and &lt;textarea&gt;.
   * </blockquote>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @see #tabindex(java.lang.Integer)
   */
  @Override
  default <Ex extends Throwable> E tabindex(IOSupplierE<? extends Integer, Ex> tabindex) throws IOException, Ex {
    return Tabindex.super.tabindex(tabindex);
  }
}
