package servlets;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import models.User;
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
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/db?serverTimezone=UTC");
        hikariConfig.setDriverClassName("mysql");
        hikariConfig.setUsername("root");
        hikariConfig.setPassword("realsanya");
        hikariConfig.setMaximumPoolSize(10);

        HikariDataSource dataSource = new HikariDataSource(hikariConfig);
        UserRepositoryJdbc userRepositoryJdbc = new UserRepositoryJdbc(dataSource);
        this.userService = new UserServiceImpl(userRepositoryJdbc);

    }

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

        userService.addUser(user);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("registerdetails.jsp");
        requestDispatcher.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/register.jsp");
        requestDispatcher.forward(request, response);
    }
}
