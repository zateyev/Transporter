package com.epam.transporter.servlet;

import com.epam.transporter.dao.DaoFactory;
import com.epam.transporter.dao.OrderDao;
import com.epam.transporter.entity.Customer;
import com.epam.transporter.entity.Order;
import com.epam.transporter.entity.Truck;
import com.epam.transporter.logic.TruckReservation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Book extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        Order order = (Order) session.getAttribute("order");
        Customer customer = (Customer) session.getAttribute("customer");
        order.setCustomer(customer);
        Truck truck = order.getSuitableTruck();
        if (truck.isEmpty()) {
            DaoFactory jdbcDaoFactory = DaoFactory.getDaoFactory(DaoFactory.JDBC);
            OrderDao jdbcOrderDao = jdbcDaoFactory.getOrderDao();
            jdbcOrderDao.insert(order);
            TruckReservation.reserveTruck(truck);
            session.setAttribute("truck", truck);
            response.sendRedirect(request.getContextPath() + "/order-confirmation.jsp");
        }
        else {
            response.sendRedirect(request.getContextPath() + "/all-busy.jsp");
        }
        /*RequestDispatcher dispatcher = request.getRequestDispatcher("/order-confirmation.jsp");
        dispatcher.forward(request, response);*/
    }
}
