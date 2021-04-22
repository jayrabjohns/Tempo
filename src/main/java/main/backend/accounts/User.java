package main.backend.accounts;

public class User {
    private int id;
    private String forename;
    private String surname;
    private String username;
    private String email;
    private String password;

    public User(int id, String forename, String surname, String username, String email, String password) {
        this.id = id;
        this.forename = forename;
        this.surname = surname;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return this.id;
    }

    public String getForename() {
        return this.forename;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getUsername() {
        return this.username;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }
}
