package servlets;

import models.Product;
import services.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String input = request.getParameter("search-input").toLowerCase();

        boolean chocolateTag = request.getParameter("chocolateTag") != null;
        boolean nutsTag = request.getParameter("nutsTag") != null;
        boolean berriesTag = request.getParameter("berriesTag") != null;
        boolean cocosTag = request.getParameter("cocosTag") != null;
        boolean vanillaTag = request.getParameter("vanillaTag") != null;

        boolean priceIncrease = request.getParameter("priceIncrease") != null;
        boolean priceDecrease = request.getParameter("priceDecrease") != null;
        boolean weightIncrease = request.getParameter("weightIncrease") != null;
        boolean weightDecrease = request.getParameter("weightDecrease") != null;

        DataSource dataSource = (DataSource) request.getServletContext().getAttribute("datasource");
        ProductService productService = (ProductService) request.getServletContext().getAttribute("productService");

        if (input == null) {
            input = " ";
        }

        List<Product> products = null;

        //TODO исправить поиск по цене и весу в repo
        if (chocolateTag) {
            products = productService.getAllProductsByTag("шоколад");
        } else if (nutsTag) {
            products = productService.getAllProductsByTag("орехи");
        } else if (berriesTag) {
            products = productService.getAllProductsByTag("ягоды");
        } else if (cocosTag) {
            products = productService.getAllProductsByTag("кокос");
        } else if (vanillaTag) {
            products = productService.getAllProductsByTag("ваниль");
        } else if (priceIncrease) {
            //products = productService.getAllDonutsByPrice();
        } else if (priceDecrease) {
            //TODO
        } else if (weightIncrease) {
            //TODO
        } else if (weightDecrease) {
            //TODO
        }

        request.setAttribute("products", products);
        request.getRequestDispatcher("/catalog.ftl").forward(request, response);
    }
}
