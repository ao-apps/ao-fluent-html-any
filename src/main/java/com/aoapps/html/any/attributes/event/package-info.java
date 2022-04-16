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

/**
 * <ul>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#event-handlers-on-elements,-document-objects,-and-window-objects">8.1.7.2 Event handlers on elements, Document objects, and Window objects</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers">GlobalEventHandlers</a>.</li>
 * <li>See <a href="https://www.w3schools.com/jsref/dom_obj_event.asp">HTML DOM Event Object</a>.</li>
 * <li>See <a href="https://www.w3schools.com/tags/ref_eventattributes.asp">Clipboard Events</a>.</li>
 * <li>See <a href="https://www.w3schools.com/tags/ref_eventattributes.asp">Drag Events</a>.</li>
 * <li>See <a href="https://www.w3schools.com/tags/ref_eventattributes.asp">Form Events</a>.</li>
 * <li>See <a href="https://www.w3schools.com/tags/ref_eventattributes.asp">Keyboard Events</a>.</li>
 * <li>See <a href="https://www.w3schools.com/tags/ref_eventattributes.asp">Media Events</a>.</li>
 * <li>See <a href="https://www.w3schools.com/tags/ref_eventattributes.asp">Misc Events</a>.</li>
 * <li>See <a href="https://www.w3schools.com/tags/ref_eventattributes.asp">Mouse Events</a>.</li>
 * <li>See <a href="https://www.w3schools.com/tags/ref_eventattributes.asp">Window Events</a>.</li>
 * </ul>
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

package com.aoapps.html.any.attributes.event;
