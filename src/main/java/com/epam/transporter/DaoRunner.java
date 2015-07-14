package com.epam.transporter;

import com.epam.transporter.dao.CustomerDao;
import com.epam.transporter.dao.DaoFactory;
import com.epam.transporter.entity.Customer;

public class DaoRunner {
    public static void main(String[] args) {
        DaoFactory jdbcDaoFactory = DaoFactory.getDaoFactory(DaoFactory.JDBC);
        CustomerDao customerDao = jdbcDaoFactory.getCustomerDao();
        Customer customer = customerDao.findById(1L);
        customerDao.update(customer);
        customerDao.save(customer);
        customerDao.merge(customer);
        customerDao.insert(customer);
        customerDao.remove(customer);
        customerDao.removeById(1L);
    }
}
