package com.epam.transporter.entity;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    private boolean logged = false;

    public String getPassword() {
        return super.getPassword();
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }

    @Override
    public void setEmail(String email) {
        super.setEmail(email);
    }

    @Override
    public void setPassword(String password) {
        super.setPassword(password);
    }

    public boolean isRegistered() {
        return logged;
    }

    public List<Order> getOrderListFrom(List<Order> orderList) {
        List<Order> customerOrders = new ArrayList<>();
        for (Order order : orderList) {
            if (order.getCustomer().getId().equals(this.getId())) customerOrders.add(order);
        }
        return customerOrders;
    }
}
