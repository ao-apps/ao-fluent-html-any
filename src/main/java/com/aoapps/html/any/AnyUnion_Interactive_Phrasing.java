/*
 * ao-fluent-html-any - Base abstract classes and interfaces for Fluent Java DSL for high-performance HTML generation.
 * Copyright (C) 2021, 2022, 2024, 2025  AO Industries, Inc.
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

import com.aoapps.encoding.TextWritable;
import com.aoapps.lang.io.function.IOConsumerE;
import com.aoapps.lang.io.function.IORunnableE;
import com.aoapps.lang.io.function.IOSupplierE;
import java.io.IOException;

/**
 * Elements that are common to both {@link AnyInteractiveContent} and {@link AnyPhrasingContent}.
 *
 * @param  <D>   This document type
 * @param  <__>  This content model, which will be the parent content model of child elements
 *
 * @author  AO Industries, Inc.
 */
public interface AnyUnion_Interactive_Phrasing<
    D  extends AnyDocument<D>,
    __ extends AnyUnion_Interactive_Phrasing<D, __>
    >
    extends
    //
    // Unions:
    //
    AnyUnion_Embedded_Interactive<D, __> {

  //
  // Content models:
  //
  // Inherited: Content<D, __>

  //
  // Factories:
  //
  // <editor-fold defaultstate="collapsed" desc="A">
  /**
   * Opens a new a element.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/text-level-semantics.html#the-a-element">4.5.1 The a element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/a">&lt;a&gt;: The Anchor element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_a.asp">HTML a tag</a>.</li>
   * </ul>
   */
  @Factory("a")
  AnyA<D, __, ?, ?> a() throws IOException;

  /**
   * Opens a new a element with the given href attribute.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/text-level-semantics.html#the-a-element">4.5.1 The a element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/a">&lt;a&gt;: The Anchor element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_a.asp">HTML a tag</a>.</li>
   * </ul>
   */
  @Factory("a")
  default AnyA<D, __, ?, ?> a(String href) throws IOException {
    return a().href(href);
  }

  /**
   * Opens a new a element with the given href attribute.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/text-level-semantics.html#the-a-element">4.5.1 The a element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/a">&lt;a&gt;: The Anchor element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_a.asp">HTML a tag</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   */
  @Factory("a")
  default <Ex extends Throwable> AnyA<D, __, ?, ?> a(IOSupplierE<String, Ex> href) throws IOException, Ex {
    return a().href(href);
  }

  /**
   * Creates an a element with no attributes and the given body.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/text-level-semantics.html#the-a-element">4.5.1 The a element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/a">&lt;a&gt;: The Anchor element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_a.asp">HTML a tag</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @return  This content model, which will be the parent content model of child elements
   */
  @Factory("a")
  default <Ex extends Throwable> __ a__(IORunnableE<Ex> a) throws IOException, Ex {
    return a().__(a);
  }

  /**
   * Creates an a element with no attributes and the given body.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/text-level-semantics.html#the-a-element">4.5.1 The a element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/a">&lt;a&gt;: The Anchor element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_a.asp">HTML a tag</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @return  This content model, which will be the parent content model of child elements
   */
  // TODO: How to limit content to not have interactive elements?
  @Factory("a")
  default <Ex extends Throwable> __ a__(IOConsumerE<? super __, Ex> a) throws IOException, Ex {
    return a().__(a);
  }

  /**
   * Creates an a element with no attributes and a text body.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/text-level-semantics.html#the-a-element">4.5.1 The a element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/a">&lt;a&gt;: The Anchor element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_a.asp">HTML a tag</a>.</li>
   * </ul>
   *
   * <p>Since {@link AnyTextContent} is not a part of {@link AnyUnion_Interactive_Phrasing},
   * strictly speaking text is not allowed in all possible content models that can apply to <code>&lt;a&gt;</code>.
   * However, since it is such a common operation, we've added it here.</p>
   *
   * @return  This content model, which will be the parent content model of child elements
   *
   * @throws  IllegalStateException when {@code text != null} and current content model does not allow text
   */
  @Factory("a")
  default __ a__(Object text) throws IOException, IllegalStateException {
    return a().__(text);
  }

  /**
   * Creates an empty a element with no attributes.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/text-level-semantics.html#the-a-element">4.5.1 The a element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/a">&lt;a&gt;: The Anchor element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_a.asp">HTML a tag</a>.</li>
   * </ul>
   *
   * @return  This content model, which will be the parent content model of child elements
   */
  @Factory("a")
  default __ a__() throws IOException {
    return a().__();
  }

  /**
   * Creates an a element with no attributes then begins element content.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/text-level-semantics.html#the-a-element">4.5.1 The a element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/a">&lt;a&gt;: The Anchor element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_a.asp">HTML a tag</a>.</li>
   * </ul>
   *
   * @return  The content model of this element, which will be the parent content model of child elements.
   *          This must be {@linkplain Closeable#__() ended} or {@linkplain Closeable#close() closed} in order to end
   *          the tag.  This is well suited for use in a try-with-resources block.
   *
   *          <p>Due to limitations in Java generics, this content model does not directly reflect the parent content
   *          model, despite this being a transparent content model.  Rather, it includes only the content model that
   *          always applies to this element type.</p>
   *
   *          <p><em>For the full, context-aware content model, which will likely include more elements,
   *          {@linkplain Transparent_c#pc() use the parent content model directly}.</em></p>
   *
   * @see  Closeable#__()
   * @see  Closeable#close()
   * @see  Transparent_c#pc()
   */
  @Factory("a")
  AnyA_c<D, __, ?> a_c() throws IOException;

  // </editor-fold>
  // Inherited: AUDIO
  // <editor-fold defaultstate="collapsed" desc="BUTTON">
  /**
   * Opens a new button element.
   *
   * <p>See <a href="https://html.spec.whatwg.org/multipage/form-elements.html#the-button-element">4.10.6 The button element</a>.</p>
   *
   * @deprecated  TODO: Implement button
   */
  @Deprecated(forRemoval = false)
  @Factory("button")
  default AnyBUTTON button() throws IOException {
    throw new AssertionError("TODO: Implement button");
  }

  // </editor-fold>
  // Inherited: EMBED
  // <editor-fold defaultstate="collapsed" desc="INPUT">
  /**
   * Specialized input implementations.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/input.html#the-input-element">4.10.5 The input element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input">&lt;input&gt;: The Input (Form Input) element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_input.asp">HTML input tag</a>.</li>
   * </ul>
   *
   * @param  <D>   This document type
   * @param  <__>  This content model, which will be the parent content model of child elements
   */
  public abstract static class InputFactory<
      D  extends AnyDocument<D>,
      __ extends AnyUnion_Interactive_Phrasing<D, __>
      > {

    protected final D document;
    protected final __ pc;

    protected InputFactory(D document, __ pc) {
      this.document = document;
      this.pc = pc;
    }

    /**
     * <ul>
     * <li>See <a href="https://html.spec.whatwg.org/multipage/input.html#the-input-element">4.10.5 The input element</a>.</li>
     * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input">&lt;input&gt;: The Input (Form Input) element</a>.</li>
     * <li>See <a href="https://www.w3schools.com/tags/tag_input.asp">HTML input tag</a>.</li>
     * </ul>
     */
    public abstract AnyINPUT.Dynamic<D, __, ?> dynamic() throws IOException;

    /**
     * <ul>
     * <li>See <a href="https://html.spec.whatwg.org/multipage/input.html#the-input-element">4.10.5 The input element</a>.</li>
     * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input">&lt;input&gt;: The Input (Form Input) element</a>.</li>
     * <li>See <a href="https://www.w3schools.com/tags/tag_input.asp">HTML input tag</a>.</li>
     * <li>See <a href="https://www.w3schools.com/tags/att_input_type.asp">HTML input type Attribute</a>.</li>
     * </ul>
     */
    public abstract AnyINPUT.Dynamic<D, __, ?> dynamic(String type) throws IOException;

    /**
     * <ul>
     * <li>See <a href="https://html.spec.whatwg.org/multipage/input.html#the-input-element">4.10.5 The input element</a>.</li>
     * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input">&lt;input&gt;: The Input (Form Input) element</a>.</li>
     * <li>See <a href="https://www.w3schools.com/tags/tag_input.asp">HTML input tag</a>.</li>
     * <li>See <a href="https://www.w3schools.com/tags/att_input_type.asp">HTML input type Attribute</a>.</li>
     * </ul>
     *
     * @param  <Ex>  An arbitrary exception type that may be thrown
     */
    // TODO: Move these type Input.type only?
    public <Ex extends Throwable> AnyINPUT.Dynamic<D, __, ?> dynamic(Suppliers.String<Ex> type) throws IOException, Ex {
      return dynamic((type == null) ? null : type.get());
    }

    /**
     * <ul>
     * <li>See <a href="https://html.spec.whatwg.org/multipage/input.html#the-input-element">4.10.5 The input element</a>.</li>
     * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input">&lt;input&gt;: The Input (Form Input) element</a>.</li>
     * <li>See <a href="https://www.w3schools.com/tags/tag_input.asp">HTML input tag</a>.</li>
     * <li>See <a href="https://www.w3schools.com/tags/att_input_type.asp">HTML input type Attribute</a>.</li>
     * </ul>
     */
    public abstract AnyINPUT.Dynamic<D, __, ?> dynamic(AnyINPUT.Dynamic.Type type) throws IOException;

    /**
     * <ul>
     * <li>See <a href="https://html.spec.whatwg.org/multipage/input.html#the-input-element">4.10.5 The input element</a>.</li>
     * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input">&lt;input&gt;: The Input (Form Input) element</a>.</li>
     * <li>See <a href="https://www.w3schools.com/tags/tag_input.asp">HTML input tag</a>.</li>
     * <li>See <a href="https://www.w3schools.com/tags/att_input_type.asp">HTML input type Attribute</a>.</li>
     * </ul>
     *
     * @param  <Ex>  An arbitrary exception type that may be thrown
     */
    // TODO: Move these type Input.type only?
    public <Ex extends Throwable> AnyINPUT.Dynamic<D, __, ?> dynamic(IOSupplierE<AnyINPUT.Dynamic.Type, Ex> type) throws IOException, Ex {
      return dynamic((type == null) ? null : type.get());
    }

    /**
     * <ul>
     * <li>See <a href="https://html.spec.whatwg.org/multipage/input.html#the-input-element">4.10.5 The input element</a>.</li>
     * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input">&lt;input&gt;: The Input (Form Input) element</a>.</li>
     * <li>See <a href="https://www.w3schools.com/tags/tag_input.asp">HTML input tag</a>.</li>
     * <li>See <a href="https://www.w3schools.com/tags/att_input_type_button.asp">HTML input type="button"</a>.</li>
     * </ul>
     */
    public abstract AnyINPUT.Button<D, __, ?> button() throws IOException;

    /**
     * <ul>
     * <li>See <a href="https://html.spec.whatwg.org/multipage/input.html#the-input-element">4.10.5 The input element</a>.</li>
     * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input">&lt;input&gt;: The Input (Form Input) element</a>.</li>
     * <li>See <a href="https://www.w3schools.com/tags/tag_input.asp">HTML input tag</a>.</li>
     * <li>See <a href="https://www.w3schools.com/tags/att_input_type_checkbox.asp">HTML input type="checkbox"</a>.</li>
     * </ul>
     */
    public abstract AnyINPUT.Checkbox<D, __, ?> checkbox() throws IOException;

    /**
     * <ul>
     * <li>See <a href="https://html.spec.whatwg.org/multipage/input.html#the-input-element">4.10.5 The input element</a>.</li>
     * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input">&lt;input&gt;: The Input (Form Input) element</a>.</li>
     * <li>See <a href="https://www.w3schools.com/tags/tag_input.asp">HTML input tag</a>.</li>
     * <li>See <a href="https://www.w3schools.com/tags/att_input_type_color.asp">HTML input type="color"</a>.</li>
     * </ul>
     */
    public abstract AnyINPUT.Color<D, __, ?> color() throws IOException;

    /**
     * <ul>
     * <li>See <a href="https://html.spec.whatwg.org/multipage/input.html#the-input-element">4.10.5 The input element</a>.</li>
     * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input">&lt;input&gt;: The Input (Form Input) element</a>.</li>
     * <li>See <a href="https://www.w3schools.com/tags/tag_input.asp">HTML input tag</a>.</li>
     * <li>See <a href="https://www.w3schools.com/tags/att_input_type_date.asp">HTML input type="date"</a>.</li>
     * </ul>
     */
    public abstract AnyINPUT.Date<D, __, ?> date() throws IOException;

    /**
     * <ul>
     * <li>See <a href="https://html.spec.whatwg.org/multipage/input.html#the-input-element">4.10.5 The input element</a>.</li>
     * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input">&lt;input&gt;: The Input (Form Input) element</a>.</li>
     * <li>See <a href="https://www.w3schools.com/tags/tag_input.asp">HTML input tag</a>.</li>
     * <li>See <a href="https://www.w3schools.com/tags/att_input_type_datetime-local.asp">HTML input type="datetime-local"</a>.</li>
     * </ul>
     */
    public abstract AnyINPUT.DatetimeLocal<D, __, ?> datetimeLocal() throws IOException;

    /**
     * <ul>
     * <li>See <a href="https://html.spec.whatwg.org/multipage/input.html#the-input-element">4.10.5 The input element</a>.</li>
     * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input">&lt;input&gt;: The Input (Form Input) element</a>.</li>
     * <li>See <a href="https://www.w3schools.com/tags/tag_input.asp">HTML input tag</a>.</li>
     * <li>See <a href="https://www.w3schools.com/tags/att_input_type_email.asp">HTML input type="email"</a>.</li>
     * </ul>
     */
    public abstract AnyINPUT.Email<D, __, ?> email() throws IOException;

    /**
     * <ul>
     * <li>See <a href="https://html.spec.whatwg.org/multipage/input.html#the-input-element">4.10.5 The input element</a>.</li>
     * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input">&lt;input&gt;: The Input (Form Input) element</a>.</li>
     * <li>See <a href="https://www.w3schools.com/tags/tag_input.asp">HTML input tag</a>.</li>
     * <li>See <a href="https://www.w3schools.com/tags/att_input_type_file.asp">HTML input type="file"</a>.</li>
     * </ul>
     */
    public abstract AnyINPUT.File<D, __, ?> file() throws IOException;

    /**
     * <ul>
     * <li>See <a href="https://html.spec.whatwg.org/multipage/input.html#the-input-element">4.10.5 The input element</a>.</li>
     * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input">&lt;input&gt;: The Input (Form Input) element</a>.</li>
     * <li>See <a href="https://www.w3schools.com/tags/tag_input.asp">HTML input tag</a>.</li>
     * <li>See <a href="https://www.w3schools.com/tags/att_input_type_hidden.asp">HTML input type="hidden"</a>.</li>
     * </ul>
     */
    public abstract AnyINPUT.Hidden<D, __, ?> hidden() throws IOException;

    /**
     * <ul>
     * <li>See <a href="https://html.spec.whatwg.org/multipage/input.html#the-input-element">4.10.5 The input element</a>.</li>
     * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input">&lt;input&gt;: The Input (Form Input) element</a>.</li>
     * <li>See <a href="https://www.w3schools.com/tags/tag_input.asp">HTML input tag</a>.</li>
     * <li>See <a href="https://www.w3schools.com/tags/att_input_type_image.asp">HTML input type="image"</a>.</li>
     * </ul>
     */
    public abstract AnyINPUT.Image<D, __, ?> image() throws IOException;

    /**
     * <ul>
     * <li>See <a href="https://html.spec.whatwg.org/multipage/input.html#the-input-element">4.10.5 The input element</a>.</li>
     * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input">&lt;input&gt;: The Input (Form Input) element</a>.</li>
     * <li>See <a href="https://www.w3schools.com/tags/tag_input.asp">HTML input tag</a>.</li>
     * <li>See <a href="https://www.w3schools.com/tags/att_input_type_month.asp">HTML input type="month"</a>.</li>
     * </ul>
     */
    public abstract AnyINPUT.Month<D, __, ?> month() throws IOException;

    /**
     * <ul>
     * <li>See <a href="https://html.spec.whatwg.org/multipage/input.html#the-input-element">4.10.5 The input element</a>.</li>
     * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input">&lt;input&gt;: The Input (Form Input) element</a>.</li>
     * <li>See <a href="https://www.w3schools.com/tags/tag_input.asp">HTML input tag</a>.</li>
     * <li>See <a href="https://www.w3schools.com/tags/att_input_type_number.asp">HTML input type="number"</a>.</li>
     * </ul>
     */
    public abstract AnyINPUT.Number<D, __, ?> number() throws IOException;

    /**
     * <ul>
     * <li>See <a href="https://html.spec.whatwg.org/multipage/input.html#the-input-element">4.10.5 The input element</a>.</li>
     * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input">&lt;input&gt;: The Input (Form Input) element</a>.</li>
     * <li>See <a href="https://www.w3schools.com/tags/tag_input.asp">HTML input tag</a>.</li>
     * <li>See <a href="https://www.w3schools.com/tags/att_input_type_password.asp">HTML input type="password"</a>.</li>
     * </ul>
     */
    public abstract AnyINPUT.Password<D, __, ?> password() throws IOException;

    /**
     * <ul>
     * <li>See <a href="https://html.spec.whatwg.org/multipage/input.html#the-input-element">4.10.5 The input element</a>.</li>
     * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input">&lt;input&gt;: The Input (Form Input) element</a>.</li>
     * <li>See <a href="https://www.w3schools.com/tags/tag_input.asp">HTML input tag</a>.</li>
     * <li>See <a href="https://www.w3schools.com/tags/att_input_type_radio.asp">HTML input type="radio"</a>.</li>
     * </ul>
     */
    public abstract AnyINPUT.Radio<D, __, ?> radio() throws IOException;

    /**
     * <ul>
     * <li>See <a href="https://html.spec.whatwg.org/multipage/input.html#the-input-element">4.10.5 The input element</a>.</li>
     * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input">&lt;input&gt;: The Input (Form Input) element</a>.</li>
     * <li>See <a href="https://www.w3schools.com/tags/tag_input.asp">HTML input tag</a>.</li>
     * <li>See <a href="https://www.w3schools.com/tags/att_input_type_range.asp">HTML input type="range"</a>.</li>
     * </ul>
     */
    public abstract AnyINPUT.Range<D, __, ?> range() throws IOException;

    /**
     * <ul>
     * <li>See <a href="https://html.spec.whatwg.org/multipage/input.html#the-input-element">4.10.5 The input element</a>.</li>
     * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input">&lt;input&gt;: The Input (Form Input) element</a>.</li>
     * <li>See <a href="https://www.w3schools.com/tags/tag_input.asp">HTML input tag</a>.</li>
     * <li>See <a href="https://www.w3schools.com/tags/att_input_type_reset.asp">HTML input type="reset"</a>.</li>
     * </ul>
     */
    public abstract AnyINPUT.Reset<D, __, ?> reset() throws IOException;

    /**
     * <ul>
     * <li>See <a href="https://html.spec.whatwg.org/multipage/input.html#the-input-element">4.10.5 The input element</a>.</li>
     * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input">&lt;input&gt;: The Input (Form Input) element</a>.</li>
     * <li>See <a href="https://www.w3schools.com/tags/tag_input.asp">HTML input tag</a>.</li>
     * <li>See <a href="https://www.w3schools.com/tags/att_input_type_search.asp">HTML input type="search"</a>.</li>
     * </ul>
     */
    public abstract AnyINPUT.Search<D, __, ?> search() throws IOException;

    /**
     * <ul>
     * <li>See <a href="https://html.spec.whatwg.org/multipage/input.html#the-input-element">4.10.5 The input element</a>.</li>
     * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input">&lt;input&gt;: The Input (Form Input) element</a>.</li>
     * <li>See <a href="https://www.w3schools.com/tags/tag_input.asp">HTML input tag</a>.</li>
     * <li>See <a href="https://www.w3schools.com/tags/att_input_type_submit.asp">HTML input type="submit"</a>.</li>
     * </ul>
     */
    public abstract AnyINPUT.Submit<D, __, ?> submit() throws IOException;

    /**
     * <ul>
     * <li>See <a href="https://html.spec.whatwg.org/multipage/input.html#the-input-element">4.10.5 The input element</a>.</li>
     * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input">&lt;input&gt;: The Input (Form Input) element</a>.</li>
     * <li>See <a href="https://www.w3schools.com/tags/tag_input.asp">HTML input tag</a>.</li>
     * <li>See <a href="https://www.w3schools.com/tags/att_input_type_submit.asp">HTML input type="submit"</a>.</li>
     * <li>See <a href="https://www.w3schools.com/tags/att_input_value.asp">HTML input value Attribute</a>.</li>
     * </ul>
     *
     * @return  This content model, which will be the parent content model of child elements
     */
    public __ submit__(Object value) throws IOException {
      return submit().value(value).__();
    }

    /**
     * <ul>
     * <li>See <a href="https://html.spec.whatwg.org/multipage/input.html#the-input-element">4.10.5 The input element</a>.</li>
     * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input">&lt;input&gt;: The Input (Form Input) element</a>.</li>
     * <li>See <a href="https://www.w3schools.com/tags/tag_input.asp">HTML input tag</a>.</li>
     * <li>See <a href="https://www.w3schools.com/tags/att_input_type_submit.asp">HTML input type="submit"</a>.</li>
     * <li>See <a href="https://www.w3schools.com/tags/att_input_value.asp">HTML input value Attribute</a>.</li>
     * </ul>
     *
     * @param  <Ex>  An arbitrary exception type that may be thrown
     *
     * @return  This content model, which will be the parent content model of child elements
     */
    public <Ex extends Throwable> __ submit__(IOSupplierE<?, Ex> value) throws IOException, Ex {
      return submit().value(value).__();
    }

    /**
     * <ul>
     * <li>See <a href="https://html.spec.whatwg.org/multipage/input.html#the-input-element">4.10.5 The input element</a>.</li>
     * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input">&lt;input&gt;: The Input (Form Input) element</a>.</li>
     * <li>See <a href="https://www.w3schools.com/tags/tag_input.asp">HTML input tag</a>.</li>
     * <li>See <a href="https://www.w3schools.com/tags/att_input_type_submit.asp">HTML input type="submit"</a>.</li>
     * <li>See <a href="https://www.w3schools.com/tags/att_input_value.asp">HTML input value Attribute</a>.</li>
     * </ul>
     *
     * @param  <Ex>  An arbitrary exception type that may be thrown
     *
     * @return  This content model, which will be the parent content model of child elements
     */
    public <Ex extends Throwable> __ submit__(TextWritable<Ex> value) throws IOException, Ex {
      return submit().value(value).__();
    }

    /**
     * <ul>
     * <li>See <a href="https://html.spec.whatwg.org/multipage/input.html#the-input-element">4.10.5 The input element</a>.</li>
     * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input">&lt;input&gt;: The Input (Form Input) element</a>.</li>
     * <li>See <a href="https://www.w3schools.com/tags/tag_input.asp">HTML input tag</a>.</li>
     * <li>See <a href="https://www.w3schools.com/tags/att_input_type_tel.asp">HTML input type="tel"</a>.</li>
     * </ul>
     */
    public abstract AnyINPUT.Tel<D, __, ?> tel() throws IOException;

    /**
     * <ul>
     * <li>See <a href="https://html.spec.whatwg.org/multipage/input.html#the-input-element">4.10.5 The input element</a>.</li>
     * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input">&lt;input&gt;: The Input (Form Input) element</a>.</li>
     * <li>See <a href="https://www.w3schools.com/tags/tag_input.asp">HTML input tag</a>.</li>
     * <li>See <a href="https://www.w3schools.com/tags/att_input_type_text.asp">HTML input type="text"</a>.</li>
     * </ul>
     */
    public abstract AnyINPUT.Text<D, __, ?> text() throws IOException;

    /**
     * <ul>
     * <li>See <a href="https://html.spec.whatwg.org/multipage/input.html#the-input-element">4.10.5 The input element</a>.</li>
     * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input">&lt;input&gt;: The Input (Form Input) element</a>.</li>
     * <li>See <a href="https://www.w3schools.com/tags/tag_input.asp">HTML input tag</a>.</li>
     * <li>See <a href="https://www.w3schools.com/tags/att_input_type_time.asp">HTML input type="time"</a>.</li>
     * </ul>
     */
    public abstract AnyINPUT.Time<D, __, ?> time() throws IOException;

    /**
     * <ul>
     * <li>See <a href="https://html.spec.whatwg.org/multipage/input.html#the-input-element">4.10.5 The input element</a>.</li>
     * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input">&lt;input&gt;: The Input (Form Input) element</a>.</li>
     * <li>See <a href="https://www.w3schools.com/tags/tag_input.asp">HTML input tag</a>.</li>
     * <li>See <a href="https://www.w3schools.com/tags/att_input_type_url.asp">HTML input type="url"</a>.</li>
     * </ul>
     */
    public abstract AnyINPUT.Url<D, __, ?> url() throws IOException;

    /**
     * <ul>
     * <li>See <a href="https://html.spec.whatwg.org/multipage/input.html#the-input-element">4.10.5 The input element</a>.</li>
     * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input">&lt;input&gt;: The Input (Form Input) element</a>.</li>
     * <li>See <a href="https://www.w3schools.com/tags/tag_input.asp">HTML input tag</a>.</li>
     * <li>See <a href="https://www.w3schools.com/tags/att_input_type_week.asp">HTML input type="week"</a>.</li>
     * </ul>
     */
    public abstract AnyINPUT.Week<D, __, ?> week() throws IOException;
  }

  /**
   * Specialized input implementations.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/input.html#the-input-element">4.10.5 The input element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input">&lt;input&gt;: The Input (Form Input) element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_input.asp">HTML input tag</a>.</li>
   * </ul>
   */
  @Factory("input")
  InputFactory<D, __> input();

  // </editor-fold>
  // Inherited: IFRAME
  // Inherited: IMG
  // <editor-fold defaultstate="collapsed" desc="LABEL">
  /**
   * Opens a new label element.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/forms.html#the-label-element">4.10.4 The label element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/label">&lt;label&gt;: The Input Label element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_label.asp">HTML label tag</a>.</li>
   * </ul>
   */
  @Factory("label")
  AnyLABEL<D, __, ?, ?, ?> label() throws IOException;

  // TODO: Shortcuts for "for" attribute, like a:href

  /**
   * Creates a label element with no attributes and the given body.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/forms.html#the-label-element">4.10.4 The label element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/label">&lt;label&gt;: The Input Label element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_label.asp">HTML label tag</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @return  This content model, which will be the parent content model of child elements
   */
  @Factory("label")
  default <Ex extends Throwable> __ label__(IORunnableE<Ex> label) throws IOException, Ex {
    return label().__(label);
  }

  /**
   * Creates a label element with no attributes and the given body.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/forms.html#the-label-element">4.10.4 The label element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/label">&lt;label&gt;: The Input Label element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_label.asp">HTML label tag</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @return  This content model, which will be the parent content model of child elements
   */
  @Factory("label")
  default <Ex extends Throwable> __ label__any(IOConsumerE<? super AnyLABEL__<D, __, ? extends AnyLABEL__<D, __, ?>>, Ex> label) throws IOException, Ex {
    return label().__(label);
  }

  /**
   * Creates a label element with no attributes and a text body.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/forms.html#the-label-element">4.10.4 The label element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/label">&lt;label&gt;: The Input Label element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_label.asp">HTML label tag</a>.</li>
   * </ul>
   *
   * @return  This content model, which will be the parent content model of child elements
   */
  @Factory("label")
  default __ label__(Object text) throws IOException {
    return label().__(text);
  }

  /**
   * Creates an empty label element with no attributes.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/forms.html#the-label-element">4.10.4 The label element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/label">&lt;label&gt;: The Input Label element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_label.asp">HTML label tag</a>.</li>
   * </ul>
   *
   * @return  This content model, which will be the parent content model of child elements
   */
  @Factory("label")
  default __ label__() throws IOException {
    return label().__();
  }

  /**
   * Creates a label element with no attributes then begins element content.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/forms.html#the-label-element">4.10.4 The label element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/label">&lt;label&gt;: The Input Label element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_label.asp">HTML label tag</a>.</li>
   * </ul>
   *
   * @return  The content model of this element, which will be the parent content model of child elements.
   *          This must be {@linkplain Closeable#__() ended} or {@linkplain Closeable#close() closed} in order to end
   *          the tag.  This is well suited for use in a try-with-resources block.
   *
   * @see  Closeable#__()
   * @see  Closeable#close()
   */
  @Factory("label")
  AnyLABEL_c<D, __, ?> label_c() throws IOException;

  // </editor-fold>
  // Inherited: OBJECT
  // <editor-fold defaultstate="collapsed" desc="SELECT">
  /**
   * Opens a new select element.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/form-elements.html#the-select-element">4.10.7 The select element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/select">&lt;section&gt;: The HTML Select element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_select.asp">HTML select tag</a>.</li>
   * </ul>
   */
  @Factory("select")
  AnySELECT<D, __, ?, ?, ?> select() throws IOException;

  /**
   * Creates a select element with no attributes and the given body.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/form-elements.html#the-select-element">4.10.7 The select element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/select">&lt;section&gt;: The HTML Select element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_select.asp">HTML select tag</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @return  This content model, which will be the parent content model of child elements
   */
  @Factory("select")
  default <Ex extends Throwable> __ select__(IORunnableE<Ex> select) throws IOException, Ex {
    return select().__(select);
  }

  /**
   * Creates a select element with no attributes and the given body.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/form-elements.html#the-select-element">4.10.7 The select element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/select">&lt;section&gt;: The HTML Select element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_select.asp">HTML select tag</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @return  This content model, which will be the parent content model of child elements
   */
  @Factory("select")
  default <Ex extends Throwable> __ select__any(IOConsumerE<? super AnySELECT__<D, __, ? extends AnySELECT__<D, __, ?>>, Ex> select) throws IOException, Ex {
    return select().__(select);
  }

  /**
   * Creates an empty select element with no attributes.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/form-elements.html#the-select-element">4.10.7 The select element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/select">&lt;section&gt;: The HTML Select element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_select.asp">HTML select tag</a>.</li>
   * </ul>
   *
   * @return  This content model, which will be the parent content model of child elements
   */
  @Factory("select")
  default __ select__() throws IOException {
    return select().__();
  }

  /**
   * Creates a select element with no attributes then begins element content.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/form-elements.html#the-select-element">4.10.7 The select element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/select">&lt;section&gt;: The HTML Select element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_select.asp">HTML select tag</a>.</li>
   * </ul>
   *
   * @return  The content model of this element, which will be the parent content model of child elements.
   *          This must be {@linkplain Closeable#__() ended} or {@linkplain Closeable#close() closed} in order to end
   *          the tag.  This is well suited for use in a try-with-resources block.
   *
   * @see  Closeable#__()
   * @see  Closeable#close()
   */
  @Factory("select")
  AnySELECT_c<D, __, ?> select_c() throws IOException;

  // </editor-fold>
  // <editor-fold defaultstate="collapsed" desc="TEXTAREA">
  /**
   * Opens a new textarea element.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/form-elements.html#the-textarea-element">4.10.11 The textarea element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/textarea">&lt;textarea&gt;: The Textarea element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_textarea.asp">HTML textarea tag</a>.</li>
   * </ul>
   */
  @Factory("textarea")
  AnyTEXTAREA<D, __, ?, ?, ?> textarea() throws IOException;

  /**
   * Creates a textarea element with no attributes and the given body.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/form-elements.html#the-textarea-element">4.10.11 The textarea element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/textarea">&lt;textarea&gt;: The Textarea element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_textarea.asp">HTML textarea tag</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @return  This content model, which will be the parent content model of child elements
   */
  @Factory("textarea")
  default <Ex extends Throwable> __ textarea__(IORunnableE<Ex> textarea) throws IOException, Ex {
    return textarea().__(textarea);
  }

  /**
   * Creates a textarea element with no attributes and the given body.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/form-elements.html#the-textarea-element">4.10.11 The textarea element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/textarea">&lt;textarea&gt;: The Textarea element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_textarea.asp">HTML textarea tag</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @return  This content model, which will be the parent content model of child elements
   */
  @Factory("textarea")
  default <Ex extends Throwable> __ textarea__any(IOConsumerE<? super AnyTEXTAREA__<D, __, ? extends AnyTEXTAREA__<D, __, ?>>, Ex> textarea) throws IOException, Ex {
    return textarea().__(textarea);
  }

  /**
   * Creates a textarea element with no attributes and a text body.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/form-elements.html#the-textarea-element">4.10.11 The textarea element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/textarea">&lt;textarea&gt;: The Textarea element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_textarea.asp">HTML textarea tag</a>.</li>
   * </ul>
   *
   * @return  This content model, which will be the parent content model of child elements
   */
  @Factory("textarea")
  default __ textarea__(Object text) throws IOException {
    return textarea().__(text);
  }

  /**
   * Creates an empty textarea element with no attributes.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/form-elements.html#the-textarea-element">4.10.11 The textarea element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/textarea">&lt;textarea&gt;: The Textarea element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_textarea.asp">HTML textarea tag</a>.</li>
   * </ul>
   *
   * @return  This content model, which will be the parent content model of child elements
   */
  @Factory("textarea")
  default __ textarea__() throws IOException {
    return textarea().__();
  }

  /**
   * Creates a textarea element with no attributes then begins element content.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/form-elements.html#the-textarea-element">4.10.11 The textarea element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/textarea">&lt;textarea&gt;: The Textarea element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_textarea.asp">HTML textarea tag</a>.</li>
   * </ul>
   *
   * @return  The content model of this element, which will be the parent content model of child elements.
   *          This must be {@linkplain Closeable#__() ended} or {@linkplain Closeable#close() closed} in order to end
   *          the tag.  This is well suited for use in a try-with-resources block.
   *
   * @see  Closeable#__()
   * @see  Closeable#close()
   */
  @Factory("textarea")
  AnyTEXTAREA_c<D, __, ?> textarea_c() throws IOException;
  // </editor-fold>
  // Inherited: VIDEO
}
