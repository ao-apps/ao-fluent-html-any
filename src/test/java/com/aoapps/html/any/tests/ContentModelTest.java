/*
 * ao-fluent-html-any - Base abstract classes and interfaces for Fluent Java DSL for high-performance HTML generation.
 * Copyright (C) 2021, 2022, 2025  AO Industries, Inc.
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

import com.aoapps.html.any.AnyContent;
import com.aoapps.html.any.AnyEmbeddedContent;
import com.aoapps.html.any.AnyFlowContent;
import com.aoapps.html.any.AnyHeadingContent;
import com.aoapps.html.any.AnyInteractiveContent;
import com.aoapps.html.any.AnyListContent;
import com.aoapps.html.any.AnyMetadataContent;
import com.aoapps.html.any.AnyPalpableContent;
import com.aoapps.html.any.AnyPhrasingContent;
import com.aoapps.html.any.AnyScriptSupportingContent;
import com.aoapps.html.any.AnySectioningContent;
import com.aoapps.html.any.AnyTextContent;
import com.aoapps.html.any.Content;
import org.junit.Test;

/**
 * Tests <code>*Content</code> content model interfaces,
 * which confirm a class implements the expected set of interfaces.
 *
 * @author  AO Industries, Inc.
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public class ContentModelTest {

  /**
   * Gets the set of all <code>*Content</code> content model interfaces.
   */
  static Class<? extends Content>[] getAllContentModels() {
    return new Class[]{
        AnyContent.class,
        Content.class,
        AnyEmbeddedContent.class,
        AnyFlowContent.class,
        AnyHeadingContent.class,
        AnyInteractiveContent.class,
        AnyListContent.class,
        AnyMetadataContent.class,
        AnyPalpableContent.class,
        AnyPhrasingContent.class,
        AnyScriptSupportingContent.class,
        AnySectioningContent.class,
        AnyTextContent.class
    };
  }

  static void testContentModels(Class<? extends Content> clazz, Class<? extends Content>... expected) {
    InheritanceTestHelper.testInterfaces(
        Content.class,
        iface -> iface.getSimpleName().endsWith("Content"),
        getAllContentModels(),
        clazz,
        expected
    );
  }

  @Test
  public void testNoImplementInherited() {
    for (Class<? extends Content> iface : getAllContentModels()) {
      InheritanceTestHelper.testNoImplementInherited(Content.class, iface);
    }
  }
}
