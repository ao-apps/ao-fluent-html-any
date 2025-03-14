/*
 * ao-fluent-html-any - Base abstract classes and interfaces for Fluent Java DSL for high-performance HTML generation.
 * Copyright (C) 2020, 2021, 2022, 2025  AO Industries, Inc.
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
 * <li>See <a href="https://html.spec.whatwg.org/multipage/tables.html#the-col-element">4.9.4 The col element</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/col">&lt;col&gt; - The Table Column element</a>.</li>
 * <li>See <a href="https://www.w3schools.com/tags/tag_col.asp">HTML col tag</a>.</li>
 * </ul>
 *
 * @param  <D>   This document type
 * @param  <PC>  The parent content model this element is within
 * @param  <E>   This element type
 *
 * @author  AO Industries, Inc.
 */
@SuppressWarnings("deprecation")
public abstract class AnyCOL<
    D  extends AnyDocument<D>,
    PC extends AnyCOLGROUP_content<D, PC>,
    E  extends AnyCOL<D, PC, E>
    >
    extends Void<D, PC, E> implements
    com.aoapps.html.any.attributes.enumeration.Align<E, AnyCOL.Align>,
    // TODO: bgcolor (deprecated)
    // TODO: char (deprecated)
    // TODO: charoff (deprecated)
    com.aoapps.html.any.attributes.integer.Span<E>,
    com.aoapps.html.any.attributes.enumeration.Valign<E, AnyCOL.Valign>,
    com.aoapps.html.any.attributes.dimension.WidthHtml4Only<E> {

  protected AnyCOL(D document, PC pc) {
    super(document, pc);
  }

  @Override
  protected void writeOpen(Writer unsafe) throws IOException {
    document.autoNli(unsafe).unsafe(unsafe, "<col", false);
  }

  @Override
  protected void doAfterElement(Writer unsafe) throws IOException {
    document.autoNl(unsafe);
  }

  /**
   * See <a href="https://www.w3schools.com/tags/att_col_align.asp">HTML col align Attribute</a>.
   *
   * @deprecated  The align attribute of &lt;col&gt; is not supported in HTML5. Use CSS instead.
   */
  @Deprecated(forRemoval = false)
  public enum Align implements Function<AnyDocument<?>, String> {

    /**
     * Left-align content.
     */
    LEFT("left"),

    /**
     * Right-align content.
     */
    RIGHT("right"),

    /**
     * Center-align content.
     */
    CENTER("center"),

    /**
     * Stretches the lines so that each line has equal width (like in newspapers and magazines).
     */
    JUSTIFY("justify"),

    /**
     * Align the content to a specific character.
     */
    CHAR("char");

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

  /**
   * See <a href="https://www.w3schools.com/tags/att_col_valign.asp">HTML col valign Attribute</a>.
   *
   * @deprecated  The valign attribute of &lt;col&gt; is not supported in HTML5. Use CSS instead.
   */
  @Deprecated(forRemoval = false)
  public enum Valign implements Function<AnyDocument<?>, String> {

    /**
     * Top-align content.
     */
    TOP("top"),

    /**
     * Center-align content.
     */
    MIDDLE("middle"),

    /**
     * Bottom-align content.
     */
    BOTTOM("bottom"),

    /**
     * The baseline is the "imaginary line" which most letters "sit" on, in a line of text.
     */
    BASELINE("baseline");

    private final String value;

    private Valign(String value) {
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
