/*
 * ao-fluent-html-any - Base abstract classes and interfaces for Fluent Java DSL for high-performance HTML generation.
 * Copyright (C) 2021, 2022, 2023  AO Industries, Inc.
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

package com.aoapps.html.any.attributes.url;

import com.aoapps.html.any.Attributes;
import com.aoapps.html.any.Element;
import com.aoapps.lang.Strings;
import com.aoapps.lang.io.function.IOSupplierE;
import java.io.IOException;

/**
 * See <a href="https://www.w3schools.com/tags/att_action.asp">HTML action Attribute</a>.
 *
 * @param  <E>   This element type
 *
 * @author  AO Industries, Inc.
 */
public interface Action<E extends Element<?, ?, E> & Action<E>> {

  /**
   * <p>
   * Utility class for working with {@link Action}.
   * </p>
   * <p>
   * See <a href="https://www.w3schools.com/tags/att_action.asp">HTML action Attribute</a>.
   * </p>
   */
  public static final class action {
    /** Make no instances. */
    private action() {
      throw new AssertionError();
    }

    /**
     * Normalizes an action attribute.
     *
     * @see  Strings#trimNullIfEmpty(java.lang.String)
     */
    public static String normalize(String action) {
      return Strings.trimNullIfEmpty(action);
    }
  }

  /**
   * See <a href="https://www.w3schools.com/tags/att_action.asp">HTML action Attribute</a>.
   */
  @Attributes.Funnel
  default E action(String action) throws IOException {
    @SuppressWarnings("unchecked")
    E element = (E) this;
    return Attributes.Url.attribute(element, "action", action, Action.action::normalize);
  }

  /**
   * See <a href="https://www.w3schools.com/tags/att_action.asp">HTML action Attribute</a>.
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @see #action(java.lang.String)
   */
  default <Ex extends Throwable> E action(IOSupplierE<? extends String, Ex> action) throws IOException, Ex {
    return action((action == null) ? null : action.get());
  }
}
