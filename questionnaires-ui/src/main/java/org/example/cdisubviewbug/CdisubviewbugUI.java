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