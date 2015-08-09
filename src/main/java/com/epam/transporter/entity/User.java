package com.epam.transporter.entity;

import java.util.ArrayList;
import java.util.List;

public class User extends BaseEntity {
    private String firstName;
    private String email;
    private String login;
    private String password;
    private Role role;
    private boolean logged = false;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRegistered() {
        return logged;
    }

    public List<Order> getOrderListFrom(List<Order> orderList) {
        List<Order> customerOrders = new ArrayList<>();
        for (Order order : orderList) {
            if (order.getUser().getId().equals(this.getId())) customerOrders.add(order);
        }
        return customerOrders;
    }

    public enum Role {
        ADMIN, CUSTOMER, MODERATOR
    }
}
