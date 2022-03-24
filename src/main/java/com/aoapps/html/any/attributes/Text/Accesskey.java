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
package com.aoapps.html.any.attributes.Text;

import com.aoapps.encoding.Doctype;
import com.aoapps.encoding.MediaWritable;
import static com.aoapps.encoding.TextInXhtmlAttributeEncoder.textInXhtmlAttributeEncoder;
import com.aoapps.hodgepodge.i18n.MarkupType;
import com.aoapps.html.any.Attributes;
import static com.aoapps.html.any.Attributes.RESOURCES;
import com.aoapps.html.any.Element;
import com.aoapps.lang.LocalizedIllegalArgumentException;
import com.aoapps.lang.io.function.IOSupplierE;
import java.io.IOException;

/**
 * <ul>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/interaction.html#the-accesskey-attribute">6.7.2 The accesskey attribute</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/accesskey">Global attributes / accesskey</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/accessKey">HTMLElement.accessKey</a>.</li>
 * <li>See <a href="https://www.w3schools.com/tags/att_global_accesskey.asp">HTML accesskey Attributes</a>.</li>
 * </ul>
 *
 * @param  <E>   This element type
 *
 * @since HTML 5
 *
 * @author  AO Industries, Inc.
 */
// Matches AccesskeyUnexpected
public interface Accesskey<E extends Element<?, ?, E> & Accesskey<E>> {

	/**
	 * <ul>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/interaction.html#the-accesskey-attribute">6.7.2 The accesskey attribute</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/accesskey">Global attributes / accesskey</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/accessKey">HTMLElement.accessKey</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/tags/att_global_accesskey.asp">HTML accesskey Attributes</a>.</li>
	 * </ul>
	 *
	 * @since HTML 5
	 */
	@Attributes.Funnel
	default E accesskey(Object accesskey) throws IOException {
		@SuppressWarnings("unchecked") E element = (E)this;
		if(element.getDocument().doctype != Doctype.HTML5) {
			throw new LocalizedIllegalArgumentException(
				RESOURCES,
				"onlySupportedInHtml5",
				element.getDocument().doctype,
				"accesskey"
			);
		}
		return Attributes.Text.attribute(element, "accesskey", MarkupType.NONE, accesskey, true, true, textInXhtmlAttributeEncoder);
	}

	/**
	 * <ul>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/interaction.html#the-accesskey-attribute">6.7.2 The accesskey attribute</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/accesskey">Global attributes / accesskey</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/accessKey">HTMLElement.accessKey</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/tags/att_global_accesskey.asp">HTML accesskey Attributes</a>.</li>
	 * </ul>
	 *
	 * @since HTML 5
	 */
	default E accesskey(int ... codePoints) throws IOException {
		if(codePoints != null && codePoints.length > 0) {
			// Default size optimized for Unicode BMP
			StringBuilder accesskey = new StringBuilder(codePoints.length * 2 - 1);
			for(int i = 0; i < codePoints.length; i++) {
				int codePoint = codePoints[i];
				if(i > 0) accesskey.append(' ');
				if(Character.isBmpCodePoint(codePoint)) {
					accesskey.append((char)codePoint);
				} else if(Character.isValidCodePoint(codePoint)) {
					accesskey.append(Character.lowSurrogate(codePoint));
					accesskey.append(Character.highSurrogate(codePoint));
				} else {
					throw new IllegalArgumentException(String.format("Invalid code point: 0x%X", codePoint));
				}
			}
			return accesskey(accesskey);
		} else {
			@SuppressWarnings("unchecked") E element = (E)this;
			return element;
		}
	}

	/**
	 * <ul>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/interaction.html#the-accesskey-attribute">6.7.2 The accesskey attribute</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/accesskey">Global attributes / accesskey</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/accessKey">HTMLElement.accessKey</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/tags/att_global_accesskey.asp">HTML accesskey Attributes</a>.</li>
	 * </ul>
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 *
	 * @since HTML 5
	 *
	 * @see #accesskey(java.lang.Object)
	 */
	default <Ex extends Throwable> E accesskey(IOSupplierE<?, Ex> accesskey) throws IOException, Ex {
		return accesskey((accesskey == null) ? null : accesskey.get());
	}

	/**
	 * <ul>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/interaction.html#the-accesskey-attribute">6.7.2 The accesskey attribute</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/accesskey">Global attributes / accesskey</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/accessKey">HTMLElement.accessKey</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/tags/att_global_accesskey.asp">HTML accesskey Attributes</a>.</li>
	 * </ul>
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 *
	 * @since HTML 5
	 *
	 * @see #accesskey(java.lang.Object)
	 */
	default <Ex extends Throwable> E accesskey(MediaWritable<Ex> accesskey) throws IOException, Ex {
		return accesskey((Object)accesskey);
	}
}
