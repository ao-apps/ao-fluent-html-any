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
 * along with ao-fluent-html-any.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.aoapps.html.any;

import java.io.IOException;

/**
 * When the content of an element is closed, the element's ending tag is written then the enclosing content model is
 * returned.
 *
 * @param  <D>   This document type
 * @param  <PC>  The parent content model this element is within
 *
 * @author  AO Industries, Inc.
 */
public interface Closeable<
	D  extends AnyDocument<D>,
	PC extends Content<D, PC>
> extends java.io.Closeable {

	/**
	 * Closes the content and ends the parent tag.
	 * This is for use in try-with-resources, and simply calls {@link #__()}.
	 *
	 * @see  #__()
	 */
	@Override
	default void close() throws IOException {
		__();
	}

	/**
	 * Closes the content and ends the parent tag.
	 *
	 * @return  The parent content model this element is within
	 *
	 * @see  #close()
	 */
	PC __() throws IOException;
}
