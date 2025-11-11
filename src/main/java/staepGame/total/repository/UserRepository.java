package staepGame.total.repository;

import staepGame.total.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private final List<User> userList = new ArrayList<>();


    public void add(User user) {
        userList.add(user);
    }

    public List<User> getUserList() {
        return userList;
    }
}
