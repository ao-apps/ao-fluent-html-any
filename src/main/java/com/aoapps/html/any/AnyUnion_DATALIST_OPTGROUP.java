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
 * Elements that are common to both {@link AnyDATALIST_content} and {@link AnyOPTGROUP_content}.
 *
 * @param  <D>   This document type
 * @param  <__>  This content model, which will be the parent content model of child elements
 *
 * @author  AO Industries, Inc.
 */
public interface AnyUnion_DATALIST_OPTGROUP<
    D  extends AnyDocument<D>,
    __ extends AnyUnion_DATALIST_OPTGROUP<D, __>
    >
    extends
    //
    // Content models:
    //
    Content<D, __> {
  //
  // Factories:
  //
  // <editor-fold defaultstate="collapsed" desc="OPTION">
  /**
   * Opens a new option element.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/form-elements.html#the-option-element">4.10.10 The option element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/option">&lt;option&gt;: The HTML Option element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_option.asp">HTML option tag</a>.</li>
   * </ul>
   */
  @Factory("option")
  AnyOPTION<D, __, ?, ?, ?> option() throws IOException;

  /**
   * Creates an option element with no attributes and the given body.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/form-elements.html#the-option-element">4.10.10 The option element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/option">&lt;option&gt;: The HTML Option element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_option.asp">HTML option tag</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @return  This content model, which will be the parent content model of child elements
   */
  @Factory("option")
  default <Ex extends Throwable> __ option__(IORunnableE<Ex> option) throws IOException, Ex {
    return option().__(option);
  }

  /**
   * Creates an option element with no attributes and the given body.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/form-elements.html#the-option-element">4.10.10 The option element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/option">&lt;option&gt;: The HTML Option element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_option.asp">HTML option tag</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @return  This content model, which will be the parent content model of child elements
   */
  @Factory("option")
  default <Ex extends Throwable> __ option__any(IOConsumerE<? super AnyOPTION__<D, __, ? extends AnyOPTION__<D, __, ?>>, Ex> option) throws IOException, Ex {
    return option().__(option);
  }

  /**
   * Creates an option element with no attributes and a text body.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/form-elements.html#the-option-element">4.10.10 The option element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/option">&lt;option&gt;: The HTML Option element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_option.asp">HTML option tag</a>.</li>
   * </ul>
   *
   * @return  This content model, which will be the parent content model of child elements
   */
  @Factory("option")
  default __ option__(Object text) throws IOException {
    return option().__(text);
  }

  /**
   * Creates an empty option element with no attributes.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/form-elements.html#the-option-element">4.10.10 The option element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/option">&lt;option&gt;: The HTML Option element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_option.asp">HTML option tag</a>.</li>
   * </ul>
   *
   * @return  This content model, which will be the parent content model of child elements
   */
  @Factory("option")
  default __ option__() throws IOException {
    return option().__();
  }

  /**
   * Creates an option element with no attributes then begins element content.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/form-elements.html#the-option-element">4.10.10 The option element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/option">&lt;option&gt;: The HTML Option element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_option.asp">HTML option tag</a>.</li>
   * </ul>
   *
   * @return  The content model of this element, which will be the parent content model of child elements.
   *          This must be {@linkplain Closeable#__() ended} or {@linkplain Closeable#close() closed} in order to end
   *          the tag.  This is well suited for use in a try-with-resources block.
   *
   * @see  Closeable#__()
   * @see  Closeable#close()
   */
  @Factory("option")
  AnyOPTION_c<D, __, ?> option_c() throws IOException;
  // </editor-fold>
}
