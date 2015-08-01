package com.epam.transporter.servlet;

import com.epam.transporter.dao.DaoFactory;
import com.epam.transporter.dao.DeliveryPointsDao;
import com.epam.transporter.entity.Customer;
import com.epam.transporter.entity.DeliveryPoints;
import com.epam.transporter.entity.Goods;
import com.epam.transporter.logic.Order;
import com.epam.transporter.logic.Price;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Calculation extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String startingPoint = request.getParameter("startingPoint");
        String destination = request.getParameter("destination");
        String name = request.getParameter("name");
        String weight = request.getParameter("weight");
        String volume = request.getParameter("volume");
        String cost = request.getParameter("cost");
        String comment = request.getParameter("comment");

        DaoFactory jdbcDaoFactory = DaoFactory.getDaoFactory(DaoFactory.JDBC);
        DeliveryPointsDao jdbcDeliveryPointsDao = jdbcDaoFactory.getDeliveryPointsDao();
        DeliveryPoints deliveryPoints = jdbcDeliveryPointsDao.findByPoints(startingPoint, destination);

        Goods goods = new Goods(name, Integer.valueOf(weight), Integer.valueOf(volume), Integer.valueOf(cost), comment);
        Order order = new Order(deliveryPoints, goods);
        Price price = new Price(order);

        /*request.setAttribute("price", price);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/info.jsp");
        dispatcher.forward(request, response);*/

        HttpSession session = request.getSession(false);
        session.setAttribute("price", price);
        Customer customer = (Customer) session.getAttribute("customer");
        if (customer == null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/info.jsp");
            dispatcher.forward(request, response);
        } else {
            if (customer.isRegistered()) {
                response.sendRedirect(request.getContextPath() + "/book.jsp");
                /*RequestDispatcher dispatcher = request.getRequestDispatcher("/book.jsp");
                dispatcher.forward(request, response);*/
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/info.jsp");
                dispatcher.forward(request, response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
