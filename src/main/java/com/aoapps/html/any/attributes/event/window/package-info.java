/*
 * ao-fluent-html-any - Base abstract classes and interfaces for Fluent Java DSL for high-performance HTML generation.
 * Copyright (C) 2021  AO Industries, Inc.
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

/**
 * See <a href="https://www.w3schools.com/tags/ref_eventattributes.asp">Window Events</a>.
 * <p>
 * Per-attribute interfaces with default implementations.
 * </p>
 * <p>
 * Attributes are attached to elements by simply implementing the interface.  Thanks to the default methods on the
 * interfaces, the element has a fully functional attribute with just the one-liner.  However, the elements still have
 * the option to override the attribute.
 * </p>
 *
 * @see  com.aoapps.html.any.Attributes.Event
 */
package com.aoapps.html.any.attributes.event.window;

// TODO: oncancel
//       https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes
//       https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/oncancel
//       https://developer.mozilla.org/en-US/docs/Web/HTML/Element/dialog

// TODO: onclose
//       https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes
//       https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/onclose
//       https://developer.mozilla.org/en-US/docs/Web/HTML/Element/dialog
