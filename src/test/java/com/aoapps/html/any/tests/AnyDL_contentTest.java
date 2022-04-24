/*
 * ao-fluent-html-any - Base abstract classes and interfaces for Fluent Java DSL for high-performance HTML generation.
 * Copyright (C) 2021, 2022  AO Industries, Inc.
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
import com.aoapps.html.any.AnyDL_content;
import com.aoapps.html.any.AnyScriptSupportingContent;
import com.aoapps.html.any.AnyUnion_COLGROUP_ScriptSupporting;
import com.aoapps.html.any.AnyUnion_DIV_DL;
import com.aoapps.html.any.AnyUnion_DL_Palpable;
import com.aoapps.html.any.Content;
import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;

/**
 * @see  AnyDL_content
 *
 * @author  AO Industries, Inc.
 */
@SuppressWarnings("rawtypes")
public class AnyDL_contentTest {

  private final Class<? extends AnyDL_content> testingClass;

  protected AnyDL_contentTest(Class<? extends AnyDL_content> testingClass) {
    this.testingClass = testingClass;
  }

  public AnyDL_contentTest() {
    this(AnyDL_content.class);
  }

  @Test
  @SuppressWarnings("unchecked")
  public void testUnions() {
    AnyUnionContentTest.testUnions(
        AnyDL_content.class,
        //
        // Unions:
        //
        AnyUnion_COLGROUP_ScriptSupporting.class,
        AnyUnion_DIV_DL.class,
        AnyUnion_DL_Palpable.class
    );
  }

  @Test
  @SuppressWarnings("unchecked")
  public void testContentModels() {
    ContentModelTest.testContentModels(
        AnyDL_content.class,
        //
        // Content models:
        //
        Content.class,
        AnyScriptSupportingContent.class
    );
  }

  @Test
  @SuppressWarnings("unchecked")
  public void testElementContentModels() {
    ElementContentModelTest.testElementContentModels(
        AnyDL_content.class
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
        "dd",
        "div",
        "dt",
        "script",
        "template"
    );
  }

  @Test
  public void testNoImplementInherited() {
    Assert.assertNotEquals(
        "Must be included in " + ElementContentModelTest.class.getSimpleName() + ".getAllElementContentModels()",
        -1,
        AoArrays.indexOf(ElementContentModelTest.getAllElementContentModels(), AnyDL_content.class)
    );
    InheritanceTestHelper.testNoImplementInherited(Content.class, AnyDL_content.class);
  }
}
