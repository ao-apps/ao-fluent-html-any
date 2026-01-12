/*
 * ao-fluent-html-any - Base abstract classes and interfaces for Fluent Java DSL for high-performance HTML generation.
 * Copyright (C) 2026  AO Industries, Inc.
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
 * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#flow-content">3.2.5.2.2 Flow content</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/Guide/HTML/Content_categories#flow_content">Flow content</a>.</li>
 * </ul>
 *
 * @param  <D>   This document type
 * @param  <PC>  The parent content model this element is within
 * @param  <_c>  This content model as {@link Closeable}, which will be the parent content model of child elements
 *
 * @author  AO Industries, Inc.
 */
public interface AnyFlowContent_c<
    D  extends AnyDocument<D>,
    PC extends Content<D, PC>,
    _c extends AnyFlowContent_c<D, PC, _c>
    >
    extends AnyFlowContent<D, _c>,
    //
    // Unions:
    //
    // Inherited: AnyUnion_COLGROUP_ScriptSupporting_c<D, PC, _c>
    // Inherited: AnyUnion_DL_Palpable_c<D, PC, _c>
    // Inherited: AnyUnion_Embedded_Interactive_c<D, PC, _c>
    // Inherited: AnyUnion_Embedded_Palpable_Phrasing_c<D, PC, _c>
    // Inherited: AnyUnion_Interactive_Phrasing_c<D, PC, _c>
    // Inherited: AnyUnion_Metadata_Phrasing_c<D, PC, _c>
    // Inherited: AnyUnion_Palpable_Phrasing_c<D, PC, _c>

    //
    // Content models:
    //
    // Inherited: Content_c<D, PC, _c>
    // Inherited: AnyEmbeddedContent_c<D, PC, _c>
    // Inherited: AnyHeadingContent_c<D, PC, _c>
    // Inherited: AnyInteractiveContent_c<D, PC, _c>
    AnyPalpableContent_c<D, PC, _c>,
    AnyPhrasingContent_c<D, PC, _c> {
  // Inherited: AnyScriptSupportingContent_c<D, PC, _c>
  // Inherited: AnySectioningContent_c<D, PC, _c>
  // Inherited: AnyTextContent_c<D, PC, _c>

}
