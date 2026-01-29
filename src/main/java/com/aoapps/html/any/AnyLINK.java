/*
 * ao-fluent-html-any - Base abstract classes and interfaces for Fluent Java DSL for high-performance HTML generation.
 * Copyright (C) 2019, 2020, 2021, 2022, 2023, 2024, 2025  AO Industries, Inc.
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

import static com.aoapps.encoding.TextInXhtmlAttributeEncoder.encodeTextInXhtmlAttribute;
import static com.aoapps.encoding.TextInXhtmlAttributeEncoder.textInXhtmlAttributeEncoder;

import com.aoapps.encoding.Doctype;
import com.aoapps.html.any.AnySTYLE.Type;
import com.aoapps.lang.Coercion;
import com.aoapps.lang.LocalizedIllegalStateException;
import com.aoapps.lang.Strings;
import com.aoapps.lang.io.ContentType;
import com.aoapps.lang.io.function.IOSupplierE;
import java.io.IOException;
import java.io.Writer;
import java.util.ResourceBundle;
import java.util.function.Function;

/**
 * <ul>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/semantics.html#the-link-element">4.2.4 The link element</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/link">&lt;link&gt;: The External Resource Link element</a>.</li>
 * <li>See <a href="https://www.w3schools.com/tags/tag_link.asp">HTML link tag</a>.</li>
 * </ul>
 *
 * @param  <D>   This document type
 * @param  <PC>  The parent content model this element is within
 * @param  <E>   This element type
 *
 * @author  AO Industries, Inc.
 */
// TODO: Have multiple implementations, along with "Dynamic", similar to AnyINPUT?
@SuppressWarnings("deprecation")
public abstract class AnyLINK<
    D  extends AnyDocument<D>,
    PC extends AnyUnion_Metadata_Phrasing<D, PC>,
    E  extends AnyLINK<D, PC, E>
    >
    extends Void<D, PC, E> implements
    // TODO: as
    com.aoapps.html.any.attributes.enumeration.CharsetHtml4Only<E, com.aoapps.html.any.attributes.enumeration.Charset.Value>,
    com.aoapps.html.any.attributes.enumeration.Crossorigin<E>,
    // https://developer.mozilla.org/en-US/docs/Web/HTML/Element/link#attr-disabled
    com.aoapps.html.any.attributes.bool.Disabled<E>,
    com.aoapps.html.any.attributes.url.Href<E>,
    com.aoapps.html.any.attributes.text.Hreflang<E>,
    com.aoapps.html.any.attributes.text.Media<E>,
    com.aoapps.html.any.attributes.enumeration.Rel<E, AnyLINK.Rel>,
    // TODO: rev
    // TODO: sizes
    // TODO: target (not standardized per MDN)
    // TODO: type
    // Global Event Attributes overrides
    com.aoapps.html.any.attributes.event.Onerror<E>,
    com.aoapps.html.any.attributes.event.Onload<E> {

  private static final com.aoapps.lang.i18n.Resources RESOURCES =
      com.aoapps.lang.i18n.Resources.getResources(ResourceBundle::getBundle, AnyLINK.class);

  protected AnyLINK(D document, PC pc) {
    super(document, pc);
  }

  @Override
  protected void writeOpen(Writer unsafe) throws IOException {
    document.autoNli(unsafe).unsafe(unsafe, "<link", false);
  }

  /**
   * <a href="https://html.spec.whatwg.org/multipage/semantics.html#the-link-element">HTML Standard</a>:
   * "A link element must have either a rel attribute or an itemprop attribute, but not both".
   */
  private Object itemprop;

  // TODO: Is global property, move there and add See comment, still checking for link-specific rules here
  // TODO: Attributes...itemprop in global
  public E itemprop(Object itemprop) throws IOException {
    itemprop = Coercion.trimNullIfEmpty(itemprop);
    if (itemprop != null) {
      if (this.itemprop != null) {
        throw new LocalizedIllegalStateException(
            AnyDocument.RESOURCES,
            "duplicateAttribute",
            "link",
            "itemprop",
            Coercion.toString(this.itemprop),
            Coercion.toString(itemprop)
        );
      }
      this.itemprop = itemprop;
      if (this.rel != null) {
        throw new LocalizedIllegalStateException(RESOURCES, "relOrItemprop");
      }
      Writer unsafe = document.getRawUnsafe(null);
      if (document.getAtnl()) {
        document.autoIndent(unsafe, 1);
        unsafe.write("itemprop=\"");
        document.clearAtnl();
      } else {
        unsafe.write(" itemprop=\"");
      }
      Coercion.write(itemprop, textInXhtmlAttributeEncoder, unsafe);
      unsafe.append('"');
    }
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return element;
  }

  /**
   * <ul>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Link_types">Link types - HTML: Hypertext Markup Language</a>.</li>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/semantics.html#attr-link-rel">HTML Standard</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/att_link_rel.asp">HTML link rel Attribute</a>.</li>
   * </ul>
   */
  public enum Rel implements Function<AnyDocument<?>, String> {
    ALTERNATE("alternate"),
    /**
     * MDN only.
     *
     * @deprecated MDN only
     */
    @Deprecated(forRemoval = true)
    ARCHIVES("archives"),
    AUTHOR("author"), // w3schools, MDN only
    CANONICAL("canonical"), // MDN only
    DNS_PREFETCH("dns-prefetch"),
    /**
     * MDN only.
     *
     * @deprecated MDN only
     */
    @Deprecated(forRemoval = true)
    FIRST("first"),
    HELP("help"), // w3schools, MDN only
    ICON("icon"),
    IMPORT("import"), // MDN only
    /**
     * MDN only.
     *
     * @deprecated MDN only
     */
    @Deprecated(forRemoval = true)
    INDEX("index"),
    /**
     * MDN only.
     *
     * @deprecated MDN only
     */
    @Deprecated(forRemoval = true)
    LAST("last"),
    LICENSE("license"), // w3schools, MDN only
    MANIFEST("manifest"), // MDN only
    MODULEPRELOAD("modulepreload"),
    NEXT("next"),
    PINGBACK("pingback"),
    PRECONNECT("preconnect"),
    PREFETCH("prefetch"),
    PRELOAD("preload"),
    PRERENDER("prerender"),
    PREV("prev"), // w3schools, MDN only
    SEARCH("search"),
    SHORTLINK("shortlink"), // MDN only
    /**
     * MDN only.
     *
     * @deprecated MDN only
     */
    @Deprecated(forRemoval = true)
    SIDEBAR("sidebar"),
    STYLESHEET("stylesheet"),
    /**
     * MDN only.
     *
     * @deprecated MDN only
     */
    @Deprecated(forRemoval = true)
    UP("up"),

    /**
     * To specify an icon for a single webpage or replace the website icon with a webpage-specific icon, add a link element to the webpage.
     *
     * <p>See <a href="https://developer.apple.com/library/archive/documentation/AppleApplications/Reference/SafariWebContent/ConfiguringWebApplications/ConfiguringWebApplications.html">Configuring Web Applications</a>.</p>
     */
    APPLE_TOUCH_ICON("apple-touch-icon"),

    /**
     * On iOS, similar to native applications, you can specify a launch screen image that is displayed while your web application launches.
     *
     * <p>See <a href="https://developer.apple.com/library/archive/documentation/AppleApplications/Reference/SafariWebContent/ConfiguringWebApplications/ConfiguringWebApplications.html">Configuring Web Applications</a>.</p>
     */
    APPLE_TOUCH_STARTUP_IMAGE("apple-touch-startup-image");

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

  private String rel;

  /**
   * <a href="https://html.spec.whatwg.org/multipage/semantics.html#the-link-element">HTML Standard</a>:
   * "A link element must have either a rel attribute or an itemprop attribute, but not both".
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/semantics.html#attr-link-rel">HTML Standard</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/att_link_rel.asp">HTML link rel Attribute</a>.</li>
   * </ul>
   */
  @Override
  public E rel(String rel) throws IOException {
    rel = Strings.trimNullIfEmpty(rel);
    if (rel != null) {
      if (this.rel != null) {
        throw new LocalizedIllegalStateException(
            AnyDocument.RESOURCES,
            "duplicateAttribute",
            "link",
            "rel",
            Coercion.toString(this.rel),
            Coercion.toString(rel)
        );
      }
      this.rel = rel;
      if (this.itemprop != null) {
        throw new LocalizedIllegalStateException(RESOURCES, "relOrItemprop");
      }
      com.aoapps.html.any.attributes.enumeration.Rel.super.rel(rel);
    }
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return element;
  }

  /**
   * <a href="https://html.spec.whatwg.org/multipage/semantics.html#the-link-element">HTML Standard</a>:
   * "A link element must have either a rel attribute or an itemprop attribute, but not both".
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/semantics.html#attr-link-rel">HTML Standard</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/att_link_rel.asp">HTML link rel Attribute</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @see AnyLINK#rel(java.lang.String)
   */
  @Override
  public <Ex extends Throwable> E rel(Suppliers.String<Ex> rel) throws IOException, Ex {
    return com.aoapps.html.any.attributes.enumeration.Rel.super.rel(rel);
  }

  /**
   * <a href="https://html.spec.whatwg.org/multipage/semantics.html#the-link-element">HTML Standard</a>:
   * "A link element must have either a rel attribute or an itemprop attribute, but not both".
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/semantics.html#attr-link-rel">HTML Standard</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/att_link_rel.asp">HTML link rel Attribute</a>.</li>
   * </ul>
   *
   * @see AnyLINK#rel(java.lang.String)
   */
  @Override
  public E rel(Rel rel) throws IOException {
    return com.aoapps.html.any.attributes.enumeration.Rel.super.rel(rel);
  }

  /**
   * <a href="https://html.spec.whatwg.org/multipage/semantics.html#the-link-element">HTML Standard</a>:
   * "A link element must have either a rel attribute or an itemprop attribute, but not both".
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/semantics.html#attr-link-rel">HTML Standard</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/att_link_rel.asp">HTML link rel Attribute</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @see AnyLINK#rel(com.aoapps.html.AnyLINK.Rel)
   */
  @Override
  public <Ex extends Throwable> E rel(IOSupplierE<Rel, Ex> rel) throws IOException, Ex {
    return com.aoapps.html.any.attributes.enumeration.Rel.super.rel(rel);
  }

  private String type;

  /**
   * If the rel is {@link Rel#STYLESHEET}, the type is {@link Type#TEXT_CSS},
   * and the {@link Doctype} is {@link Doctype#HTML5}, skips writing
   * the type.
   *
   * <p>See <a href="https://www.w3schools.com/tags/att_link_type.asp">HTML link type Attribute</a>.</p>
   */
  public E type(String type) throws IOException {
    type = Strings.trimNullIfEmpty(type);
    this.type = type;
    if (
        type != null
            && !(
            document.encodingContext.getDoctype() == Doctype.HTML5
                && rel != null
                && rel.equalsIgnoreCase(Rel.STYLESHEET.toString())
                && ContentType.CSS.equalsIgnoreCase(type)
          )
    ) {
      Writer unsafe = document.getRawUnsafe(null);
      if (document.getAtnl()) {
        document.autoIndent(unsafe, 1);
        unsafe.write("type=\"");
        document.clearAtnl();
      } else {
        unsafe.write(" type=\"");
      }
      encodeTextInXhtmlAttribute(type, unsafe);
      unsafe.append('"');
    }
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return element;
  }

  /**
   * {@inheritDoc}
   *
   * <p>If the rel is {@link Rel#STYLESHEET}, a {@linkplain AnyLINK#type(java.lang.String) type}
   * has not been written, and the {@link Doctype} is not {@link Doctype#HTML5},
   * writes the default type {@link Type#TEXT_CSS} for backward compatibility.</p>
   *
   * <p><a href="https://html.spec.whatwg.org/multipage/semantics.html#the-link-element">HTML Standard</a>:
   * "A link element must have either a rel attribute or an itemprop attribute, but not both".</p>
   *
   * @return  The parent content model this element is within
   */
  @Override
  public PC __() throws IOException {
    if (
        type == null
            && document.encodingContext.getDoctype() != Doctype.HTML5
            && rel != null
            && rel.equalsIgnoreCase(Rel.STYLESHEET.toString())
    ) {
      Writer unsafe = document.getRawUnsafe(null);
      if (document.getAtnl()) {
        document.autoIndent(unsafe, 1);
        unsafe.write("type=\"" + ContentType.CSS + '"');
        document.clearAtnl();
      } else {
        unsafe.write(" type=\"" + ContentType.CSS + '"');
      }
    }
    return super.__();
  }

  @Override
  protected void doAfterElement(Writer unsafe) throws IOException {
    document.autoNl(unsafe);
    if (rel == null && itemprop == null) {
      throw new LocalizedIllegalStateException(RESOURCES, "relOrItemprop");
    }
  }
}
