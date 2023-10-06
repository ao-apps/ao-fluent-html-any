/*
 * ao-fluent-html-any - Base abstract classes and interfaces for Fluent Java DSL for high-performance HTML generation.
 * Copyright (C) 2022, 2023  AO Industries, Inc.
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

package com.aoapps.html.any.attributes.text;

import static com.aoapps.encoding.TextInXhtmlAttributeEncoder.textInXhtmlAttributeEncoder;

import com.aoapps.encoding.TextWritable;
import com.aoapps.hodgepodge.i18n.MarkupType;
import com.aoapps.html.any.Attributes;
import com.aoapps.html.any.Element;
import com.aoapps.lang.Coercion;
import com.aoapps.lang.io.function.IOSupplierE;
import java.io.IOException;

/**
 * <ul>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/form-control-infrastructure.html#submitting-element-directionality:-the-dirname-attribute">4.10.18.2 Submitting element directionality: the dirname attribute</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input#attr-dirname">&lt;input&gt;: The Input (Form Input) element</a>.</li>
 * <li>See <a href="https://www.w3schools.com/tags/att_dirname.asp">HTML dirname Attribute</a>.</li>
 * </ul>
 *
 * @param  <E>   This element type
 *
 * @author  AO Industries, Inc.
 */
public interface Dirname<E extends Element<?, ?, E> & Dirname<E>> {

  /**
   * <p>
   * Utility class for working with {@link Dirname}.
   * </p>
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/form-control-infrastructure.html#submitting-element-directionality:-the-dirname-attribute">4.10.18.2 Submitting element directionality: the dirname attribute</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input#attr-dirname">&lt;input&gt;: The Input (Form Input) element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/att_dirname.asp">HTML dirname Attribute</a>.</li>
   * </ul>
   */
  public static final class dirname {
    /** Make no instances. */
    private dirname() {
      throw new AssertionError();
    }

    /**
     * Normalizes a dirname attribute.
     *
     * @see  Coercion#nullIfEmpty(java.lang.Object)
     */
    // Note: Delegates to Name.name.normalize
    public static Object normalize(Object dirname) {
      return Name.name.normalize(dirname);
    }
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/form-control-infrastructure.html#submitting-element-directionality:-the-dirname-attribute">4.10.18.2 Submitting element directionality: the dirname attribute</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input#attr-dirname">&lt;input&gt;: The Input (Form Input) element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/att_dirname.asp">HTML dirname Attribute</a>.</li>
   * </ul>
   */
  @Attributes.Funnel
  default E dirname(Object dirname) throws IOException {
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return Attributes.Text.attribute(element, "dirname", MarkupType.NONE, dirname, Dirname.dirname::normalize,
        textInXhtmlAttributeEncoder);
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/form-control-infrastructure.html#submitting-element-directionality:-the-dirname-attribute">4.10.18.2 Submitting element directionality: the dirname attribute</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input#attr-dirname">&lt;input&gt;: The Input (Form Input) element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/att_dirname.asp">HTML dirname Attribute</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @see #dirname(java.lang.Object)
   */
  default <Ex extends Throwable> E dirname(IOSupplierE<?, Ex> dirname) throws IOException, Ex {
    return dirname((dirname == null) ? null : dirname.get());
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/form-control-infrastructure.html#submitting-element-directionality:-the-dirname-attribute">4.10.18.2 Submitting element directionality: the dirname attribute</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input#attr-dirname">&lt;input&gt;: The Input (Form Input) element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/att_dirname.asp">HTML dirname Attribute</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @see #dirname(java.lang.Object)
   */
  default <Ex extends Throwable> E dirname(TextWritable<Ex> dirname) throws IOException, Ex {
    return dirname((Object) dirname);
  }
}
