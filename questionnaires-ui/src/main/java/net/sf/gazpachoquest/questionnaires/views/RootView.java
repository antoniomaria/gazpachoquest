package net.sf.gazpachoquest.questionnaires.views;

import javax.inject.Inject;

import net.sf.gazpachoquest.questionnaires.util.SessionStore;

import com.vaadin.cdi.CDIView;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@CDIView
public class RootView extends AbstractView {
    // UI scoped
    @Inject
    private SessionStore sessionStore;

    @Override
    protected Component buildContent() {
        VerticalLayout layout = new VerticalLayout();
        layout.setSizeUndefined();

        Label label = new Label("Top-level content here");
        label.setSizeUndefined();
        layout.addComponent(label);

        final Label countLabel = new Label("UI scoped counter = " + sessionStore.get());
        countLabel.setSizeUndefined();
        layout.addComponent(countLabel);

        Button incrementButton = new Button("Increment UI scoped");
        layout.addComponent(incrementButton);
        incrementButton.addClickListener(new ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                countLabel.setValue("UI scoped counter = " + sessionStore.next());
            }
        });

        return layout;
    }

}
