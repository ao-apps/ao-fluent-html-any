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

/**
 * <ul>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/form-elements.html#the-datalist-element">4.10.8 The datalist element</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/datalist">&lt;datalist&gt;: The HTML Data List element</a>.</li>
 * <li>See <a href="https://www.w3schools.com/tags/tag_datalist.asp">HTML datalist Tag</a>.</li>
 * </ul>
 *
 * @param  <D>   This document type
 * @param  <PC>  The parent content model this element is within
 * @param  <_c>  This content model as {@link Closeable}, which will be the parent content model of child elements
 *
 * @since HTML 5
 *
 * @author  AO Industries, Inc.
 */
public abstract class AnyDATALIST_c<
    D  extends AnyDocument<D>,
    PC extends AnyPhrasingContent<D, PC>,
    _c extends AnyDATALIST_c<D, PC, _c>
    >
    extends NormalText_c<D, PC, _c>
    implements AnyDATALIST_content<D, _c> {

  protected AnyDATALIST_c(AnyDATALIST<D, PC, ?, ?, _c> element) {
    super(element);
  }
}
