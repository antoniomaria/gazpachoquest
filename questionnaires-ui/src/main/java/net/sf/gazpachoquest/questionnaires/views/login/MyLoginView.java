package net.sf.gazpachoquest.questionnaires.views.login;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import com.vaadin.cdi.CDIView;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.Reindeer;

@CDIView(LoginView.NAME)
public class MyLoginView extends CustomComponent implements View {

    private static final long serialVersionUID = -5588579843187115669L;

    public static final String NAME = "login";

    private HorizontalLayout viewLayout;
    private TextField username;
    private PasswordField password;
    private Button login;

    @PostConstruct
    public void init() {
        setSizeFull();
        setCompositionRoot(createCompositionRoot());
    }

    @Inject
    private javax.enterprise.event.Event<LoginEvent> loginEvent;

    protected HorizontalLayout createCompositionRoot() {
        VerticalLayout loginPanel = new VerticalLayout();
        loginPanel.setSpacing(true);
        loginPanel.setWidth("300px");

        Label header = new Label("Please login");
        header.addStyleName(Reindeer.LABEL_H1);
        loginPanel.addComponent(header);

        username = new TextField("Username");
        username.setWidth("100%");
        loginPanel.addComponent(username);

        password = new PasswordField("Password");
        password.setWidth("100%");
        loginPanel.addComponent(password);

        HorizontalLayout buttons = new HorizontalLayout();
        buttons.setSpacing(true);
        loginPanel.addComponent(buttons);
        loginPanel.setComponentAlignment(buttons, Alignment.MIDDLE_RIGHT);

        login = new Button("Login");
        login.setClickShortcut(KeyCode.ENTER);
        login.addStyleName(Reindeer.BUTTON_DEFAULT);
        login.addClickListener(createLoginButtonListener());
        buttons.addComponent(login);

        viewLayout = new HorizontalLayout();
        viewLayout.addComponent(loginPanel);
        viewLayout.setComponentAlignment(loginPanel, Alignment.MIDDLE_CENTER);
        viewLayout.setSizeFull();
        viewLayout.addStyleName(Reindeer.LAYOUT_BLUE);
        setSizeFull();

        username.focus();

        return viewLayout;
    }

    protected Button.ClickListener createLoginButtonListener() {
        return new Button.ClickListener() {
            private static final long serialVersionUID = 3424514570135131495L;

            @Override
            public void buttonClick(Button.ClickEvent event) {
                loginEvent.fire(new LoginEvent(username.getValue(), password.getValue()));
            }
        };
    }

    // @Override
    public void showLoginFailed() {
        // viewLayout.getWindow().showNotification("Login failed. Please try again.",
        // Notification.TYPE_HUMANIZED_MESSAGE);
    }

    public void clearForm() {
        username.setValue("");
        password.setValue("");
        username.focus();
    }

    @Override
    public void enter(ViewChangeEvent event) {
        // TODO Auto-generated method stub

    }
}
