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

@WebServlet("/searchByTag")
public class SearchByTagServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductService productService = (ProductService) request.getServletContext().getAttribute("productService");
        List<Product> products = productService.getAllProducts();
        request.setAttribute("products", products);
        getServletContext().getRequestDispatcher("/catalog.ftl").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String tag = request.getParameter("select-tag");
        ProductService productService = (ProductService) request.getServletContext().getAttribute("productService");

        List<Product> products = new ArrayList<>();

        if (tag.equals("chocolateTag")) {
            products = productService.getAllProductsByTag("шоколад");
        } else if (tag.equals("nutsTag")) {
            products = productService.getAllProductsByTag("орехи");
        } else if (tag.equals("berriesTag")) {
            products = productService.getAllProductsByTag("ягоды");
        } else if (tag.equals("cocosTag")) {
            products = productService.getAllProductsByTag("кокос");
        } else if (tag.equals("vanillaTag")) {
            products = productService.getAllProductsByTag("ваниль");
        }
        System.out.println(products.isEmpty());
        request.setAttribute("products", products);
        request.getRequestDispatcher("/catalog.ftl").forward(request, response);
    }
}
