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

import com.aoapps.lang.io.function.IOSupplierE;
import java.io.IOException;
import java.io.Writer;

/**
 * See <a href="https://html.spec.whatwg.org/multipage/text-level-semantics.html#the-bdo-element">4.5.25 The bdo element</a>.
 *
 * @param  <D>   This document type
 * @param  <PC>  The parent content model this element is within
 * @param  <E>   This element type
 * @param  <__>  This content model, which will be the parent content model of child elements
 * @param  <_c>  This content model as {@link Closeable}, which will be the parent content model of child elements
 *
 * @author  AO Industries, Inc.
 */
@SuppressWarnings("deprecation")
public abstract class AnyBDO<
	D  extends AnyDocument<D>,
	PC extends AnyUnion_Palpable_Phrasing<D, PC>,
	E  extends AnyBDO<D, PC, E, __, _c>,
	__ extends AnyBDO__<D, PC, __>,
	// Would prefer "_c extends __ & Closeable<D, PC>", but "a type variable may not be followed by other bounds"
	_c extends AnyBDO_c<D, PC, _c>
> extends NormalText<D, PC, E, __, _c> implements
	// Global Attributes overrides
	com.aoapps.html.any.attributes.Text.AccesskeyUnexpected<E>,
	com.aoapps.html.any.attributes.Boolean.AutofocusUnexpected<E>,
	com.aoapps.html.any.attributes.Enum.DirUnexpected<E>,
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
	com.aoapps.html.any.attributes.event.OnwheelUnexpected<E>
{

	protected AnyBDO(D document, PC pc) {
		super(document, pc);
	}

	@Override
	protected E writeOpen(Writer unsafe) throws IOException {
		document.autoIndent(unsafe).unsafe(unsafe, "<bdo", false);
		@SuppressWarnings("unchecked") E element = (E)this;
		return element;
	}

	@Override
	protected void writeClose(Writer unsafe, boolean closeAttributes) throws IOException {
		document.autoIndent(unsafe).unsafe(unsafe, closeAttributes ? "></bdo>" : "</bdo>", false);
	}

	/**
	 * @param  dir  <em>The <code>auto</code> value must not be specified.</em>
	 */
	@Override
	public E dir(String dir) throws IOException {
		// TODO: Enforce auto value must not be specified
		return super.dir(dir);
	}

	/**
	 * @param  dir  <em>The <code>auto</code> value must not be specified.</em>
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 */
	@Override
	public <Ex extends Throwable> E dir(Suppliers.String<Ex> dir) throws IOException, Ex {
		return super.dir(dir);
	}

	/**
	 * @param  dir  <em>The <code>auto</code> value must not be specified.</em>
	 */
	@Override
	public E dir(Value dir) throws IOException {
		return super.dir(dir);
	}

	/**
	 * @param  dir  <em>The <code>auto</code> value must not be specified.</em>
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 */
	@Override
	public <Ex extends Throwable> E dir(IOSupplierE<? extends Value, Ex> dir) throws IOException, Ex {
		return super.dir(dir);
	}
}
