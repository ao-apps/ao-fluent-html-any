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

package com.aoapps.html.any.attributes.enumeration;

import com.aoapps.hodgepodge.i18n.MarkupType;
import com.aoapps.html.any.AnyDocument;
import com.aoapps.html.any.Attributes;
import com.aoapps.html.any.Element;
import com.aoapps.html.any.Suppliers;
import com.aoapps.lang.Strings;
import com.aoapps.lang.io.function.IOSupplierE;
import java.io.IOException;
import java.util.function.Function;

/**
 * <ul>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input#htmlattrdefcapture">&lt;input&gt;: The Input (Form Input) element</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input/file#capture">&lt;input type="file"&gt;</a>.</li>
 * <li>See <a href="https://www.w3.org/TR/html-media-capture/#the-capture-attribute">5. The capture attribute</a>.</li>
 * <li>See <a href="https://www.w3.org/TR/mediacapture-streams/#dom-videofacingmodeenum">Media Capture and Streams: VideoFacingModeEnum</a>.</li>
 * </ul>
 *
 * @param  <E>   This element type
 * @param  <V>   This enum type to use for this attribute
 *
 * @since HTML 5
 *
 * @author  AO Industries, Inc.
 */
public interface Capture<
    E extends Element<?, ?, E> & Capture<E, V>,
    V extends Enum<V> & Function<? super AnyDocument<?>, String>
    > {

  /**
   * Utility class for working with {@link Capture}.
   *
   * <ul>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input#htmlattrdefcapture">&lt;input&gt;: The Input (Form Input) element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input/file#capture">&lt;input type="file"&gt;</a>.</li>
   * <li>See <a href="https://www.w3.org/TR/html-media-capture/#the-capture-attribute">5. The capture attribute</a>.</li>
   * <li>See <a href="https://www.w3.org/TR/mediacapture-streams/#dom-videofacingmodeenum">Media Capture and Streams: VideoFacingModeEnum</a>.</li>
   * </ul>
   *
   * @since HTML 5
   */
  public static final class capture {
    /** Make no instances. */
    private capture() {
      throw new AssertionError();
    }

    /**
     * Normalizes a capture attribute.
     *
     * @see  Strings#trimNullIfEmpty(java.lang.String)
     */
    public static String normalize(String capture) {
      return Strings.trimNullIfEmpty(capture);
    }
  }

  /**
   * <ul>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input#htmlattrdefcapture">&lt;input&gt;: The Input (Form Input) element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input/file#capture">&lt;input type="file"&gt;</a>.</li>
   * <li>See <a href="https://www.w3.org/TR/html-media-capture/#the-capture-attribute">5. The capture attribute</a>.</li>
   * <li>See <a href="https://www.w3.org/TR/mediacapture-streams/#dom-videofacingmodeenum">Media Capture and Streams: VideoFacingModeEnum</a>.</li>
   * </ul>
   *
   * @since HTML 5
   */
  @Attributes.Funnel
  default E capture(String capture) throws IOException {
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return Attributes.String.attribute(element, "capture", MarkupType.NONE, capture, Capture.capture::normalize,
        value -> Attributes.validateInHtml5(element, "capture"));
  }

  /**
   * <ul>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input#htmlattrdefcapture">&lt;input&gt;: The Input (Form Input) element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input/file#capture">&lt;input type="file"&gt;</a>.</li>
   * <li>See <a href="https://www.w3.org/TR/html-media-capture/#the-capture-attribute">5. The capture attribute</a>.</li>
   * <li>See <a href="https://www.w3.org/TR/mediacapture-streams/#dom-videofacingmodeenum">Media Capture and Streams: VideoFacingModeEnum</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @since HTML 5
   *
   * @see Capture#capture(java.lang.String)
   */
  @SuppressWarnings("overloads")
  default <Ex extends Throwable> E capture(Suppliers.String<Ex> capture) throws IOException, Ex {
    return capture((capture == null) ? null : capture.get());
  }

  /**
   * <ul>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input#htmlattrdefcapture">&lt;input&gt;: The Input (Form Input) element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input/file#capture">&lt;input type="file"&gt;</a>.</li>
   * <li>See <a href="https://www.w3.org/TR/html-media-capture/#the-capture-attribute">5. The capture attribute</a>.</li>
   * <li>See <a href="https://www.w3.org/TR/mediacapture-streams/#dom-videofacingmodeenum">Media Capture and Streams: VideoFacingModeEnum</a>.</li>
   * </ul>
   *
   * @since HTML 5
   *
   * @see Capture#capture(java.lang.String)
   */
  default E capture(V capture) throws IOException {
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return capture((capture == null) ? null : capture.apply(element.getDocument()));
  }

  /**
   * <ul>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input#htmlattrdefcapture">&lt;input&gt;: The Input (Form Input) element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input/file#capture">&lt;input type="file"&gt;</a>.</li>
   * <li>See <a href="https://www.w3.org/TR/html-media-capture/#the-capture-attribute">5. The capture attribute</a>.</li>
   * <li>See <a href="https://www.w3.org/TR/mediacapture-streams/#dom-videofacingmodeenum">Media Capture and Streams: VideoFacingModeEnum</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @since HTML 5
   *
   * @see Capture#capture(java.lang.Enum)
   */
  @SuppressWarnings("overloads")
  default <Ex extends Throwable> E capture(IOSupplierE<V, Ex> capture) throws IOException, Ex {
    return capture((capture == null) ? null : capture.get());
  }
}
