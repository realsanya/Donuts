package controllers.servlets;

import models.*;
import services.interfaces.CommentService;
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
import java.util.List;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        CommentService commentService = (CommentService) request.getServletContext().getAttribute("commentService");

        List<Comment> comments = commentService.getAllCommentsByUserID(user);
        if (commentService.getAllCommentsByUserID(user) != null)
            request.setAttribute("comments", comments);

        request.getRequestDispatcher("/profile.ftl").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
