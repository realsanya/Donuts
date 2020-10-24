package controllers.servlets;

import services.interfaces.AuthService;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.UUID;

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        boolean find = true;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("cookie")) {
                    find = false;
                }
            }
        }

        if (find) {
            AuthService authService = (AuthService) request.getServletContext().getAttribute("authService");

            Cookie cookie = new Cookie("cookie", UUID.randomUUID().toString());
            cookie.setMaxAge(60 * 60 * 24 * 365);
            authService.addCookie(cookie);
            response.addCookie(cookie);
        } else {
            response.sendRedirect("/profile");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login.ftl").forward(request, response);
    }
}
