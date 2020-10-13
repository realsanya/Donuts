package servlets;

import models.Review;
import repositories.ReviewRepositoryJdbc;
import services.ReviewsService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProfileServlet extends HttpServlet {
    private ReviewsService reviewsService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO: findAllByID
//        List<Review> reviewList = reviewRepositoryJdbc.findAllByUserID(4);
//        for (Review r : reviewList) {
//            System.out.println(r.getText());
//        }
       // request.setAttribute("reviewList", reviewList);
        RequestDispatcher requestDispatcher = request.getServletContext().getRequestDispatcher("views/profile.jsp");
        requestDispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("profile.ftl").forward(request, response);
    }
}
