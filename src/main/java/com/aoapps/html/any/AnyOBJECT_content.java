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

import java.io.IOException;

/**
 * <ul>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/iframe-embed-object.html#the-object-element">4.8.7 The object element</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/object">&lt;object&gt;: The External Object element</a>.</li>
 * <li>See <a href="https://www.w3schools.com/tags/tag_object.asp">HTML object tag</a>.</li>
 * </ul>
 *
 * @param  <D>   This document type
 * @param  <__>  This content model, which will be the parent content model of child elements
 *
 * @author  AO Industries, Inc.
 */
public interface AnyOBJECT_content<
  D  extends AnyDocument<D>,
  __ extends AnyOBJECT_content<D, __>
> extends
  //
  // Unions:
  //
  AnyUnion_Embedded_Interactive<D, __>

  //
  // Content models:
  //
  // Inherited: Content<D, __>
{
  //
  // Factories:
  //
  // Inherited: AUDIO
  // Inherited: EMBED
  // Inherited: IFRAME
  // Inherited: IMG
  // Inherited: OBJECT
  // <editor-fold defaultstate="collapsed" desc="PARAM">
  /**
   * Opens a new param element.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/iframe-embed-object.html#the-param-element">4.8.8 The param element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/param">&lt;param&gt;: The Object Parameter element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_param.asp">HTML param tag</a>.</li>
   * </ul>
   */
  @Factory("param")
  AnyPARAM<D, __, ?> param() throws IOException;

  /**
   * Creates a param element with the given name and value.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/iframe-embed-object.html#the-param-element">4.8.8 The param element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/param">&lt;param&gt;: The Object Parameter element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_param.asp">HTML param tag</a>.</li>
   * </ul>
   *
   * @return  This content model, which will be the parent content model of child elements
   */
  @Factory("param")
  default __ param__(Object name, Object value) throws IOException {
    return param().name(name).value(value).__();
  }
  // TODO: More types like supported by ao-taglib (ParamsTag.java), including collection types, as "params__"?
  // </editor-fold>
  // Inherited: VIDEO
}
