/*
 * ao-fluent-html-any - Base abstract classes and interfaces for Fluent Java DSL for high-performance HTML generation.
 * Copyright (C) 2019, 2020, 2021, 2022  AO Industries, Inc.
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

/**
 * <ul>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/dom.html#global-attributes">3.2.6 Global attributes</a>.</li>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#event-handlers-on-elements,-document-objects,-and-window-objects">8.1.7.2 Event handlers on elements, Document objects, and Window objects</a>.</li>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions">8.1.7.2.1 IDL definitions</a>.</li>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/media.html#mediaevents">4.8.12.16 Media elements / Events summary</a>.</li>
 * <li>See <a href="https://html.spec.whatwg.org/multipage/indices.html#events-2">Index / Events</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes">Global attributes</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers">GlobalEventHandlers</a>.</li>
 * <li>See <a href="https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement">HTMLElement</a>.</li>
 * <li>See <a href="https://www.w3schools.com/tags/ref_standardattributes.asp">HTML Global attributes</a>.</li>
 * <li>See <a href="https://www.w3schools.com/jsref/dom_obj_event.asp">HTML DOM Event Object</a>.</li>
 * </ul>
 *
 * @param  <E>   This element type
 *
 * @author  AO Industries, Inc.
 */
@SuppressWarnings("deprecation")
public interface GlobalAttributes<E extends Element<?, ?, E> & GlobalAttributes<E>> extends
    // Global Attributes
    com.aoapps.html.any.attributes.text.Accesskey<E>,
    com.aoapps.html.any.attributes.enumeration.AutocapitalizeUnexpected<E>,
    com.aoapps.html.any.attributes.bool.Autofocus<E>,
    com.aoapps.html.any.attributes.text.Class<E>,
    // TODO: contenteditable
    //       https://html.spec.whatwg.org/multipage/interaction.html#attr-contenteditable
    //       https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/contenteditable
    //       https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/contentEditable
    //       https://www.w3schools.com/tags/att_global_contenteditable.asp
    com.aoapps.html.any.attributes.text.Data<E>,
    com.aoapps.html.any.attributes.enumeration.Dir<E>,
    // TODO: draggable
    //       https://html.spec.whatwg.org/multipage/dnd.html#attr-draggable
    //       https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/draggable
    //       https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/draggable
    //       https://www.w3schools.com/tags/att_global_draggable.asp
    // TODO: enterkeyhint
    //       https://html.spec.whatwg.org/multipage/interaction.html#attr-enterkeyhint
    //       https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/enterkeyhint
    //       https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/enterKeyHint
    // TODO: exportparts (experimental)
    //       https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes#attr-exportparts
    // TODO: hidden
    //       https://html.spec.whatwg.org/multipage/interaction.html#attr-hidden
    //       https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/hidden
    //       https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/hidden
    //       https://www.w3schools.com/tags/att_global_hidden.asp
    com.aoapps.html.any.attributes.text.Id<E>,
    // TODO: inert
    //       https://html.spec.whatwg.org/multipage/interaction.html#the-inert-attribute
    //       https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/inert
    // TODO: inputmode
    //       https://html.spec.whatwg.org/multipage/interaction.html#attr-inputmode
    //       https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/inputmode
    //       https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/inputMode
    // TODO: is
    //       https://html.spec.whatwg.org/multipage/custom-elements.html#attr-is
    //       https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/is
    // TODO: itemid
    //       https://html.spec.whatwg.org/multipage/microdata.html#attr-itemid
    //       https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/itemid
    //       https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/itemId
    // TODO: itemprop
    //       https://html.spec.whatwg.org/multipage/microdata.html#names:-the-itemprop-attribute
    //       https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/itemprop
    //       https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/itemProp
    // TODO: itemref
    //       https://html.spec.whatwg.org/multipage/microdata.html#attr-itemref
    //       https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/itemref
    //       https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/itemRef
    // TODO: itemscope
    //       https://html.spec.whatwg.org/multipage/microdata.html#attr-itemscope
    //       https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/itemscope
    //       https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/itemScope
    // TODO: itemtype
    //       https://html.spec.whatwg.org/multipage/microdata.html#attr-itemtype
    //       https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/itemtype
    //       https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/itemType
    com.aoapps.html.any.attributes.text.Lang<E>,
    // TODO: nonce
    //       https://html.spec.whatwg.org/multipage/urls-and-fetching.html#attr-nonce
    //       https://fetch.spec.whatwg.org/#concept-request-nonce-metadata
    //       https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/nonce
    //       https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/nonce
    // TODO: part (experimental)
    //       https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/part
    // TODO: slot
    //       https://html.spec.whatwg.org/multipage/dom.html#attr-slot
    //       https://dom.spec.whatwg.org/#concept-slot
    //       https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/slot
    // TODO: spellcheck
    //       https://html.spec.whatwg.org/multipage/interaction.html#attr-spellcheck
    //       https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/spellcheck
    //       https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/spellcheck
    //       https://www.w3schools.com/tags/att_global_spellcheck.asp
    com.aoapps.html.any.attributes.text.Style<E>,
    com.aoapps.html.any.attributes.integer.Tabindex<E>,
    com.aoapps.html.any.attributes.text.Title<E>,
    // TODO: translate
    //       https://html.spec.whatwg.org/multipage/dom.html#the-translate-attribute
    //       https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes#attr-translate
    //       https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/translate
    //       https://www.w3schools.com/tags/att_global_translate.asp
    // Global Event Attributes
    com.aoapps.html.any.attributes.event.OnabortUnexpected<E>,
    // TODO: onanimationcancel (deprecated poor browser support)
    //       https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/onanimationcancel
    //       https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/animationcancel_event
    // TODO: onanimationend
    //       https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/onanimationend
    //       https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/animationend_event
    //       https://www.w3schools.com/jsref/event_animationend.asp
    // TODO: onanimationiteration
    //       https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/onanimationiteration
    //       https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/animationiteration_event
    //       https://www.w3schools.com/jsref/event_animationiteration.asp
    // TODO: onanimationstart
    //       https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/onanimationstart
    //       https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/animationstart_event
    //       https://www.w3schools.com/jsref/event_animationstart.asp
    // TODO: onauxclick
    //       https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-onauxclick
    //       https://html.spec.whatwg.org/multipage/webappapis.html#handler-onauxclick
    //       https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-onauxclick
    //       https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/onauxclick
    com.aoapps.html.any.attributes.event.Onblur<E>,
    // TODO: oncancel (fired on dialog only?)
    //       https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-oncancel
    //       https://html.spec.whatwg.org/multipage/webappapis.html#handler-oncancel
    //       https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-oncancel
    //       https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/oncancel
    com.aoapps.html.any.attributes.event.OncanplayUnexpected<E>,
    com.aoapps.html.any.attributes.event.OncanplaythroughUnexpected<E>,
    com.aoapps.html.any.attributes.event.OnchangeUnexpected<E>,
    com.aoapps.html.any.attributes.event.Onclick<E>,
    // TODO: onclose (fired on dialog only?)
    //       https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-onclose
    //       https://html.spec.whatwg.org/multipage/webappapis.html#handler-onclose
    //       https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-onclose
    //       https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/onclose
    // TODO: oncontextlost (fired on canvas only?)
    //       https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-oncontextlost
    //       https://html.spec.whatwg.org/multipage/webappapis.html#handler-oncontextlost
    //       https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-oncontextlost
    com.aoapps.html.any.attributes.event.Oncontextmenu<E>,
    // TODO: oncontextrestored (fired on canvas only?)
    //       https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-oncontextrestored
    //       https://html.spec.whatwg.org/multipage/webappapis.html#handler-oncontextrestored
    //       https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-oncontextrestored
    com.aoapps.html.any.attributes.event.Oncopy<E>,
    // TODO: oncuechange (fired at track only?) HTML 5 only
    //       https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-oncuechange
    //       https://html.spec.whatwg.org/multipage/webappapis.html#handler-oncuechange
    //       https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-oncuechange
    com.aoapps.html.any.attributes.event.Oncut<E>,
    com.aoapps.html.any.attributes.event.Ondblclick<E>,
    com.aoapps.html.any.attributes.event.Ondrag<E>,
    com.aoapps.html.any.attributes.event.Ondragend<E>,
    com.aoapps.html.any.attributes.event.Ondragenter<E>,
    com.aoapps.html.any.attributes.event.Ondragleave<E>,
    com.aoapps.html.any.attributes.event.Ondragover<E>,
    com.aoapps.html.any.attributes.event.Ondragstart<E>,
    com.aoapps.html.any.attributes.event.Ondrop<E>,
    com.aoapps.html.any.attributes.event.OndurationchangeUnexpected<E>,
    com.aoapps.html.any.attributes.event.OnemptiedUnexpected<E>,
    com.aoapps.html.any.attributes.event.OnendedUnexpected<E>,
    com.aoapps.html.any.attributes.event.OnerrorUnexpected<E>,
    com.aoapps.html.any.attributes.event.Onfocus<E>,
    // TODO: onformdata (fired on form only?)
    //       https://html.spec.whatwg.org/multipage/dom.html#global-attributes:handler-onformdata
    //       https://html.spec.whatwg.org/multipage/webappapis.html#handler-onformdata
    //       https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-onformdata
    //       https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/onformdata
    // TODO: ongotpointercapture
    //       https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/ongotpointercapture
    //       https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/gotpointercapture_event
    com.aoapps.html.any.attributes.event.OninputUnexpected<E>,
    com.aoapps.html.any.attributes.event.OninvalidUnexpected<E>,
    com.aoapps.html.any.attributes.event.Onkeydown<E>,
    com.aoapps.html.any.attributes.event.Onkeypress<E>,
    com.aoapps.html.any.attributes.event.Onkeyup<E>,
    com.aoapps.html.any.attributes.event.OnloadUnexpected<E>,
    com.aoapps.html.any.attributes.event.OnloadeddataUnexpected<E>,
    com.aoapps.html.any.attributes.event.OnloadedmetadataUnexpected<E>,
    com.aoapps.html.any.attributes.event.OnloadstartUnexpected<E>,
    // TODO: onlostpointercapture
    //       https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/onlostpointercapture
    //       https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/lostpointercapture_event
    com.aoapps.html.any.attributes.event.Onmousedown<E>,
    com.aoapps.html.any.attributes.event.Onmouseenter<E>,
    com.aoapps.html.any.attributes.event.Onmouseleave<E>,
    com.aoapps.html.any.attributes.event.Onmousemove<E>,
    com.aoapps.html.any.attributes.event.Onmouseout<E>,
    com.aoapps.html.any.attributes.event.Onmouseover<E>,
    com.aoapps.html.any.attributes.event.Onmouseup<E>,
    com.aoapps.html.any.attributes.event.Onmousewheel<E>,
    com.aoapps.html.any.attributes.event.Onpaste<E>,
    com.aoapps.html.any.attributes.event.OnpauseUnexpected<E>,
    com.aoapps.html.any.attributes.event.OnplayUnexpected<E>,
    com.aoapps.html.any.attributes.event.OnplayingUnexpected<E>,
    // TODO: onpointercancel
    //       https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/ononpointercancel
    //       https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/pointercancel_event
    // TODO: onpointerdown
    //       https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/ononpointerdown
    //       https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/pointerdown_event
    // TODO: onpointerenter
    //       https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/ononpointerenter
    //       https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/pointerenter_event
    // TODO: onpointerleave
    //       https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/ononpointerleave
    //       https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/pointerleave_event
    // TODO: onpointermove
    //       https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/ononpointermove
    //       https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/pointermove_event
    // TODO: onpointerout
    //       https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/ononpointerout
    //       https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/pointerout_event
    // TODO: onpointerover
    //       https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/ononpointerover
    //       https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/pointerover_event
    // TODO: onpointerrawupdate
    //       https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/ononpointerrawupdate
    //       https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/pointerrawupdate_event
    // TODO: onpointerup
    //       https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/ononpointerup
    //       https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/pointerup_event
    com.aoapps.html.any.attributes.event.OnprogressUnexpected<E>,
    com.aoapps.html.any.attributes.event.OnratechangeUnexpected<E>,
    com.aoapps.html.any.attributes.event.OnresetUnexpected<E>,
    com.aoapps.html.any.attributes.event.OnresizeUnexpected<E>,
    com.aoapps.html.any.attributes.event.Onscroll<E>,
    com.aoapps.html.any.attributes.event.OnsecuritypolicyviolationUnexpected<E>,
    com.aoapps.html.any.attributes.event.OnseekedUnexpected<E>,
    com.aoapps.html.any.attributes.event.OnseekingUnexpected<E>,
    com.aoapps.html.any.attributes.event.OnselectUnexpected<E>,
    // TODO: onselectstart
    //       https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/onselectstart
    // TODO: onselectionchange
    //       https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/onselectionchange
    com.aoapps.html.any.attributes.event.OnslotchangeUnexpected<E>,
    com.aoapps.html.any.attributes.event.OnstalledUnexpected<E>,
    com.aoapps.html.any.attributes.event.OnsubmitUnexpected<E>,
    com.aoapps.html.any.attributes.event.OnsuspendUnexpected<E>,
    com.aoapps.html.any.attributes.event.OntimeupdateUnexpected<E>,
    com.aoapps.html.any.attributes.event.OntoggleUnexpected<E>,
    // TODO: ontouchcancel
    //       https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/ontouchcancel
    //       https://developer.mozilla.org/en-US/docs/Web/API/Element/touchcancel_event
    //       https://www.w3schools.com/jsref/event_touchcancel.asp
    // TODO: ontouchend
    //       https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/ontouchend
    //       https://developer.mozilla.org/en-US/docs/Web/API/Element/touchend_event
    //       https://www.w3schools.com/jsref/event_touchend.asp
    // TODO: ontouchmove
    //       https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/ontouchmove
    //       https://developer.mozilla.org/en-US/docs/Web/API/Element/touchmove_event
    //       https://www.w3schools.com/jsref/event_touchmove.asp
    // TODO: ontouchstart
    //       https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/ontouchstart
    //       https://developer.mozilla.org/en-US/docs/Web/API/Element/touchstart_event
    //       https://www.w3schools.com/jsref/event_touchstart.asp
    // TODO: ontransitioncancel
    //       https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/ontransitioncancel
    //       https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/transitioncancel_event
    // TODO: ontransitionend
    //       https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/ontransitionend
    //       https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/transitionend_event
    //       https://www.w3schools.com/jsref/event_transitionend.asp
    // TODO: ontransitionrun
    //       https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/ontransitionrun
    //       https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/transitionrun_event
    // TODO: ontransitionstart
    //       https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/ontransitionstart
    //       https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/transitionstart_event
    com.aoapps.html.any.attributes.event.OnvolumechangeUnexpected<E>,
    com.aoapps.html.any.attributes.event.OnwaitingUnexpected<E>,
    // TODO: onwebkitanimationend
    //       https://html.spec.whatwg.org/multipage/webappapis.html#handler-onwebkitanimationend
    //       https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-onwebkitanimationend
    // TODO: onwebkitanimationiteration
    //       https://html.spec.whatwg.org/multipage/webappapis.html#handler-onwebkitanimationiteration
    //       https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-onwebkitanimationiteration
    // TODO: onwebkitanimationstart
    //       https://html.spec.whatwg.org/multipage/webappapis.html#handler-onwebkitanimationstart
    //       https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-onwebkitanimationstart
    // TODO: onwebkittransitionend
    //       https://html.spec.whatwg.org/multipage/webappapis.html#handler-onwebkittransitionend
    //       https://html.spec.whatwg.org/multipage/webappapis.html#idl-definitions:handler-onwebkittransitionend
    com.aoapps.html.any.attributes.event.Onwheel<E> {
  // No methods, just adding attributes
}
