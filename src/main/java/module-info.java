module oberflache {
    requires javafx.controls;
    requires javafx.fxml;


    opens oberflache to javafx.fxml;
    exports oberflache;
}