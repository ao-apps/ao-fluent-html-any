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
 * Elements that are common to all three of {@link AnyTBODY}, {@link AnyTHEAD}, and {@link AnyTFOOT}.
 * <ul>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/tables.html#the-tbody-element">4.9.5 The tbody element</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/tbody">&lt;tbody&gt;: The Table Body element</a>.</li>
 * <li>See <a href="https://www.w3schools.com/tags/tag_tbody.asp">HTML tbody tag</a>.</li>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/tables.html#the-thead-element">4.9.6 The thead element</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/thead">&lt;thead&gt;: The Table Head element</a>.</li>
 * <li>See <a href="https://www.w3schools.com/tags/tag_thead.asp">HTML thead tag</a>.</li>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/tables.html#the-tfoot-element">4.9.7 The tfoot element</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/tfoot">&lt;tfoot&gt;: The Table Foot element</a>.</li>
 * <li>See <a href="https://www.w3schools.com/tags/tag_tfoot.asp">HTML tfoot tag</a>.</li>
 * </ul>
 *
 * @param  <D>   This document type
 * @param  <__>  This content model, which will be the parent content model of child elements
 *
 * @author  AO Industries, Inc.
 */
public interface AnyUnion_TBODY_THEAD_TFOOT<
    D  extends AnyDocument<D>,
    __ extends AnyUnion_TBODY_THEAD_TFOOT<D, __>
> extends
    //
    // Unions:
    //
    // Inherited: AnyCOLGROUP_ScriptSupporting<D, __>

    //
    // Content models:
    //
    // Inherited: Content<D, __>
    AnyScriptSupportingContent<D, __>
{
  //
  // Factories:
  //
  // <editor-fold defaultstate="collapsed" desc="TR">
  /**
   * Opens a new tr element.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/tables.html#the-tr-element">4.9.8 The tr element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/tr">&lt;tr&gt;: The Table Row element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_tr.asp">HTML tr tag</a>.</li>
   * </ul>
   */
  @Factory("tr")
  AnyTR<D, __, ?, ?, ?> tr() throws IOException;

  /**
   * Creates a tr element with no attributes and the given body.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/tables.html#the-tr-element">4.9.8 The tr element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/tr">&lt;tr&gt;: The Table Row element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_tr.asp">HTML tr tag</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @return  This content model, which will be the parent content model of child elements
   */
  @Factory("tr")
  default <Ex extends Throwable> __ tr__(IORunnableE<Ex> tr) throws IOException, Ex {
    return tr().__(tr);
  }

  /**
   * Creates a tr element with no attributes and the given body.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/tables.html#the-tr-element">4.9.8 The tr element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/tr">&lt;tr&gt;: The Table Row element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_tr.asp">HTML tr tag</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @return  This content model, which will be the parent content model of child elements
   */
  @Factory("tr")
  default <Ex extends Throwable> __ tr__any(IOConsumerE<? super AnyTR__<D, __, ? extends AnyTR__<D, __, ?>>, Ex> tr) throws IOException, Ex {
    return tr().__(tr);
  }

  /**
   * Creates an empty tr element with no attributes.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/tables.html#the-tr-element">4.9.8 The tr element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/tr">&lt;tr&gt;: The Table Row element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_tr.asp">HTML tr tag</a>.</li>
   * </ul>
   *
   * @return  This content model, which will be the parent content model of child elements
   */
  @Factory("tr")
  default __ tr__() throws IOException {
    return tr().__();
  }

  /**
   * Creates a tr element with no attributes then begins element content
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/tables.html#the-tr-element">4.9.8 The tr element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/tr">&lt;tr&gt;: The Table Row element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_tr.asp">HTML tr tag</a>.</li>
   * </ul>
   *
   * @return  The content model of this element, which will be the parent content model of child elements.
   *          This must be {@linkplain Closeable#__() ended} or {@linkplain Closeable#close() closed} in order to end
   *          the tag.  This is well suited for use in a try-with-resources block.
   *
   * @see  Closeable#__()
   * @see  Closeable#close()
   */
  @Factory("tr")
  AnyTR_c<D, __, ?> tr_c() throws IOException;
  // </editor-fold>
  // Inherited: SCRIPT
  // Inherited: TEMPLATE
}
