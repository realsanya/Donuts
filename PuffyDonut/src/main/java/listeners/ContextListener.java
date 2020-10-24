package listeners;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import repositories.*;
import repositories.interfaces.*;
import services.*;
import services.interfaces.*;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

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

        CommentRepository commentRepository = new CommentRepositoryJdbc(dataSource, userService, productService);
        CommentService commentService = new CommentServiceImpl(commentRepository);
        servletContextEvent.getServletContext().setAttribute("commentService", commentService);

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        sce.getServletContext().setAttribute("datasource", null);
    }

}
