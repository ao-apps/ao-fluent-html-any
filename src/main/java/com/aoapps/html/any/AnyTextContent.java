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

import com.aoapps.encoding.MediaWritable;
import com.aoapps.encoding.TextWriter;
import com.aoapps.hodgepodge.i18n.MarkupType;
import com.aoapps.lang.io.function.IOSupplierE;
import java.io.IOException;

/**
 * See <a href="https://html.spec.whatwg.org/multipage/dom.html#text-content">3.2.5.2.5 Phrasing content / Text</a>.
 *
 * @param  <D>   This document type
 * @param  <__>  This content model, which will be the parent content model of child elements
 *
 * @author  AO Industries, Inc.
 */
public interface AnyTextContent<
	D  extends AnyDocument<D>,
	__ extends AnyTextContent<D, __>
> extends TextWriter,
	Content<D, __> {

	// <editor-fold desc="WhitespaceWriter - manual self-type" defaultstate="collapsed">
	/**
	 * {@inheritDoc}
	 *
	 * @deprecated  Deprecated to keep out of the way in code assist, since this not expected to be used normally.
	 */
	@Deprecated
	@Override
	default __ nl() throws IOException {
		Content.super.nl();
		@SuppressWarnings("unchecked") __ c = (__)this;
		return c;
	}

	@Override
	default __ nli() throws IOException {
		Content.super.nli();
		@SuppressWarnings("unchecked") __ c = (__)this;
		return c;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @deprecated  Deprecated to keep out of the way in code assist, since this not expected to be used normally.
	 */
	@Deprecated
	@Override
	default __ nli(int depthOffset) throws IOException {
		Content.super.nli(depthOffset);
		@SuppressWarnings("unchecked") __ c = (__)this;
		return c;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @deprecated  Deprecated to keep out of the way in code assist, since this not expected to be used normally.
	 */
	@Deprecated
	@Override
	default __ indent() throws IOException {
		Content.super.indent();
		@SuppressWarnings("unchecked") __ c = (__)this;
		return c;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @deprecated  Deprecated to keep out of the way in code assist, since this not expected to be used normally.
	 */
	@Deprecated
	@Override
	default __ indent(int depthOffset) throws IOException {
		Content.super.indent(depthOffset);
		@SuppressWarnings("unchecked") __ c = (__)this;
		return c;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @deprecated  Deprecated to keep out of the way in code assist, since this not expected to be used normally.
	 */
	@Deprecated
	@Override
	default __ setIndent(boolean indent) {
		Content.super.setIndent(indent);
		@SuppressWarnings("unchecked") __ c = (__)this;
		return c;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @deprecated  Deprecated to keep out of the way in code assist, since this not expected to be used normally.
	 */
	@Deprecated
	@Override
	default __ setDepth(int depth) {
		Content.super.setDepth(depth);
		@SuppressWarnings("unchecked") __ c = (__)this;
		return c;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @deprecated  Deprecated to keep out of the way in code assist, since this not expected to be used normally.
	 */
	@Deprecated
	@Override
	default __ incDepth() {
		Content.super.incDepth();
		@SuppressWarnings("unchecked") __ c = (__)this;
		return c;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @deprecated  Deprecated to keep out of the way in code assist, since this not expected to be used normally.
	 */
	@Deprecated
	@Override
	default __ decDepth() {
		Content.super.decDepth();
		@SuppressWarnings("unchecked") __ c = (__)this;
		return c;
	}

	@Override
	default __ sp() throws IOException {
		Content.super.sp();
		@SuppressWarnings("unchecked") __ c = (__)this;
		return c;
	}

	@Override
	default __ sp(int count) throws IOException {
		Content.super.sp(count);
		@SuppressWarnings("unchecked") __ c = (__)this;
		return c;
	}
	// </editor-fold>

	// <editor-fold desc="TextWriter - delegate to Document" defaultstate="collapsed">
	/**
	 * {@inheritDoc}
	 * <p>
	 * Does not perform any translation markups.
	 * </p>
	 *
	 * @return  This content model, which will be the parent content model of child elements
	 */
	// Note: Must be implemented in AnyDocument to avoid infinite recursion
	@Override
	default __ nbsp() throws IOException {
		getDocument().nbsp();
		@SuppressWarnings("unchecked") __ c = (__)this;
		return c;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Does not perform any translation markups.
	 * </p>
	 *
	 * @return  This content model, which will be the parent content model of child elements
	 */
	// Note: Must be implemented in AnyDocument to avoid infinite recursion
	@Override
	default __ nbsp(int count) throws IOException {
		getDocument().nbsp(count);
		@SuppressWarnings("unchecked") __ c = (__)this;
		return c;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Does not perform any translation markups.
	 * </p>
	 *
	 * @return  This content model, which will be the parent content model of child elements
	 */
	// Note: Must be implemented in AnyDocument to avoid infinite recursion
	@Override
	default __ text(char ch) throws IOException {
		getDocument().text(ch);
		@SuppressWarnings("unchecked") __ c = (__)this;
		return c;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Does not perform any translation markups.
	 * </p>
	 *
	 * @return  This content model, which will be the parent content model of child elements
	 */
	// Note: Must be implemented in AnyDocument to avoid infinite recursion
	@Override
	default __ text(char[] cbuf) throws IOException {
		getDocument().text(cbuf);
		@SuppressWarnings("unchecked") __ c = (__)this;
		return c;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Does not perform any translation markups.
	 * </p>
	 *
	 * @return  This content model, which will be the parent content model of child elements
	 */
	// Note: Must be implemented in AnyDocument to avoid infinite recursion
	@Override
	default __ text(char[] cbuf, int offset, int len) throws IOException {
		getDocument().text(cbuf, offset, len);
		@SuppressWarnings("unchecked") __ c = (__)this;
		return c;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Does not perform any translation markups.
	 * </p>
	 *
	 * @return  This content model, which will be the parent content model of child elements
	 */
	// Note: Must be implemented in AnyDocument to avoid infinite recursion
	@Override
	default __ text(CharSequence csq) throws IOException {
		getDocument().text(csq);
		@SuppressWarnings("unchecked") __ c = (__)this;
		return c;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Does not perform any translation markups.
	 * </p>
	 *
	 * @return  This content model, which will be the parent content model of child elements
	 */
	// Note: Must be implemented in AnyDocument to avoid infinite recursion
	@Override
	default __ text(CharSequence csq, int start, int end) throws IOException {
		getDocument().text(csq, start, end);
		@SuppressWarnings("unchecked") __ c = (__)this;
		return c;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * When no knowledge of what will be written, calls {@link #clearAtnl()} to be safe.
	 * </p>
	 * <p>
	 * Supports translation markup type {@link MarkupType#XHTML}.
	 * </p>
	 *
	 * @return  This content model, which will be the parent content model of child elements
	 */
	// Note: Must be implemented in AnyDocument to avoid infinite recursion
	@Override
	default __ text(Object text) throws IOException {
		getDocument().text(text);
		@SuppressWarnings("unchecked") __ c = (__)this;
		return c;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * When no knowledge of what will be written, calls {@link #clearAtnl()} to be safe.
	 * </p>
	 * <p>
	 * Supports translation markup type {@link MarkupType#XHTML}.
	 * </p>
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 *
	 * @return  This content model, which will be the parent content model of child elements
	 */
	// Note: Must be implemented in AnyDocument to avoid infinite recursion
	@Override
	default <Ex extends Throwable> __ text(IOSupplierE<?, Ex> text) throws IOException, Ex {
		getDocument().text(text);
		@SuppressWarnings("unchecked") __ c = (__)this;
		return c;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * With no knowledge of what will be written, calls {@link #clearAtnl()} to be safe.
	 * </p>
	 * <p>
	 * Does not perform any translation markups.
	 * </p>
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 *
	 * @return  This content model, which will be the parent content model of child elements
	 */
	// Note: Must be implemented in AnyDocument to avoid infinite recursion
	@Override
	default <Ex extends Throwable> __ text(MediaWritable<Ex> text) throws IOException, Ex {
		getDocument().text(text);
		@SuppressWarnings("unchecked") __ c = (__)this;
		return c;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * With no knowledge of what will be written, calls {@link #clearAtnl()} to be safe.
	 * </p>
	 * <p>
	 * Does not perform any translation markups.
	 * </p>
	 */
	// Note: Must be implemented in AnyDocument to avoid infinite recursion
	// TODO: __() method to end text?  Call it "ContentWriter"?
	@Override
	default DocumentMediaWriter<D> text() throws IOException {
		return getDocument().text();
	}
	// </editor-fold>
}
