package jkronyak;

import java.sql.*;

public class MySQLConnection {

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/itemdb";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "Jarusalem44";

    public static Connection getConnection(){
        try {
            Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
            return connection;

        } catch(SQLException e) {
            throw new RuntimeException("Error connecting to the database", e);
        }
    }




}
