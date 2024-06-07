package com.MikeRosends.springapi.model;

import java.util.List;

public class User {

    private int id;
    private String name;
    private List<Deposit> deposits;
    private List<Expense> expenses;
    private List<WishlistItem> wishlist;


    public User(int id, String name, List<Deposit> deposits, List<Expense> expenses, List<WishlistItem> wishlist) {
        this.id = id;
        this.name = name;
        this.deposits = deposits;
        this.expenses = expenses;
        this.wishlist = wishlist;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Deposit> getDeposits() {
        return deposits;
    }

    public void setDeposits(List<Deposit> deposits) {
        this.deposits = deposits;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }

    public List<WishlistItem> getWishlist() {
        return wishlist;
    }

    public void setWishlist(List<WishlistItem> wishlist) {
        this.wishlist = wishlist;
    }
}
