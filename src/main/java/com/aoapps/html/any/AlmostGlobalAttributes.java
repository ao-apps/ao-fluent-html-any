/*
 * ao-fluent-html-any - Base abstract classes and interfaces for Fluent Java DSL for high-performance HTML generation.
 * Copyright (C) 2019, 2020, 2021, 2022  AO Industries, Inc.
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
 * See <a href="https://www.w3schools.com/tags/ref_eventattributes.asp">HTML Event Attributes</a>.
 * Supported HTML tags:
 * <blockquote>
 * All HTML elements, EXCEPT: &lt;base&gt;, &lt;bdo&gt;, &lt;br&gt;, &lt;head&gt;, &lt;html&gt;, &lt;iframe&gt;, &lt;meta&gt;, &lt;param&gt;, &lt;script&gt;, &lt;style&gt;, and &lt;title&gt;
 * </blockquote>
 *
 * @param  <E>   This element type
 *
 * @author  AO Industries, Inc.
 */
public interface AlmostGlobalAttributes<E extends Element<?, ?, E> & AlmostGlobalAttributes<E>> extends
	// Form
	com.aoapps.html.any.attributes.event.Onblur<E>,
	com.aoapps.html.any.attributes.event.Onfocus<E>,
	// Keyboard
	com.aoapps.html.any.attributes.event.Onkeydown<E>,
	com.aoapps.html.any.attributes.event.Onkeypress<E>,
	com.aoapps.html.any.attributes.event.Onkeyup<E>,
	// Mouse
	com.aoapps.html.any.attributes.event.Onclick<E>,
	com.aoapps.html.any.attributes.event.Ondblclick<E>,
	com.aoapps.html.any.attributes.event.Onmousedown<E>,
	com.aoapps.html.any.attributes.event.Onmousemove<E>,
	com.aoapps.html.any.attributes.event.Onmouseout<E>,
	com.aoapps.html.any.attributes.event.Onmouseover<E>,
	com.aoapps.html.any.attributes.event.Onmouseup<E>
{
	// No methods, just adding event types
}
