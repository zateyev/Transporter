package com.epam.transporter.servlet;

import com.epam.transporter.dao.DaoFactory;
import com.epam.transporter.dao.OrderDao;
import com.epam.transporter.entity.Customer;
import com.epam.transporter.entity.Order;
import com.epam.transporter.entity.OrderStatus;
import com.epam.transporter.entity.UserRole;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ChangingOrderStatus extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        Customer customer = (Customer) session.getAttribute("customer");
        String orders;
        String jspPage;
        if (customer.getUserRole().equals(UserRole.ADMIN)) {
            orders = "orderList";
            jspPage = "/admin.jsp";
        } else {
            orders = "customerOrders";
            jspPage = "/my-orders.jsp";
        }
        List<Order> orderList = (List<Order>) session.getAttribute(orders);
        for (Order order : orderList) {
            String status = request.getParameter("status" + order.getId());
            if (!status.equals(order.getStatus())) {
                order.setStatus(OrderStatus.valueOf(status));
                DaoFactory jdbcDaoFactory = DaoFactory.getDaoFactory(DaoFactory.JDBC);
                OrderDao jdbcOrderDao = jdbcDaoFactory.getOrderDao();
                jdbcOrderDao.update(order);
            }
        }
        session.setAttribute(orders, orderList);
        response.sendRedirect(request.getContextPath() + jspPage);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
