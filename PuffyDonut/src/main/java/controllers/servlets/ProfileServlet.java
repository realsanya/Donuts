package controllers.servlets;

import models.*;
import services.interfaces.CommentService;
import services.interfaces.OrderService;
import services.interfaces.ProductService;
import services.interfaces.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DataSource dataSource = (DataSource) request.getServletContext().getAttribute("datasource");

        ProductService productService = (ProductService) request.getServletContext().getAttribute("productService");
        UserService userService = (UserService) request.getServletContext().getAttribute("userService");
        OrderService orderService = (OrderService) request.getServletContext().getAttribute("orderService");
        CommentService commentService = (CommentService) request.getServletContext().getAttribute("commentService");

        User user = (User) request.getServletContext().getAttribute("user");
//        //TODO
//        List<Comment> comments = commentService.getAllCommentsByUserID(user);

        request.getRequestDispatcher("/profile.ftl").forward(request, response);
    }
}
