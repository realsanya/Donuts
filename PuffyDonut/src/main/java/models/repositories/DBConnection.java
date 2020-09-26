package models.repositories;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    final static String URL = "jdbc:mysql://localhost:3306/db?serverTimezone=UTC";
    final static String USERNAME = "root";
    final static String PASSWORD = "realsanya";

    public static Connection createConnection()
    {
        Connection con = null;
        System.out.println("In models.repositories.DBConnection.java class ");

        try
        {
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Printing connection object " + con);
        }
        catch (Exception e)
        {
            throw new IllegalStateException(e);
        }
        return con;
    }
}
