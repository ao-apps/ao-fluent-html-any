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

import com.aoapps.encoding.TextWritable;
import com.aoapps.html.any.attributes.text.Title;
import com.aoapps.lang.io.function.IOSupplierE;
import java.io.IOException;
import java.io.Writer;

/**
 * <ul>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/text-level-semantics.html#the-abbr-element">4.5.9 The abbr element</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/abbr">&lt;abbr&gt;: The Abbreviation element</a>.</li>
 * <li>See <a href="https://www.w3schools.com/tags/tag_abbr.asp">HTML abbr tag</a>.</li>
 * </ul>
 *
 * @param  <D>   This document type
 * @param  <PC>  The parent content model this element is within
 * @param  <E>   This element type
 * @param  <__>  This content model, which will be the parent content model of child elements
 * @param  <_c>  This content model as {@link Closeable}, which will be the parent content model of child elements
 *
 * @author  AO Industries, Inc.
 */
public abstract class AnyABBR<
    D  extends AnyDocument<D>,
    PC extends AnyUnion_Palpable_Phrasing<D, PC>,
    E  extends AnyABBR<D, PC, E, __, _c>,
    __ extends AnyABBR__<D, PC, __>,
    // Would prefer "_c extends __ & Closeable<D, PC>", but "a type variable may not be followed by other bounds"
    _c extends AnyABBR_c<D, PC, _c>
    >
    extends NormalText<D, PC, E, __, _c> {

  protected AnyABBR(D document, PC pc) {
    super(document, pc);
  }

  @Override
  protected void writeOpen(Writer unsafe) throws IOException {
    document.autoIndent(unsafe).unsafe(unsafe, "<abbr", false);
  }

  @Override
  protected void writeClose(Writer unsafe, boolean closeAttributes) throws IOException {
    document.autoIndent(unsafe).unsafe(unsafe, closeAttributes ? "></abbr>" : "</abbr>", false);
  }

  /**
   * The {@linkplain Title#title(java.lang.Object) title} attribute
   * <a href="https://html.spec.whatwg.org/multipage/text-level-semantics.html#attr-abbr-title">has special semantics</a>
   * on this element: Full term or expansion of abbreviation.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/text-level-semantics.html#the-abbr-element">4.5.9 The abbr element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/abbr">&lt;abbr&gt;: The Abbreviation element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_abbr.asp">HTML abbr tag</a>.</li>
   * </ul>
   */
  @Override
  public E title(Object title) throws IOException {
    return super.title(title);
  }

  /**
   * The {@linkplain Title#title(com.aoapps.lang.io.function.IOSupplierE) title} attribute
   * <a href="https://html.spec.whatwg.org/multipage/text-level-semantics.html#attr-abbr-title">has special semantics</a>
   * on this element: Full term or expansion of abbreviation.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/text-level-semantics.html#the-abbr-element">4.5.9 The abbr element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/abbr">&lt;abbr&gt;: The Abbreviation element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_abbr.asp">HTML abbr tag</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   */
  @Override
  public <Ex extends Throwable> E title(IOSupplierE<?, Ex> title) throws IOException, Ex {
    return super.title(title);
  }

  /**
   * The {@linkplain Title#title(com.aoapps.encoding.TextWritable) title} attribute
   * <a href="https://html.spec.whatwg.org/multipage/text-level-semantics.html#attr-abbr-title">has special semantics</a>
   * on this element: Full term or expansion of abbreviation.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/text-level-semantics.html#the-abbr-element">4.5.9 The abbr element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/abbr">&lt;abbr&gt;: The Abbreviation element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_abbr.asp">HTML abbr tag</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   */
  @Override
  public <Ex extends Throwable> E title(TextWritable<Ex> title) throws IOException, Ex {
    return super.title(title);
  }
}
