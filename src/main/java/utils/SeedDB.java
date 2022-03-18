package utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SeedDB {

    public static void seed() {

        try {
            Connection connection = MySQLConnection.getConnection();

            // Drop the table in the database if it exists.
            Statement statement = connection.createStatement();
            statement.executeUpdate("DROP TABLE IF EXISTS storedb.items");
            System.out.println("Table deleted in database");

            // Recreate the table with sample data.
            statement.executeUpdate(
                    "CREATE TABLE items" +
                            "(plu CHAR(10) not NULL UNIQUE," +
                            " name CHAR(255) not NULL, " +
                            " price DOUBLE not NULL, " +
                            " PRIMARY KEY ( plu) )"
            );
            System.out.println("Table created in database");

            statement.executeUpdate(
                    "INSERT INTO storedb.items (plu, name, price) " +
                            "VALUES ('4011', 'bananas', 0.79), " +
                            "('4225', 'avocados', 1.33), " +
                            "('4060', 'broccoli', 1.29), " +
                            "('4078', 'corn', 0.72), " +
                            "('3401', 'garlic', 0.99), " +
                            "('4030', 'kiwi', 0.79)"
            );
            System.out.println("Sample data create in database table");



            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
            e.printStackTrace();
        }
    }


}
