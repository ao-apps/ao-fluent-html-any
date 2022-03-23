/*
 * ao-fluent-html-any - Base abstract classes and interfaces for Fluent Java DSL for high-performance HTML generation.
 * Copyright (C) 2022  AO Industries, Inc.
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

import com.aoapps.encoding.WhitespaceWriter;
import com.aoapps.lang.io.Writable;
import com.aoapps.lang.io.function.IOSupplierE;
import java.io.IOException;
import java.io.Writer;

/**
 * Allows writing raw document output.
 *
 * @param  <C>  The current type of writer.
 *
 * @author  AO Industries, Inc.
 */
public interface DocumentWriter<C> extends WhitespaceWriter<C> {

	// <editor-fold desc="Unsafe">
	/**
	 * Gets the current writer this document is writing to, which may be used for raw output.
	 * <p>
	 * Please prefer {@link #unsafe()}, which is compatible with try-with-resources blocks.
	 * The writer returned here is the real, underlying writer.
	 * </p>
	 *
	 * @param  endsNewline  Indicates whether the data that will be written will end in a {@link #NL}.
	 *                      When non-null, will call {@link #setAtnl(boolean)} with the given value.
	 *
	 * @throws  IllegalStateException  when output has been set to {@code null}.
	 *
	 * @see  #getUnsafe()
	 * @see  AnyDocument#setOut(java.io.Writer)
	 */
	Writer getUnsafe(Boolean endsNewline) throws IllegalStateException;

	/**
	 * Gets the current writer this document is writing to, which may be used for raw output.
	 * <p>
	 * Please prefer {@link #unsafe()}, which is compatible with try-with-resources blocks.
	 * The writer returned here is the real, underlying writer.
	 * </p>
	 * <p>
	 * With no knowledge of what will be written, calls {@link #clearAtnl()} to be safe.
	 * </p>
	 *
	 * @throws  IllegalStateException  when output has been set to {@code null}.
	 *
	 * @see  #getUnsafe(java.lang.Boolean)
	 * @see  AnyDocument#setOut(java.io.Writer)
	 */
	Writer getUnsafe() throws IllegalStateException;

	/**
	 * Performs raw output of a single character, automatically determining {@link #setAtnl(boolean)}.
	 *
	 * @return  {@code this} writer
	 */
	C unsafe(char ch) throws IOException;

	/**
	 * Performs raw output of a single code point, automatically determining {@link #setAtnl(boolean)}.
	 *
	 * @return  {@code this} writer
	 */
	C unsafe(int codePoint) throws IOException;

	/**
	 * Performs raw output, automatically determining {@link #setAtnl(boolean)}.
	 *
	 * @return  {@code this} writer
	 */
	C unsafe(char[] cbuf) throws IOException;

	/**
	 * Performs raw output, automatically determining {@link #setAtnl(boolean)}.
	 *
	 * @return  {@code this} writer
	 */
	C unsafe(char[] cbuf, int offset, int len) throws IOException;

	/**
	 * Performs raw output, automatically determining {@link #setAtnl(boolean)}.
	 *
	 * @return  {@code this} writer
	 */
	C unsafe(CharSequence csq) throws IOException;

	/**
	 * Performs raw output, automatically determining {@link #setAtnl(boolean)}.
	 *
	 * @return  {@code this} writer
	 */
	C unsafe(CharSequence csq, int start, int end) throws IOException;

	/**
	 * Performs raw output, automatically determining {@link #setAtnl(boolean)}.
	 * <p>
	 * When no knowledge of what will be written, calls {@link #clearAtnl()} to be safe.
	 * </p>
	 *
	 * @return  {@code this} writer
	 */
	C unsafe(Object unsafe) throws IOException;

	/**
	 * Performs raw output, automatically determining {@link #setAtnl(boolean)}.
	 * <p>
	 * When no knowledge of what will be written, calls {@link #clearAtnl()} to be safe.
	 * </p>
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 *
	 * @return  {@code this} writer
	 */
	<Ex extends Throwable> C unsafe(IOSupplierE<?, Ex> unsafe) throws IOException, Ex;

	/**
	 * Performs raw output.
	 * <p>
	 * With no knowledge of what will be written, calls {@link #clearAtnl()} to be safe.
	 * </p>
	 *
	 * @return  {@code this} writer
	 */
	C unsafe(Writable unsafe) throws IOException;

	/**
	 * Performs raw output.
	 * This is well suited for use in a try-with-resources block.
	 * <p>
	 * With no knowledge of what will be written, calls {@link #clearAtnl()} to be safe.
	 * </p>
	 *
	 * @return  a writer for direct output, which will ignore any calls to {@link Writer#close()}
	 *          to be safely used in a try-with-resources block.
	 */
	Writer unsafe() throws IOException;
	// </editor-fold>

	// <editor-fold desc="Automatic Newline and Indentation">
	/**
	 * Gets if automatic newline (and indentation when {@linkplain #getIndent() enabled}) is currently enabled,
	 * off by default.
	 */
	boolean getAutonli();

	/**
	 * Enables or disabled automatic newline (and indentation when {@linkplain #getIndent() enabled}).
	 *
	 * @return  {@code this} writer
	 */
	C setAutonli(boolean autonli);

	/**
	 * Gets the at newline flag.
	 */
	boolean getAtnl();

	/**
	 * Flags is at a newline.
	 *
	 * @return  {@code this} writer
	 */
	C setAtnl();

	/**
	 * Sets the at newline flag.
	 *
	 * @return  {@code this} writer
	 */
	C setAtnl(boolean atnl);

	/**
	 * Clears the at newline flag.
	 *
	 * @return  {@code this} writer
	 */
	C clearAtnl();

	/**
	 * Performs automatic newline when
	 * {@link #getAutonli()} and not {@link #getAtnl()}.
	 *
	 * @return  {@code this} writer
	 */
	C autoNl() throws IOException;

	/**
	 * Performs automatic newline when {@link #getAutonli()} and not {@link #getAtnl()},
	 * followed by automatic indentation when {@linkplain #getIndent() enabled})
	 *
	 * @return  {@code this} writer
	 */
	C autoNli() throws IOException;

	/**
	 * Performs automatic newline when {@link #getAutonli()} and not {@link #getAtnl()},
	 * followed by automatic indentation with a depth offset when {@linkplain #getIndent() enabled})
	 *
	 * @param  depthOffset  A value added to the current indentation depth.
	 *                      For example, pass {@code -1} when performing a newline before a closing tag or ending curly brace.
	 *
	 * @return  {@code this} writer
	 */
	C autoNli(int depthOffset) throws IOException;

	/**
	 * Performs automatic indentation when
	 * {@link #getAutonli()}, {@link #getIndent()}, and {@link #getAtnl()}.
	 *
	 * @return  {@code this} writer
	 */
	C autoIndent() throws IOException;

	/**
	 * Performs automatic indentation with a depth offset when
	 * {@link #getAutonli()}, {@link #getIndent()}, and {@link #getAtnl()}.
	 *
	 * @param  depthOffset  A value added to the current indentation depth.
	 *                      For example, pass {@code -1} when performing a newline before a closing tag or ending curly brace.
	 *
	 * @return  {@code this} writer
	 */
	C autoIndent(int depthOffset) throws IOException;
	// </editor-fold>
}
