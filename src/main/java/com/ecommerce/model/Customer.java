package com.ecommerce.model;

public class Customer {
    private int id;
    private String username;
    private String password;

    // Constructors
    public Customer() {}

    public Customer(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
