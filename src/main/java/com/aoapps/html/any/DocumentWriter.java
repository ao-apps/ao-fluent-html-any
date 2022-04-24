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

import com.aoapps.encoding.Whitespace;
import com.aoapps.lang.Coercion;
import com.aoapps.lang.io.NoClose;
import com.aoapps.lang.io.Writable;
import com.aoapps.lang.io.function.IOSupplierE;
import java.io.IOException;
import java.io.Writer;

/**
 * Allows writing raw document output.
 *
 * @author  AO Industries, Inc.
 */
public interface DocumentWriter extends Whitespace {

  // <editor-fold desc="Whitespace - manual self-type" defaultstate="collapsed">
  @Override
  DocumentWriter nl() throws IOException;

  @Override
  default DocumentWriter nli() throws IOException {
    Whitespace.super.nli();
    return this;
  }

  @Override
  default DocumentWriter nli(int depthOffset) throws IOException {
    Whitespace.super.nli(depthOffset);
    return this;
  }

  @Override
  default DocumentWriter indent() throws IOException {
    Whitespace.super.indent();
    return this;
  }

  @Override
  default DocumentWriter indent(int depthOffset) throws IOException {
    Whitespace.super.indent(depthOffset);
    return this;
  }

  @Override
  DocumentWriter setIndent(boolean indent);

  @Override
  DocumentWriter setDepth(int depth);

  @Override
  DocumentWriter incDepth();

  @Override
  DocumentWriter decDepth();

  @Override
  default DocumentWriter sp() throws IOException {
    Whitespace.super.sp();
    return this;
  }

  @Override
  DocumentWriter sp(int count) throws IOException;

  // </editor-fold>

  // <editor-fold desc="Unsafe - definition" defaultstate="collapsed">
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
   * @return  The writer, already optimized via {@link Coercion#optimize(java.io.Writer, com.aoapps.lang.io.Encoder)}
   *          with {@code encoder = null}.
   *
   * @throws  IllegalStateException  when output has been set to {@code null}.
   *
   * @see  #getRawUnsafe()
   * @see  AnyDocument#setOut(java.io.Writer)
   *
   * @deprecated  This method will remain, but its use is discouraged as it can be dangerous
   */
  @Deprecated
  Writer getRawUnsafe(Boolean endsNewline) throws IllegalStateException;

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
   * @return  The writer, already optimized via {@link Coercion#optimize(java.io.Writer, com.aoapps.lang.io.Encoder)}
   *          with {@code encoder = null}.
   *
   * @throws  IllegalStateException  when output has been set to {@code null}.
   *
   * @see  #getRawUnsafe(java.lang.Boolean)
   * @see  AnyDocument#setOut(java.io.Writer)
   *
   * @deprecated  This method will remain, but its use is discouraged as it can be dangerous
   */
  @Deprecated
  Writer getRawUnsafe() throws IllegalStateException;

  /**
   * Performs raw output of a single character, automatically determining {@link #setAtnl(boolean)}.
   *
   * @return  {@code this} writer
   *
   * @deprecated  This method will remain, but its use is discouraged as it can be dangerous
   */
  @Deprecated
  DocumentWriter unsafe(char ch) throws IOException;

  /**
   * Performs raw output, automatically determining {@link #setAtnl(boolean)}.
   *
   * @return  {@code this} writer
   *
   * @deprecated  This method will remain, but its use is discouraged as it can be dangerous
   */
  @Deprecated
  DocumentWriter unsafe(char[] cbuf) throws IOException;

  /**
   * Performs raw output, automatically determining {@link #setAtnl(boolean)}.
   *
   * @return  {@code this} writer
   *
   * @deprecated  This method will remain, but its use is discouraged as it can be dangerous
   */
  @Deprecated
  DocumentWriter unsafe(char[] cbuf, int offset, int len) throws IOException;

  /**
   * Performs raw output, automatically determining {@link #setAtnl(boolean)}.
   *
   * @return  {@code this} writer
   *
   * @deprecated  This method will remain, but its use is discouraged as it can be dangerous
   */
  @Deprecated
  DocumentWriter unsafe(CharSequence csq) throws IOException;

  /**
   * Performs raw output, automatically determining {@link #setAtnl(boolean)}.
   *
   * @return  {@code this} writer
   *
   * @deprecated  This method will remain, but its use is discouraged as it can be dangerous
   */
  @Deprecated
  DocumentWriter unsafe(CharSequence csq, int start, int end) throws IOException;

  /**
   * Performs raw output, automatically determining {@link #setAtnl(boolean)}.
   * <p>
   * When no knowledge of what will be written, calls {@link #clearAtnl()} to be safe.
   * </p>
   *
   * @return  {@code this} writer
   *
   * @deprecated  This method will remain, but its use is discouraged as it can be dangerous
   */
  @Deprecated
  DocumentWriter unsafe(Object unsafe) throws IOException;

  /**
   * Performs raw output, automatically determining {@link #setAtnl(boolean)}.
   * <p>
   * When no knowledge of what will be written, calls {@link #clearAtnl()} to be safe.
   * </p>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @return  {@code this} writer
   *
   * @deprecated  This method will remain, but its use is discouraged as it can be dangerous
   */
  @Deprecated
  <Ex extends Throwable> DocumentWriter unsafe(IOSupplierE<?, Ex> unsafe) throws IOException, Ex;

  /**
   * Performs raw output.
   * <p>
   * With no knowledge of what will be written, calls {@link #clearAtnl()} to be safe.
   * </p>
   *
   * @return  {@code this} writer
   *
   * @deprecated  This method will remain, but its use is discouraged as it can be dangerous
   */
  @Deprecated
  DocumentWriter unsafe(Writable unsafe) throws IOException;

  /**
   * Performs raw output.
   * This is well suited for use in a try-with-resources block.
   * <p>
   * With no knowledge of what will be written, calls {@link #clearAtnl()} to be safe.
   * </p>
   *
   * @return  a writer for direct output, which will ignore any calls to {@link Writer#close()}
   *          to be safely used in a try-with-resources block.
   *
   * @deprecated  This method will remain, but its use is discouraged as it can be dangerous
   */
  @Deprecated
  <W extends Writer & NoClose> W unsafe() throws IOException;

  // </editor-fold>

  // <editor-fold desc="Automatic Newline and Indentation - definition" defaultstate="collapsed">
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
  DocumentWriter setAutonli(boolean autonli);

  /**
   * Gets the at newline flag.
   */
  boolean getAtnl();

  /**
   * Flags is at a newline.
   *
   * @return  {@code this} writer
   */
  DocumentWriter setAtnl();

  /**
   * Sets the at newline flag.
   *
   * @return  {@code this} writer
   */
  DocumentWriter setAtnl(boolean atnl);

  /**
   * Clears the at newline flag.
   *
   * @return  {@code this} writer
   */
  DocumentWriter clearAtnl();

  /**
   * Performs automatic newline when
   * {@link #getAutonli()} and not {@link #getAtnl()}.
   *
   * @return  {@code this} writer
   */
  DocumentWriter autoNl() throws IOException;

  /**
   * Performs automatic newline when {@link #getAutonli()} and not {@link #getAtnl()},
   * followed by automatic indentation when {@linkplain #getIndent() enabled})
   *
   * @return  {@code this} writer
   */
  DocumentWriter autoNli() throws IOException;

  /**
   * Performs automatic newline when {@link #getAutonli()} and not {@link #getAtnl()},
   * followed by automatic indentation with a depth offset when {@linkplain #getIndent() enabled})
   *
   * @param  depthOffset  A value added to the current indentation depth.
   *                      For example, pass {@code -1} when performing a newline before a closing tag or ending curly brace.
   *
   * @return  {@code this} writer
   */
  DocumentWriter autoNli(int depthOffset) throws IOException;

  /**
   * Performs automatic indentation when
   * {@link #getAutonli()}, {@link #getIndent()}, and {@link #getAtnl()}.
   *
   * @return  {@code this} writer
   */
  DocumentWriter autoIndent() throws IOException;

  /**
   * Performs automatic indentation with a depth offset when
   * {@link #getAutonli()}, {@link #getIndent()}, and {@link #getAtnl()}.
   *
   * @param  depthOffset  A value added to the current indentation depth.
   *                      For example, pass {@code -1} when performing a newline before a closing tag or ending curly brace.
   *
   * @return  {@code this} writer
   */
  DocumentWriter autoIndent(int depthOffset) throws IOException;
  // </editor-fold>
}
