/*
 * ao-fluent-html-any - Base abstract classes and interfaces for Fluent Java DSL for high-performance HTML generation.
 * Copyright (C) 2022  AO Industries, Inc.
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
 * <li>See <a href="https://html.spec.whatwg.org/multipage/form-elements.html#the-button-element">4.10.6 The button element</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/button">&lt;button&gt;: The Button element</a>.</li>
 * <li>See <a href="https://www.w3schools.com/tags/tag_button.asp">HTML button tag</a>.</li>
 * </ul>
 *
 * @author  AO Industries, Inc.
 */
// TODO: implements com.aoapps.html.any.attributes.Enum.Autocapitalize (comment that also added to <input type="button"> since declared here)
// TODO: implements Formenctype<E> (and many others similar to AnyINPUT.Submit
// TODO: com.aoapps.html.any.attributes.Integer.TabindexHtml4<E>,
public abstract class AnyBUTTON {
  // TODO: Phrasing content, but there must be no interactive content descendant and no descendant with the tabindex attribute specified.
  //           A sub-interface AnyInteractiveContentBlocked of AnyInteractiveContent, deprecating all methods?
  //               This sub-interface might also apply other places where specification says "must be no interactive content descendant"
  //               This might be of shallow benefit, as Phrasing -> element -> Phrasing nesting would lose knowledge of parent being blocked interative.
  //                   Unless this additional level of interface relationships were maintained through every element and interface
  //       AnyBUTTON content extends AnyPhrasingContent and deprecates all methods from AnyInteractiveContent?
  //       Certainly no easy way to enforce no tabindex on descendents (other than complicating implementation)
  //           Also no way to conditionally deprecate tabindex, short of having NoTabIndex variants of absolutely every element and interface
  // TODO
}
