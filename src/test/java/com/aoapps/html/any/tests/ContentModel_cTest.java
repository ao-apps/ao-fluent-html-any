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

import com.aoapps.html.any.AnyContent_c;
import com.aoapps.html.any.AnyEmbeddedContent_c;
import com.aoapps.html.any.AnyFlowContent_c;
import com.aoapps.html.any.AnyHeadingContent_c;
import com.aoapps.html.any.AnyInteractiveContent_c;
import com.aoapps.html.any.AnyListContent_c;
import com.aoapps.html.any.AnyMetadataContent_c;
import com.aoapps.html.any.AnyPalpableContent_c;
import com.aoapps.html.any.AnyPhrasingContent_c;
import com.aoapps.html.any.AnyScriptSupportingContent_c;
import com.aoapps.html.any.AnySectioningContent_c;
import com.aoapps.html.any.AnyTextContent_c;
import com.aoapps.html.any.Closeable;
import com.aoapps.html.any.Content_c;
import org.junit.Test;

/**
 * Tests <code>*Content_c</code> {@link Closeable} content model interfaces,
 * which confirm a class implements the expected set of interfaces.
 *
 * @author  AO Industries, Inc.
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public class ContentModel_cTest {

  /**
   * Gets the set of all <code>*Content_c</code> {@link Closeable} content model interfaces.
   */
  static Class<? extends Content_c>[] getAllContentModels() {
    return new Class[]{
        AnyContent_c.class,
        Content_c.class,
        AnyEmbeddedContent_c.class,
        AnyFlowContent_c.class,
        AnyHeadingContent_c.class,
        AnyInteractiveContent_c.class,
        AnyListContent_c.class,
        AnyMetadataContent_c.class,
        AnyPalpableContent_c.class,
        AnyPhrasingContent_c.class,
        AnyScriptSupportingContent_c.class,
        AnySectioningContent_c.class,
        AnyTextContent_c.class
    };
  }

  static void testContentModels(Class<? extends Content_c> clazz, Class<? extends Content_c>... expected) {
    InheritanceTestHelper.testInterfaces(
        Content_c.class,
        iface -> iface.getSimpleName().endsWith("Content_c"),
        getAllContentModels(),
        clazz,
        expected
    );
  }

  @Test
  public void testNoImplementInherited() {
    for (Class<? extends Content_c> iface : getAllContentModels()) {
      InheritanceTestHelper.testNoImplementInherited(Content_c.class, iface);
    }
  }
}
