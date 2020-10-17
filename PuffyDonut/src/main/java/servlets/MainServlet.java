package servlets;

import services.DonutService;
import services.ReviewsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;


public class MainServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DataSource dataSource = (DataSource) request.getServletContext().getAttribute("datasource");

        DonutService donutService = (DonutService) request.getServletContext().getAttribute("donutService");
        request.setAttribute("products", donutService.getAllDonuts());

        ReviewsService reviewsService = (ReviewsService) request.getServletContext().getAttribute("reviewsService");
        request.setAttribute("reviews", reviewsService.getAllReviews());

        request.getRequestDispatcher("/main.ftl").forward(request, response);
    }
}
