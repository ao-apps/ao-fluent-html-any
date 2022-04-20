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
 * <li>See <a href="https://html.spec.whatwg.org/multipage/tables.html#the-colgroup-element">4.9.3 The colgroup element</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/colgroup">&lt;colgroup&gt;: The Table Column Group element</a>.</li>
 * <li>See <a href="https://www.w3schools.com/tags/tag_colgroup.asp">HTML colgroup tag</a>.</li>
 * </ul>
 *
 * @param  <D>   This document type
 * @param  <__>  This content model, which will be the parent content model of child elements
 *
 * @author  AO Industries, Inc.
 */
public interface AnyCOLGROUP_content<
  D  extends AnyDocument<D>,
  __ extends AnyCOLGROUP_content<D, __>
> extends
  //
  // Unions:
  //
  AnyUnion_COLGROUP_ScriptSupporting<D, __>

  //
  // Content models:
  //
  // Inherited: Content<D, __>
{
  //
  // Factories:
  //
  // <editor-fold defaultstate="collapsed" desc="COL">
  /**
   * Opens a new col element.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/tables.html#the-col-element">4.9.4 The col element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/col">&lt;col&gt; - The Table Column element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_col.asp">HTML col tag</a>.</li>
   * </ul>
   */
  @Factory("col")
  AnyCOL<D, __, ?> col() throws IOException;
  // </editor-fold>
  // Inherited: TEMPLATE
}
