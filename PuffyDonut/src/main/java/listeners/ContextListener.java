package listeners;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import repositories.DonutRepository;
import repositories.DonutRepositoryJdbc;
import repositories.UserRepository;
import repositories.UserRepositoryJdbc;
import services.DonutService;
import services.DonutServiceImpl;
import services.UserService;
import services.UserServiceImpl;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ContextListener implements ServletContextListener {

    @SuppressWarnings("DuplicatedCode")
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
//        Properties properties = new Properties();
//        try {
//            properties.load(new FileReader("resources/db.properties"));
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
        hikariConfig.setDriverClassName("mysql");
        hikariConfig.setUsername("root");
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

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        sce.getServletContext().setAttribute("datasource", null);
    }

}
