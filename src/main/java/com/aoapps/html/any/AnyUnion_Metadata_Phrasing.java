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
 * Elements that are common to both {@link AnyMetadataContent} and {@link AnyPhrasingContent}.
 *
 * @param  <D>   This document type
 * @param  <__>  This content model, which will be the parent content model of child elements
 *
 * @author  AO Industries, Inc.
 */
public interface AnyUnion_Metadata_Phrasing<
    D  extends AnyDocument<D>,
    __ extends AnyUnion_Metadata_Phrasing<D, __>
    >
    extends
    //
    // Unions:
    //
    // Inherited: AnyCOLGROUP_ScriptSupporting<D, __>

    //
    // Content models:
    //
    // Inherited: Content<D, __>
    AnyScriptSupportingContent<D, __> {
  //
  // Factories:
  //
  // <editor-fold defaultstate="collapsed" desc="LINK">
  /**
   * Opens a new link element.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/semantics.html#the-link-element">4.2.4 The link element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/link">&lt;link&gt;: The External Resource Link element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_link.asp">HTML link tag</a>.</li>
   * </ul>
   */
  // TODO: Variants of Link by Rel, with per-implementation attributes like Input?
  @Factory("link")
  AnyLINK<D, __, ?> link() throws IOException;

  /**
   * Opens a new link element with the given rel attribute.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/semantics.html#the-link-element">4.2.4 The link element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/link">&lt;link&gt;: The External Resource Link element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_link.asp">HTML link tag</a>.</li>
   * </ul>
   *
   * @see #link()
   * @see AnyLINK#rel(java.lang.Enum)
   */
  @Factory("link")
  AnyLINK<D, __, ?> link(AnyLINK.Rel rel) throws IOException;

  // No link__(), since either rel or itemprop is required
  // </editor-fold>
  // <editor-fold defaultstate="collapsed" desc="META">
  /**
   * Opens a new meta element.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/semantics.html#the-meta-element">4.2.5 The meta element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/meta">&lt;meta&gt;: The metadata element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_meta.asp">HTML meta tag</a>.</li>
   * </ul>
   */
  @Factory("meta")
  AnyMETA<D, __, ?> meta() throws IOException;

  // No meta__(), since either name, http-equiv, or itemprop is required
  // TODO: confirm itemprop-only metas?
  // </editor-fold>
  // <editor-fold defaultstate="collapsed" desc="NOSCRIPT">
  /**
   * Opens a new noscript element.
   * <p>
   * See <a href="https://html.spec.whatwg.org/multipage/scripting.html#the-noscript-element">4.12.2 The noscript element</a>.
   * </p>
   *
   * @deprecated  TODO: Implement noscript
   */
  @Deprecated
  @Factory("noscript")
  default AnyNOSCRIPT noscript() throws IOException {
    throw new AssertionError("TODO: Implement noscript");
  }
  // </editor-fold>
  // Inherited: SCRIPT
  // Inherited: TEMPLATE
}
