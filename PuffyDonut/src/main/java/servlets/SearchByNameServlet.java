package servlets;

import models.Product;
import services.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/searchByName")
public class SearchByNameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductService productService = (ProductService) request.getServletContext().getAttribute("productService");
        List<Product> products = productService.getAllProducts();
        request.setAttribute("products", products);
        getServletContext().getRequestDispatcher("/catalog.ftl").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String input = request.getParameter("search-input");
        input = input == null ? "null" : input;
        ProductService productService = (ProductService) request.getServletContext().getAttribute("productService");
        List<Product> products = productService.getProductByName(input);
        request.setAttribute("products", products);
        request.getRequestDispatcher("/catalog.ftl").forward(request, response);
    }
}
