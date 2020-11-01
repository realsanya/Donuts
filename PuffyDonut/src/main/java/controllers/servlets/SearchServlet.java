package controllers.servlets;

import models.Product;
import services.interfaces.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductService productService = (ProductService) request.getServletContext().getAttribute("productService");
        List<Product> products = productService.getAllProducts();
        request.setAttribute("products", products);
        getServletContext().getRequestDispatcher("/catalog.ftl").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String select = request.getParameter("select-form");

        ProductService productService = (ProductService) request.getServletContext().getAttribute("productService");

        List<Product> products = new ArrayList<>();

        if (select.equals("priceIncrease")) {
            products = productService.getAllProductsByIncreasePrice();
        } else if (select.equals("priceDecrease")) {
            products = productService.getAllProductsByDecreasePrice();
        } else if (select.equals("weightIncrease")) {
            products = productService.getAllProductsByIncreaseWeight();
        } else if (select.equals("weightDecrease")) {
            products = productService.getAllProductsByDecreaseWeight();
        }

        request.setAttribute("products", products);
        request.getRequestDispatcher("/catalog.ftl").forward(request, response);
    }
}
