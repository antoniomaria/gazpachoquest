package net.sf.gazpachoquest.questionnaires.views.login;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import net.sf.gazpachoquest.dto.auth.RespondentAccount;

import com.vaadin.cdi.CDIView;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.Reindeer;

@CDIView(MyLoginView.NAME)
public class MyLoginView extends CustomComponent implements View {

    private static final long serialVersionUID = -5588579843187115669L;

    public static final String NAME = "login";

    private PasswordField invitation;
    private Button login;

    @PostConstruct
    public void init() {
        setSizeFull();
        setCompositionRoot(createCompositionRoot());
    }

    @Inject
    private javax.enterprise.event.Event<LoginEvent> loginEvent;

    protected CssLayout createCompositionRoot() {
        CssLayout root = new CssLayout();
        root.setSizeFull();
        
        VerticalLayout   loginLayout = new VerticalLayout();
        loginLayout.setSizeFull();
        loginLayout.addStyleName("login-layout");
        root.addComponent(loginLayout);

        final CssLayout loginPanel = new CssLayout();
        loginPanel.addStyleName("login-panel");
        loginLayout.addComponent(loginPanel);
        
        //VerticalLayout loginPanel = new VerticalLayout();
       // loginPanel.setSpacing(true);
        // loginPanel.setWidth("400px");

        HorizontalLayout labels = new HorizontalLayout();
        labels.setWidth("100%");
        labels.setMargin(true);
        labels.addStyleName("labels");
        loginPanel.addComponent(labels);

        Label welcome = new Label("Welcome");
        welcome.setSizeUndefined();
        welcome.addStyleName(Reindeer.LABEL_H2);
        labels.addComponent(welcome);
        labels.setComponentAlignment(welcome, Alignment.MIDDLE_LEFT);

        Label title = new Label("Gazpacho Quest");
        title.setSizeUndefined();
        title.addStyleName(Reindeer.LABEL_H1);
        labels.addComponent(title);
        labels.setComponentAlignment(title, Alignment.MIDDLE_RIGHT);

        HorizontalLayout fields = new HorizontalLayout();

        fields.setWidth("100%");
        fields.setSpacing(true);
        fields.setMargin(true);
        fields.addStyleName("fields");

        invitation = new PasswordField("Invitation");
        invitation.setSizeUndefined();
        // invitation.setWidth("100%");
        invitation.focus();
        invitation.setValue("YAS5ICHRBE");
        fields.addComponent(invitation);

        final Button signin = new Button("Sign In");
        fields.addComponent(signin);
        fields.setComponentAlignment(signin, Alignment.BOTTOM_LEFT);

        loginPanel.addComponent(fields);

      

        return root;
    }

    protected HorizontalLayout createCompositionRootx() {
        VerticalLayout loginPanel = new VerticalLayout();
        loginPanel.setSpacing(true);
        loginPanel.setWidth("400px");

        Label header = new Label("Enter your invitation to start the questionnair");
        header.addStyleName(Reindeer.LABEL_H1);
        loginPanel.addComponent(header);

        invitation = new PasswordField("Invitation");
        invitation.setWidth("100%");
        invitation.focus();
        invitation.setValue("YAS5ICHRBE");
        loginPanel.addComponent(invitation);

        HorizontalLayout buttons = new HorizontalLayout();
        buttons.setSpacing(true);
        loginPanel.addComponent(buttons);
        loginPanel.setComponentAlignment(buttons, Alignment.MIDDLE_RIGHT);

        login = new Button("Start");
        login.setClickShortcut(KeyCode.ENTER);
        login.addStyleName(Reindeer.BUTTON_DEFAULT);
        login.addClickListener(createLoginButtonListener());
        buttons.addComponent(login);

        HorizontalLayout viewLayout = new HorizontalLayout();
        viewLayout.addComponent(loginPanel);
        viewLayout.setComponentAlignment(loginPanel, Alignment.MIDDLE_CENTER);
        viewLayout.setSizeFull();
        viewLayout.addStyleName(Reindeer.LAYOUT_BLUE);
        setSizeFull();

        return viewLayout;
    }

    protected Button.ClickListener createLoginButtonListener() {
        return new Button.ClickListener() {
            private static final long serialVersionUID = 3424514570135131495L;

            @Override
            public void buttonClick(Button.ClickEvent event) {
                loginEvent.fire(new LoginEvent(RespondentAccount.USER_NAME, invitation.getValue()));
            }
        };
    }

    // @Override
    public void showLoginFailed() {
        // viewLayout.getWindow().showNotification("Login failed. Please try again.",
        // Notification.TYPE_HUMANIZED_MESSAGE);
    }

    public void clearForm() {
        invitation.setValue("");
    }

    @Override
    public void enter(ViewChangeEvent event) {
        // TODO Auto-generated method stub

    }
}
