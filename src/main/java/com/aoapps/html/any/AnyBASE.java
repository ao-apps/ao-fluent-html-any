/*
 * ao-fluent-html-any - Base abstract classes and interfaces for Fluent Java DSL for high-performance HTML generation.
 * Copyright (C) 2020, 2021, 2022, 2025  AO Industries, Inc.
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

import java.io.IOException;
import java.io.Writer;

/**
 * <ul>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/semantics.html#the-base-element">4.2.3 The base element</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/base">&lt;base&gt;: The Document Base URL element</a>.</li>
 * <li>See <a href="https://www.w3schools.com/tags/tag_base.asp">HTML base tag</a>.</li>
 * </ul>
 *
 * @param  <D>   This document type
 * @param  <PC>  The parent content model this element is within
 * @param  <E>   This element type
 *
 * @author  AO Industries, Inc.
 */
@SuppressWarnings("deprecation")
public abstract class AnyBASE<
    D  extends AnyDocument<D>,
    PC extends AnyMetadataContent<D, PC>,
    E  extends AnyBASE<D, PC, E>
    >
    extends Void<D, PC, E> implements
    com.aoapps.html.any.attributes.url.Href<E>,
    com.aoapps.html.any.attributes.enumeration.Target<E, com.aoapps.html.any.attributes.enumeration.Target.Value>,
    // Global Attributes overrides
    com.aoapps.html.any.attributes.text.AccesskeyUnexpected<E>,
    com.aoapps.html.any.attributes.bool.AutofocusUnexpected<E>,
    com.aoapps.html.any.attributes.enumeration.DirUnexpected<E>,
    com.aoapps.html.any.attributes.text.ClassNoHtml4<E>,
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

  protected AnyBASE(D document, PC pc) {
    super(document, pc);
  }

  @Override
  protected void writeOpen(Writer unsafe) throws IOException {
    document.autoNli(unsafe).unsafe(unsafe, "<base", false);
  }

  @Override
  protected void doAfterElement(Writer unsafe) throws IOException {
    document.autoNl(unsafe);
  }
}
