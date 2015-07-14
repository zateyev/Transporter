package com.epam.transporter.dao;

import com.epam.transporter.entity.Customer;
import com.epam.transporter.sql.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcCustomerDao implements CustomerDao {

    public JdbcCustomerDao() {
    }

    @Override
    public Customer findById(long id) {
        ResultSet resultSet;
        PreparedStatement preparedStatement;
        Connection connection = JdbcDaoFactory.createConnection();
        try {
            preparedStatement = connection.prepareStatement("SELECT ID, FIRSTNAME, EMAIL, PASSWORD FROM CUSTOMER WHERE ID = ?");
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            boolean found = resultSet.next();
            if (!found) return null;
            Customer customer = new Customer();
            customer.setFirstName(resultSet.getString("FIRSTNAME"));
            customer.setEmail(resultSet.getString("EMAIL"));
            customer.setPassword(resultSet.getString("PASSWORD"));
            return customer;
        } catch (SQLException e) {
            throw new DaoException();
        } finally {
            //TODO up to the end
        }
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
        Connection connection = JdbcDaoFactory.createConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO CUSTOMER (ID, FIRSTNAME, EMAIL, PASSWORD) VALUES (DEFAULT, ?, ?, ?)");
            preparedStatement.setString(1, customer.getFirstName());
            preparedStatement.setString(2, customer.getEmail());
            preparedStatement.setString(3, customer.getPassword());
            preparedStatement.executeQuery();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next();
            long id = generatedKeys.getLong(1);
            customer.setId(id);
        } catch (SQLException e) {
            throw new DaoException();
        }
        return customer;
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
