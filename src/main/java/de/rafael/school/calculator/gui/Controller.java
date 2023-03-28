package de.rafael.school.calculator.gui;

import de.rafael.school.calculator.Main;
import de.rafael.school.calculator.logic.StackCalculator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.util.Stack;

public class Controller {

    private final Stack<Double> stack = new Stack<>();

    @FXML
    private Label errorLabel;

    @FXML
    private TextField expressionInput;

    @FXML
    private Label expressionOutput;

    @FXML
    private TextField numberInput;


    @FXML
    private TextField stackI0;

    @FXML
    private TextField stackI1;

    @FXML
    private TextField stackI2;

    @FXML
    private TextField stackI3;

    @FXML
    protected void add(ActionEvent event) {
        StackCalculator.add(stack);
        refreshFields();
    }

    @FXML
    protected void clear(ActionEvent event) {
        numberInput.setText("");
        refreshFields();
    }

    @FXML
    protected void div(ActionEvent event) {
        StackCalculator.div(stack);
        refreshFields();
    }

    @FXML
    protected void drop(ActionEvent event) {
        stack.pop();
        refreshFields();
    }

    @FXML
    protected void enter(ActionEvent event) {
        String input = numberInput.getText();
        numberInput.clear();
        try {
            double value = Double.parseDouble(input);
            stack.push(value);
        } catch (Exception exception) {
            errorLabel.setText(exception.getMessage());
        }
        refreshFields();
    }

    @FXML
    protected void mul(ActionEvent event) {
        StackCalculator.mul(stack);
        refreshFields();
    }

    @FXML
    protected void sub(ActionEvent event) {
        StackCalculator.sub(stack);
        refreshFields();
    }

    @FXML
    protected void swap(ActionEvent event) {

    }

    @FXML
    protected void swapSign(ActionEvent event) {
        try {
            numberInput.setText(String.valueOf(-Double.parseDouble(numberInput.getText())));
        } catch (Exception exception) {
            errorLabel.setText(exception.getMessage());
        }
    }

    @FXML
    protected void expressionChanged(KeyEvent event) {
        StackCalculator.eval(expressionInput.getText()).ifPresent(value -> {
            expressionOutput.setText(value + "");
        });
    }

    private void refreshFields() {
        for (int i = 0; i <= 3; i++) {
            var value = StackCalculator.at(stack, i);
            try {
                TextField textField = (TextField) getClass().getDeclaredField("stackI" + i).get(this);
                textField.setText((value.isPresent() ? value.get() : "") + "");
            } catch (Exception exception) {
                errorLabel.setText(exception.getMessage());
                exception.printStackTrace();
            }
        }
    }
    
}
