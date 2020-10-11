package servlets;

import models.User;
import repositories.UserRepositoryJdbc;
import utils.HashPassword;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");

        HashPassword hashPassword = new HashPassword();
        password = HashPassword.getHash(password);

        User user = User.builder().email(email).password(password).build();



//        String userValidate = userRepositoryJdbc.authenticateUser(user);

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
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/login.jsp");
        requestDispatcher.forward(request, response);

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("email", email);
        httpSession.setAttribute("password", password);
    }
}
