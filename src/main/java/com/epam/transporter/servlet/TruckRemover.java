package com.epam.transporter.servlet;

import com.epam.transporter.dao.DaoFactory;
import com.epam.transporter.dao.TruckDao;
import com.epam.transporter.entity.Truck;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class TruckRemover extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String truckId = request.getParameter("truckId");
        DaoFactory jdbcDaoFactory = DaoFactory.getDaoFactory(DaoFactory.JDBC);
        TruckDao jdbcTruckDao = jdbcDaoFactory.getTruckDao();
        jdbcTruckDao.removeById(Long.valueOf(truckId));
        List<Truck> trucksList = jdbcTruckDao.getTrucksList();
        HttpSession session = request.getSession(false);
        session.setAttribute("trucksList", trucksList);
        response.sendRedirect(request.getContextPath() + "/edit-trucks-list.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
