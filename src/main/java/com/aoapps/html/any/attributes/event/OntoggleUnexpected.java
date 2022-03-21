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
package com.aoapps.html.any.attributes.event;

import com.aoapps.encoding.Doctype;
import com.aoapps.encoding.MediaWritable;
import com.aoapps.html.any.AnyDETAILS;
import com.aoapps.html.any.Attributes;
import static com.aoapps.html.any.Attributes.RESOURCES;
import com.aoapps.html.any.Element;
import com.aoapps.lang.LocalizedIllegalArgumentException;
import com.aoapps.lang.io.function.IOSupplierE;
import java.io.IOException;

/**
 * <ul>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-ontoggle">3.2.6 Global attributes / ontoggle</a>.</li>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-ontoggle">8.1.7.2 Event handlers on elements, Document objects, and Window objects / ontoggle</a>.</li>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-ontoggle">8.1.7.2.1 IDL definitions / ontoggle</a>.</li>
 * <li>See <a href="https://www.w3schools.com/jsref/event_ontoggle.asp">ontoggle Event</a>.</li>
 * </ul>
 *
 * @param  <E>   This element type
 *
 * @since HTML 5
 *
 * @deprecated  Although the ontoggle attribute is global, it is only expected on
 *              {@linkplain AnyDETAILS &lt;details&gt;}.
 *
 * @author  AO Industries, Inc.
 */
// Matches Ontoggle
@Deprecated
public interface OntoggleUnexpected<E extends Element<?, ?, E> & OntoggleUnexpected<E>> {

	/**
	 * <ul>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-ontoggle">3.2.6 Global attributes / ontoggle</a>.</li>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-ontoggle">8.1.7.2 Event handlers on elements, Document objects, and Window objects / ontoggle</a>.</li>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-ontoggle">8.1.7.2.1 IDL definitions / ontoggle</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/jsref/event_ontoggle.asp">ontoggle Event</a>.</li>
	 * </ul>
	 *
	 * @since HTML 5
	 *
	 * @deprecated  Although the ontoggle attribute is global, it is only expected on
	 *              {@linkplain AnyDETAILS &lt;details&gt;}.
	 */
	@Deprecated
	@Attributes.Funnel
	default E ontoggle(Object ontoggle) throws IOException {
		@SuppressWarnings("unchecked") E element = (E)this;
		if(element.getDocument().doctype != Doctype.HTML5) {
			throw new LocalizedIllegalArgumentException(
				RESOURCES,
				"onlySupportedInHtml5",
				element.getDocument().doctype,
				"ontoggle"
			);
		}
		return Attributes.Event.attribute(element, "ontoggle", ontoggle);
	}

	/**
	 * <ul>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-ontoggle">3.2.6 Global attributes / ontoggle</a>.</li>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-ontoggle">8.1.7.2 Event handlers on elements, Document objects, and Window objects / ontoggle</a>.</li>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-ontoggle">8.1.7.2.1 IDL definitions / ontoggle</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/jsref/event_ontoggle.asp">ontoggle Event</a>.</li>
	 * </ul>
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 *
	 * @since HTML 5
	 *
	 * @see #ontoggle(java.lang.Object)
	 *
	 * @deprecated  Although the ontoggle attribute is global, it is only expected on
	 *              {@linkplain AnyDETAILS &lt;details&gt;}.
	 */
	@Deprecated
	default <Ex extends Throwable> E ontoggle(IOSupplierE<?, Ex> ontoggle) throws IOException, Ex {
		return ontoggle((ontoggle == null) ? null : ontoggle.get());
	}

	/**
	 * <ul>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-ontoggle">3.2.6 Global attributes / ontoggle</a>.</li>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#handler-ontoggle">8.1.7.2 Event handlers on elements, Document objects, and Window objects / ontoggle</a>.</li>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-ontoggle">8.1.7.2.1 IDL definitions / ontoggle</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/jsref/event_ontoggle.asp">ontoggle Event</a>.</li>
	 * </ul>
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 *
	 * @since HTML 5
	 *
	 * @see #ontoggle(java.lang.Object)
	 *
	 * @deprecated  Although the ontoggle attribute is global, it is only expected on
	 *              {@linkplain AnyDETAILS &lt;details&gt;}.
	 */
	@Deprecated
	default <Ex extends Throwable> E ontoggle(MediaWritable<Ex> ontoggle) throws IOException, Ex {
		return ontoggle((Object)ontoggle);
	}
}
