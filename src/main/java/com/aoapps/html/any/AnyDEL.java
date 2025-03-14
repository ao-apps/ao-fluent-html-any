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
 * <li>See <a href="https://html.spec.whatwg.org/multipage/edits.html#the-del-element">4.7.2 The del element</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/del">&lt;del&gt;: The Deleted Text element</a>.</li>
 * <li>See <a href="https://www.w3schools.com/tags/tag_del.asp">HTML del tag</a>.</li>
 * </ul>
 *
 * @param  <D>   This document type
 * @param  <PC>  The parent content model this element is within
 * @param  <E>   This element type
 * @param  <_c>  This content model as {@link Closeable}, which will be the parent content model of child elements
 *
 * @author  AO Industries, Inc.
 */
public abstract class AnyDEL<
    D  extends AnyDocument<D>,
    PC extends AnyPhrasingContent<D, PC>,
    E  extends AnyDEL<D, PC, E, _c>,
    _c extends AnyDEL_c<D, PC, _c>
    >
    extends Transparent<D, PC, E, _c> implements
    com.aoapps.html.any.attributes.url.Cite<E> {
  // TODO: datetime

  protected AnyDEL(D document, PC pc) {
    super(document, pc);
  }

  @Override
  protected void writeOpen(Writer unsafe) throws IOException {
    document.autoIndent(unsafe).unsafe(unsafe, "<del", false);
  }

  @Override
  protected void writeClose(Writer unsafe, boolean closeAttributes) throws IOException {
    document.autoIndent(unsafe).unsafe(unsafe, closeAttributes ? "></del>" : "</del>", false);
  }
}
