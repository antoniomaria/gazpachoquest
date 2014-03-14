package com.github.wolfie.history.simpledemo;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.github.wolfie.history.HistoryExtension;
import com.github.wolfie.history.HistoryExtension.ErrorListener;
import com.github.wolfie.history.HistoryExtension.PopStateEvent;
import com.github.wolfie.history.HistoryExtension.PopStateListener;
import com.vaadin.annotations.Title;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.event.ShortcutListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Title("Simplified HTML5 History Demo")
public class SimpleHistoryUI extends UI {

    private static final String DATA_KEY = "data";

    // @WebServlet(urlPatterns = { "/SimpleDemo/*" }, asyncSupported = true)
    // @VaadinServletConfiguration(productionMode = false, ui = SimpleHistoryUI.class)
    public static class Servlet extends VaadinServlet {
        // default implementation is fine.
    }

    private final VerticalLayout layout = new VerticalLayout();
    private HistoryExtension history;
    private TextField url;
    private TextField stateField;

    @Override
    protected void init(final VaadinRequest request) {

        history = HistoryExtension.extend(this,

        new PopStateListener() {
            @Override
            public void popState(final PopStateEvent event) {
                final Map<String, String> state = event.getStateAsMap();
                stateField.setValue(state.get(DATA_KEY));
                url.setValue(event.getAddress().toString());
            }
        },

        new ErrorListener() {
            @Override
            public void onError(final HistoryExtension.ErrorEvent event) {
                Notification.show(event.getErrorName() + ": " + event.getMessage(), Notification.Type.ERROR_MESSAGE);
                event.cancel();
            }
        });
        /*
         * we want to initialize the history state data with something we can handle in our popstate listener
         */
        history.replaceState(Collections.singletonMap(DATA_KEY, ""), getPage().getLocation().toString());

        setContent(layout);

        layout.addComponent(new Label("Choose some text " + "to store in "
                + "a state. Then choose a new URL to navigate to. After "
                + "you've done this a few times, press the back and "
                + "forward buttons in your browser to see what happens"));

        final FormLayout fl = new FormLayout();
        fl.setSpacing(true);
        fl.setMargin(true);
        layout.addComponent(fl);

        stateField = new TextField("State data");
        fl.addComponent(stateField);

        url = new TextField("URL");
        url.setValue(getPage().getLocation().toString());
        url.setWidth("500px");
        url.addShortcutListener(new ShortcutListener("", KeyCode.ENTER, (int[]) null) {
            @Override
            public void handleAction(final Object sender, final Object target) {
                pushState();
            }
        });
        fl.addComponent(url);

        fl.addComponent(new Button("Save and go", new Button.ClickListener() {
            @Override
            public void buttonClick(final ClickEvent event) {
                pushState();
            }
        }));
    }

    private void pushState() {
        final Map<String, String> stateMap = new HashMap<String, String>();
        stateMap.put(DATA_KEY, stateField.getValue());
        history.pushState(stateMap, url.getValue());
    }
}