package com.epam.transporter.dao;

import com.epam.transporter.entity.Order;

import java.util.List;

public interface OrderDao {
    Order findById(long id);

    Order insert(Order order);

    void update(Order order);

    boolean removeById(long id);

    List<Order> getOrderList();
}
