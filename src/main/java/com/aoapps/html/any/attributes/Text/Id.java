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
package com.aoapps.html.any.attributes.Text;

import com.aoapps.encoding.MediaWritable;
import static com.aoapps.encoding.TextInXhtmlAttributeEncoder.textInXhtmlAttributeEncoder;
import com.aoapps.hodgepodge.i18n.MarkupType;
import com.aoapps.html.any.Attributes;
import com.aoapps.html.any.Element;
import com.aoapps.lang.io.function.IOSupplierE;
import java.io.IOException;

/**
 * <ul>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#the-id-attribute">3.2.6 Global attributes / id</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/id">Global attributes / id</a>.</li>
 * <li>See <a href="https://www.w3schools.com/tags/att_global_id.asp">id Attribute</a>.</li>
 * </ul>
 * <blockquote>
 * In HTML5, the id attribute can be used on <b>any</b> HTML element (it will validate on any HTML element. However, it is not necessarily useful).
 * </blockquote>
 *
 * @param  <E>   This element type
 *
 * @author  AO Industries, Inc.
 */
// TODO: Move to String?
// Matches IdNoHtml4
public interface Id<E extends Element<?, ?, E> & Id<E>> {

	/**
	 * <ul>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#the-id-attribute">3.2.6 Global attributes / id</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/id">Global attributes / id</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/tags/att_global_id.asp">id Attribute</a>.</li>
	 * </ul>
	 * <blockquote>
	 * In HTML5, the id attribute can be used on <b>any</b> HTML element (it will validate on any HTML element. However, it is not necessarily useful).
	 * </blockquote>
	 */
	@Attributes.Funnel
	default E id(Object id) throws IOException {
		@SuppressWarnings("unchecked") E element = (E)this;
		// TODO: Validate, with doctype-aware character constraints.  XmlUtils can help, or build into Doctype itself.
		return Attributes.Text.attribute(element, "id", MarkupType.NONE, id, true, true, textInXhtmlAttributeEncoder);
	}

	/**
	 * <ul>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#the-id-attribute">3.2.6 Global attributes / id</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/id">Global attributes / id</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/tags/att_global_id.asp">id Attribute</a>.</li>
	 * </ul>
	 * <blockquote>
	 * In HTML5, the id attribute can be used on <b>any</b> HTML element (it will validate on any HTML element. However, it is not necessarily useful).
	 * </blockquote>
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 *
	 * @see #id(java.lang.Object)
	 */
	default <Ex extends Throwable> E id(IOSupplierE<?, Ex> id) throws IOException, Ex {
		return id((id == null) ? null : id.get());
	}

	/**
	 * <ul>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#the-id-attribute">3.2.6 Global attributes / id</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/id">Global attributes / id</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/tags/att_global_id.asp">id Attribute</a>.</li>
	 * </ul>
	 * <blockquote>
	 * In HTML5, the id attribute can be used on <b>any</b> HTML element (it will validate on any HTML element. However, it is not necessarily useful).
	 * </blockquote>
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 *
	 * @see #id(java.lang.Object)
	 */
	default <Ex extends Throwable> E id(MediaWritable<Ex> id) throws IOException, Ex {
		return id((Object)id);
	}
}
