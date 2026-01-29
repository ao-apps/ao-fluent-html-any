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

package com.aoapps.html.any.attributes.text;

import static com.aoapps.encoding.TextInXhtmlAttributeEncoder.textInXhtmlAttributeEncoder;

import com.aoapps.encoding.Doctype;
import com.aoapps.encoding.TextWritable;
import com.aoapps.hodgepodge.i18n.MarkupType;
import com.aoapps.html.any.Attributes;
import com.aoapps.html.any.Element;
import com.aoapps.lang.io.function.IOSupplierE;
import java.io.IOException;

/**
 * <ul>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#the-title-attribute">3.2.6.1 The title attribute</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/title">Global attributes / title</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/title">HTMLElement.title</a>.</li>
 * <li>See <a href="https://www.w3schools.com/tags/att_global_title.asp">HTML title Attribute</a>.</li>
 * </ul>
 * <blockquote>
 * In HTML 4.01, the title attribute cannot be used with: &lt;base&gt;, &lt;head&gt;, &lt;html&gt;, &lt;meta&gt;, &lt;param&gt;, &lt;script&gt;, &lt;style&gt;, and &lt;title&gt;.
 * </blockquote>
 *
 * @param  <E>   This element type
 *
 * @author  AO Industries, Inc.
 */
// Matches Title
public interface TitleNoHtml4<E extends Element<?, ?, E> & TitleNoHtml4<E>> extends Title<E> {

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#the-title-attribute">3.2.6.1 The title attribute</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/title">Global attributes / title</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/title">HTMLElement.title</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/att_global_title.asp">HTML title Attribute</a>.</li>
   * </ul>
   * <blockquote>
   * In HTML 4.01, the title attribute cannot be used with: &lt;base&gt;, &lt;head&gt;, &lt;html&gt;, &lt;meta&gt;, &lt;param&gt;, &lt;script&gt;, &lt;style&gt;, and &lt;title&gt;.
   * </blockquote>
   */
  @Override
  @Attributes.Funnel
  default E title(Object title) throws IOException {
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return Attributes.Text.attribute(element, "title", MarkupType.TEXT, title, Title.title::normalize,
        value -> Attributes.invalidGlobalAttributeForDoctype(element, Doctype.HTML5, "title"),
        textInXhtmlAttributeEncoder);
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#the-title-attribute">3.2.6.1 The title attribute</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/title">Global attributes / title</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/title">HTMLElement.title</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/att_global_title.asp">HTML title Attribute</a>.</li>
   * </ul>
   * <blockquote>
   * In HTML 4.01, the title attribute cannot be used with: &lt;base&gt;, &lt;head&gt;, &lt;html&gt;, &lt;meta&gt;, &lt;param&gt;, &lt;script&gt;, &lt;style&gt;, and &lt;title&gt;.
   * </blockquote>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @see TitleNoHtml4#title(java.lang.Object)
   */
  @Override
  default <Ex extends Throwable> E title(IOSupplierE<?, Ex> title) throws IOException, Ex {
    return Title.super.title(title);
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#the-title-attribute">3.2.6.1 The title attribute</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/title">Global attributes / title</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/title">HTMLElement.title</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/att_global_title.asp">HTML title Attribute</a>.</li>
   * </ul>
   * <blockquote>
   * In HTML 4.01, the title attribute cannot be used with: &lt;base&gt;, &lt;head&gt;, &lt;html&gt;, &lt;meta&gt;, &lt;param&gt;, &lt;script&gt;, &lt;style&gt;, and &lt;title&gt;.
   * </blockquote>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @see TitleNoHtml4#title(java.lang.Object)
   */
  @Override
  default <Ex extends Throwable> E title(TextWritable<Ex> title) throws IOException, Ex {
    return Title.super.title(title);
  }
}
