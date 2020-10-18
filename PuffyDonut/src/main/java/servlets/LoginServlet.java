package servlets;

import models.User;
import repositories.UserRepositoryJdbc;
import services.UserService;
import utils.HashPassword;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = (UserService) request.getServletContext().getAttribute("userService");

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        boolean remember = request.getParameter("remember") != null;

        password = HashPassword.getHash(password);

        if (email != null && password != null) {
            User user = userService.getUser(email);

            if (user == null) {
                setError(request, response, "Такого пользователья не существует!");
                return;
            }

            String passwordVerify = user.getPassword();

            if (!password.equals(passwordVerify)) {
                setError(request, response, "Неверный пароль !");
            }
            if (remember) {
                response.addCookie(new Cookie("email", email));
                response.addCookie(new Cookie("password", password));
            }

            request.getSession().setAttribute("user", user);
            response.sendRedirect("/main");
        } else {
            setError(request, response, "Неверные данные!");
        }
    }

    private void setError(HttpServletRequest request, HttpServletResponse response, String message) throws ServletException, IOException {
        request.setAttribute(message, true);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login");
        requestDispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login.ftl").forward(request, response);
    }
}
