module jkronyak {
    requires javafx.controls;
    requires javafx.fxml;

    opens jkronyak to javafx.fxml;
    exports jkronyak;
}