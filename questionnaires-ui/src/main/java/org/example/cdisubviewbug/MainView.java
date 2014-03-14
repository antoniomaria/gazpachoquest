package org.example.cdisubviewbug;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

// @CDIView(value = MainView.VIEW_ID)
public class MainView extends VerticalLayout implements View {
    public static final String VIEW_ID = "main";

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        // removeAllComponents();
        addComponent(new Label("" + VIEW_ID));
        Button bt = new Button("GO");
        bt.addClickListener(new ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                getUI().getNavigator().navigateTo(SubView.VIEW_ID);
            }
        });
        addComponent(bt);
    }

}