package filters;


import com.mysql.cj.xdevapi.JsonArray;
import com.mysql.cj.xdevapi.JsonValue;
import models.Product;
import org.json.simple.JSONArray;
import services.ProductService;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@WebServlet("/catalog")
public class CatalogFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        ProductService productService = (ProductService) httpServletRequest.getServletContext().getAttribute("productService");
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
