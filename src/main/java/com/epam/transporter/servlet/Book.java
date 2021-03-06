package com.epam.transporter.servlet;

import com.epam.transporter.dao.DaoFactory;
import com.epam.transporter.dao.OrderDao;
import com.epam.transporter.entity.User;
import com.epam.transporter.entity.Order;
import com.epam.transporter.entity.Truck;
import com.epam.transporter.entity.TrucksPark;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class Book extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String truckId = request.getParameter("truckId");
        HttpSession session = request.getSession(false);
        Order order = (Order) session.getAttribute("order");
        User user = (User) session.getAttribute("user");
        order.setUser(user);
        DaoFactory jdbcDaoFactory = DaoFactory.getDaoFactory(DaoFactory.JDBC);
        OrderDao jdbcOrderDao = jdbcDaoFactory.getOrderDao();
        jdbcOrderDao.insert(order);
        Truck truck = TrucksPark.reserveTruck(Long.valueOf(truckId));
        List<Order> orderList = jdbcOrderDao.getOrderList();
        List<Order> customerOrders = user.getOrderListFrom(orderList);
        session.setAttribute("customerOrders", customerOrders);
        session.setAttribute("truck", truck);
        response.sendRedirect(request.getContextPath() + "/order-confirmation.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
