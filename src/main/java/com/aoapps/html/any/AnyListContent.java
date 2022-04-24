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

package com.aoapps.html.any;

import com.aoapps.lang.io.function.IOConsumerE;
import com.aoapps.lang.io.function.IORunnableE;
import java.io.IOException;

/**
 * <ul>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/grouping-content.html#the-li-element">4.4.8 The li element</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/li">&lt;li&gt;: The List Item element</a>.</li>
 * <li>See <a href="https://www.w3schools.com/tags/tag_li.asp">HTML li tag</a>.</li>
 * </ul>
 *
 * @param  <D>   This document type
 * @param  <__>  This content model, which will be the parent content model of child elements
 *
 * @author  AO Industries, Inc.
 */
public interface AnyListContent<
    D  extends AnyDocument<D>,
    __ extends AnyListContent<D, __>
> extends
    //
    // Unions:
    //
    // Inherited: AnyUnion_COLGROUP_ScriptSupporting<D, __>

    //
    // Content models:
    //
    // Inherited: Content<D, __>
    AnyScriptSupportingContent<D, __>
{
  //
  // Factories:
  //
  // <editor-fold defaultstate="collapsed" desc="LI">
  /**
   * Opens a new li element.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/grouping-content.html#the-li-element">4.4.8 The li element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/li">&lt;li&gt;: The List Item element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_li.asp">HTML li tag</a>.</li>
   * </ul>
   */
  @Factory("li")
  AnyLI<D, __, ?, ?, ?> li() throws IOException;

  /**
   * Creates a li element with no attributes and the given body.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/grouping-content.html#the-li-element">4.4.8 The li element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/li">&lt;li&gt;: The List Item element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_li.asp">HTML li tag</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @return  This content model, which will be the parent content model of child elements
   */
  @Factory("li")
  default <Ex extends Throwable> __ li__(IORunnableE<Ex> li) throws IOException, Ex {
    return li().__(li);
  }

  /**
   * Creates a li element with no attributes and the given body.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/grouping-content.html#the-li-element">4.4.8 The li element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/li">&lt;li&gt;: The List Item element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_li.asp">HTML li tag</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @return  This content model, which will be the parent content model of child elements
   */
  @Factory("li")
  default <Ex extends Throwable> __ li__any(IOConsumerE<? super AnyLI__<D, __, ? extends AnyLI__<D, __, ?>>, Ex> li) throws IOException, Ex {
    return li().__(li);
  }

  /**
   * Creates a li element with no attributes and a text body.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/grouping-content.html#the-li-element">4.4.8 The li element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/li">&lt;li&gt;: The List Item element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_li.asp">HTML li tag</a>.</li>
   * </ul>
   *
   * @return  This content model, which will be the parent content model of child elements
   */
  @Factory("li")
  default __ li__(Object text) throws IOException {
    return li().__(text);
  }

  /**
   * Creates an empty li element with no attributes.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/grouping-content.html#the-li-element">4.4.8 The li element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/li">&lt;li&gt;: The List Item element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_li.asp">HTML li tag</a>.</li>
   * </ul>
   *
   * @return  This content model, which will be the parent content model of child elements
   */
  @Factory("li")
  default __ li__() throws IOException {
    return li().__();
  }

  /**
   * Creates a li element with no attributes then begins element content
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/grouping-content.html#the-li-element">4.4.8 The li element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/li">&lt;li&gt;: The List Item element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_li.asp">HTML li tag</a>.</li>
   * </ul>
   *
   * @return  The content model of this element, which will be the parent content model of child elements.
   *          This must be {@linkplain Closeable#__() ended} or {@linkplain Closeable#close() closed} in order to end
   *          the tag.  This is well suited for use in a try-with-resources block.
   *
   * @see  Closeable#__()
   * @see  Closeable#close()
   */
  @Factory("li")
  AnyLI_c<D, __, ?> li_c() throws IOException;
  // </editor-fold>
  // Inherited: SCRIPT
  // Inherited: TEMPLATE
}
