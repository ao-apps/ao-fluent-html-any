/*
 * ao-fluent-html-any - Base abstract classes and interfaces for Fluent Java DSL for high-performance HTML generation.
 * Copyright (C) 2021, 2022, 2024  AO Industries, Inc.
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
 * See <a href="https://html.spec.whatwg.org/multipage/common-microsyntaxes.html#keywords-and-enumerated-attributes">2.4.3 Keywords and enumerated attributes</a>.
 *
 * <p>Per-attribute interfaces with default implementations.</p>
 *
 * <p>Attributes are attached to elements by simply implementing the interface.  Thanks to the default methods on the
 * interfaces, the element has a fully functional attribute with just the one-liner.  However, the elements still have
 * the option to override the attribute.</p>
 *
 * <p>Values may be provided either as a {@link java.lang.String} or an {@link java.lang.Enum},
 * with the {@link java.lang.Enum} representation preferred.  The {@link java.lang.String}
 * value is allowed for values that are not part of the enumeration.</p>
 *
 * <p>When converting from {@link java.lang.Enum}, uses {@link java.util.function.Function}. giving the
 * {@link com.aoapps.html.any.AnyDocument}.  This allows the enum to select values by
 * {@link com.aoapps.encoding.Serialization} and/or {@link com.aoapps.encoding.Doctype}, as-needed.</p>
 *
 * @see  com.aoapps.html.any.Attributes
 */
// TODO: Link to Attributes.Enum or Attributes.String possible?

package com.aoapps.html.any.attributes.enumeration;
