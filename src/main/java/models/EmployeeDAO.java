package models;

import utils.MySQLConnection;

import java.sql.*;
import javax.sql.rowset.serial.SerialBlob;

public class EmployeeDAO {

    public Employee get(String id) throws Exception {
        Connection connection = MySQLConnection.getConnection();

        try {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM storedb.employees WHERE employee_id=" + id);

            if(resultSet.next()) {
                Integer foundId = resultSet.getInt("employee_id");
                String foundFirst = resultSet.getString("first_name");
                String foundLast = resultSet.getString("last_name");
                String foundPassword = resultSet.getString("password");
                Blob foundBlob = resultSet.getBlob("salt");

                int blobLen = (int) foundBlob.length();
                byte[] foundSalt = foundBlob.getBytes(1, blobLen);

                Employee foundEmployee = new Employee(foundId, foundFirst, foundLast, foundPassword, foundSalt);
                foundEmployee.setPassword(foundPassword);
                return foundEmployee;
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

    public void create(Employee employee) {
        Connection connection = MySQLConnection.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO storedb.employees (employee_id, first_name, last_name, password, salt)"
                    + "VALUES (?, ?, ?, ?, ?)");

            preparedStatement.setInt(1, employee.getEmployeeID());
            preparedStatement.setString(2, employee.getFirstName());
            preparedStatement.setString(3, employee.getLastName());
            preparedStatement.setString(4, employee.getPassword());
            preparedStatement.setBlob(5, new SerialBlob(employee.getSalt()));

            preparedStatement.executeUpdate();


            connection.close();
            preparedStatement.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}



