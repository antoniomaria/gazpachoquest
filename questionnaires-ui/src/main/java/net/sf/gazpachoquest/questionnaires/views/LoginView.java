package net.sf.gazpachoquest.questionnaires.views;

import java.util.Locale;

import com.vaadin.cdi.CDIView;
import com.vaadin.data.validator.AbstractValidator;
import com.vaadin.data.validator.EmailValidator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.Reindeer;

@CDIView(LoginView.NAME)
public class LoginView extends CustomComponent implements View, Button.ClickListener {

    private static final long serialVersionUID = 2314128852757221652L;

    public static final String NAME = "";

    private final TextField user;

    private final PasswordField password;

    private final Button loginButton;

    private ComboBox createLanguageSelector() {
        ComboBox languageSelector = new ComboBox("com.vaadin.demo.dashboard.DashboardUI.Language");
        languageSelector.setImmediate(true);
        languageSelector.setNullSelectionAllowed(false);
        addLocale(Locale.ENGLISH, languageSelector);
        addLocale(Locale.FRENCH, languageSelector);
        addLocale(new Locale("es"), languageSelector);
        // languageSelector.setValue(I18NStaticService.getI18NServive().getLocale());
        /*-languageSelector.addValueChangeListener(new ValueChangeListener() {

            private static final long serialVersionUID = 1L;

            @Override
            public void valueChange(ValueChangeEvent event) {
                Locale locale = (Locale) (event.getProperty().getValue());
                I18NStaticService.getI18NServive().setLocale(locale);
                getUI().requestRepaintAll();
            }
        });*/
        return languageSelector;
    }

    private void addLocale(Locale locale, ComboBox languageSelector) {
        languageSelector.addItem(locale);
        languageSelector.setItemCaption(locale, "XX");
    }

    public LoginView() {
        setSizeFull();

        // Language bar in the top-right corner for selecting
        // user interface language
        final HorizontalLayout languageBar = new HorizontalLayout();
        languageBar.setHeight("50px");
        // addComponent(languageBar);
        // setComponentAlignment(languageBar, Alignment.TOP_RIGHT);

        // Allow selecting a language. We are in a constructor of a
        // CustomComponent, so preselecting the current
        // language of the application can not be done before
        // this (and the selection) component are attached to
        // the application.
        final ComboBox languageSelector = new ComboBox("Select a language") {
            @Override
            public void attach() {
                super.attach();
                // setValue(getLocale());
            }
        };

        // for (int i=0; i<locales.length; i++) {
        String locale = "es";
        languageSelector.addItem(locale);
        languageSelector.setItemCaption(locale, "español");

        // Automatically select the current locale
        // if (locales[i].equals(getLocale()))
        languageSelector.setValue(locale);

        // }

        // Create the user input field
        user = new TextField("User:");
        user.setWidth("300px");
        user.setRequired(true);
        user.setInputPrompt("Your username (eg. joe@email.com)");
        user.addValidator(new EmailValidator("Username must be an email address"));
        user.setInvalidAllowed(false);

        // Create the password input field
        password = new PasswordField("Password:");
        password.setWidth("300px");
        password.addValidator(new PasswordValidator());
        password.setRequired(true);
        password.setValue("");
        password.setNullRepresentation("");

        // Create login button
        loginButton = new Button("Login", this);

        // Add both to a panel
        VerticalLayout fields = new VerticalLayout(languageSelector, user, password, loginButton);
        fields.setCaption("Please login to access the application. (test@test.com/passw0rd)");
        fields.setSpacing(true);
        fields.setMargin(new MarginInfo(true, true, true, false));
        fields.setSizeUndefined();

        // The view root layout
        VerticalLayout viewLayout = new VerticalLayout(fields);
        viewLayout.setSizeFull();
        viewLayout.setComponentAlignment(fields, Alignment.MIDDLE_CENTER);
        viewLayout.setStyleName(Reindeer.LAYOUT_BLUE);
        setCompositionRoot(viewLayout);
    }

    @Override
    public void enter(ViewChangeEvent event) {
        // focus the username field when user arrives to the login view
        user.focus();
    }

    //
    // Validator for validating the passwords
    //
    private static final class PasswordValidator extends AbstractValidator<String> {

        public PasswordValidator() {
            super("The password provided is not valid");
        }

        @Override
        protected boolean isValidValue(String value) {
            //
            // Password must be at least 8 characters long and contain at least
            // one number
            //
            if (value != null && (value.length() < 8 || !value.matches(".*\\d.*"))) {
                return false;
            }
            return true;
        }

        @Override
        public Class<String> getType() {
            return String.class;
        }
    }

    @Override
    public void buttonClick(ClickEvent event) {

        //
        // Validate the fields using the navigator. By using validors for the
        // fields we reduce the amount of queries we have to use to the database
        // for wrongly entered passwords
        //
        if (!user.isValid() || !password.isValid()) {
            return;
        }

        String username = user.getValue();
        String password = this.password.getValue();

        //
        // Validate username and password with database here. For examples sake
        // I use a dummy username and password.
        //
        boolean isValid = username.equals("test@test.com") && password.equals("passw0rd");

        if (isValid) {
            // Store the current user in the service session
            getSession().setAttribute("user", username);

            // Navigate to main view
            // getUI().getNavigator().navigateTo(SimpleLoginMainView.NAME);

        } else {

            // Wrong password clear the password field and refocuses it
            this.password.setValue(null);
            this.password.focus();
        }
    }
}