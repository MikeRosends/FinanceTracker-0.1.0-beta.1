package com.MikeRosends.springapi.service;

import com.MikeRosends.springapi.model.Deposit;
import com.MikeRosends.springapi.model.Expense;
import com.MikeRosends.springapi.model.User;
import com.MikeRosends.springapi.model.Wishlist;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    private List<User> userList;
    private List<Expense> expensesList;
    private List<Wishlist> wishList;
    private List<Deposit> deposits;

    public UserService() {
        userList = new ArrayList<>();
        expensesList = new ArrayList<>();
        wishList = new ArrayList<>();
        deposits = new ArrayList<>();

        Expense expense1 = new Expense(1, "BJJ", 43);
        Expense expense2 = new Expense(2, "Food", 50);
        Expense expense3 = new Expense(3, "Code4All Contract", 143);
        Expense expense4 = new Expense(3, "Save - Invest (20% of salary)", 180);

        Wishlist item1 = new Wishlist(1, "Raising Desk", 200);
        Wishlist item2 = new Wishlist(2, "New Phone (Specific Model)", 599);
        Wishlist item3 = new Wishlist(3, "Watter Bottle - tupperware", 40);

        Deposit deposit1 = new Deposit(1, "Salary", 900);
        Deposit deposit2 = new Deposit(2, "MB-Way", 37);


        expensesList.addAll(Arrays.asList(expense1, expense2, expense3, expense4));
        wishList.addAll(Arrays.asList(item1, item2, item3));
        deposits.addAll(Arrays.asList(deposit1, deposit2));

        User user1 = new User(1, "mike", deposits, expensesList, wishList);
        User user2 = new User(2, "pete", deposits, expensesList, wishList);

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
