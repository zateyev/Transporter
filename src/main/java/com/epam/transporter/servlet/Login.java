package com.epam.transporter.servlet;

import com.epam.transporter.entity.Customer;
import com.epam.transporter.entity.CustomerManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Login extends MainServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Customer customer = new CustomerManager().findCustomerByEmail(email);
        if (customer.getPassword().equals(password)) {
            customer.setLogged(true);

            request.setAttribute("customer", customer);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/welcome.jsp");
            dispatcher.forward(request, response);

            /*request.getSession().setAttribute("customer", customer);
            response.sendRedirect(request.getContextPath() + "/welcome.jsp");*/

        }
        else {
            customer.setLogged(false);

            request.setAttribute("customer", customer);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);

            /*request.getSession().setAttribute("user", customer);
            response.sendRedirect("/login.jsp");*/
        }
    }
}
