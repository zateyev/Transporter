package com.epam.transporter.dao;

import com.epam.transporter.entity.Customer;
import com.epam.transporter.sql.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcCustomerDao implements CustomerDao {
    private ConnectionPool connectionPool;
    @Override
    public Customer findById(long id) {
        ResultSet resultSet;
        PreparedStatement preparedStatement;
        Connection connection = connectionPool.getConnection();
        return null;
    }

    @Override
    public void update(Customer customer) {
    }

    @Override
    public Customer save(Customer customer) {
        return null;
    }

    @Override
    public Customer merge(Customer customer) {
        return null;
    }

    @Override
    public Customer insert(Customer customer) {
        return null;
    }

    @Override
    public boolean remove(Customer customer) {
        return false;
    }

    @Override
    public boolean removeById(long id) {
        return false;
    }
}
