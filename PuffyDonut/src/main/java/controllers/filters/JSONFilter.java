package controllers.filters;

import com.google.gson.Gson;
import models.Review;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import services.interfaces.ReviewsService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebFilter("/reviewsJson")
public class JSONFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("filter");

        ReviewsService reviewsService = (ReviewsService) servletRequest.getServletContext().getAttribute("reviewsService");
        List<Review> reviews = reviewsService.getAllReviews();
        String json = new Gson().toJson(reviews);
        servletResponse.setContentType("application/json; charset=UTF-8");
        servletResponse.setCharacterEncoding("UTF-8");
        PrintWriter out = servletResponse.getWriter();
        out.print(json);
    }
}

