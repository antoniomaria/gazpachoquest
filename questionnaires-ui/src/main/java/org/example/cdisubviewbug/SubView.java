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