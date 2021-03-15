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

import com.aoindustries.collections.AoArrays;
import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;

/**
 * @see  AnyInteractiveContent
 *
 * @author  AO Industries, Inc.
 */
@SuppressWarnings("rawtypes")
public class AnyInteractiveContentTest {

	private final Class<? extends AnyInteractiveContent> testingClass;

	protected AnyInteractiveContentTest(Class<? extends AnyInteractiveContent> testingClass) {
		this.testingClass = testingClass;
	}

	public AnyInteractiveContentTest() {
		this(AnyInteractiveContent.class);
	}

	@Test
	@SuppressWarnings("unchecked")
	public void testUnions() {
		AnyUnionContentTest.testUnions(
			AnyInteractiveContent.class,
			//
			// Unions:
			//
			AnyUnion_Embedded_Interactive.class,
			AnyUnion_Interactive_Phrasing.class
		);
	}

	@Test
	@SuppressWarnings("unchecked")
	public void testContentModels() {
		ContentModelTest.testContentModels(
			AnyInteractiveContent.class,
			//
			// Content models:
			//
			Content.class
		);
	}

	@Test
	@SuppressWarnings("unchecked")
	public void testElementContentModels() {
		ElementContentModelTest.testElementContentModels(
			AnyInteractiveContent.class
			//
			// Per-element content models:
			//
			// None
		);
	}

	@Test
	public void testFactories() throws IOException {
		FactoryTest.testFactories(
			testingClass,
			//
			// Factories:
			//
			"a", // if the href attribute is present
			"audio", // if the controls attribute is present
			"button",
			"details",
			"embed",
			"iframe",
			"img", // if the usemap attribute is present
			"input", // if type attribute is not in the hidden state
			"label",
			"menu", // (MDN only) if the type attribute is in the toolbar state
			"object", // if the usemap attribute is present
			"select",
			"textarea",
			"video" // if the controls attribute is present
		);
	}

	@Test
	public void testNoImplementInherited() {
		Assert.assertNotEquals(
			"Must be included in " + ContentModelTest.class.getSimpleName() + ".getAllContentModels()",
			-1,
			AoArrays.indexOf(ContentModelTest.getAllContentModels(), AnyInteractiveContent.class)
		);
		InheritanceTests.testNoImplementInherited(Content.class, AnyInteractiveContent.class);
	}
}
