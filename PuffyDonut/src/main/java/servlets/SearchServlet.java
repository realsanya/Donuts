package servlets;

import models.Product;
import services.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //String input = request.getParameter("search-input").toLowerCase();
//        boolean chocolateTag = request.getParameter("chocolateTag") != null;
//        boolean nutsTag = request.getParameter("nutsTag") != null;
//        boolean berriesTag = request.getParameter("berriesTag") != null;
//        boolean cocosTag = request.getParameter("cocosTag") != null;
//        boolean vanillaTag = request.getParameter("vanillaTag") != null;

        ProductService productService = (ProductService) request.getServletContext().getAttribute("productService");
        List<Product> products = productService.getAllProducts();
        request.setAttribute("products", products);
        getServletContext().getRequestDispatcher("/catalog.ftl").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String select = request.getParameter("select-form");
        System.out.println(select);

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
