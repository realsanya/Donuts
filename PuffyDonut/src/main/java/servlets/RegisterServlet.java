package servlets;

import models.User;
import repositories.UserRepositoryJdbc;
import utils.HashPassword;

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
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        HashPassword hashPassword = new HashPassword();
        password = HashPassword.getHash(password);

        User user = User.builder()
                .first_name(first_name)
                .last_name(last_name)
                .address(address)
                .email(email)
                .password(password)
                .build();

        userRepositoryJdbc.save(user);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("registerdetails.jsp");
        requestDispatcher.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/register.jsp");
        requestDispatcher.forward(request, response);
    }
}
