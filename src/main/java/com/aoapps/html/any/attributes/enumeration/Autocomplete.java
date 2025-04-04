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

import static com.aoapps.encoding.TextInXhtmlAttributeEncoder.encodeTextInXhtmlAttribute;

import com.aoapps.hodgepodge.i18n.MarkupType;
import com.aoapps.html.any.AnyDocument;
import com.aoapps.html.any.Attributes;
import com.aoapps.html.any.Element;
import com.aoapps.html.any.Suppliers;
import com.aoapps.lang.Strings;
import com.aoapps.lang.io.function.IOSupplierE;
import java.io.IOException;
import java.io.Writer;
import java.util.function.Function;

/**
 * <ul>
 * <li>See <a href="https://www.w3schools.com/tags/att_autocomplete.asp">HTML autocomplete Attribute</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input#htmlattrdefautocomplete">&lt;input&gt;: The Input (Form Input) element</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Attributes/autocomplete">The HTML autocomplete attribute</a>.</li>
 * </ul>
 *
 * @param  <E>   This element type
 * @param  <V>   This enum type to use for this attribute
 *
 * @since HTML 5
 *
 * @author  AO Industries, Inc.
 */
public interface Autocomplete<
    E extends Element<?, ?, E> & Autocomplete<E, V>,
    V extends Enum<V> & Function<? super AnyDocument<?>, String>
    > {

  /**
   * Utility class for working with {@link Autocomplete}.
   *
   * <ul>
   * <li>See <a href="https://www.w3schools.com/tags/att_autocomplete.asp">HTML autocomplete Attribute</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input#htmlattrdefautocomplete">&lt;input&gt;: The Input (Form Input) element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Attributes/autocomplete">The HTML autocomplete attribute</a>.</li>
   * </ul>
   *
   * @since HTML 5
   */
  public static final class autocomplete {
    /** Make no instances. */
    private autocomplete() {
      throw new AssertionError();
    }

    /**
     * Normalizes an autocomplete attribute.
     *
     * @see  Strings#trimNullIfEmpty(java.lang.String)
     */
    public static String normalize(String autocomplete) {
      return Strings.trimNullIfEmpty(autocomplete);
    }
  }

  /**
   * <ul>
   * <li>See <a href="https://www.w3schools.com/tags/att_autocomplete.asp">HTML autocomplete Attribute</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input#htmlattrdefautocomplete">&lt;input&gt;: The Input (Form Input) element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Attributes/autocomplete">The HTML autocomplete attribute</a>.</li>
   * </ul>
   *
   * @since HTML 5
   */
  @Attributes.Funnel
  default E autocomplete(String autocomplete) throws IOException {
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return Attributes.String.attribute(element, "autocomplete", MarkupType.NONE, autocomplete,
        Autocomplete.autocomplete::normalize, value -> Attributes.validateInHtml5(element, "autocomplete"));
  }

  /**
   * <ul>
   * <li>See <a href="https://www.w3schools.com/tags/att_autocomplete.asp">HTML autocomplete Attribute</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input#htmlattrdefautocomplete">&lt;input&gt;: The Input (Form Input) element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Attributes/autocomplete">The HTML autocomplete attribute</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @since HTML 5
   *
   * @see #autocomplete(java.lang.String)
   */
  @SuppressWarnings("overloads")
  default <Ex extends Throwable> E autocomplete(Suppliers.String<Ex> autocomplete) throws IOException, Ex {
    return autocomplete((autocomplete == null) ? null : autocomplete.get());
  }

  /**
   * <ul>
   * <li>See <a href="https://www.w3schools.com/tags/att_autocomplete.asp">HTML autocomplete Attribute</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input#htmlattrdefautocomplete">&lt;input&gt;: The Input (Form Input) element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Attributes/autocomplete">The HTML autocomplete attribute</a>.</li>
   * </ul>
   *
   * @since HTML 5
   *
   * @see #autocomplete(java.lang.String)
   */
  default E autocomplete(V autocomplete) throws IOException {
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return autocomplete((autocomplete == null) ? null : autocomplete.apply(element.getDocument()));
  }

  /**
   * <ul>
   * <li>See <a href="https://www.w3schools.com/tags/att_autocomplete.asp">HTML autocomplete Attribute</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input#htmlattrdefautocomplete">&lt;input&gt;: The Input (Form Input) element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Attributes/autocomplete">The HTML autocomplete attribute</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @since HTML 5
   *
   * @see #autocomplete(java.lang.Enum)
   */
  @SuppressWarnings("overloads")
  default <Ex extends Throwable> E autocomplete(IOSupplierE<V, Ex> autocomplete) throws IOException, Ex {
    return autocomplete((autocomplete == null) ? null : autocomplete.get());
  }

  /**
   * <ul>
   * <li>See <a href="https://www.w3schools.com/tags/att_autocomplete.asp">HTML autocomplete Attribute</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input#htmlattrdefautocomplete">&lt;input&gt;: The Input (Form Input) element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Attributes/autocomplete">The HTML autocomplete attribute</a>.</li>
   * </ul>
   *
   * @since HTML 5
   */
  @Attributes.Funnel
  default E autocomplete(String ... autocomplete) throws IOException {
    @SuppressWarnings("unchecked")
    E element = (E) this;
    AnyDocument<?> document = element.getDocument();
    Attributes.onlySupportedInHtml5(document, "autocomplete");
    if (autocomplete != null) {
      @SuppressWarnings("deprecation")
      Writer unsafe = document.getRawUnsafe(null);
      boolean didOne = false;
      for (String value : autocomplete) {
        String trimmed = Strings.trimNullIfEmpty(value);
        if (trimmed != null) {
          if (!didOne) {
            if (document.getAtnl()) {
              // Can't access: document.autoIndent(unsafe, 1);
              document.autoIndent(1);
              unsafe.write("autocomplete=\"");
              document.clearAtnl();
            } else {
              unsafe.write(" autocomplete=\"");
            }
            didOne = true;
          } else {
            unsafe.append(' ');
          }
          encodeTextInXhtmlAttribute(trimmed, unsafe);
        }
      }
      if (didOne) {
        unsafe.append('"');
      }
    }
    return element;
  }

  // TODO: More variants for suppliers of arrays, arrays of suppliers, iterables, ...?

  /**
   * <ul>
   * <li>See <a href="https://www.w3schools.com/tags/att_autocomplete.asp">HTML autocomplete Attribute</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input#htmlattrdefautocomplete">&lt;input&gt;: The Input (Form Input) element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Attributes/autocomplete">The HTML autocomplete attribute</a>.</li>
   * </ul>
   *
   * @since HTML 5
   */
  @Attributes.Funnel
  @SuppressWarnings({"unchecked", "deprecation"}) // generic varargs
  default E autocomplete(V ... autocomplete) throws IOException {
    @SuppressWarnings("unchecked")
    E element = (E) this;
    AnyDocument<?> document = element.getDocument();
    Attributes.onlySupportedInHtml5(document, "autocomplete");
    if (autocomplete != null) {
      Writer unsafe = document.getRawUnsafe(null);
      boolean didOne = false;
      for (V value : autocomplete) {
        if (value != null) {
          if (!didOne) {
            if (document.getAtnl()) {
              // Can't access: document.autoIndent(unsafe, 1);
              document.autoIndent(1);
              unsafe.write("autocomplete=\"");
              document.clearAtnl();
            } else {
              unsafe.write(" autocomplete=\"");
            }
            didOne = true;
          } else {
            unsafe.append(' ');
          }
          encodeTextInXhtmlAttribute(value.apply(document), unsafe);
        }
      }
      if (didOne) {
        unsafe.append('"');
      }
    }
    return element;
  }

  // TODO: More variants for suppliers of arrays, arrays of suppliers, iterables, ...?
}
