package com.MikeRosends.springapi.service;

import com.MikeRosends.springapi.model.Expense;
import com.MikeRosends.springapi.model.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    private List<User> userList;
    private List<Expense> expensesList;

    public UserService() {
        userList = new ArrayList<>();
        expensesList = new ArrayList<>();

        Expense expense1 = new Expense(1, "BJJ", 43);
        Expense expense2 = new Expense(2, "Food", 50);
        Expense expense3 = new Expense(3, "Code4All Contract", 143);


        expensesList.addAll(Arrays.asList(expense1, expense2, expense3));

        User user1 = new User(1, expensesList);
        User user2 = new User(2, expensesList);

        userList.addAll(Arrays.asList(user1, user2));
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
