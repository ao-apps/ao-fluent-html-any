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

import com.aoapps.collections.AoArrays;
import com.aoapps.html.any.AnyCOLGROUP_content_c;
import com.aoapps.html.any.AnyUnion_COLGROUP_ScriptSupporting_c;
import com.aoapps.html.any.Content_c;
import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;

/**
 * @see  AnyCOLGROUP_content_c
 *
 * @author  AO Industries, Inc.
 */
public class AnyCOLGROUP_content_cTest {

  private final Class<? extends AnyCOLGROUP_content_c> testingClass;

  protected AnyCOLGROUP_content_cTest(Class<? extends AnyCOLGROUP_content_c> testingClass) {
    this.testingClass = testingClass;
  }

  public AnyCOLGROUP_content_cTest() {
    this(AnyCOLGROUP_content_c.class);
  }

  @Test
  @SuppressWarnings("unchecked")
  public void testUnions() {
    AnyUnionContent_cTest.testUnions(
        AnyCOLGROUP_content_c.class,
        //
        // Unions:
        //
        AnyUnion_COLGROUP_ScriptSupporting_c.class
    );
  }

  @Test
  @SuppressWarnings("unchecked")
  public void testContentModels() {
    ContentModel_cTest.testContentModels(
        AnyCOLGROUP_content_c.class,
        //
        // Content models:
        //
        Content_c.class
    );
  }

  @Test
  @SuppressWarnings("unchecked")
  public void testElementContentModels() {
    ElementContentModel_cTest.testElementContentModels(
        AnyCOLGROUP_content_c.class
    //
    // Per-element content models:
    //
    // None
    );
  }

  @Test
  public void testFactories() throws IOException {
    FactoryTestHelper.testFactories(
        testingClass,
        //
        // Factories:
        //
        "col",
        "template"
    );
  }

  @Test
  public void testNoImplementInherited() {
    Assert.assertNotEquals(
        "Must be included in " + ElementContentModel_cTest.class.getSimpleName() + ".getAllElementContentModels()",
        -1,
        AoArrays.indexOf(ElementContentModel_cTest.getAllElementContentModels(), AnyCOLGROUP_content_c.class)
    );
    InheritanceTestHelper.testNoImplementInherited(Content_c.class, AnyCOLGROUP_content_c.class);
  }
}
