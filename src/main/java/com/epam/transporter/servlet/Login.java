package com.epam.transporter.servlet;

import com.epam.transporter.dao.UserDao;
import com.epam.transporter.dao.DaoFactory;
import com.epam.transporter.dao.OrderDao;
import com.epam.transporter.dao.TruckDao;
import com.epam.transporter.entity.User;
import com.epam.transporter.entity.Order;
import com.epam.transporter.entity.Truck;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class Login extends MainServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        DaoFactory jdbcDaoFactory = DaoFactory.getDaoFactory(DaoFactory.JDBC);
        UserDao jdbcUserDao = jdbcDaoFactory.getUserDao();
        User user = jdbcUserDao.findByEmail(email);
        if (user.getPassword().equals(password)) {
            user.setLogged(true);
            HttpSession session = request.getSession(true);
            session.setAttribute("user", user);
            OrderDao jdbcOrderDao = jdbcDaoFactory.getOrderDao();
            List<Order> orderList = jdbcOrderDao.getOrderList();
            if (user.getRole().equals(User.Role.ADMIN)) {
                session.setAttribute("orderList", orderList);
                TruckDao jdbcTruckDao = jdbcDaoFactory.getTruckDao();
                List<Truck> trucksList = jdbcTruckDao.getTrucksList();
                session.setAttribute("trucksList", trucksList);
                response.sendRedirect(request.getContextPath() + "/admin.jsp");
            } else {
                List<Order> customerOrders = user.getOrderListFrom(orderList);
                session.setAttribute("customerOrders", customerOrders);
                response.sendRedirect(request.getContextPath() + "/welcome.jsp");
            }
        } else {
            user.setLogged(false);
            request.setAttribute("user", user);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
        }
    }
}
