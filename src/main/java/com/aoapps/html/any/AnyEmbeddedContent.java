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
 * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#embedded-content-2">3.2.5.2.6 Embedded content</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/Guide/HTML/Content_categories#embedded_content">Embedded content</a>.</li>
 * </ul>
 *
 * @param  <D>   This document type
 * @param  <__>  This content model, which will be the parent content model of child elements
 *
 * @author  AO Industries, Inc.
 */
public interface AnyEmbeddedContent<
  D  extends AnyDocument<D>,
  __ extends AnyEmbeddedContent<D, __>
> extends
  //
  // Unions:
  //
  AnyUnion_Embedded_Interactive<D, __>,
  AnyUnion_Embedded_Palpable_Phrasing<D, __>

  //
  // Content models:
  //
  // Inherited: Content<D, __>
{
  //
  // Factories:
  //
  // Inherited: AUDIO
  // Inherited: CANVAS
  // Inherited: EMBED
  // Inherited: IFRAME
  // Inherited: IMG
  // Inherited: MathML math
  // Inherited: OBJECT
  // <editor-fold defaultstate="collapsed" desc="PICTURE">
  /**
   * Opens a new picture element.
   * <p>
   * See <a href="https://html.spec.whatwg.org/multipage/embedded-content.html#the-picture-element">4.8.1 The picture element</a>.
   * </p>
   *
   * @since HTML 5
   *
   * @deprecated  TODO: Implement picture
   */
  @Deprecated
  @Factory("picture")
  default AnyPICTURE picture() throws IOException {
    throw new AssertionError("TODO: Implement picture");
  }
  // </editor-fold>
  // Inherited: SVG svg
  // Inherited: VIDEO
}
