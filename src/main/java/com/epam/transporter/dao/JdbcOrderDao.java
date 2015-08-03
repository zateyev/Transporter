package com.epam.transporter.dao;

import com.epam.transporter.entity.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.epam.transporter.dao.JdbcDaoFactory.createConnection;
import static com.epam.transporter.dao.JdbcDaoFactory.freeConnection;

public class JdbcOrderDao implements OrderDao {
    @Override
    public Order findById(long id) {
        return null;
    }

    @Override
    public Order insert(Order order) {
        DaoFactory jdbcDaoFactory = DaoFactory.getDaoFactory(DaoFactory.JDBC);
        GoodsDao jdbcGoodsDao = jdbcDaoFactory.getGoodsDao();
        Goods goods = jdbcGoodsDao.insert(order.getGoods());
        order.setGoods(goods);
        DeliveryPointsDao jdbcDeliveryPointsDao = jdbcDaoFactory.getDeliveryPointsDao();
        Long startingPoint = jdbcDeliveryPointsDao.getIdByPoint(order.getDeliveryPoints().getStartingPoint());
        Long destination = jdbcDeliveryPointsDao.getIdByPoint(order.getDeliveryPoints().getDestination());
        Connection connection = createConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO BOOKING (ID, ID_GOOD, ID_POINT1, ID_POINT2, ID_CUSTOMER, STATUS) VALUES (DEFAULT, ?, ?, ?, ?, ?)");
            preparedStatement.setLong(1, goods.getId());
            preparedStatement.setLong(2, startingPoint);
            preparedStatement.setLong(3, destination);
            preparedStatement.setLong(4, order.getCustomer().getId());
            preparedStatement.setString(5, String.valueOf(OrderStatus.NEW));
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next();
            long id = generatedKeys.getLong(1);
            order.setId(id);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return order;
    }

    @Override
    public void update(Order order) {
        Connection connection = createConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(
                    "UPDATE BOOKING SET STATUS = ? WHERE ID = ?");
            preparedStatement.setString(1, String.valueOf(order.getStatus()));
            preparedStatement.setLong(2, order.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public boolean removeById(long id) {
        return false;
    }

    @Override
    public List<Order> getOrderList() {
        ResultSet resultSet;
        PreparedStatement preparedStatement;
        Connection connection = createConnection();
        try {
            preparedStatement = connection.prepareStatement("SELECT ID, ID_GOOD, ID_POINT1, ID_POINT2, ID_CUSTOMER, STATUS FROM BOOKING");
            resultSet = preparedStatement.executeQuery();
            List<Order> orderList = new ArrayList<>();
            DaoFactory jdbcDaoFactory = DaoFactory.getDaoFactory(DaoFactory.JDBC);
            GoodsDao jdbcGoodsDao = jdbcDaoFactory.getGoodsDao();
            DeliveryPointsDao jdbcDeliveryPointsDao = jdbcDaoFactory.getDeliveryPointsDao();
            CustomerDao jdbcCustomerDao = jdbcDaoFactory.getCustomerDao();
            while (resultSet.next()) {
                Long goodsId = resultSet.getLong("ID_GOOD");
                Long startingPointId = resultSet.getLong("ID_POINT1");
                Long destinationId = resultSet.getLong("ID_POINT2");
                Goods goods = jdbcGoodsDao.findById(goodsId);
                DeliveryPoints deliveryPoints = jdbcDeliveryPointsDao.findByPointsId(startingPointId, destinationId);
                Customer customer = jdbcCustomerDao.findById(resultSet.getLong("ID_CUSTOMER"));
                OrderStatus status = OrderStatus.valueOf(resultSet.getString("STATUS"));
                Order order = new Order(deliveryPoints, goods);
                order.setId(resultSet.getLong("ID"));
                order.setCustomer(customer);
                order.setStatus(status);
                orderList.add(order);
            }
            return orderList;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            freeConnection(connection);
        }
    }
}
