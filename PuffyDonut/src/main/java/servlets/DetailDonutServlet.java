package servlets;

import models.Product;
import services.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/detail")
public class DetailDonutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String s = request.getParameter("id");
        try {
            Long id = Long.parseLong(s);
            ProductService productService = (ProductService) request.getServletContext().getAttribute("productService");

            Product product = productService.getProductById(id);

            request.setAttribute("product", product);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/detail.ftl");
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
