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
 * <li>See <a href="https://html.spec.whatwg.org/multipage/sections.html#the-footer-element">4.3.9 The footer element</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/footer">&lt;footer&gt;</a>.</li>
 * <li>See <a href="https://www.w3schools.com/tags/tag_footer.asp">HTML footer Tag</a>.</li>
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
// TODO: Flow content, but with no header or footer element descendants.
public abstract class AnyFOOTER<
    D  extends AnyDocument<D>,
    PC extends AnyPalpableContent<D, PC>,
    E  extends AnyFOOTER<D, PC, E, __, _c>,
    __ extends AnyFOOTER__<D, PC, __>,
    // Would prefer "_c extends __ & Closeable<D, PC>", but "a type variable may not be followed by other bounds"
    _c extends AnyFOOTER_c<D, PC, _c>
    >
    extends NormalText<D, PC, E, __, _c> {

  protected AnyFOOTER(D document, PC pc) {
    super(document, pc);
    Elements.onlySupportedInHtml5(document, "<footer>");
  }

  @Override
  protected void writeOpen(Writer unsafe) throws IOException {
    document.autoNli(unsafe).unsafe(unsafe, "<footer", false);
  }

  @Override
  protected void doBeforeBody(Writer unsafe) throws IOException {
    document.autoNl(unsafe);
  }

  @Override
  protected void writeClose(Writer unsafe, boolean closeAttributes) throws IOException {
    if (closeAttributes) {
      document.autoIndent(unsafe).unsafe(unsafe, "></footer>", false);
    } else {
      document.autoNli(unsafe).unsafe(unsafe, "</footer>", false);
    }
    document.autoNl(unsafe);
  }
}
