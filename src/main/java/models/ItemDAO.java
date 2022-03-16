package models;

import utils.DAO;
import utils.MySQLConnection;

import java.sql.*;

public class ItemDAO implements DAO<Item> {

    @Override
    public Item get(Integer plu) {
        Connection connection = MySQLConnection.getConnection();
        try {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM itemdb.items WHERE plu=" + plu);

            if(resultSet.next()) {
                return new TransactionItem(resultSet.getInt("plu"), resultSet.getString("name"), resultSet.getDouble("price"));
            }

            connection.close();
            statement.close();
            resultSet.close();
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
