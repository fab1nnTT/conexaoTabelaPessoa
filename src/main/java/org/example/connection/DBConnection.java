package org.example.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
    private static final String url = "jdbc:mysql://localhost:3306/produtos";
    static Properties props = new Properties();
    static {
        props.setProperty("user", "root");
        props.setProperty("password", "953074");
        props.setProperty("ssl", "require");
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, props);
    }
}
