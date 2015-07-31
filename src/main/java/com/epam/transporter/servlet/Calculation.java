package com.epam.transporter.servlet;

import com.epam.transporter.dao.DaoFactory;
import com.epam.transporter.dao.DeliveryPointsDao;
import com.epam.transporter.entity.DeliveryPoints;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.print.Printable;
import java.io.IOException;
import java.io.PrintWriter;

public class Calculation extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String startingPoint = request.getParameter("startingPoint");
        String destination = request.getParameter("destination");
        String weight = request.getParameter("weight");
        String volume = request.getParameter("volume");
        String cost = request.getParameter("cost");
        String comment = request.getParameter("comment");

        DaoFactory jdbcDaoFactory = DaoFactory.getDaoFactory(DaoFactory.JDBC);
        DeliveryPointsDao jdbcDeliveryPointsDao = jdbcDaoFactory.getDeliveryPointsDao();
        DeliveryPoints deliveryPoints = jdbcDeliveryPointsDao.findByPoints(startingPoint, destination);

        request.setAttribute("deliveryPoints", deliveryPoints);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/info.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
