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

/**
 * <ul>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/sections.html#the-article-element">4.3.2 The article element</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/article">&lt;article&gt;: The Article Contents element</a>.</li>
 * <li>See <a href="https://www.w3schools.com/tags/tag_article.asp">HTML article Tag</a>.</li>
 * </ul>
 *
 * @param  <D>   This document type
 * @param  <PC>  The parent content model this element is within
 * @param  <__>  This content model, which will be the parent content model of child elements
 *
 * @since HTML 5
 *
 * @author  AO Industries, Inc.
 */
public abstract class AnyARTICLE__<
    D  extends AnyDocument<D>,
    PC extends AnySectioningContent<D, PC>,
    __ extends AnyARTICLE__<D, PC, __>
    >
    extends NormalText__<D, PC, __>
    implements AnyFlowContent<D, __> {

  protected AnyARTICLE__(AnyARTICLE<D, PC, ?, __, ?> element) {
    super(element);
  }
}
