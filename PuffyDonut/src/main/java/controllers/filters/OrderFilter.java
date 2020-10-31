package controllers.filters;

import models.Order;
import models.User;
import services.interfaces.OrderService;
import services.interfaces.UserService;
import utils.DeleteCookie;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebFilter("/catalog")
public class OrderFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        UserService userService = (UserService) request.getServletContext().getAttribute("userService");
        OrderService orderService = (OrderService) request.getServletContext().getAttribute("orderService");

        User user = (User) request.getSession().getAttribute("user");

        if (user != null) {
            filterChain.doFilter(servletRequest, servletResponse);
            setOrder(user, orderService, request);
            return;
        }

        String email = "";
        String password = "";

        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("email")) {
                email = cookie.getValue();
            } else if (cookie.getName().equals("password")) {
                password = cookie.getValue();
            }
        }

        if (!email.equals("") && !password.equals("")) {
            user = userService.getUser(email);
            if (user != null) {
                request.getSession().setAttribute("user", user);
                setOrder(user, orderService, request);
            } else {
                DeleteCookie.delete(request, response, "email", "password");
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    private void setOrder(User user, OrderService orderService, HttpServletRequest request) {
        Order order = orderService.getUserOrder(user);
        if (order == null) {
            order = Order.builder().user_id(user).products_id(new ArrayList<>()).user_id(user).build();
            orderService.createOrder(order);
        }
        request.getSession().setAttribute("order", orderService.getUserOrder(user));
    }
}
