package servlets;

import models.User;
import services.DonutService;
import services.UserService;
import utils.HashPassword;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CatalogServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DonutService donutService = (DonutService) request.getServletContext().getAttribute("donutService");
        request.setAttribute("donuts", donutService.getAllDonuts());
        request.getRequestDispatcher("/catalog.ftl").forward(request, response);
    }

//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doGet(request, response);
//    }
}
