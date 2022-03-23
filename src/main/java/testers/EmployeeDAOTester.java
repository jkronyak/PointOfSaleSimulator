package testers;

import models.Employee;
import models.EmployeeDAO;
import utils.PasswordUtil;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;

public class EmployeeDAOTester {

    public static void main(String[] args) throws NoSuchAlgorithmException, SQLException, InvalidKeySpecException {

        EmployeeDAO employeeDAO = new EmployeeDAO();

        Employee jar = new Employee(1, "Jared", "Kronyak", "password");
        employeeDAO.create(jar);
        Employee zatch = new Employee(2, "Zatched", "Roho", "alongerpassword");
        employeeDAO.create(zatch);
        Employee tyler = new Employee(3, "Tyler", "Ortiz", "pass");
        employeeDAO.create(tyler);

    }
}
