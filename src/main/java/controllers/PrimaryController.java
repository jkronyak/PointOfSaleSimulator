package controllers;

import java.io.IOException;

import javafx.fxml.FXML;
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
