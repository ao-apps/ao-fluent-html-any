/*
 * ao-fluent-html-any - Base abstract classes and interfaces for Fluent Java DSL for high-performance HTML generation.
 * Copyright (C) 2022, 2024, 2025  AO Industries, Inc.
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

package com.aoapps.html.any.attributes.text;

import com.aoapps.encoding.TextWritable;
import com.aoapps.html.any.AnyBASE;
import com.aoapps.html.any.AnyBDO;
import com.aoapps.html.any.AnyBR;
import com.aoapps.html.any.AnyHEAD;
import com.aoapps.html.any.AnyHTML;
import com.aoapps.html.any.AnyIFRAME;
import com.aoapps.html.any.AnyINPUT;
import com.aoapps.html.any.AnyMETA;
import com.aoapps.html.any.AnyPARAM;
import com.aoapps.html.any.AnySCRIPT;
import com.aoapps.html.any.AnySTYLE;
import com.aoapps.html.any.AnyTITLE;
import com.aoapps.html.any.AnyWBR;
import com.aoapps.html.any.Attributes;
import com.aoapps.html.any.Element;
import com.aoapps.lang.io.function.IOSupplierE;
import java.io.IOException;

/**
 * <ul>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/interaction.html#the-accesskey-attribute">6.7.2 The accesskey attribute</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/accesskey">Global attributes / accesskey</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/accessKey">HTMLElement.accessKey</a>.</li>
 * <li>See <a href="https://www.w3schools.com/tags/att_global_accesskey.asp">HTML accesskey Attributes</a>.</li>
 * </ul>
 *
 * @param  <E>   This element type
 *
 * @since HTML 5
 *
 * @deprecated  Although the accesskey attribute is global, it is not expected on
 *              {@linkplain AnyBASE &lt;base&gt;}, {@linkplain AnyBDO &lt;bdo&gt;}, {@linkplain AnyBR &lt;br&gt;},
 *              {@linkplain AnyHEAD &lt;head&gt;}, {@linkplain AnyHTML &lt;html&gt;}, {@linkplain AnyIFRAME &lt;iframe&gt;},
 *              {@linkplain AnyINPUT.Hidden &lt;input type="hidden"&gt;}, {@linkplain AnyMETA &lt;meta&gt;}, {@linkplain AnyPARAM &lt;param&gt;},
 *              {@linkplain AnySCRIPT &lt;script&gt;}, {@linkplain AnySTYLE &lt;style&gt;}, {@linkplain AnyTITLE &lt;title&gt;},
 *              or {@linkplain AnyWBR &lt;wbr&gt;}.
 *
 *              <p>See <a href="https://www.w3schools.com/tags/ref_eventattributes.asp">HTML Event Attributes</a>.</p>
 *
 * @author  AO Industries, Inc.
 */
// Matches Accesskey
@Deprecated(forRemoval = false)
public interface AccesskeyUnexpected<E extends Element<?, ?, E> & AccesskeyUnexpected<E>> extends Accesskey<E> {

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/interaction.html#the-accesskey-attribute">6.7.2 The accesskey attribute</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/accesskey">Global attributes / accesskey</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/accessKey">HTMLElement.accessKey</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/att_global_accesskey.asp">HTML accesskey Attributes</a>.</li>
   * </ul>
   *
   * @since HTML 5
   *
   * @deprecated  Although the accesskey attribute is global, it is not expected on
   *              {@linkplain AnyBASE &lt;base&gt;}, {@linkplain AnyBDO &lt;bdo&gt;}, {@linkplain AnyBR &lt;br&gt;},
   *              {@linkplain AnyHEAD &lt;head&gt;}, {@linkplain AnyHTML &lt;html&gt;}, {@linkplain AnyIFRAME &lt;iframe&gt;},
   *              {@linkplain AnyINPUT.Hidden &lt;input type="hidden"&gt;}, {@linkplain AnyMETA &lt;meta&gt;}, {@linkplain AnyPARAM &lt;param&gt;},
   *              {@linkplain AnySCRIPT &lt;script&gt;}, {@linkplain AnySTYLE &lt;style&gt;}, {@linkplain AnyTITLE &lt;title&gt;},
   *              or {@linkplain AnyWBR &lt;wbr&gt;}.
   *
   *              <p>See <a href="https://www.w3schools.com/tags/ref_eventattributes.asp">HTML Event Attributes</a>.</p>
   */
  @Deprecated(forRemoval = false)
  @Override
  @Attributes.Funnel
  default E accesskey(Object accesskey) throws IOException {
    return Accesskey.super.accesskey(accesskey);
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/interaction.html#the-accesskey-attribute">6.7.2 The accesskey attribute</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/accesskey">Global attributes / accesskey</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/accessKey">HTMLElement.accessKey</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/att_global_accesskey.asp">HTML accesskey Attributes</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @since HTML 5
   *
   * @see #accesskey(java.lang.Object)
   *
   * @deprecated  Although the accesskey attribute is global, it is not expected on
   *              {@linkplain AnyBASE &lt;base&gt;}, {@linkplain AnyBDO &lt;bdo&gt;}, {@linkplain AnyBR &lt;br&gt;},
   *              {@linkplain AnyHEAD &lt;head&gt;}, {@linkplain AnyHTML &lt;html&gt;}, {@linkplain AnyIFRAME &lt;iframe&gt;},
   *              {@linkplain AnyINPUT.Hidden &lt;input type="hidden"&gt;}, {@linkplain AnyMETA &lt;meta&gt;}, {@linkplain AnyPARAM &lt;param&gt;},
   *              {@linkplain AnySCRIPT &lt;script&gt;}, {@linkplain AnySTYLE &lt;style&gt;}, {@linkplain AnyTITLE &lt;title&gt;},
   *              or {@linkplain AnyWBR &lt;wbr&gt;}.
   *
   *              <p>See <a href="https://www.w3schools.com/tags/ref_eventattributes.asp">HTML Event Attributes</a>.</p>
   */
  @Deprecated(forRemoval = false)
  @Override
  default <Ex extends Throwable> E accesskey(IOSupplierE<?, Ex> accesskey) throws IOException, Ex {
    return Accesskey.super.accesskey(accesskey);
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/interaction.html#the-accesskey-attribute">6.7.2 The accesskey attribute</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/accesskey">Global attributes / accesskey</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/accessKey">HTMLElement.accessKey</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/att_global_accesskey.asp">HTML accesskey Attributes</a>.</li>
   * </ul>
   *
   * @since HTML 5
   *
   * @deprecated  Although the accesskey attribute is global, it is not expected on
   *              {@linkplain AnyBASE &lt;base&gt;}, {@linkplain AnyBDO &lt;bdo&gt;}, {@linkplain AnyBR &lt;br&gt;},
   *              {@linkplain AnyHEAD &lt;head&gt;}, {@linkplain AnyHTML &lt;html&gt;}, {@linkplain AnyIFRAME &lt;iframe&gt;},
   *              {@linkplain AnyINPUT.Hidden &lt;input type="hidden"&gt;}, {@linkplain AnyMETA &lt;meta&gt;}, {@linkplain AnyPARAM &lt;param&gt;},
   *              {@linkplain AnySCRIPT &lt;script&gt;}, {@linkplain AnySTYLE &lt;style&gt;}, {@linkplain AnyTITLE &lt;title&gt;},
   *              or {@linkplain AnyWBR &lt;wbr&gt;}.
   *
   *              <p>See <a href="https://www.w3schools.com/tags/ref_eventattributes.asp">HTML Event Attributes</a>.</p>
   */
  @Deprecated(forRemoval = false)
  @Override
  default E accesskey(int ... codePoints) throws IOException {
    return Accesskey.super.accesskey(codePoints);
  }

  /**
   * <ul>
   * <li>See <a href="https://html.spec.whatwg.org/multipage/interaction.html#the-accesskey-attribute">6.7.2 The accesskey attribute</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/accesskey">Global attributes / accesskey</a>.</li>
   * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/accessKey">HTMLElement.accessKey</a>.</li>
   * <li>See <a href="https://www.w3schools.com/tags/att_global_accesskey.asp">HTML accesskey Attributes</a>.</li>
   * </ul>
   *
   * @param  <Ex>  An arbitrary exception type that may be thrown
   *
   * @since HTML 5
   *
   * @see #accesskey(java.lang.Object)
   *
   * @deprecated  Although the accesskey attribute is global, it is not expected on
   *              {@linkplain AnyBASE &lt;base&gt;}, {@linkplain AnyBDO &lt;bdo&gt;}, {@linkplain AnyBR &lt;br&gt;},
   *              {@linkplain AnyHEAD &lt;head&gt;}, {@linkplain AnyHTML &lt;html&gt;}, {@linkplain AnyIFRAME &lt;iframe&gt;},
   *              {@linkplain AnyINPUT.Hidden &lt;input type="hidden"&gt;}, {@linkplain AnyMETA &lt;meta&gt;}, {@linkplain AnyPARAM &lt;param&gt;},
   *              {@linkplain AnySCRIPT &lt;script&gt;}, {@linkplain AnySTYLE &lt;style&gt;}, {@linkplain AnyTITLE &lt;title&gt;},
   *              or {@linkplain AnyWBR &lt;wbr&gt;}.
   *
   *              <p>See <a href="https://www.w3schools.com/tags/ref_eventattributes.asp">HTML Event Attributes</a>.</p>
   */
  @Deprecated(forRemoval = false)
  @Override
  default <Ex extends Throwable> E accesskey(TextWritable<Ex> accesskey) throws IOException, Ex {
    return Accesskey.super.accesskey(accesskey);
  }
}
