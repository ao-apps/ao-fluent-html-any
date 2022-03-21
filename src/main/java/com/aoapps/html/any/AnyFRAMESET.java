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
 * TODO
 *
 * @author  AO Industries, Inc.
 */
// TODO: Implements other attributes similar to AnyBODY per https://html.spec.whatwg.org/multipage/obsolete.html#frameset :
//       "The frameset element acts as the body element in documents that use frames."
//       https://html.spec.whatwg.org/multipage/webappapis.html#handler-onresize :
//       "The following are the event handlers (and their corresponding event handler event types) that must be supported by all HTML elements other than body and frameset elements" ...
// TODO: implements Onerror<E>
// TODO: implements Onload<E>
// TODO: implements Onresize<E>
@Deprecated
public abstract class AnyFRAMESET {
	// TODO
}
