package controllers.servlets;

import utils.DeleteCookie;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        DeleteCookie.delete(req, resp, "email", "password");

        req.getSession().setAttribute("user", null);
        req.getSession().setAttribute("order", null);

        resp.sendRedirect("/main");
    }
}
