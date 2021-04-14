package main.session;

public class Session {

    private static Session instance = new Session();

    public static Session get() {
        return Session.instance;
    }

    private Session() {
    }

    /**
     * Log a user into the session
     */
    public void login() {
        return;
    }

    /**
     * Log the user out of the session
     */
    public void logout() {

    }

    /**
     * Return the model of the logged in user?
     * 
     * @return null if not logged in
     */
    public int getUser() {
        return -1;
    }
}