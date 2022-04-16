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

import static com.aoapps.encoding.TextInXhtmlAttributeEncoder.textInXhtmlAttributeEncoder;
import com.aoapps.encoding.XhtmlAttributeWritable;
import com.aoapps.hodgepodge.i18n.MarkupType;
import com.aoapps.html.any.Attributes;
import com.aoapps.html.any.Element;
import com.aoapps.lang.io.function.IOSupplierE;
import java.io.IOException;

/**
 * An arbitrary attribute.
 *
 * @param  <E>   This element type
 *
 * @author  AO Industries, Inc.
 */
public interface Attribute<E extends Element<?, ?, E> & Attribute<E>> {

	/**
	 * An arbitrary attribute.
	 *
	 * @param value  The attribute value, {@link Attributes#NO_VALUE} (by identity, not value) for an empty attribute, {@code null} for no attribute.
	 *
	 * @deprecated  Please implement specific attributes as-needed
	 */
	@Deprecated
	@Attributes.Funnel
	default E attribute(String name, Object value) throws IOException {
		@SuppressWarnings("unchecked") E element = (E)this;
		// TODO: Validate attribute name by doctype: https://dev.w3.org/html5/html-author/#attributes (XmlUtils could help)
		return Attributes.Text.attribute(element, name, MarkupType.NONE, value, false, false, textInXhtmlAttributeEncoder);
	}

	/**
	 * An arbitrary attribute.
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 * @param value  The attribute value, {@link Attributes#NO_VALUE} (by identity, not value) for an empty attribute, {@code null} for no attribute.
	 *
	 * @see #attribute(java.lang.String, java.lang.Object)
	 *
	 * @deprecated  Please implement specific attributes as-needed
	 */
	@Deprecated
	default <Ex extends Throwable> E attribute(String name, IOSupplierE<?, Ex> value) throws IOException, Ex {
		return attribute(name, (value == null) ? null : value.get());
	}

	/**
	 * An arbitrary attribute.
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 *
	 * @see #attribute(java.lang.String, java.lang.Object)
	 *
	 * @deprecated  Please implement specific attributes as-needed
	 */
	@Deprecated
	// TODO: Just MediaWritable here?  How does this interact with the various types of MediaWriters?
	default <Ex extends Throwable> E attribute(String name, XhtmlAttributeWritable<Ex> value) throws IOException, Ex {
		return attribute(name, (Object)value);
	}
}
