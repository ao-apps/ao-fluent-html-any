/*
 * ao-fluent-html-any - Base abstract classes and interfaces for Fluent Java DSL for high-performance HTML generation.
 * Copyright (C) 2026  AO Industries, Inc.
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

import com.aoapps.html.any.AnyUnion_COLGROUP_ScriptSupporting_c;
import com.aoapps.html.any.AnyUnion_DATALIST_OPTGROUP_c;
import com.aoapps.html.any.AnyUnion_DIV_DL_c;
import com.aoapps.html.any.AnyUnion_DL_Palpable_c;
import com.aoapps.html.any.AnyUnion_Embedded_Interactive_c;
import com.aoapps.html.any.AnyUnion_Embedded_Palpable_Phrasing_c;
import com.aoapps.html.any.AnyUnion_Interactive_Phrasing_c;
import com.aoapps.html.any.AnyUnion_Metadata_Phrasing_c;
import com.aoapps.html.any.AnyUnion_Palpable_Phrasing_c;
import com.aoapps.html.any.AnyUnion_TBODY_THEAD_TFOOT_c;
import com.aoapps.html.any.Content_c;
import org.junit.Test;

/**
 * Tests <code>Union_*</code> interfaces,
 * which confirm a class implements the expected set of interfaces.
 *
 * @author  AO Industries, Inc.
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public class AnyUnionContent_cTest {

  /**
   * Gets the set of all <code>Union_*</code> interfaces.
   */
  static Class<? extends Content_c>[] getAllUnions() {
    return new Class[]{
        AnyUnion_COLGROUP_ScriptSupporting_c.class,
        AnyUnion_DATALIST_OPTGROUP_c.class,
        AnyUnion_DIV_DL_c.class,
        AnyUnion_DL_Palpable_c.class,
        AnyUnion_Embedded_Interactive_c.class,
        AnyUnion_Embedded_Palpable_Phrasing_c.class,
        AnyUnion_Interactive_Phrasing_c.class,
        AnyUnion_Metadata_Phrasing_c.class,
        AnyUnion_Palpable_Phrasing_c.class,
        AnyUnion_TBODY_THEAD_TFOOT_c.class
    };
  }

  static void testUnions(Class<? extends Content_c> clazz, Class<? extends Content_c>... expected) {
    InheritanceTestHelper.testInterfaces(
        Content_c.class,
        iface -> iface.getSimpleName().startsWith("AnyUnion_"),
        getAllUnions(),
        clazz,
        expected
    );
  }

  @Test
  public void testNoImplementInherited() {
    for (Class<? extends Content_c> iface : getAllUnions()) {
      InheritanceTestHelper.testNoImplementInherited(Content_c.class, iface);
    }
  }
}
