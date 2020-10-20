package listeners;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import models.Product;
import repositories.*;
import services.*;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

@WebListener
public class ContextListener implements ServletContextListener {

    @SuppressWarnings("DuplicatedCode")
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/db?serverTimezone=UTC");
        hikariConfig.setUsername("root");
        hikariConfig.setDriverClassName("com.mysql.jdbc.Driver");
        hikariConfig.setPassword("realsanya");
        hikariConfig.setMaximumPoolSize(10);

        HikariDataSource dataSource = new HikariDataSource(hikariConfig);
        servletContextEvent.getServletContext().setAttribute("datasource", dataSource);

        UserRepository userRepository = new UserRepositoryJdbc(dataSource);
        UserService userService = new UserServiceImpl(userRepository);
        servletContextEvent.getServletContext().setAttribute("userService", userService);

        ProductRepository productRepository = new ProductRepositoryJdbc(dataSource);
        ProductService productService = new ProductServiceImpl(productRepository);
        servletContextEvent.getServletContext().setAttribute("productService", productService);

        ReviewRepository reviewRepository = new ReviewRepositoryJdbc(dataSource, userService);
        ReviewsService reviewsService = new ReviewsServiceImpl(reviewRepository);
        servletContextEvent.getServletContext().setAttribute("reviewsService", reviewsService);

        AuthRepository authRepository = new AuthRepositoryJdbc(dataSource);
        AuthService authService = new AuthServiceImpl(authRepository);
        servletContextEvent.getServletContext().setAttribute("authService", authService);

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        sce.getServletContext().setAttribute("datasource", null);
    }

}
