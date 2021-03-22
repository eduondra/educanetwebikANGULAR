package cz.educanet.webik;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@ApplicationScoped
public class UserManager {

    @Inject
    private LogManager loginManager;

    private ArrayList<User> userList = new ArrayList<>();

    public ArrayList<User> getUsers() {
        return userList;
    }

    public boolean createUser(User user) {
        user.setId(userList.size());
        return userList.add(user);
    }

    public UserToken checkUser(User user) {
        Optional<User> tempUser = userList.stream()
                .filter(u -> u.getUsername().equals(user.getUsername()))
                .findFirst();
        if (tempUser.isPresent() && Objects.equals(tempUser.get().getPassword(), user.getPassword()))
            return loginManager.createToken();
        return null;
    }

    public User getUserById(int id) {
        return userList.stream()
                .filter(userListStream -> id == userListStream.getId())
                .findAny()
                .orElse(null);
    }

    public boolean deleteUserById(int id) {

        return userList.remove(id) != null;
    }

}

