package de.rafael.school.calculator.error;

import de.rafael.school.calculator.logic.StackCalculator;

import java.util.Locale;

public class MissingValueException extends Exception {

    private final StackCalculator.MathAction mathAction;

    public MissingValueException(StackCalculator.MathAction mathAction) {
        this.mathAction = mathAction;
    }

    public StackCalculator.MathAction mathAction() {
        return mathAction;
    }

    @Override
    public String toString() {
        return mathAction.name() + " action failed because of missing values in the stack";
    }
    
}
