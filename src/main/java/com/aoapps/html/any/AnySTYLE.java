/*
 * ao-fluent-html-any - Base abstract classes and interfaces for Fluent Java DSL for high-performance HTML generation.
 * Copyright (C) 2019, 2020, 2021, 2022, 2023, 2025  AO Industries, Inc.
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

import com.aoapps.encoding.Doctype;
import com.aoapps.encoding.MediaEncoder;
import com.aoapps.encoding.MediaType;
import com.aoapps.encoding.Serialization;
import com.aoapps.encoding.StyleWritable;
import com.aoapps.encoding.StyleWriter;
import com.aoapps.hodgepodge.i18n.MarkupCoercion;
import com.aoapps.lang.Coercion;
import com.aoapps.lang.Strings;
import com.aoapps.lang.Throwables;
import com.aoapps.lang.io.ContentType;
import com.aoapps.lang.io.function.IOSupplierE;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Locale;

/**
 * <ul>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/semantics.html#the-style-element">4.2.6 The style element</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/style">&lt;style&gt;: The Style Information element</a>.</li>
 * <li>See <a href="https://www.w3schools.com/tags/tag_style.asp">HTML style tag</a>.</li>
 * </ul>
 *
 * @param  <D>   This document type
 * @param  <PC>  The parent content model this element is within
 * @param  <E>   This element type
 *
 * @author  AO Industries, Inc.
 */
// TODO: Extend RawTextElement: https://html.spec.whatwg.org/multipage/syntax.html#raw-text-elements
@SuppressWarnings("deprecation")
public abstract class AnySTYLE<
    D  extends AnyDocument<D>,
    PC extends AnyMetadataContent<D, PC>,
    E  extends AnySTYLE<D, PC, E>
    >
    extends Element<D, PC, E> implements
    com.aoapps.html.any.attributes.text.Media<E>,
    // TODO: type as enum, deprecated?  See type implementation in AnyScript
    // Global Attributes overrides
    com.aoapps.html.any.attributes.text.AccesskeyUnexpected<E>,
    com.aoapps.html.any.attributes.bool.AutofocusUnexpected<E>,
    com.aoapps.html.any.attributes.text.ClassNoHtml4<E>,
    com.aoapps.html.any.attributes.enumeration.DirUnexpected<E>,
    com.aoapps.html.any.attributes.text.IdNoHtml4<E>,
    com.aoapps.html.any.attributes.text.StyleNoHtml4<E>,
    com.aoapps.html.any.attributes.text.TitleNoHtml4<E>,
    // Global Event Attributes overrides
    com.aoapps.html.any.attributes.event.OnblurUnexpected<E>,
    com.aoapps.html.any.attributes.event.OnclickUnexpected<E>,
    com.aoapps.html.any.attributes.event.OncontextmenuUnexpected<E>,
    com.aoapps.html.any.attributes.event.OncopyUnexpected<E>,
    com.aoapps.html.any.attributes.event.OncutUnexpected<E>,
    com.aoapps.html.any.attributes.event.OndblclickUnexpected<E>,
    com.aoapps.html.any.attributes.event.OndragUnexpected<E>,
    com.aoapps.html.any.attributes.event.OndragendUnexpected<E>,
    com.aoapps.html.any.attributes.event.OndragenterUnexpected<E>,
    com.aoapps.html.any.attributes.event.OndragleaveUnexpected<E>,
    com.aoapps.html.any.attributes.event.OndragoverUnexpected<E>,
    com.aoapps.html.any.attributes.event.OndragstartUnexpected<E>,
    com.aoapps.html.any.attributes.event.OndropUnexpected<E>,
    com.aoapps.html.any.attributes.event.Onerror<E>, // TODO: Does this belong here? Only listed at https://www.w3schools.com/tags/ref_attributes.asp
    com.aoapps.html.any.attributes.event.OnfocusUnexpected<E>,
    com.aoapps.html.any.attributes.event.Onload<E>, // TODO: Does this belong here?
    com.aoapps.html.any.attributes.event.OnkeydownUnexpected<E>,
    com.aoapps.html.any.attributes.event.OnkeypressUnexpected<E>,
    com.aoapps.html.any.attributes.event.OnkeyupUnexpected<E>,
    com.aoapps.html.any.attributes.event.OnmousedownUnexpected<E>,
    com.aoapps.html.any.attributes.event.OnmouseenterUnexpected<E>,
    com.aoapps.html.any.attributes.event.OnmouseleaveUnexpected<E>,
    com.aoapps.html.any.attributes.event.OnmousemoveUnexpected<E>,
    com.aoapps.html.any.attributes.event.OnmouseoutUnexpected<E>,
    com.aoapps.html.any.attributes.event.OnmouseoverUnexpected<E>,
    com.aoapps.html.any.attributes.event.OnmouseupUnexpected<E>,
    com.aoapps.html.any.attributes.event.OnpasteUnexpected<E>,
    com.aoapps.html.any.attributes.event.OnscrollUnexpected<E>,
    com.aoapps.html.any.attributes.event.OnwheelUnexpected<E> {

  /**
   * See <a href="https://www.w3schools.com/tags/att_script_type.asp">HTML script type Attribute</a>.
   */
  public enum Type {
    /**
     * The default type.
     */
    TEXT_CSS(ContentType.CSS);

    private final String contentType;

    private Type(String contentType) {
      this.contentType = contentType;
    }

    @Override
    public String toString() {
      return contentType;
    }

    public String getContentType() {
      return contentType;
    }

    private static boolean assertAllLowerCaseAndTrimmed() {
      for (Type type : values()) {
        if (!type.contentType.equals(type.contentType.toLowerCase(Locale.ROOT))) {
          throw new AssertionError("Content types must be lowercase as looked-up later");
        }
        if (!type.contentType.equals(type.contentType.trim())) {
          throw new AssertionError("Content types must be trimmed as looked-up later");
        }
      }
      return true;
    }

    static {
      assert assertAllLowerCaseAndTrimmed();
    }
  }

  private final String type;

  protected AnySTYLE(D document, PC pc) {
    super(document, pc);
    this.type = null;
  }

  protected AnySTYLE(D document, PC pc, String type) {
    super(document, pc);
    type = Strings.trimNullIfEmpty(type);
    this.type = (type == null) ? null : type.toLowerCase(Locale.ROOT);
  }

  protected AnySTYLE(D document, PC pc, Type type) {
    super(document, pc);
    this.type = (type == null) ? null : type.getContentType();
  }

  @Override
  protected void writeOpen(Writer unsafe) throws IOException {
    document.autoNli(unsafe).unsafe(unsafe, "<style", false);
    E s = type();
    assert s == this;
  }

  /**
   * See <a href="https://www.w3schools.com/tags/att_style_type.asp">HTML style type Attribute</a>.
   *
   * @see Doctype#styleType(java.lang.Appendable)
   */
  protected E type() throws IOException {
    Writer unsafe = document.getRawUnsafe(null);
    if (
        type == null
            || type.equals(ContentType.CSS)
    ) {
      String typeAttr = document.encodingContext.getDoctype().getStyleType();
      int len = typeAttr.length();
      if (len > 0) {
        if (document.getAtnl()) {
          assert typeAttr.charAt(0) == ' ';
          document.autoIndent(unsafe, 1);
          unsafe.write(typeAttr, 1, len - 1);
          document.clearAtnl();
        } else {
          unsafe.write(typeAttr);
        }
      }
    } else {
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

  protected MediaType getMediaType() throws UnsupportedEncodingException {
    return type == null ? MediaType.CSS : MediaType.getMediaTypeForContentType(type);
  }

  protected MediaEncoder getMediaEncoder(MediaType mediaType) throws UnsupportedEncodingException {
    return MediaEncoder.getInstance(document.encodingContext, mediaType, MediaType.XHTML);
  }

  protected boolean doCdata() {
    return document.encodingContext.getSerialization() == Serialization.XML;
  }

  private boolean didBody;

  protected void startBody(Writer unsafe) throws IOException {
    if (!didBody) {
      document
          .autoIndent(unsafe)
          .unsafe(unsafe, doCdata() ? (">/*<![CDATA[*/" + NL) : (">" + NL), true)
          .incDepth();
      didBody = true;
    }
  }

  // TODO: Return a "Body" / "StyleBody" that only allows additional out or closing the tag.
  // TODO:     Setting attributes after startBody() would create invalid HTML.
  // TODO:     Similar for "text", too.
  // TODO: Out parameter with MediaType, that automatically picks the encoder
  // TODO: Separate "Write" for direct writing (no encoding)?
  @SuppressWarnings("UseSpecificCatch")
  // TODO: No "out", just closing "__"?
  public E out(Object style) throws IOException {
    while (style instanceof IOSupplierE<?, ?>) {
      try {
        style = ((IOSupplierE<?, ?>) style).get();
      } catch (Throwable t) {
        throw Throwables.wrap(t, IOException.class, IOException::new);
      }
    }
    if (style instanceof StyleWritable) {
      try {
        @SuppressWarnings("unchecked")
        StyleWritable<?> writable = (StyleWritable<?>) style;
        return out(writable);
      } catch (Throwable t) {
        throw Throwables.wrap(t, IOException.class, IOException::new);
      }
    }
    style = Coercion.nullIfEmpty(style);
    if (style != null) {
      Writer unsafe = document.getRawUnsafe(null);
      startBody(unsafe);
      // Allow text markup from translations
      MediaType mediaType = getMediaType();
      MarkupCoercion.write(
          style,
          mediaType.getMarkupType(),
          true,
          getMediaEncoder(mediaType),
          false,
          unsafe
      );
      document.clearAtnl(); // Unknown, safe to assume not at newline
    }
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return element;
  }

  /**
   * @param  <Ex>  An arbitrary exception type that may be thrown
   */
  // TODO: No "out", just closing "__"?
  public <Ex extends Throwable> E out(IOSupplierE<?, Ex> style) throws IOException, Ex {
    return out((style == null) ? null : style.get());
  }

  /**
   * @param  <Ex>  An arbitrary exception type that may be thrown
   */
  // TODO: No "out", just closing "__"?
  public <Ex extends Throwable> E out(StyleWritable<Ex> style) throws IOException, Ex {
    if (style != null) {
      MediaType newOutputType = getMediaType();
      MediaEncoder encoder = getMediaEncoder(newOutputType);
      Writer unsafe = document.getRawUnsafe(null);
      startBody(unsafe);
      style.writeTo(
          newOutputType.newMediaWriter(
              document.encodingContext,
              encoder,
              document.getRawUnsafe(null),
              false,
              document,
              mediaWriter -> true, // isNoClose
              null // Ignore close
          )
      );
      document.clearAtnl(); // Unknown, safe to assume not at newline
    }
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return element;
  }

  /**
   * Writes the style, automatically closing the style via
   * {@link #__()} on {@link StyleWriter#close()}.
   * This is well suited for use in a try-with-resources block.
   */
  // TODO: __() method to end text?  Call it "ContentWriter"?
  public StyleWriter _c() throws IOException {
    MediaType newOutputType = getMediaType();
    MediaEncoder encoder = getMediaEncoder(newOutputType);
    Writer unsafe = document.getRawUnsafe(null);
    startBody(unsafe);
    // Invoking via newMediaWriter to support subclasses of StyleWriter
    return (StyleWriter) newOutputType.newMediaWriter(
        document.encodingContext,
        encoder,
        unsafe,
        false,
        document,
        mediaWriter -> false, // !isNoClose
        closing -> __()
    );
  }

  /**
   * Closes this element.
   *
   * @return  The parent content model this element is within
   */
  public PC __() throws IOException {
    Writer unsafe = document.getRawUnsafe(null);
    if (!didBody) {
      document.autoIndent(unsafe).unsafe(unsafe, "></style>", false);
    } else {
      document.decDepth().nli(unsafe).unsafe(unsafe, doCdata() ? "/*]]>*/</style>" : "</style>", false);
    }
    document.autoNl(unsafe);
    return pc;
  }
}
