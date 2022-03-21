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
package com.aoapps.html.any.attributes.Integer;

import com.aoapps.encoding.Doctype;
import com.aoapps.html.any.Attributes;
import static com.aoapps.html.any.Attributes.RESOURCES;
import com.aoapps.html.any.Element;
import com.aoapps.lang.LocalizedIllegalArgumentException;
import com.aoapps.lang.io.function.IOSupplierE;
import java.io.IOException;

/**
 * <ul>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/interaction.html#the-tabindex-attribute">6.6.3 The tabindex attribute</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/tabindex">Global attributes / tabindex</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/tabIndex">HTMLElement.tabIndex</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Learn/Accessibility/HTML#building_keyboard_accessibility_back_in">Building keyboard accessibility back in</a>.</li>
 * <li>See <a href="https://www.w3schools.com/tags/att_global_tabindex.asp">HTML tabindex Attribute</a>.</li>
 * </ul>
 * <blockquote>
 * In HTML5, the tabindex attribute can be used on <b>any</b> HTML element (it will validate on any HTML element. However, it is not necessarily useful).
 * </blockquote>
 *
 * @param  <E>   This element type
 *
 * @since HTML 5
 *
 * @author  AO Industries, Inc.
 */
// Matches TabindexHtml4
public interface Tabindex<E extends Element<?, ?, E> & Tabindex<E>> {

	/**
	 * <ul>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/interaction.html#the-tabindex-attribute">6.6.3 The tabindex attribute</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/tabindex">Global attributes / tabindex</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/tabIndex">HTMLElement.tabIndex</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Learn/Accessibility/HTML#building_keyboard_accessibility_back_in">Building keyboard accessibility back in</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/tags/att_global_tabindex.asp">HTML tabindex Attribute</a>.</li>
	 * </ul>
	 * <blockquote>
	 * In HTML5, the tabindex attribute can be used on <b>any</b> HTML element (it will validate on any HTML element. However, it is not necessarily useful).
	 * </blockquote>
	 *
	 * @since HTML 5
	 */
	@Attributes.Funnel
	default E tabindex(int tabindex) throws IOException {
		@SuppressWarnings("unchecked") E element = (E)this;
		if(element.getDocument().doctype != Doctype.HTML5) {
			throw new LocalizedIllegalArgumentException(
				RESOURCES,
				"onlySupportedInHtml5",
				element.getDocument().doctype,
				"tabindex"
			);
		}
		return Attributes.Integer.attribute(element, "tabindex", tabindex);
	}

	/**
	 * <ul>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/interaction.html#the-tabindex-attribute">6.6.3 The tabindex attribute</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/tabindex">Global attributes / tabindex</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/tabIndex">HTMLElement.tabIndex</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Learn/Accessibility/HTML#building_keyboard_accessibility_back_in">Building keyboard accessibility back in</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/tags/att_global_tabindex.asp">HTML tabindex Attribute</a>.</li>
	 * </ul>
	 * <blockquote>
	 * In HTML5, the tabindex attribute can be used on <b>any</b> HTML element (it will validate on any HTML element. However, it is not necessarily useful).
	 * </blockquote>
	 *
	 * @since HTML 5
	 */
	@Attributes.Funnel
	default E tabindex(Integer tabindex) throws IOException {
		@SuppressWarnings("unchecked") E element = (E)this;
		if(element.getDocument().doctype != Doctype.HTML5) {
			throw new LocalizedIllegalArgumentException(
				RESOURCES,
				"onlySupportedInHtml5",
				element.getDocument().doctype,
				"tabindex"
			);
		}
		return Attributes.Integer.attribute(element, "tabindex", tabindex);
	}

	/**
	 * <ul>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/interaction.html#the-tabindex-attribute">6.6.3 The tabindex attribute</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/tabindex">Global attributes / tabindex</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/tabIndex">HTMLElement.tabIndex</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Learn/Accessibility/HTML#building_keyboard_accessibility_back_in">Building keyboard accessibility back in</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/tags/att_global_tabindex.asp">HTML tabindex Attribute</a>.</li>
	 * </ul>
	 * <blockquote>
	 * In HTML5, the tabindex attribute can be used on <b>any</b> HTML element (it will validate on any HTML element. However, it is not necessarily useful).
	 * </blockquote>
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 *
	 * @since HTML 5
	 *
	 * @see #tabindex(java.lang.Integer)
	 */
	default <Ex extends Throwable> E tabindex(IOSupplierE<? extends Integer, Ex> tabindex) throws IOException, Ex {
		return tabindex((tabindex == null) ? null : tabindex.get());
	}
}
