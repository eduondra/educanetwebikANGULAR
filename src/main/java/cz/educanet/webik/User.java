package cz.educanet.webik;

public class User {

    private String firstname;
    private String lastName;
    private String username;
    private String password;
    private String email;

    public User(String firstName, String lastName, String username, String password, String email) {
        this.firstname= firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


    public String renameUser(String newUsername) {
        return username = newUsername;
    }


}