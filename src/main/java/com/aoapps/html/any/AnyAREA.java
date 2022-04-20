/*
 * ao-fluent-html-any - Base abstract classes and interfaces for Fluent Java DSL for high-performance HTML generation.
 * Copyright (C) 2020, 2021, 2022  AO Industries, Inc.
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
import java.io.Writer;
import java.util.function.Function;

/**
 * <ul>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/image-maps.html#the-area-element">4.8.14 The area element</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/area">&lt;area&gt;: The Image Map Area element</a>.</li>
 * <li>See <a href="https://www.w3schools.com/tags/tag_area.asp">HTML area tag</a>.</li>
 * </ul>
 *
 * @param  <D>   This document type
 * @param  <PC>  The parent content model this element is within
 * @param  <E>   This element type
 *
 * @author  AO Industries, Inc.
 */
public abstract class AnyAREA<
  D  extends AnyDocument<D>,
  PC extends AnyPhrasingContent<D, PC>,
  E  extends AnyAREA<D, PC, E>
> extends Void<D, PC, E> implements
  com.aoapps.html.any.attributes.Text.Alt<E>,
  com.aoapps.html.any.attributes.Dimension.Coords<E>,
  // TODO: download
  com.aoapps.html.any.attributes.Url.Href<E>,
  com.aoapps.html.any.attributes.Text.Hreflang<E>,
  com.aoapps.html.any.attributes.Text.Media<E>,
  // TODO: name? (MDN only)
  // TODO: nohref
  // TODO: ping
  // TODO: referrerpolicy
  com.aoapps.html.any.attributes.Enum.Rel<E, AnyA.Rel>,
  com.aoapps.html.any.attributes.Enum.Shape<E, AnyAREA.Shape>,
  com.aoapps.html.any.attributes.Enum.Target<E, com.aoapps.html.any.attributes.Enum.Target.Value>,
  // TODO: type (deprecated since definition is in conflict and doesn't do anything?)
  // Global Attributes overrides
  com.aoapps.html.any.attributes.Integer.TabindexHtml4<E>
{

  protected AnyAREA(D document, PC pc) {
    super(document, pc);
  }

  @Override
  protected E writeOpen(Writer unsafe) throws IOException {
    document.autoNli(unsafe).unsafe(unsafe, "<area", false);
    @SuppressWarnings("unchecked") E element = (E)this;
    return element;
  }

  @Override
  protected void doAfterElement(Writer unsafe) throws IOException {
    document.autoNl(unsafe);
  }

  /**
   * <ul>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/area#attr-shape">&lt;area&gt; - HTML: Hypertext Markup Language</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/att_area_shape.asp">HTML area shape Attribute</a>.</li>
   * </ul>
   */
  public enum Shape implements Function<AnyDocument<?>, String> {
    DEFAULT("default"),
    RECT("rect"),
    CIRCLE("circle"),
    POLY("poly");

    private final String value;

    private Shape(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }

    @Override
    public String apply(AnyDocument<?> document) {
      return value;
    }
  }
}
