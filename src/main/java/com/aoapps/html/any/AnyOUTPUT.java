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

package com.aoapps.html.any;

import java.io.IOException;
import java.io.Writer;

/**
 * <ul>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/form-elements.html#the-output-element">4.10.12 The output element</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/output">&lt;output&gt;: The Output element</a>.</li>
 * <li>See <a href="https://www.w3schools.com/tags/tag_output.asp">HTML output Tag</a>.</li>
 * </ul>
 *
 * @param  <D>   This document type
 * @param  <PC>  The parent content model this element is within
 * @param  <E>   This element type
 * @param  <__>  This content model, which will be the parent content model of child elements
 * @param  <_c>  This content model as {@link Closeable}, which will be the parent content model of child elements
 *
 * @since HTML 5
 *
 * @author  AO Industries, Inc.
 */
public abstract class AnyOUTPUT<
    D  extends AnyDocument<D>,
    PC extends AnyUnion_Palpable_Phrasing<D, PC>,
    E  extends AnyOUTPUT<D, PC, E, __, _c>,
    __ extends AnyOUTPUT__<D, PC, __>,
    // Would prefer "_c extends __ & Closeable<D, PC>", but "a type variable may not be followed by other bounds"
    _c extends AnyOUTPUT_c<D, PC, _c>
    >
    extends NormalText<D, PC, E, __, _c> implements
    // TODO: for, like AnyLABEL.for, but attribute named "ForArray", with support for multiple values like the Class attribute.
    com.aoapps.html.any.attributes.text.Form<E>,
    com.aoapps.html.any.attributes.text.Name<E>,
    // Global Attributes overrides
    com.aoapps.html.any.attributes.enumeration.Autocapitalize<E> {

  protected AnyOUTPUT(D document, PC pc) {
    super(document, pc);
    Elements.onlySupportedInHtml5(document, "<output>");
  }

  @Override
  protected void writeOpen(Writer unsafe) throws IOException {
    document.autoIndent(unsafe).unsafe(unsafe, "<output", false);
  }

  @Override
  protected void writeClose(Writer unsafe, boolean closeAttributes) throws IOException {
    document.autoIndent(unsafe).unsafe(unsafe, closeAttributes ? "></output>" : "</output>", false);
  }
}
