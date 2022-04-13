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
package com.aoapps.html.any;

import com.aoapps.lang.io.function.IOConsumerE;
import com.aoapps.lang.io.function.IORunnableE;
import java.io.IOException;

/**
 * <ul>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/tables.html#the-tr-element">4.9.8 The tr element</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/tr">&lt;tr&gt;: The Table Row element</a>.</li>
 * <li>See <a href="https://www.w3schools.com/tags/tag_tr.asp">HTML tr tag</a>.</li>
 * </ul>
 *
 * @param  <D>   This document type
 * @param  <__>  This content model, which will be the parent content model of child elements
 *
 * @author  AO Industries, Inc.
 */
public interface AnyTR_content<
	D  extends AnyDocument<D>,
	__ extends AnyTR_content<D, __>
> extends
	//
	// Unions:
	//
	// Inherited: AnyUnion_COLGROUP_ScriptSupporting<D, __>

	//
	// Content models:
	//
	// Inherited: Content<D, __>
	AnyScriptSupportingContent<D, __>
{
	//
	// Factories:
	//
	// <editor-fold defaultstate="collapsed" desc="TD">
	/**
	 * Opens a new td element.
	 * <ul>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/tables.html#the-td-element">4.9.9 The td element</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/td">&lt;td&gt;: The Table Data Cell element</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/tags/tag_td.asp">HTML td tag</a>.</li>
	 * </ul>
	 */
	@Factory("td")
	AnyTD<D, __, ?, ?, ?> td() throws IOException;

	/**
	 * Creates a td element with no attributes and the given body.
	 * <ul>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/tables.html#the-td-element">4.9.9 The td element</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/td">&lt;td&gt;: The Table Data Cell element</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/tags/tag_td.asp">HTML td tag</a>.</li>
	 * </ul>
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 *
	 * @return  This content model, which will be the parent content model of child elements
	 */
	@Factory("td")
	default <Ex extends Throwable> __ td__(IORunnableE<Ex> td) throws IOException, Ex {
		return td().__(td);
	}

	/**
	 * Creates a td element with no attributes and the given body.
	 * <ul>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/tables.html#the-td-element">4.9.9 The td element</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/td">&lt;td&gt;: The Table Data Cell element</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/tags/tag_td.asp">HTML td tag</a>.</li>
	 * </ul>
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 *
	 * @return  This content model, which will be the parent content model of child elements
	 */
	@Factory("td")
	default <Ex extends Throwable> __ td__any(IOConsumerE<? super AnyTD__<D, __, ? extends AnyTD__<D, __, ?>>, Ex> td) throws IOException, Ex {
		return td().__(td);
	}

	/**
	 * Creates a td element with no attributes and a text body.
	 * <ul>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/tables.html#the-td-element">4.9.9 The td element</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/td">&lt;td&gt;: The Table Data Cell element</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/tags/tag_td.asp">HTML td tag</a>.</li>
	 * </ul>
	 *
	 * @return  This content model, which will be the parent content model of child elements
	 */
	@Factory("td")
	default __ td__(Object text) throws IOException {
		return td().__(text);
	}

	/**
	 * Creates an empty td element with no attributes.
	 * <ul>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/tables.html#the-td-element">4.9.9 The td element</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/td">&lt;td&gt;: The Table Data Cell element</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/tags/tag_td.asp">HTML td tag</a>.</li>
	 * </ul>
	 *
	 * @return  This content model, which will be the parent content model of child elements
	 */
	@Factory("td")
	default __ td__() throws IOException {
		return td().__();
	}

	/**
	 * Creates a td element with no attributes then begins element content
	 * <ul>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/tables.html#the-td-element">4.9.9 The td element</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/td">&lt;td&gt;: The Table Data Cell element</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/tags/tag_td.asp">HTML td tag</a>.</li>
	 * </ul>
	 *
	 * @return  The content model of this element, which will be the parent content model of child elements.
	 *          This must be {@linkplain Closeable#__() ended} or {@linkplain Closeable#close() closed} in order to end
	 *          the tag.  This is well suited for use in a try-with-resources block.
	 *
	 * @see  Closeable#__()
	 * @see  Closeable#close()
	 */
	@Factory("td")
	AnyTD_c<D, __, ?> td_c() throws IOException;
	// </editor-fold>
	// <editor-fold defaultstate="collapsed" desc="TH">
	/**
	 * Opens a new th element.
	 * <ul>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/tables.html#the-th-element">4.9.10 The th element</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/th">&lt;th&gt;: The Table Header element</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/tags/tag_th.asp">HTML th tag</a>.</li>
	 * </ul>
	 */
	@Factory("th")
	AnyTH<D, __, ?, ?, ?> th() throws IOException;

	/**
	 * Creates a th element with no attributes and the given body.
	 * <ul>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/tables.html#the-th-element">4.9.10 The th element</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/th">&lt;th&gt;: The Table Header element</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/tags/tag_th.asp">HTML th tag</a>.</li>
	 * </ul>
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 *
	 * @return  This content model, which will be the parent content model of child elements
	 */
	@Factory("th")
	default <Ex extends Throwable> __ th__(IORunnableE<Ex> th) throws IOException, Ex {
		return th().__(th);
	}

	/**
	 * Creates a th element with no attributes and the given body.
	 * <ul>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/tables.html#the-th-element">4.9.10 The th element</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/th">&lt;th&gt;: The Table Header element</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/tags/tag_th.asp">HTML th tag</a>.</li>
	 * </ul>
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 *
	 * @return  This content model, which will be the parent content model of child elements
	 */
	@Factory("th")
	default <Ex extends Throwable> __ th__any(IOConsumerE<? super AnyTH__<D, __, ? extends AnyTH__<D, __, ?>>, Ex> th) throws IOException, Ex {
		return th().__(th);
	}

	/**
	 * Creates a th element with no attributes and a text body.
	 * <ul>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/tables.html#the-th-element">4.9.10 The th element</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/th">&lt;th&gt;: The Table Header element</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/tags/tag_th.asp">HTML th tag</a>.</li>
	 * </ul>
	 *
	 * @return  This content model, which will be the parent content model of child elements
	 */
	@Factory("th")
	default __ th__(Object text) throws IOException {
		return th().__(text);
	}

	/**
	 * Creates an empty th element with no attributes.
	 * <ul>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/tables.html#the-th-element">4.9.10 The th element</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/th">&lt;th&gt;: The Table Header element</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/tags/tag_th.asp">HTML th tag</a>.</li>
	 * </ul>
	 *
	 * @return  This content model, which will be the parent content model of child elements
	 */
	@Factory("th")
	default __ th__() throws IOException {
		return th().__();
	}

	/**
	 * Creates a th element with no attributes then begins element content
	 * <ul>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/tables.html#the-th-element">4.9.10 The th element</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/th">&lt;th&gt;: The Table Header element</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/tags/tag_th.asp">HTML th tag</a>.</li>
	 * </ul>
	 *
	 * @return  The content model of this element, which will be the parent content model of child elements.
	 *          This must be {@linkplain Closeable#__() ended} or {@linkplain Closeable#close() closed} in order to end
	 *          the tag.  This is well suited for use in a try-with-resources block.
	 *
	 * @see  Closeable#__()
	 * @see  Closeable#close()
	 */
	@Factory("th")
	AnyTH_c<D, __, ?> th_c() throws IOException;
	// </editor-fold>
	// Inherited: SCRIPT
	// Inherited: TEMPLATE
}
