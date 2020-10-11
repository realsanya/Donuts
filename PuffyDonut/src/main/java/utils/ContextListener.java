package utils;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {

    @SuppressWarnings("DuplicatedCode")
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/db?serverTimezone=UTC");
        hikariConfig.setDriverClassName("mysql");
        hikariConfig.setUsername("root");
        hikariConfig.setPassword("realsanya");
        hikariConfig.setMaximumPoolSize(10);

        HikariDataSource dataSource = new HikariDataSource(hikariConfig);
        sce.getServletContext().setAttribute("datasource", dataSource);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        sce.getServletContext().setAttribute("datasource", null);
    }

}
