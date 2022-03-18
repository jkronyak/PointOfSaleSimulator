package controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import app.App;
import models.Transaction;
import models.TransactionItem;

public class PrimaryController {

    @FXML private ListView<TransactionItem> itemListView;
    @FXML private TextField itemEntryField;
    @FXML private Button itemEntryButton;
    @FXML private Label statusLabel;
    @FXML private Label totalPriceLabel;

    private Transaction curTransaction;

    public PrimaryController() {
    }

    public void initialize() {
        curTransaction = new Transaction();
        itemListView.setItems(curTransaction.getItemList());
    }

    public void onNumpadButtonPressed(ActionEvent event) {
        String id = ((Node) event.getSource()).getId();
        switch(id) {
            case "zeroButton":
                itemEntryField.insertText(itemEntryField.getText().length(), "0");
                break;
            case "backspaceButton":
                if(itemEntryField.getText().length() != 0)
                    itemEntryField.replaceText(0, itemEntryField.getText().length(), itemEntryField.getText().substring(0, itemEntryField.getText().length() - 1));
                break;
            case "clearButton":
                itemEntryField.clear();
                break;
            case "oneButton":
                itemEntryField.insertText(itemEntryField.getText().length(), "1");
                break;
            case "twoButton":
                itemEntryField.insertText(itemEntryField.getText().length(), "2");
                break;
            case "threeButton":
                itemEntryField.insertText(itemEntryField.getText().length(), "3");
                break;
            case "fourButton":
                itemEntryField.insertText(itemEntryField.getText().length(), "4");
                break;
            case "fiveButton":
                itemEntryField.insertText(itemEntryField.getText().length(), "5");
                break;
            case "sixButton":
                itemEntryField.insertText(itemEntryField.getText().length(), "6");
                break;
            case "sevenButton":
                itemEntryField.insertText(itemEntryField.getText().length(), "7");
                break;
            case "eightButton":
                itemEntryField.insertText(itemEntryField.getText().length(), "8");
                break;
            case "nineButton":
                itemEntryField.insertText(itemEntryField.getText().length(), "9");
                break;
        }

    }


    public void onItemEntryButtonPressed() {

        try {
            String strippedInput = itemEntryField.getText().strip();

            if (strippedInput.isBlank()) {
                statusLabel.setText("Invalid entry!");
                itemEntryField.clear();
            } else {
                curTransaction.addItem(strippedInput);
                itemEntryField.clear();
                statusLabel.setText("Item added!");
                totalPriceLabel.setText( "TOTAL: $" + curTransaction.getTotal());
            }
        } catch(Exception e) {
            showErrorAlert(e);
            itemEntryField.clear();
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
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
