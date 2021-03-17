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
package com.aoindustries.html.any.attributes.Text;

import com.aoindustries.encoding.MediaWritable;
import static com.aoindustries.encoding.TextInXhtmlAttributeEncoder.textInXhtmlAttributeEncoder;
import com.aoindustries.html.any.Attributes;
import com.aoindustries.html.any.Element;
import com.aoindustries.io.function.IOSupplierE;
import com.aoindustries.util.i18n.MarkupType;
import java.io.IOException;

/**
 * See <a href="https://html.spec.whatwg.org/multipage/iframe-embed-object.html#attr-object-type">4.8.7 The object element / type</a>.
 *
 * @param  <E>   This element type
 *
 * @author  AO Industries, Inc.
 */
public interface Type<E extends Element<?, ?, E> & Type<E>> {

	/**
	 * See <a href="https://html.spec.whatwg.org/multipage/iframe-embed-object.html#attr-object-type">4.8.7 The object element / type</a>.
	 */
	@Attributes.Funnel
	default E type(Object type) throws IOException {
		@SuppressWarnings("unchecked") E element = (E)this;
		return Attributes.Text.attribute(element, "type", MarkupType.NONE, type, true, true, textInXhtmlAttributeEncoder);
	}

	/**
	 * See <a href="https://html.spec.whatwg.org/multipage/iframe-embed-object.html#attr-object-type">4.8.7 The object element / type</a>.
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 *
	 * @see #type(java.lang.Object)
	 */
	default <Ex extends Throwable> E type(IOSupplierE<?, Ex> type) throws IOException, Ex {
		return type((type == null) ? null : type.get());
	}

	/**
	 * See <a href="https://html.spec.whatwg.org/multipage/iframe-embed-object.html#attr-object-type">4.8.7 The object element / type</a>.
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 *
	 * @see #type(java.lang.Object)
	 */
	default <Ex extends Throwable> E type(MediaWritable<Ex> type) throws IOException, Ex {
		return type((Object)type);
	}
}
