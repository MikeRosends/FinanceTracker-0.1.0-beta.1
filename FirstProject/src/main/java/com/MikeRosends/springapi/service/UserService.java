package com.MikeRosends.springapi.service;

import com.MikeRosends.springapi.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private List<User> userList;

    public UserService() {
        userList = new ArrayList<>();

        User user1 = new User(1, "Mike", 25, "mike@mail.com");
        User user2 = new User(2, "Pete", 35, "pete@mail.com");
        User user3 = new User(3, "Bia", 20, "bia@mail.com");
        User user4 = new User(4, "tommy", 30, "tommy@mail.com");

        userList.addAll(Arrays.asList(user1, user2, user3, user4));
    }

    public Optional<User> getUser(Integer id) {
        Optional optional = Optional.empty();
        for (User user: userList) {
            if (id == user.getId() ) {
                optional = Optional.of(user);
                return optional;
            }
        }
        return optional;
    }
}
