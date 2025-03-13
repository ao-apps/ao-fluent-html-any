/*
 * ao-fluent-html-any - Base abstract classes and interfaces for Fluent Java DSL for high-performance HTML generation.
 * Copyright (C) 2019, 2020, 2021, 2022, 2025  AO Industries, Inc.
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
import java.util.function.Function;

/**
 * <ul>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/grouping-content.html#the-hr-element">4.4.2 The hr element</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/hr">&lt;hr&gt;: The Thematic Break (Horizontal Rule) element</a>.</li>
 * <li>See <a href="https://www.w3schools.com/tags/tag_hr.asp">HTML hr tag</a>.</li>
 * </ul>
 *
 * @param  <D>   This document type
 * @param  <PC>  The parent content model this element is within
 * @param  <E>   This element type
 *
 * @author  AO Industries, Inc.
 */
@SuppressWarnings("deprecation")
public abstract class AnyHR<
    D  extends AnyDocument<D>,
    PC extends AnyFlowContent<D, PC>,
    E  extends AnyHR<D, PC, E>
    >
    extends Void<D, PC, E> implements
    com.aoapps.html.any.attributes.enumeration.Align<E, AnyHR.Align>,
    com.aoapps.html.any.attributes.bool.Noshade<E>,
    com.aoapps.html.any.attributes.integer.SizeHtml4Only<E>,
    com.aoapps.html.any.attributes.dimension.Width<E> {

  protected AnyHR(D document, PC pc) {
    super(document, pc);
  }

  @Override
  protected void writeOpen(Writer unsafe) throws IOException {
    document.autoNli(unsafe).unsafe(unsafe, "<hr", false);
  }

  @Override
  protected void doAfterElement(Writer unsafe) throws IOException {
    document.autoNl(unsafe);
  }

  /**
   * See <a href="https://www.w3schools.com/tags/att_hr_align.asp">HTML hr align Attribute</a>.
   *
   * @deprecated  The align attribute of &lt;hr&gt; is not supported in HTML5. Use CSS instead.
   */
  @Deprecated
  public enum Align implements Function<AnyDocument<?>, String> {

    /**
     * Left-aligns the horizontal line.
     */
    LEFT("left"),

    /**
     * Center-aligns the horizontal line (this is default).
     */
    CENTER("center"),

    /**
     * Right-aligns the horizontal line.
     */
    RIGHT("right");

    private final String value;

    private Align(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }

    @Override
    public String apply(AnyDocument<?> document) {
      return value;
    }
  }
}
