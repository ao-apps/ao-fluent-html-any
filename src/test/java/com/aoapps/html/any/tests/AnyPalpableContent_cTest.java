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
import com.aoapps.html.any.AnyHeadingContent_c;
import com.aoapps.html.any.AnyInteractiveContent_c;
import com.aoapps.html.any.AnyPalpableContent_c;
import com.aoapps.html.any.AnySectioningContent_c;
import com.aoapps.html.any.AnyTextContent_c;
import com.aoapps.html.any.AnyUnion_DL_Palpable_c;
import com.aoapps.html.any.AnyUnion_Embedded_Interactive_c;
import com.aoapps.html.any.AnyUnion_Embedded_Palpable_Phrasing_c;
import com.aoapps.html.any.AnyUnion_Interactive_Phrasing_c;
import com.aoapps.html.any.AnyUnion_Palpable_Phrasing_c;
import com.aoapps.html.any.Content_c;
import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;

/**
 * @see  AnyPalpableContent_c
 *
 * @author  AO Industries, Inc.
 */
@SuppressWarnings("rawtypes")
public class AnyPalpableContent_cTest {

  private final Class<? extends AnyPalpableContent_c> testingClass;

  protected AnyPalpableContent_cTest(Class<? extends AnyPalpableContent_c> testingClass) {
    this.testingClass = testingClass;
  }

  public AnyPalpableContent_cTest() {
    this(AnyPalpableContent_c.class);
  }

  @Test
  @SuppressWarnings("unchecked")
  public void testUnions() {
    AnyUnionContent_cTest.testUnions(
        AnyPalpableContent_c.class,
        //
        // Unions:
        //
        AnyUnion_DL_Palpable_c.class,
        AnyUnion_Embedded_Interactive_c.class,
        AnyUnion_Embedded_Palpable_Phrasing_c.class,
        AnyUnion_Interactive_Phrasing_c.class,
        AnyUnion_Palpable_Phrasing_c.class
    );
  }

  @Test
  @SuppressWarnings("unchecked")
  public void testContentModels() {
    ContentModel_cTest.testContentModels(
        AnyPalpableContent_c.class,
        //
        // Content models:
        //
        Content_c.class,
        AnySectioningContent_c.class,
        AnyHeadingContent_c.class,
        AnyInteractiveContent_c.class,
        AnyTextContent_c.class // that is not inter-element whitespace
    );
  }

  @Test
  @SuppressWarnings("unchecked")
  public void testElementContentModels() {
    ElementContentModel_cTest.testElementContentModels(
        AnyPalpableContent_c.class
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
        "address",
        "article",
        "aside",
        "audio", // if the controls attribute is present
        "b",
        "bdi",
        "bdo",
        "blockquote",
        "button",
        "canvas",
        "cite",
        "code",
        "data",
        "details",
        "dfn",
        "div",
        "dl", // if children contain at least one name/value pair
        "em",
        "embed",
        "fieldset",
        "figure",
        "footer",
        "form",
        "h1",
        "h2",
        "h3",
        "h4",
        "h5",
        "h6",
        "h#",
        "header",
        "hgroup",
        "i",
        "iframe",
        "img",
        "input", // if type attribute is not in the hidden state
        "ins",
        "kbd",
        "label",
        "main",
        "map",
        "mark",
        // TODO: MathML math
        "menu", // if children include at least one li
        "meter",
        "nav",
        "object",
        "ol", // if children include at least one li
        "output",
        "p",
        "pre",
        "progress",
        "q",
        "ruby",
        "s",
        "samp",
        "section",
        "select",
        "small",
        "span",
        "strong",
        "sub",
        "sup",
        // TODO: SVG svg
        "table",
        "textarea",
        "time",
        "u",
        "ul", // if children include at least one li
        "var",
        "video"
    // TODO: autonomous custom elements: 4.13 Custom elements: https://html.spec.whatwg.org/multipage/custom-elements.html#custom-elements
    );
  }

  @Test
  public void testNoImplementInherited() {
    Assert.assertNotEquals(
        "Must be included in " + ContentModel_cTest.class.getSimpleName() + ".getAllContentModels()",
        -1,
        AoArrays.indexOf(ContentModel_cTest.getAllContentModels(), AnyPalpableContent_c.class)
    );
    InheritanceTestHelper.testNoImplementInherited(Content_c.class, AnyPalpableContent_c.class);
  }
}
