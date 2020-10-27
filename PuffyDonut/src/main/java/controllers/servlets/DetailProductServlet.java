package controllers.servlets;

import models.Comment;
import models.Product;
import models.User;
import services.interfaces.CommentService;
import services.interfaces.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet("/detail")
public class DetailProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet");
        String s = request.getParameter("id");

        try {

            Integer id = Integer.parseInt(s);

            //при повторном заходе id = null,  user_id не заносится в бд
            ProductService productService = (ProductService) request.getServletContext().getAttribute("productService");
            CommentService commentService = (CommentService) request.getServletContext().getAttribute("commentService");

            Product product = productService.getProductById(id);
            List<Comment> comments = commentService.getAllCommentsByDonutID(product);

            request.setAttribute("product", product);
            request.setAttribute("comments", comments);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/detail.ftl");
            requestDispatcher.forward(request, response);
        } catch (NumberFormatException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost");
        request.setCharacterEncoding("UTF-8");
        User user = (User) request.getSession().getAttribute("user");

        if (user != null) {
            ProductService productService = (ProductService) request.getServletContext().getAttribute("productService");
            CommentService commentService = (CommentService) request.getServletContext().getAttribute("commentService");
            String input = request.getParameter("comment-input");
            System.out.println(input);

            Integer id = Integer.parseInt(request.getParameter("product_id"));

            Date date = new Date(System.currentTimeMillis());
            Comment comment = Comment.builder()
                    .user_id(user)
                    .product_id(productService.getProductById(id))
                    .date(date)
                    .text(input)
                    .build();
            commentService.addComment(comment);

            response.sendRedirect("/detail?id=" + id);
        } else {
            response.sendRedirect("/login");
        }
    }

}
