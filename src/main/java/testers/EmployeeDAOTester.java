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

        byte[] salt = PasswordUtil.getSalt();
        employeeDAO.create(2, "Erik", "Anhorn", PasswordUtil.getHashedPassword("pass", salt), salt);


    }
}
