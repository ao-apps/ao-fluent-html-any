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

import com.aoapps.lang.io.function.IOConsumerE;
import com.aoapps.lang.io.function.IORunnableE;
import java.io.IOException;

/**
 * <ul>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#sectioning-content">3.2.5.2.3 Sectioning content</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/Guide/HTML/Content_categories#sectioning_content">Sectioning content</a>.</li>
 * </ul>
 *
 * @param  <D>   This document type
 * @param  <__>  This content model, which will be the parent content model of child elements
 *
 * @since HTML 5
 *
 * @author  AO Industries, Inc.
 */
public interface AnySectioningContent<
  D  extends AnyDocument<D>,
  __ extends AnySectioningContent<D, __>
> extends
  //
  // Content models:
  //
  Content<D, __>
{
  //
  // Factories:
  //
  // <editor-fold defaultstate="collapsed" desc="ARTICLE">
  /**
   * Opens a new article element.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/sections.html#the-article-element">4.3.2 The article element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/article">&lt;article&gt;: The Article Contents element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_article.asp">HTML article Tag</a>.</li>
   * </ul>
   *
   * @since HTML 5
   */
  @Factory("article")
  AnyARTICLE<D, __, ?, ?, ?> article() throws IOException;

  /**
   * Creates an article element with no attributes and the given body.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/sections.html#the-article-element">4.3.2 The article element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/article">&lt;article&gt;: The Article Contents element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_article.asp">HTML article Tag</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @return  This content model, which will be the parent content model of child elements
   *
   * @since HTML 5
   */
  @Factory("article")
  default <Ex extends Throwable> __ article__(IORunnableE<Ex> article) throws IOException, Ex {
    return article().__(article);
  }

  /**
   * Creates an article element with no attributes and the given body.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/sections.html#the-article-element">4.3.2 The article element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/article">&lt;article&gt;: The Article Contents element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_article.asp">HTML article Tag</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @return  This content model, which will be the parent content model of child elements
   *
   * @since HTML 5
   */
  @Factory("article")
  default <Ex extends Throwable> __ article__any(IOConsumerE<? super AnyARTICLE__<D, __, ? extends AnyARTICLE__<D, __, ?>>, Ex> article) throws IOException, Ex {
    return article().__(article);
  }

  /**
   * Creates an article element with no attributes and a text body.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/sections.html#the-article-element">4.3.2 The article element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/article">&lt;article&gt;: The Article Contents element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_article.asp">HTML article Tag</a>.</li>
   * </ul>
   *
   * @return  This content model, which will be the parent content model of child elements
   *
   * @since HTML 5
   */
  @Factory("article")
  default __ article__(Object text) throws IOException {
    return article().__(text);
  }

  /**
   * Creates an empty article element with no attributes.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/sections.html#the-article-element">4.3.2 The article element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/article">&lt;article&gt;: The Article Contents element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_article.asp">HTML article Tag</a>.</li>
   * </ul>
   *
   * @return  This content model, which will be the parent content model of child elements
   *
   * @since HTML 5
   */
  @Factory("article")
  default __ article__() throws IOException {
    return article().__();
  }

  /**
   * Creates an article element with no attributes then begins element content
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/sections.html#the-article-element">4.3.2 The article element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/article">&lt;article&gt;: The Article Contents element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_article.asp">HTML article Tag</a>.</li>
   * </ul>
   *
   * @return  The content model of this element, which will be the parent content model of child elements.
   *          This must be {@linkplain Closeable#__() ended} or {@linkplain Closeable#close() closed} in order to end
   *          the tag.  This is well suited for use in a try-with-resources block.
   *
   * @since HTML 5
   *
   * @see  Closeable#__()
   * @see  Closeable#close()
   */
  @Factory("article")
  AnyARTICLE_c<D, __, ?> article_c() throws IOException;
  // </editor-fold>
  // <editor-fold defaultstate="collapsed" desc="ASIDE">
  /**
   * Opens a new aside element.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/sections.html#the-aside-element">4.3.5 The aside element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/aside">&lt;aside&gt;: The Aside element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_aside.asp">HTML aside Tag</a>.</li>
   * </ul>
   *
   * @since HTML 5
   */
  @Factory("aside")
  AnyASIDE<D, __, ?, ?, ?> aside() throws IOException;

  /**
   * Creates an aside element with no attributes and the given body.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/sections.html#the-aside-element">4.3.5 The aside element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/aside">&lt;aside&gt;: The Aside element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_aside.asp">HTML aside Tag</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @return  This content model, which will be the parent content model of child elements
   *
   * @since HTML 5
   */
  @Factory("aside")
  default <Ex extends Throwable> __ aside__(IORunnableE<Ex> aside) throws IOException, Ex {
    return aside().__(aside);
  }

  /**
   * Creates an aside element with no attributes and the given body.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/sections.html#the-aside-element">4.3.5 The aside element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/aside">&lt;aside&gt;: The Aside element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_aside.asp">HTML aside Tag</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @return  This content model, which will be the parent content model of child elements
   *
   * @since HTML 5
   */
  @Factory("aside")
  default <Ex extends Throwable> __ aside__any(IOConsumerE<? super AnyASIDE__<D, __, ? extends AnyASIDE__<D, __, ?>>, Ex> aside) throws IOException, Ex {
    return aside().__(aside);
  }

  /**
   * Creates an aside element with no attributes and a text body.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/sections.html#the-aside-element">4.3.5 The aside element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/aside">&lt;aside&gt;: The Aside element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_aside.asp">HTML aside Tag</a>.</li>
   * </ul>
   *
   * @return  This content model, which will be the parent content model of child elements
   *
   * @since HTML 5
   */
  @Factory("aside")
  default __ aside__(Object text) throws IOException {
    return aside().__(text);
  }

  /**
   * Creates an empty aside element with no attributes.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/sections.html#the-aside-element">4.3.5 The aside element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/aside">&lt;aside&gt;: The Aside element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_aside.asp">HTML aside Tag</a>.</li>
   * </ul>
   *
   * @return  This content model, which will be the parent content model of child elements
   *
   * @since HTML 5
   */
  @Factory("aside")
  default __ aside__() throws IOException {
    return aside().__();
  }

  /**
   * Creates an aside element with no attributes then begins element content
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/sections.html#the-aside-element">4.3.5 The aside element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/aside">&lt;aside&gt;: The Aside element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_aside.asp">HTML aside Tag</a>.</li>
   * </ul>
   *
   * @return  The content model of this element, which will be the parent content model of child elements.
   *          This must be {@linkplain Closeable#__() ended} or {@linkplain Closeable#close() closed} in order to end
   *          the tag.  This is well suited for use in a try-with-resources block.
   *
   * @since HTML 5
   *
   * @see  Closeable#__()
   * @see  Closeable#close()
   */
  @Factory("aside")
  AnyASIDE_c<D, __, ?> aside_c() throws IOException;
  // </editor-fold>
  // <editor-fold defaultstate="collapsed" desc="NAV">
  /**
   * Opens a new nav element.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/sections.html#the-nav-element">4.3.4 The nav element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/nav">&lt;nav&gt;: The Navigation Section element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_nav.asp">HTML nav Tag</a>.</li>
   * </ul>
   *
   * @since HTML 5
   */
  @Factory("nav")
  AnyNAV<D, __, ?, ?, ?> nav() throws IOException;

  /**
   * Creates a nav element with no attributes and the given body.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/sections.html#the-nav-element">4.3.4 The nav element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/nav">&lt;nav&gt;: The Navigation Section element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_nav.asp">HTML nav Tag</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @return  This content model, which will be the parent content model of child elements
   *
   * @since HTML 5
   */
  @Factory("nav")
  default <Ex extends Throwable> __ nav__(IORunnableE<Ex> nav) throws IOException, Ex {
    return nav().__(nav);
  }

  /**
   * Creates a nav element with no attributes and the given body.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/sections.html#the-nav-element">4.3.4 The nav element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/nav">&lt;nav&gt;: The Navigation Section element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_nav.asp">HTML nav Tag</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @return  This content model, which will be the parent content model of child elements
   *
   * @since HTML 5
   */
  @Factory("nav")
  default <Ex extends Throwable> __ nav__any(IOConsumerE<? super AnyNAV__<D, __, ? extends AnyNAV__<D, __, ?>>, Ex> nav) throws IOException, Ex {
    return nav().__(nav);
  }

  /**
   * Creates a nav element with no attributes and a text body.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/sections.html#the-nav-element">4.3.4 The nav element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/nav">&lt;nav&gt;: The Navigation Section element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_nav.asp">HTML nav Tag</a>.</li>
   * </ul>
   *
   * @return  This content model, which will be the parent content model of child elements
   *
   * @since HTML 5
   */
  @Factory("nav")
  default __ nav__(Object text) throws IOException {
    return nav().__(text);
  }

  /**
   * Creates an empty nav element with no attributes.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/sections.html#the-nav-element">4.3.4 The nav element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/nav">&lt;nav&gt;: The Navigation Section element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_nav.asp">HTML nav Tag</a>.</li>
   * </ul>
   *
   * @return  This content model, which will be the parent content model of child elements
   *
   * @since HTML 5
   */
  @Factory("nav")
  default __ nav__() throws IOException {
    return nav().__();
  }

  /**
   * Creates a nav element with no attributes then begins element content
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/sections.html#the-nav-element">4.3.4 The nav element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/nav">&lt;nav&gt;: The Navigation Section element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_nav.asp">HTML nav Tag</a>.</li>
   * </ul>
   *
   * @return  The content model of this element, which will be the parent content model of child elements.
   *          This must be {@linkplain Closeable#__() ended} or {@linkplain Closeable#close() closed} in order to end
   *          the tag.  This is well suited for use in a try-with-resources block.
   *
   * @since HTML 5
   *
   * @see  Closeable#__()
   * @see  Closeable#close()
   */
  @Factory("nav")
  AnyNAV_c<D, __, ?> nav_c() throws IOException;
  // </editor-fold>
  // <editor-fold defaultstate="collapsed" desc="SECTION">
  /**
   * Opens a new section element.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/sections.html#the-section-element">4.3.3 The section element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/section">&lt;section&gt;: The Generic Section element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_section.asp">HTML section Tag</a>.</li>
   * </ul>
   *
   * @since HTML 5
   */
  @Factory("section")
  AnySECTION<D, __, ?, ?, ?> section() throws IOException;

  /**
   * Creates a section element with no attributes and the given body.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/sections.html#the-section-element">4.3.3 The section element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/section">&lt;section&gt;: The Generic Section element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_section.asp">HTML section Tag</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @return  This content model, which will be the parent content model of child elements
   *
   * @since HTML 5
   */
  @Factory("section")
  default <Ex extends Throwable> __ section__(IORunnableE<Ex> section) throws IOException, Ex {
    return section().__(section);
  }

  /**
   * Creates a section element with no attributes and the given body.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/sections.html#the-section-element">4.3.3 The section element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/section">&lt;section&gt;: The Generic Section element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_section.asp">HTML section Tag</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @return  This content model, which will be the parent content model of child elements
   *
   * @since HTML 5
   */
  @Factory("section")
  default <Ex extends Throwable> __ section__any(IOConsumerE<? super AnySECTION__<D, __, ? extends AnySECTION__<D, __, ?>>, Ex> section) throws IOException, Ex {
    return section().__(section);
  }

  /**
   * Creates a section element with no attributes and a text body.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/sections.html#the-section-element">4.3.3 The section element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/section">&lt;section&gt;: The Generic Section element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_section.asp">HTML section Tag</a>.</li>
   * </ul>
   *
   * @return  This content model, which will be the parent content model of child elements
   *
   * @since HTML 5
   */
  @Factory("section")
  default __ section__(Object text) throws IOException {
    return section().__(text);
  }

  /**
   * Creates an empty section element with no attributes.
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/sections.html#the-section-element">4.3.3 The section element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/section">&lt;section&gt;: The Generic Section element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_section.asp">HTML section Tag</a>.</li>
   * </ul>
   *
   * @return  This content model, which will be the parent content model of child elements
   *
   * @since HTML 5
   */
  @Factory("section")
  default __ section__() throws IOException {
    return section().__();
  }

  /**
   * Creates a section element with no attributes then begins element content
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/sections.html#the-section-element">4.3.3 The section element</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/section">&lt;section&gt;: The Generic Section element</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/tag_section.asp">HTML section Tag</a>.</li>
   * </ul>
   *
   * @return  The content model of this element, which will be the parent content model of child elements.
   *          This must be {@linkplain Closeable#__() ended} or {@linkplain Closeable#close() closed} in order to end
   *          the tag.  This is well suited for use in a try-with-resources block.
   *
   * @since HTML 5
   *
   * @see  Closeable#__()
   * @see  Closeable#close()
   */
  @Factory("section")
  AnySECTION_c<D, __, ?> section_c() throws IOException;
  // </editor-fold>
}
