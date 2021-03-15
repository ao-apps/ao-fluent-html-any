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
package com.aoindustries.html.any;

import java.io.IOException;

/**
 * See <a href="https://html.spec.whatwg.org/multipage/semantics.html#the-html-element">4.1.1 The html element</a>.
 *
 * @param  <D>   This document type
 * @param  <__>  This content model, which will be the parent content model of child elements
 *
 * @author  AO Industries, Inc.
 */
public interface AnyHTML_content<
	D  extends AnyDocument<D>,
	__ extends AnyHTML_content<D, __>
> extends
	//
	// Content models:
	//
	Content<D, __>
{
	//
	// Factories:
	//
	// <editor-fold defaultstate="collapsed" desc="HEAD">
	/**
	 * Opens a new head element.
	 * <p>
	 * See <a href="https://html.spec.whatwg.org/multipage/semantics.html#the-head-element">4.2.1 The head element</a>.
	 * </p>
	 */
	@Factory("head")
	default void head() throws IOException {
		throw new AssertionError("TODO: Implement head");
	}
	// TODO: Head tag will not indent
	// </editor-fold>
	// <editor-fold defaultstate="collapsed" desc="BODY">
	/**
	 * Opens a new body element.
	 * <p>
	 * See <a href="https://html.spec.whatwg.org/multipage/sections.html#the-body-element">4.3.1 The body element</a>.
	 * </p>
	 */
	@Factory("body")
	default void body() throws IOException {
		throw new AssertionError("TODO: Implement body");
	}
	// TODO: Body tag will not indent
	// </editor-fold>
}
