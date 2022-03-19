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

import java.io.IOException;
import java.io.Writer;

/**
 * <ul>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/sections.html#the-body-element">4.3.1 The body element</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/body">&lt;body&gt;: The Document Body element - HTML: HyperText Markup Language | MDN</a>.</li>
 * <li>See <a href="https://www.w3schools.com/tags/tag_body.asp">HTML body tag</a>.</li>
 * </ul>
 *
 * @param  <D>   This document type
 * @param  <PC>  The parent content model this element is within
 * @param  <E>   This element type
 * @param  <__>  This content model, which will be the parent content model of child elements
 * @param  <_c>  This content model as {@link Closeable}, which will be the parent content model of child elements
 *
 * @author  AO Industries, Inc.
 */
public abstract class AnyBODY<
	D  extends AnyDocument<D>,
	PC extends AnyHTML_content<D, PC>,
	E  extends AnyBODY<D, PC, E, __, _c>,
	__ extends AnyBODY__<D, PC, __>,
	// Would prefer "_c extends __ & Closeable<D, PC>", but "a type variable may not be followed by other bounds"
	_c extends AnyBODY_c<D, PC, _c>
> extends Normal<D, PC, E, __, _c> implements
	// Global Event Attributes: https://www.w3schools.com/tags/ref_eventattributes.asp
	AlmostGlobalAttributes<E>,
	com.aoapps.html.any.attributes.event.Onafterprint<E>,
	com.aoapps.html.any.attributes.event.Onbeforeprint<E>,
	com.aoapps.html.any.attributes.event.Onbeforeunload<E>,
	com.aoapps.html.any.attributes.event.Onhashchange<E>,
	// TODO: onlanguagechange (experimental per MDN)
	com.aoapps.html.any.attributes.event.Onmessage<E>,
	// TODO: onmessageerror (not on MDN)
	com.aoapps.html.any.attributes.event.Onoffline<E>,
	com.aoapps.html.any.attributes.event.Ononline<E>,
	com.aoapps.html.any.attributes.event.Onpagehide<E>, // not on MDN
	com.aoapps.html.any.attributes.event.Onpageshow<E>, // not on MDN
	com.aoapps.html.any.attributes.event.Onpopstate<E>,
	// TODO: onredo (MDN only)
	// TODO: onrejectionhandled
	com.aoapps.html.any.attributes.event.Onstorage<E>,
	// TODO: onundo (MDN only)
	// TODO: onunhandledrejection (not on MDN)
	com.aoapps.html.any.attributes.event.Onunload<E>,
	// TODO: Are the following supposed to be global event handlers? https://html.spec.whatwg.org/multipage/webappapis.html
	// TODO: onblur
	com.aoapps.html.any.attributes.event.Onerror<E>,
	// TODO: onfocus
	com.aoapps.html.any.attributes.event.Onload<E>,
	com.aoapps.html.any.attributes.event.Onresize<E>
	// TODO: onscroll? (not listed on body?)
{

	protected AnyBODY(D document, PC pc) {
		super(document, pc);
	}

	/**
	 * Does not have indented content.
	 *
	 * @return {@code false} - does not indent
	 */
	@Override
	protected boolean isContentIndented() {
		return false;
	}

	@Override
	protected E writeOpen(Writer out) throws IOException {
		document.autoNli(out).unsafe(out, "<body", false);
		@SuppressWarnings("unchecked") E element = (E)this;
		return element;
	}

	@Override
	protected void doBeforeBody(Writer out) throws IOException {
		document.autoNl(out);
	}

	@Override
	protected void writeClose(Writer out, boolean closeAttributes) throws IOException {
		if(closeAttributes) {
			document.autoIndent(out).unsafe(out, "></body>", false);
		} else {
			document.autoNli(out).unsafe(out, "</body>", false);
		}
		document.autoNl(out);
	}
}
