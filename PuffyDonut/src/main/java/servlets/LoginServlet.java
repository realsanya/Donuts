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
        String remember = request.getParameter("remember");

        password = HashPassword.getHash(password);

        User user = User.builder().email(email).password(password).build();
        userService.addUser(user);

        Cookie cookieEmail = new Cookie("cookieEmail", email);
        Cookie cookiePassword = new Cookie("cookiePassword", password);
        Cookie cookieRemember = new Cookie("cookieRemember", remember);
        response.addCookie(cookieEmail);
        response.addCookie(cookiePassword);
        response.addCookie(cookieRemember);

//        if (userValidate.equals("SUCCESS")) {
//            request.setAttribute("email", email);
//            request.getRequestDispatcher("views/profile.jsp").forward(request, response);
//        } else {
//            request.setAttribute("errMessage", userValidate);
//            request.getRequestDispatcher("views/login.jsp").forward(request, response);
//        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.ftl").forward(request, response);

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("email", email);
        httpSession.setAttribute("password", password);
    }
}
