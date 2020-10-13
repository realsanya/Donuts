package listeners;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import repositories.UserRepository;
import repositories.UserRepositoryJdbc;
import services.UserService;
import services.UserServiceImpl;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ContextListener implements ServletContextListener {

    @SuppressWarnings("DuplicatedCode")
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("db.properties"));
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }

        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(properties.getProperty("db.url"));
        hikariConfig.setDriverClassName(properties.getProperty("db.driver.classname"));
        hikariConfig.setUsername(properties.getProperty("db.username"));
        hikariConfig.setPassword(properties.getProperty("db.password"));
        hikariConfig.setMaximumPoolSize(Integer.parseInt(properties.getProperty("db.hikari.max - pool")));

        HikariDataSource dataSource = new HikariDataSource(hikariConfig);
        servletContextEvent.getServletContext().setAttribute("datasource", dataSource);

        UserRepository userRepository = new UserRepositoryJdbc(dataSource);
        UserService userService = new UserServiceImpl(userRepository);
        servletContextEvent.getServletContext().setAttribute("userService", userService);

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        sce.getServletContext().setAttribute("datasource", null);
    }

}
