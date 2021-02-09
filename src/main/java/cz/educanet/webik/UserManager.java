package cz.educanet.webik;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class UserManager {

    private ArrayList<User> userList = new ArrayList<User>();

    public boolean existByUsername(String username) {
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }


    public void save(User tempUser) {
        userList.add(tempUser);

    }

    public User getUserByUsernameAndPassword(String username, String password) {


        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getUsername().equals(username) && (userList.get(i).getPassword().equals(password))) {

                return userList.get(i);
            }
        }
        return null;
    }

    public ArrayList<User> getAllUsers() {

        return userList;
    }

}

