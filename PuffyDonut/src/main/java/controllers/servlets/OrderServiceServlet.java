package controllers.servlets;

import models.Order;
import models.User;
import services.interfaces.OrderService;
import services.interfaces.ProductService;
import services.interfaces.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

@WebServlet("/orderService")
public class OrderServiceServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductService productService = (ProductService) request.getServletContext().getAttribute("productService");
        OrderService orderService = (OrderService) request.getServletContext().getAttribute("orderService");

        Order order = (Order) request.getSession().getAttribute("order");

        String add = request.getParameter("add");
        String delete = request.getParameter("delete");
        try {
            if (add != null) {
                addProduct(orderService, order, productService, Integer.parseInt(add));
                response.sendRedirect("/catalog");
            } else if (delete != null) {
                deleteProduct(orderService, order, productService, Integer.parseInt(delete));
                response.sendRedirect("/basket");
            }
        } catch (NumberFormatException ignored) {
        }
        if (add == null && delete == null) {
            response.sendRedirect("/main");
        }
    }

    private void addProduct(OrderService orderService, Order order, ProductService productService, Integer id) {
        orderService.addProductInOrder(order, productService.getProductById(id));
    }

    private void deleteProduct(OrderService orderService, Order order, ProductService productService, Integer id) {
        orderService.deleteProductFromOrder(order, productService.getProductById(id));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
