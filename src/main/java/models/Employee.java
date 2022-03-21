package models;

import utils.PasswordUtil;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class Employee implements Serializable {

    private Integer employeeID;
    private String firstName;
    private String lastName;
    private byte[] salt;
    private String password;

    public Employee(Integer employeeID, String firstName, String lastName, String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salt = PasswordUtil.getSalt();
        this.password = PasswordUtil.getHashedPassword(password, salt);
    }

    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte[] getSalt() { return salt; }
}
