package controllers.servlets;

import services.interfaces.ReviewsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/reviews")
public class ReviewsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ReviewsService reviewsService = (ReviewsService) request.getServletContext().getAttribute("reviewsService");
        request.setAttribute("reviews", reviewsService.getAllReviews());

        request.getRequestDispatcher("/reviews.ftl").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
