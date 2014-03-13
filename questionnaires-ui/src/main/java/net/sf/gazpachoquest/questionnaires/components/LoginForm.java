package net.sf.gazpachoquest.questionnaires.components;

import com.vaadin.ui.Button;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class LoginForm extends VerticalLayout {
    private final TextField txtLogin = new TextField("Login: ");
    private final PasswordField txtPassword = new PasswordField("Password: ");
    private final Button btnLogin = new Button("Login");

    public LoginForm() {
        addComponent(txtLogin);
        addComponent(txtPassword);
        addComponent(btnLogin);
        LoginFormListener loginFormListener = getLoginFormListener();
        btnLogin.addClickListener(loginFormListener);
    }

    public LoginFormListener getLoginFormListener() {
        AppUI ui = (AppUI) UI.getCurrent();
        ApplicationContext context = ui.getApplicationContext();
        return context.getBean(LoginFormListener.class);
    }

    public TextField getTxtLogin() {
        return txtLogin;
    }

    public PasswordField getTxtPassword() {
        return txtPassword;
    }

}
