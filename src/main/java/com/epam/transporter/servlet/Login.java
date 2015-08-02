package com.epam.transporter.servlet;

import com.epam.transporter.dao.CustomerDao;
import com.epam.transporter.dao.DaoFactory;
import com.epam.transporter.entity.Customer;
import com.epam.transporter.entity.UserRole;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Login extends MainServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        DaoFactory jdbcDaoFactory = DaoFactory.getDaoFactory(DaoFactory.JDBC);
        CustomerDao jdbcCustomerDao = jdbcDaoFactory.getCustomerDao();
        Customer customer = jdbcCustomerDao.findByEmail(email);

        if (customer.getPassword().equals(password)) {
            customer.setLogged(true);

            HttpSession session = request.getSession(true);
            session.setAttribute("customer", customer);
            if (customer.getUserRole().equals(UserRole.ADMIN)) {
                response.sendRedirect(request.getContextPath() + "/admin.jsp");
            } else {
            response.sendRedirect(request.getContextPath() + "/welcome.jsp");
            }
        }
        else {
            customer.setLogged(false);

            request.setAttribute("customer", customer);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
        }
    }
}
