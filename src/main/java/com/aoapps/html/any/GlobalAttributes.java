/*
 * ao-fluent-html-any - Base abstract classes and interfaces for Fluent Java DSL for high-performance HTML generation.
 * Copyright (C) 2019, 2020, 2021  AO Industries, Inc.
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
 * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes">3.2.6 Global attributes</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes">Global attributes</a>.</li>
 * <li>See <a href="https://www.w3schools.com/tags/ref_standardattributes.asp">HTML Global attributes</a>.</li>
 * </ul>
 *
 * @param  <E>   This element type
 *
 * @author  AO Industries, Inc.
 */
@SuppressWarnings("deprecation")
public interface GlobalAttributes<E extends Element<?, ?, E> & GlobalAttributes<E>> extends
	// TODO: accesskey
	// TODO: autocapitalize
	// TODO: autofocus (whatwg only)
	com.aoapps.html.any.attributes.Text.Class<E>,
	// TODO: contenteditable
	// TODO: contextmenu (deprecated)
	com.aoapps.html.any.attributes.Text.Data<E>,
	com.aoapps.html.any.attributes.Enum.Dir<E, com.aoapps.html.any.attributes.Enum.Dir.Value>,
	// TODO: draggable
	// TODO: dropzone (experimental)
	// TODO: enterkeyhint (whatwg only)
	// TODO: exportparts (experimental)
	// TODO: hidden
	com.aoapps.html.any.attributes.Text.Id<E>,
	// TODO: inputmode
	// TODO: is
	// TODO: itemid
	// TODO: itemprop
	// TODO: itemref
	// TODO: itemscope
	// TODO: itemtype
	com.aoapps.html.any.attributes.String.Lang<E>,
	// TODO: none (whatwg only)
	// TODO: part (experimental)
	// TODO: slot
	// TODO: spellcheck (experimental)
	com.aoapps.html.any.attributes.Text.Style<E>,
	com.aoapps.html.any.attributes.Integer.Tabindex<E>,
	com.aoapps.html.any.attributes.Text.Title<E>,
	// TODO: translate (experimental)
	// Global Event Attributes: https://www.w3schools.com/tags/ref_eventattributes.asp
	// Form
	com.aoapps.html.any.attributes.event.form.Oncontextmenu<E>,
	// TODO: onautocomplete
	// TODO: onautocompleteerror
	// Mouse
	com.aoapps.html.any.attributes.event.mouse.Onmousewheel<E>,
	com.aoapps.html.any.attributes.event.mouse.Onwheel<E>,
	// Drag
	com.aoapps.html.any.attributes.event.drag.Ondrag<E>,
	com.aoapps.html.any.attributes.event.drag.Ondragend<E>,
	com.aoapps.html.any.attributes.event.drag.Ondragenter<E>,
	com.aoapps.html.any.attributes.event.drag.Ondragleave<E>,
	com.aoapps.html.any.attributes.event.drag.Ondragover<E>,
	com.aoapps.html.any.attributes.event.drag.Ondragstart<E>,
	com.aoapps.html.any.attributes.event.drag.Ondrop<E>,
	// Clipboard
	com.aoapps.html.any.attributes.event.clipboard.Oncopy<E>,
	com.aoapps.html.any.attributes.event.clipboard.Oncut<E>,
	com.aoapps.html.any.attributes.event.clipboard.Onpaste<E>
	// TODO: onsort? https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes
{
	// No methods, just adding attributes
}
