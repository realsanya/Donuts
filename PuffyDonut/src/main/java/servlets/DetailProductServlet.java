package servlets;

import models.Comment;
import models.Product;
import services.CommentService;
import services.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/detail/product")
public class DetailProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String s = request.getParameter("id");
        try {
            Long id = Long.parseLong(s);

            ProductService productService = (ProductService) request.getServletContext().getAttribute("productService");
            CommentService commentService = (CommentService) request.getServletContext().getAttribute("commentService");

            List<Comment> comments = commentService.getAllCommentsByDonutID(productService.getProductById(id));
            Product product = productService.getProductById(id);

            request.setAttribute("product", product);
            request.setAttribute("comments", comments);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/detail.ftl");
            requestDispatcher.forward(request, response);

        } catch (NumberFormatException exp) {
            response.sendRedirect("/404");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}
