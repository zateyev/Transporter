package com.epam.transporter.servlet;

import com.epam.transporter.dao.DaoFactory;
import com.epam.transporter.dao.OrderDao;
import com.epam.transporter.dao.TruckDao;
import com.epam.transporter.entity.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class TruckStatusChanger extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        List<Truck> trucksList = (List<Truck>) session.getAttribute("trucksList");
        for (Truck truck : trucksList) {
            String status = request.getParameter("status" + truck.getId());
            if (!status.equals(truck.getStatus())) {
                truck.setStatus(TruckStatus.valueOf(status));
                DaoFactory jdbcDaoFactory = DaoFactory.getDaoFactory(DaoFactory.JDBC);
                TruckDao jdbcTruckDao = jdbcDaoFactory.getTruckDao();
                jdbcTruckDao.update(truck);
            }
        }
        session.setAttribute("trucksList", trucksList);
        response.sendRedirect(request.getContextPath() + "/admin.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
