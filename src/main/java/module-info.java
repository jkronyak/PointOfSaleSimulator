module jkronyak {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens app to javafx.fxml;
    exports app;
    exports controllers;
    opens controllers to javafx.fxml;
    exports models;
    opens models to javafx.fxml;
    exports utils;
    opens utils to javafx.fxml;
}