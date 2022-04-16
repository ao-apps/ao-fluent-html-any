/*
 * ao-fluent-html-any - Base abstract classes and interfaces for Fluent Java DSL for high-performance HTML generation.
 * Copyright (C) 2021, 2022  AO Industries, Inc.
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
import com.aoapps.encoding.TextWritable;
import com.aoapps.hodgepodge.i18n.MarkupType;
import com.aoapps.html.any.Attributes;
import com.aoapps.html.any.Element;
import com.aoapps.lang.io.function.IOSupplierE;
import java.io.IOException;

/**
 * See <a href="https://html.spec.whatwg.org/multipage/forms.html#attr-label-for">4.10.4 The label element / for</a>.
 *
 * @param  <E>   This element type
 *
 * @author  AO Industries, Inc.
 */
public interface For<E extends Element<?, ?, E> & For<E>> {

	/**
	 * See <a href="https://html.spec.whatwg.org/multipage/forms.html#attr-label-for">4.10.4 The label element / for</a>.
	 */
	// "for" is keyword, so named "forAttr", despite not typically using "Attr" suffix
	@Attributes.Funnel
	default E forAttr(Object forAttr) throws IOException {
		@SuppressWarnings("unchecked") E element = (E)this;
		return Attributes.Text.attribute(element, "for", MarkupType.NONE, forAttr, true, true, textInXhtmlAttributeEncoder);
	}

	/**
	 * See <a href="https://html.spec.whatwg.org/multipage/forms.html#attr-label-for">4.10.4 The label element / for</a>.
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 *
	 * @see #forAttr(java.lang.Object)
	 */
	// "for" is keyword, so named "forAttr", despite not typically using "Attr" suffix
	default <Ex extends Throwable> E forAttr(IOSupplierE<?, Ex> forAttr) throws IOException, Ex {
		return forAttr((forAttr == null) ? null : forAttr.get());
	}

	/**
	 * See <a href="https://html.spec.whatwg.org/multipage/forms.html#attr-label-for">4.10.4 The label element / for</a>.
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 *
	 * @see #forAttr(java.lang.Object)
	 */
	// "for" is keyword, so named "forAttr", despite not typically using "Attr" suffix
	default <Ex extends Throwable> E forAttr(TextWritable<Ex> forAttr) throws IOException, Ex {
		return forAttr((Object)forAttr);
	}
}
