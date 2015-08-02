package com.epam.transporter.dao;

public abstract class DaoFactory {
    public static final int JDBC = 1;

    public static DaoFactory getDaoFactory(int whichFactory) {
        switch (whichFactory) {
            case JDBC:
                return new JdbcDaoFactory();
            default:
                throw new DaoException("required DaoFactory not found");
        }
    }

    public abstract CustomerDao getCustomerDao();

    public abstract DeliveryPointsDao getDeliveryPointsDao();

    public abstract GoodsDao getGoodsDao();

    public abstract OrderDao getOrderDao();

    public abstract TruckDao getTruckDao();
}
