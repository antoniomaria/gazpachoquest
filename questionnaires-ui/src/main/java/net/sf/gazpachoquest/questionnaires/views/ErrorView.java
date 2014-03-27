package net.sf.gazpachoquest.questionnaires.views;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class ErrorView extends VerticalLayout implements View {

    public ErrorView() {
        setMargin(true);
        setSpacing(true);
        setSizeFull();

        addComponent(new Label("Error loading view, you may not have proper access rights"));
    }

    @Override
    public void enter(ViewChangeEvent event) {
        // TODO Auto-generated method stub
    }

}