package main.session;

import main.backend.DBHandler;

public class Session {

    private static Session instance = new Session();

    private int user_id;
    private String username;

    public static Session get() {
        return Session.instance;
    }

    private Session() {
    }

    /**
     * Log a user into the session
     */
    public void login(String username) {

        this.username = username;
        this.user_id = DBHandler.getActiveUserID(username);
    }

    /**
     * Log the user out of the session
     */
    public void logout() {
        this.username = null;
        this.user_id = -1;
    }

    /**
     * Return the model of the logged in user?
     * 
     * @return -1 if not logged in
     */
    public int getUserId() {
        return this.user_id;
    }

    /**
     * Return the model of the logged in user?
     * 
     * @return null if not logged in
     */
    public String getUsername() {
        return this.username;
    }
}