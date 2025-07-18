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

import com.aoapps.collections.AoCollections;
import com.aoapps.encoding.Doctype;
import com.aoapps.hodgepodge.i18n.MarkupType;
import com.aoapps.lang.LocalizedIllegalStateException;
import com.aoapps.lang.LocalizedUnsupportedOperationException;
import com.aoapps.lang.Strings;
import com.aoapps.lang.function.FunctionE;
import com.aoapps.lang.io.LocalizedUnsupportedEncodingException;
import java.io.IOException;
import java.io.Writer;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.function.Function;

/**
 * This has the set of attributes common to all input types.  There are also
 * type-specific subclasses that add type-specific attributes.  Furthermore,
 * there is a {@link AnyINPUT.Dynamic} implementation that has all the input attributes,
 * supporting unanticipated or more dynamic configurations.
 *
 * <ul>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/input.html#the-input-element">4.10.5 The input element</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input">&lt;input&gt;: The Input (Form Input) element</a>.</li>
 * <li>See <a href="https://www.w3schools.com/tags/tag_input.asp">HTML input tag</a>.</li>
 * </ul>
 *
 * @param  <D>   This document type
 * @param  <PC>  The parent content model this element is within
 * @param  <E>   This element type
 *
 * @author  AO Industries, Inc.
 */
public abstract class AnyINPUT<
    D  extends AnyDocument<D>,
    PC extends AnyUnion_Interactive_Phrasing<D, PC>,
    E  extends AnyINPUT<D, PC, E>
    >
    extends Void<D, PC, E> implements
    com.aoapps.html.any.attributes.bool.Disabled<E>,
    com.aoapps.html.any.attributes.text.Form<E>,
    // TODO: inputmode here or global?
    // TODO: list
    // TODO: max
    // TODO: min
    com.aoapps.html.any.attributes.text.Name<E>,
    // TODO: pattern
    // TODO: step
    // Global Attributes overrides
    com.aoapps.html.any.attributes.integer.TabindexHtml4<E> {

  private static final com.aoapps.lang.i18n.Resources RESOURCES =
      com.aoapps.lang.i18n.Resources.getResources(ResourceBundle::getBundle, AnyINPUT.class);

  private static void typeOnlySupportedInHtml5(AnyDocument<?> document, Dynamic.Type type) throws UnsupportedOperationException {
    assert type.getRequiredDoctype() == Doctype.HTML5;
    Doctype doctype = document.encodingContext.getDoctype();
    if (doctype != Doctype.HTML5) {
      throw new LocalizedUnsupportedOperationException(
          RESOURCES,
          "typeOnlySupportedInHtml5",
          doctype,
          type.getValue()
      );
    }
  }

  protected AnyINPUT(D document, PC pc) {
    super(document, pc);
  }

  @Override
  protected void writeOpen(Writer unsafe) throws IOException {
    document.autoIndent(unsafe).unsafe(unsafe, "<input", false);
    openWriteType(unsafe);
  }

  protected abstract void openWriteType(Writer unsafe) throws IOException;

  /**
   * The complete list of expected autocomplete values.  Specific input types may provide
   * a shorter list.
   *
   * <p>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Attributes/autocomplete">The HTML autocomplete attribute</a>.</p>
   *
   * @since HTML 5
   */
  public enum Autocomplete implements Function<AnyDocument<?>, String> {
    OFF("off"),
    ON("on"),
    NAME("name"),
    HONORIFIC_PREFIX("honorific-prefix"),
    GIVEN_NAME("given-name"),
    ADDITIONAL_NAME("additional-name"),
    FAMILY_NAME("family-name"),
    HONORIFIC_SUFFIX("honorific-suffix"),
    NICKNAME("nickname"),
    EMAIL("email"),
    USERNAME("username"),
    NEW_PASSWORD("new-password"),
    CURRENT_PASSWORD("current-password"),
    ONE_TIME_CODE("one-time-code"),
    ORGANIZATION_TITLE("organization-title"),
    ORGANIZATION("organization"),
    STREET_ADDRESS("street-address"),
    ADDRESS_LINE1("address-line1"),
    ADDRESS_LINE2("address-line2"),
    ADDRESS_LINE3("address-line3"),
    ADDRESS_LEVEL4("address-level4"),
    ADDRESS_LEVEL3("address-level3"),
    ADDRESS_LEVEL2("address-level2"),
    ADDRESS_LEVEL1("address-level1"),
    COUNTRY("country"),
    COUNTRY_NAME("country-name"),
    POSTAL_CODE("postal-code"),
    CC_NAME("cc-name"),
    CC_GIVEN_NAME("cc-given-name"),
    CC_ADDITIONAL_NAME("cc-additional-name"),
    CC_FAMILY_NAME("cc-family-name"),
    CC_NUMBER("cc-number"),
    CC_EXP("cc-exp"),
    CC_EXP_MONTH("cc-exp-month"),
    CC_EXP_YEAR("cc-exp-year"),
    CC_CSC("cc-csc"),
    CC_TYPE("cc-type"),
    TRANSACTION_CURRENCY("transaction-currency"),
    TRANSACTION_AMOUNT("transaction-amount"),
    LANGUAGE("language"),
    BDAY("bday"),
    BDAY_DAY("bday-day"),
    BDAY_MONTH("bday-month"),
    BDAY_YEAR("bday-year"),
    SEX("sex"),
    TEL("tel"),
    TEL_COUNTRY_CODE("tel-country-code"),
    TEL_NATIONAL("tel-national"),
    TEL_AREA_CODE("tel-area-code"),
    TEL_LOCAL("tel-local"),
    TEL_LOCAL_PREFIX("tel-local-prefix"),
    TEL_LOCAL_SUFFIX("tel-local-suffix"),
    TEL_EXTENSION("tel-extension"),
    IMPP("impp"),
    URL("url"),
    PHOTO("photo");

    private final String value;

    private Autocomplete(String value) {
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
  }

  /**
   * See <a href="https://www.w3schools.com/tags/tag_input.asp">HTML input tag</a>.
   *
   * <p>This implementation has all the input attributes,
   * supporting unanticipated or more dynamic configurations.</p>
   *
   * <p>This does not limit attributes by type, and would allow mismatches where
   * type-specific implementations may constrain the attributes and values.
   * Although there is less validation, doctype-specific checks are expected
   * to remain, such as only allowing type="color" in {@link Doctype#HTML5}.</p>
   *
   * @param  <D>   This document type
   * @param  <PC>  The parent content model this element is within
   * @param  <E>   This element type
   */
  @SuppressWarnings("deprecation")
  public abstract static class Dynamic<
      D  extends AnyDocument<D>,
      PC extends AnyUnion_Interactive_Phrasing<D, PC>,
      E  extends Dynamic<D, PC, E>
      >
      extends AnyINPUT<D, PC, E> implements
      com.aoapps.html.any.attributes.text.Accept<E>,
      com.aoapps.html.any.attributes.enumeration.Align<E, Image.Align>,
      com.aoapps.html.any.attributes.text.Alt<E>,
      com.aoapps.html.any.attributes.enumeration.Autocomplete<E, AnyINPUT.Autocomplete>,
      com.aoapps.html.any.attributes.enumeration.Capture<E, File.Capture>,
      com.aoapps.html.any.attributes.bool.Checked<E>,
      com.aoapps.html.any.attributes.text.Dirname<E>,
      com.aoapps.html.any.attributes.url.Formaction<E>,
      com.aoapps.html.any.attributes.enumeration.Formenctype<E, com.aoapps.html.any.attributes.enumeration.Enctype.Value>,
      com.aoapps.html.any.attributes.enumeration.Formmethod<E, com.aoapps.html.any.attributes.enumeration.Method.Value>,
      com.aoapps.html.any.attributes.bool.Formnovalidate<E>,
      com.aoapps.html.any.attributes.enumeration.Formtarget<E, com.aoapps.html.any.attributes.enumeration.Target.Value>,
      com.aoapps.html.any.attributes.integer.HeightHtml5Only<E>,
      com.aoapps.html.any.attributes.text.List<E>,
      com.aoapps.html.any.attributes.integer.Maxlength<E>,
      com.aoapps.html.any.attributes.integer.Minlength<E>,
      com.aoapps.html.any.attributes.bool.Multiple<E>,
      com.aoapps.html.any.attributes.text.Placeholder<E>,
      com.aoapps.html.any.attributes.bool.Readonly<E>,
      com.aoapps.html.any.attributes.bool.Required<E>,
      com.aoapps.html.any.attributes.integer.Size<E>,
      com.aoapps.html.any.attributes.url.Src<E>,
      com.aoapps.html.any.attributes.enumeration.Type<E, Dynamic.Type>,
      com.aoapps.html.any.attributes.text.Value<E>,
      com.aoapps.html.any.attributes.integer.WidthHtml5Only<E>,
      // Event Attributes
      com.aoapps.html.any.attributes.event.Onsearch<E>,
      // Global Attributes overrides
      com.aoapps.html.any.attributes.enumeration.Autocapitalize<E>,
      // Global Event Attributes overrides
      com.aoapps.html.any.attributes.event.Onabort<E>,
      com.aoapps.html.any.attributes.event.Onchange<E>,
      com.aoapps.html.any.attributes.event.Onerror<E>,
      com.aoapps.html.any.attributes.event.Oninput<E>,
      com.aoapps.html.any.attributes.event.Oninvalid<E>,
      com.aoapps.html.any.attributes.event.Onload<E>,
      com.aoapps.html.any.attributes.event.Onselect<E> {

    private String type;

    protected Dynamic(D document, PC pc) {
      super(document, pc);
      this.type = null;
    }

    protected Dynamic(D document, PC pc, String type) {
      super(document, pc);
      type = Strings.trimNullIfEmpty(type);
      this.type = (type == null) ? null : type.toLowerCase(Locale.ROOT);
    }

    protected Dynamic(D document, PC pc, Type type) {
      super(document, pc);
      this.type = (type == null) ? null : type.getValue();
    }

    @Override
    protected void openWriteType(Writer unsafe) throws IOException {
      assert !document.getAtnl();
      // Write the type now, if already set
      String t = this.type;
      if (t != null) {
        // Unset to avoid duplicate attribute
        this.type = null;
        E i = type(t);
        assert i == this;
      }
    }

    /**
     * See <a href="https://www.w3schools.com/tags/att_input_type.asp">HTML input type Attribute</a>.
     */
    public enum Type implements Function<AnyDocument<?>, String> {
      BUTTON("button") {
        /**
         * {@inheritDoc}
         *
         * @see Button#value(java.lang.Object)
         */
        @Override
        public MarkupType getMarkupType() {
          return MarkupType.TEXT;
        }
      },
      CHECKBOX("checkbox"),
      COLOR("color", Doctype.HTML5),
      DATE("date", Doctype.HTML5),
      DATETIME_LOCAL("datetime-local", Doctype.HTML5),
      EMAIL("email", Doctype.HTML5),
      FILE("file"),
      HIDDEN("hidden"),
      IMAGE("image"),
      MONTH("month", Doctype.HTML5),
      NUMBER("number", Doctype.HTML5),
      PASSWORD("password"),
      RADIO("radio"),
      RANGE("range", Doctype.HTML5),
      RESET("reset") {
        /**
         * {@inheritDoc}
         *
         * @see Reset#value(java.lang.Object)
         */
        @Override
        public MarkupType getMarkupType() {
          return MarkupType.TEXT;
        }
      },
      SEARCH("search", Doctype.HTML5),
      SUBMIT("submit") {
        /**
         * {@inheritDoc}
         *
         * @see Submit#value(java.lang.Object)
         */
        @Override
        public MarkupType getMarkupType() {
          return MarkupType.TEXT;
        }
      },
      TEL("tel", Doctype.HTML5),
      TEXT("text"),
      TIME("time", Doctype.HTML5),
      URL("url", Doctype.HTML5),
      WEEK("week", Doctype.HTML5);

      private final String value;
      private final Doctype requiredDoctype;

      private Type(String value, Doctype requiredDoctype) {
        this.value = value;
        this.requiredDoctype = requiredDoctype;
      }

      private Type(String value) {
        this(value, null);
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

      public Doctype getRequiredDoctype() {
        return requiredDoctype;
      }

      /**
       * Gets the interactive editor markup type or {@code null} to not alter
       * the value.
       */
      public MarkupType getMarkupType() {
        return null;
      }

      private static final Type[] values = values();
      private static final Map<String, Type> byLowerValue = AoCollections.newHashMap(values.length);

      static {
        for (Type type : values) {
          if (!type.value.equals(type.value.toLowerCase(Locale.ROOT))) {
            throw new AssertionError("Values must be lowercase as looked-up later");
          }
          if (!type.value.equals(type.value.trim())) {
            throw new AssertionError("Values must be trimmed as looked-up later");
          }
          byLowerValue.put(type.value, type);
        }
      }
    }

    /**
     * See <a href="https://www.w3schools.com/tags/att_input_type.asp">HTML input type Attribute</a>.
     */
    @Override
    public E type(String type) throws IOException {
      type = Strings.trimNullIfEmpty(type);
      if (type != null) {
        type = type.toLowerCase(Locale.ROOT);
        // Perform doctype checks and optimizations for recognized types
        Type typeEnum = Type.byLowerValue.get(type);
        if (typeEnum != null) {
          return type(typeEnum);
        }
        if (this.type != null) {
          throw new LocalizedIllegalStateException(
            AnyDocument.RESOURCES,
            "duplicateAttribute",
            "input",
            "type",
            this.type,
            type
          );
        }
        this.type = type;
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
     * See <a href="https://www.w3schools.com/tags/att_input_type.asp">HTML input type Attribute</a>.
     */
    @Override
    public E type(Type type) throws IOException {
      if (type != null) {
        if (this.type != null) {
          throw new LocalizedIllegalStateException(
            AnyDocument.RESOURCES,
            "duplicateAttribute",
            "input",
            "type",
            this.type,
            type
          );
        }
        // Perform doctype checks for recognized types
        Doctype requiredDoctype = type.getRequiredDoctype();
        Doctype doctype = document.encodingContext.getDoctype();
        if (requiredDoctype != null && doctype != requiredDoctype) {
          throw new LocalizedUnsupportedEncodingException(
              RESOURCES,
              "typeRequiresDoctype",
              type.value,
              requiredDoctype,
              doctype
          );
        }
        this.type = type.value;
        Writer unsafe = document.getRawUnsafe(null);
        if (document.getAtnl()) {
          document.autoIndent(unsafe, 1);
          unsafe.write("type=\"");
          document.clearAtnl();
        } else {
          unsafe.write(" type=\"");
        }
        unsafe.write(type.value); // No encoding, is a known safe value.  TODO: Assert this above in static initializer?
        unsafe.append('"');
      }
      @SuppressWarnings("unchecked")
      E element = (E) this;
      return element;
    }

    /**
     * See <a href="https://www.w3schools.com/tags/att_input_value.asp">HTML input value Attribute</a>.
     */
    @Override
    public E value(Object value) throws IOException {
      assert this.type == null || this.type.equals(this.type.toLowerCase(Locale.ROOT));
      assert this.type == null || this.type.equals(this.type.trim());
      Type typeEnum = Type.byLowerValue.get(this.type);
      @SuppressWarnings("unchecked")
      E element = (E) this;
      return Attributes.Text.attribute(
        element,
        "value",
        // Allow text markup from translations
        (typeEnum == null) ? null : typeEnum.getMarkupType(),
        value,
        FunctionE.identity(),
        textInXhtmlAttributeEncoder
      );
    }
  }

  /**
   * See <a href="https://www.w3schools.com/tags/att_input_type_button.asp">HTML input type="button"</a>.
   *
   * @param  <D>   This document type
   * @param  <PC>  The parent content model this element is within
   * @param  <E>   This element type
   */
  public abstract static class Button<
      D  extends AnyDocument<D>,
      PC extends AnyUnion_Interactive_Phrasing<D, PC>,
      E  extends Button<D, PC, E>
      >
      extends AnyINPUT<D, PC, E> implements
      com.aoapps.html.any.attributes.text.Value<E>,
      // Global Attributes overrides
      // Is allowed on <button>, so guessing here, too
      com.aoapps.html.any.attributes.enumeration.Autocapitalize<E> {

    protected Button(D document, PC pc) {
      super(document, pc);
    }

    @Override
    protected void openWriteType(Writer unsafe) throws IOException {
      assert !document.getAtnl();
      unsafe.write(" type=\"button\"");
    }

    /**
     * See <a href="https://www.w3schools.com/tags/att_input_value.asp">HTML input value Attribute</a>.
     *
     * @see Dynamic.Type#BUTTON
     */
    @Override
    public E value(Object value) throws IOException {
      @SuppressWarnings("unchecked")
      E element = (E) this;
      return Attributes.Text.attribute(
        element,
        "value",
        // Allow text markup from translations
        Dynamic.Type.BUTTON.getMarkupType(),
        value,
        FunctionE.identity(),
        textInXhtmlAttributeEncoder
      );
    }
  }

  /**
   * See <a href="https://www.w3schools.com/tags/att_input_type_checkbox.asp">HTML input type="checkbox"</a>.
   *
   * @param  <D>   This document type
   * @param  <PC>  The parent content model this element is within
   * @param  <E>   This element type
   */
  public abstract static class Checkbox<
      D  extends AnyDocument<D>,
      PC extends AnyUnion_Interactive_Phrasing<D, PC>,
      E  extends Checkbox<D, PC, E>
      >
      extends AnyINPUT<D, PC, E> implements
      com.aoapps.html.any.attributes.bool.Checked<E>,
      com.aoapps.html.any.attributes.bool.Required<E>,
      com.aoapps.html.any.attributes.text.Value<E>,
      // Global Event Attributes overrides
      com.aoapps.html.any.attributes.event.Onchange<E>,
      com.aoapps.html.any.attributes.event.Oninput<E>,
      com.aoapps.html.any.attributes.event.Oninvalid<E> {

    protected Checkbox(D document, PC pc) {
      super(document, pc);
    }

    @Override
    protected void openWriteType(Writer unsafe) throws IOException {
      assert !document.getAtnl();
      unsafe.write(" type=\"checkbox\"");
    }
  }

  /**
   * See <a href="https://www.w3schools.com/tags/att_input_type_color.asp">HTML input type="color"</a>.
   *
   * @param  <D>   This document type
   * @param  <PC>  The parent content model this element is within
   * @param  <E>   This element type
   *
   * @since HTML 5
   */
  public abstract static class Color<
      D  extends AnyDocument<D>,
      PC extends AnyUnion_Interactive_Phrasing<D, PC>,
      E  extends Color<D, PC, E>
      >
      extends AnyINPUT<D, PC, E> implements
      com.aoapps.html.any.attributes.enumeration.Autocomplete<E, Color.Autocomplete>,
      com.aoapps.html.any.attributes.text.List<E>,
      com.aoapps.html.any.attributes.bool.Readonly<E>, // Guessed
      com.aoapps.html.any.attributes.text.Value<E>,
      // Global Event Attributes overrides
      com.aoapps.html.any.attributes.event.Onchange<E>,
      com.aoapps.html.any.attributes.event.Oninput<E> {

    protected Color(D document, PC pc) {
      super(document, pc);
      typeOnlySupportedInHtml5(document, Dynamic.Type.COLOR);
    }

    /**
     * See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Attributes/autocomplete">The HTML autocomplete attribute</a>.
     *
     * <p>We're making our best guess which values are applicable.
     * This is to give a nice short list in code assist.
     * TODO: Find somewhere this relationship is defined (if there is any).</p>
     *
     * @since HTML 5
     *
     * @see AnyINPUT.Autocomplete
     */
    public enum Autocomplete implements Function<AnyDocument<?>, String> {
      OFF(AnyINPUT.Autocomplete.OFF),
      ON(AnyINPUT.Autocomplete.ON);

      private final AnyINPUT.Autocomplete value;

      private Autocomplete(AnyINPUT.Autocomplete value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value.toString();
      }

      @Override
      public String apply(AnyDocument<?> document) {
        return value.apply(document);
      }

      public AnyINPUT.Autocomplete getValue() {
        return value;
      }

      static {
        for (Autocomplete value : values()) {
          if (!value.name().equals(value.value.name())) {
            throw new AssertionError("Enum name mismatch");
          }
        }
      }
    }

    @Override
    protected void openWriteType(Writer unsafe) throws IOException {
      assert !document.getAtnl();
      unsafe.write(" type=\"color\"");
    }
  }

  /**
   * See <a href="https://www.w3schools.com/tags/att_input_type_date.asp">HTML input type="date"</a>.
   *
   * @param  <D>   This document type
   * @param  <PC>  The parent content model this element is within
   * @param  <E>   This element type
   *
   * @since HTML 5
   */
  public abstract static class Date<
      D  extends AnyDocument<D>,
      PC extends AnyUnion_Interactive_Phrasing<D, PC>,
      E  extends Date<D, PC, E>
      >
      extends AnyINPUT<D, PC, E> implements
      com.aoapps.html.any.attributes.enumeration.Autocomplete<E, Date.Autocomplete>,
      com.aoapps.html.any.attributes.text.List<E>,
      com.aoapps.html.any.attributes.bool.Readonly<E>, // Guessed
      com.aoapps.html.any.attributes.bool.Required<E>,
      com.aoapps.html.any.attributes.text.Value<E>,
      // Global Event Attributes overrides
      com.aoapps.html.any.attributes.event.Onchange<E>,
      com.aoapps.html.any.attributes.event.Oninput<E>,
      com.aoapps.html.any.attributes.event.Oninvalid<E> {

    protected Date(D document, PC pc) {
      super(document, pc);
      typeOnlySupportedInHtml5(document, Dynamic.Type.DATE);
    }

    /**
     * See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Attributes/autocomplete">The HTML autocomplete attribute</a>.
     *
     * <p>We're making our best guess which values are applicable.
     * This is to give a nice short list in code assist.
     * TODO: Find somewhere this relationship is defined (if there is any).</p>
     *
     * @since HTML 5
     *
     * @see AnyINPUT.Autocomplete
     */
    public enum Autocomplete implements Function<AnyDocument<?>, String> {
      OFF(AnyINPUT.Autocomplete.OFF),
      ON(AnyINPUT.Autocomplete.ON),
      CC_EXP(AnyINPUT.Autocomplete.CC_EXP),
      BDAY(AnyINPUT.Autocomplete.BDAY);

      private final AnyINPUT.Autocomplete value;

      private Autocomplete(AnyINPUT.Autocomplete value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value.toString();
      }

      @Override
      public String apply(AnyDocument<?> document) {
        return value.apply(document);
      }

      public AnyINPUT.Autocomplete getValue() {
        return value;
      }

      static {
        for (Autocomplete value : values()) {
          if (!value.name().equals(value.value.name())) {
            throw new AssertionError("Enum name mismatch");
          }
        }
      }
    }

    @Override
    protected void openWriteType(Writer unsafe) throws IOException {
      assert !document.getAtnl();
      unsafe.write(" type=\"date\"");
    }
  }

  /**
   * See <a href="https://www.w3schools.com/tags/att_input_type_datetime-local.asp">HTML input type="datetime-local"</a>.
   *
   * @param  <D>   This document type
   * @param  <PC>  The parent content model this element is within
   * @param  <E>   This element type
   *
   * @since HTML 5
   */
  public abstract static class DatetimeLocal<
      D  extends AnyDocument<D>,
      PC extends AnyUnion_Interactive_Phrasing<D, PC>,
      E  extends DatetimeLocal<D, PC, E>
      >
      extends AnyINPUT<D, PC, E> implements
      com.aoapps.html.any.attributes.enumeration.Autocomplete<E, DatetimeLocal.Autocomplete>,
      com.aoapps.html.any.attributes.text.List<E>,
      com.aoapps.html.any.attributes.bool.Readonly<E>, // Guessed
      com.aoapps.html.any.attributes.bool.Required<E>,
      com.aoapps.html.any.attributes.text.Value<E>,
      // Global Event Attributes overrides
      com.aoapps.html.any.attributes.event.Onchange<E>,
      com.aoapps.html.any.attributes.event.Oninput<E>,
      com.aoapps.html.any.attributes.event.Oninvalid<E> {

    protected DatetimeLocal(D document, PC pc) {
      super(document, pc);
      typeOnlySupportedInHtml5(document, Dynamic.Type.DATETIME_LOCAL);
    }

    /**
     * See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Attributes/autocomplete">The HTML autocomplete attribute</a>.
     *
     * <p>We're making our best guess which values are applicable.
     * This is to give a nice short list in code assist.
     * TODO: Find somewhere this relationship is defined (if there is any).</p>
     *
     * @since HTML 5
     *
     * @see AnyINPUT.Autocomplete
     */
    public enum Autocomplete implements Function<AnyDocument<?>, String> {
      OFF(AnyINPUT.Autocomplete.OFF),
      ON(AnyINPUT.Autocomplete.ON),
      BDAY(AnyINPUT.Autocomplete.BDAY);

      private final AnyINPUT.Autocomplete value;

      private Autocomplete(AnyINPUT.Autocomplete value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value.toString();
      }

      @Override
      public String apply(AnyDocument<?> document) {
        return value.apply(document);
      }

      public AnyINPUT.Autocomplete getValue() {
        return value;
      }

      static {
        for (Autocomplete value : values()) {
          if (!value.name().equals(value.value.name())) {
            throw new AssertionError("Enum name mismatch");
          }
        }
      }
    }

    @Override
    protected void openWriteType(Writer unsafe) throws IOException {
      assert !document.getAtnl();
      unsafe.write(" type=\"datetime-local\"");
    }
  }

  /**
   * See <a href="https://www.w3schools.com/tags/att_input_type_email.asp">HTML input type="email"</a>.
   *
   * @param  <D>   This document type
   * @param  <PC>  The parent content model this element is within
   * @param  <E>   This element type
   *
   * @since HTML 5
   */
  public abstract static class Email<
      D  extends AnyDocument<D>,
      PC extends AnyUnion_Interactive_Phrasing<D, PC>,
      E  extends Email<D, PC, E>
      >
      extends AnyINPUT<D, PC, E> implements
      com.aoapps.html.any.attributes.enumeration.Autocomplete<E, Email.Autocomplete>,
      com.aoapps.html.any.attributes.text.List<E>,
      com.aoapps.html.any.attributes.integer.Maxlength<E>,
      com.aoapps.html.any.attributes.integer.Minlength<E>,
      com.aoapps.html.any.attributes.bool.Multiple<E>,
      com.aoapps.html.any.attributes.text.Placeholder<E>,
      com.aoapps.html.any.attributes.bool.Readonly<E>,
      com.aoapps.html.any.attributes.bool.Required<E>,
      com.aoapps.html.any.attributes.integer.Size<E>,
      com.aoapps.html.any.attributes.text.Value<E>,
      // Global Event Attributes overrides
      com.aoapps.html.any.attributes.event.Onchange<E>,
      com.aoapps.html.any.attributes.event.Oninput<E>,
      com.aoapps.html.any.attributes.event.Oninvalid<E>,
      // Guessed (to match Placeholder)
      com.aoapps.html.any.attributes.event.Onselect<E> {

    protected Email(D document, PC pc) {
      super(document, pc);
      typeOnlySupportedInHtml5(document, Dynamic.Type.EMAIL);
    }

    /**
     * See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Attributes/autocomplete">The HTML autocomplete attribute</a>.
     *
     * <p>We're making our best guess which values are applicable.
     * This is to give a nice short list in code assist.
     * TODO: Find somewhere this relationship is defined (if there is any).</p>
     *
     * @since HTML 5
     *
     * @see AnyINPUT.Autocomplete
     */
    public enum Autocomplete implements Function<AnyDocument<?>, String> {
      OFF(AnyINPUT.Autocomplete.OFF),
      ON(AnyINPUT.Autocomplete.ON),
      EMAIL(AnyINPUT.Autocomplete.EMAIL),
      IMPP(AnyINPUT.Autocomplete.IMPP),
      URL(AnyINPUT.Autocomplete.URL);

      private final AnyINPUT.Autocomplete value;

      private Autocomplete(AnyINPUT.Autocomplete value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value.toString();
      }

      @Override
      public String apply(AnyDocument<?> document) {
        return value.apply(document);
      }

      public AnyINPUT.Autocomplete getValue() {
        return value;
      }

      static {
        for (Autocomplete value : values()) {
          if (!value.name().equals(value.value.name())) {
            throw new AssertionError("Enum name mismatch");
          }
        }
      }
    }

    @Override
    protected void openWriteType(Writer unsafe) throws IOException {
      assert !document.getAtnl();
      unsafe.write(" type=\"email\"");
    }
  }

  /**
   * <ul>
   * <li>See <a href="https://www.w3schools.com/tags/att_input_type_file.asp">HTML input type="file"</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input/file">&lt;input type="file"&gt;</a>.</li>
   * </ul>
   *
   * @param  <D>   This document type
   * @param  <PC>  The parent content model this element is within
   * @param  <E>   This element type
   */
  public abstract static class File<
      D  extends AnyDocument<D>,
      PC extends AnyUnion_Interactive_Phrasing<D, PC>,
      E  extends File<D, PC, E>
      >
      extends AnyINPUT<D, PC, E> implements
      com.aoapps.html.any.attributes.text.Accept<E>,
      com.aoapps.html.any.attributes.enumeration.Capture<E, File.Capture>,
      com.aoapps.html.any.attributes.bool.Multiple<E>,
      com.aoapps.html.any.attributes.bool.Required<E>,
      // Does not support value per https://www.w3schools.com/tags/att_input_value.asp: com.aoapps.html.any.attributes.text.Value<File>
      // Global Event Attributes overrides
      com.aoapps.html.any.attributes.event.Onchange<E>,
      com.aoapps.html.any.attributes.event.Oninput<E>,
      com.aoapps.html.any.attributes.event.Oninvalid<E>,
      com.aoapps.html.any.attributes.event.Onselect<E> {

    protected File(D document, PC pc) {
      super(document, pc);
    }

    /**
     * See <a href="https://www.w3.org/TR/mediacapture-streams/#dom-videofacingmodeenum">Media Capture and Streams: VideoFacingModeEnum</a>.
     *
     * @since HTML 5
     */
    public enum Capture implements Function<AnyDocument<?>, String> {

      /**
       * The source is facing toward the user (a self-view camera).
       */
      USER("user"),

      /**
       * The source is facing away from the user (viewing the environment).
       */
      ENVIRONMENT("environment"),

      /**
       * The source is facing to the left of the user.
       */
      LEFT("left"),

      /**
       * The source is facing to the right of the user.
       */
      RIGHT("right");

      private final String value;

      private Capture(String value) {
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

    @Override
    protected void openWriteType(Writer unsafe) throws IOException {
      assert !document.getAtnl();
      unsafe.write(" type=\"file\"");
    }
  }

  /**
   * See <a href="https://www.w3schools.com/tags/att_input_type_hidden.asp">HTML input type="hidden"</a>.
   *
   * @param  <D>   This document type
   * @param  <PC>  The parent content model this element is within
   * @param  <E>   This element type
   */
  @SuppressWarnings("deprecation")
  public abstract static class Hidden<
      D  extends AnyDocument<D>,
      PC extends AnyUnion_Interactive_Phrasing<D, PC>,
      E  extends Hidden<D, PC, E>
      >
      extends AnyINPUT<D, PC, E> implements
      com.aoapps.html.any.attributes.text.Value<E>,
      // Global Attributes overrides
      com.aoapps.html.any.attributes.text.AccesskeyUnexpected<E>,
      com.aoapps.html.any.attributes.bool.AutofocusUnexpected<E>,
      com.aoapps.html.any.attributes.enumeration.DirUnexpected<E>,
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
      com.aoapps.html.any.attributes.event.OnfocusUnexpected<E>,
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

    protected Hidden(D document, PC pc) {
      super(document, pc);
    }

    @Override
    protected void openWriteType(Writer unsafe) throws IOException {
      assert !document.getAtnl();
      unsafe.write(" type=\"hidden\"");
    }
  }

  /**
   * <ul>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input/image">&lt;input type="image"&gt;</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/att_input_type_image.asp">HTML input type="image"</a>.</li>
   * </ul>
   *
   * @param  <D>   This document type
   * @param  <PC>  The parent content model this element is within
   * @param  <E>   This element type
   */
  @SuppressWarnings("deprecation")
  public abstract static class Image<
      D  extends AnyDocument<D>,
      PC extends AnyUnion_Interactive_Phrasing<D, PC>,
      E  extends Image<D, PC, E>
      >
      extends AnyINPUT<D, PC, E> implements
      com.aoapps.html.any.attributes.enumeration.Align<E, Image.Align>,
      com.aoapps.html.any.attributes.text.Alt<E>,
      com.aoapps.html.any.attributes.url.Formaction<E>,
      com.aoapps.html.any.attributes.enumeration.Formenctype<E, com.aoapps.html.any.attributes.enumeration.Enctype.Value>,
      com.aoapps.html.any.attributes.enumeration.Formmethod<E, com.aoapps.html.any.attributes.enumeration.Method.Value>,
      com.aoapps.html.any.attributes.bool.Formnovalidate<E>,
      com.aoapps.html.any.attributes.enumeration.Formtarget<E, com.aoapps.html.any.attributes.enumeration.Target.Value>,
      com.aoapps.html.any.attributes.integer.HeightHtml5Only<E>,
      com.aoapps.html.any.attributes.url.Src<E>,
      com.aoapps.html.any.attributes.text.Value<E>,
      com.aoapps.html.any.attributes.integer.WidthHtml5Only<E>,
      // Global Event Attributes overrides
      com.aoapps.html.any.attributes.event.Onabort<E>,
      com.aoapps.html.any.attributes.event.Onerror<E>,
      com.aoapps.html.any.attributes.event.Onload<E> {

    protected Image(D document, PC pc) {
      super(document, pc);
    }

    @Override
    protected void openWriteType(Writer unsafe) throws IOException {
      assert !document.getAtnl();
      unsafe.write(" type=\"image\"");
    }

    /**
     * See <a href="https://www.w3schools.com/tags/att_input_align.asp">HTML input align Attribute</a>.
     *
     * @deprecated  The align attribute of &lt;input&gt; is not supported in HTML5. Use CSS instead.
     */
    @Deprecated(forRemoval = false)
    public enum Align implements Function<AnyDocument<?>, String> {

      /**
       * Left-aligns the image (this is default).
       */
      LEFT("left"),

      /**
       * Right-aligns the image.
       */
      RIGHT("right"),

      /**
       * Top-aligns the image.
       */
      TOP("top"),

      /**
       * Middle-aligns the image.
       */
      MIDDLE("middle"),

      /**
       * Bottom-aligns the image.
       */
      BOTTOM("bottom");

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
  }

  /**
   * See <a href="https://www.w3schools.com/tags/att_input_type_month.asp">HTML input type="month"</a>.
   *
   * @param  <D>   This document type
   * @param  <PC>  The parent content model this element is within
   * @param  <E>   This element type
   *
   * @since HTML 5
   */
  public abstract static class Month<
      D  extends AnyDocument<D>,
      PC extends AnyUnion_Interactive_Phrasing<D, PC>,
      E  extends Month<D, PC, E>
      >
      extends AnyINPUT<D, PC, E> implements
      com.aoapps.html.any.attributes.enumeration.Autocomplete<E, Month.Autocomplete>,
      com.aoapps.html.any.attributes.text.List<E>,
      com.aoapps.html.any.attributes.bool.Readonly<E>, // Guessed
      com.aoapps.html.any.attributes.bool.Required<E>,
      com.aoapps.html.any.attributes.text.Value<E>,
      // Global Event Attributes overrides
      com.aoapps.html.any.attributes.event.Onchange<E>,
      com.aoapps.html.any.attributes.event.Oninput<E>,
      com.aoapps.html.any.attributes.event.Oninvalid<E> {

    protected Month(D document, PC pc) {
      super(document, pc);
      typeOnlySupportedInHtml5(document, Dynamic.Type.MONTH);
    }

    /**
     * See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Attributes/autocomplete">The HTML autocomplete attribute</a>.
     *
     * <p>We're making our best guess which values are applicable.
     * This is to give a nice short list in code assist.
     * TODO: Find somewhere this relationship is defined (if there is any).</p>
     *
     * @since HTML 5
     *
     * @see AnyINPUT.Autocomplete
     */
    public enum Autocomplete implements Function<AnyDocument<?>, String> {
      OFF(AnyINPUT.Autocomplete.OFF),
      ON(AnyINPUT.Autocomplete.ON),
      CC_EXP(AnyINPUT.Autocomplete.CC_EXP),
      CC_EXP_MONTH(AnyINPUT.Autocomplete.CC_EXP_MONTH),
      BDAY_MONTH(AnyINPUT.Autocomplete.BDAY_MONTH);

      private final AnyINPUT.Autocomplete value;

      private Autocomplete(AnyINPUT.Autocomplete value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value.toString();
      }

      @Override
      public String apply(AnyDocument<?> document) {
        return value.apply(document);
      }

      public AnyINPUT.Autocomplete getValue() {
        return value;
      }

      static {
        for (Autocomplete value : values()) {
          if (!value.name().equals(value.value.name())) {
            throw new AssertionError("Enum name mismatch");
          }
        }
      }
    }

    @Override
    protected void openWriteType(Writer unsafe) throws IOException {
      assert !document.getAtnl();
      unsafe.write(" type=\"month\"");
    }
  }

  /**
   * See <a href="https://www.w3schools.com/tags/att_input_type_number.asp">HTML input type="number"</a>.
   *
   * @param  <D>   This document type
   * @param  <PC>  The parent content model this element is within
   * @param  <E>   This element type
   *
   * @since HTML 5
   */
  public abstract static class Number<
      D  extends AnyDocument<D>,
      PC extends AnyUnion_Interactive_Phrasing<D, PC>,
      E  extends Number<D, PC, E>
      >
      extends AnyINPUT<D, PC, E> implements
      com.aoapps.html.any.attributes.enumeration.Autocomplete<E, Number.Autocomplete>,
      com.aoapps.html.any.attributes.text.List<E>,
      com.aoapps.html.any.attributes.bool.Readonly<E>,
      com.aoapps.html.any.attributes.bool.Required<E>,
      com.aoapps.html.any.attributes.text.Value<E>, // TODO: Review types (this and others), perhaps Attributes.Number or similar?
      // Global Event Attributes overrides
      com.aoapps.html.any.attributes.event.Onchange<E>,
      com.aoapps.html.any.attributes.event.Oninput<E>,
      com.aoapps.html.any.attributes.event.Oninvalid<E> {

    protected Number(D document, PC pc) {
      super(document, pc);
      typeOnlySupportedInHtml5(document, Dynamic.Type.NUMBER);
    }

    /**
     * See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Attributes/autocomplete">The HTML autocomplete attribute</a>.
     *
     * <p>We're making our best guess which values are applicable.
     * This is to give a nice short list in code assist.
     * TODO: Find somewhere this relationship is defined (if there is any).</p>
     *
     * @since HTML 5
     *
     * @see AnyINPUT.Autocomplete
     */
    public enum Autocomplete implements Function<AnyDocument<?>, String> {
      OFF(AnyINPUT.Autocomplete.OFF),
      ON(AnyINPUT.Autocomplete.ON),
      ONE_TIME_CODE(AnyINPUT.Autocomplete.ONE_TIME_CODE),
      ADDRESS_LEVEL4(AnyINPUT.Autocomplete.ADDRESS_LEVEL4),
      ADDRESS_LEVEL3(AnyINPUT.Autocomplete.ADDRESS_LEVEL3),
      ADDRESS_LEVEL2(AnyINPUT.Autocomplete.ADDRESS_LEVEL2),
      ADDRESS_LEVEL1(AnyINPUT.Autocomplete.ADDRESS_LEVEL1),
      POSTAL_CODE(AnyINPUT.Autocomplete.POSTAL_CODE),
      CC_NUMBER(AnyINPUT.Autocomplete.CC_NUMBER),
      CC_EXP_MONTH(AnyINPUT.Autocomplete.CC_EXP_MONTH),
      CC_EXP_YEAR(AnyINPUT.Autocomplete.CC_EXP_YEAR),
      CC_CSC(AnyINPUT.Autocomplete.CC_CSC),
      TRANSACTION_AMOUNT(AnyINPUT.Autocomplete.TRANSACTION_AMOUNT),
      BDAY_DAY(AnyINPUT.Autocomplete.BDAY_DAY),
      BDAY_MONTH(AnyINPUT.Autocomplete.BDAY_MONTH),
      BDAY_YEAR(AnyINPUT.Autocomplete.BDAY_YEAR),
      TEL_COUNTRY_CODE(AnyINPUT.Autocomplete.TEL_COUNTRY_CODE),
      TEL_AREA_CODE(AnyINPUT.Autocomplete.TEL_AREA_CODE),
      TEL_LOCAL_PREFIX(AnyINPUT.Autocomplete.TEL_LOCAL_PREFIX),
      TEL_LOCAL_SUFFIX(AnyINPUT.Autocomplete.TEL_LOCAL_SUFFIX),
      TEL_EXTENSION(AnyINPUT.Autocomplete.TEL_EXTENSION);

      private final AnyINPUT.Autocomplete value;

      private Autocomplete(AnyINPUT.Autocomplete value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value.toString();
      }

      @Override
      public String apply(AnyDocument<?> document) {
        return value.apply(document);
      }

      public AnyINPUT.Autocomplete getValue() {
        return value;
      }

      static {
        for (Autocomplete value : values()) {
          if (!value.name().equals(value.value.name())) {
            throw new AssertionError("Enum name mismatch");
          }
        }
      }
    }

    @Override
    protected void openWriteType(Writer unsafe) throws IOException {
      assert !document.getAtnl();
      unsafe.write(" type=\"number\"");
    }
  }

  /**
   * See <a href="https://www.w3schools.com/tags/att_input_type_password.asp">HTML input type="password"</a>.
   *
   * @param  <D>   This document type
   * @param  <PC>  The parent content model this element is within
   * @param  <E>   This element type
   */
  public abstract static class Password<
      D  extends AnyDocument<D>,
      PC extends AnyUnion_Interactive_Phrasing<D, PC>,
      E  extends Password<D, PC, E>
      >
      extends AnyINPUT<D, PC, E> implements
      com.aoapps.html.any.attributes.enumeration.Autocomplete<E, Password.Autocomplete>,
      com.aoapps.html.any.attributes.integer.Maxlength<E>,
      com.aoapps.html.any.attributes.integer.Minlength<E>,
      com.aoapps.html.any.attributes.text.Placeholder<E>,
      com.aoapps.html.any.attributes.bool.Readonly<E>,
      com.aoapps.html.any.attributes.bool.Required<E>,
      com.aoapps.html.any.attributes.integer.Size<E>,
      com.aoapps.html.any.attributes.text.Value<E>,
      // Global Event Attributes overrides
      com.aoapps.html.any.attributes.event.Onchange<E>,
      com.aoapps.html.any.attributes.event.Oninput<E>,
      com.aoapps.html.any.attributes.event.Oninvalid<E>,
      com.aoapps.html.any.attributes.event.Onselect<E> {

    protected Password(D document, PC pc) {
      super(document, pc);
    }

    /**
     * See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Attributes/autocomplete">The HTML autocomplete attribute</a>.
     *
     * <p>We're making our best guess which values are applicable.
     * This is to give a nice short list in code assist.
     * TODO: Find somewhere this relationship is defined (if there is any).</p>
     *
     * @since HTML 5
     *
     * @see AnyINPUT.Autocomplete
     */
    public enum Autocomplete implements Function<AnyDocument<?>, String> {
      OFF(AnyINPUT.Autocomplete.OFF),
      ON(AnyINPUT.Autocomplete.ON),
      NEW_PASSWORD(AnyINPUT.Autocomplete.NEW_PASSWORD),
      CURRENT_PASSWORD(AnyINPUT.Autocomplete.CURRENT_PASSWORD),
      ONE_TIME_CODE(AnyINPUT.Autocomplete.ONE_TIME_CODE),
      CC_NUMBER(AnyINPUT.Autocomplete.CC_NUMBER),
      CC_EXP(AnyINPUT.Autocomplete.CC_EXP),
      CC_EXP_MONTH(AnyINPUT.Autocomplete.CC_EXP_MONTH),
      CC_EXP_YEAR(AnyINPUT.Autocomplete.CC_EXP_YEAR),
      CC_CSC(AnyINPUT.Autocomplete.CC_CSC);

      private final AnyINPUT.Autocomplete value;

      private Autocomplete(AnyINPUT.Autocomplete value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value.toString();
      }

      @Override
      public String apply(AnyDocument<?> document) {
        return value.apply(document);
      }

      public AnyINPUT.Autocomplete getValue() {
        return value;
      }

      static {
        for (Autocomplete value : values()) {
          if (!value.name().equals(value.value.name())) {
            throw new AssertionError("Enum name mismatch");
          }
        }
      }
    }

    @Override
    protected void openWriteType(Writer unsafe) throws IOException {
      assert !document.getAtnl();
      unsafe.write(" type=\"password\"");
    }
  }

  /**
   * See <a href="https://www.w3schools.com/tags/att_input_type_radio.asp">HTML input type="radio"</a>.
   *
   * @param  <D>   This document type
   * @param  <PC>  The parent content model this element is within
   * @param  <E>   This element type
   */
  public abstract static class Radio<
      D  extends AnyDocument<D>,
      PC extends AnyUnion_Interactive_Phrasing<D, PC>,
      E  extends Radio<D, PC, E>
      >
      extends AnyINPUT<D, PC, E> implements
      com.aoapps.html.any.attributes.bool.Checked<E>,
      com.aoapps.html.any.attributes.bool.Required<E>,
      com.aoapps.html.any.attributes.text.Value<E>,
      // Global Event Attributes overrides
      com.aoapps.html.any.attributes.event.Onchange<E>,
      com.aoapps.html.any.attributes.event.Oninput<E>,
      com.aoapps.html.any.attributes.event.Oninvalid<E> {

    protected Radio(D document, PC pc) {
      super(document, pc);
    }

    @Override
    protected void openWriteType(Writer unsafe) throws IOException {
      assert !document.getAtnl();
      unsafe.write(" type=\"radio\"");
    }
  }

  /**
   * See <a href="https://www.w3schools.com/tags/att_input_type_range.asp">HTML input type="range"</a>.
   *
   * @param  <D>   This document type
   * @param  <PC>  The parent content model this element is within
   * @param  <E>   This element type
   *
   * @since HTML 5
   */
  public abstract static class Range<
      D  extends AnyDocument<D>,
      PC extends AnyUnion_Interactive_Phrasing<D, PC>,
      E  extends Range<D, PC, E>
      >
      extends AnyINPUT<D, PC, E> implements
      com.aoapps.html.any.attributes.enumeration.Autocomplete<E, Range.Autocomplete>,
      com.aoapps.html.any.attributes.text.List<E>,
      com.aoapps.html.any.attributes.text.Value<E>,
      // Global Event Attributes overrides
      com.aoapps.html.any.attributes.event.Onchange<E>,
      com.aoapps.html.any.attributes.event.Oninput<E> {

    protected Range(D document, PC pc) {
      super(document, pc);
      typeOnlySupportedInHtml5(document, Dynamic.Type.RANGE);
    }

    /**
     * See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Attributes/autocomplete">The HTML autocomplete attribute</a>.
     *
     * <p>We're making our best guess which values are applicable.
     * This is to give a nice short list in code assist.
     * TODO: Find somewhere this relationship is defined (if there is any).</p>
     *
     * @since HTML 5
     *
     * @see AnyINPUT.Autocomplete
     */
    public enum Autocomplete implements Function<AnyDocument<?>, String> {
      OFF(AnyINPUT.Autocomplete.OFF),
      ON(AnyINPUT.Autocomplete.ON);

      private final AnyINPUT.Autocomplete value;

      private Autocomplete(AnyINPUT.Autocomplete value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value.toString();
      }

      @Override
      public String apply(AnyDocument<?> document) {
        return value.apply(document);
      }

      public AnyINPUT.Autocomplete getValue() {
        return value;
      }

      static {
        for (Autocomplete value : values()) {
          if (!value.name().equals(value.value.name())) {
            throw new AssertionError("Enum name mismatch");
          }
        }
      }
    }

    @Override
    protected void openWriteType(Writer unsafe) throws IOException {
      assert !document.getAtnl();
      unsafe.write(" type=\"range\"");
    }
  }

  /**
   * See <a href="https://www.w3schools.com/tags/att_input_type_reset.asp">HTML input type="reset"</a>.
   *
   * @param  <D>   This document type
   * @param  <PC>  The parent content model this element is within
   * @param  <E>   This element type
   */
  public abstract static class Reset<
      D  extends AnyDocument<D>,
      PC extends AnyUnion_Interactive_Phrasing<D, PC>,
      E  extends Reset<D, PC, E>
      >
      extends AnyINPUT<D, PC, E> implements
      com.aoapps.html.any.attributes.text.Value<E> {

    protected Reset(D document, PC pc) {
      super(document, pc);
    }

    @Override
    protected void openWriteType(Writer unsafe) throws IOException {
      assert !document.getAtnl();
      unsafe.write(" type=\"reset\"");
    }

    /**
     * See <a href="https://www.w3schools.com/tags/att_input_value.asp">HTML input value Attribute</a>.
     *
     * @see Dynamic.Type#RESET
     */
    @Override
    public E value(Object value) throws IOException {
      @SuppressWarnings("unchecked")
      E element = (E) this;
      return Attributes.Text.attribute(
        element,
        "value",
        // Allow text markup from translations
        Dynamic.Type.RESET.getMarkupType(),
        value,
        FunctionE.identity(),
        textInXhtmlAttributeEncoder
      );
    }
  }

  /**
   * See <a href="https://www.w3schools.com/tags/att_input_type_search.asp">HTML input type="search"</a>.
   *
   * @param  <D>   This document type
   * @param  <PC>  The parent content model this element is within
   * @param  <E>   This element type
   *
   * @since HTML 5
   */
  public abstract static class Search<
      D  extends AnyDocument<D>,
      PC extends AnyUnion_Interactive_Phrasing<D, PC>,
      E  extends Search<D, PC, E>
      >
      extends AnyINPUT<D, PC, E> implements
      com.aoapps.html.any.attributes.enumeration.Autocomplete<E, Search.Autocomplete>,
      com.aoapps.html.any.attributes.text.Dirname<E>,
      com.aoapps.html.any.attributes.text.List<E>,
      com.aoapps.html.any.attributes.integer.Maxlength<E>,
      com.aoapps.html.any.attributes.integer.Minlength<E>,
      com.aoapps.html.any.attributes.text.Placeholder<E>,
      com.aoapps.html.any.attributes.bool.Readonly<E>,
      com.aoapps.html.any.attributes.bool.Required<E>,
      com.aoapps.html.any.attributes.integer.Size<E>,
      com.aoapps.html.any.attributes.text.Value<E>,
      // Event Attributes
      com.aoapps.html.any.attributes.event.Onsearch<E>,
      // Global Attributes overrides
      com.aoapps.html.any.attributes.enumeration.Autocapitalize<E>,
      // Global Event Attributes overrides
      com.aoapps.html.any.attributes.event.Onchange<E>,
      com.aoapps.html.any.attributes.event.Oninput<E>,
      com.aoapps.html.any.attributes.event.Oninvalid<E>,
      // Guessed (to match Placeholder)
      com.aoapps.html.any.attributes.event.Onselect<E> {

    protected Search(D document, PC pc) {
      super(document, pc);
      typeOnlySupportedInHtml5(document, Dynamic.Type.SEARCH);
    }

    /**
     * See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Attributes/autocomplete">The HTML autocomplete attribute</a>.
     *
     * <p>We're making our best guess which values are applicable.
     * This is to give a nice short list in code assist.
     * TODO: Find somewhere this relationship is defined (if there is any).</p>
     *
     * @since HTML 5
     *
     * @see AnyINPUT.Autocomplete
     */
    public enum Autocomplete implements Function<AnyDocument<?>, String> {
      OFF(AnyINPUT.Autocomplete.OFF),
      ON(AnyINPUT.Autocomplete.ON),
      NAME(AnyINPUT.Autocomplete.NAME),
      HONORIFIC_PREFIX(AnyINPUT.Autocomplete.HONORIFIC_PREFIX),
      GIVEN_NAME(AnyINPUT.Autocomplete.GIVEN_NAME),
      ADDITIONAL_NAME(AnyINPUT.Autocomplete.ADDITIONAL_NAME),
      FAMILY_NAME(AnyINPUT.Autocomplete.FAMILY_NAME),
      HONORIFIC_SUFFIX(AnyINPUT.Autocomplete.HONORIFIC_SUFFIX),
      NICKNAME(AnyINPUT.Autocomplete.NICKNAME),
      EMAIL(AnyINPUT.Autocomplete.EMAIL),
      USERNAME(AnyINPUT.Autocomplete.USERNAME),
      ORGANIZATION_TITLE(AnyINPUT.Autocomplete.ORGANIZATION_TITLE),
      ORGANIZATION(AnyINPUT.Autocomplete.ORGANIZATION),
      STREET_ADDRESS(AnyINPUT.Autocomplete.STREET_ADDRESS),
      ADDRESS_LINE1(AnyINPUT.Autocomplete.ADDRESS_LINE1),
      ADDRESS_LINE2(AnyINPUT.Autocomplete.ADDRESS_LINE2),
      ADDRESS_LINE3(AnyINPUT.Autocomplete.ADDRESS_LINE3),
      ADDRESS_LEVEL4(AnyINPUT.Autocomplete.ADDRESS_LEVEL4),
      ADDRESS_LEVEL3(AnyINPUT.Autocomplete.ADDRESS_LEVEL3),
      ADDRESS_LEVEL2(AnyINPUT.Autocomplete.ADDRESS_LEVEL2),
      ADDRESS_LEVEL1(AnyINPUT.Autocomplete.ADDRESS_LEVEL1),
      COUNTRY(AnyINPUT.Autocomplete.COUNTRY),
      COUNTRY_NAME(AnyINPUT.Autocomplete.COUNTRY_NAME),
      POSTAL_CODE(AnyINPUT.Autocomplete.POSTAL_CODE),
      CC_NAME(AnyINPUT.Autocomplete.CC_NAME),
      CC_GIVEN_NAME(AnyINPUT.Autocomplete.CC_GIVEN_NAME),
      CC_ADDITIONAL_NAME(AnyINPUT.Autocomplete.CC_ADDITIONAL_NAME),
      CC_FAMILY_NAME(AnyINPUT.Autocomplete.CC_FAMILY_NAME),
      CC_TYPE(AnyINPUT.Autocomplete.CC_TYPE),
      TRANSACTION_CURRENCY(AnyINPUT.Autocomplete.TRANSACTION_CURRENCY),
      TRANSACTION_AMOUNT(AnyINPUT.Autocomplete.TRANSACTION_AMOUNT),
      LANGUAGE(AnyINPUT.Autocomplete.LANGUAGE),
      BDAY(AnyINPUT.Autocomplete.BDAY),
      BDAY_DAY(AnyINPUT.Autocomplete.BDAY_DAY),
      BDAY_MONTH(AnyINPUT.Autocomplete.BDAY_MONTH),
      BDAY_YEAR(AnyINPUT.Autocomplete.BDAY_YEAR),
      SEX(AnyINPUT.Autocomplete.SEX),
      TEL(AnyINPUT.Autocomplete.TEL),
      TEL_COUNTRY_CODE(AnyINPUT.Autocomplete.TEL_COUNTRY_CODE),
      TEL_NATIONAL(AnyINPUT.Autocomplete.TEL_NATIONAL),
      TEL_AREA_CODE(AnyINPUT.Autocomplete.TEL_AREA_CODE),
      TEL_LOCAL(AnyINPUT.Autocomplete.TEL_LOCAL),
      TEL_LOCAL_PREFIX(AnyINPUT.Autocomplete.TEL_LOCAL_PREFIX),
      TEL_LOCAL_SUFFIX(AnyINPUT.Autocomplete.TEL_LOCAL_SUFFIX),
      TEL_EXTENSION(AnyINPUT.Autocomplete.TEL_EXTENSION),
      IMPP(AnyINPUT.Autocomplete.IMPP),
      URL(AnyINPUT.Autocomplete.URL),
      PHOTO(AnyINPUT.Autocomplete.PHOTO);

      private final AnyINPUT.Autocomplete value;

      private Autocomplete(AnyINPUT.Autocomplete value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value.toString();
      }

      @Override
      public String apply(AnyDocument<?> document) {
        return value.apply(document);
      }

      public AnyINPUT.Autocomplete getValue() {
        return value;
      }

      static {
        for (Autocomplete value : values()) {
          if (!value.name().equals(value.value.name())) {
            throw new AssertionError("Enum name mismatch");
          }
        }
      }
    }

    @Override
    protected void openWriteType(Writer unsafe) throws IOException {
      assert !document.getAtnl();
      unsafe.write(" type=\"search\"");
    }
  }

  /**
   * <ul>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input/submit">&lt;input type="submit"&gt;</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/att_input_type_submit.asp">HTML input type="submit"</a>.</li>
   * </ul>
   *
   * @param  <D>   This document type
   * @param  <PC>  The parent content model this element is within
   * @param  <E>   This element type
   */
  public abstract static class Submit<
      D  extends AnyDocument<D>,
      PC extends AnyUnion_Interactive_Phrasing<D, PC>,
      E  extends Submit<D, PC, E>
      >
      extends AnyINPUT<D, PC, E> implements
      com.aoapps.html.any.attributes.url.Formaction<E>,
      com.aoapps.html.any.attributes.enumeration.Formenctype<E, com.aoapps.html.any.attributes.enumeration.Enctype.Value>,
      com.aoapps.html.any.attributes.enumeration.Formmethod<E, com.aoapps.html.any.attributes.enumeration.Method.Value>,
      com.aoapps.html.any.attributes.bool.Formnovalidate<E>,
      com.aoapps.html.any.attributes.enumeration.Formtarget<E, com.aoapps.html.any.attributes.enumeration.Target.Value>,
      com.aoapps.html.any.attributes.text.Value<E> {

    protected Submit(D document, PC pc) {
      super(document, pc);
    }

    @Override
    protected void openWriteType(Writer unsafe) throws IOException {
      assert !document.getAtnl();
      unsafe.write(" type=\"submit\"");
    }

    /**
     * See <a href="https://www.w3schools.com/tags/att_input_value.asp">HTML input value Attribute</a>.
     *
     * @see Dynamic.Type#SUBMIT
     */
    @Override
    public E value(Object value) throws IOException {
      @SuppressWarnings("unchecked")
      E element = (E) this;
      return Attributes.Text.attribute(
        element,
        "value",
        // Allow text markup from translations
        Dynamic.Type.SUBMIT.getMarkupType(),
        value,
        FunctionE.identity(),
        textInXhtmlAttributeEncoder
      );
    }
  }

  /**
   * See <a href="https://www.w3schools.com/tags/att_input_type_tel.asp">HTML input type="tel"</a>.
   *
   * @param  <D>   This document type
   * @param  <PC>  The parent content model this element is within
   * @param  <E>   This element type
   *
   * @since HTML 5
   */
  public abstract static class Tel<
      D  extends AnyDocument<D>,
      PC extends AnyUnion_Interactive_Phrasing<D, PC>,
      E  extends Tel<D, PC, E>
      >
      extends AnyINPUT<D, PC, E> implements
      com.aoapps.html.any.attributes.enumeration.Autocomplete<E, Tel.Autocomplete>,
      com.aoapps.html.any.attributes.text.List<E>,
      com.aoapps.html.any.attributes.integer.Maxlength<E>,
      com.aoapps.html.any.attributes.integer.Minlength<E>,
      com.aoapps.html.any.attributes.text.Placeholder<E>,
      com.aoapps.html.any.attributes.bool.Readonly<E>, // Guessed
      com.aoapps.html.any.attributes.bool.Required<E>,
      com.aoapps.html.any.attributes.integer.Size<E>,
      com.aoapps.html.any.attributes.text.Value<E>,
      // Global Event Attributes overrides
      com.aoapps.html.any.attributes.event.Onchange<E>,
      com.aoapps.html.any.attributes.event.Oninput<E>,
      com.aoapps.html.any.attributes.event.Oninvalid<E>,
      // Guessed (to match Placeholder)
      com.aoapps.html.any.attributes.event.Onselect<E> {

    protected Tel(D document, PC pc) {
      super(document, pc);
      typeOnlySupportedInHtml5(document, Dynamic.Type.TEL);
    }

    /**
     * See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Attributes/autocomplete">The HTML autocomplete attribute</a>.
     *
     * <p>We're making our best guess which values are applicable.
     * This is to give a nice short list in code assist.
     * TODO: Find somewhere this relationship is defined (if there is any).</p>
     *
     * @since HTML 5
     *
     * @see AnyINPUT.Autocomplete
     */
    public enum Autocomplete implements Function<AnyDocument<?>, String> {
      OFF(AnyINPUT.Autocomplete.OFF),
      ON(AnyINPUT.Autocomplete.ON),
      TEL(AnyINPUT.Autocomplete.TEL),
      TEL_COUNTRY_CODE(AnyINPUT.Autocomplete.TEL_COUNTRY_CODE),
      TEL_NATIONAL(AnyINPUT.Autocomplete.TEL_NATIONAL),
      TEL_AREA_CODE(AnyINPUT.Autocomplete.TEL_AREA_CODE),
      TEL_LOCAL(AnyINPUT.Autocomplete.TEL_LOCAL),
      TEL_LOCAL_PREFIX(AnyINPUT.Autocomplete.TEL_LOCAL_PREFIX),
      TEL_LOCAL_SUFFIX(AnyINPUT.Autocomplete.TEL_LOCAL_SUFFIX),
      TEL_EXTENSION(AnyINPUT.Autocomplete.TEL_EXTENSION);

      private final AnyINPUT.Autocomplete value;

      private Autocomplete(AnyINPUT.Autocomplete value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value.toString();
      }

      @Override
      public String apply(AnyDocument<?> document) {
        return value.apply(document);
      }

      public AnyINPUT.Autocomplete getValue() {
        return value;
      }

      static {
        for (Autocomplete value : values()) {
          if (!value.name().equals(value.value.name())) {
            throw new AssertionError("Enum name mismatch");
          }
        }
      }
    }

    @Override
    protected void openWriteType(Writer unsafe) throws IOException {
      assert !document.getAtnl();
      unsafe.write(" type=\"tel\"");
    }
  }

  /**
   * See <a href="https://www.w3schools.com/tags/att_input_type_text.asp">HTML input type="text"</a>.
   *
   * @param  <D>   This document type
   * @param  <PC>  The parent content model this element is within
   * @param  <E>   This element type
   */
  public abstract static class Text<
      D  extends AnyDocument<D>,
      PC extends AnyUnion_Interactive_Phrasing<D, PC>,
      E  extends Text<D, PC, E>
      >
      extends AnyINPUT<D, PC, E> implements
      com.aoapps.html.any.attributes.enumeration.Autocomplete<E, AnyINPUT.Autocomplete>,
      com.aoapps.html.any.attributes.text.Dirname<E>,
      com.aoapps.html.any.attributes.integer.Maxlength<E>,
      com.aoapps.html.any.attributes.integer.Minlength<E>,
      com.aoapps.html.any.attributes.text.List<E>,
      com.aoapps.html.any.attributes.text.Placeholder<E>,
      com.aoapps.html.any.attributes.bool.Readonly<E>,
      com.aoapps.html.any.attributes.bool.Required<E>,
      com.aoapps.html.any.attributes.integer.Size<E>,
      com.aoapps.html.any.attributes.text.Value<E>,
      // Global Attributes overrides
      com.aoapps.html.any.attributes.enumeration.Autocapitalize<E>,
      // Global Event Attributes overrides
      com.aoapps.html.any.attributes.event.Onchange<E>,
      com.aoapps.html.any.attributes.event.Oninput<E>,
      com.aoapps.html.any.attributes.event.Oninvalid<E>,
      com.aoapps.html.any.attributes.event.Onselect<E> {

    protected Text(D document, PC pc) {
      super(document, pc);
    }

    @Override
    protected void openWriteType(Writer unsafe) throws IOException {
      assert !document.getAtnl();
      unsafe.write(" type=\"text\"");
    }
  }

  /**
   * See <a href="https://www.w3schools.com/tags/att_input_type_time.asp">HTML input type="time"</a>.
   *
   * @param  <D>   This document type
   * @param  <PC>  The parent content model this element is within
   * @param  <E>   This element type
   *
   * @since HTML 5
   */
  public abstract static class Time<
      D  extends AnyDocument<D>,
      PC extends AnyUnion_Interactive_Phrasing<D, PC>,
      E  extends Time<D, PC, E>
      >
      extends AnyINPUT<D, PC, E> implements
      com.aoapps.html.any.attributes.enumeration.Autocomplete<E, Time.Autocomplete>,
      com.aoapps.html.any.attributes.text.List<E>,
      com.aoapps.html.any.attributes.bool.Readonly<E>, // Guessed
      com.aoapps.html.any.attributes.bool.Required<E>,
      com.aoapps.html.any.attributes.text.Value<E>,
      // Global Event Attributes overrides
      com.aoapps.html.any.attributes.event.Onchange<E>,
      com.aoapps.html.any.attributes.event.Oninput<E>,
      com.aoapps.html.any.attributes.event.Oninvalid<E> {

    protected Time(D document, PC pc) {
      super(document, pc);
      typeOnlySupportedInHtml5(document, Dynamic.Type.TIME);
    }

    /**
     * See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Attributes/autocomplete">The HTML autocomplete attribute</a>.
     *
     * <p>We're making our best guess which values are applicable.
     * This is to give a nice short list in code assist.
     * TODO: Find somewhere this relationship is defined (if there is any).</p>
     *
     * @since HTML 5
     *
     * @see AnyINPUT.Autocomplete
     */
    public enum Autocomplete implements Function<AnyDocument<?>, String> {
      OFF(AnyINPUT.Autocomplete.OFF),
      ON(AnyINPUT.Autocomplete.ON);

      private final AnyINPUT.Autocomplete value;

      private Autocomplete(AnyINPUT.Autocomplete value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value.toString();
      }

      @Override
      public String apply(AnyDocument<?> document) {
        return value.apply(document);
      }

      public AnyINPUT.Autocomplete getValue() {
        return value;
      }

      static {
        for (Autocomplete value : values()) {
          if (!value.name().equals(value.value.name())) {
            throw new AssertionError("Enum name mismatch");
          }
        }
      }
    }

    @Override
    protected void openWriteType(Writer unsafe) throws IOException {
      assert !document.getAtnl();
      unsafe.write(" type=\"time\"");
    }
  }

  /**
   * See <a href="https://www.w3schools.com/tags/att_input_type_url.asp">HTML input type="url"</a>.
   *
   * @param  <D>   This document type
   * @param  <PC>  The parent content model this element is within
   * @param  <E>   This element type
   *
   * @since HTML 5
   */
  public abstract static class Url<
      D  extends AnyDocument<D>,
      PC extends AnyUnion_Interactive_Phrasing<D, PC>,
      E  extends Url<D, PC, E>
      >
      extends AnyINPUT<D, PC, E> implements
      com.aoapps.html.any.attributes.enumeration.Autocomplete<E, Url.Autocomplete>,
      com.aoapps.html.any.attributes.text.List<E>,
      com.aoapps.html.any.attributes.integer.Maxlength<E>,
      com.aoapps.html.any.attributes.integer.Minlength<E>,
      com.aoapps.html.any.attributes.text.Placeholder<E>,
      com.aoapps.html.any.attributes.bool.Readonly<E>,
      com.aoapps.html.any.attributes.bool.Required<E>,
      com.aoapps.html.any.attributes.integer.Size<E>,
      com.aoapps.html.any.attributes.text.Value<E>,
      // Global Event Attributes overrides
      com.aoapps.html.any.attributes.event.Onchange<E>,
      com.aoapps.html.any.attributes.event.Oninput<E>,
      com.aoapps.html.any.attributes.event.Oninvalid<E>,
      // Guessed (to match Placeholder)
      com.aoapps.html.any.attributes.event.Onselect<E> {

    protected Url(D document, PC pc) {
      super(document, pc);
      typeOnlySupportedInHtml5(document, Dynamic.Type.URL);
    }

    /**
     * See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Attributes/autocomplete">The HTML autocomplete attribute</a>.
     *
     * <p>We're making our best guess which values are applicable.
     * This is to give a nice short list in code assist.
     * TODO: Find somewhere this relationship is defined (if there is any).</p>
     *
     * @since HTML 5
     *
     * @see AnyINPUT.Autocomplete
     */
    public enum Autocomplete implements Function<AnyDocument<?>, String> {
      OFF(AnyINPUT.Autocomplete.OFF),
      ON(AnyINPUT.Autocomplete.ON),
      EMAIL(AnyINPUT.Autocomplete.EMAIL),
      TEL(AnyINPUT.Autocomplete.TEL),
      TEL_NATIONAL(AnyINPUT.Autocomplete.TEL_NATIONAL),
      TEL_LOCAL(AnyINPUT.Autocomplete.TEL_LOCAL),
      IMPP(AnyINPUT.Autocomplete.IMPP),
      URL(AnyINPUT.Autocomplete.URL),
      PHOTO(AnyINPUT.Autocomplete.PHOTO);

      private final AnyINPUT.Autocomplete value;

      private Autocomplete(AnyINPUT.Autocomplete value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value.toString();
      }

      @Override
      public String apply(AnyDocument<?> document) {
        return value.apply(document);
      }

      public AnyINPUT.Autocomplete getValue() {
        return value;
      }

      static {
        for (Autocomplete value : values()) {
          if (!value.name().equals(value.value.name())) {
            throw new AssertionError("Enum name mismatch");
          }
        }
      }
    }

    @Override
    protected void openWriteType(Writer unsafe) throws IOException {
      assert !document.getAtnl();
      unsafe.write(" type=\"url\"");
    }
  }

  /**
   * See <a href="https://www.w3schools.com/tags/att_input_type_week.asp">HTML input type="week"</a>.
   *
   * @param  <D>   This document type
   * @param  <PC>  The parent content model this element is within
   * @param  <E>   This element type
   *
   * @since HTML 5
   */
  public abstract static class Week<
      D  extends AnyDocument<D>,
      PC extends AnyUnion_Interactive_Phrasing<D, PC>,
      E  extends Week<D, PC, E>
      >
      extends AnyINPUT<D, PC, E> implements
      com.aoapps.html.any.attributes.enumeration.Autocomplete<E, Week.Autocomplete>,
      com.aoapps.html.any.attributes.text.List<E>,
      com.aoapps.html.any.attributes.bool.Readonly<E>, // Guessed
      com.aoapps.html.any.attributes.bool.Required<E>,
      com.aoapps.html.any.attributes.text.Value<E>,
      // Global Event Attributes overrides
      com.aoapps.html.any.attributes.event.Onchange<E>,
      com.aoapps.html.any.attributes.event.Oninput<E>,
      com.aoapps.html.any.attributes.event.Oninvalid<E> {

    protected Week(D document, PC pc) {
      super(document, pc);
      typeOnlySupportedInHtml5(document, Dynamic.Type.WEEK);
    }

    /**
     * See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Attributes/autocomplete">The HTML autocomplete attribute</a>.
     *
     * <p>We're making our best guess which values are applicable.
     * This is to give a nice short list in code assist.
     * TODO: Find somewhere this relationship is defined (if there is any).</p>
     *
     * @since HTML 5
     *
     * @see AnyINPUT.Autocomplete
     */
    public enum Autocomplete implements Function<AnyDocument<?>, String> {
      OFF(AnyINPUT.Autocomplete.OFF),
      ON(AnyINPUT.Autocomplete.ON),
      CC_EXP(AnyINPUT.Autocomplete.CC_EXP),
      BDAY(AnyINPUT.Autocomplete.BDAY);

      private final AnyINPUT.Autocomplete value;

      private Autocomplete(AnyINPUT.Autocomplete value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return value.toString();
      }

      @Override
      public String apply(AnyDocument<?> document) {
        return value.apply(document);
      }

      public AnyINPUT.Autocomplete getValue() {
        return value;
      }

      static {
        for (Autocomplete value : values()) {
          if (!value.name().equals(value.value.name())) {
            throw new AssertionError("Enum name mismatch");
          }
        }
      }
    }

    @Override
    protected void openWriteType(Writer unsafe) throws IOException {
      assert !document.getAtnl();
      unsafe.write(" type=\"week\"");
    }
  }
}
