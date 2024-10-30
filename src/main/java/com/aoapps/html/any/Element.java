/*
 * ao-fluent-html-any - Base abstract classes and interfaces for Fluent Java DSL for high-performance HTML generation.
 * Copyright (C) 2019, 2021, 2022, 2024  AO Industries, Inc.
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

import com.aoapps.lang.io.NoClose;
import com.aoapps.lang.io.Writable;
import com.aoapps.lang.io.function.IOSupplierE;
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
    >
    implements
    DocumentWriter,
    // Allow any arbitrary attributes
    com.aoapps.html.any.attributes.text.Attribute<E>,
    // Global Attributes
    GlobalAttributes<E> {

  protected final D document;
  protected final PC pc;

  protected Element(D document, PC pc) {
    this.document = document;
    this.pc = pc;
  }

  public D getDocument() {
    return document;
  }

  // <editor-fold desc="Whitespace - delegate to Document" defaultstate="collapsed">
  /**
   * {@inheritDoc}
   *
   * <p>Delegates to {@link AnyDocument#nl()}.</p>
   *
   * @deprecated  Deprecated to keep out of the way in code assist, since this not expected to be used normally.
   */
  @Deprecated
  @Override
  public E nl() throws IOException {
    document.nl();
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return element;
  }

  /**
   * {@inheritDoc}
   *
   * <p>Delegates to {@link AnyDocument#nli()}.</p>
   */
  @Override
  public E nli() throws IOException {
    document.nli();
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return element;
  }

  /**
   * {@inheritDoc}
   *
   * <p>Delegates to {@link AnyDocument#nli(int)}.</p>
   *
   * @deprecated  Deprecated to keep out of the way in code assist, since this not expected to be used normally.
   */
  @Deprecated
  @Override
  public E nli(int depthOffset) throws IOException {
    document.nli(depthOffset);
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return element;
  }

  /**
   * {@inheritDoc}
   *
   * <p>Delegates to {@link AnyDocument#indent()}.</p>
   *
   * @deprecated  Deprecated to keep out of the way in code assist, since this not expected to be used normally.
   */
  @Deprecated
  @Override
  public E indent() throws IOException {
    document.indent();
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return element;
  }

  /**
   * {@inheritDoc}
   *
   * <p>Delegates to {@link AnyDocument#indent(int)}.</p>
   *
   * @deprecated  Deprecated to keep out of the way in code assist, since this not expected to be used normally.
   */
  @Deprecated
  @Override
  public E indent(int depthOffset) throws IOException {
    document.indent(depthOffset);
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return element;
  }

  /**
   * {@inheritDoc}
   *
   * <p>Delegates to {@link AnyDocument#getIndent()}.</p>
   *
   * @deprecated  Deprecated to keep out of the way in code assist, since this not expected to be used normally.
   */
  @Deprecated
  @Override
  public boolean getIndent() {
    return document.getIndent();
  }

  /**
   * {@inheritDoc}
   *
   * <p>Delegates to {@link AnyDocument#setIndent(boolean)}.</p>
   *
   * @deprecated  Deprecated to keep out of the way in code assist, since this not expected to be used normally.
   */
  @Deprecated
  @Override
  public E setIndent(boolean indent) {
    document.setIndent(indent);
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return element;
  }

  /**
   * {@inheritDoc}
   *
   * <p>Delegates to {@link AnyDocument#getDepth()}.</p>
   *
   * @deprecated  Deprecated to keep out of the way in code assist, since this not expected to be used normally.
   */
  @Deprecated
  @Override
  public int getDepth() {
    return document.getDepth();
  }

  /**
   * {@inheritDoc}
   *
   * <p>Delegates to {@link AnyDocument#setDepth(int)}.</p>
   *
   * @deprecated  Deprecated to keep out of the way in code assist, since this not expected to be used normally.
   */
  @Deprecated
  @Override
  public E setDepth(int depth) {
    document.setDepth(depth);
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return element;
  }

  /**
   * {@inheritDoc}
   *
   * <p>Delegates to {@link AnyDocument#incDepth()}.</p>
   *
   * @deprecated  Deprecated to keep out of the way in code assist, since this not expected to be used normally.
   */
  @Deprecated
  @Override
  public E incDepth() {
    document.incDepth();
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return element;
  }

  /**
   * {@inheritDoc}
   *
   * <p>Delegates to {@link AnyDocument#decDepth()}.</p>
   *
   * @deprecated  Deprecated to keep out of the way in code assist, since this not expected to be used normally.
   */
  @Deprecated
  @Override
  public E decDepth() {
    document.decDepth();
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return element;
  }

  /**
   * {@inheritDoc}
   *
   * <p>Delegates to {@link AnyDocument#sp()}.</p>
   *
   * @deprecated  Deprecated to keep out of the way in code assist, since this not expected to be used normally.
   */
  @Deprecated
  @Override
  public E sp() throws IOException {
    document.sp();
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return element;
  }

  /**
   * {@inheritDoc}
   *
   * <p>Delegates to {@link AnyDocument#sp(int)}.</p>
   *
   * @deprecated  Deprecated to keep out of the way in code assist, since this not expected to be used normally.
   */
  @Deprecated
  @Override
  public E sp(int count) throws IOException {
    this.document.sp(count);
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return element;
  }

  // </editor-fold>

  // <editor-fold desc="DocumentWriter / Unsafe - delegate to Document" defaultstate="collapsed">
  /**
   * {@inheritDoc}
   *
   * <p>Delegates to {@link AnyDocument#getRawUnsafe(java.lang.Boolean)}.</p>
   *
   * @deprecated  This method will remain, but its use is discouraged as it can be dangerous
   */
  @Deprecated
  @Override
  public Writer getRawUnsafe(Boolean endsNewline) throws IllegalStateException {
    return document.getRawUnsafe(endsNewline);
  }

  /**
   * {@inheritDoc}
   *
   * <p>Delegates to {@link AnyDocument#getRawUnsafe()}.</p>
   *
   * @deprecated  This method will remain, but its use is discouraged as it can be dangerous
   */
  @Deprecated
  @Override
  public Writer getRawUnsafe() throws IllegalStateException {
    return document.getRawUnsafe();
  }

  /**
   * {@inheritDoc}
   *
   * <p>Delegates to {@link AnyDocument#unsafe(char)}.</p>
   *
   * @deprecated  This method will remain, but its use is discouraged as it can be dangerous
   */
  @Deprecated
  @Override
  public E unsafe(char ch) throws IOException {
    document.unsafe(ch);
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return element;
  }

  /**
   * {@inheritDoc}
   *
   * <p>Delegates to {@link AnyDocument#unsafe(char[])}.</p>
   *
   * @deprecated  This method will remain, but its use is discouraged as it can be dangerous
   */
  @Deprecated
  @Override
  public E unsafe(char[] cbuf) throws IOException {
    document.unsafe(cbuf);
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return element;
  }

  /**
   * {@inheritDoc}
   *
   * <p>Delegates to {@link AnyDocument#unsafe(char[], int, int)}.</p>
   *
   * @deprecated  This method will remain, but its use is discouraged as it can be dangerous
   */
  @Deprecated
  @Override
  public E unsafe(char[] cbuf, int offset, int len) throws IOException {
    document.unsafe(cbuf, offset, len);
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return element;
  }

  /**
   * {@inheritDoc}
   *
   * <p>Delegates to {@link AnyDocument#unsafe(java.lang.CharSequence)}.</p>
   *
   * @deprecated  This method will remain, but its use is discouraged as it can be dangerous
   */
  @Deprecated
  @Override
  public E unsafe(CharSequence csq) throws IOException {
    document.unsafe(csq);
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return element;
  }

  /**
   * {@inheritDoc}
   *
   * <p>Delegates to {@link AnyDocument#unsafe(java.lang.CharSequence, int, int)}.</p>
   *
   * @deprecated  This method will remain, but its use is discouraged as it can be dangerous
   */
  @Deprecated
  @Override
  public E unsafe(CharSequence csq, int start, int end) throws IOException {
    document.unsafe(csq, start, end);
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return element;
  }

  /**
   * {@inheritDoc}
   *
   * <p>Delegates to {@link AnyDocument#unsafe(java.lang.Object)}.</p>
   *
   * @deprecated  This method will remain, but its use is discouraged as it can be dangerous
   */
  @Deprecated
  @Override
  public E unsafe(Object unsafe) throws IOException {
    document.unsafe(unsafe);
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return element;
  }

  /**
   * {@inheritDoc}
   *
   * <p>Delegates to {@link AnyDocument#unsafe(com.aoapps.lang.io.function.IOSupplierE)}.</p>
   *
   * @deprecated  This method will remain, but its use is discouraged as it can be dangerous
   */
  @Deprecated
  @Override
  public <Ex extends Throwable> E unsafe(IOSupplierE<?, Ex> unsafe) throws IOException, Ex {
    document.unsafe(unsafe);
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return element;
  }

  /**
   * {@inheritDoc}
   *
   * <p>Delegates to {@link AnyDocument#unsafe(com.aoapps.lang.io.Writable)}.</p>
   *
   * @deprecated  This method will remain, but its use is discouraged as it can be dangerous
   */
  @Deprecated
  @Override
  public E unsafe(Writable unsafe) throws IOException {
    document.unsafe(unsafe);
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return element;
  }

  /**
   * {@inheritDoc}
   *
   * <p>Delegates to {@link AnyDocument#unsafe()}.</p>
   *
   * @deprecated  This method will remain, but its use is discouraged as it can be dangerous
   */
  @Deprecated
  @Override
  public <W extends Writer & NoClose> W unsafe() throws IOException {
    return document.unsafe();
  }

  // </editor-fold>

  // <editor-fold desc="DocumentWriter / Automatic Newline and Indentation - delegate to Document" defaultstate="collapsed">
  /**
   * {@inheritDoc}
   *
   * <p>Delegates to {@link AnyDocument#getAutonli()}.</p>
   *
   * @deprecated  Deprecated to keep out of the way in code assist, since this not expected to be used normally.
   */
  @Deprecated
  @Override
  public boolean getAutonli() {
    return document.getAutonli();
  }

  /**
   * {@inheritDoc}
   *
   * <p>Delegates to {@link AnyDocument#setAutonli(boolean)}.</p>
   *
   * @deprecated  Deprecated to keep out of the way in code assist, since this not expected to be used normally.
   */
  @Deprecated
  @Override
  public E setAutonli(boolean autonli) {
    document.setAutonli(autonli);
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return element;
  }

  /**
   * {@inheritDoc}
   *
   * <p>Delegates to {@link AnyDocument#getAtnl()}.</p>
   *
   * @deprecated  Deprecated to keep out of the way in code assist, since this not expected to be used normally.
   */
  @Deprecated
  @Override
  public boolean getAtnl() {
    return document.getAtnl();
  }

  /**
   * {@inheritDoc}
   *
   * <p>Delegates to {@link AnyDocument#setAtnl()}.</p>
   *
   * @deprecated  Deprecated to keep out of the way in code assist, since this not expected to be used normally.
   */
  @Deprecated
  @Override
  public E setAtnl() {
    document.setAtnl();
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return element;
  }

  /**
   * {@inheritDoc}
   *
   * <p>Delegates to {@link AnyDocument#setAtnl(boolean)}.</p>
   *
   * @deprecated  Deprecated to keep out of the way in code assist, since this not expected to be used normally.
   */
  @Deprecated
  @Override
  public E setAtnl(boolean atnl) {
    document.setAtnl(atnl);
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return element;
  }

  /**
   * {@inheritDoc}
   *
   * <p>Delegates to {@link AnyDocument#clearAtnl()}.</p>
   *
   * @deprecated  Deprecated to keep out of the way in code assist, since this not expected to be used normally.
   */
  @Deprecated
  @Override
  public E clearAtnl() {
    document.clearAtnl();
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return element;
  }

  /**
   * {@inheritDoc}
   *
   * <p>Delegates to {@link AnyDocument#autoNl()}.</p>
   *
   * @deprecated  Deprecated to keep out of the way in code assist, since this not expected to be used normally.
   */
  @Deprecated
  @Override
  public E autoNl() throws IOException {
    document.autoNl();
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return element;
  }

  /**
   * {@inheritDoc}
   *
   * <p>Delegates to {@link AnyDocument#autoNli()}.</p>
   */
  @Override
  public E autoNli() throws IOException {
    document.autoNli();
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return element;
  }

  /**
   * {@inheritDoc}
   *
   * <p>Delegates to {@link AnyDocument#autoNli(int)}.</p>
   *
   * @deprecated  Deprecated to keep out of the way in code assist, since this not expected to be used normally.
   */
  @Deprecated
  @Override
  public E autoNli(int depthOffset) throws IOException {
    document.autoNli(depthOffset);
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return element;
  }

  /**
   * {@inheritDoc}
   *
   * <p>Delegates to {@link AnyDocument#autoIndent()}.</p>
   *
   * @deprecated  Deprecated to keep out of the way in code assist, since this not expected to be used normally.
   */
  @Deprecated
  @Override
  public E autoIndent() throws IOException {
    document.autoIndent();
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return element;
  }

  /**
   * {@inheritDoc}
   *
   * <p>Delegates to {@link AnyDocument#autoIndent(int)}.</p>
   *
   * @deprecated  Deprecated to keep out of the way in code assist, since this not expected to be used normally.
   */
  @Deprecated
  @Override
  public E autoIndent(int depthOffset) throws IOException {
    document.autoIndent(depthOffset);
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return element;
  }

  // </editor-fold>

  /**
   * Writes the beginning of the opening tag.
   *
   * @return  The element instance to use.
   *          This may substitute the element with a different instance, when appropriate.
   */
  protected abstract E writeOpen(Writer unsafe) throws IOException;
}
