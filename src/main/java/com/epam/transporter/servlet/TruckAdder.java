package com.epam.transporter.servlet;

import com.epam.transporter.dao.DaoFactory;
import com.epam.transporter.dao.TruckDao;
import com.epam.transporter.entity.Truck;
import com.epam.transporter.entity.TruckStatus;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class TruckAdder extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String model = request.getParameter("model");
        String capacityByWeight = request.getParameter("capacityByWeight");
        String capacityByVolume = request.getParameter("capacityByVolume");
        String pricePerKm = request.getParameter("pricePerKm");
        String status = request.getParameter("status");
        DaoFactory jdbcDaoFactory = DaoFactory.getDaoFactory(DaoFactory.JDBC);
        TruckDao jdbcTruckDao = jdbcDaoFactory.getTruckDao();
        Truck truck = jdbcTruckDao.insert(
                new Truck(model, Integer.valueOf(capacityByWeight), Integer.valueOf(capacityByVolume), Integer.valueOf(pricePerKm), TruckStatus.valueOf(status)));
        HttpSession session = request.getSession(false);
        List<Truck> trucksList = (List<Truck>) session.getAttribute("trucksList");
        trucksList.add(truck);
        session.setAttribute("trucksList", trucksList);
        response.sendRedirect(request.getContextPath() + "/edit-trucks-list.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
