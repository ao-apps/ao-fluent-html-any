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

package com.aoapps.html.any.attributes.Text;

import com.aoapps.encoding.Doctype;
import com.aoapps.encoding.TextWritable;
import com.aoapps.html.any.Attributes;
import com.aoapps.html.any.Element;
import com.aoapps.lang.io.function.IOSupplierE;
import java.io.IOException;

/**
 * <ul>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#classes">3.2.6 Global attributes / class</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/class">Global attributes / class</a>.</li>
 * <li>See <a href="https://www.w3schools.com/tags/att_global_class.asp">HTML class Attribute</a>.</li>
 * </ul>
 * <blockquote>
 * In HTML 4.01, the class attribute cannot be used with: &lt;base&gt;, &lt;head&gt;, &lt;html&gt;, &lt;meta&gt;, &lt;param&gt;, &lt;script&gt;, &lt;style&gt;, and &lt;title&gt;.
 * </blockquote>
 *
 * @param  <E>   This element type
 *
 * @author  AO Industries, Inc.
 */
// Matches Class
public interface ClassNoHtml4<E extends Element<?, ?, E> & ClassNoHtml4<E>> extends Class<E> {

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#classes">3.2.6 Global attributes / class</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/class">Global attributes / class</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/att_global_class.asp">HTML class Attribute</a>.</li>
   * </ul>
   * <blockquote>
   * In HTML 4.01, the class attribute cannot be used with: &lt;base&gt;, &lt;head&gt;, &lt;html&gt;, &lt;meta&gt;, &lt;param&gt;, &lt;script&gt;, &lt;style&gt;, and &lt;title&gt;.
   * </blockquote>
   */
  @Override
  @Attributes.Funnel
  default E clazz(Object clazz) throws IOException {
    @SuppressWarnings("unchecked") E element = (E)this;
    Attributes.invalidGlobalAttributeForDoctype(element, Doctype.HTML5, "class");
    return Class.super.clazz(clazz);
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#classes">3.2.6 Global attributes / class</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/class">Global attributes / class</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/att_global_class.asp">HTML class Attribute</a>.</li>
   * </ul>
   * <blockquote>
   * In HTML 4.01, the class attribute cannot be used with: &lt;base&gt;, &lt;head&gt;, &lt;html&gt;, &lt;meta&gt;, &lt;param&gt;, &lt;script&gt;, &lt;style&gt;, and &lt;title&gt;.
   * </blockquote>
   */
  @Override
  @Attributes.Funnel
  default E clazz(Object ... clazz) throws IOException {
    @SuppressWarnings("unchecked") E element = (E)this;
    Attributes.invalidGlobalAttributeForDoctype(element, Doctype.HTML5, "class");
    return Class.super.clazz(clazz);
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#classes">3.2.6 Global attributes / class</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/class">Global attributes / class</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/att_global_class.asp">HTML class Attribute</a>.</li>
   * </ul>
   * <blockquote>
   * In HTML 4.01, the class attribute cannot be used with: &lt;base&gt;, &lt;head&gt;, &lt;html&gt;, &lt;meta&gt;, &lt;param&gt;, &lt;script&gt;, &lt;style&gt;, and &lt;title&gt;.
   * </blockquote>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @see #clazz(java.lang.Object)
   */
  @Override
  default <Ex extends Throwable> E clazz(IOSupplierE<?, Ex> clazz) throws IOException, Ex {
    return Class.super.clazz(clazz);
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#classes">3.2.6 Global attributes / class</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/class">Global attributes / class</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/att_global_class.asp">HTML class Attribute</a>.</li>
   * </ul>
   * <blockquote>
   * In HTML 4.01, the class attribute cannot be used with: &lt;base&gt;, &lt;head&gt;, &lt;html&gt;, &lt;meta&gt;, &lt;param&gt;, &lt;script&gt;, &lt;style&gt;, and &lt;title&gt;.
   * </blockquote>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @see #clazz(java.lang.Object)
   */
  @Override
  default <Ex extends Throwable> E clazz(TextWritable<Ex> clazz) throws IOException, Ex {
    return Class.super.clazz(clazz);
  }
}
