package com.epam.transporter.servlet;

import com.epam.transporter.dao.DaoFactory;
import com.epam.transporter.dao.OrderDao;
import com.epam.transporter.entity.User;
import com.epam.transporter.entity.Order;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class OrderStatusChanger extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");
        String orders;
        String jspPage;
        if (user.getRole().equals(User.Role.ADMIN)) {
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
                order.setStatus(Order.Status.valueOf(status));
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
