module jkronyak {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens jkronyak to javafx.fxml;
    exports jkronyak;
}