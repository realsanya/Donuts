package controllers.listeners;

import repositories.*;
import repositories.interfaces.*;
import services.*;
import services.interfaces.*;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;
import java.util.Properties;

@WebListener
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        Properties properties = new Properties();
        try {
            properties.load(servletContextEvent.getServletContext().getResourceAsStream("/WEB-INF/properties/db.properties"));
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }

        SimpleDataSourceConfig simpleConfig = new SimpleDataSourceConfig();

        simpleConfig.setUrl(properties.getProperty("db.url"));
        simpleConfig.setDriver(properties.getProperty("db.driver"));
        simpleConfig.setUsername(properties.getProperty("db.username"));
        simpleConfig.setPassword(properties.getProperty("db.password"));

        SimpleDataSource dataSource = new SimpleDataSource(simpleConfig);

        servletContextEvent.getServletContext().setAttribute("datasource", dataSource);


        ImageRepository imageRepository = new ImageRepositoryJdbc(dataSource);
        ImageService imageService = new ImageServiceImpl(imageRepository);
        servletContextEvent.getServletContext().setAttribute("imageService", imageService);

        UserRepository userRepository = new UserRepositoryJdbc(dataSource, imageService);
        UserService userService = new UserServiceImpl(userRepository);
        servletContextEvent.getServletContext().setAttribute("userService", userService);

        ProductRepository productRepository = new ProductRepositoryJdbc(dataSource);
        ProductService productService = new ProductServiceImpl(productRepository);
        servletContextEvent.getServletContext().setAttribute("productService", productService);

        ReviewRepository reviewRepository = new ReviewRepositoryJdbc(dataSource, userService);
        ReviewsService reviewsService = new ReviewsServiceImpl(reviewRepository);
        servletContextEvent.getServletContext().setAttribute("reviewsService", reviewsService);

        CommentRepository commentRepository = new CommentRepositoryJdbc(dataSource, userService, productService);
        CommentService commentService = new CommentServiceImpl(commentRepository);
        servletContextEvent.getServletContext().setAttribute("commentService", commentService);

        OrderRepository orderRepository = new OrderRepositoryJdbc(dataSource, userService, productService);
        OrderService orderService = new OrderServiceImpl(orderRepository);
        servletContextEvent.getServletContext().setAttribute("orderService", orderService);


    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        sce.getServletContext().setAttribute("datasource", null);
    }

}
