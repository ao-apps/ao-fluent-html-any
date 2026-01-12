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
import com.aoapps.html.any.AnyInteractiveContent_c;
import com.aoapps.html.any.AnyUnion_Embedded_Interactive_c;
import com.aoapps.html.any.AnyUnion_Interactive_Phrasing_c;
import com.aoapps.html.any.Content_c;
import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;

/**
 * @see  AnyInteractiveContent_c
 *
 * @author  AO Industries, Inc.
 */
@SuppressWarnings("rawtypes")
public class AnyInteractiveContent_cTest {

  private final Class<? extends AnyInteractiveContent_c> testingClass;

  protected AnyInteractiveContent_cTest(Class<? extends AnyInteractiveContent_c> testingClass) {
    this.testingClass = testingClass;
  }

  public AnyInteractiveContent_cTest() {
    this(AnyInteractiveContent_c.class);
  }

  @Test
  @SuppressWarnings("unchecked")
  public void testUnions() {
    AnyUnionContent_cTest.testUnions(
        AnyInteractiveContent_c.class,
        //
        // Unions:
        //
        AnyUnion_Embedded_Interactive_c.class,
        AnyUnion_Interactive_Phrasing_c.class
    );
  }

  @Test
  @SuppressWarnings("unchecked")
  public void testContentModels() {
    ContentModel_cTest.testContentModels(
        AnyInteractiveContent_c.class,
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
        AnyInteractiveContent_c.class
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
        "a", // if the href attribute is present
        "audio", // if the controls attribute is present
        "button",
        "details",
        "embed",
        "iframe",
        "img", // if the usemap attribute is present
        "input", // if type attribute is not in the hidden state
        "label",
        "menu", // (MDN only) if the type attribute is in the toolbar state
        "object", // if the usemap attribute is present
        "select",
        "textarea",
        "video" // if the controls attribute is present
    );
  }

  @Test
  public void testNoImplementInherited() {
    Assert.assertNotEquals(
        "Must be included in " + ContentModel_cTest.class.getSimpleName() + ".getAllContentModels()",
        -1,
        AoArrays.indexOf(ContentModel_cTest.getAllContentModels(), AnyInteractiveContent_c.class)
    );
    InheritanceTestHelper.testNoImplementInherited(Content_c.class, AnyInteractiveContent_c.class);
  }
}
