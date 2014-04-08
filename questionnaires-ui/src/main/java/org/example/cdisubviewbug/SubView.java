/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     antoniomaria - initial API and implementation
 ******************************************************************************/
package org.example.cdisubviewbug;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

// @CDIView(value = SubView.VIEW_ID)
public class SubView extends VerticalLayout implements View {
    public static final String VIEW_ID = MainView.VIEW_ID + "/" + "subview";

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        // removeAllComponents();
        addComponent(new Label("" + VIEW_ID));
    }

}
