package com.epam.transporter.servlet;

import com.epam.transporter.dao.UserDao;
import com.epam.transporter.dao.DaoFactory;
import com.epam.transporter.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Register extends MainServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String firstName = request.getParameter("firstName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = new User();
        user.setFirstName(firstName);
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(User.Role.CUSTOMER);
        DaoFactory jdbcDaoFactory = DaoFactory.getDaoFactory(DaoFactory.JDBC);
        UserDao jdbcUserDao = jdbcDaoFactory.getUserDao();
        jdbcUserDao.insert(user);
        request.setAttribute("user", user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/confirm.jsp");
        dispatcher.forward(request, response);
    }
}
