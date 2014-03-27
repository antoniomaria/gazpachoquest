package net.sf.gazpachoquest.questionnaires.views.login;

public class LoginEvent {

    private final String username;
    private final String password;

    public LoginEvent(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
