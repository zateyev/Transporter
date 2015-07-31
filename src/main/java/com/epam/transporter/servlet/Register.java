package com.epam.transporter.servlet;

import com.epam.transporter.dao.CustomerDao;
import com.epam.transporter.dao.DaoFactory;
import com.epam.transporter.entity.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Register extends MainServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setEmail(email);
        customer.setPassword(password);

        DaoFactory jdbcDaoFactory = DaoFactory.getDaoFactory(DaoFactory.JDBC);
        CustomerDao jdbcCustomerDao = jdbcDaoFactory.getCustomerDao();
        jdbcCustomerDao.insert(customer);

        request.setAttribute("customer", customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/confirm.jsp");
        dispatcher.forward(request, response);
    }
}
