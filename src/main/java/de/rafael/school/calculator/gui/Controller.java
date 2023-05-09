package de.rafael.school.calculator.gui;

import de.rafael.school.calculator.errors.MissingValueException;
import de.rafael.school.calculator.logic.StackCalculator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Controller {

    private final StackCalculator stackCalculator = new StackCalculator();

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
    public void initialize() {
        this.numberInput.setOnKeyPressed(event -> {
            if(event.getCode().equals(KeyCode.ENTER)) {
                enter(null);
            }
        });
    }

    @FXML
    protected void clear(ActionEvent event) {
        stackCalculator.clear();
        numberInput.setText("");
        numberInput.requestFocus();
        refreshFields();
    }

    @FXML
    protected void add(ActionEvent event) {
        try {
            stackCalculator.add();
        } catch (MissingValueException exception) {
            errorLabel.setText(exception.toString());
        }
        numberInput.requestFocus();
        refreshFields();
    }

    @FXML
    protected void div(ActionEvent event) {
        try {
            stackCalculator.div();
        } catch (MissingValueException exception) {
            errorLabel.setText(exception.toString());
        }
        numberInput.requestFocus();
        refreshFields();
    }

    @FXML
    protected void mul(ActionEvent event) {
        try {
            stackCalculator.mul();
        } catch (MissingValueException exception) {
            errorLabel.setText(exception.toString());
        }
        numberInput.requestFocus();
        refreshFields();
    }

    @FXML
    protected void sub(ActionEvent event) {
        try {
            stackCalculator.sub();
        } catch (MissingValueException exception) {
            errorLabel.setText(exception.toString());
        }
        numberInput.requestFocus();
        refreshFields();
    }

    @FXML
    protected void drop(ActionEvent event) {
        stackCalculator.pop();
        numberInput.requestFocus();
        refreshFields();
    }

    @FXML
    protected void enter(ActionEvent event) {
        String input = numberInput.getText().trim();
        numberInput.requestFocus();
        numberInput.clear();

        // Check if the value is + or something else
        if((input.isEmpty() || input.isBlank())) {
            try {
                stackCalculator.at(0).ifPresent(stackCalculator::push);
                refreshFields();
                return;
            } catch (ArrayIndexOutOfBoundsException ignored) {
                errorLabel.setText("The stack is already full");
                return;
            }
        } else if(input.length() == 1) {
            switch (input) {
                case "+" -> {
                    add(null);
                    return;
                }
                case "-" -> {
                    sub(null);
                    return;
                }
                case "*" -> {
                    mul(null);
                    return;
                }
                case "/" -> {
                    div(null);
                    return;
                }
                case "d" -> {
                    drop(null);
                    return;
                }
                case "c" -> {
                    clear(null);
                    return;
                }
                case "s" -> {
                    swap(null);
                    return;
                }
            }
        }

        try {
            stackCalculator.push(Double.parseDouble(input));
        } catch(NumberFormatException numberFormatException) {
            errorLabel.setText("Please enter a valid number");
        } catch (ArrayIndexOutOfBoundsException exception) {
            errorLabel.setText("The stack is already full");
        } catch(Exception exception) {
            errorLabel.setText(exception.toString());
        }
        refreshFields();
    }

    @FXML
    protected void swap(ActionEvent event) {
        try {
            stackCalculator.swap();
        } catch(Exception exception) {
            errorLabel.setText(exception.toString());
        }
        numberInput.requestFocus();
        refreshFields();
    }

    @FXML
    protected void swapSign(ActionEvent event) {
        try {
            numberInput.setText(String.valueOf(-Double.parseDouble(numberInput.getText())));
        } catch (Exception exception) {
            errorLabel.setText(exception.toString());
        }
        numberInput.requestFocus();
    }

    @FXML
    protected void expressionChanged(KeyEvent event) {
        try {
            expressionOutput.setText("");

            StackCalculator.eval(expressionInput.getText()).ifPresent(value -> {
                expressionOutput.setText(value + "");
            });
        } catch (MissingValueException exception) {
            errorLabel.setText(exception.toString());
        }
    }

    private void refreshFields() {
        int amount = 3;
        for (int i = 0; i <= amount; i++) {
            int vI = stackCalculator.size() - 1 - i;
            try {
                TextField textField = (TextField) getClass().getDeclaredField("stackI" + i).get(this);
                if(vI >= 0) {
                    var value = stackCalculator.at(vI);
                    textField.setText((value.isPresent() ? value.get() : "") + "");
                } else {
                    textField.setText("");
                }
            } catch (Exception exception) {
                errorLabel.setText(exception.toString());
                exception.printStackTrace();
            }
        }
    }
    
}
