package jkronyak;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ItemDAO implements DAO<Item> {

    @Override
    public Item get(Integer plu) {
        Connection connection = MySQLConnection.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM itemdb.items WHERE plu=" + plu);

            if(resultSet.next()) {
                return new Item(resultSet.getInt("plu"), resultSet.getString("name"), resultSet.getDouble("price"));
            }

        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }


        return null;
    }

    /*
    @Override
    public List<Item> getAll() {
        Connection connection = MySQLConnection.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM itemdb.items");

            if(resultSet.next()) {
                List<Item> resultList = new ArrayList<Item>();
                resultList.addAll(resultSet);
            }

        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
    }
     */
}
