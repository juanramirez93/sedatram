package com.sedatram.controller;
import com.sedatram.model.User;

public class SessionController {

    private static SessionController instance;

    private User userSession;

    private SessionController() {
    }

    public static SessionController getInstance() {
        if(instance == null) {
            instance = new SessionController();
        }
        return instance;
    }

    public User getUserSession() {
        return userSession;
    }

    public void setUserSession(User userSession) {
        this.userSession = userSession;
    }
}
