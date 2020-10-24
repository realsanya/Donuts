package controllers.servlets;

import models.User;
import services.interfaces.AuthService;
import services.interfaces.UserService;
import utils.HashPassword;
import utils.Validator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = (UserService) request.getServletContext().getAttribute("userService");

        User user;
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        final boolean remember = request.getParameter("remember") != null;

        if (Validator.validLoginData(email, password)) {
            user = userService.getUser(email);

            if (user != null) {
                request.getSession().setAttribute("user", user);

                if (remember) {
                    Cookie emailCookie = new Cookie("email", email);
                    emailCookie.setMaxAge(60 * 60 * 24 * 365);
                    Cookie hashCookie = new Cookie("password", HashPassword.getHash(password));
                    hashCookie.setMaxAge(60 * 60 * 24 * 365);
                    response.addCookie(emailCookie);
                    response.addCookie(hashCookie);
                }
                response.sendRedirect("/profile");
            } else {
                response.sendRedirect("/login");
            }
        } else {
            response.sendRedirect("/login");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login.ftl").forward(request, response);
    }
}
