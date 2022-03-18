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

import com.aoapps.encoding.Doctype;
import com.aoapps.lang.io.function.IOConsumerE;
import com.aoapps.lang.io.function.IORunnableE;
import com.aoapps.lang.io.function.IOSupplierE;
import java.io.IOException;

/**
 * <ul>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#metadata-content">3.2.5.2.1 Metadata content</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/Guide/HTML/Content_categories#metadata_content">Metadata content</a>.</li>
 * </ul>
 *
 * @param  <D>   This document type
 * @param  <__>  This content model, which will be the parent content model of child elements
 *
 * @author  AO Industries, Inc.
 */
public interface AnyMetadataContent<
	D  extends AnyDocument<D>,
	__ extends AnyMetadataContent<D, __>
> extends
	//
	// Unions:
	//
	// Inherited: AnyUnion_COLGROUP_ScriptSupporting<D, __>
	AnyUnion_Metadata_Phrasing<D, __>

	//
	// Content models:
	//
	// Inherited: Content<D, __>
	// Inherited: AnyScriptSupportingContent<D, __>
{
	//
	// Factories:
	//
	// <editor-fold defaultstate="collapsed" desc="BASE">
	/**
	 * Opens a new base element.
	 * <ul>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/semantics.html#the-base-element">4.2.3 The base element</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/base">&lt;base&gt;: The Document Base URL element</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/tags/tag_base.asp">HTML base tag</a>.</li>
	 * </ul>
	 */
	@Factory("base")
	AnyBASE<D, __, ?> base() throws IOException;

	/**
	 * Shortcut to create a base with href only.
	 * <ul>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/semantics.html#the-base-element">4.2.3 The base element</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/base">&lt;base&gt;: The Document Base URL element</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/tags/tag_base.asp">HTML base tag</a>.</li>
	 * </ul>
	 *
	 * @return  This content model, which will be the parent content model of child elements
	 */
	@Factory("base")
	default __ base__(String href) throws IOException {
		return base().href(href).__();
	}
	// TODO: IOSupplierE version like A? (review others, too)
	// </editor-fold>
	// Inherited: LINK
	// Inherited: META
	// Inherited: NOSCRIPT
	// Inherited: SCRIPT
	// <editor-fold defaultstate="collapsed" desc="STYLE">
	/**
	 * Opens a new style element.
	 * <ul>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/semantics.html#the-style-element">4.2.6 The style element</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/tags/tag_style.asp">HTML style tag</a>.</li>
	 * </ul>
	 *
	 * @see Doctype#styleType(java.lang.Appendable)
	 */
	@Factory("style")
	AnySTYLE<D, __, ?> style() throws IOException;

	/**
	 * Opens a new style element of the given type.
	 * <ul>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/semantics.html#the-style-element">4.2.6 The style element</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/tags/tag_style.asp">HTML style tag</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/tags/att_style_type.asp">HTML style type Attribute</a>.</li>
	 * </ul>
	 */
	@Factory("style")
	AnySTYLE<D, __, ?> style(String type) throws IOException;

	/**
	 * Opens a new style element of the given type.
	 * <ul>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/semantics.html#the-style-element">4.2.6 The style element</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/tags/tag_style.asp">HTML style tag</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/tags/att_style_type.asp">HTML style type Attribute</a>.</li>
	 * </ul>
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 */
	@Factory("style")
	<Ex extends Throwable> AnySTYLE<D, __, ?> style(Suppliers.String<Ex> type) throws IOException, Ex;

	/**
	 * Opens a new style element of the given type.
	 * <ul>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/semantics.html#the-style-element">4.2.6 The style element</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/tags/tag_style.asp">HTML style tag</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/tags/att_style_type.asp">HTML style type Attribute</a>.</li>
	 * </ul>
	 */
	@Factory("style")
	AnySTYLE<D, __, ?> style(AnySTYLE.Type type) throws IOException;

	/**
	 * Opens a new style element of the given type.
	 * <ul>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/semantics.html#the-style-element">4.2.6 The style element</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/tags/tag_style.asp">HTML style tag</a>.</li>
	 * <li>See <a href="https://www.w3schools.com/tags/att_style_type.asp">HTML style type Attribute</a>.</li>
	 * </ul>
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 */
	@Factory("style")
	<Ex extends Throwable> AnySTYLE<D, __, ?> style(IOSupplierE<? extends AnySTYLE.Type, Ex> type) throws IOException, Ex;
	// TODO: style__() - go directly to out, since no attributes? Lambda versions, too
	// TODO: A version called HtmlWriter that extends ChainWriter to avoid all this passing of appendables?
	// TODO: html.input.style.type().print("...").__().  How far do we take this?
	// </editor-fold>
	// Inherited: TEMPLATE - WHATWG only
	// <editor-fold defaultstate="collapsed" desc="TITLE">
	/**
	 * Opens a new title element.
	 * <p>
	 * See <a href="https://html.spec.whatwg.org/multipage/semantics.html#the-title-element">4.2.2 The title element</a>.
	 * </p>
	 */
	@Factory("title")
	AnyTITLE<D, __, ?, ?, ?> title() throws IOException;

	/**
	 * Creates a title element with no attributes and the given body.
	 * <p>
	 * See <a href="https://html.spec.whatwg.org/multipage/semantics.html#the-title-element">4.2.2 The title element</a>.
	 * </p>
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 *
	 * @return  This content model, which will be the parent content model of child elements
	 */
	@Factory("title")
	default <Ex extends Throwable> __ title__(IORunnableE<Ex> title) throws IOException, Ex {
		return title().__(title);
	}

	/**
	 * Creates a title element with no attributes and the given body.
	 * <p>
	 * See <a href="https://html.spec.whatwg.org/multipage/semantics.html#the-title-element">4.2.2 The title element</a>.
	 * </p>
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 *
	 * @return  This content model, which will be the parent content model of child elements
	 */
	@Factory("title")
	default <Ex extends Throwable> __ title__any(IOConsumerE<? super AnyTITLE__<D, __, ? extends AnyTITLE__<D, __, ?>>, Ex> title) throws IOException, Ex {
		return title().__(title);
	}

	/**
	 * Creates a title element with no attributes and a text body.
	 * <p>
	 * See <a href="https://html.spec.whatwg.org/multipage/semantics.html#the-title-element">4.2.2 The title element</a>.
	 * </p>
	 *
	 * @return  This content model, which will be the parent content model of child elements
	 */
	@Factory("title")
	default __ title__(Object text) throws IOException {
		return title().__(text);
	}

// Empty element not expected.  Requires "Text that is not inter-element whitespace":
//	/**
//	 * Creates an empty title element with no attributes.
//	 * <p>
//	 * See <a href="https://html.spec.whatwg.org/multipage/semantics.html#the-title-element">4.2.2 The title element</a>.
//	 * </p>
//	 *
//	 * @return  This content model, which will be the parent content model of child elements
//	 */
//	@Factory("title")
//	default __ title__() throws IOException {
//		return title().__();
//	}

	/**
	 * Creates a title element with no attributes then begins element content
	 * <p>
	 * See <a href="https://html.spec.whatwg.org/multipage/semantics.html#the-title-element">4.2.2 The title element</a>.
	 * </p>
	 *
	 * @return  The content model of this element, which will be the parent content model of child elements.
	 *          This must be {@linkplain Closeable#__() ended} or {@linkplain Closeable#close() closed} in order to end
	 *          the tag.  This is well suited for use in a try-with-resources block.
	 *
	 * @see  Closeable#__()
	 * @see  Closeable#close()
	 */
	@Factory("title")
	AnyTITLE_c<D, __, ?> title_c() throws IOException;
	// </editor-fold>
}
