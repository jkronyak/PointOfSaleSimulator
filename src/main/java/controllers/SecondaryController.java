package controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import app.App;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import models.Employee;
import models.EmployeeDAO;
import utils.PasswordUtil;

public class SecondaryController {


    @FXML TextField employeeIDTextField;
    @FXML PasswordField employeePasswordField;

    EmployeeDAO employeeDAO;

    public void initialize() {
        employeeDAO = new EmployeeDAO();


    }


    @FXML
    public void onLoginButtonPressed(ActionEvent event) {

        String foundPassword;
        byte[] salt;

        try {
            Employee foundEmployee = employeeDAO.get(employeeIDTextField.getText());
            if(foundEmployee == null) {
                throw new Exception("Employee not found!");
            }
            foundPassword = foundEmployee.getPassword();
            salt = foundEmployee.getSalt();


            String hashedEnteredPassword = PasswordUtil.getHashedPassword(this.employeePasswordField.getText(), salt);

            if(hashedEnteredPassword.equals(foundPassword)) {
                switchToTransactionView();
            } else {
                throw new Exception("Incorrect id and password combination");
            }



        } catch(Exception e) {
            e.printStackTrace();
            showErrorAlert(e);
        }


    }

    public void showErrorAlert(Exception e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(e.getMessage());

        alert.showAndWait();
    }

    @FXML
    private void switchToTransactionView() throws IOException {
        App.setRoot("TransactionView");
    }

}