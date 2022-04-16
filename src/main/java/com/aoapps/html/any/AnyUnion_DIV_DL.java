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
 * Elements that are common to both {@link AnyDIV_content} and {@link AnyDL_content}.
 *
 * @param  <D>   This document type
 * @param  <__>  This content model, which will be the parent content model of child elements
 *
 * @author  AO Industries, Inc.
 */
public interface AnyUnion_DIV_DL<
	D  extends AnyDocument<D>,
	__ extends AnyUnion_DIV_DL<D, __>
> extends
	//
	// Content models:
	//
	Content<D, __>
{
	//
	// Factories:
	//
	// <editor-fold defaultstate="collapsed" desc="DD">
	/**
	 * Opens a new dd element.
	 * <ul>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/grouping-content.html#the-dd-element">4.4.11 The dd element</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/dd">&lt;dd&gt;: The Description Details element</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/tags/tag_dd.asp">HTML dd tag</a>.</li>
	 * </ul>
	 */
	@Factory("dd")
	AnyDD<D, __, ?, ?, ?> dd() throws IOException;

	/**
	 * Creates a dd element with no attributes and the given body.
	 * <ul>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/grouping-content.html#the-dd-element">4.4.11 The dd element</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/dd">&lt;dd&gt;: The Description Details element</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/tags/tag_dd.asp">HTML dd tag</a>.</li>
	 * </ul>
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 *
	 * @return  This content model, which will be the parent content model of child elements
	 */
	@Factory("dd")
	default <Ex extends Throwable> __ dd__(IORunnableE<Ex> dd) throws IOException, Ex {
		return dd().__(dd);
	}

	/**
	 * Creates a dd element with no attributes and the given body.
	 * <ul>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/grouping-content.html#the-dd-element">4.4.11 The dd element</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/dd">&lt;dd&gt;: The Description Details element</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/tags/tag_dd.asp">HTML dd tag</a>.</li>
	 * </ul>
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 *
	 * @return  This content model, which will be the parent content model of child elements
	 */
	@Factory("dd")
	default <Ex extends Throwable> __ dd__any(IOConsumerE<? super AnyDD__<D, __, ? extends AnyDD__<D, __, ?>>, Ex> dd) throws IOException, Ex {
		return dd().__(dd);
	}

	/**
	 * Creates a dd element with no attributes and a text body.
	 * <ul>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/grouping-content.html#the-dd-element">4.4.11 The dd element</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/dd">&lt;dd&gt;: The Description Details element</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/tags/tag_dd.asp">HTML dd tag</a>.</li>
	 * </ul>
	 *
	 * @return  This content model, which will be the parent content model of child elements
	 */
	@Factory("dd")
	default __ dd__(Object text) throws IOException {
		return dd().__(text);
	}

	/**
	 * Creates an empty dd element with no attributes.
	 * <ul>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/grouping-content.html#the-dd-element">4.4.11 The dd element</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/dd">&lt;dd&gt;: The Description Details element</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/tags/tag_dd.asp">HTML dd tag</a>.</li>
	 * </ul>
	 *
	 * @return  This content model, which will be the parent content model of child elements
	 */
	@Factory("dd")
	default __ dd__() throws IOException {
		return dd().__();
	}

	/**
	 * Creates a dd element with no attributes then begins element content
	 * <ul>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/grouping-content.html#the-dd-element">4.4.11 The dd element</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/dd">&lt;dd&gt;: The Description Details element</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/tags/tag_dd.asp">HTML dd tag</a>.</li>
	 * </ul>
	 *
	 * @return  The content model of this element, which will be the parent content model of child elements.
	 *          This must be {@linkplain Closeable#__() ended} or {@linkplain Closeable#close() closed} in order to end
	 *          the tag.  This is well suited for use in a try-with-resources block.
	 *
	 * @see  Closeable#__()
	 * @see  Closeable#close()
	 */
	@Factory("dd")
	AnyDD_c<D, __, ?> dd_c() throws IOException;
	// </editor-fold>
	// <editor-fold defaultstate="collapsed" desc="DT">
	/**
	 * Opens a new dt element.
	 * <ul>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/grouping-content.html#the-dt-element">4.4.10 The dt element</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/dt">&lt;dt&gt;: The Description Term element</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/tags/tag_dt.asp">HTML dt tag</a>.</li>
	 * </ul>
	 */
	@Factory("dt")
	AnyDT<D, __, ?, ?, ?> dt() throws IOException;

	/**
	 * Creates a dt element with no attributes and the given body.
	 * <ul>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/grouping-content.html#the-dt-element">4.4.10 The dt element</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/dt">&lt;dt&gt;: The Description Term element</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/tags/tag_dt.asp">HTML dt tag</a>.</li>
	 * </ul>
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 *
	 * @return  This content model, which will be the parent content model of child elements
	 */
	@Factory("dt")
	default <Ex extends Throwable> __ dt__(IORunnableE<Ex> dt) throws IOException, Ex {
		return dt().__(dt);
	}

	/**
	 * Creates a dt element with no attributes and the given body.
	 * <ul>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/grouping-content.html#the-dt-element">4.4.10 The dt element</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/dt">&lt;dt&gt;: The Description Term element</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/tags/tag_dt.asp">HTML dt tag</a>.</li>
	 * </ul>
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 *
	 * @return  This content model, which will be the parent content model of child elements
	 */
	@Factory("dt")
	default <Ex extends Throwable> __ dt__any(IOConsumerE<? super AnyDT__<D, __, ? extends AnyDT__<D, __, ?>>, Ex> dt) throws IOException, Ex {
		return dt().__(dt);
	}

	/**
	 * Creates a dt element with no attributes and a text body.
	 * <ul>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/grouping-content.html#the-dt-element">4.4.10 The dt element</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/dt">&lt;dt&gt;: The Description Term element</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/tags/tag_dt.asp">HTML dt tag</a>.</li>
	 * </ul>
	 *
	 * @return  This content model, which will be the parent content model of child elements
	 */
	@Factory("dt")
	default __ dt__(Object text) throws IOException {
		return dt().__(text);
	}

	/**
	 * Creates an empty dt element with no attributes.
	 * <ul>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/grouping-content.html#the-dt-element">4.4.10 The dt element</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/dt">&lt;dt&gt;: The Description Term element</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/tags/tag_dt.asp">HTML dt tag</a>.</li>
	 * </ul>
	 *
	 * @return  This content model, which will be the parent content model of child elements
	 */
	@Factory("dt")
	default __ dt__() throws IOException {
		return dt().__();
	}

	/**
	 * Creates a dt element with no attributes then begins element content
	 * <ul>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/grouping-content.html#the-dt-element">4.4.10 The dt element</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/dt">&lt;dt&gt;: The Description Term element</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/tags/tag_dt.asp">HTML dt tag</a>.</li>
	 * </ul>
	 *
	 * @return  The content model of this element, which will be the parent content model of child elements.
	 *          This must be {@linkplain Closeable#__() ended} or {@linkplain Closeable#close() closed} in order to end
	 *          the tag.  This is well suited for use in a try-with-resources block.
	 *
	 * @see  Closeable#__()
	 * @see  Closeable#close()
	 */
	@Factory("dt")
	AnyDT_c<D, __, ?> dt_c() throws IOException;
	// </editor-fold>
}
