package net.sf.gazpachoquest.questionnaires;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Panel;

public class GazpachoViewDisplay extends Panel implements ViewDisplay {

    public GazpachoViewDisplay() {
        setSizeFull();
    }

    @Override
    public void showView(View view) {
        if (view instanceof CustomComponent) {
            setContent((CustomComponent) view);
        } else if (view instanceof ComponentContainer) {
            setContent((ComponentContainer) view);
        } else {
            throw new IllegalStateException("View not supported! ");
        }
    }

}
