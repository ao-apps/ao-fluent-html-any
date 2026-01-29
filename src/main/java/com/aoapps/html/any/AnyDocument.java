/*
 * ao-fluent-html-any - Base abstract classes and interfaces for Fluent Java DSL for high-performance HTML generation.
 * Copyright (C) 2019, 2020, 2021, 2022, 2024, 2025  AO Industries, Inc.
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

import static com.aoapps.encoding.TextInXhtmlEncoder.encodeTextInXhtml;
import static com.aoapps.encoding.TextInXhtmlEncoder.textInXhtmlEncoder;

import com.aoapps.encoding.BufferedValidator;
import com.aoapps.encoding.Doctype;
import com.aoapps.encoding.EncodingContext;
import com.aoapps.encoding.MediaEncoder;
import com.aoapps.encoding.MediaType;
import com.aoapps.encoding.MediaValidator;
import com.aoapps.encoding.MediaWritable;
import com.aoapps.encoding.MediaWriter;
import com.aoapps.encoding.NoCloseMediaValidator;
import com.aoapps.encoding.TextWritable;
import com.aoapps.encoding.TextWriter;
import com.aoapps.encoding.ValidateOnlyEncoder;
import com.aoapps.encoding.WriterUtil;
import com.aoapps.hodgepodge.i18n.BundleLookupMarkup;
import com.aoapps.hodgepodge.i18n.BundleLookupThreadContext;
import com.aoapps.hodgepodge.i18n.MarkupCoercion;
import com.aoapps.hodgepodge.i18n.MarkupType;
import com.aoapps.lang.Coercion;
import com.aoapps.lang.LocalizedIllegalStateException;
import com.aoapps.lang.Throwables;
import com.aoapps.lang.io.NoClose;
import com.aoapps.lang.io.NullWriter;
import com.aoapps.lang.io.Writable;
import com.aoapps.lang.io.function.IOSupplierE;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * Fluent Java DSL for high-performance HTML generation.
 *
 * <p>This class implements all content interfaces and supports all element types.</p>
 *
 * <p>See also <a href="https://github.com/xmlet/HtmlFlow">HtmlFlow</a>.</p>
 *
 * @param  <D>   This document type
 *
 * @author  AO Industries, Inc.
 */
public abstract class AnyDocument<D extends AnyDocument<D>> implements AnyContent<D, D> {

  /**
   * The default, and recommended, encoding for (X)HTML.
   */
  public static final Charset ENCODING = StandardCharsets.UTF_8;

  static final com.aoapps.lang.i18n.Resources RESOURCES =
      com.aoapps.lang.i18n.Resources.getResources(ResourceBundle::getBundle, AnyDocument.class);

  public final EncodingContext encodingContext;

  /**
   * Writer for raw output.
   *
   * <p>Direct use of this output may throw-off the automatic newlines and indentation.  Please use any of the
   * {@code unsafe(…)} methods.</p>
   *
   * <p>Already optimized via {@link Coercion#optimize(java.io.Writer, com.aoapps.lang.io.Encoder)}
   * with {@code encoder = null}.</p>
   *
   * @see  AnyDocument#unsafe()
   * @see  AnyDocument#getRawUnsafe()
   * @see  AnyDocument#getRawUnsafe(java.lang.Boolean)
   * @see  AnyDocument#setOut(java.io.Writer)
   */
  // TODO: Wrap this writer in XhtmlValidator if is not already validating XHTML?
  //       If wrapping, consider uses of this losing access to this wrapping, such as optimizations done by MediaValidator
  // TODO: Does this need to be thread-safe, such as DocumentEE inside concurrent sub-requests?
  //       Perhaps need to review thread safety of the API overall?
  //       Maybe elements and attributes need not be thread-safe, but document and contexts should be?
  private Writer optimized;

  /**
   * @param  out  May be {@code null}, but must be set to a non-null value again before any additional writes.
   *              Not doing so may result in {@link IllegalStateException}.
   *
   *              <p>Will be through {@link Coercion#optimize(java.io.Writer, com.aoapps.lang.io.Encoder)}
   *              with {@code encoder = null}.</p>
   *
   * @see  AnyDocument#setOut(java.io.Writer)
   */
  protected AnyDocument(EncodingContext encodingContext, Writer out) {
    this.encodingContext = encodingContext;
    this.optimized = (out == null) ? null : Coercion.optimize(out, null);
  }

  /**
   * Replaces the writer this document is writing to.
   *
   * @param  out  May be {@code null}, but must be set to a non-null value again before any additional writes.
   *              Not doing so may result in {@link IllegalStateException}.
   *
   *              <p>Will be through {@link Coercion#optimize(java.io.Writer, com.aoapps.lang.io.Encoder)}
   *              with {@code encoder = null}.</p>
   *
   * @see  AnyDocument#getRawUnsafe()
   * @see  AnyDocument#getRawUnsafe(java.lang.Boolean)
   */
  public void setOut(Writer out) {
    this.optimized = (out == null) ? null : Coercion.optimize(out, null);
  }

  @Override
  public D getDocument() {
    @SuppressWarnings("unchecked")
    D d = (D) this;
    return d;
  }

  // <editor-fold desc="Whitespace - implementation" defaultstate="collapsed">
  /**
   * Is indenting enabled.
   */
  // Matches WhitespaceWriter.indent
  private boolean indent;

  /**
   * Current indentation level.
   */
  // Matches WhitespaceWriter.depth
  private int depth;

  // Matches WhitespaceWriter.nl()
  @Override
  public D nl() throws IOException {
    return nl(getRawUnsafe(null));
  }

  D nl(Writer unsafe) throws IOException {
    unsafe.append(NL);
    setAtnl();
    @SuppressWarnings("unchecked")
    D d = (D) this;
    return d;
  }

  // Matches WhitespaceWriter.nli()
  @Override
  public D nli() throws IOException {
    return nli(getRawUnsafe(null), 0);
  }

  D nli(Writer unsafe) throws IOException {
    return nli(unsafe, 0);
  }

  // Matches WhitespaceWriter.nli(int)
  @Override
  public D nli(int depthOffset) throws IOException {
    return nli(getRawUnsafe(null), depthOffset);
  }

  D nli(Writer unsafe, int depthOffset) throws IOException {
    if (getIndent()) {
      int d = getDepth();
      assert d >= 0;
      d += depthOffset;
      int spaces;
      if (d < 0) {
        // Handle underflow and overflow
        spaces = (depthOffset < 0) ? 0 : Integer.MAX_VALUE;
      } else if (d > (Integer.MAX_VALUE / INDENT_SPACES)) {
        spaces = Integer.MAX_VALUE;
      } else {
        spaces = d * INDENT_SPACES;
      }
      if (spaces > 0) {
        WriterUtil.nlsp(unsafe, spaces);
        return clearAtnl();
      }
    }
    unsafe.append(NL);
    return setAtnl();
  }

  // Matches WhitespaceWriter.indent()
  @Override
  @SuppressWarnings("deprecation")
  public D indent() throws IOException {
    return indent(getRawUnsafe(null), 0);
  }

  D indent(Writer unsafe) throws IOException {
    return indent(unsafe, 0);
  }

  // Matches WhitespaceWriter.indent(int)
  @Override
  @SuppressWarnings("deprecation")
  public D indent(int depthOffset) throws IOException {
    return indent(getRawUnsafe(null), depthOffset);
  }

  D indent(Writer unsafe, int depthOffset) throws IOException {
    if (getIndent()) {
      int d = getDepth();
      assert d >= 0;
      d += depthOffset;
      int spaces;
      if (d < 0) {
        // Handle underflow and overflow
        spaces = (depthOffset < 0) ? 0 : Integer.MAX_VALUE;
      } else if (d > (Integer.MAX_VALUE / INDENT_SPACES)) {
        spaces = Integer.MAX_VALUE;
      } else {
        spaces = d * INDENT_SPACES;
      }
      if (spaces > 0) {
        WriterUtil.sp(unsafe, spaces);
        clearAtnl();
      }
    }
    @SuppressWarnings("unchecked")
    D d = (D) this;
    return d;
  }

  // Matches WhitespaceWriter.getIndent()
  // TODO: Document these, since "Delegates to" in description is misleading
  @Override
  @SuppressWarnings("deprecation")
  public boolean getIndent() {
    return indent;
  }

  // Matches WhitespaceWriter.setIndent(int)
  @Override
  @SuppressWarnings("deprecation")
  public D setIndent(boolean indent) {
    this.indent = indent;
    @SuppressWarnings("unchecked")
    D d = (D) this;
    return d;
  }

  // Matches WhitespaceWriter.getDepth()
  @Override
  @SuppressWarnings("deprecation")
  public int getDepth() {
    return depth;
  }

  // Matches WhitespaceWriter.setDepth(int)
  @Override
  @SuppressWarnings("deprecation")
  public D setDepth(int depth) {
    if (depth < 0) {
      throw new IllegalArgumentException("depth < 0: " + depth);
    }
    this.depth = depth;
    @SuppressWarnings("unchecked")
    D d = (D) this;
    return d;
  }

  // Matches WhitespaceWriter.incDepth()
  @Override
  @SuppressWarnings("deprecation")
  public D incDepth() {
    if (getIndent()) {
      int d = ++depth;
      if (d < 0) {
        depth = Integer.MAX_VALUE;
      }
    }
    assert depth >= 0;
    @SuppressWarnings("unchecked")
    D d = (D) this;
    return d;
  }

  // Matches WhitespaceWriter.decDepth()
  @Override
  @SuppressWarnings("deprecation")
  public D decDepth() {
    if (getIndent()) {
      int d = --depth;
      if (d < 0) {
        depth = 0;
      }
    }
    assert depth >= 0;
    @SuppressWarnings("unchecked")
    D d = (D) this;
    return d;
  }

  // Matches WhitespaceWriter.sp()
  @Override
  public D sp() throws IOException {
    return sp(getRawUnsafe(null));
  }

  D sp(Writer unsafe) throws IOException {
    unsafe.append(SPACE);
    return clearAtnl();
  }

  // Matches WhitespaceWriter.sp(int)
  @Override
  public D sp(int count) throws IOException {
    return sp(getRawUnsafe(null), count);
  }

  D sp(Writer unsafe, int count) throws IOException {
    if (count > 0) {
      WriterUtil.sp(unsafe, count);
      clearAtnl();
    }
    @SuppressWarnings("unchecked")
    D d = (D) this;
    return d;
  }

  // </editor-fold>

  // <editor-fold desc="DocumentWriter / Unsafe - implementation" defaultstate="collapsed">
  /**
   * {@inheritDoc}
   *
   * @deprecated  This method will remain, but its use is discouraged as it can be dangerous
   */
  @Deprecated(forRemoval = false)
  @Override
  public Writer getRawUnsafe(Boolean endsNewline) throws IllegalStateException {
    Writer unsafe = optimized;
    if (unsafe == null) {
      throw new LocalizedIllegalStateException(RESOURCES, "getRawUnsafe.noOut");
    }
    assert unsafe == Coercion.optimize(unsafe, null);
    if (endsNewline != null) {
      setAtnl(endsNewline);
    }
    return unsafe;
  }

  /**
   * {@inheritDoc}
   *
   * @deprecated  This method will remain, but its use is discouraged as it can be dangerous
   */
  @Deprecated(forRemoval = false)
  @Override
  public Writer getRawUnsafe() throws IllegalStateException {
    return getRawUnsafe(false);
  }

  /**
   * {@inheritDoc}
   *
   * @return  {@code this} document
   *
   * @deprecated  This method will remain, but its use is discouraged as it can be dangerous
   */
  @Deprecated(forRemoval = false)
  @Override
  public D unsafe(char ch) throws IOException {
    return unsafe(getRawUnsafe(null), ch);
  }

  D unsafe(Writer unsafe, char ch) throws IOException {
    unsafe.append(ch);
    return setAtnl(ch == NL);
  }

  /**
   * {@inheritDoc}
   *
   * @return  {@code this} document
   *
   * @deprecated  This method will remain, but its use is discouraged as it can be dangerous
   */
  @Deprecated(forRemoval = false)
  @Override
  public D unsafe(char[] cbuf) throws IOException {
    if (cbuf != null) {
      int len = cbuf.length;
      if (len > 0) {
        unsafe(
            getRawUnsafe(null),
            cbuf,
            cbuf[len - 1] == NL
        );
      }
    }
    @SuppressWarnings("unchecked")
    D d = (D) this;
    return d;
  }

  /**
   * Performs raw output of a non-empty array.
   *
   * @param  endsNewline  Declares the array ends in a newline.
   *                      Calls {@link AnyDocument#setAtnl(boolean)} after the write.
   *                      This is an optimization that is verified when assertions are enabled.
   *
   * @return  {@code this} document
   */
  D unsafe(Writer unsafe, char[] cbuf, boolean endsNewline) throws IOException {
    assert cbuf.length > 0;
    unsafe.write(cbuf);
    assert endsNewline == (cbuf[cbuf.length - 1] == NL);
    return setAtnl(endsNewline);
  }

  /**
   * {@inheritDoc}
   *
   * @return  {@code this} document
   *
   * @deprecated  This method will remain, but its use is discouraged as it can be dangerous
   */
  @Deprecated(forRemoval = false)
  @Override
  public D unsafe(char[] cbuf, int offset, int len) throws IOException {
    if (cbuf != null && len > 0) {
      unsafe(
          getRawUnsafe(null),
          cbuf,
          offset,
          len,
          cbuf[offset + len - 1] == NL
      );
    }
    @SuppressWarnings("unchecked")
    D d = (D) this;
    return d;
  }

  /**
   * Performs raw output of a non-empty array.
   *
   * @param  endsNewline  Declares the array ends in a newline.
   *                      Calls {@link AnyDocument#setAtnl(boolean)} after the write.
   *                      This is an optimization that is verified when assertions are enabled.
   *
   * @return  {@code this} document
   */
  D unsafe(Writer unsafe, char[] cbuf, int offset, int len, boolean endsNewline) throws IOException {
    assert len > 0;
    unsafe.write(cbuf, offset, len);
    assert endsNewline == (cbuf[offset + len - 1] == NL);
    return setAtnl(endsNewline);
  }

  /**
   * {@inheritDoc}
   *
   * @return  {@code this} document
   *
   * @deprecated  This method will remain, but its use is discouraged as it can be dangerous
   */
  @Deprecated(forRemoval = false)
  @Override
  public D unsafe(CharSequence csq) throws IOException {
    if (csq != null) {
      int len = csq.length();
      if (len > 0) {
        unsafe(
            getRawUnsafe(null),
            csq,
            csq.charAt(len - 1) == NL
        );
      }
    }
    @SuppressWarnings("unchecked")
    D d = (D) this;
    return d;
  }

  /**
   * Performs raw output of a non-empty sequence.
   *
   * @param  endsNewline  Declares the sequence ends in a newline.
   *                      Calls {@link AnyDocument#setAtnl(boolean)} after the write.
   *                      This is an optimization that is verified when assertions are enabled.
   *
   * @return  {@code this} document
   */
  D unsafe(Writer unsafe, CharSequence csq, boolean endsNewline) throws IOException {
    assert csq.length() > 0;
    unsafe.append(csq);
    assert endsNewline == (csq.charAt(csq.length() - 1) == NL);
    return setAtnl(endsNewline);
  }

  /**
   * {@inheritDoc}
   *
   * @return  {@code this} document
   *
   * @deprecated  This method will remain, but its use is discouraged as it can be dangerous
   */
  @Deprecated(forRemoval = false)
  @Override
  public D unsafe(CharSequence csq, int start, int end) throws IOException {
    if (csq != null && end > start) {
      unsafe(
          getRawUnsafe(null),
          csq,
          start,
          end,
          csq.charAt(end - 1) == NL
      );
    }
    @SuppressWarnings("unchecked")
    D d = (D) this;
    return d;
  }

  /**
   * Performs raw output of a non-empty sequence.
   *
   * @param  endsNewline  Declares the sequence ends in a newline.
   *                      Calls {@link AnyDocument#setAtnl(boolean)} after the write.
   *                      This is an optimization that is verified when assertions are enabled.
   *
   * @return  {@code this} document
   */
  D unsafe(Writer unsafe, CharSequence csq, int start, int end, boolean endsNewline) throws IOException {
    assert end > start;
    unsafe.append(csq, start, end);
    assert endsNewline == (csq.charAt(end - 1) == NL);
    return setAtnl(endsNewline);
  }

  /**
   * {@inheritDoc}
   *
   * @return  {@code this} document
   *
   * @deprecated  This method will remain, but its use is discouraged as it can be dangerous
   */
  @Deprecated(forRemoval = false)
  @Override
  public D unsafe(Object unsafe) throws IOException {
    return unsafe(getRawUnsafe(null), unsafe);
  }

  @SuppressWarnings("UseSpecificCatch")
  D unsafe(Writer unsafe, Object value) throws IOException {
    // Support Optional
    while (value instanceof Optional) {
      value = ((Optional<?>) value).orElse(null);
    }
    while (value instanceof IOSupplierE<?, ?>) {
      try {
        value = ((IOSupplierE<?, ?>) value).get();
      } catch (Throwable t) {
        throw Throwables.wrap(t, IOException.class, IOException::new);
      }
    }
    if (value != null) {
      if (value instanceof char[]) {
        char[] cbuf = (char[]) value;
        int len = cbuf.length;
        if (len > 0) {
          return unsafe(
              unsafe,
              cbuf,
              cbuf[len - 1] == NL
          );
        } else {
          // Nothing to write
          @SuppressWarnings("unchecked")
          D d = (D) this;
          return d;
        }
      }
      if (value instanceof CharSequence) {
        CharSequence csq = (CharSequence) value;
        int len = csq.length();
        if (len > 0) {
          return unsafe(
              unsafe,
              csq,
              csq.charAt(len - 1) == NL
          );
        } else {
          // Nothing to write
          @SuppressWarnings("unchecked")
          D d = (D) this;
          return d;
        }
      }
      if (value instanceof Writable) {
        return unsafe(unsafe, (Writable) value);
      }
      // Allow no markup from translations
      Coercion.write(value, unsafe);
      clearAtnl(); // Unknown, safe to assume not at newline
    }
    @SuppressWarnings("unchecked")
    D d = (D) this;
    return d;
  }

  /**
   * {@inheritDoc}
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @return  {@code this} document
   *
   * @deprecated  This method will remain, but its use is discouraged as it can be dangerous
   */
  @Deprecated(forRemoval = false)
  @Override
  public <Ex extends Throwable> D unsafe(IOSupplierE<?, Ex> unsafe) throws IOException, Ex {
    return unsafe(getRawUnsafe(null), unsafe);
  }

  <Ex extends Throwable> D unsafe(Writer unsafe, IOSupplierE<?, Ex> value) throws IOException, Ex {
    return unsafe(unsafe, (value == null) ? null : value.get());
  }

  /**
   * {@inheritDoc}
   *
   * @return  {@code this} document
   *
   * @deprecated  This method will remain, but its use is discouraged as it can be dangerous
   */
  @Deprecated(forRemoval = false)
  @Override
  public D unsafe(Writable unsafe) throws IOException {
    return unsafe(getRawUnsafe(null), unsafe);
  }

  D unsafe(Writer unsafe, Writable value) throws IOException {
    if (value != null) {
      if (value.isFastToString()) {
        String str = value.toString();
        int len = str.length();
        if (len > 0) {
          unsafe(
              unsafe,
              str,
              str.charAt(len - 1) == NL
          );
        }
      } else {
        try (Writer _out = unsafe(unsafe)) {
          value.writeTo(_out);
        }
      }
    }
    @SuppressWarnings("unchecked")
    D d = (D) this;
    return d;
  }

  /**
   * {@inheritDoc}
   *
   * @deprecated  This method will remain, but its use is discouraged as it can be dangerous
   */
  @Deprecated(forRemoval = false)
  @Override
  public <W extends Writer & NoClose> W unsafe() throws IOException {
    return unsafe(getRawUnsafe(null));
  }

  /**
   * Calls {@link AnyDocument#clearAtnl()} then wraps the given writer via {@link NoCloseMediaValidator#wrap(java.io.Writer)}
   * to ignore against calls to {@link Writer#close()}.
   */
  <W extends Writer & NoClose> W unsafe(Writer unsafe) {
    clearAtnl(); // Unknown, safe to assume not at newline
    return NoCloseMediaValidator.wrap(unsafe);
  }
  // </editor-fold>

  // <editor-fold desc="DocumentWriter / Automatic Newline and Indentation - implementation" defaultstate="collapsed">
  /**
   * Is automatic newline and indenting enabled.
   */
  private boolean autonli;

  @Override
  @SuppressWarnings("deprecation")
  public boolean getAutonli() {
    return autonli;
  }

  /**
   * {@inheritDoc}
   *
   * @return  {@code this} document
   */
  @Override
  @SuppressWarnings("deprecation")
  public D setAutonli(boolean autonli) {
    this.autonli = autonli;
    @SuppressWarnings("unchecked")
    D d = (D) this;
    return d;
  }

  /**
   * Is the output currently at a newline.
   */
  private boolean atnl;

  @Override
  @SuppressWarnings("deprecation")
  public boolean getAtnl() {
    return atnl;
  }

  /**
   * {@inheritDoc}
   *
   * @return  {@code this} document
   */
  @Override
  @SuppressWarnings("deprecation")
  public D setAtnl() {
    this.atnl = true;
    @SuppressWarnings("unchecked")
    D d = (D) this;
    return d;
  }

  /**
   * {@inheritDoc}
   *
   * @return  {@code this} document
   */
  @Override
  @SuppressWarnings("deprecation")
  public D setAtnl(boolean atnl) {
    this.atnl = atnl;
    @SuppressWarnings("unchecked")
    D d = (D) this;
    return d;
  }

  /**
   * {@inheritDoc}
   *
   * @return  {@code this} document
   */
  @Override
  @SuppressWarnings("deprecation")
  public D clearAtnl() {
    this.atnl = false;
    @SuppressWarnings("unchecked")
    D d = (D) this;
    return d;
  }

  /**
   * {@inheritDoc}
   *
   * @return  {@code this} document
   */
  @Override
  public D autoNl() throws IOException {
    return autoNl(getRawUnsafe(null));
  }

  D autoNl(Writer unsafe) throws IOException {
    if (getAutonli() && !getAtnl()) {
      unsafe.append(NL);
      setAtnl();
    }
    @SuppressWarnings("unchecked")
    D d = (D) this;
    return d;
  }

  /**
   * {@inheritDoc}
   *
   * @return  {@code this} document
   */
  @Override
  public D autoNli() throws IOException {
    return autoNli(getRawUnsafe(null), 0);
  }

  D autoNli(Writer unsafe) throws IOException {
    return autoNli(unsafe, 0);
  }

  /**
   * {@inheritDoc}
   *
   * @return  {@code this} document
   */
  @Override
  public D autoNli(int depthOffset) throws IOException {
    return autoNli(getRawUnsafe(null), depthOffset);
  }

  D autoNli(Writer unsafe, int depthOffset) throws IOException {
    if (getAutonli()) {
      if (getAtnl()) {
        // Already at newline, indentation only
        indent(unsafe, depthOffset);
      } else {
        // Combined newline and indentation
        nli(unsafe, depthOffset);
      }
    }
    @SuppressWarnings("unchecked")
    D d = (D) this;
    return d;
  }

  /**
   * {@inheritDoc}
   *
   * @return  {@code this} document
   */
  @Override
  @SuppressWarnings("deprecation")
  public D autoIndent() throws IOException {
    return autoIndent(getRawUnsafe(null), 0);
  }

  D autoIndent(Writer unsafe) throws IOException {
    return autoIndent(unsafe, 0);
  }

  /**
   * {@inheritDoc}
   *
   * @return  {@code this} document
   */
  @Override
  @SuppressWarnings("deprecation")
  public D autoIndent(int depthOffset) throws IOException {
    return autoIndent(getRawUnsafe(null), depthOffset);
  }

  D autoIndent(Writer unsafe, int depthOffset) throws IOException {
    if (getAutonli() && getAtnl()) {
      indent(unsafe, depthOffset);
    }
    @SuppressWarnings("unchecked")
    D d = (D) this;
    return d;
  }

  // </editor-fold>

  // <editor-fold desc="Encode - manual self-type and implementation" defaultstate="collapsed">
  /**
   * {@inheritDoc}
   *
   * @return  {@code this} document
   */
  @Override
  public D encode(MediaType contentType, char ch) throws IOException {
    if (contentType == MediaType.TEXT) {
      return text(ch);
    } else {
      return AnyContent.super.encode(contentType, ch);
    }
  }

  /**
   * {@inheritDoc}
   *
   * @return  {@code this} document
   */
  @Override
  public D encode(MediaType contentType, char[] cbuf) throws IOException {
    if (contentType == MediaType.TEXT) {
      return text(cbuf);
    } else {
      return AnyContent.super.encode(contentType, cbuf);
    }
  }

  /**
   * {@inheritDoc}
   *
   * @return  {@code this} document
   */
  @Override
  public D encode(MediaType contentType, char[] cbuf, int offset, int len) throws IOException {
    if (contentType == MediaType.TEXT) {
      return text(cbuf, offset, len);
    } else {
      return AnyContent.super.encode(contentType, cbuf, offset, len);
    }
  }

  /**
   * {@inheritDoc}
   *
   * @return  {@code this} document
   */
  @Override
  public D encode(MediaType contentType, CharSequence csq) throws IOException {
    if (contentType == MediaType.TEXT) {
      return text(csq);
    } else {
      // Allow text markup from translations
      Writer unsafe = getRawUnsafe(null);
      if (contentType == MediaType.XHTML) {
        // Already in the requested media type, no prefix/suffix required
        BundleLookupThreadContext threadContext;
        if (
            csq == null
                || (threadContext = BundleLookupThreadContext.getThreadContext()) == null
                // Other types that will not be converted to String for bundle lookups
                || !(csq instanceof String)
        ) {
          int len;
          if (csq != null && (len = csq.length()) > 0) {
            if (csq.charAt(len - 1) == NL) {
              if (len == 1) {
                unsafe.write(NL);
              } else {
                autoIndent(unsafe);
                unsafe.append(csq);
              }
              setAtnl();
            } else {
              autoIndent(unsafe);
              unsafe.append(csq);
              clearAtnl();
            }
          }
        } else {
          String str = (String) csq;
          BundleLookupMarkup lookupMarkup = threadContext.getLookupMarkup(str);
          if (lookupMarkup != null) {
            autoIndent(unsafe);
            lookupMarkup.appendPrefixTo(MarkupType.XHTML, unsafe);
            unsafe.write(str);
            lookupMarkup.appendSuffixTo(MarkupType.XHTML, unsafe);
            clearAtnl(); // Unknown, safe to assume not at newline
          } else {
            int len = str.length();
            if (len > 0) {
              if (str.charAt(len - 1) == NL) {
                if (len == 1) {
                  unsafe.write(NL);
                } else {
                  autoIndent(unsafe);
                  unsafe.write(str);
                }
                setAtnl();
              } else {
                autoIndent(unsafe);
                unsafe.write(str);
                clearAtnl();
              }
            }
          }
        }
      } else {
        autoIndent(unsafe);
        // In different media type, need prefix/suffix
        MediaEncoder encoder = MediaEncoder.getInstance(encodingContext, contentType, MediaType.XHTML);
        if (encoder == null) {
          // Already in a compatible context that does not strictly require character encoding, but still need prefix/suffix
          encoder = new ValidateOnlyEncoder(contentType);
        }
        Writer encoderOptimized = Coercion.optimize(unsafe, encoder);
        if (encoder.isBuffered()) {
          // Do not bypass buffered encoder for markup
          encoder.writePrefixTo(encoderOptimized);
          if (csq != null) {
            MarkupType markupType = contentType.getMarkupType();
            BundleLookupThreadContext threadContext;
            if (
                markupType == MarkupType.NONE
                    || (threadContext = BundleLookupThreadContext.getThreadContext()) == null
                    // Other types that will not be converted to String for bundle lookups
                    || !(csq instanceof String)
            ) {
              encoder.append(csq, encoderOptimized);
            } else {
              String str = (String) csq;
              BundleLookupMarkup lookupMarkup = threadContext.getLookupMarkup(str);
              if (lookupMarkup != null) {
                lookupMarkup.appendPrefixTo(markupType, encoder, encoderOptimized);
              }
              encoder.write(str, encoderOptimized);
              if (lookupMarkup != null) {
                lookupMarkup.appendSuffixTo(markupType, encoder, encoderOptimized);
              }
            }
          }
          encoder.writeSuffixTo(encoderOptimized, false);
        } else {
          // Bypass encoder for markup
          BundleLookupThreadContext threadContext;
          if (
              csq == null
                  || (threadContext = BundleLookupThreadContext.getThreadContext()) == null
                  // Other types that will not be converted to String for bundle lookups
                  || !(csq instanceof String)
          ) {
            encoder.writePrefixTo(encoderOptimized);
            if (csq != null) {
              encoder.append(csq, encoderOptimized);
            }
            encoder.writeSuffixTo(encoderOptimized, false);
          } else {
            String str = (String) csq;
            BundleLookupMarkup lookupMarkup = threadContext.getLookupMarkup(str);
            if (lookupMarkup != null) {
              lookupMarkup.appendPrefixTo(MarkupType.XHTML, encoderOptimized);
            }
            encoder.writePrefixTo(encoderOptimized);
            encoder.write(str, encoderOptimized);
            encoder.writeSuffixTo(encoderOptimized, false);
            if (lookupMarkup != null) {
              lookupMarkup.appendSuffixTo(MarkupType.XHTML, encoderOptimized);
            }
          }
        }
        clearAtnl(); // Unknown, safe to assume not at newline
      }
      @SuppressWarnings("unchecked")
      D d = (D) this;
      return d;
    }
  }

  /**
   * Appends a character sequence while doing auto-indent and tracking end-of-line.
   */
  private void appendCharSequence(Writer unsafe, CharSequence csq, int start, int end) throws IOException {
    if (end > start) {
      int last = end - 1;
      if (csq.charAt(last) == NL) {
        if (start == last) {
          unsafe.write(NL);
        } else {
          autoIndent(unsafe);
          unsafe.append(csq, start, end);
        }
        setAtnl();
      } else {
        autoIndent(unsafe);
        unsafe.append(csq, start, end);
        clearAtnl();
      }
    }
  }

  /**
   * {@inheritDoc}
   *
   * @return  {@code this} document
   */
  @Override
  public D encode(MediaType contentType, CharSequence csq, int start, int end) throws IOException {
    if (contentType == MediaType.TEXT) {
      return text(csq, start, end);
    } else {
      // Allow text markup from translations
      Writer unsafe = getRawUnsafe(null);
      if (contentType == MediaType.XHTML) {
        // Already in the requested media type, no prefix/suffix required
        BundleLookupThreadContext threadContext;
        if (
            csq == null
                || (threadContext = BundleLookupThreadContext.getThreadContext()) == null
                // Other types that will not be converted to String for bundle lookups
                || !(csq instanceof String)
        ) {
          if (csq != null) {
            appendCharSequence(unsafe, csq, start, end);
          }
        } else {
          BundleLookupMarkup lookupMarkup = threadContext.getLookupMarkup((String) csq);
          if (lookupMarkup != null) {
            autoIndent(unsafe);
            lookupMarkup.appendPrefixTo(MarkupType.XHTML, unsafe);
            unsafe.append(csq, start, end);
            lookupMarkup.appendSuffixTo(MarkupType.XHTML, unsafe);
            clearAtnl(); // Unknown, safe to assume not at newline
          } else {
            appendCharSequence(unsafe, csq, start, end);
          }
        }
      } else {
        autoIndent(unsafe);
        // In different media type, need prefix/suffix
        MediaEncoder encoder = MediaEncoder.getInstance(encodingContext, contentType, MediaType.XHTML);
        if (encoder == null) {
          // Already in a compatible context that does not strictly require character encoding, but still need prefix/suffix
          encoder = new ValidateOnlyEncoder(contentType);
        }
        Writer encoderOptimized = Coercion.optimize(unsafe, encoder);
        if (encoder.isBuffered()) {
          // Do not bypass buffered encoder for markup
          encoder.writePrefixTo(encoderOptimized);
          if (csq != null) {
            MarkupType markupType = contentType.getMarkupType();
            BundleLookupThreadContext threadContext;
            if (
                markupType == MarkupType.NONE
                    || (threadContext = BundleLookupThreadContext.getThreadContext()) == null
                    // Other types that will not be converted to String for bundle lookups
                    || !(csq instanceof String)
            ) {
              encoder.append(csq, start, end, encoderOptimized);
            } else {
              BundleLookupMarkup lookupMarkup = threadContext.getLookupMarkup((String) csq);
              if (lookupMarkup != null) {
                lookupMarkup.appendPrefixTo(markupType, encoder, encoderOptimized);
              }
              encoder.append(csq, start, end, encoderOptimized);
              if (lookupMarkup != null) {
                lookupMarkup.appendSuffixTo(markupType, encoder, encoderOptimized);
              }
            }
          }
          encoder.writeSuffixTo(encoderOptimized, false);
        } else {
          // Bypass encoder for markup
          BundleLookupThreadContext threadContext;
          if (
              csq == null
                  || (threadContext = BundleLookupThreadContext.getThreadContext()) == null
                  // Other types that will not be converted to String for bundle lookups
                  || !(csq instanceof String)
          ) {
            encoder.writePrefixTo(encoderOptimized);
            if (csq != null) {
              encoder.append(csq, start, end, encoderOptimized);
            }
            encoder.writeSuffixTo(encoderOptimized, false);
          } else {
            BundleLookupMarkup lookupMarkup = threadContext.getLookupMarkup((String) csq);
            if (lookupMarkup != null) {
              lookupMarkup.appendPrefixTo(MarkupType.XHTML, encoderOptimized);
            }
            encoder.writePrefixTo(encoderOptimized);
            encoder.append(csq, start, end, encoderOptimized);
            encoder.writeSuffixTo(encoderOptimized, false);
            if (lookupMarkup != null) {
              lookupMarkup.appendSuffixTo(MarkupType.XHTML, encoderOptimized);
            }
          }
        }
        clearAtnl(); // Unknown, safe to assume not at newline
      }
      @SuppressWarnings("unchecked")
      D d = (D) this;
      return d;
    }
  }

  /**
   * {@inheritDoc}
   *
   * @return  {@code this} document
   */
  @Override
  @SuppressWarnings("UseSpecificCatch")
  public D encode(MediaType contentType, Object content) throws IOException {
    if (contentType == MediaType.TEXT) {
      return text(content);
    } else {
      // Support Optional
      while (content instanceof Optional) {
        content = ((Optional<?>) content).orElse(null);
      }
      while (content instanceof IOSupplierE<?, ?>) {
        try {
          content = ((IOSupplierE<?, ?>) content).get();
        } catch (Throwable t) {
          throw Throwables.wrap(t, IOException.class, IOException::new);
        }
      }
      if (content instanceof char[]) {
        return encode(contentType, (char[]) content);
      }
      if (content instanceof CharSequence) {
        return encode(contentType, (CharSequence) content);
      }
      if (content instanceof Writable) {
        Writable writable = (Writable) content;
        if (writable.isFastToString()) {
          return encode(contentType, writable.toString());
        }
      }
      if (content instanceof MediaWritable) {
        try {
          return encode(contentType, (MediaWritable<?>) content);
        } catch (Throwable t) {
          throw Throwables.wrap(t, IOException.class, IOException::new);
        }
      }
      // Allow text markup from translations
      Writer unsafe = getRawUnsafe(null);
      autoIndent(unsafe);
      // TODO: Way to temp-disable markups from within OPTION (without value set) and TEXTAREA, or to make HTML comment mark-up only.  All places from AnyTextContent
      if (contentType == MediaType.XHTML) {
        // Already in the requested media type, no prefix/suffix required
        MarkupCoercion.write(
            content,
            MarkupType.XHTML,
            unsafe
        );
      } else {
        // In different media type, need prefix/suffix
        MediaEncoder encoder = MediaEncoder.getInstance(encodingContext, contentType, MediaType.XHTML);
        if (encoder == null) {
          // Already in a compatible context that does not strictly require character encoding, but still need prefix/suffix
          encoder = new ValidateOnlyEncoder(contentType);
        }
        if (encoder.isBuffered()) {
          // Do not bypass buffered encoder for markup
          MarkupCoercion.write(
              content,
              contentType.getMarkupType(),
              true,
              encoder,
              true,
              unsafe
          );
        } else {
          // Bypass encoder for markup
          MarkupCoercion.write(
              content,
              MarkupType.XHTML,
              false,
              encoder,
              true,
              unsafe
          );
        }
      }
      clearAtnl(); // Unknown, safe to assume not at newline
      @SuppressWarnings("unchecked")
      D d = (D) this;
      return d;
    }
  }

  /**
   * {@inheritDoc}
   *
   * @return  {@code this} document
   */
  @Override
  public <Ex extends Throwable> D encode(MediaType contentType, IOSupplierE<?, Ex> content) throws IOException, Ex {
    return AnyContent.super.encode(contentType, content);
  }

  /**
   * {@inheritDoc}
   *
   * @return  {@code this} document
   */
  @Override
  public <Ex extends Throwable> D encode(MediaType contentType, MediaWritable<Ex> content) throws IOException, Ex {
    return AnyContent.super.encode(contentType, content);
  }

  private static final MediaValidator xhtmlValidator = MediaValidator.getMediaValidator(MediaType.XHTML, NullWriter.getInstance());

  static {
    assert !(xhtmlValidator instanceof BufferedValidator) : "If were " + BufferedValidator.class.getName() + " could not share singleton";
  }

  /**
   * {@inheritDoc}
   *
   * @return  {@code this} document
   */
  @Override
  public MediaWriter encode(MediaType contentType) throws IOException {
    MediaEncoder encoder;
    {
      MediaEncoder myEncoder = MediaEncoder.getInstance(encodingContext, contentType, MediaType.XHTML);
      if (myEncoder == null) {
        myEncoder = new ValidateOnlyEncoder(xhtmlValidator);
      }
      encoder = myEncoder;
    }
    Writer encoderOptimized = Coercion.optimize(getRawUnsafe(null), encoder);
    encoder.writePrefixTo(encoderOptimized);
    return contentType.newMediaWriter(
        encodingContext,
        encoder,
        encoderOptimized,
        true,
        this,
        mediaWriter -> false, // !isNoClose
        closing -> encoder.writeSuffixTo(encoderOptimized, false)
    );
  }

  // </editor-fold>

  // <editor-fold desc="Text - implementation" defaultstate="collapsed">
  /**
   * {@inheritDoc}
   *
   * @return  {@code this} document
   */
  @Override
  public D nbsp() throws IOException {
    return nbsp(getRawUnsafe(null));
  }

  D nbsp(Writer unsafe) throws IOException {
    unsafe.append(NBSP);
    return clearAtnl();
  }

  /**
   * {@inheritDoc}
   *
   * @return  {@code this} document
   */
  @Override
  public D nbsp(int count) throws IOException {
    return nbsp(getRawUnsafe(null), count);
  }

  D nbsp(Writer unsafe, int count) throws IOException {
    if (count > 0) {
      WriterUtil.nbsp(unsafe, count);
      clearAtnl();
    }
    @SuppressWarnings("unchecked")
    D d = (D) this;
    return d;
  }

  /**
   * {@inheritDoc}
   *
   * @return  {@code this} document
   */
  @Override
  public D text(char ch) throws IOException {
    return text(getRawUnsafe(null), ch);
  }

  D text(Writer unsafe, char ch) throws IOException {
    if (ch == NL) {
      unsafe.write(NL);
      return setAtnl();
    } else {
      autoIndent(unsafe);
      encodeTextInXhtml(ch, unsafe);
      return clearAtnl();
    }
  }

  /**
   * {@inheritDoc}
   *
   * @return  {@code this} document
   */
  @Override
  public D text(char[] cbuf) throws IOException {
    return text(getRawUnsafe(null), cbuf);
  }

  D text(Writer unsafe, char[] cbuf) throws IOException {
    if (cbuf != null) {
      int len = cbuf.length;
      if (len > 0) {
        if (cbuf[len - 1] == NL) {
          if (len == 1) {
            unsafe.write(NL);
          } else {
            autoIndent(unsafe);
            encodeTextInXhtml(cbuf, unsafe);
          }
          setAtnl();
        } else {
          autoIndent(unsafe);
          encodeTextInXhtml(cbuf, unsafe);
          clearAtnl();
        }
      }
    }
    @SuppressWarnings("unchecked")
    D d = (D) this;
    return d;
  }

  /**
   * {@inheritDoc}
   *
   * @return  {@code this} document
   */
  @Override
  public D text(char[] cbuf, int offset, int len) throws IOException {
    return text(getRawUnsafe(null), cbuf, offset, len);
  }

  D text(Writer unsafe, char[] cbuf, int offset, int len) throws IOException {
    if (cbuf != null && len > 0) {
      if (cbuf[offset + len - 1] == NL) {
        if (len == 1) {
          unsafe.write(NL);
        } else {
          autoIndent(unsafe);
          encodeTextInXhtml(cbuf, offset, len, unsafe);
        }
        setAtnl();
      } else {
        autoIndent(unsafe);
        encodeTextInXhtml(cbuf, offset, len, unsafe);
        clearAtnl();
      }
    }
    @SuppressWarnings("unchecked")
    D d = (D) this;
    return d;
  }

  /**
   * {@inheritDoc}
   *
   * @return  {@code this} document
   */
  @Override
  public D text(CharSequence csq) throws IOException {
    return text(getRawUnsafe(null), csq);
  }

  /**
   * Encodes a character sequence while doing auto-indent and tracking end-of-line.
   */
  private void encodeCharSequence(Writer unsafe, CharSequence csq) throws IOException {
    int len = csq.length();
    if (len > 0) {
      if (csq.charAt(len - 1) == NL) {
        if (len == 1) {
          unsafe.write(NL);
        } else {
          autoIndent(unsafe);
          encodeTextInXhtml(csq, unsafe);
        }
        setAtnl();
      } else {
        autoIndent(unsafe);
        encodeTextInXhtml(csq, unsafe);
        clearAtnl();
      }
    }
  }

  D text(Writer unsafe, CharSequence csq) throws IOException {
    // Allow text markup from translations
    if (csq != null) {
      // Bypass encoder for markup
      BundleLookupThreadContext threadContext;
      if (
          (threadContext = BundleLookupThreadContext.getThreadContext()) == null
              // Other types that will not be converted to String for bundle lookups
              || !(csq instanceof String)
      ) {
        encodeCharSequence(unsafe, csq);
      } else {
        BundleLookupMarkup lookupMarkup = threadContext.getLookupMarkup((String) csq);
        if (lookupMarkup != null) {
          autoIndent(unsafe);
          lookupMarkup.appendPrefixTo(MarkupType.XHTML, unsafe);
        }
        encodeCharSequence(unsafe, csq);
        if (lookupMarkup != null) {
          lookupMarkup.appendSuffixTo(MarkupType.XHTML, unsafe);
          clearAtnl(); // Unknown, safe to assume not at newline
        }
      }
    }
    @SuppressWarnings("unchecked")
    D d = (D) this;
    return d;
  }

  /**
   * {@inheritDoc}
   *
   * @return  {@code this} document
   */
  @Override
  public D text(CharSequence csq, int start, int end) throws IOException {
    return text(getRawUnsafe(null), csq, start, end);
  }

  /**
   * Encodes a character sequence while doing auto-indent and tracking end-of-line.
   */
  private void encodeCharSequence(Writer unsafe, CharSequence csq, int start, int end) throws IOException {
    if (end > start) {
      int last = end - 1;
      if (csq.charAt(last) == NL) {
        if (start == last) {
          unsafe.write(NL);
        } else {
          autoIndent(unsafe);
          encodeTextInXhtml(csq, start, end, unsafe);
        }
        setAtnl();
      } else {
        autoIndent(unsafe);
        encodeTextInXhtml(csq, start, end, unsafe);
        clearAtnl();
      }
    }
  }

  D text(Writer unsafe, CharSequence csq, int start, int end) throws IOException {
    // Allow text markup from translations
    if (csq != null) {
      // Bypass encoder for markup
      BundleLookupThreadContext threadContext;
      if (
          (threadContext = BundleLookupThreadContext.getThreadContext()) == null
              // Other types that will not be converted to String for bundle lookups
              || !(csq instanceof String)
      ) {
        encodeCharSequence(unsafe, csq, start, end);
      } else {
        BundleLookupMarkup lookupMarkup = threadContext.getLookupMarkup((String) csq);
        if (lookupMarkup != null) {
          autoIndent(unsafe);
          lookupMarkup.appendPrefixTo(MarkupType.XHTML, unsafe);
        }
        encodeCharSequence(unsafe, csq, start, end);
        if (lookupMarkup != null) {
          lookupMarkup.appendSuffixTo(MarkupType.XHTML, unsafe);
          clearAtnl(); // Unknown, safe to assume not at newline
        }
      }
    }
    @SuppressWarnings("unchecked")
    D d = (D) this;
    return d;
  }

  /**
   * {@inheritDoc}
   *
   * @return  {@code this} document
   */
  @Override
  public D text(Object text) throws IOException {
    return text(getRawUnsafe(null), text);
  }

  // TODO: Compare to text() implemented by AnyTextContent, to see how it handles markuptype=text within TextContent, and how to have <option> only do markup when value attribute is set.
  @SuppressWarnings("UseSpecificCatch")
  D text(Writer unsafe, Object text) throws IOException {
    // Support Optional
    while (text instanceof Optional) {
      text = ((Optional<?>) text).orElse(null);
    }
    while (text instanceof IOSupplierE<?, ?>) {
      try {
        text = ((IOSupplierE<?, ?>) text).get();
      } catch (Throwable t) {
        throw Throwables.wrap(t, IOException.class, IOException::new);
      }
    }
    if (text != null) {
      if (text instanceof char[]) {
        return text(unsafe, (char[]) text);
      }
      if (text instanceof CharSequence) {
        return text(unsafe, (CharSequence) text);
      }
      if (text instanceof Writable) {
        Writable writable = (Writable) text;
        if (writable.isFastToString()) {
          return text(unsafe, writable.toString());
        }
      }
      if (text instanceof TextWritable) {
        try {
          return text(unsafe, (TextWritable<?>) text);
        } catch (Throwable t) {
          throw Throwables.wrap(t, IOException.class, IOException::new);
        }
      }
      // Allow text markup from translations
      autoIndent(unsafe);
      // TODO: Way to temp-disable markups from within OPTION (without value set) and TEXTAREA, or to make HTML comment mark-up only.  All places from AnyTextContent
      MediaEncoder encoder = textInXhtmlEncoder;
      assert !encoder.isBuffered() : "Is OK to bypass encoder for markup";
      MarkupCoercion.write(
          text,
          MarkupType.XHTML,
          false,
          encoder,
          true,
          unsafe
      );
      clearAtnl(); // Unknown, safe to assume not at newline
    }
    @SuppressWarnings("unchecked")
    D d = (D) this;
    return d;
  }

  /**
   * {@inheritDoc}
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @return  {@code this} document
   */
  @Override
  public <Ex extends Throwable> D text(IOSupplierE<?, Ex> text) throws IOException, Ex {
    return text(getRawUnsafe(null), text);
  }

  <Ex extends Throwable> D text(Writer unsafe, IOSupplierE<?, Ex> text) throws IOException, Ex {
    return text(unsafe, (text == null) ? null : text.get());
  }

  /**
   * {@inheritDoc}
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @return  {@code this} document
   */
  @Override
  public <Ex extends Throwable> D text(TextWritable<Ex> text) throws IOException, Ex {
    return text(getRawUnsafe(null), text);
  }

  <Ex extends Throwable> D text(Writer unsafe, TextWritable<Ex> text) throws IOException, Ex {
    if (text != null) {
      try (TextWriter _out = text(unsafe)) {
        text.writeTo(_out);
      }
    }
    @SuppressWarnings("unchecked")
    D d = (D) this;
    return d;
  }

  @Override
  public TextWriter text() throws IOException {
    return text(getRawUnsafe(null));
  }

  TextWriter text(Writer unsafe) throws IOException {
    autoIndent(unsafe);
    clearAtnl(); // Unknown, safe to assume not at newline
    @SuppressWarnings("unchecked")
    D d = (D) this;
    return new TextWriter(
        d.encodingContext,
        textInXhtmlEncoder,
        unsafe,
        false,
        d,
        mediaWriter -> true, // isNoClose
        null // Ignore close
    );
  }

  // </editor-fold>

  // TODO: comments

  /**
   * Writes the XML declaration, if needed, using the character encoding of the encoding context.
   *
   * @see  AnyDocument#encodingContext
   * @see  EncodingContext#getCharacterEncoding()
   * @see  Doctype#xmlDeclaration(com.aoapps.encoding.Serialization, java.nio.charset.Charset, java.lang.Appendable)
   */
  public D xmlDeclaration() throws IOException {
    Charset documentEncoding = encodingContext.getCharacterEncoding();
    if (encodingContext.getDoctype().xmlDeclaration(encodingContext.getSerialization(), documentEncoding, getRawUnsafe(null))) {
      setAtnl();
    }
    @SuppressWarnings("unchecked")
    D d = (D) this;
    return d;
  }

  /**
   * @see Doctype#doctype(com.aoapps.encoding.Serialization, java.lang.Appendable)
   */
  public D doctype() throws IOException {
    if (encodingContext.getDoctype().doctype(encodingContext.getSerialization(), getRawUnsafe(null))) {
      setAtnl();
    }
    @SuppressWarnings("unchecked")
    D d = (D) this;
    return d;
  }
}
