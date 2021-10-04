/*
 * ao-fluent-html-any - Base abstract classes and interfaces for Fluent Java DSL for high-performance HTML generation.
 * Copyright (C) 2019, 2021  AO Industries, Inc.
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
 * along with ao-fluent-html-any.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.aoapps.html.any;

import com.aoapps.encoding.WhitespaceWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * See <a href="https://html.spec.whatwg.org/multipage/syntax.html#elements-2">13.1.2 Elements</a>.
 *
 * @param  <D>   This document type
 * @param  <PC>  The parent content model this element is within
 * @param  <E>   This element type
 *
 * @author  AO Industries, Inc.
 */
// TODO: Should every element have a __() closing method?
//       Should every element implement Closeable, even if does not have a specific __()?
public abstract class Element<
	D  extends AnyDocument<D>,
	PC extends Content<D, PC>,
	E  extends Element<D, PC, E>
> implements
	WhitespaceWriter<E>,
	// Allow any arbitrary attributes
	com.aoapps.html.any.attributes.Text.Attribute<E>,
	// Global Attributes: https://www.w3schools.com/tags/ref_standardattributes.asp
	GlobalAttributes<E>
{

	protected final D document;
	protected final PC pc;

	protected Element(D document, PC pc) {
		this.document = document;
		this.pc = pc;
	}

	public D getDocument() {
		return document;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Delegates to {@link AnyDocument#nl()}.
	 * </p>
	 */
	@Override
	public E nl() throws IOException {
		@SuppressWarnings("unchecked") E element = (E)this;
		document.nl();
		return element;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Delegates to {@link AnyDocument#nli()}.
	 * </p>
	 */
	@Override
	public E nli() throws IOException {
		@SuppressWarnings("unchecked") E element = (E)this;
		document.nli();
		return element;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Delegates to {@link AnyDocument#nli(int)}.
	 * </p>
	 */
	@Override
	public E nli(int depthOffset) throws IOException {
		@SuppressWarnings("unchecked") E element = (E)this;
		document.nli(depthOffset);
		return element;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Delegates to {@link AnyDocument#indent()}.
	 * </p>
	 */
	@Override
	public E indent() throws IOException {
		@SuppressWarnings("unchecked") E element = (E)this;
		document.indent();
		return element;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Delegates to {@link AnyDocument#indent(int)}.
	 * </p>
	 */
	@Override
	public E indent(int depthOffset) throws IOException {
		@SuppressWarnings("unchecked") E element = (E)this;
		document.indent(depthOffset);
		return element;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Delegates to {@link AnyDocument#getIndent()}.
	 * </p>
	 */
	@Override
	public boolean getIndent() {
		return document.getIndent();
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Delegates to {@link AnyDocument#setIndent(boolean)}.
	 * </p>
	 */
	@Override
	public E setIndent(boolean indent) {
		@SuppressWarnings("unchecked") E element = (E)this;
		document.setIndent(indent);
		return element;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Delegates to {@link AnyDocument#getDepth()}.
	 * </p>
	 */
	@Override
	public int getDepth() {
		return document.getDepth();
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Delegates to {@link AnyDocument#setDepth(int)}.
	 * </p>
	 */
	@Override
	public E setDepth(int depth) {
		@SuppressWarnings("unchecked") E element = (E)this;
		document.setDepth(depth);
		return element;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Delegates to {@link AnyDocument#incDepth()}.
	 * </p>
	 */
	@Override
	public E incDepth() {
		@SuppressWarnings("unchecked") E element = (E)this;
		document.incDepth();
		return element;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Delegates to {@link AnyDocument#decDepth()}.
	 * </p>
	 */
	@Override
	public E decDepth() {
		@SuppressWarnings("unchecked") E element = (E)this;
		document.decDepth();
		return element;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Delegates to {@link AnyDocument#sp()}.
	 * </p>
	 */
	@Override
	public E sp() throws IOException {
		@SuppressWarnings("unchecked") E element = (E)this;
		document.sp();
		return element;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Delegates to {@link AnyDocument#sp(int)}.
	 * </p>
	 */
	@Override
	public E sp(int count) throws IOException {
		@SuppressWarnings("unchecked") E element = (E)this;
		document.sp(count);
		return element;
	}

	/**
	 * Writes the beginning of the opening tag.
	 *
	 * @return  The element instance to use.
	 *          This may substitute the element with a different instance, when appropriate.
	 */
	protected abstract E writeOpen(Writer out) throws IOException;
}
