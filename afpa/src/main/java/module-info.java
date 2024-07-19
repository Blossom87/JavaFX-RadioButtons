module fr {
    requires javafx.controls;
    requires javafx.fxml;

    opens fr to javafx.fxml;
    exports fr;
}
