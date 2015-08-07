package com.epam.transporter.servlet;

import com.epam.transporter.dao.DaoFactory;
import com.epam.transporter.dao.DeliveryPointsDao;
import com.epam.transporter.entity.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class TruckCollector extends HttpServlet {
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

        List<Truck> truckList = TrucksPark.getSuitableEmptyTrucks(order);

        HttpSession session = request.getSession(false);
        session.setAttribute("truckList", truckList);
        session.setAttribute("order", order);
        Customer customer = (Customer) session.getAttribute("customer");
        if (customer == null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/info.jsp");
            dispatcher.forward(request, response);
        } else {
            if (customer.isRegistered()) {
                response.sendRedirect(request.getContextPath() + "/book.jsp");
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/info.jsp");
                dispatcher.forward(request, response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
