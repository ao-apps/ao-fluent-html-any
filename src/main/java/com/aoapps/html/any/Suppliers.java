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
package com.aoapps.html.any;

import com.aoapps.lang.Iterables;
import com.aoapps.lang.io.function.IOSupplierE;
import java.io.IOException;

/**
 * Variant bounded by classes other than {@link Object}, since can't have multiple methods with different bounds due to erasure.
 *
 * @see  Iterables
 *
 * @author  AO Industries, Inc.
 */
// TODO: Move to ao-lang, since it is very similar to the new Iterables utility class.
public class Suppliers {

	private Suppliers() {}

	/**
	 * Variant bounded by {@link com.aoapps.html.any.Circle}, since can't have multiple methods with different bounds due to erasure.
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 */
	@FunctionalInterface
	public interface Circle<Ex extends Throwable> extends IOSupplierE<com.aoapps.html.any.Circle, Ex> {

		/**
		 * @return  The attribute value or {@code null} for no attribute.
		 */
		@Override
		com.aoapps.html.any.Circle get() throws IOException, Ex;
	}

	/**
	 * Variant bounded by {@link java.util.Locale}, since can't have multiple methods with different bounds due to erasure.
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 */
	@FunctionalInterface
	public interface Locale<Ex extends Throwable> extends IOSupplierE<java.util.Locale, Ex> {

		/**
		 * @return  The attribute value or {@code null} for no attribute.
		 */
		@Override
		java.util.Locale get() throws IOException, Ex;
	}

	/**
	 * Variant bounded by {@link java.awt.Polygon}, since can't have multiple methods with different bounds due to erasure.
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 */
	@FunctionalInterface
	public interface Polygon<Ex extends Throwable> extends IOSupplierE<java.awt.Polygon, Ex> {

		/**
		 * @return  The attribute value or {@code null} for no attribute.
		 */
		@Override
		java.awt.Polygon get() throws IOException, Ex;
	}

	/**
	 * Variant bounded by {@link java.awt.Rectangle}, since can't have multiple methods with different bounds due to erasure.
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 */
	@FunctionalInterface
	public interface Rectangle<Ex extends Throwable> extends IOSupplierE<java.awt.Rectangle, Ex> {

		/**
		 * @return  The attribute value or {@code null} for no attribute.
		 */
		@Override
		java.awt.Rectangle get() throws IOException, Ex;
	}

	/**
	 * Variant bounded by {@link java.awt.Shape}, since can't have multiple methods with different bounds due to erasure.
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 */
	@FunctionalInterface
	public interface Shape<Ex extends Throwable> extends IOSupplierE<java.awt.Shape, Ex> {

		/**
		 * @return  The attribute value or {@code null} for no attribute.
		 */
		@Override
		java.awt.Shape get() throws IOException, Ex;
	}

	/**
	 * Variant bounded by {@link java.lang.String}, since can't have multiple methods with different bounds due to erasure.
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 */
	@FunctionalInterface
	public interface String<Ex extends Throwable> extends IOSupplierE<java.lang.String, Ex> {

		/**
		 * @return  The attribute value, {@link Attributes#NO_VALUE} (by identity, not value) for an empty attribute, {@code null} for no attribute.
		 */
		@Override
		java.lang.String get() throws IOException, Ex;
	}
}
