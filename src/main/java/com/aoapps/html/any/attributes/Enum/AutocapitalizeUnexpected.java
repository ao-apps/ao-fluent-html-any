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

package com.aoapps.html.any.attributes.Enum;

import com.aoapps.hodgepodge.i18n.MarkupType;
import com.aoapps.html.any.AnyBUTTON;
import com.aoapps.html.any.AnyFIELDSET;
import com.aoapps.html.any.AnyINPUT;
import com.aoapps.html.any.AnyOUTPUT;
import com.aoapps.html.any.AnySELECT;
import com.aoapps.html.any.AnyTEXTAREA;
import com.aoapps.html.any.Attributes;
import com.aoapps.html.any.Element;
import com.aoapps.html.any.GlobalAttributes;
import com.aoapps.html.any.Suppliers;
import com.aoapps.lang.io.function.IOSupplierE;
import java.io.IOException;

/**
 * <ul>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/interaction.html#autocapitalization">6.8.6 Autocapitalization</a>.</li>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:attr-autocapitalize">3.2.6 Global attributes / autocapitalize</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/autocapitalize">Global attributes / autocapitalize</a>.</li>
 * </ul>
 * <p>
 * Note: Enum type cannot be parameterized because this is a {@linkplain GlobalAttributes global attribute}.
 * </p>
 *
 * @param  <E>   This element type
 *
 * @since HTML 5
 *
 * @deprecated  Although the autocapitalize attribute is global, it is only expected on
 *              {@linkplain AnyBUTTON &lt;button&gt;}, {@linkplain AnyFIELDSET &lt;fieldset&gt;}, {@linkplain AnyINPUT &lt;input&gt;},
 *              {@linkplain AnyOUTPUT &lt;output&gt;}, {@linkplain AnySELECT &lt;select&gt;}, and {@linkplain AnyTEXTAREA &lt;textarea&gt;}.
 *              <ul>
 *              <li>See <a href="https://html.spec.whatwg.org/multipage/forms.html#category-autocapitalize">Autocapitalize-inheriting elements</a>.</li>
 *              <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/autocapitalize">Global attributes / autocapitalize</a>.</li>
 *              </ul>
 *
 * @author  AO Industries, Inc.
 */
// Matches Autocapitalize
@Deprecated
public interface AutocapitalizeUnexpected<E extends Element<?, ?, E> & AutocapitalizeUnexpected<E>> {

	/**
	 * <ul>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/interaction.html#autocapitalization">6.8.6 Autocapitalization</a>.</li>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:attr-autocapitalize">3.2.6 Global attributes / autocapitalize</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/autocapitalize">Global attributes / autocapitalize</a>.</li>
	 * </ul>
	 *
	 * @since HTML 5
	 *
	 * @deprecated  Although the autocapitalize attribute is global, it is only expected on
	 *              {@linkplain AnyBUTTON &lt;button&gt;}, {@linkplain AnyFIELDSET &lt;fieldset&gt;}, {@linkplain AnyINPUT &lt;input&gt;},
	 *              {@linkplain AnyOUTPUT &lt;output&gt;}, {@linkplain AnySELECT &lt;select&gt;}, and {@linkplain AnyTEXTAREA &lt;textarea&gt;}.
	 *              <ul>
	 *              <li>See <a href="https://html.spec.whatwg.org/multipage/forms.html#category-autocapitalize">Autocapitalize-inheriting elements</a>.</li>
	 *              <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/autocapitalize">Global attributes / autocapitalize</a>.</li>
	 *              </ul>
	 */
	@Deprecated
	@Attributes.Funnel
	default E autocapitalize(String autocapitalize) throws IOException {
		@SuppressWarnings("unchecked") E element = (E)this;
		Attributes.onlySupportedInHtml5(element, "autocapitalize");
		return Attributes.String.attribute(element, "autocapitalize", MarkupType.NONE, autocapitalize, true, true);
	}

	/**
	 * <ul>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/interaction.html#autocapitalization">6.8.6 Autocapitalization</a>.</li>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:attr-autocapitalize">3.2.6 Global attributes / autocapitalize</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/autocapitalize">Global attributes / autocapitalize</a>.</li>
	 * </ul>
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 *
	 * @since HTML 5
	 *
	 * @see #autocapitalize(java.lang.String)
	 *
	 * @deprecated  Although the autocapitalize attribute is global, it is only expected on
	 *              {@linkplain AnyBUTTON &lt;button&gt;}, {@linkplain AnyFIELDSET &lt;fieldset&gt;}, {@linkplain AnyINPUT &lt;input&gt;},
	 *              {@linkplain AnyOUTPUT &lt;output&gt;}, {@linkplain AnySELECT &lt;select&gt;}, and {@linkplain AnyTEXTAREA &lt;textarea&gt;}.
	 *              <ul>
	 *              <li>See <a href="https://html.spec.whatwg.org/multipage/forms.html#category-autocapitalize">Autocapitalize-inheriting elements</a>.</li>
	 *              <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/autocapitalize">Global attributes / autocapitalize</a>.</li>
	 *              </ul>
	 */
	@Deprecated
	@SuppressWarnings("overloads")
	default <Ex extends Throwable> E autocapitalize(Suppliers.String<Ex> autocapitalize) throws IOException, Ex {
		return autocapitalize((autocapitalize == null) ? null : autocapitalize.get());
	}

	/**
	 * <ul>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/interaction.html#autocapitalization">6.8.6 Autocapitalization</a>.</li>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:attr-autocapitalize">3.2.6 Global attributes / autocapitalize</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/autocapitalize">Global attributes / autocapitalize</a>.</li>
	 * </ul>
	 *
	 * @since HTML 5
	 *
	 * @see #autocapitalize(java.lang.String)
	 *
	 * @deprecated  Although the autocapitalize attribute is global, it is only expected on
	 *              {@linkplain AnyBUTTON &lt;button&gt;}, {@linkplain AnyFIELDSET &lt;fieldset&gt;}, {@linkplain AnyINPUT &lt;input&gt;},
	 *              {@linkplain AnyOUTPUT &lt;output&gt;}, {@linkplain AnySELECT &lt;select&gt;}, and {@linkplain AnyTEXTAREA &lt;textarea&gt;}.
	 *              <ul>
	 *              <li>See <a href="https://html.spec.whatwg.org/multipage/forms.html#category-autocapitalize">Autocapitalize-inheriting elements</a>.</li>
	 *              <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/autocapitalize">Global attributes / autocapitalize</a>.</li>
	 *              </ul>
	 */
	@Deprecated
	default E autocapitalize(Autocapitalize.Value autocapitalize) throws IOException {
		@SuppressWarnings("unchecked") E element = (E)this;
		return autocapitalize((autocapitalize == null) ? null : autocapitalize.apply(element.getDocument()));
	}

	/**
	 * <ul>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/interaction.html#autocapitalization">6.8.6 Autocapitalization</a>.</li>
	 * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes:attr-autocapitalize">3.2.6 Global attributes / autocapitalize</a>.</li>
	 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/autocapitalize">Global attributes / autocapitalize</a>.</li>
	 * </ul>
	 *
	 * @param  <Ex>  An arbitrary exception type that may be thrown
	 *
	 * @since HTML 5
	 *
	 * @see #autocapitalize(com.aoapps.html.any.attributes.Enum.Autocapitalize.Value)
	 *
	 * @deprecated  Although the autocapitalize attribute is global, it is only expected on
	 *              {@linkplain AnyBUTTON &lt;button&gt;}, {@linkplain AnyFIELDSET &lt;fieldset&gt;}, {@linkplain AnyINPUT &lt;input&gt;},
	 *              {@linkplain AnyOUTPUT &lt;output&gt;}, {@linkplain AnySELECT &lt;select&gt;}, and {@linkplain AnyTEXTAREA &lt;textarea&gt;}.
	 *              <ul>
	 *              <li>See <a href="https://html.spec.whatwg.org/multipage/forms.html#category-autocapitalize">Autocapitalize-inheriting elements</a>.</li>
	 *              <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/autocapitalize">Global attributes / autocapitalize</a>.</li>
	 *              </ul>
	 */
	@Deprecated
	@SuppressWarnings("overloads")
	default <Ex extends Throwable> E autocapitalize(IOSupplierE<? extends Autocapitalize.Value, Ex> autocapitalize) throws IOException, Ex {
		return autocapitalize((autocapitalize == null) ? null : autocapitalize.get());
	}
}
