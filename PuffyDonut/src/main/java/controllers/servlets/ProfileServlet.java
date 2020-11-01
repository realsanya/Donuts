package controllers.servlets;

import models.*;
import services.interfaces.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");

        ReviewsService reviewsService = (ReviewsService) request.getServletContext().getAttribute("reviewsService");
        List<Review> reviews = reviewsService.getAllReviewsByUserID(user);
        if (reviews != null)
            request.setAttribute("reviews", reviews);

        System.out.println(reviews);
        request.getRequestDispatcher("/profile.ftl").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/profile.ftl").forward(request, response);
    }
}
