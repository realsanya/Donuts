package controllers.servlets;

import services.interfaces.ProductService;
import services.interfaces.ReviewsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ProductService productService = (ProductService) request.getServletContext().getAttribute("productService");
        request.setAttribute("products", productService.getAllProducts());

        ReviewsService reviewsService = (ReviewsService) request.getServletContext().getAttribute("reviewsService");
        request.setAttribute("reviews", reviewsService.getAllReviews());

        request.getRequestDispatcher("/main.ftl").forward(request, response);
    }
}

