package net.sf.gazpachoquest.questionnaires.views;

import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

// @CDIView
public class LoginView extends AbstractView {

    private static final long serialVersionUID = 6808925001649270387L;

    private final Button btnLogin = new Button("Login");
    private final TextField login = new TextField("Username");
    private final PasswordField password = new PasswordField("Password");

    public LoginView() {
        super();
    }

    @Override
    protected Component buildContent() {
        super.setCaption("Authentication Required !");

        VerticalLayout layout = new VerticalLayout();

        layout.addComponent(new Label("Please login in order to use the application"));
        layout.addComponent(new Label());
        layout.addComponent(login);
        layout.addComponent(password);
        layout.addComponent(btnLogin);

        return layout;
    }
}