package com.MikeRosends.springapi.service;

import com.MikeRosends.springapi.model.Deposit;
import com.MikeRosends.springapi.model.Expense;
import com.MikeRosends.springapi.model.User;
import com.MikeRosends.springapi.model.WishlistItem;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    private List<User> userList;
    private List<WishlistItem> wishList;
    private List<Expense> expenseList;
    private List<Deposit> deposits;

    public UserService() {
        wishList = new ArrayList<>();
        WishlistItem wishlistItem1 = new WishlistItem(1, "Raising Desk", 200);
        WishlistItem wishlistItem2 = new WishlistItem(2, "New Phone (Specific Model)", 599);
        WishlistItem wishlistItem3 = new WishlistItem(3, "Watter Bottle - tupperware", 40);
        wishList.addAll(Arrays.asList(wishlistItem1, wishlistItem2, wishlistItem3));

        expenseList = new ArrayList<>();
        Expense expense1 = new Expense(1, "BJJ", 43);
        Expense expense2 = new Expense(2, "Food", 50);
        Expense expense3 = new Expense(3, "Code4All Contract", 143);
        Expense expense4 = new Expense(4, "Save - Invest -(20% of salary)", 180);
        expenseList.addAll(Arrays.asList(expense1, expense2, expense3, expense4));


        deposits = new ArrayList<>();
        Deposit deposit1 = new Deposit(1, "Salary", 900);
        Deposit deposit2 = new Deposit(2, "MB-Way", 37);
        deposits.addAll(Arrays.asList(deposit1, deposit2));

        userList = new ArrayList<>();
        User user1 = new User(1, "mike", deposits, expenseList, wishList);
        User user2 = new User(2, "pete", deposits, expenseList ,wishList);
        userList.addAll(Arrays.asList(user1, user2));
    }

    public Optional<User> getUserById(Integer id) {
        Optional<User> optional = Optional.empty();
        for (User user : userList) {
            if (id == user.getId() ) {
                optional = Optional.of(user);
                break;
            }
        }
        return optional;
    }
}
