package jkronyak;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class PrimaryController {

    @FXML private ListView<Item> itemListView;
    @FXML private TextField itemEntryField;
    @FXML private Button itemEntryButton;
    @FXML private Label statusLabel;

    private Transaction curTransaction;

    public PrimaryController(){
    }

    public void initialize(){

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

            }
        } catch(Exception e){
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
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
