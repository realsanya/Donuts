package servlets;

import models.Donut;
import services.DonutService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/detail")
public class DetailDonutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String s = request.getParameter("id");
        try {
            Long donutId = Long.parseLong(s);
            DonutService donutService = (DonutService) request.getServletContext().getAttribute("donutService");

            Optional<Donut> donut = donutService.getDonutById(donutId);

            request.setAttribute("donut", donut);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/details/musicpage.ftl");
            requestDispatcher.forward(request, response);


        } catch (NumberFormatException exp) {
            response.sendRedirect("/404");
        }
    }

//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doGet(request, response);
//    }
}
