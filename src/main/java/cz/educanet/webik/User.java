package cz.educanet.webik;

public class User {

    private String firstname;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private int id;

    public User(){

    }

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
    public int getId() {
        return id;
    }


    public String setUsername(String username) {
        return this.username = username;
    }

    public String setPassword(String password) {
        return this.password = password;
    }
    public int setId(int id) {
        return this.id = id;
    }


    public String renameUser(String newUsername) {
        return username = newUsername;
    }


}
