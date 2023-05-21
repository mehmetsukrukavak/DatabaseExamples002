package com.database.library.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtilities {
    public static String url = "jdbc:postgresql://localhost:5432/db_java";
    public static String user = "postgres";
    public static String pwd = "123456";

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        Connection connection = null;

        connection = DriverManager.getConnection(url, user, pwd);

        return connection;
    }
}
