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
 * along with ao-fluent-html-any.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.aoindustries.html.any.attributes.Text;

import com.aoindustries.encoding.Doctype;
import com.aoindustries.encoding.MediaWritable;
import com.aoindustries.html.any.Attributes;
import static com.aoindustries.html.any.Attributes.RESOURCES;
import com.aoindustries.html.any.Element;
import com.aoindustries.io.function.IOSupplierE;
import com.aoindustries.lang.LocalizedIllegalArgumentException;
import java.io.IOException;

/**
 * See <a href="https://www.w3schools.com/tags/att_global_title.asp">HTML Global title Attribute</a>.
 * <blockquote>
 * In HTML 4.01, the title attribute cannot be used with: &lt;base&gt;, &lt;head&gt;, &lt;html&gt;, &lt;meta&gt;, &lt;param&gt;, &lt;script&gt;, &lt;style&gt;, and &lt;title&gt;.
 * </blockquote>
 *
 * @param  <E>   This element type
 *
 * @author  AO Industries, Inc.
 */
public interface TitleNoHtml4<E extends Element<?, ?, E> & TitleNoHtml4<E>> extends Title<E> {

	/**
	 * See <a href="https://www.w3schools.com/tags/att_global_title.asp">HTML Global title Attribute</a>.
	 * <blockquote>
	 * In HTML 4.01, the title attribute cannot be used with: &lt;base&gt;, &lt;head&gt;, &lt;html&gt;, &lt;meta&gt;, &lt;param&gt;, &lt;script&gt;, &lt;style&gt;, and &lt;title&gt;.
	 * </blockquote>
	 */
	@Override
	@Attributes.Funnel
	default E title(Object title) throws IOException {
		@SuppressWarnings("unchecked") E element = (E)this;
		if(element.getDocument().doctype != Doctype.HTML5) {
			throw new LocalizedIllegalArgumentException(
				RESOURCES,
				"invalidGlobalAttributeForDoctype",
				element.getDocument().doctype,
				"title"
			);
		}
		return Title.super.title(title);
	}

	/**
	 * See <a href="https://www.w3schools.com/tags/att_global_title.asp">HTML Global title Attribute</a>.
	 * <blockquote>
	 * In HTML 4.01, the title attribute cannot be used with: &lt;base&gt;, &lt;head&gt;, &lt;html&gt;, &lt;meta&gt;, &lt;param&gt;, &lt;script&gt;, &lt;style&gt;, and &lt;title&gt;.
	 * </blockquote>
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 *
	 * @see #title(java.lang.Object)
	 */
	@Override
	default <Ex extends Throwable> E title(IOSupplierE<?, Ex> title) throws IOException, Ex {
		@SuppressWarnings("unchecked") E element = (E)this;
		if(element.getDocument().doctype != Doctype.HTML5) {
			throw new LocalizedIllegalArgumentException(
				RESOURCES,
				"invalidGlobalAttributeForDoctype",
				element.getDocument().doctype,
				"title"
			);
		}
		return Title.super.title(title);
	}

	/**
	 * See <a href="https://www.w3schools.com/tags/att_global_title.asp">HTML Global title Attribute</a>.
	 * <blockquote>
	 * In HTML 4.01, the title attribute cannot be used with: &lt;base&gt;, &lt;head&gt;, &lt;html&gt;, &lt;meta&gt;, &lt;param&gt;, &lt;script&gt;, &lt;style&gt;, and &lt;title&gt;.
	 * </blockquote>
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 *
	 * @see #title(java.lang.Object)
	 */
	@Override
	default <Ex extends Throwable> E title(MediaWritable<Ex> title) throws IOException, Ex {
		@SuppressWarnings("unchecked") E element = (E)this;
		if(element.getDocument().doctype != Doctype.HTML5) {
			throw new LocalizedIllegalArgumentException(
				RESOURCES,
				"invalidGlobalAttributeForDoctype",
				element.getDocument().doctype,
				"title"
			);
		}
		return Title.super.title(title);
	}
}
