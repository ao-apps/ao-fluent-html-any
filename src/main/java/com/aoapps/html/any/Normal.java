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
import java.io.Writer;

/**
 * See <a href="https://html.spec.whatwg.org/multipage/syntax.html#normal-elements">13.1.2 Elements / Normal elements</a>.
 *
 * @param  <D>   This document type
 * @param  <PC>  The parent content model this element is within
 * @param  <E>   This element type
 * @param  <__>  This content model, which will be the parent content model of child elements
 * @param  <_c>  This content model as {@link Closeable}, which will be the parent content model of child elements
 *
 * @author  AO Industries, Inc.
 */
public abstract class Normal<
	D  extends AnyDocument<D>,
	PC extends Content<D, PC>,
	E  extends Normal<D, PC, E, __, _c>,
	__ extends Content<D, __>, // Transparent can have any: Normal__<D, PC, __>,
	// Would prefer "_c extends __ & Closeable<D, PC>", but "a type variable may not be followed by other bounds"
	_c extends Normal_c<D, PC, _c>
> extends Element<D, PC, E> {

	protected Normal(D document, PC pc) {
		super(document, pc);
	}

	/**
	 * Determines if this element has indented content.
	 *
	 * @return {@code true} - defaults to indenting
	 */
	protected boolean isContentIndented() {
		return true;
	}

	/**
	 * Called after opening tag is completed, {@linkplain AnyDocument#incDepth() indentation depth is increased}
	 * (if {@link #isContentIndented()}), and before the body is invoked.
	 * <p>
	 * An common use-case is to call {@link AnyDocument#autoNl()} to begin body on the next line.
	 * </p>
	 */
	@SuppressWarnings("NoopMethodInAbstractClass")
	protected void doBeforeBody(Writer unsafe) throws IOException {
		// Do nothing by default
	}

	/**
	 * Writes the closing tag.
	 *
	 * @param  closeAttributes  When {@code true}, must end attributes with {@code '>'} before writing the closing tag.
	 *                          These are expected to be combined to a single write.
	 */
	protected abstract void writeClose(Writer unsafe, boolean closeAttributes) throws IOException;

	/**
	 * Ends attributes, invokes the body, then closes this element.
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 *
	 * @return  The parent content model this element is within
	 */
	public <Ex extends Throwable> PC __(IORunnableE<Ex> body) throws IOException, Ex {
		@SuppressWarnings("deprecation")
		Writer unsafe = document.getRawUnsafe(null);
		if(body != null) {
			document.autoIndent(unsafe).unsafe(unsafe, '>');
			boolean contentIndented = isContentIndented();
			if(contentIndented) document.incDepth();
			doBeforeBody(unsafe);
			body.run();
			if(contentIndented) document.decDepth();
			writeClose(unsafe, false);
		} else {
			writeClose(unsafe, true);
		}
		return pc;
	}

	/**
	 * Ends attributes, invokes the body, then closes this element.
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 *
	 * @return  The parent content model this element is within
	 *
	 * @see  #new__()
	 */
	public <Ex extends Throwable> PC __(IOConsumerE<? super __, Ex> body) throws IOException, Ex {
		@SuppressWarnings("deprecation")
		Writer unsafe = document.getRawUnsafe(null);
		if(body != null) {
			document.autoIndent(unsafe).unsafe(unsafe, '>');
			boolean contentIndented = isContentIndented();
			if(contentIndented) document.incDepth();
			doBeforeBody(unsafe);
			body.accept(new__());
			if(contentIndented) document.decDepth();
			writeClose(unsafe, false);
		} else {
			writeClose(unsafe, true);
		}
		return pc;
	}

	/**
	 * Ends attributes then closes this element without any body.
	 *
	 * @return  The parent content model this element is within
	 */
	@SuppressWarnings("deprecation")
	public PC __() throws IOException {
		writeClose(document.getRawUnsafe(null), true);
		return pc;
	}

	/**
	 * Ends attributes then begins element content
	 *
	 * @return  The content model of this element, which will be the parent content model of child elements.
	 *          This must be {@linkplain Closeable#__() ended} or {@linkplain Closeable#close() closed} in order to end
	 *          the tag.  This is well suited for use in a try-with-resources block.
	 *
	 * @see  Closeable#__()
	 * @see  Closeable#close()
	 * @see  #new_c()
	 */
	public _c _c() throws IOException {
		@SuppressWarnings("deprecation")
		Writer unsafe = document.getRawUnsafe(null);
		document.autoIndent(unsafe).unsafe(unsafe, '>');
		if(isContentIndented()) document.incDepth();
		doBeforeBody(unsafe);
		return new_c();
	}

	/**
	 * Creates a new instance of uncloseable content.
	 *
	 * @see  #__(com.aoapps.lang.io.function.IOConsumerE)
	 */
	protected abstract __ new__();

	/**
	 * Creates a new instance of closeable content.
	 *
	 * @see  #_c()
	 */
	protected abstract _c new_c();
}
