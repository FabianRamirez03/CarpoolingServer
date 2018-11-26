package org.carpooling.ws.server.user;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    public static List<User> users = new ArrayList<>();
    private ObjectMapper mapper = new ObjectMapper();

    public String getUser(int id) {
        String user = null;
        try {
            user = mapper.writeValueAsString(users.get(id));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void newUser(String user) {
        try {
            users.add(mapper.readValue(user, User.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
