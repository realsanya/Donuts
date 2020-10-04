package controllers;

import models.entities.User;
import models.repositories.UserRepositoryJdbc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class RegisterServlet extends HttpServlet {
    private UserRepositoryJdbc userRepositoryJdbc = new UserRepositoryJdbc();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String address = request.getParameter("address");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            byte[] bytes = messageDigest.digest(password.getBytes());
            StringBuilder builder = new StringBuilder();
            for (byte b : bytes) {
                builder.append(b);
            }

            User user = new User();
            user.setFirst_name(first_name);
            user.setLast_name(last_name);
            user.setAddress(address);
            user.setUsername(username);
            user.setPassword(builder.toString());
            user.setEmail(email);

            userRepositoryJdbc.save(user);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("registerdetails.jsp");
        requestDispatcher.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/register.jsp");
        requestDispatcher.forward(request, response);
    }
}
