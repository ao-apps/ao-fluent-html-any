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
 * <li>See <a href="https://html.spec.whatwg.org/multipage/embedded-content.html#the-source-element">4.8.2 The source element</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/source">&lt;source&gt;: The Media or Image Source element</a>.</li>
 * <li>See <a href="https://www.w3schools.com/tags/tag_source.asp">HTML source Tag</a>.</li>
 * </ul>
 *
 * @since HTML 5
 *
 * @author  AO Industries, Inc.
 */
// TODO: implements Onerror<E>
public abstract class AnySOURCE {
	// TODO: __ extends TODO<D, __>
	// TODO: "the source element's src attribute has no meaning when the element is nested within a picture element"
	//       Can we have a subclass of AnySOURCE that is used for AnyPICTURE_content, which would deprecate src attribute?
	// TODO
}
