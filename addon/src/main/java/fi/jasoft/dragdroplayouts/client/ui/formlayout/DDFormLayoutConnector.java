/*
 * Copyright 2014 John Ahlroos
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package fi.jasoft.dragdroplayouts.client.ui.formlayout;

import com.vaadin.client.ApplicationConnection;
import com.vaadin.client.Paintable;
import com.vaadin.client.UIDL;
import com.vaadin.client.ui.formlayout.FormLayoutConnector;
import com.vaadin.shared.ui.Connect;

import fi.jasoft.dragdroplayouts.DDFormLayout;
import fi.jasoft.dragdroplayouts.client.VDragFilter;
import fi.jasoft.dragdroplayouts.client.ui.VDragDropUtil;
import fi.jasoft.dragdroplayouts.client.ui.interfaces.VHasDragFilter;

@Connect(DDFormLayout.class)
public class DDFormLayoutConnector extends FormLayoutConnector implements
	Paintable, VHasDragFilter {

    @Override
    public VDDFormLayout getWidget() {
	return (VDDFormLayout) super.getWidget();
    }

    @Override
    public DDFormLayoutState getState() {
	return (DDFormLayoutState) super.getState();
    }

    @Override
    protected void init() {
	super.init();
	VDragDropUtil.listenToStateChangeEvents(this, getWidget());
    }

    public void updateFromUIDL(UIDL uidl, ApplicationConnection client) {
	VDragDropUtil.updateDropHandlerFromUIDL(uidl, this,
		new VDDFormLayoutDropHandler(this));
    }

    @Override
    public VDragFilter getDragFilter() {
	return getWidget().getDragFilter();
    }

    @Override
    public void setDragFilter(VDragFilter filter) {
	getWidget().setDragFilter(filter);
    }

}
