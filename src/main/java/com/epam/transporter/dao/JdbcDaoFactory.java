package com.epam.transporter.dao;

import com.epam.transporter.sql.ConnectionPool;

import java.sql.Connection;

public class JdbcDaoFactory extends DaoFactory {
    public static final String DRIVER_NAME = "org.h2.Driver";
    public static final String URL = "jdbc:h2:tcp://localhost/~/transporter";
    public static final String USER = "transporter";
    public static final String PASSWORD = "transporter";
    public static final int MAX_CONNECTION = 5;

    @Override
    public CustomerDao getCustomerDao() {
        return new JdbcCustomerDao();
    }

    public static Connection createConnection() {
        ConnectionPool connectionPool = ConnectionPool.getInstance(DRIVER_NAME, URL, USER, PASSWORD, MAX_CONNECTION);
        return connectionPool.getConnection();
    }
}
