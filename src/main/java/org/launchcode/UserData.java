package org.launchcode;

import org.launchcode.models.User;

import java.util.ArrayList;
import java.util.HashMap;

public class UserData {
    private static HashMap<Integer, User> userList = new HashMap<>();

    public static void add(User user) {
        userList.put(user.getId(), user);
    }

    public static ArrayList<User> getAll() {
        return (ArrayList<User>) userList.values();
    }

    public static User getById(int id) {
        return userList.get(id);
    }
}
