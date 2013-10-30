package net.sf.gazpachosurvey.api;

public interface SecurityService {

    String USER_SYSTEM = "admin";
    
    boolean isAuthenticated();

    String currentUsername();

}
