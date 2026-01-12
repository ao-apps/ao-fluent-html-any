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

import com.aoapps.html.any.AnyCOLGROUP_content_c;
import com.aoapps.html.any.AnyDATALIST_content_c;
import com.aoapps.html.any.AnyDIV_content_c;
import com.aoapps.html.any.AnyDL_content_c;
import com.aoapps.html.any.AnyHTML_content_c;
import com.aoapps.html.any.AnyOBJECT_content_c;
import com.aoapps.html.any.AnyOPTGROUP_content_c;
import com.aoapps.html.any.AnySELECT_content_c;
import com.aoapps.html.any.AnyTABLE_content_c;
import com.aoapps.html.any.AnyTR_content_c;
import com.aoapps.html.any.Closeable;
import com.aoapps.html.any.Content_c;
import org.junit.Test;

/**
 * Tests <code>*_content_c</code> per-element {@link Closeable} content model interfaces,
 * which confirm a class implements the expected set of interfaces.
 *
 * @author  AO Industries, Inc.
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public class ElementContentModel_cTest {

  /**
   * Gets the set of all <code>*_content_c</code> per-element {@link Closeable} content model interfaces.
   */
  static Class<? extends Content_c>[] getAllElementContentModels() {
    return new Class[]{
        AnyCOLGROUP_content_c.class,
        AnyDATALIST_content_c.class,
        AnyDIV_content_c.class,
        AnyDL_content_c.class,
        AnyHTML_content_c.class,
        AnyOBJECT_content_c.class,
        AnyOPTGROUP_content_c.class,
        AnySELECT_content_c.class,
        AnyTABLE_content_c.class,
        AnyTR_content_c.class
    };
  }

  static void testElementContentModels(Class<? extends Content_c> clazz, Class<? extends Content_c>... expected) {
    InheritanceTestHelper.testInterfaces(
        Content_c.class,
        iface -> iface.getSimpleName().endsWith("_content_c"),
        getAllElementContentModels(),
        clazz,
        expected
    );
  }

  @Test
  public void testNoImplementInherited() {
    for (Class<? extends Content_c> iface : getAllElementContentModels()) {
      InheritanceTestHelper.testNoImplementInherited(Content_c.class, iface);
    }
  }
}
