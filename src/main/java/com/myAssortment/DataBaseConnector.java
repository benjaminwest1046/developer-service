package com.myAssortment;

import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class DataBaseConnector {

    static String username = "root";
    static String password = "root";
    static String dbUrl = "jdbc:mysql://localhost:3306/developers";

    public static void testConnection () throws SQLException {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbUrl, username, password);
            System.out.println("Connection Established to MYSQL Database");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            assert conn != null;
            conn.close();
        }
    }


}
