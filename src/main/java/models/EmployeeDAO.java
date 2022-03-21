package models;

import utils.MySQLConnection;

import java.sql.*;
import javax.sql.rowset.serial.SerialBlob;

public class EmployeeDAO {

    public Employee get(String id) throws Exception {
        Connection connection = MySQLConnection.getConnection();

        try {

            Statement statement = connection.createStatement();
           // ResultSet resultSet = statement.executeQuery("SELECT * FROM storedb.employees WHERE employee_id=" + id);
            ResultSet resultSet = statement.executeQuery("SELECT * FROM storedb.employees WHERE employee_id=" + id);

            if(resultSet.next()) {
                Integer empId = resultSet.getInt("employee_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String password = resultSet.getString("password");
                Blob blob = resultSet.getBlob("salt");

                return new Employee(resultSet.getInt("employee_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("password"));
            }

            connection.close();
            statement.close();
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }


        return null;
    }

    public void create(Integer employeeID, String firstName, String lastName, String password, byte[] salt) throws SQLException {
        Connection connection = MySQLConnection.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO storedb.employees (employee_id, first_name, last_name, password, salt)"
                    + "VALUES (?, ?, ?, ?, ?)");

            preparedStatement.setInt(1, employeeID);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setString(4, password);
            preparedStatement.setBlob(5, new SerialBlob(salt));

            preparedStatement.executeUpdate();


            connection.close();
            preparedStatement.close();

        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}



