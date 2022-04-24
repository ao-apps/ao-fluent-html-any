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
 * <li>See <a href="https://html.spec.whatwg.org/multipage/iframe-embed-object.html#the-object-element">4.8.7 The object element</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/object">&lt;object&gt;: The External Object element</a>.</li>
 * <li>See <a href="https://www.w3schools.com/tags/tag_object.asp">HTML object tag</a>.</li>
 * </ul>
 * <p>
 * Due to limitations in Java generics, this content model does not directly reflect the parent content
 * model, despite this being a transparent content model.  Rather, it includes only the content model that
 * always applies to this element type.
 * </p>
 * <p><em>
 * For the full, context-aware content model, which will likely include more elements,
 * {@linkplain #pc() use the parent content model directly}.
 * </em></p>
 *
 * @param  <D>   This document type
 * @param  <PC>  The parent content model this element is within
 * @param  <__>  This content model, which will be the parent content model of child elements
 *
 * @see  #pc()
 *
 * @author  AO Industries, Inc.
 */
public abstract class AnyOBJECT__<
    D  extends AnyDocument<D>,
    PC extends AnyUnion_Embedded_Interactive<D, PC>,
    __ extends AnyOBJECT__<D, PC, __>
>
    extends Normal__<D, PC, __>
    implements AnyOBJECT_content<D, __> {

  protected AnyOBJECT__(AnyOBJECT<D, PC, ?, __, ?> element) {
    super(element);
  }

  /**
   * Gets the parent content model, which may also be used for creating child elements.
   * <p><em>
   * This is the full, context-aware content model, which will likely include more elements.
   * </em></p>
   *
   * @return  The parent content model this element is within
   */
  public PC pc() {
    return element.pc;
  }
}
