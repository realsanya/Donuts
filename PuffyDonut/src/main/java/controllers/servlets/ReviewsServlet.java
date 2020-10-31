package controllers.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.Review;
import services.interfaces.ReviewsService;
import utils.ReviewDto;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import static utils.ReviewDto.from;

@WebServlet("/reviews")
public class ReviewsServlet extends HttpServlet {
    private ReviewsService reviewsService;
    private ObjectMapper objectMapper;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext servletContext = config.getServletContext();
        this.reviewsService = (ReviewsService) servletContext.getAttribute("reviewsService");
        this.objectMapper = (ObjectMapper) servletContext.getAttribute("objectMapper");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        String size = request.getParameter("size");

        System.out.println(page + " " + size);

        List<ReviewDto> reviews = from(reviewsService.getAllReviews(Integer.parseInt(page), Integer.parseInt(size)));

        String resp = objectMapper.writeValueAsString(reviews);
        response.getWriter().write(resp);
        response.setContentType("application/json");

        request.getRequestDispatcher("/reviews.ftl").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Reader reader = request.getReader();
        ReviewDto json = objectMapper.readValue(reader, ReviewDto.class);
        reviewsService.addReview(json);
    }

}
