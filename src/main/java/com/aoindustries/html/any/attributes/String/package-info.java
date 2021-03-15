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
 * along with ao-fluent-html-any.  If not, see <http://www.gnu.org/licenses/>.
 */

/**
 * Non-streamable text attributes (expected to be short, relatively fixed values)
 * <p>
 * Per-attribute interfaces with default implementations.
 * </p>
 * <p>
 * Attributes are attached to elements by simply implementing the interface.  Thanks to the default methods on the
 * interfaces, the element has a fully functional attribute with just the one-liner.  However, the elements still have
 * the option to override the attribute.
 * </p>
 *
 * @see  com.aoindustries.html.any.Attributes.String
 */
// TODO: Move some non-streamable attributes from Text to here, such as id and name
//       Or, just use "text" for all, since text types are already optimized for String, but are still streamble
package com.aoindustries.html.any.attributes.String;
