package net.sf.gazpachoquest.questionnaires.views.login;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.cdi.CDIView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

@CDIView(LoginView.NAME)
public class LoginView extends CustomComponent implements View {

    private static final long serialVersionUID = 2314128852757221652L;

    private static Logger logger = LoggerFactory.getLogger(LoginView.class);

    public static final String NAME = "login";

    private TextField username;
    private PasswordField password;

    @Inject
    private javax.enterprise.event.Event<LoginEvent> loginEvent;

    private final Button.ClickListener loginButtonListener = new Button.ClickListener() {

        @Override
        public void buttonClick(ClickEvent event) {
            performLogin();
        }
    };

    @PostConstruct
    public void init() {
        setSizeFull();

        VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        layout.setSpacing(true);

        username = new TextField();
        username.setInputPrompt("User name");

        password = new PasswordField();
        password.setInputPrompt("Password");

        layout.addComponent(username);
        layout.addComponent(password);

        Button login = new Button("Login", loginButtonListener);

        layout.addComponent(login);

        setCompositionRoot(layout);
    }

    protected void performLogin() {
        loginEvent.fire(new LoginEvent(username.getValue(), password.getValue()));
    }

    @Override
    public void enter(ViewChangeEvent event) {
        // TODO Auto-generated method stub

    }

}