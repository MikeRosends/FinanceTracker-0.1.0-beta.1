package com.MikeRosends.springapi.controller;

import com.MikeRosends.springapi.model.Deposit;
import com.MikeRosends.springapi.model.Expense;
import com.MikeRosends.springapi.model.User;
import com.MikeRosends.springapi.model.WishlistItem;
import com.MikeRosends.springapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @CrossOrigin(origins = "http://127.0.0.1:8081")
    @GetMapping("/user/{userId}")
    @ResponseBody
    public User getUserById(@PathVariable Integer userId) {
        Optional<User> user = userService.getUserById(userId);
        if (user.isPresent()) {
            return user.get();
        }
        // HANDLE DIFFERENTLY
        return null;
    }

    @CrossOrigin(origins = "http://127.0.0.1:8081")
    @GetMapping("/user/{userId}/expenses")
    @ResponseBody
    public List<Expense> getUserExpensesByUserId(@PathVariable Integer userId) {
        Optional<User> user = userService.getUserById(userId);
        if (user.isPresent()) {
            return user.get().getExpenses();
        }
        return Collections.emptyList();
    }

    @CrossOrigin(origins = "http://127.0.0.1:8081")
    @GetMapping("/user/{userId}/deposits")
    @ResponseBody
    public List<Deposit> getUserDepositsByUserId(@PathVariable Integer userId) {
        Optional<User> user = userService.getUserById(userId);
        if (user.isPresent()) {
            return user.get().getDeposits();
        }
        return Collections.emptyList();
    }

    @CrossOrigin(origins = "http://127.0.0.1:8081")
    @GetMapping("/user/{userId}/wishlist")
    @ResponseBody
    public List<WishlistItem> getUserWishlistByUserId(@PathVariable Integer userId) {
        Optional<User> user = userService.getUserById(userId);
        if (user.isPresent()) {
            return user.get().getWishlist();
        }
        return Collections.emptyList();
    }

    @CrossOrigin(origins = "http://127.0.0.1:8081")
    @PostMapping("/user/{userId}/wishlist")
    @ResponseBody
    public WishlistItem createWishListItem(@PathVariable Integer userId, @RequestBody WishlistItem wishlistItem) {
        Optional<User> user = userService.getUserById(userId);
        if (user.isPresent()) {
            List<WishlistItem> currentWishlist = user.get().getWishlist();
            currentWishlist.add(wishlistItem);
            user.get().setWishlist(currentWishlist);
        }
        return null;
    }

    @CrossOrigin(origins = "http://127.0.0.1:8081")
    @PostMapping("/user/{userId}/deposit")
    @ResponseBody
    public Deposit createDeposit(@PathVariable Integer userId, @RequestBody Deposit deposit) {
        Optional<User> user = userService.getUserById(userId);
        if (user.isPresent()) {
            List<Deposit> currentDepositlist = user.get().getDeposits();
            currentDepositlist.add(deposit);
            user.get().setDeposits(currentDepositlist);
        }
        return null;
    }

    @CrossOrigin(origins = "http://127.0.0.1:8081")
    @PostMapping("/user/{userId}/expense")
    @ResponseBody
    public Deposit createExpense(@PathVariable Integer userId, @RequestBody Expense expense) {
        Optional<User> user = userService.getUserById(userId);
        if  (user.isPresent()) {
            List<Expense> currentExpenselist = user.get().getExpenses();
            currentExpenselist.add(expense);
            user.get().setExpenses(currentExpenselist);
        }
        return null;
    }

}
