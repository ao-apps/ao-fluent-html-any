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
import com.aoapps.html.any.AnyUnion_Embedded_Interactive;
import com.aoapps.html.any.AnyUnion_Interactive_Phrasing;
import com.aoapps.html.any.Content;
import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;

/**
 * @see  AnyUnion_Interactive_Phrasing
 *
 * @author  AO Industries, Inc.
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public class AnyUnion_Interactive_PhrasingTest {

  private final Class<? extends AnyUnion_Interactive_Phrasing> testingClass;

  protected AnyUnion_Interactive_PhrasingTest(Class<? extends AnyUnion_Interactive_Phrasing> testingClass) {
    this.testingClass = testingClass;
  }

  public AnyUnion_Interactive_PhrasingTest() {
    this(AnyUnion_Interactive_Phrasing.class);
  }

  @Test
  @SuppressWarnings("unchecked")
  public void testUnions() {
    AnyUnionContentTest.testUnions(
        AnyUnion_Interactive_Phrasing.class,
        //
        // Unions:
        //
        AnyUnion_Embedded_Interactive.class
    );
  }

  @Test
  @SuppressWarnings("unchecked")
  public void testContentModels() {
    ContentModelTest.testContentModels(
        AnyUnion_Interactive_Phrasing.class,
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
        AnyUnion_Interactive_Phrasing.class
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
        "a",
        "audio",
        "button",
        "embed",
        "input",
        "iframe",
        "img",
        "label",
        "object",
        "select",
        "textarea",
        "video"
    );
  }

  @Test
  public void testNoImplementInherited() {
    Assert.assertNotEquals("Must be included in " + AnyUnionContentTest.class.getSimpleName() + ".getAllUnions()",
        -1,
        AoArrays.indexOf(AnyUnionContentTest.getAllUnions(), AnyUnion_Interactive_Phrasing.class)
    );
    InheritanceTestHelper.testNoImplementInherited(Content.class, AnyUnion_Interactive_Phrasing.class);
  }
}
