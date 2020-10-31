package controllers.servlets;

import models.Order;
import models.Product;
import services.interfaces.OrderService;
import services.interfaces.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/orderService")
public class OrderServiceServlet extends HttpServlet {

    private Float total_price;
    private int count;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductService productService = (ProductService) request.getServletContext().getAttribute("productService");
        OrderService orderService = (OrderService) request.getServletContext().getAttribute("orderService");

        Order order = (Order) request.getSession().getAttribute("order");
        System.out.println("order" + order);


        String add = request.getParameter("add");
        String delete = request.getParameter("delete");
        System.out.println(add);


        try {
            if (add != null) {
                System.out.println(Integer.parseInt(add));
                addProduct(orderService, order, productService, Integer.parseInt(add));
                response.sendRedirect("/catalog");
            } else if (delete != null) {
                deleteProduct(orderService, order, productService, Integer.parseInt(delete));
                response.sendRedirect("/order");
            }
        } catch (NumberFormatException ignored) {
        }
        if (add == null && delete == null) {
            response.sendRedirect("/main");
        }
    }

    private void addProduct(OrderService orderService, Order order, ProductService productService, Integer id) {
        orderService.addProductInOrder(order, productService.getProductById(id));
//        for (Product p : orderService.getAllProductsInOrder(order)) {
//            total_price += p.getPrice();
//            count++;
//        }
//        order.setTotal_price(total_price);
//        order.setCount(count);
        //System.out.println(order);
    }

    private void deleteProduct(OrderService orderService, Order order, ProductService productService, Integer id) {
        orderService.deleteProductFromOrder(order, productService.getProductById(id));
//        for (Product p : orderService.getAllProductsInOrder(order)) {
//            total_price -= p.getPrice();
//            count--;
//        }
//        order.setTotal_price(total_price);
//        order.setCount(count);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
