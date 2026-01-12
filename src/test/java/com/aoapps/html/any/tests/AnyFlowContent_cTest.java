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
import com.aoapps.html.any.AnyEmbeddedContent_c;
import com.aoapps.html.any.AnyFlowContent_c;
import com.aoapps.html.any.AnyHeadingContent_c;
import com.aoapps.html.any.AnyInteractiveContent_c;
import com.aoapps.html.any.AnyPalpableContent_c;
import com.aoapps.html.any.AnyPhrasingContent_c;
import com.aoapps.html.any.AnyScriptSupportingContent_c;
import com.aoapps.html.any.AnySectioningContent_c;
import com.aoapps.html.any.AnyTextContent_c;
import com.aoapps.html.any.AnyUnion_COLGROUP_ScriptSupporting_c;
import com.aoapps.html.any.AnyUnion_DL_Palpable_c;
import com.aoapps.html.any.AnyUnion_Embedded_Interactive_c;
import com.aoapps.html.any.AnyUnion_Embedded_Palpable_Phrasing_c;
import com.aoapps.html.any.AnyUnion_Interactive_Phrasing_c;
import com.aoapps.html.any.AnyUnion_Metadata_Phrasing_c;
import com.aoapps.html.any.AnyUnion_Palpable_Phrasing_c;
import com.aoapps.html.any.Content_c;
import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;

/**
 * @see  AnyFlowContent_c
 *
 * @author  AO Industries, Inc.
 */
@SuppressWarnings("rawtypes")
public class AnyFlowContent_cTest {

  private final Class<? extends AnyFlowContent_c> testingClass;

  protected AnyFlowContent_cTest(Class<? extends AnyFlowContent_c> testingClass) {
    this.testingClass = testingClass;
  }

  public AnyFlowContent_cTest() {
    this(AnyFlowContent_c.class);
  }

  @Test
  @SuppressWarnings("unchecked")
  public void testUnions() {
    AnyUnionContent_cTest.testUnions(
        AnyFlowContent_c.class,
        //
        // Unions:
        //
        AnyUnion_COLGROUP_ScriptSupporting_c.class,
        AnyUnion_DL_Palpable_c.class,
        AnyUnion_Embedded_Interactive_c.class,
        AnyUnion_Embedded_Palpable_Phrasing_c.class,
        AnyUnion_Interactive_Phrasing_c.class,
        AnyUnion_Metadata_Phrasing_c.class,
        AnyUnion_Palpable_Phrasing_c.class
    );
  }

  @Test
  @SuppressWarnings("unchecked")
  public void testContentModels() {
    ContentModel_cTest.testContentModels(
        AnyFlowContent_c.class,
        //
        // Content models:
        //
        Content_c.class,
        AnyEmbeddedContent_c.class,
        AnyHeadingContent_c.class,
        AnyInteractiveContent_c.class,
        AnyPalpableContent_c.class,
        AnyPhrasingContent_c.class,
        AnyScriptSupportingContent_c.class,
        AnySectioningContent_c.class,
        AnyTextContent_c.class
    );
  }

  @Test
  @SuppressWarnings("unchecked")
  public void testElementContentModels() {
    ElementContentModel_cTest.testElementContentModels(
        AnyFlowContent_c.class
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
        "area", // if a descendent of map
        "article",
        "aside",
        "audio",
        "b",
        "bdi",
        "bdo",
        "blockquote",
        "br",
        "button",
        "canvas",
        "cite",
        "code",
        "data",
        "datalist",
        "del",
        "details",
        "dfn",
        "dialog",
        "div",
        "dl",
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
        "hr",
        "i",
        "iframe",
        "img",
        "input",
        "ins",
        "kbd",
        "label",
        "link", // if it is allowed in body
        "main", // if it is a hierarchically correct main element
        "map",
        "mark",
        // TODO: MathML math
        "menu",
        "meta", // if the itemprop attribute is present
        "meter",
        "nav",
        "noscript",
        "object",
        "ol",
        "output",
        "p",
        "picture",
        "pre",
        "progress",
        "q",
        "ruby",
        "s",
        "samp",
        "script",
        "section",
        "select",
        "slot",
        "small",
        "span",
        "strong",
        "sub",
        "sup",
        // TODO: SVG svg
        "table",
        "template",
        "textarea",
        "time",
        "u",
        "ul",
        "var",
        "video",
        "wbr"
    // TODO: autonomous custom elements: 4.13 Custom elements: https://html.spec.whatwg.org/multipage/custom-elements.html#custom-elements
    );
  }

  @Test
  public void testNoImplementInherited() {
    Assert.assertNotEquals(
        "Must be included in " + ContentModel_cTest.class.getSimpleName() + ".getAllContentModels()",
        -1,
        AoArrays.indexOf(ContentModel_cTest.getAllContentModels(), AnyFlowContent_c.class)
    );
    InheritanceTestHelper.testNoImplementInherited(Content_c.class, AnyFlowContent_c.class);
  }
}
