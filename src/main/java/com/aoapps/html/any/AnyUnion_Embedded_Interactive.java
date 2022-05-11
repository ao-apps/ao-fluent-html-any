/*
 * ao-fluent-html-any - Base abstract classes and interfaces for Fluent Java DSL for high-performance HTML generation.
 * Copyright (C) 2021, 2022  AO Industries, Inc.
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

import com.aoapps.lang.io.function.IOConsumerE;
import com.aoapps.lang.io.function.IORunnableE;
import com.aoapps.lang.io.function.IOSupplierE;
import java.io.IOException;

/**
 * Elements that are common to both {@link AnyEmbeddedContent} and {@link AnyInteractiveContent}.
 *
 * @param  <D>   This document type
 * @param  <__>  This content model, which will be the parent content model of child elements
 *
 * @author  AO Industries, Inc.
 */
public interface AnyUnion_Embedded_Interactive<
    D  extends AnyDocument<D>,
    __ extends AnyUnion_Embedded_Interactive<D, __>
    >
    extends
    //
    // Content models:
    //
    Content<D, __> {
  //
  // Factories:
  //
  // <editor-fold defaultstate="collapsed" desc="AUDIO">
  /**
   * Opens a new audio element.
   * <p>
   * See <a href="https://html.spec.whatwg.org/multipage/media.html#the-audio-element">4.8.10 The audio element</a>.
   * </p>
   *
   * @since HTML 5
   *
   * @deprecated  TODO: Implement audio
   */
  @Deprecated
  @Factory("audio")
  default AnyAUDIO audio() throws IOException {
    throw new AssertionError("TODO: Implement audio");
  }

  // </editor-fold>
  // <editor-fold defaultstate="collapsed" desc="EMBED">
  /**
   * Opens a new embed element.
   * <p>
   * See <a href="https://html.spec.whatwg.org/multipage/iframe-embed-object.html#the-embed-element">4.8.6 The embed element</a>.
   * </p>
   *
   * @deprecated  TODO: Implement embed
   */
  @Deprecated
  @Factory("embed")
  default AnyEMBED embed() throws IOException {
    throw new AssertionError("TODO: Implement embed");
  }

  // </editor-fold>
  // <editor-fold defaultstate="collapsed" desc="IFRAME">
  /**
   * Opens a new iframe element.
   * <p>
   * See <a href="https://html.spec.whatwg.org/multipage/iframe-embed-object.html#the-iframe-element">4.8.5 The iframe element</a>.
   * </p>
   *
   * @deprecated  TODO: Implement iframe
   */
  @Deprecated
  @Factory("iframe")
  default AnyIFRAME iframe() throws IOException {
    throw new AssertionError("TODO: Implement iframe");
  }

  // </editor-fold>
  // <editor-fold defaultstate="collapsed" desc="IMG">
  /**
   * Opens a new img element.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/embedded-content.html#the-img-element">4.8.3 The img element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/img">&lt;img&gt;: The Image Embed element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_img.asp">HTML img tag</a>.</li>
   * </ul>
   */
  @Factory("img")
  AnyIMG<D, __, ?> img() throws IOException;

  /**
   * Opens a new img element with the given src attribute.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/embedded-content.html#the-img-element">4.8.3 The img element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/img">&lt;img&gt;: The Image Embed element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_img.asp">HTML img tag</a>.</li>
   * </ul>
   */
  @Factory("img")
  AnyIMG<D, __, ?> img(String src) throws IOException;

  /**
   * Opens a new img element with the given src attribute.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/embedded-content.html#the-img-element">4.8.3 The img element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/img">&lt;img&gt;: The Image Embed element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_img.asp">HTML img tag</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   */
  @Factory("img")
  <Ex extends Throwable> AnyIMG<D, __, ?> img(IOSupplierE<? extends String, Ex> src) throws IOException, Ex;

  // </editor-fold>
  // <editor-fold defaultstate="collapsed" desc="OBJECT">
  /**
   * Opens a new object element.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/iframe-embed-object.html#the-object-element">4.8.7 The object element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/object">&lt;object&gt;: The External Object element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_object.asp">HTML object tag</a>.</li>
   * </ul>
   */
  @Factory("object")
  AnyOBJECT<D, __, ?, ?, ?> object() throws IOException;

  /**
   * Creates an object element with no attributes and the given body.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/iframe-embed-object.html#the-object-element">4.8.7 The object element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/object">&lt;object&gt;: The External Object element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_object.asp">HTML object tag</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @return  This content model, which will be the parent content model of child elements
   */
  @Factory("object")
  default <Ex extends Throwable> __ object__(IORunnableE<Ex> object) throws IOException, Ex {
    return object().__(object);
  }

  /**
   * Creates an object element with no attributes and the given body.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/iframe-embed-object.html#the-object-element">4.8.7 The object element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/object">&lt;object&gt;: The External Object element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_object.asp">HTML object tag</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   * @param  object  The content model of this element, which will be the parent content model of child elements.
   *                 <p>
   *                 Due to limitations in Java generics, this content model does not directly reflect the parent content
   *                 model, despite this being a transparent content model.  Rather, it includes only the content model that
   *                 always applies to this element type.
   *                 </p>
   *                 <p><em>
   *                 For the full, context-aware content model, which will likely include more elements,
   *                 {@linkplain AnyOBJECT__#pc() use the parent content model directly}.
   *                 </em></p>
   *
   * @return  This content model, which will be the parent content model of child elements
   *
   * @see  AnyOBJECT__#pc()
   */
  @Factory("object")
  default <Ex extends Throwable> __ object__any(IOConsumerE<? super AnyOBJECT__<D, __, ? extends AnyOBJECT__<D, __, ?>>, Ex> object) throws IOException, Ex {
    return object().__(object);
  }

  /**
   * Creates an empty object element with no attributes.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/iframe-embed-object.html#the-object-element">4.8.7 The object element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/object">&lt;object&gt;: The External Object element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_object.asp">HTML object tag</a>.</li>
   * </ul>
   *
   * @return  This content model, which will be the parent content model of child elements
   */
  @Factory("object")
  default __ object__() throws IOException {
    return object().__();
  }

  /**
   * Creates an object element with no attributes then begins element content.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/iframe-embed-object.html#the-object-element">4.8.7 The object element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/object">&lt;object&gt;: The External Object element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_object.asp">HTML object tag</a>.</li>
   * </ul>
   *
   * @return  The content model of this element, which will be the parent content model of child elements.
   *          This must be {@linkplain Closeable#__() ended} or {@linkplain Closeable#close() closed} in order to end
   *          the tag.  This is well suited for use in a try-with-resources block.
   *          <p>
   *          Due to limitations in Java generics, this content model does not directly reflect the parent content
   *          model, despite this being a transparent content model.  Rather, it includes only the content model that
   *          always applies to this element type.
   *          </p>
   *          <p><em>
   *          For the full, context-aware content model, which will likely include more elements,
   *          {@linkplain AnyOBJECT_c#pc() use the parent content model directly}.
   *          </em></p>
   *
   * @see  Closeable#__()
   * @see  Closeable#close()
   * @see  AnyOBJECT_c#pc()
   */
  @Factory("object")
  AnyOBJECT_c<D, __, ?> object_c() throws IOException;

  // </editor-fold>
  // <editor-fold defaultstate="collapsed" desc="VIDEO">
  /**
   * Opens a new video element.
   * <p>
   * See <a href="https://html.spec.whatwg.org/multipage/media.html#the-video-element">4.8.9 The video element</a>.
   * </p>
   *
   * @since HTML 5
   *
   * @deprecated  TODO: Implement video
   */
  @Deprecated
  @Factory("video")
  default AnyVIDEO video() throws IOException {
    throw new AssertionError("TODO: Implement video");
  }
  // </editor-fold>
}
