package servlets;

import services.ProductService;
import services.ReviewsService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;


public class MainServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DataSource dataSource = (DataSource) request.getServletContext().getAttribute("datasource");

        ProductService productService = (ProductService) request.getServletContext().getAttribute("productService");
        request.setAttribute("products", productService.getAllProducts());

        ReviewsService reviewsService = (ReviewsService) request.getServletContext().getAttribute("reviewsService");
        request.setAttribute("reviews", reviewsService.getAllReviews());

        request.getRequestDispatcher("/main.ftl").forward(request, response);
    }
}
