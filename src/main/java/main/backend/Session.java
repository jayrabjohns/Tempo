package main.backend;

import main.backend.accounts.User;

public class Session {

    private static Session instance;

    private User user;

    public static void init(DBHandler db) {
        instance = new Session(db);
    }

    public static Session get() {
        if(Session.instance == null) {
            throw new IllegalStateException("Session must be initialized first");
        }

        return Session.instance;
    }

    private Session(DBHandler db) {
    }

    /**
     * Log a user into the session
     */
    public void login(String username) {
        this.user = DBHandler.getActiveUserID(username);
    }

    /**
     * Log a user into the session
     * 
     * @deprecated NOT TO BE USED FOR PRODUCTION
     */
    public void login(int username) {
        this.user = new User(username, "Forename", "Surname", "Username", "email here", "");
    }

    /**
     * Log the user out of the session
     */
    public void logout() {
        this.user = null;
    }

    /**
     * Return the model of the logged in user?
     * 
     * @return -1 if not logged in
     */
    public int getUserId() {
        if(this.user == null) {
            return -1;
        }

        return this.user.getId();
    }

    /**
     * Return the username of the user
     * 
     * @return empty string if not logged in
     */
    public String getUsername() {
        if(this.user == null) {
            return "";
        }

        return this.user.getUsername();
    }

    /**
     * Return the forename of the user
     * 
     * @return empty string if not logged in
     */
    public String getForename() {
        if(this.user == null) {
            return "";
        }

        return this.user.getForename();
    }

    /**
     * Return the surname of the user
     * 
     * @return empty string if not logged in
     */
    public String getSurname() {
        if(this.user == null) {
            return "";
        }

        return this.user.getSurname();
    }

    /**
     * Return the email address of the user
     * 
     * @return empty string if not logged in
     */
    public String getEmail() {
        if(this.user == null) {
            return "";
        }

        return this.user.getEmail();
    }

}