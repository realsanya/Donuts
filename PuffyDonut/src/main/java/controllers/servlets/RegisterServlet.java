package controllers.servlets;

import javafx.scene.image.Image;
import models.User;
import services.interfaces.ImageService;
import services.interfaces.UserService;
import utils.HashPassword;
import utils.Validator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        UserService userService = (UserService) request.getServletContext().getAttribute("userService");
        ImageService imageService = (ImageService) request.getServletContext().getAttribute("imageService");

        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String password_again = request.getParameter("password_again");
        System.out.println(first_name + " " + last_name + " " + address + " " + email + " " + password + " " + password_again);

        if (Validator.validRegisterData(first_name, last_name, address, email, password, password_again)) {
            System.out.println("valid");
            password = HashPassword.getHash(password);

            if (userService.userIsExist(email)) {
                response.sendRedirect("/login");
            } else {
                User user = User.builder()
                        .first_name(first_name)
                        .last_name(last_name)
                        .address(address)
                        .email(email)
                        .password(password)
                        .image(imageService.getById(2))
                        .build();
                userService.addUser(user);

                request.getSession().setAttribute("user", userService.getUser(user.getEmail()));
                response.sendRedirect("/main");
            }
        } else {
            response.sendRedirect("/register");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("register.ftl").forward(request, response);
    }
}
