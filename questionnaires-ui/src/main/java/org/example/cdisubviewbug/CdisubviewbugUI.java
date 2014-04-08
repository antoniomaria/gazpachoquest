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

import javax.inject.Inject;

import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

// @CDIUI
public class CdisubviewbugUI extends UI {

    private final VerticalLayout vl = new VerticalLayout();
    private Navigator navigator = null;

    // @Inject
    // private CdiNavViewProvider viewProvider;

    @Inject
    private TweakedCDIViewProvider viewProvider;

    @Override
    protected void init(VaadinRequest request) {
        setSizeFull();
        vl.addComponent(new Label("My Application"));
        navigator = new Navigator(this, vl);
        navigator.addProvider(this.viewProvider);
        setContent(vl);
    }
}
