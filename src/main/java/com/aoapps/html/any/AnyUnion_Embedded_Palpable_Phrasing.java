/*
 * ao-fluent-html-any - Base abstract classes and interfaces for Fluent Java DSL for high-performance HTML generation.
 * Copyright (C) 2021, 2022, 2024, 2025  AO Industries, Inc.
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
 * Elements that are common to all three of {@link AnyEmbeddedContent}, {@link AnyPalpableContent}, and
 * {@link AnyPhrasingContent}.
 *
 * @param  <D>   This document type
 * @param  <__>  This content model, which will be the parent content model of child elements
 *
 * @author  AO Industries, Inc.
 */
public interface AnyUnion_Embedded_Palpable_Phrasing<
    D  extends AnyDocument<D>,
    __ extends AnyUnion_Embedded_Palpable_Phrasing<D, __>
    >
    extends
    //
    // Content models:
    //
    Content<D, __> {
  //
  // Factories:
  //
  // <editor-fold defaultstate="collapsed" desc="CANVAS">
  /**
   * Opens a new canvas element.
   *
   * <p>See <a href="https://html.spec.whatwg.org/multipage/canvas.html#the-canvas-element">4.12.5 The canvas element</a>.</p>
   *
   * @since HTML 5
   *
   * @deprecated  TODO: Implement canvas
   */
  @Deprecated(forRemoval = false)
  @Factory("canvas")
  default AnyCANVAS canvas() throws IOException {
    throw new AssertionError("TODO: Implement canvas");
  }
  // </editor-fold>
  // <editor-fold defaultstate="collapsed" desc="TODO: MathML math">
  // See <a href="https://html.spec.whatwg.org/multipage/embedded-content-other.html#mathml">4.8.16 MathML</a>.
  // </editor-fold>
  // <editor-fold defaultstate="collapsed" desc="TODO: SVG svg">
  // See <a href="https://html.spec.whatwg.org/multipage/embedded-content-other.html#svg-0">4.8.17 SVG</a>.
  // </editor-fold>
}
