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
 * Elements that are common to all three of {@link AnyTBODY}, {@link AnyTHEAD}, and {@link AnyTFOOT}.
 * <ul>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/tables.html#the-tbody-element">4.9.5 The tbody element</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/tbody">&lt;tbody&gt;: The Table Body element</a>.</li>
 * <li>See <a href="https://www.w3schools.com/tags/tag_tbody.asp">HTML tbody tag</a>.</li>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/tables.html#the-thead-element">4.9.6 The thead element</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/thead">&lt;thead&gt;: The Table Head element</a>.</li>
 * <li>See <a href="https://www.w3schools.com/tags/tag_thead.asp">HTML thead tag</a>.</li>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/tables.html#the-tfoot-element">4.9.7 The tfoot element</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/tfoot">&lt;tfoot&gt;: The Table Foot element</a>.</li>
 * <li>See <a href="https://www.w3schools.com/tags/tag_tfoot.asp">HTML tfoot tag</a>.</li>
 * </ul>
 *
 * @param  <D>   This document type
 * @param  <PC>  The parent content model this element is within
 * @param  <_c>  This content model as {@link Closeable}, which will be the parent content model of child elements
 *
 * @author  AO Industries, Inc.
 */
public interface AnyUnion_TBODY_THEAD_TFOOT_c<
    D  extends AnyDocument<D>,
    PC extends Content<D, PC>,
    _c extends AnyUnion_TBODY_THEAD_TFOOT_c<D, PC, _c>
    >
    extends AnyUnion_TBODY_THEAD_TFOOT<D, _c>,
    //
    // Unions:
    //
    // Inherited: AnyCOLGROUP_ScriptSupporting_c<D, PC, _c>

    //
    // Content models:
    //
    // Inherited: Content_c<D, PC, _c>
    AnyScriptSupportingContent_c<D, PC, _c> {

}
