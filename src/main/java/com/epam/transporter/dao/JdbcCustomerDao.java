package com.epam.transporter.dao;

import com.epam.transporter.entity.Customer;
import com.epam.transporter.entity.UserRole;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.epam.transporter.dao.JdbcDaoFactory.*;
import static com.epam.transporter.dao.JdbcDaoFactory.freeConnection;

public class JdbcCustomerDao implements CustomerDao {

    public JdbcCustomerDao() {
    }

    @Override
    public Customer findById(Long id) {
        ResultSet resultSet;
        PreparedStatement preparedStatement;
        Connection connection = createConnection();
        try {
            preparedStatement = connection.prepareStatement("SELECT ID, FIRSTNAME, EMAIL, PASSWORD FROM CUSTOMER WHERE ID = ?");
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            boolean found = resultSet.next();
            if (!found) return null;
            Customer customer = new Customer();
            customer.setId(id);
            customer.setFirstName(resultSet.getString("FIRSTNAME"));
            customer.setEmail(resultSet.getString("EMAIL"));
            customer.setPassword(resultSet.getString("PASSWORD"));
            return customer;
        } catch (SQLException e) {
            throw new DaoException();
        } finally {
            freeConnection(connection);
        }
    }

    @Override
    public Customer findByEmail(String email) {
        ResultSet resultSet;
        PreparedStatement preparedStatement;
        Connection connection = createConnection();
        try {
            preparedStatement = connection.prepareStatement("SELECT ID, FIRSTNAME, EMAIL, PASSWORD, ROLE FROM CUSTOMER WHERE EMAIL = ?");
            preparedStatement.setString(1, email);
            resultSet = preparedStatement.executeQuery();
            boolean found = resultSet.next();
            if (!found) return null;
            Customer customer = new Customer();
            customer.setId(resultSet.getLong("ID"));
            customer.setFirstName(resultSet.getString("FIRSTNAME"));
            customer.setEmail(resultSet.getString("EMAIL"));
            customer.setPassword(resultSet.getString("PASSWORD"));
            customer.setUserRole(UserRole.valueOf(resultSet.getString("ROLE")));
            return customer;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            freeConnection(connection);
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
        Connection connection = createConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO CUSTOMER (ID, FIRSTNAME, EMAIL, PASSWORD) VALUES (DEFAULT, ?, ?, ?)");
            preparedStatement.setString(1, customer.getFirstName());
            preparedStatement.setString(2, customer.getEmail());
            preparedStatement.setString(3, customer.getPassword());
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next();
            long id = generatedKeys.getLong(1);
            customer.setId(id);
        } catch (SQLException e) {
            throw new DaoException(e);
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
