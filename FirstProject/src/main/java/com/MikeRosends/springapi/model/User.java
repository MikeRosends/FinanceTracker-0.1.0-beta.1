package com.MikeRosends.springapi.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {

    private int id;
    private List<Expense> expenses;


    public User(int id, List<Expense> expenses) {
        this.id = id;
        this.expenses = expenses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }
}
