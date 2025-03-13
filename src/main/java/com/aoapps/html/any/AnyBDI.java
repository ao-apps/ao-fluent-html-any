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

import com.aoapps.html.any.attributes.enumeration.Dir;
import com.aoapps.lang.io.function.IOSupplierE;
import java.io.IOException;
import java.io.Writer;

/**
 * <ul>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/text-level-semantics.html#the-bdi-element">4.5.24 The bdi element</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/bdi">&lt;bdi&gt;: The Bidirectional Isolate element</a>.</li>
 * <li>See <a href="https://www.w3schools.com/tags/tag_bdi.asp">HTML bdi Tag</a>.</li>
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
public abstract class AnyBDI<
    D  extends AnyDocument<D>,
    PC extends AnyUnion_Palpable_Phrasing<D, PC>,
    E  extends AnyBDI<D, PC, E, __, _c>,
    __ extends AnyBDI__<D, PC, __>,
    // Would prefer "_c extends __ & Closeable<D, PC>", but "a type variable may not be followed by other bounds"
    _c extends AnyBDI_c<D, PC, _c>
    >
    extends NormalText<D, PC, E, __, _c> {

  protected AnyBDI(D document, PC pc) {
    super(document, pc);
    Elements.onlySupportedInHtml5(document, "<bdi>");
  }

  @Override
  protected void writeOpen(Writer unsafe) throws IOException {
    document.autoIndent(unsafe).unsafe(unsafe, "<bdi", false);
  }

  @Override
  protected void writeClose(Writer unsafe, boolean closeAttributes) throws IOException {
    document.autoIndent(unsafe).unsafe(unsafe, closeAttributes ? "></bdi>" : "</bdi>", false);
  }

  /**
   * The {@linkplain Dir#dir(java.lang.String) dir} global attribute defaults to <code>auto</code>
   * on this element (it never inherits from the parent element like with other elements).
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/text-level-semantics.html#the-bdi-element">4.5.24 The bdi element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/bdi">&lt;bdi&gt;: The Bidirectional Isolate element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_bdi.asp">HTML bdi Tag</a>.</li>
   * </ul>
   *
   * @since HTML 5
   */
  @Override
  public E dir(String dir) throws IOException {
    return super.dir(dir);
  }

  /**
   * The {@linkplain Dir#dir(com.aoapps.html.Suppliers.String) dir} global attribute defaults to <code>auto</code>
   * on this element (it never inherits from the parent element like with other elements).
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/text-level-semantics.html#the-bdi-element">4.5.24 The bdi element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/bdi">&lt;bdi&gt;: The Bidirectional Isolate element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_bdi.asp">HTML bdi Tag</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @since HTML 5
   */
  @Override
  public <Ex extends Throwable> E dir(Suppliers.String<Ex> dir) throws IOException, Ex {
    return super.dir(dir);
  }

  /**
   * The {@linkplain Dir#dir(com.aoapps.html.any.attributes.enumeration.Dir.Value) dir} global attribute defaults to <code>auto</code>
   * on this element (it never inherits from the parent element like with other elements).
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/text-level-semantics.html#the-bdi-element">4.5.24 The bdi element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/bdi">&lt;bdi&gt;: The Bidirectional Isolate element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_bdi.asp">HTML bdi Tag</a>.</li>
   * </ul>
   *
   * @since HTML 5
   */
  @Override
  public E dir(Value dir) throws IOException {
    return super.dir(dir);
  }

  /**
   * The {@linkplain Dir#dir(com.aoapps.lang.io.function.IOSupplierE) dir} global attribute defaults to <code>auto</code>
   * on this element (it never inherits from the parent element like with other elements).
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/text-level-semantics.html#the-bdi-element">4.5.24 The bdi element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/bdi">&lt;bdi&gt;: The Bidirectional Isolate element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_bdi.asp">HTML bdi Tag</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @since HTML 5
   */
  @Override
  public <Ex extends Throwable> E dir(IOSupplierE<? extends Value, Ex> dir) throws IOException, Ex {
    return super.dir(dir);
  }
}
