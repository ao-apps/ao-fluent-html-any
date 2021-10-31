/*
 * ao-fluent-html-any - Base abstract classes and interfaces for Fluent Java DSL for high-performance HTML generation.
 * Copyright (C) 2021  AO Industries, Inc.
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

/**
 * <p>
 *   Interface hierarchy, abstract base classes, and overall relationship between {@linkplain AnyDocument document},
 *   {@linkplain Element element}, {@linkplain Attributes attributes}, and {@link Content content}.
 * </p>
 * <p>
 *   This package makes extensive use of parameterized types, may of them self-referential.  This is primarily so that
 *   code-assistance can provide the full context of the current element/attribute/content.  The verbosity caused by
 *   the expanding type parameters is not expected to be intrusive for two reasons: <code>var</code> is available for
 *   local variables in newer versions of Java, and the type definitions provide meaningful limits to wildcard bounds
 *   (<code>&lt;?&gt;</code>).
 * </p>
 * <p>
 *   Naming conventions within the package:
 * </p>
 * <ul>
 *   <li>
 *     <p>
 *      <code>ELEMENT</code> - Classes that represent HTML elements.
 *     </p>
 *   </li>
 *   <li>
 *     <p>
 *       <code>ELEMENT__</code> - Non-{@link com.aoapps.html.any.Closeable closeable}, lambda-friendly content of HTML elements (tag is
 *       automatically ended when lambda execution completes).
 *     </p>
 *   </li>
 *   <li>
 *     <p>
 *       <code>ELEMENT_c</code> - {@link com.aoapps.html.any.Closeable} HTML element content, which must be explicitly closed to end the tag
 *       (with either {@link com.aoapps.html.any.Closeable#close()} or {@link com.aoapps.html.any.Closeable#__()}, the latter allowing further fluent method
 *       chaining).  This is useful when the opening tag and closing tag are written at different times or in different
 *       parts of the code.  For example, when creating a template where one method writes the template header and a
 *       different method writes the template footer.
 *     </p>
 *   </li>
 *   <li>
 *     <p>
 *       <code>ELEMENT_content</code> - Content model interface specific to a single type of element.  This interface, or
 *       one of the more general-purpose <code>*Content</code> models, is implemented by both <code>ELEMENT__</code> and
 *       <code>ELEMENT_c</code>.
 *     </p>
 *   </li>
 *   <li>
 *     <p>
 *       <code>*Content</code> - Various content model interfaces, either directly defined by the HTML specification or a
 *       result of adapting the HTML specification into an interface hierarchy.
 *     </p>
 *   </li>
 *   <li>
 *     <p>
 *       <code>Union_*</code> - Union content models represent the specific elements that are common between two or more
 *       content models, but where the content models cannot inherit from one another.
 *       These interfaces are not specifically part of the HTML specification, but are an artifact of this implementation.
 *       These interfaces are primarily needed because there is no "or" for generic upper bounds.
 *     </p>
 *     <p>
 *       For example, both {@link AnyB} and {@link AnyI} are part of both {@link AnyPalpableContent} and {@link AnyPhrasingContent}.
 *       Thus, when you have one, you know you can have the other (see {@link AnyUnion_Palpable_Phrasing} in this case).
 *     </p>
 *   </li>
 * </ul>
 */
package com.aoapps.html.any;
