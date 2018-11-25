package org.carpooling.ws.server.user;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    public static List<User> users = new ArrayList<>();

    public User getUser(int id) {
        return users.get(id);
    }

    public void newUser(User user) {
        users.add(user);
    }
}
