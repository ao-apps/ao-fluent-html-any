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
package com.aoapps.html.any.tests;

import com.aoapps.collections.AoArrays;
import com.aoapps.html.any.AnyEmbeddedContent;
import com.aoapps.html.any.AnyPhrasingContent;
import com.aoapps.html.any.AnyScriptSupportingContent;
import com.aoapps.html.any.AnyTextContent;
import com.aoapps.html.any.AnyUnion_COLGROUP_ScriptSupporting;
import com.aoapps.html.any.AnyUnion_Embedded_Interactive;
import com.aoapps.html.any.AnyUnion_Embedded_Palpable_Phrasing;
import com.aoapps.html.any.AnyUnion_Interactive_Phrasing;
import com.aoapps.html.any.AnyUnion_Metadata_Phrasing;
import com.aoapps.html.any.AnyUnion_Palpable_Phrasing;
import com.aoapps.html.any.Content;
import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;

/**
 * @see  AnyPhrasingContent
 *
 * @author  AO Industries, Inc.
 */
@SuppressWarnings("rawtypes")
public class AnyPhrasingContentTest {

	private final Class<? extends AnyPhrasingContent> testingClass;

	protected AnyPhrasingContentTest(Class<? extends AnyPhrasingContent> testingClass) {
		this.testingClass = testingClass;
	}

	public AnyPhrasingContentTest() {
		this(AnyPhrasingContent.class);
	}

	@Test
	@SuppressWarnings("unchecked")
	public void testUnions() {
		AnyUnionContentTest.testUnions(
			AnyPhrasingContent.class,
			//
			// Unions:
			//
			AnyUnion_COLGROUP_ScriptSupporting.class,
			AnyUnion_Embedded_Interactive.class,
			AnyUnion_Embedded_Palpable_Phrasing.class,
			AnyUnion_Interactive_Phrasing.class,
			AnyUnion_Metadata_Phrasing.class,
			AnyUnion_Palpable_Phrasing.class
		);
	}

	@Test
	@SuppressWarnings("unchecked")
	public void testContentModels() {
		ContentModelTest.testContentModels(
			AnyPhrasingContent.class,
			//
			// Content models:
			//
			Content.class,
			AnyEmbeddedContent.class,
			AnyScriptSupportingContent.class,
			AnyTextContent.class
		);
	}

	@Test
	@SuppressWarnings("unchecked")
	public void testElementContentModels() {
		ElementContentModelTest.testElementContentModels(
			AnyPhrasingContent.class
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
			"a",
			"abbr",
			"area", // if a descendent of map
			"audio",
			"b",
			"bdi",
			"bdo",
			"br",
			"button",
			"canvas",
			"cite",
			"code",
			"data",
			"datalist",
			"del",
			"dfn",
			"em",
			"embed",
			"i",
			"iframe",
			"img",
			"input",
			"ins",
			"kbd",
			"label",
			"link", // if it is allowed in body
			"map",
			"mark",
			// TODO: MathML math
			"meta", // if the itemprop attribute is present
			"meter",
			"noscript",
			"object",
			"output",
			"picture",
			"progress",
			"q",
			"ruby",
			"s",
			"samp",
			"script",
			"select",
			"slot",
			"small",
			"span",
			"strong",
			"sub",
			"sup",
			// TODO: SVG svg
			"template",
			"textarea",
			"time",
			"u",
			"var",
			"video",
			"wbr"
			// TODO: autonomous custom elements: 4.13 Custom elements: https://html.spec.whatwg.org/multipage/custom-elements.html#custom-elements
		);
	}

	@Test
	public void testNoImplementInherited() {
		Assert.assertNotEquals(
			"Must be included in " + ContentModelTest.class.getSimpleName() + ".getAllContentModels()",
			-1,
			AoArrays.indexOf(ContentModelTest.getAllContentModels(), AnyPhrasingContent.class)
		);
		InheritanceTests.testNoImplementInherited(Content.class, AnyPhrasingContent.class);
	}
}
