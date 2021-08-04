package jkronyak;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML private ListView<String> itemListView;
    @FXML private TextField itemEntryField;
    @FXML private Button itemEntryButton;
    @FXML private Label statusLabel;

    public void onItemEntryButtonPressed()
    {
        String strippedInput = itemEntryField.getText().strip();

        if(strippedInput.isBlank()){
            statusLabel.setText("Invalid entry!");
            itemEntryField.clear();
        }
        else
        {
            itemListView.getItems().add(strippedInput);
            itemEntryField.clear();
            statusLabel.setText("");
        }

    }


    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
