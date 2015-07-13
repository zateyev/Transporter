package com.epam.transporter.entity;

import java.sql.*;

public class CustomerManager {
    public Customer findCustomerByEmail(String email) {
        Customer customer = new Customer();
        customer.setEmail(email);
        try {
            Class.forName("org.h2.Driver");
            String url = "jdbc:h2:tcp://localhost/~/transporter";
            Connection connection = DriverManager.getConnection(url, "transporter", "transporter");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM CUSTOMER WHERE email = ?");
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String password = resultSet.getString("PASSWORD");
                String firstName = resultSet.getString("FIRSTNAME");
                customer.setPassword(password);
                customer.setFirstName(firstName);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }
}