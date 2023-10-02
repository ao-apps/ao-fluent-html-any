/*
 * ao-fluent-html-any - Base abstract classes and interfaces for Fluent Java DSL for high-performance HTML generation.
 * Copyright (C) 2019, 2020, 2021, 2022, 2023  AO Industries, Inc.
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
import static com.aoapps.html.any.Attributes.RESOURCES;
import static com.aoapps.html.any.Attributes.validate;

import com.aoapps.encoding.TextWritable;
import com.aoapps.hodgepodge.i18n.MarkupType;
import com.aoapps.html.any.Attributes;
import com.aoapps.html.any.Element;
import com.aoapps.lang.LocalizedIllegalArgumentException;
import com.aoapps.lang.function.FunctionE;
import com.aoapps.lang.io.function.IOSupplierE;
import com.aoapps.lang.validation.InvalidResult;
import com.aoapps.lang.validation.ValidResult;
import com.aoapps.lang.validation.ValidationResult;
import com.aoapps.lang.xml.XmlUtils;
import java.io.IOException;

/**
 * <ul>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#embedding-custom-non-visible-data-with-the-data-%2A-attributes">3.2.6.6 Embedding custom non-visible data with the data-* attributes</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/data-%2A">Global attributes / data-*</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/dataset">HTMLElement.dataset</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Learn/HTML/Howto/Use_data_attributes">Using data attributes - Learn web development | MDN</a>.</li>
 * <li>See <a href="https://www.w3schools.com/tags/att_global_data.asp">HTML data-* Attributes</a>.</li>
 * </ul>
 *
 * @param  <E>   This element type
 *
 * @since HTML 5
 *
 * @author  AO Industries, Inc.
 */
public interface Data<E extends Element<?, ?, E> & Data<E>> {

  /**
   * <p>
   * Utility class for working with {@link Data} as data-* HTML attributes.
   * </p>
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#embedding-custom-non-visible-data-with-the-data-%2A-attributes">3.2.6.6 Embedding custom non-visible data with the data-* attributes</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/data-%2A">Global attributes / data-*</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/dataset">HTMLElement.dataset</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Learn/HTML/Howto/Use_data_attributes">Using data attributes - Learn web development | MDN</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/att_global_data.asp">HTML data-* Attributes</a>.</li>
   * </ul>
   *
   * @since HTML 5
   */
  public static final class data {

    /** Make no instances. */
    private data() {
      throw new AssertionError();
    }

    /**
     * The required prefix for data-* HTML attributes.
     */
    public static final String ATTRIBUTE_PREFIX = "data-";

    /**
     * <p>
     * Validates a data-* HTML attribute name.
     * </p>
     * <ul>
     * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/data-%2A">Global attributes / data-*</a>.</li>
     * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/HTMLOrForeignElement/dataset">HTMLOrForeignElement.dataset - Web APIs | MDN</a>.</li>
     * <li>See <a href="https://www.w3.org/TR/REC-xml/#NT-Name">Name - Extensible Markup Language (XML) 1.0</a>.</li>
     * </ul>
     */
    public static ValidationResult validate(String attrName) {
      if (attrName == null) {
        return new InvalidResult(RESOURCES, "Text.Data.data.validate.isNull");
      }
      if (!attrName.startsWith(ATTRIBUTE_PREFIX)) {
        return new InvalidResult(
            RESOURCES,
            "Text.Data.data.validate.invalidStart",
            ATTRIBUTE_PREFIX,
            attrName
        );
      }
      int len = attrName.length();
      int pos = ATTRIBUTE_PREFIX.length();
      // The * may be replaced by any name following the production rule of XML names:
      if (!XmlUtils.isValidName(attrName, pos, len)) {
        return new InvalidResult(
            RESOURCES,
            "Text.Data.data.validate.notFollowedByValidName",
            ATTRIBUTE_PREFIX,
            attrName
        );
      }
      // the name must not contain any semicolon (U+003A):
      // Nothing to do, semicolon is already not a valid XML Name

      // but NOT any ASCII capital letters (A to Z):
      while (pos < len) {
        char ch = attrName.charAt(pos++);
        if (ch >= 'A' && ch <= 'Z') {
          return new InvalidResult(
              RESOURCES,
              "Text.Data.data.validate.mayNotContainCapitalLetters",
              attrName
          );
        }
      }
      // the name must not start with xml, whatever case is used for these letters:
      if (attrName.regionMatches(ATTRIBUTE_PREFIX.length(), "xml", 0, 3)) {
        return new InvalidResult(
            RESOURCES,
            "Text.Data.data.validate.mayNotStartXml",
            ATTRIBUTE_PREFIX,
            attrName
        );
      }
      return ValidResult.getInstance();
    }

    /**
     * <p>
     * Converts a data-* HTML attribute name to a JavaScript dataset property name.
     * </p>
     * <p>
     * This method is the simplest conversion implementation and does not
     * perform full validation.
     * </p>
     * <ul>
     * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/HTMLOrForeignElement/dataset">HTMLOrForeignElement.dataset - Web APIs | MDN</a>.</li>
     * </ul>
     *
     * @see  #validate(java.lang.String)
     */
    public static String toJsName(String attrName) {
      String jsName = toJsNameNoAssert(attrName);
      assert attrName.equals(dataset.toAttrNameNoAssert(jsName)) : "toJsName and toAttrName are inverse functions";
      return jsName;
    }

    /**
     * Implementation of {@link #toJsName(java.lang.String)} without assertions.
     * Used to avoid infinite recursion when assertions are enabled.
     */
    private static String toJsNameNoAssert(String attrName) {
      if (!attrName.startsWith(ATTRIBUTE_PREFIX)) {
        throw new LocalizedIllegalArgumentException(
            RESOURCES,
            "Text.Data.data.validate.invalidStart",
            ATTRIBUTE_PREFIX,
            attrName
        );
      }
      int len = attrName.length();
      // 1. The prefix data- is removed (including the dash)
      int pos = ATTRIBUTE_PREFIX.length();
      StringBuilder jsName = new StringBuilder(len - pos);
      while (pos < len) {
        char ch = attrName.charAt(pos++);
        if (ch == '-' && pos < len) {
          // 2. For any dash (U+002D) followed by an ASCII lowercase letter a to z,
          //    the dash is removed, and the letter is transformed into its uppercase counterpart
          char ch2 = attrName.charAt(pos);
          if (ch2 >= 'a' && ch2 <= 'z') {
            ch = (char) (ch2 - ('a' - 'A'));
            pos++;
          }
        }
        // 3. Other characters (including other dashes) are left unchanged
        jsName.append(ch);
      }
      return jsName.toString();
    }
  }

  /**
   * <p>
   * Data provided by HTML attribute name.  Name must begin with {@link data#ATTRIBUTE_PREFIX}, and must
   * conform to the rules defined in HTML.
   * </p>
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#embedding-custom-non-visible-data-with-the-data-%2A-attributes">3.2.6.6 Embedding custom non-visible data with the data-* attributes</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/data-%2A">Global attributes / data-*</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/dataset">HTMLElement.dataset</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Learn/HTML/Howto/Use_data_attributes">Using data attributes - Learn web development | MDN</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/att_global_data.asp">HTML data-* Attributes</a>.</li>
   * </ul>
   *
   * @since HTML 5
   */
  @Attributes.Funnel
  default E data(String attrName, Object value) throws IOException {
    @SuppressWarnings("unchecked")
    E element = (E) this;
    validate(attrName, data::validate);
    return Attributes.Text.attribute(
        element,
        attrName,
        MarkupType.NONE,
        value,
        FunctionE.identity(),
        v -> Attributes.validateInHtml5(element, attrName),
        textInXhtmlAttributeEncoder
    );
  }

  /**
   * <p>
   * Data provided by HTML attribute name.  Name must begin with {@link data#ATTRIBUTE_PREFIX}, and must
   * conform to the rules defined in HTML.
   * </p>
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#embedding-custom-non-visible-data-with-the-data-%2A-attributes">3.2.6.6 Embedding custom non-visible data with the data-* attributes</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/data-%2A">Global attributes / data-*</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/dataset">HTMLElement.dataset</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Learn/HTML/Howto/Use_data_attributes">Using data attributes - Learn web development | MDN</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/att_global_data.asp">HTML data-* Attributes</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @since HTML 5
   */
  default <Ex extends Throwable> E data(String attrName, IOSupplierE<?, Ex> value) throws IOException, Ex {
    return data(attrName, (value == null) ? null : value.get());
  }

  /**
   * <p>
   * Data provided by HTML attribute name.  Name must begin with {@link data#ATTRIBUTE_PREFIX}, and must
   * conform to the rules defined in HTML.
   * </p>
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#embedding-custom-non-visible-data-with-the-data-%2A-attributes">3.2.6.6 Embedding custom non-visible data with the data-* attributes</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/data-%2A">Global attributes / data-*</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/dataset">HTMLElement.dataset</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Learn/HTML/Howto/Use_data_attributes">Using data attributes - Learn web development | MDN</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/att_global_data.asp">HTML data-* Attributes</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @since HTML 5
   */
  default <Ex extends Throwable> E data(String attrName, TextWritable<Ex> value) throws IOException, Ex {
    return data(attrName, (Object) value);
  }

  /**
   * <p>
   * Utility class for working with {@link Data} as JavaScript dataset property.
   * </p>
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#embedding-custom-non-visible-data-with-the-data-%2A-attributes">3.2.6.6 Embedding custom non-visible data with the data-* attributes</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/data-%2A">Global attributes / data-*</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/dataset">HTMLElement.dataset</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Learn/HTML/Howto/Use_data_attributes">Using data attributes - Learn web development | MDN</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/att_global_data.asp">HTML data-* Attributes</a>.</li>
   * </ul>
   *
   * @since HTML 5
   */
  public static final class dataset {

    /** Make no instances. */
    private dataset() {
      throw new AssertionError();
    }

    /**
     * <p>
     * Validates a JavaScript dataset property name.
     * </p>
     * <ul>
     * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/HTMLOrForeignElement/dataset">HTMLOrForeignElement.dataset - Web APIs | MDN</a>.</li>
     * </ul>
     */
    public static ValidationResult validate(String jsName) {
      if (jsName == null) {
        return new InvalidResult(RESOURCES, "Text.Data.dataset.validate.isNull");
      }
      // 1. Restriction: Before the transformation, a dash must not be immediately followed by
      //    an ASCII lowercase letter a to z
      int len = jsName.length();
      int pos = 0;
      while (pos < len) {
        pos = jsName.indexOf('-', pos) + 1;
        if (
            // Not found
            pos == 0
                // Found at end
                || pos >= len
        ) {
          break;
        }
        char nextChar = jsName.charAt(pos);
        if (nextChar >= 'a' && nextChar <= 'z') {
          return new InvalidResult(
              RESOURCES,
              "Text.Data.dataset.validate.dashThenLower",
              jsName
          );
        }
      }
      // Must also convert into a valid data-* HTML attribute name
      return data.validate(toAttrName(jsName));
    }

    /**
     * <p>
     * Converts a JavaScript dataset property name to a data-* HTML attribute name.
     * </p>
     * <p>
     * This method is the simplest conversion implementation and does not
     * perform full validation.
     * </p>
     * <ul>
     * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/HTMLOrForeignElement/dataset">HTMLOrForeignElement.dataset - Web APIs | MDN</a>.</li>
     * </ul>
     *
     * @see  #validate(java.lang.String)
     */
    public static String toAttrName(String jsName) {
      String attrName = toAttrNameNoAssert(jsName);
      assert jsName.equals(data.toJsNameNoAssert(attrName)) : "toAttrName and toJsName are inverse functions";
      return attrName;
    }

    /**
     * Implementation of {@link #toAttrName(java.lang.String)} without assertions.
     * Used to avoid infinite recursion when assertions are enabled.
     */
    private static String toAttrNameNoAssert(String jsName) {
      int len = jsName.length();
      StringBuilder attrName = new StringBuilder(
          // room for "data-"
          data.ATTRIBUTE_PREFIX.length()
              // and room for the JavaScript property name
              + len
              // and some space for some added dashes from conversion
              // 10 is arbitrary, but bigger than the number of typical camelCase sections
              + 10
      );
      // 2. The prefix data- is added
      attrName.append(data.ATTRIBUTE_PREFIX);
      int pos = 0;
      while (pos < len) {
        char ch = attrName.charAt(pos++);
        if (ch >= 'A' && ch <= 'Z') {
          // 3. Any ASCII uppercase letter A to Z is transformed into a dash,
          //    followed by its lowercase counterpart
          attrName.append('-');
          ch += 'a' - 'A';
        }
        // 4. Other characters are left unchanged
        attrName.append(ch);
      }
      return attrName.toString();
    }
  }

  /**
   * <p>
   * Data provided by JavaScript dataset property name.
   * </p>
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#embedding-custom-non-visible-data-with-the-data-%2A-attributes">3.2.6.6 Embedding custom non-visible data with the data-* attributes</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/data-%2A">Global attributes / data-*</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/dataset">HTMLElement.dataset</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Learn/HTML/Howto/Use_data_attributes">Using data attributes - Learn web development | MDN</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/att_global_data.asp">HTML data-* Attributes</a>.</li>
   * </ul>
   *
   * @since HTML 5
   */
  default E dataset(String jsName, Object value) throws IOException {
    return data(
        dataset.toAttrName(
            validate(jsName, dataset::validate)
        ),
        value
    );
  }

  /**
   * <p>
   * Data provided by JavaScript dataset property name.
   * </p>
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#embedding-custom-non-visible-data-with-the-data-%2A-attributes">3.2.6.6 Embedding custom non-visible data with the data-* attributes</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/data-%2A">Global attributes / data-*</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/dataset">HTMLElement.dataset</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Learn/HTML/Howto/Use_data_attributes">Using data attributes - Learn web development | MDN</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/att_global_data.asp">HTML data-* Attributes</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @since HTML 5
   */
  default <Ex extends Throwable> E dataset(String jsName, IOSupplierE<?, Ex> value) throws IOException, Ex {
    return dataset(jsName, (value == null) ? null : value.get());
  }

  /**
   * <p>
   * Data provided by JavaScript dataset property name.
   * </p>
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#embedding-custom-non-visible-data-with-the-data-%2A-attributes">3.2.6.6 Embedding custom non-visible data with the data-* attributes</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/data-%2A">Global attributes / data-*</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/dataset">HTMLElement.dataset</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Learn/HTML/Howto/Use_data_attributes">Using data attributes - Learn web development | MDN</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/att_global_data.asp">HTML data-* Attributes</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @since HTML 5
   */
  default <Ex extends Throwable> E dataset(String jsName, TextWritable<Ex> value) throws IOException, Ex {
    return dataset(jsName, (Object) value);
  }
}
