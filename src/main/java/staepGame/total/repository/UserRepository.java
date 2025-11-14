package staepGame.total.repository;

import staepGame.total.model.StepRank;
import staepGame.total.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {

    private final List<User> userList = new ArrayList<>();


    public void add(User user) {
        userList.add(user);
    }

    public Optional<User> findUser(String userName) {
        return userList.stream()
                .filter(user -> user.getName().equals(userName))
                .findFirst();
    }

    public List<User> findAll() {
        return userList;
    }
}
