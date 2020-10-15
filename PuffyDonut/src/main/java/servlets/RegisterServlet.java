package servlets;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import models.User;
import repositories.UserRepository;
import repositories.UserRepositoryJdbc;
import services.UserService;
import services.UserServiceImpl;
import utils.HashPassword;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;


public class  RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = (UserService) request.getServletContext().getAttribute("userService");

        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String password_again = request.getParameter("password_again");

        if (password.equals(password_again) && !userService.userIsExist(email)) {
            password = HashPassword.getHash(password);

            User user = User.builder()
                    .first_name(first_name)
                    .last_name(last_name)
                    .address(address)
                    .email(email)
                    .password(password)
                    .build();
            System.out.println(user.getLast_name());
            userService.addUser(user);

            request.getSession().setAttribute("email", email);
            request.getSession().setAttribute("password", password);
           // response.sendRedirect("/profile");

        } else {
           // response.sendRedirect("/register");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/register.ftl").forward(request, response);
    }
}
