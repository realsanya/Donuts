package listeners;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
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
//        Properties properties = new Properties();
//        try {
//            properties.load(new FileReader("/WEB-INF/properties/db.properties"));
//        } catch (IOException e) {
//            throw new IllegalStateException(e);
//        }
//
//        HikariConfig hikariConfig = new HikariConfig();
//        hikariConfig.setJdbcUrl(properties.getProperty("db.url"));
//        hikariConfig.setDriverClassName(properties.getProperty("db.driver.classname"));
//        hikariConfig.setUsername(properties.getProperty("db.username"));
//        hikariConfig.setPassword(properties.getProperty("db.password"));
//        hikariConfig.setMaximumPoolSize(Integer.parseInt(properties.getProperty("db.hikari.max - pool")));

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

        DonutRepository donutRepository = new DonutRepositoryJdbc(dataSource);
        DonutService donutService = new DonutServiceImpl(donutRepository);
        servletContextEvent.getServletContext().setAttribute("donutService", donutService);

        ReviewRepository reviewRepository = new ReviewRepositoryJdbc(dataSource);
        ReviewsService reviewsService = new ReviewsServiceImpl(reviewRepository);
        servletContextEvent.getServletContext().setAttribute("reviewsService", reviewsService);

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        sce.getServletContext().setAttribute("datasource", null);
    }

}
