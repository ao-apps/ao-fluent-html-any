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

import com.aoapps.lang.io.Writable;
import com.aoapps.lang.io.function.IOSupplierE;
import java.io.IOException;
import java.io.Writer;

/**
 * The methods common to all content models.
 * <ul>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#content-models">3.2.5 Content models</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/Guide/HTML/Content_categories">Content categories - Developer guides</a>.</li>
 * </ul>
 *
 * @param  <D>   This document type
 * @param  <__>  This content model, which will be the parent content model of child elements
 *
 * @author  AO Industries, Inc.
 */
public interface Content<
	D  extends AnyDocument<D>,
	__ extends Content<D, __>
> extends DocumentWriter {

	/**
	 * Gets the document for the current content model.  The document can be used to
	 * perform raw output or write elements not expected in the current context.
	 */
	D getDocument();

	// <editor-fold desc="WhitespaceWriter - delegate to Document" defaultstate="collapsed">
	/**
	 * {@inheritDoc}
	 * <p>
	 * Delegates to {@link AnyDocument#nl()}.
	 * </p>
	 *
	 * @deprecated  Deprecated to keep out of the way in code assist, since this not expected to be used normally.
	 */
	// Note: Must be implemented in AnyDocument to avoid infinite recursion
	@Deprecated
	@Override
	default __ nl() throws IOException {
		getDocument().nl();
		@SuppressWarnings("unchecked") __ c = (__)this;
		return c;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Delegates to {@link AnyDocument#nli()}.
	 * </p>
	 */
	// Note: Must be implemented in AnyDocument to avoid infinite recursion
	@Override
	default __ nli() throws IOException {
		getDocument().nli();
		@SuppressWarnings("unchecked") __ c = (__)this;
		return c;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Delegates to {@link AnyDocument#nli(int)}.
	 * </p>
	 *
	 * @deprecated  Deprecated to keep out of the way in code assist, since this not expected to be used normally.
	 */
	// Note: Must be implemented in AnyDocument to avoid infinite recursion
	@Deprecated
	@Override
	default __ nli(int depthOffset) throws IOException {
		getDocument().nli(depthOffset);
		@SuppressWarnings("unchecked") __ c = (__)this;
		return c;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Delegates to {@link AnyDocument#indent()}.
	 * </p>
	 *
	 * @deprecated  Deprecated to keep out of the way in code assist, since this not expected to be used normally.
	 */
	// Note: Must be implemented in AnyDocument to avoid infinite recursion
	@Deprecated
	@Override
	default __ indent() throws IOException {
		getDocument().indent();
		@SuppressWarnings("unchecked") __ c = (__)this;
		return c;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Delegates to {@link AnyDocument#indent(int)}.
	 * </p>
	 *
	 * @deprecated  Deprecated to keep out of the way in code assist, since this not expected to be used normally.
	 */
	// Note: Must be implemented in AnyDocument to avoid infinite recursion
	@Deprecated
	@Override
	default __ indent(int depthOffset) throws IOException {
		getDocument().indent(depthOffset);
		@SuppressWarnings("unchecked") __ c = (__)this;
		return c;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Delegates to {@link AnyDocument#getIndent()}.
	 * </p>
	 *
	 * @deprecated  Deprecated to keep out of the way in code assist, since this not expected to be used normally.
	 */
	// Note: Must be implemented in AnyDocument to avoid infinite recursion
	@Deprecated
	@Override
	default boolean getIndent() {
		return getDocument().getIndent();
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Delegates to {@link AnyDocument#setIndent(boolean)}.
	 * </p>
	 *
	 * @deprecated  Deprecated to keep out of the way in code assist, since this not expected to be used normally.
	 */
	// Note: Must be implemented in AnyDocument to avoid infinite recursion
	@Deprecated
	@Override
	default __ setIndent(boolean indent) {
		getDocument().setIndent(indent);
		@SuppressWarnings("unchecked") __ c = (__)this;
		return c;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Delegates to {@link AnyDocument#getDepth()}.
	 * </p>
	 *
	 * @deprecated  Deprecated to keep out of the way in code assist, since this not expected to be used normally.
	 */
	// Note: Must be implemented in AnyDocument to avoid infinite recursion
	@Deprecated
	@Override
	default int getDepth() {
		return getDocument().getDepth();
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Delegates to {@link AnyDocument#setDepth(int)}.
	 * </p>
	 *
	 * @deprecated  Deprecated to keep out of the way in code assist, since this not expected to be used normally.
	 */
	// Note: Must be implemented in AnyDocument to avoid infinite recursion
	@Deprecated
	@Override
	default __ setDepth(int depth) {
		getDocument().setDepth(depth);
		@SuppressWarnings("unchecked") __ c = (__)this;
		return c;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Delegates to {@link AnyDocument#incDepth()}.
	 * </p>
	 *
	 * @deprecated  Deprecated to keep out of the way in code assist, since this not expected to be used normally.
	 */
	// Note: Must be implemented in AnyDocument to avoid infinite recursion
	@Deprecated
	@Override
	default __ incDepth() {
		getDocument().incDepth();
		@SuppressWarnings("unchecked") __ c = (__)this;
		return c;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Delegates to {@link AnyDocument#decDepth()}.
	 * </p>
	 *
	 * @deprecated  Deprecated to keep out of the way in code assist, since this not expected to be used normally.
	 */
	// Note: Must be implemented in AnyDocument to avoid infinite recursion
	@Deprecated
	@Override
	default __ decDepth() {
		getDocument().decDepth();
		@SuppressWarnings("unchecked") __ c = (__)this;
		return c;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Delegates to {@link AnyDocument#sp()}.
	 * </p>
	 */
	// Note: Must be implemented in AnyDocument to avoid infinite recursion
	@Override
	default __ sp() throws IOException {
		getDocument().sp();
		@SuppressWarnings("unchecked") __ c = (__)this;
		return c;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Delegates to {@link AnyDocument#sp(int)}.
	 * </p>
	 */
	// Note: Must be implemented in AnyDocument to avoid infinite recursion
	@Override
	default __ sp(int count) throws IOException {
		getDocument().sp(count);
		@SuppressWarnings("unchecked") __ c = (__)this;
		return c;
	}
	// </editor-fold>

	// <editor-fold desc="DocumentWriter / Unsafe - delegate to Document" defaultstate="collapsed">
	/**
	 * {@inheritDoc}
	 * <p>
	 * Delegates to {@link AnyDocument#getUnsafe(java.lang.Boolean)}.
	 * </p>
	 */
	// Note: Must be implemented in AnyDocument to avoid infinite recursion
	@Override
	default Writer getUnsafe(Boolean endsNewline) throws IllegalStateException {
		return getDocument().getUnsafe(endsNewline);
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Delegates to {@link AnyDocument#getUnsafe()}.
	 * </p>
	 */
	// Note: Must be implemented in AnyDocument to avoid infinite recursion
	@Override
	default Writer getUnsafe() throws IllegalStateException {
		return getDocument().getUnsafe();
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Delegates to {@link AnyDocument#unsafe(char)}.
	 * </p>
	 */
	// Note: Must be implemented in AnyDocument to avoid infinite recursion
	@Override
	default __ unsafe(char ch) throws IOException {
		getDocument().unsafe(ch);
		@SuppressWarnings("unchecked") __ c = (__)this;
		return c;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Delegates to {@link AnyDocument#unsafe(char[])}.
	 * </p>
	 */
	// Note: Must be implemented in AnyDocument to avoid infinite recursion
	@Override
	default __ unsafe(char[] cbuf) throws IOException {
		getDocument().unsafe(cbuf);
		@SuppressWarnings("unchecked") __ c = (__)this;
		return c;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Delegates to {@link AnyDocument#unsafe(char[], int, int)}.
	 * </p>
	 */
	// Note: Must be implemented in AnyDocument to avoid infinite recursion
	@Override
	default __ unsafe(char[] cbuf, int offset, int len) throws IOException {
		getDocument().unsafe(cbuf, offset, len);
		@SuppressWarnings("unchecked") __ c = (__)this;
		return c;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Delegates to {@link AnyDocument#unsafe(java.lang.CharSequence)}.
	 * </p>
	 */
	// Note: Must be implemented in AnyDocument to avoid infinite recursion
	@Override
	default __ unsafe(CharSequence csq) throws IOException {
		getDocument().unsafe(csq);
		@SuppressWarnings("unchecked") __ c = (__)this;
		return c;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Delegates to {@link AnyDocument#unsafe(java.lang.CharSequence, int, int)}.
	 * </p>
	 */
	// Note: Must be implemented in AnyDocument to avoid infinite recursion
	@Override
	default __ unsafe(CharSequence csq, int start, int end) throws IOException {
		getDocument().unsafe(csq, start, end);
		@SuppressWarnings("unchecked") __ c = (__)this;
		return c;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Delegates to {@link AnyDocument#unsafe(java.lang.Object)}.
	 * </p>
	 */
	// Note: Must be implemented in AnyDocument to avoid infinite recursion
	@Override
	default __ unsafe(Object unsafe) throws IOException {
		getDocument().unsafe(unsafe);
		@SuppressWarnings("unchecked") __ c = (__)this;
		return c;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Delegates to {@link AnyDocument#unsafe(com.aoapps.lang.io.function.IOSupplierE)}.
	 * </p>
	 */
	// Note: Must be implemented in AnyDocument to avoid infinite recursion
	@Override
	default <Ex extends Throwable> __ unsafe(IOSupplierE<?, Ex> unsafe) throws IOException, Ex {
		getDocument().unsafe(unsafe);
		@SuppressWarnings("unchecked") __ c = (__)this;
		return c;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Delegates to {@link AnyDocument#unsafe(com.aoapps.lang.io.Writable)}.
	 * </p>
	 */
	// Note: Must be implemented in AnyDocument to avoid infinite recursion
	@Override
	default __ unsafe(Writable unsafe) throws IOException {
		getDocument().unsafe(unsafe);
		@SuppressWarnings("unchecked") __ c = (__)this;
		return c;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Delegates to {@link AnyDocument#unsafe()}.
	 * </p>
	 */
	// Note: Must be implemented in AnyDocument to avoid infinite recursion
	@Override
	default Writer unsafe() throws IOException {
		return getDocument().unsafe();
	}
	// </editor-fold>

	// <editor-fold desc="DocumentWriter / Automatic Newline and Indentation - delegate to Document" defaultstate="collapsed">
	/**
	 * {@inheritDoc}
	 * <p>
	 * Delegates to {@link AnyDocument#getAutonli()}.
	 * </p>
	 *
	 * @deprecated  Deprecated to keep out of the way in code assist, since this not expected to be used normally.
	 */
	// Note: Must be implemented in AnyDocument to avoid infinite recursion
	@Deprecated
	@Override
	default boolean getAutonli() {
		return getDocument().getAutonli();
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Delegates to {@link AnyDocument#setAutonli(boolean)}.
	 * </p>
	 *
	 * @deprecated  Deprecated to keep out of the way in code assist, since this not expected to be used normally.
	 */
	// Note: Must be implemented in AnyDocument to avoid infinite recursion
	@Deprecated
	@Override
	default __ setAutonli(boolean autonli) {
		getDocument().setAutonli(autonli);
		@SuppressWarnings("unchecked") __ c = (__)this;
		return c;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Delegates to {@link AnyDocument#getAtnl()}.
	 * </p>
	 *
	 * @deprecated  Deprecated to keep out of the way in code assist, since this not expected to be used normally.
	 */
	// Note: Must be implemented in AnyDocument to avoid infinite recursion
	@Deprecated
	@Override
	default boolean getAtnl() {
		return getDocument().getAtnl();
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Delegates to {@link AnyDocument#setAtnl()}.
	 * </p>
	 *
	 * @deprecated  Deprecated to keep out of the way in code assist, since this not expected to be used normally.
	 */
	// Note: Must be implemented in AnyDocument to avoid infinite recursion
	@Deprecated
	@Override
	default __ setAtnl() {
		getDocument().setAtnl();
		@SuppressWarnings("unchecked") __ c = (__)this;
		return c;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Delegates to {@link AnyDocument#setAtnl(boolean)}.
	 * </p>
	 *
	 * @deprecated  Deprecated to keep out of the way in code assist, since this not expected to be used normally.
	 */
	// Note: Must be implemented in AnyDocument to avoid infinite recursion
	@Deprecated
	@Override
	default __ setAtnl(boolean atnl) {
		getDocument().setAtnl(atnl);
		@SuppressWarnings("unchecked") __ c = (__)this;
		return c;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Delegates to {@link AnyDocument#clearAtnl()}.
	 * </p>
	 *
	 * @deprecated  Deprecated to keep out of the way in code assist, since this not expected to be used normally.
	 */
	// Note: Must be implemented in AnyDocument to avoid infinite recursion
	@Deprecated
	@Override
	default __ clearAtnl() {
		getDocument().clearAtnl();
		@SuppressWarnings("unchecked") __ c = (__)this;
		return c;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Delegates to {@link AnyDocument#autoNl()}.
	 * </p>
	 *
	 * @deprecated  Deprecated to keep out of the way in code assist, since this not expected to be used normally.
	 */
	// Note: Must be implemented in AnyDocument to avoid infinite recursion
	@Deprecated
	@Override
	default __ autoNl() throws IOException {
		getDocument().autoNl();
		@SuppressWarnings("unchecked") __ c = (__)this;
		return c;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Delegates to {@link AnyDocument#autoNli()}.
	 * </p>
	 */
	// Note: Must be implemented in AnyDocument to avoid infinite recursion
	@Override
	default __ autoNli() throws IOException {
		getDocument().autoNli();
		@SuppressWarnings("unchecked") __ c = (__)this;
		return c;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Delegates to {@link AnyDocument#autoNli(int)}.
	 * </p>
	 *
	 * @deprecated  Deprecated to keep out of the way in code assist, since this not expected to be used normally.
	 */
	// Note: Must be implemented in AnyDocument to avoid infinite recursion
	@Deprecated
	@Override
	default __ autoNli(int depthOffset) throws IOException {
		getDocument().autoNli(depthOffset);
		@SuppressWarnings("unchecked") __ c = (__)this;
		return c;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Delegates to {@link AnyDocument#autoIndent()}.
	 * </p>
	 *
	 * @deprecated  Deprecated to keep out of the way in code assist, since this not expected to be used normally.
	 */
	// Note: Must be implemented in AnyDocument to avoid infinite recursion
	@Deprecated
	@Override
	default __ autoIndent() throws IOException {
		getDocument().autoIndent();
		@SuppressWarnings("unchecked") __ c = (__)this;
		return c;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Delegates to {@link AnyDocument#autoIndent(int)}.
	 * </p>
	 *
	 * @deprecated  Deprecated to keep out of the way in code assist, since this not expected to be used normally.
	 */
	// Note: Must be implemented in AnyDocument to avoid infinite recursion
	@Deprecated
	@Override
	default __ autoIndent(int depthOffset) throws IOException {
		getDocument().autoIndent(depthOffset);
		@SuppressWarnings("unchecked") __ c = (__)this;
		return c;
	}
	// </editor-fold>
}
