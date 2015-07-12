package com.epam.transporter.entity;

import java.sql.*;

public class CustomerManager {
    public Customer findCustomerByEmail(String email) {
        Customer customer = new Customer();
        customer.setEmail(email);
        try {
            Class.forName("org.h2.Driver");
            Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/transporter, transporter, transporter");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM CUSTOMERS WHERE EMAIL = ?");
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            String password = resultSet.getString("PASSWORD");
            customer.setPassword(password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }
}
