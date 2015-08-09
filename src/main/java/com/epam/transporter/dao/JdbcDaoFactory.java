package com.epam.transporter.dao;

import com.epam.transporter.sql.ConnectionPool;

import java.sql.Connection;

public class JdbcDaoFactory extends DaoFactory {
    public static final String DRIVER_NAME = "org.h2.Driver";
    public static final String URL = "jdbc:h2:tcp://localhost/~/transporter";
    public static final String USER = "transporter";
    public static final String PASSWORD = "transporter";
    public static final int MAX_CONNECTION = 5;
    private static ConnectionPool connectionPool = ConnectionPool.getInstance(DRIVER_NAME, URL, USER, PASSWORD, MAX_CONNECTION);

    public static Connection createConnection() {
        return connectionPool.getConnection();
    }

    public static void freeConnection(Connection connection) {
        connectionPool.freeConnection(connection);
    }

    @Override
    public UserDao getUserDao() {
        return new JdbcUserDao();
    }

    @Override
    public DeliveryPointsDao getDeliveryPointsDao() {
        return new JdbcDeliveryPointsDao();
    }

    @Override
    public GoodsDao getGoodsDao() {
        return new JdbcGoodsDao();
    }

    @Override
    public OrderDao getOrderDao() {
        return new JdbcOrderDao();
    }

    @Override
    public TruckDao getTruckDao() {
        return new JdbcTruckDao();
    }
}
