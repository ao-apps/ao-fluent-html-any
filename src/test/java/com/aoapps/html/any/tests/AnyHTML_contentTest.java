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
package com.aoapps.html.any.tests;

import com.aoapps.collections.AoArrays;
import com.aoapps.html.any.AnyHTML_content;
import com.aoapps.html.any.Content;
import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;

/**
 * @see  AnyHTML_content
 *
 * @author  AO Industries, Inc.
 */
@SuppressWarnings("rawtypes")
public class AnyHTML_contentTest {

	private final Class<? extends AnyHTML_content> testingClass;

	protected AnyHTML_contentTest(Class<? extends AnyHTML_content> testingClass) {
		this.testingClass = testingClass;
	}

	public AnyHTML_contentTest() {
		this(AnyHTML_content.class);
	}

	@Test
	@SuppressWarnings("unchecked")
	public void testUnions() {
		AnyUnionContentTest.testUnions(
			AnyHTML_content.class
			//
			// Unions:
			//
			// None
		);
	}

	@Test
	@SuppressWarnings("unchecked")
	public void testContentModels() {
		ContentModelTest.testContentModels(
			AnyHTML_content.class,
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
			AnyHTML_content.class
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
			"head",
			"body"
		);
	}

	@Test
	public void testNoImplementInherited() {
		Assert.assertNotEquals(
			"Must be included in " + ElementContentModelTest.class.getSimpleName() + ".getAllElementContentModels()",
			-1,
			AoArrays.indexOf(ElementContentModelTest.getAllElementContentModels(), AnyHTML_content.class)
		);
		InheritanceTests.testNoImplementInherited(Content.class, AnyHTML_content.class);
	}
}