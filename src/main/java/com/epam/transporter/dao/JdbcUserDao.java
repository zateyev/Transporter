package com.epam.transporter.dao;

import com.epam.transporter.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.epam.transporter.dao.JdbcDaoFactory.*;
import static com.epam.transporter.dao.JdbcDaoFactory.freeConnection;

public class JdbcUserDao implements UserDao {
    public JdbcUserDao() {
    }

    @Override
    public User findById(Long id) {
        ResultSet resultSet;
        PreparedStatement preparedStatement;
        Connection connection = createConnection();
        try {
            preparedStatement = connection.prepareStatement("SELECT ID, FIRSTNAME, EMAIL, PASSWORD, ROLE FROM USER WHERE ID = ?");
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            boolean found = resultSet.next();
            if (!found) return null;
            User user = new User();
            user.setId(id);
            user.setFirstName(resultSet.getString("FIRSTNAME"));
            user.setEmail(resultSet.getString("EMAIL"));
            user.setPassword(resultSet.getString("PASSWORD"));
            user.setRole(User.Role.valueOf(resultSet.getString("ROLE")));
            return user;
        } catch (SQLException e) {
            throw new DaoException();
        } finally {
            freeConnection(connection);
        }
    }

    @Override
    public User findByEmail(String email) {
        ResultSet resultSet;
        PreparedStatement preparedStatement;
        Connection connection = createConnection();
        try {
            preparedStatement = connection.prepareStatement("SELECT ID, FIRSTNAME, EMAIL, PASSWORD, ROLE FROM USER WHERE EMAIL = ?");
            preparedStatement.setString(1, email);
            resultSet = preparedStatement.executeQuery();
            boolean found = resultSet.next();
            if (!found) return null;
            User user = new User();
            user.setId(resultSet.getLong("ID"));
            user.setFirstName(resultSet.getString("FIRSTNAME"));
            user.setEmail(resultSet.getString("EMAIL"));
            user.setPassword(resultSet.getString("PASSWORD"));
            user.setRole(User.Role.valueOf(resultSet.getString("ROLE")));
            return user;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            freeConnection(connection);
        }
    }

    @Override
    public void update(User user) {
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public User merge(User user) {
        return null;
    }

    @Override
    public User insert(User user) {
        Connection connection = createConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO USER (ID, FIRSTNAME, EMAIL, PASSWORD, ROLE) VALUES (DEFAULT, ?, ?, ?, ?)");
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, String.valueOf(user.getRole()));
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next();
            long id = generatedKeys.getLong(1);
            user.setId(id);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return user;
    }

    @Override
    public boolean remove(User user) {
        return false;
    }

    @Override
    public boolean removeById(long id) {
        return false;
    }
}
