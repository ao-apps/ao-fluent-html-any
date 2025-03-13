/*
 * ao-fluent-html-any - Base abstract classes and interfaces for Fluent Java DSL for high-performance HTML generation.
 * Copyright (C) 2020, 2021, 2022, 2023, 2025  AO Industries, Inc.
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
 * <li>See <a href="https://html.spec.whatwg.org/multipage/embedded-content.html#the-img-element">4.8.3 The img element</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/img">&lt;img&gt;: The Image Embed element</a>.</li>
 * <li>See <a href="https://www.w3schools.com/tags/tag_img.asp">HTML img tag</a>.</li>
 * </ul>
 *
 * @param  <D>   This document type
 * @param  <PC>  The parent content model this element is within
 * @param  <E>   This element type
 *
 * @author  AO Industries, Inc.
 */
@SuppressWarnings("deprecation")
public abstract class AnyIMG<
    D  extends AnyDocument<D>,
    PC extends AnyUnion_Embedded_Interactive<D, PC>,
    E  extends AnyIMG<D, PC, E>
    >
    extends Void<D, PC, E> implements
    com.aoapps.html.any.attributes.enumeration.Align<E, AnyIMG.Align>,
    com.aoapps.html.any.attributes.text.Alt<E>,
    // TODO: border
    com.aoapps.html.any.attributes.enumeration.Crossorigin<E>,
    com.aoapps.html.any.attributes.integer.Height<E>,
    // TODO: hspace
    com.aoapps.html.any.attributes.bool.Ismap<E>,
    // TODO: longdesc
    // TODO: sizes
    com.aoapps.html.any.attributes.url.Src<E>,
    // TODO: srcset
    com.aoapps.html.any.attributes.text.Usemap<E>,
    // TODO: vspace
    com.aoapps.html.any.attributes.integer.Width<E>,
    // TODO: More events
    // Global Event Attributes overrides
    com.aoapps.html.any.attributes.event.Onabort<E>,
    com.aoapps.html.any.attributes.event.Onerror<E>,
    com.aoapps.html.any.attributes.event.Onload<E> {

  protected AnyIMG(D document, PC pc) {
    super(document, pc);
  }

  @Override
  protected void writeOpen(Writer unsafe) throws IOException {
    document.autoIndent(unsafe).unsafe(unsafe, "<img", false);
  }

  /**
   * See <a href="https://www.w3schools.com/tags/att_img_align.asp">HTML img align Attribute</a>.
   *
   * @deprecated  The align attribute of &lt;img&gt; is not supported in HTML5. Use CSS instead.
   */
  @Deprecated
  public enum Align implements Function<AnyDocument<?>, String> {

    /**
     * Align the image to the left.
     */
    LEFT("left"),

    /**
     * Align the image to the right.
     */
    RIGHT("right"),

    /**
     * Align the image in the middle.
     */
    MIDDLE("middle"),

    /**
     * Align the image at the top.
     */
    TOP("top"),

    /**
     * Align the image at the bottom.
     */
    BOTTOM("bottom");

    private final String value;

    private Align(String value) {
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
