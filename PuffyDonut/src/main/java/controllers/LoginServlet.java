package controllers;

import models.entities.User;
import models.repositories.UserRepositoryJdbc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LoginServlet extends HttpServlet {
    UserRepositoryJdbc userRepositoryJdbc = new UserRepositoryJdbc();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");//TODO


        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }

        byte[] bytes = messageDigest.digest(password.getBytes());
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append(b);
        }


        User user = new User();
        user.setEmail(email);
        user.setPassword(builder.toString());

        String userValidate = userRepositoryJdbc.authenticateUser(user);

        Cookie cookieEmail = new Cookie("cookieEmail", email);
        Cookie cookiePassword = new Cookie("cookiePassword", password);
        Cookie cookieRemember = new Cookie("cookieRemember", remember);
        response.addCookie(cookieEmail);
        response.addCookie(cookiePassword);
        response.addCookie(cookieRemember);

        if (userValidate.equals("SUCCESS")) {
            request.setAttribute("email", email);
            request.getRequestDispatcher("views/register.jsp").forward(request, response);
        } else {
            request.setAttribute("errMessage", userValidate);
            request.getRequestDispatcher("views/login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/login.jsp");
        requestDispatcher.forward(request, response);

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("email", email);
        httpSession.setAttribute("password", password);
    }
}
