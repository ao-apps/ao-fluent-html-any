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
import com.aoapps.html.any.AnyTextContent_c;
import com.aoapps.html.any.AnyUnion_Embedded_Interactive_c;
import com.aoapps.html.any.AnyUnion_Embedded_Palpable_Phrasing_c;
import com.aoapps.html.any.AnyUnion_Interactive_Phrasing_c;
import com.aoapps.html.any.AnyUnion_Palpable_Phrasing_c;
import com.aoapps.html.any.Content_c;
import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;

/**
 * @see  AnyUnion_Palpable_Phrasing_c
 *
 * @author  AO Industries, Inc.
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public class AnyUnion_Palpable_Phrasing_cTest {

  private final Class<? extends AnyUnion_Palpable_Phrasing_c> testingClass;

  protected AnyUnion_Palpable_Phrasing_cTest(Class<? extends AnyUnion_Palpable_Phrasing_c> testingClass) {
    this.testingClass = testingClass;
  }

  public AnyUnion_Palpable_Phrasing_cTest() {
    this(AnyUnion_Palpable_Phrasing_c.class);
  }

  @Test
  @SuppressWarnings("unchecked")
  public void testUnions() {
    AnyUnionContent_cTest.testUnions(
        AnyUnion_Palpable_Phrasing_c.class,
        //
        // Unions:
        //
        AnyUnion_Embedded_Interactive_c.class,
        AnyUnion_Embedded_Palpable_Phrasing_c.class,
        AnyUnion_Interactive_Phrasing_c.class
    );
  }

  @Test
  @SuppressWarnings("unchecked")
  public void testContentModels() {
    ContentModel_cTest.testContentModels(
        AnyUnion_Palpable_Phrasing_c.class,
        //
        // Content models:
        //
        Content_c.class,
        AnyTextContent_c.class
    );
  }

  @Test
  @SuppressWarnings("unchecked")
  public void testElementContentModels() {
    ElementContentModel_cTest.testElementContentModels(
        AnyUnion_Palpable_Phrasing_c.class
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
        "abbr",
        "audio",
        "b",
        "bdi",
        "bdo",
        "button",
        "canvas",
        "cite",
        "code",
        "data",
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
        "map",
        "mark",
        // TODO: MathML math
        "meter",
        "object",
        "output",
        "progress",
        "q",
        "ruby",
        "s",
        "samp",
        "select",
        "small",
        "span",
        "strong",
        "sub",
        "sup",
        // TODO: SVG svg
        "textarea",
        "time",
        "u",
        "var",
        "video"
    // TODO: autonomous custom elements: 4.13 Custom elements: https://html.spec.whatwg.org/multipage/custom-elements.html#custom-elements
    );
  }

  @Test
  public void testNoImplementInherited() {
    Assert.assertNotEquals("Must be included in " + AnyUnionContent_cTest.class.getSimpleName() + ".getAllUnions()",
        -1,
        AoArrays.indexOf(AnyUnionContent_cTest.getAllUnions(), AnyUnion_Palpable_Phrasing_c.class)
    );
    InheritanceTestHelper.testNoImplementInherited(Content_c.class, AnyUnion_Palpable_Phrasing_c.class);
  }
}
