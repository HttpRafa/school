module de.rafael.school.calculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens de.rafael.school.calculator to javafx.fxml;
    opens de.rafael.school.calculator.gui to javafx.fxml;
    opens de.rafael.school.calculator.logic to javafx.fxml;
    opens de.rafael.school.calculator.errors to javafx.fxml;
    exports de.rafael.school.calculator;
    exports de.rafael.school.calculator.gui;
    exports de.rafael.school.calculator.logic;
    exports de.rafael.school.calculator.errors;
}