/*
 * ao-fluent-html-any - Base abstract classes and interfaces for Fluent Java DSL for high-performance HTML generation.
 * Copyright (C) 2021, 2022, 2024, 2025  AO Industries, Inc.
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

import com.aoapps.lang.LocalizedIllegalStateException;
import java.io.IOException;
import java.io.Writer;
import java.util.ResourceBundle;
import java.util.function.Function;

/**
 * <ul>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/text-level-semantics.html#the-a-element">4.5.1 The a element</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/a">&lt;a&gt;: The Anchor element</a>.</li>
 * <li>See <a href="https://www.w3schools.com/tags/tag_a.asp">HTML a tag</a>.</li>
 * </ul>
 *
 * @param  <D>   This document type
 * @param  <PC>  The parent content model this element is within
 * @param  <E>   This element type
 * @param  <_c>  This content model as {@link Closeable}, which will be the parent content model of child elements
 *
 * @author  AO Industries, Inc.
 */
// TODO: Transparent, but there must be no interactive content descendent, a element descendent, or descendent with
//       the tabindex attribute specified.
public abstract class AnyA<
    D  extends AnyDocument<D>,
    PC extends AnyUnion_Interactive_Phrasing<D, PC>,
    E  extends AnyA<D, PC, E, _c>,
    _c extends AnyA_c<D, PC, _c>
    >
    extends Transparent<D, PC, E, _c> implements
    com.aoapps.html.any.attributes.url.Href<E>,
    com.aoapps.html.any.attributes.enumeration.Target<E, com.aoapps.html.any.attributes.enumeration.Target.Value>,
    // TODO: download
    // TODO: ping
    com.aoapps.html.any.attributes.enumeration.Rel<E, AnyA.Rel>,
    com.aoapps.html.any.attributes.text.Hreflang<E>,
    // TODO: type
    // TODO: referrerpolicy
    // Global Attributes overrides
    com.aoapps.html.any.attributes.integer.TabindexHtml4<E> {

  private static final com.aoapps.lang.i18n.Resources RESOURCES =
      com.aoapps.lang.i18n.Resources.getResources(ResourceBundle::getBundle, AnyA.class);

  protected AnyA(D document, PC pc) {
    super(document, pc);
  }

  @Override
  protected void writeOpen(Writer unsafe) throws IOException {
    document.autoIndent(unsafe).unsafe(unsafe, "<a", false);
  }

  @Override
  protected void writeClose(Writer unsafe, boolean closeAttributes) throws IOException {
    document.autoIndent(unsafe).unsafe(unsafe, closeAttributes ? "></a>" : "</a>", false);
  }

  /**
   * Ends attributes, writes a text body, then closes this element.
   *
   * <p>Since {@link AnyTextContent} is not a part of {@link AnyUnion_Interactive_Phrasing},
   * strictly speaking text is not allowed in all possible content models that can apply to <code>&lt;a&gt;</code>.
   * However, since it is such a common operation, we've added it here.</p>
   *
   * @return  The parent content model this element is within
   *
   * @see  AnyDocument#text(java.lang.Object)
   * @see  NormalText#__(java.lang.Object)
   *
   * @throws  IllegalStateException when {@code text != null} and current content model does not allow text
   */
  public PC __(Object text) throws IOException, IllegalStateException {
    @SuppressWarnings("deprecation")
    Writer unsafe = document.getRawUnsafe(null);
    if (text != null) {
      if (!(pc instanceof AnyTextContent)) {
        throw new LocalizedIllegalStateException(RESOURCES, "contentModelNotAllowText", (pc == null) ? "null" : pc.getClass().getName());
      }
      document.autoIndent(unsafe).unsafe(unsafe, '>').incDepth().text(unsafe, text).decDepth();
      writeClose(unsafe, false);
    } else {
      writeClose(unsafe, true);
    }
    return pc;
  }

  /**
   * <ul>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Link_types">Link types - HTML: Hypertext Markup Language</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/links.html#attr-hyperlink-rel">HTML Standard</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/att_a_rel.asp">HTML a rel Attribute</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/att_area_rel.asp">HTML area rel Attribute</a>.</li>
   * </ul>
   */
  public enum Rel implements Function<AnyDocument<?>, String> {
    ALTERNATE("alternate"),
    /**
     * MDN only.
     *
     * @deprecated MDN only
     */
    @Deprecated
        ARCHIVES("archives"),
    AUTHOR("author"), // w3schools, MDN only
    BOOKMARK("bookmark"),
    EXTERNAL("external"),
    /**
     * MDN only.
     *
     * @deprecated MDN only
     */
    @Deprecated
        FIRST("first"),
    HELP("help"), // w3schools, MDN only
    /**
     * MDN only.
     *
     * @deprecated MDN only
     */
    @Deprecated
        INDEX("index"),
    /**
     * MDN only.
     *
     * @deprecated MDN only
     */
    @Deprecated
        LAST("last"),
    LICENSE("license"), // w3schools, MDN only
    NEXT("next"),
    NOFOLLOW("nofollow"),
    NOOPENER("noopener"),
    NOREFERRER("noreferrer"),
    // TODO: opener?
    PREV("prev"), // w3schools, MDN only
    SEARCH("search"),
    /**
     * MDN only.
     *
     * @deprecated MDN only
     */
    @Deprecated
        SIDEBAR("sidebar"),
    TAG("tag"),
    /**
     * MDN only.
     *
     * @deprecated MDN only
     */
    @Deprecated
        UP("up");

    private final String value;

    // TODO: Verify values by doctype

    private Rel(String value) {
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
