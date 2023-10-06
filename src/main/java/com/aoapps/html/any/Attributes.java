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

package com.aoapps.html.any;

import static com.aoapps.encoding.JavaScriptInXhtmlAttributeEncoder.javascriptInXhtmlAttributeEncoder;
import static com.aoapps.encoding.TextInXhtmlAttributeEncoder.encodeTextInXhtmlAttribute;
import static com.aoapps.encoding.TextInXhtmlAttributeEncoder.textInXhtmlAttributeEncoder;

import com.aoapps.encoding.Doctype;
import com.aoapps.encoding.EncodingContext;
import com.aoapps.encoding.MediaEncoder;
import com.aoapps.encoding.MediaWritable;
import com.aoapps.encoding.Serialization;
import com.aoapps.hodgepodge.i18n.BundleLookupMarkup;
import com.aoapps.hodgepodge.i18n.BundleLookupThreadContext;
import com.aoapps.hodgepodge.i18n.MarkupCoercion;
import com.aoapps.hodgepodge.i18n.MarkupType;
import com.aoapps.lang.Coercion;
import com.aoapps.lang.LocalizedIllegalArgumentException;
import com.aoapps.lang.LocalizedUnsupportedOperationException;
import com.aoapps.lang.function.FunctionE;
import com.aoapps.lang.i18n.Resources;
import com.aoapps.lang.io.function.IOSupplierE;
import com.aoapps.lang.validation.InvalidResult;
import com.aoapps.lang.validation.ValidResult;
import com.aoapps.lang.validation.ValidationResult;
import java.io.IOException;
import java.io.Writer;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ResourceBundle;

/**
 * See <a href="https://www.w3schools.com/tags/ref_attributes.asp">HTML Attributes</a>.
 *
 * @author  AO Industries, Inc.
 */
// TODO: Review which attributes should be trimmed and/or nullIfEmpty
// TODO: Move to a private impl package?
public final class Attributes {

  /** Make no instances. */
  private Attributes() {
    throw new AssertionError();
  }

  public static final Resources RESOURCES = Resources.getResources(ResourceBundle::getBundle, Attributes.class);

  /**
   * Special value used in-place of return values that should result in an empty
   * attribute (expected on {@link Serialization#SGML} only).
   * This distinguishes from a return value of {@code null}, which causes the
   * attribute to not be added at all.
   * <p>
   * In order to never conflict with an actual attribute value, this string is
   * compared by identity, not by value.
   * </p>
   */
  @SuppressWarnings("RedundantStringConstructorCall")
  public static final java.lang.String NO_VALUE = new java.lang.String("<<<NO_VALUE>>>"); // Use string constructor to ensure unique instance for identity comparisons

  /**
   * Marks a method as being an attribute funnel to aid in implementation.
   * A funnel is one of the methods that directly implements the attribute.
   * Non-funnel methods must call directly, or indirectly, funnel methods.
   * All funnel methods must be marked with this annotation.
   * <p>
   * When implementations need to override behavior, such as recording values
   * or checking preconditions, only the funnel methods need to be overridden.
   * </p>
   */
  // TODO: Move to com.aoapps.html.any and use for Factory methods, too?
  @Retention(RetentionPolicy.SOURCE)
  @Target(ElementType.METHOD)
  public static @interface Funnel {
  }

  /**
   * Checks a validation result.
   *
   * @return  The value when valid
   * @throws  IllegalArgumentException  When invalid, supporting {@link LocalizedIllegalArgumentException} when
   *                                    validationResult is an {@link InvalidResult}
   */
  public static <T, Ex extends Throwable> T validate(T value, ValidationResult validationResult)
      throws IllegalArgumentException, Ex {
    if (validationResult.isValid()) {
      return value;
    } else if (validationResult instanceof InvalidResult) {
      InvalidResult invalidResult = (InvalidResult) validationResult;
      throw new LocalizedIllegalArgumentException(
          invalidResult.getResources(),
          invalidResult.getKey(),
          invalidResult.getArgs()
      );
    } else {
      throw new IllegalArgumentException(validationResult.toString());
    }
  }

  /**
   * Validates a value using the provided validator.
   *
   * @param  validator  When {@code null}, no validation is performed.
   *
   * @return  The value when valid
   * @throws  IllegalArgumentException  When invalid, supporting {@link LocalizedIllegalArgumentException} when
   *                                    validationResult is an {@link InvalidResult}
   */
  public static <T, Ex extends Throwable> T validate(T value, FunctionE<? super T, ValidationResult, Ex> validator)
      throws IllegalArgumentException, Ex {
    return (validator == null) ? value : validate(value, validator.apply(value));
  }

  /**
   * Validates that the document type is HTML 5 for the given attribute.
   */
  public static ValidationResult validateInHtml5(AnyDocument<?> document, java.lang.String attrName) {
    Doctype doctype = document.encodingContext.getDoctype();
    if (doctype != Doctype.HTML5) {
      return new InvalidResult(
          RESOURCES,
          "onlySupportedInHtml5",
          doctype,
          attrName
      );
    } else {
      return ValidResult.getInstance();
    }
  }

  /**
   * Validates that the document type is HTML 5 for the given attribute.
   */
  public static ValidationResult validateInHtml5(Element<?, ?, ?> element, java.lang.String attrName) {
    return validateInHtml5(element.getDocument(), attrName);
  }

  /**
   * Enforces that the document type is HTML 5 for the given attribute.
   *
   * @throws  UnsupportedOperationException when {@link EncodingContext#getDoctype()} is not {@link Doctype#HTML5}.
   */
  public static void onlySupportedInHtml5(AnyDocument<?> document, java.lang.String attrName) throws UnsupportedOperationException {
    Doctype doctype = document.encodingContext.getDoctype();
    if (doctype != Doctype.HTML5) {
      throw new LocalizedUnsupportedOperationException(
          RESOURCES,
          "onlySupportedInHtml5",
          doctype,
          attrName
      );
    }
  }

  /**
   * Enforces that the document type is correct for the given global attribute.
   *
   * @throws  UnsupportedOperationException when {@link EncodingContext#getDoctype()} is not {@link Doctype#HTML5}.
   */
  public static ValidationResult invalidGlobalAttributeForDoctype(Element<?, ?, ?> element, Doctype requiredDoctype, java.lang.String attrName) {
    Doctype doctype = element.getDocument().encodingContext.getDoctype();
    if (doctype != requiredDoctype) {
      return new InvalidResult(
          RESOURCES,
          "invalidGlobalAttributeForDoctype",
          doctype,
          requiredDoctype,
          attrName
      );
    } else {
      return ValidResult.getInstance();
    }
  }

  /**
   * See <a href="https://html.spec.whatwg.org/multipage/common-microsyntaxes.html#boolean-attributes">2.4.2 Boolean attributes</a>.
   *
   * @see  com.aoapps.html.any.attributes.bool
   */
  public static final class Boolean {

    /** Make no instances. */
    private Boolean() {
      throw new AssertionError();
    }

    /**
     * @param  <E>        This element type
     * @param  validator  Optional validator, which gets the attribute value only when attribute will be actually written.
     *                    Will not be called when the attribute will be skipped.
     */
    public static <E extends Element<?, ?, E>, Ex extends Throwable> E attribute(
        E element,
        java.lang.String name,
        boolean value,
        FunctionE<? super java.lang.Boolean, ValidationResult, Ex> validator
    ) throws IOException, Ex {
      if (value) {
        validate(value, validator);
        AnyDocument<?> document = element.document;
        @SuppressWarnings("deprecation")
        Writer unsafe = document.getRawUnsafe(null);
        if (document.getAtnl()) {
          document.autoIndent(unsafe, 1);
          document.clearAtnl();
        } else {
          unsafe.append(' ');
        }
        unsafe.write(name);
        Serialization serialization = document.encodingContext.getSerialization();
        if (serialization == Serialization.XML) {
          unsafe.write("=\"");
          unsafe.write(name);
          unsafe.append('"');
        } else {
          assert serialization == Serialization.SGML;
        }
      }
      return element;
    }

    /**
     * @param  <E>  This element type
     */
    public static <E extends Element<?, ?, E>> E attribute(
        E element,
        java.lang.String name,
        boolean value
    ) throws IOException {
      return attribute(element, name, value, null);
    }
  }

  /**
   * See <a href="https://html.spec.whatwg.org/multipage/common-microsyntaxes.html#percentages-and-dimensions">2.4.4.4 Percentages and lengths</a>.
   * <p>
   * Supports Integer length or percentage of parent (HTML 4-only).
   * </p>
   *
   * @see  com.aoapps.html.any.attributes.dimension
   */
  public static final class Dimension {

    /** Make no instances. */
    private Dimension() {
      throw new AssertionError();
    }

    /**
     * @param  <E>        This element type
     * @param  validator  Optional validator, which gets the attribute value only when attribute will be actually written.
     *                    Will not be called when the attribute will be skipped.
     */
    public static <E extends Element<?, ?, E>, Ex extends Throwable> E attribute(
        E element,
        java.lang.String name,
        int pixels,
        FunctionE<? super java.lang.Integer, ValidationResult, Ex> validator
    ) throws IOException, Ex {
      return Integer.attribute(element, name, pixels, validator);
    }

    /**
     * @param  <E>  This element type
     */
    public static <E extends Element<?, ?, E>> E attribute(
        E element,
        java.lang.String name,
        int pixels
    ) throws IOException {
      return Integer.attribute(element, name, pixels);
    }

    /**
     * @param  <E>        This element type
     * @param  validator  Optional validator, which gets the attribute value only when attribute will be actually written.
     *                    Will not be called when the attribute will be skipped.
     */
    public static <E extends Element<?, ?, E>, Ex extends Throwable> E attribute(
        E element,
        java.lang.String name,
        java.lang.Integer pixels,
        FunctionE<? super java.lang.Integer, ValidationResult, Ex> validator
    ) throws IOException, Ex {
      return Integer.attribute(element, name, pixels, validator);
    }

    /**
     * @param  <E>  This element type
     */
    public static <E extends Element<?, ?, E>> E attribute(
        E element,
        java.lang.String name,
        java.lang.Integer pixels
    ) throws IOException {
      return Integer.attribute(element, name, pixels);
    }

    /**
     * @param  <E>        This element type
     * @param  validator  Optional validator, which gets the attribute value only when attribute will be actually written.
     *                    Will not be called when the attribute will be skipped.
     *
     * @deprecated  In HTML 4.01, the value could be defined in pixels or in % of the containing element. In HTML5, the value must be in pixels.
     */
    @Deprecated
    public static <E extends Element<?, ?, E>, Ex1 extends Throwable, Ex2 extends Throwable> E attribute(
        E element,
        java.lang.String name,
        java.lang.String pixelsOrPercent,
        FunctionE<? super java.lang.String, ? extends java.lang.String, Ex1> normalizer,
        FunctionE<? super java.lang.String, ValidationResult, Ex2> validator
    ) throws IOException, Ex1, Ex2 {
      return String.attribute(element, name, MarkupType.NONE, pixelsOrPercent, normalizer, validator);
    }

    /**
     * @param  <E>  This element type
     *
     * @deprecated  In HTML 4.01, the value could be defined in pixels or in % of the containing element. In HTML5, the value must be in pixels.
     */
    @Deprecated
    public static <E extends Element<?, ?, E>, Ex extends Throwable> E attribute(
        E element,
        java.lang.String name,
        java.lang.String pixelsOrPercent,
        FunctionE<? super java.lang.String, ? extends java.lang.String, Ex> normalizer
    ) throws IOException, Ex {
      return String.attribute(element, name, MarkupType.NONE, pixelsOrPercent, normalizer);
    }
  }

  /**
   * See <a href="https://www.w3schools.com/tags/ref_eventattributes.asp">HTML Event Attributes</a>.
   *
   * @see  com.aoapps.html.any.attributes.event
   */
  public static final class Event {

    /** Make no instances. */
    private Event() {
      throw new AssertionError();
    }

    /**
     * @param  <E>        This element type
     * @param  validator  Optional validator, which gets the attribute value only when attribute will be actually written.
     *                    Will not be called when the attribute will be skipped.
     */
    public static <E extends Element<?, ?, E>, Ex1 extends Throwable, Ex2 extends Throwable> E attribute(
        E element,
        java.lang.String name,
        Object script,
        FunctionE<? super Object, ? extends Object, Ex1> normalizer,
        FunctionE<? super Object, ValidationResult, Ex2> validator
    ) throws IOException, Ex1, Ex2 {
      return Attributes.Text.attribute(element, name, MarkupType.JAVASCRIPT, script, normalizer, validator,
          javascriptInXhtmlAttributeEncoder);
    }

    /**
     * @param  <E>  This element type
     */
    public static <E extends Element<?, ?, E>, Ex extends Throwable> E attribute(
        E element,
        java.lang.String name,
        Object script,
        FunctionE<? super Object, ? extends Object, Ex> normalizer
    ) throws IOException, Ex {
      return attribute(element, name, script, normalizer, null);
    }
  }

  /**
   * See <a href="https://html.spec.whatwg.org/multipage/common-microsyntaxes.html#signed-integers">2.4.4.1 Signed integers</a>.
   *
   * @see  com.aoapps.html.any.attributes.integer
   */
  public static final class Integer {

    /** Make no instances. */
    private Integer() {
      throw new AssertionError();
    }

    /**
     * @param  <E>        This element type
     * @param  validator  Optional validator, which gets the attribute value only when attribute will be actually written.
     *                    Will not be called when the attribute will be skipped.
     */
    public static <E extends Element<?, ?, E>, Ex extends Throwable> E attribute(
        E element,
        java.lang.String name,
        int value,
        FunctionE<? super java.lang.Integer, ValidationResult, Ex> validator
    ) throws IOException, Ex {
      validate(value, validator);
      AnyDocument<?> document = element.document;
      @SuppressWarnings("deprecation")
      Writer unsafe = document.getRawUnsafe(null);
      if (document.getAtnl()) {
        document.autoIndent(unsafe, 1);
        document.clearAtnl();
      } else {
        unsafe.append(' ');
      }
      unsafe.write(name);
      unsafe.write("=\"");
      unsafe.write(java.lang.Integer.toString(value));
      unsafe.append('"');
      return element;
    }

    /**
     * @param  <E>  This element type
     */
    public static <E extends Element<?, ?, E>> E attribute(
        E element,
        java.lang.String name,
        int value
    ) throws IOException {
      return attribute(element, name, value, null);
    }

    /**
     * @param  <E>        This element type
     * @param  validator  Optional validator, which gets the attribute value only when attribute will be actually written.
     *                    Will not be called when the attribute will be skipped.
     */
    public static <E extends Element<?, ?, E>, Ex extends Throwable> E attribute(
        E element,
        java.lang.String name,
        java.lang.Integer value,
        FunctionE<? super java.lang.Integer, ValidationResult, Ex> validator
    ) throws IOException, Ex {
      if (value != null) {
        return attribute(element, name, value.intValue(), validator);
      } else {
        return element;
      }
    }

    /**
     * @param  <E>  This element type
     */
    public static <E extends Element<?, ?, E>> E attribute(
        E element,
        java.lang.String name,
        java.lang.Integer value
    ) throws IOException {
      return attribute(element, name, value, null);
    }
  }

  /**
   * Non-streamable text attributes (expected to be short, relatively fixed values).
   */
  public static final class String {

    /** Make no instances. */
    private String() {
      throw new AssertionError();
    }

    /**
     * @param  <E>        This element type
     * @param  value      If is {@link #NO_VALUE} (by identity), will write empty attribute.
     * @param  validator  Optional validator, which gets the attribute value only when attribute will be actually written.
     *                    Will not be called when the attribute will be skipped.
     */
    @SuppressWarnings("StringEquality")
    public static <E extends Element<?, ?, E>, Ex1 extends Throwable, Ex2 extends Throwable> E attribute(
        E element,
        java.lang.String name,
        MarkupType markupType,
        java.lang.String value,
        FunctionE<? super java.lang.String, ? extends java.lang.String, Ex1> normalizer,
        FunctionE<? super java.lang.String, ValidationResult, Ex2> validator
    ) throws IOException, Ex1, Ex2 {
      if (value != null) {
        if (
            // Identity comparison for marker value
            value == NO_VALUE
        ) {
          // Empty attribute
          validate(value, validator);
          AnyDocument<?> document = element.document;
          @SuppressWarnings("deprecation")
          Writer unsafe = document.getRawUnsafe(null);
          if (document.getAtnl()) {
            document.autoIndent(unsafe, 1);
            document.clearAtnl();
          } else {
            unsafe.append(' ');
          }
          unsafe.write(name);
        } else {
          value = normalizer.apply(value);
          // value = value.trim(); // TODO: These trims should all be from Strings?
          if (value != null) {
            validate(value, validator);
            AnyDocument<?> document = element.document;
            @SuppressWarnings("deprecation")
            Writer unsafe = document.getRawUnsafe(null);
            if (document.getAtnl()) {
              document.autoIndent(unsafe, 1);
              document.clearAtnl();
            } else {
              unsafe.append(' ');
            }
            unsafe.write(name);
            unsafe.write("=\"");
            BundleLookupThreadContext threadContext;
            if (
                markupType == null
                    || markupType == MarkupType.NONE
                    || (threadContext = BundleLookupThreadContext.getThreadContext()) == null
            ) {
              // Short-cut additional type checks done by Coercion, since we already have a String
              encodeTextInXhtmlAttribute(value, unsafe);
            } else {
              Writer optimized = Coercion.optimize(unsafe, textInXhtmlAttributeEncoder);
              BundleLookupMarkup lookupMarkup = threadContext.getLookupMarkup(value);
              if (lookupMarkup != null) {
                lookupMarkup.appendPrefixTo(markupType, textInXhtmlAttributeEncoder, optimized);
              }
              encodeTextInXhtmlAttribute(value, optimized);
              if (lookupMarkup != null) {
                lookupMarkup.appendSuffixTo(markupType, textInXhtmlAttributeEncoder, optimized);
              }
            }
            unsafe.append('"');
          }
        }
      }
      return element;
    }

    /**
     * @param  <E>    This element type
     * @param  value  If is {@link #NO_VALUE} (by identity), will write empty attribute.
     */
    public static <E extends Element<?, ?, E>, Ex extends Throwable> E attribute(
        E element,
        java.lang.String name,
        MarkupType markupType,
        java.lang.String value,
        FunctionE<? super java.lang.String, ? extends java.lang.String, Ex> normalizer
    ) throws IOException, Ex {
      return attribute(element, name, markupType, value, normalizer, null);
    }
  }

  /**
   * Streamable text attributes.
   *
   * @see  com.aoapps.html.any.attributes.text
   */
  public static final class Text {

    /** Make no instances. */
    private Text() {
      throw new AssertionError();
    }

    /**
     * @param  <E>        This element type
     * @param  value      The attribute value, {@link Attributes#NO_VALUE} (by identity, not value) for an empty attribute, {@code null} for no attribute.
     * @param  validator  Optional validator, which gets the attribute value only when attribute will be actually written.
     *                    Will not be called when the attribute will be skipped.
     */
    public static <E extends Element<?, ?, E>, Ex1 extends Throwable, Ex2 extends Throwable> E attribute(
        E element,
        java.lang.String name,
        MarkupType markupType,
        Object value,
        FunctionE<? super Object, ? extends Object, Ex1> normalizer,
        FunctionE<? super Object, ValidationResult, Ex2> validator,
        MediaEncoder encoder
    ) throws IOException, Ex1, Ex2 {
      // TODO: Assert is valid attribute name by doctype
      while (value instanceof IOSupplierE<?, ?>) {
        @SuppressWarnings("unchecked")
        IOSupplierE<?, ? extends RuntimeException> supplier = (IOSupplierE<?, ? extends RuntimeException>) value;
        value = supplier.get();
      }
      if (value != null) {
        if (value instanceof MediaWritable<?>) {
          validate(value, validator);
          @SuppressWarnings("unchecked")
          final MediaWritable<? extends RuntimeException> writer = (MediaWritable<? extends RuntimeException>) value;
          AnyDocument<?> document = element.document;
          @SuppressWarnings("deprecation")
          Writer unsafe = document.getRawUnsafe(null);
          if (document.getAtnl()) {
            document.autoIndent(unsafe, 1);
            document.clearAtnl();
          } else {
            unsafe.append(' ');
          }
          unsafe.write(name);
          unsafe.write("=\"");
          writer.writeTo(
              encoder.getValidMediaInputType().newMediaWriter(
                  document.encodingContext,
                  encoder,
                  unsafe,
                  false,
                  null, // Attributes get own indentation scope and settings
                  mediaWriter -> true, // isNoClose
                  null // Ignore close
              )
          );
          unsafe.append('"');
        } else if (
            // Identity comparison for marker value
            value == NO_VALUE
        ) {
          // Empty attribute
          validate(value, validator);
          AnyDocument<?> document = element.document;
          @SuppressWarnings("deprecation")
          Writer unsafe = document.getRawUnsafe(null);
          if (document.getAtnl()) {
            document.autoIndent(unsafe, 1);
            document.clearAtnl();
          } else {
            unsafe.append(' ');
          }
          unsafe.write(name);
          // TODO: When serialization is XML, set equal to attribute name or empty?
        } else {
          value = normalizer.apply(value);
          if (value != null) {
            validate(value, validator);
            AnyDocument<?> document = element.document;
            @SuppressWarnings("deprecation")
            Writer unsafe = document.getRawUnsafe(null);
            if (document.getAtnl()) {
              document.autoIndent(unsafe, 1);
              document.clearAtnl();
            } else {
              unsafe.append(' ');
            }
            unsafe.write(name);
            unsafe.write("=\"");
            MarkupCoercion.write(
                value,
                markupType,
                true,
                encoder,
                false,
                unsafe
            );
            unsafe.append('"');
          }
        }
      }
      return element;
    }

    /**
     * @param  <E>    This element type
     * @param  value  The attribute value, {@link Attributes#NO_VALUE} (by identity, not value) for an empty attribute, {@code null} for no attribute.
     */
    public static <E extends Element<?, ?, E>, Ex extends Throwable> E attribute(
        E element,
        java.lang.String name,
        MarkupType markupType,
        Object value,
        FunctionE<? super Object, ? extends Object, Ex> normalizer,
        MediaEncoder encoder
    ) throws IOException, Ex {
      return attribute(element, name, markupType, value, normalizer, null, encoder);
    }

    /**
     * @param  <E>        This element type
     * @param  values     The attribute values, {@link Attributes#NO_VALUE} (by identity, not value) for an empty attribute, {@code null} for no attribute.
     * @param  separator  The separator to use between non-null values.  Written directly (not through the encoder).
     *                    Not written when a value is {@link Attributes#NO_VALUE}.
     * @param  validator  Optional validator, which gets the attribute value only when attribute will be actually written.
     *                    Will not be called when the attribute will be skipped.
     */
    @SuppressWarnings("AssignmentToForLoopParameter")
    public static <E extends Element<?, ?, E>, Ex1 extends Throwable, Ex2 extends Throwable> E attribute(
        E element,
        java.lang.String name,
        MarkupType markupType,
        Object[] values,
        java.lang.String separator,
        FunctionE<? super Object, ? extends Object, Ex1> normalizer,
        FunctionE<? super Object, ValidationResult, Ex2> validator,
        MediaEncoder encoder
    ) throws IOException, Ex1, Ex2 {
      if (values != null) {
        AnyDocument<?> document = element.document;
        @SuppressWarnings("deprecation")
        Writer unsafe = document.getRawUnsafe(null);
        boolean attr = false;
        boolean val = false;
        for (Object value : values) {
          // TODO: Assert is valid attribute name by doctype
          while (value instanceof IOSupplierE<?, ?>) {
            @SuppressWarnings("unchecked")
            IOSupplierE<?, ? extends RuntimeException> supplier = (IOSupplierE<?, ? extends RuntimeException>) value;
            value = supplier.get();
          }
          if (value != null) {
            if (value instanceof MediaWritable<?>) {
              validate(value, validator);
              @SuppressWarnings("unchecked")
              MediaWritable<? extends RuntimeException> writer = (MediaWritable<? extends RuntimeException>) value;
              if (val) {
                assert attr;
                if (separator != null) {
                  unsafe.write(separator);
                }
              } else {
                if (!attr) {
                  if (document.getAtnl()) {
                    document.autoIndent(unsafe, 1);
                    document.clearAtnl();
                  } else {
                    unsafe.append(' ');
                  }
                  unsafe.write(name);
                  attr = true;
                }
                unsafe.write("=\"");
                val = true;
              }
              writer.writeTo(
                  encoder.getValidMediaInputType().newMediaWriter(
                      document.encodingContext,
                      encoder,
                      unsafe,
                      false,
                      null, // Attributes get own indentation scope and settings
                      mediaWriter -> true, // isNoClose
                      null // Ignore close
                  )
              );
            } else if (
                // Identity comparison for marker value
                value == NO_VALUE
            ) {
              // Empty attribute
              validate(value, validator);
              if (!attr) {
                if (document.getAtnl()) {
                  document.autoIndent(unsafe, 1);
                  document.clearAtnl();
                } else {
                  unsafe.append(' ');
                }
                unsafe.write(name);
                attr = true;
              }
              // TODO: When serialization is XML, set equal to attribute name or empty?
            } else {
              value = normalizer.apply(value);
              if (value != null) {
                validate(value, validator);
                if (val) {
                  assert attr;
                  if (separator != null) {
                    unsafe.write(separator);
                  }
                } else {
                  if (!attr) {
                    if (document.getAtnl()) {
                      document.autoIndent(unsafe, 1);
                      document.clearAtnl();
                    } else {
                      unsafe.append(' ');
                    }
                    unsafe.write(name);
                    attr = true;
                  }
                  unsafe.write("=\"");
                  val = true;
                }
                MarkupCoercion.write(
                    value,
                    markupType,
                    true,
                    encoder,
                    false,
                    unsafe
                );
              }
            }
          }
        }
        if (val) {
          assert attr;
          unsafe.append('"');
        }
      }
      return element;
    }

    /**
     * @param  <E>        This element type
     * @param  values     The attribute values, {@link Attributes#NO_VALUE} (by identity, not value) for an empty attribute, {@code null} for no attribute.
     * @param  separator  The separator to use between non-null values.  Written directly (not through the encoder).
     *                    Not written when a value is {@link Attributes#NO_VALUE}.
     */
    public static <E extends Element<?, ?, E>, Ex extends Throwable> E attribute(
        E element,
        java.lang.String name,
        MarkupType markupType,
        Object[] values,
        java.lang.String separator,
        FunctionE<? super Object, ? extends Object, Ex> normalizer,
        MediaEncoder encoder
    ) throws IOException, Ex {
      return attribute(element, name, markupType, values, separator, normalizer, null, encoder);
    }
  }

  /**
   * URL attributes.
   *
   * @see  com.aoapps.html.any.attributes.url
   */
  // TODO: Encoding URL via encoding context
  public static final class Url {

    /** Make no instances. */
    private Url() {
      throw new AssertionError();
    }

    /**
     * @param  <E>        This element type
     * @param  validator  Optional validator, which gets the attribute value only when attribute will be actually written.
     *                    Will not be called when the attribute will be skipped.
     */
    public static <E extends Element<?, ?, E>, Ex1 extends Throwable, Ex2 extends Throwable> E attribute(
        E element,
        java.lang.String name,
        java.lang.String url,
        FunctionE<? super java.lang.String, ? extends java.lang.String, Ex1> normalizer,
        FunctionE<? super java.lang.String, ValidationResult, Ex2> validator
    ) throws IOException, Ex1, Ex2 {
      if (url != null) {
        url = normalizer.apply(url);
        if (url != null) {
          validate(url, validator);
          AnyDocument<?> document = element.document;
          @SuppressWarnings("deprecation")
          Writer unsafe = document.getRawUnsafe(null);
          if (document.getAtnl()) {
            document.autoIndent(unsafe, 1);
            document.clearAtnl();
          } else {
            unsafe.append(' ');
          }
          unsafe.write(name);
          unsafe.write("=\"");
          // TODO: UrlInXhtmlAttributeEncoder once RFC 3987 supported
          textInXhtmlAttributeEncoder.write(url, unsafe);
          unsafe.append('"');
        }
      }
      return element;
    }

    /**
     * @param  <E>  This element type
     */
    public static <E extends Element<?, ?, E>, Ex extends Throwable> E attribute(
        E element,
        java.lang.String name,
        java.lang.String url,
        FunctionE<? super java.lang.String, ? extends java.lang.String, Ex> normalizer
    ) throws IOException, Ex {
      return attribute(element, name, url, normalizer, null);
    }
  }
}
