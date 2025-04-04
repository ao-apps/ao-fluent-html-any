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

import static com.aoapps.html.any.Attributes.RESOURCES;

import com.aoapps.hodgepodge.i18n.MarkupType;
import com.aoapps.html.any.AnyDocument;
import com.aoapps.html.any.Attributes;
import com.aoapps.html.any.Element;
import com.aoapps.html.any.GlobalAttributes;
import com.aoapps.html.any.Suppliers;
import com.aoapps.lang.Strings;
import com.aoapps.lang.io.function.IOSupplierE;
import com.aoapps.lang.validation.InvalidResult;
import com.aoapps.lang.validation.ValidResult;
import com.aoapps.lang.validation.ValidationResult;
import java.io.IOException;
import java.util.Locale;
import java.util.function.Function;

/**
 * <ul>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#the-dir-attribute">3.2.6.4 The dir attribute</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/dir">Global attributes / dir</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/dir">HTMLElement.dir</a>.</li>
 * <li>See <a href="https://www.w3schools.com/tags/att_global_dir.asp">HTML dir Attribute</a>.</li>
 * </ul>
 *
 * <p>Note: Enum type cannot be parameterized because this is a {@linkplain GlobalAttributes global attribute}.</p>
 *
 * @param  <E>   This element type
 *
 * @author  AO Industries, Inc.
 */
// Matches DirUnexpected
public interface Dir<E extends Element<?, ?, E> & Dir<E>> {

  /**
   * Utility class for working with {@link Dir}.
   *
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#the-dir-attribute">3.2.6.4 The dir attribute</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/dir">Global attributes / dir</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/dir">HTMLElement.dir</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/att_global_dir.asp">HTML dir Attribute</a>.</li>
   * </ul>
   */
  public static final class dir {

    /** Make no instances. */
    private dir() {
      throw new AssertionError();
    }

    /**
     * Normalizes a dir attribute.
     *
     * @see  Strings#trimNullIfEmpty(java.lang.String)
     * @see  java.lang.String#toLowerCase(java.util.Locale)
     * @see  Locale#ROOT
     */
    public static String normalize(String dir) {
      dir = Strings.trimNullIfEmpty(dir);
      if (dir != null) {
        dir = dir.toLowerCase(Locale.ROOT);
      }
      return dir;
    }

    /**
     * Validates a dir attribute.
     * The value should already be {@linkplain #normalize(java.lang.String) normalized}.
     *
     * @see #normalize(java.lang.String)
     */
    public static ValidationResult validate(String dir) {
      if (
          dir != null
              && Dir.Value.getByValue(dir) == null
      ) {
        return new InvalidResult(
            RESOURCES,
            "Enum.Dir.invalid",
            dir
        );
      } else {
        return ValidResult.getInstance();
      }
    }
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#the-dir-attribute">3.2.6.4 The dir attribute</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/dir">Global attributes / dir</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/dir">HTMLElement.dir</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/att_global_dir.asp">HTML dir Attribute</a>.</li>
   * </ul>
   */
  @Attributes.Funnel
  default E dir(String dir) throws IOException {
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return Attributes.String.attribute(
        element,
        "dir",
        MarkupType.NONE,
        dir,
        Dir.dir::normalize,
        Dir.dir::validate
    );
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#the-dir-attribute">3.2.6.4 The dir attribute</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/dir">Global attributes / dir</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/dir">HTMLElement.dir</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/att_global_dir.asp">HTML dir Attribute</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @see #dir(java.lang.String)
   */
  @SuppressWarnings("overloads")
  default <Ex extends Throwable> E dir(Suppliers.String<Ex> dir) throws IOException, Ex {
    return dir((dir == null) ? null : dir.get());
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#the-dir-attribute">3.2.6.4 The dir attribute</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/dir">Global attributes / dir</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/dir">HTMLElement.dir</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/att_global_dir.asp">HTML dir Attribute</a>.</li>
   * </ul>
   *
   * @see #dir(java.lang.String)
   */
  default E dir(Value dir) throws IOException {
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return dir((dir == null) ? null : dir.apply(element.getDocument()));
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#the-dir-attribute">3.2.6.4 The dir attribute</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/dir">Global attributes / dir</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/dir">HTMLElement.dir</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/att_global_dir.asp">HTML dir Attribute</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @see #dir(com.aoapps.html.any.attributes.enumeration.Dir.Value)
   */
  @SuppressWarnings("overloads")
  default <Ex extends Throwable> E dir(IOSupplierE<Value, Ex> dir) throws IOException, Ex {
    return dir((dir == null) ? null : dir.get());
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#the-dir-attribute">3.2.6.4 The dir attribute</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/dir">Global attributes / dir</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/dir">HTMLElement.dir</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/att_global_dir.asp">HTML dir Attribute</a>.</li>
   * </ul>
   */
  public enum Value implements Function<AnyDocument<?>, String> {
    LTR("ltr"),
    RTL("rtl"),
    AUTO("auto");

    private final String value;

    private Value(String value) {
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

    public String getValue() {
      return value;
    }

    private static final Value[] values = values();

    /**
     * Gets the enum by value, case-sensitive.
     *
     * @return  The enum or {@code null} when not found.
     */
    public static Value getByValue(String dir) {
      if (dir != null) {
        for (Value value : values) {
          if (value.value.equals(dir)) {
            return value;
          }
        }
      }
      return null;
    }
  }
}
