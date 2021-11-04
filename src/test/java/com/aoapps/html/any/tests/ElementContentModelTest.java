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

import com.aoapps.html.any.AnyCOLGROUP_content;
import com.aoapps.html.any.AnyDATALIST_content;
import com.aoapps.html.any.AnyDIV_content;
import com.aoapps.html.any.AnyDL_content;
import com.aoapps.html.any.AnyHTML_content;
import com.aoapps.html.any.AnyOBJECT_content;
import com.aoapps.html.any.AnyOPTGROUP_content;
import com.aoapps.html.any.AnySELECT_content;
import com.aoapps.html.any.AnyTABLE_content;
import com.aoapps.html.any.AnyTR_content;
import com.aoapps.html.any.Content;
import org.junit.Test;

/**
 * Tests <code>*_content</code> per-element content model interfaces,
 * which confirm a class implements the expected set of interfaces.
 *
 * @author  AO Industries, Inc.
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public class ElementContentModelTest {

	/**
	 * Gets the set of all <code>*_content</code> per-element content model interfaces.
	 */
	static Class<? extends Content>[] getAllElementContentModels() {
		return new Class[] {
			AnyCOLGROUP_content.class,
			AnyDATALIST_content.class,
			AnyDIV_content.class,
			AnyDL_content.class,
			AnyHTML_content.class,
			AnyOBJECT_content.class,
			AnyOPTGROUP_content.class,
			AnySELECT_content.class,
			AnyTABLE_content.class,
			AnyTR_content.class
		};
	}

	static void testElementContentModels(Class<? extends Content> clazz, Class<? extends Content> ... expected) {
		InheritanceTestHelper.testInterfaces(
			Content.class,
			iface -> iface.getSimpleName().endsWith("_content"),
			getAllElementContentModels(),
			clazz,
			expected
		);
	}

	@Test
	public void testNoImplementInherited() {
		for(Class<? extends Content> iface : getAllElementContentModels()) {
			InheritanceTestHelper.testNoImplementInherited(Content.class, iface);
		}
	}
}
