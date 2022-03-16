package models;

import utils.MySQLConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ItemDAO {

    public Item get(String plu) throws SQLException {
        Connection connection = MySQLConnection.getConnection();
        try {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM storedb.items WHERE plu=" + plu);

            if(resultSet.next()) {
                return new TransactionItem(resultSet.getString("plu"), resultSet.getString("name"), resultSet.getDouble("price"));
            }

            connection.close();
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
            throw e;
        }


        return null;
    }

    private static Item getItemFromResultSet(ResultSet rs) throws SQLException {
        Item item = null;
        if(rs.next()) {
            item = new Item();
            item.setPlu(rs.getString("plu"));
            item.setName(rs.getString("name"));
            item.setPrice(rs.getDouble("price"));
        }
        return item;
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
