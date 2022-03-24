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
package com.aoapps.html.any.attributes.Boolean;

import com.aoapps.encoding.Doctype;
import com.aoapps.html.any.Attributes;
import static com.aoapps.html.any.Attributes.RESOURCES;
import com.aoapps.html.any.Element;
import com.aoapps.lang.LocalizedIllegalArgumentException;
import com.aoapps.lang.io.function.IOSupplierE;
import java.io.IOException;

/**
 * <ul>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/interaction.html#the-autofocus-attribute">6.6.7 The autofocus attribute</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/autofocus">Global attributes / autofocus</a>.</li>
 * <li>See <a href="https://www.w3schools.com/tags/att_autofocus.asp">HTML autofocus Attribute</a>.</li>
 * </ul>
 *
 * @param  <E>   This element type
 *
 * @since HTML 5
 *
 * @author  AO Industries, Inc.
 */
// Matches AutofocusUnexpected
public interface Autofocus<E extends Element<?, ?, E> & Autofocus<E>> {

	/**
	 * <ul>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/interaction.html#the-autofocus-attribute">6.6.7 The autofocus attribute</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/autofocus">Global attributes / autofocus</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/tags/att_autofocus.asp">HTML autofocus Attribute</a>.</li>
	 * </ul>
	 *
	 * @since HTML 5
	 */
	@Attributes.Funnel
	default E autofocus(boolean autofocus) throws IOException {
		@SuppressWarnings("unchecked") E element = (E)this;
		if(element.getDocument().doctype != Doctype.HTML5) {
			throw new LocalizedIllegalArgumentException(
				RESOURCES,
				"onlySupportedInHtml5",
				element.getDocument().doctype,
				"autofocus"
			);
		}
		return Attributes.Boolean.attribute(element, "autofocus", autofocus);
	}

	/**
	 * <ul>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/interaction.html#the-autofocus-attribute">6.6.7 The autofocus attribute</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/autofocus">Global attributes / autofocus</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/tags/att_autofocus.asp">HTML autofocus Attribute</a>.</li>
	 * </ul>
	 *
	 * @see #autofocus(boolean)
	 *
	 * @since HTML 5
	 */
	default E autofocus(Boolean autofocus) throws IOException {
		return autofocus(autofocus != null && autofocus);
	}

	/**
	 * <ul>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/interaction.html#the-autofocus-attribute">6.6.7 The autofocus attribute</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/autofocus">Global attributes / autofocus</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/tags/att_autofocus.asp">HTML autofocus Attribute</a>.</li>
	 * </ul>
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 *
	 * @since HTML 5
	 *
	 * @see #autofocus(java.lang.Boolean)
	 */
	default <Ex extends Throwable> E autofocus(IOSupplierE<? extends Boolean, Ex> autofocus) throws IOException, Ex {
		return autofocus((autofocus == null) ? null : autofocus.get());
	}
}
