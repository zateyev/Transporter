package com.epam.transporter.entity;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerManager {
    public Customer findCustomerByEmail(String email) {
        Customer customer = new Customer();
        customer.setEmail(email);
        try {
            /*adding properties to HikariCP using property-file hikari.properties
            Properties properties = new Properties();
            InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream("db/hikari.properties");
            try {
                properties.load(resourceAsStream);
            } catch (IOException e) {
                e.printStackTrace();
            }*/
            HikariConfig hikariConfig = new HikariConfig();
            hikariConfig.setJdbcUrl("jdbc:h2:tcp://localhost/~/transporter");
            hikariConfig.setUsername("transporter");
            hikariConfig.setPassword("transporter");
            HikariDataSource dataSource = new HikariDataSource(hikariConfig);
            Connection connection = dataSource.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM CUSTOMER WHERE EMAIL = ?");
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String password = resultSet.getString("PASSWORD");
                String firstName = resultSet.getString("FIRSTNAME");
                customer.setPassword(password);
                customer.setFirstName(firstName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }
}