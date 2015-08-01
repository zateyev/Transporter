package com.epam.transporter.dao;

import com.epam.transporter.entity.Goods;
import com.epam.transporter.logic.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.epam.transporter.dao.JdbcDaoFactory.createConnection;

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
                    "INSERT INTO BOOKING (ID, ID_GOOD, ID_POINT1, ID_POINT2) VALUES (DEFAULT, ?, ?, ?)");
            preparedStatement.setLong(1, goods.getId());
            preparedStatement.setLong(2, startingPoint);
            preparedStatement.setLong(3, destination);
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
    public boolean removeById(long id) {
        return false;
    }
}
