package com.epam.transporter.dao;

import com.epam.transporter.logic.Order;

public interface OrderDao {
    Order findById(long id);
    Order insert(Order order);
    boolean removeById(long id);
}
