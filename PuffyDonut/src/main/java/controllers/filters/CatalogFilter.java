package controllers.filters;

import models.Product;
import org.json.simple.JSONArray;
import services.interfaces.ProductService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

//TODO
@WebFilter("/catalogs")
public class CatalogFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        ProductService productService = (ProductService) request.getServletContext().getAttribute("productService");
        List<Product> productList = productService.getAllProducts();
        JSONArray products = new JSONArray();
        for (Product product : productList) {
            products.add(product.getName());
        }
        servletResponse.setContentType("application/json");
        servletResponse.setCharacterEncoding("UTF-8");
        servletResponse.getWriter().write(products.toString());
    }
}
