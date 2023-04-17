package de.rafael.school.calculator.logic;

import de.rafael.school.calculator.errors.MissingValueException;

import java.util.Optional;
import java.util.Stack;

public class StackCalculator {

    private final Stack<Double> stack = new Stack<>();

    public int size() {
        return stack.size();
    }

    public boolean empty() {
        return stack.empty();
    }

    public double push(double value) {
        return stack.push(value);
    }

    public Optional<Double> pop() {
        if(stack.empty()) return Optional.empty();
        return Optional.of(stack.pop());
    }

    public void add() throws MissingValueException {
        if(stack.size() < 2) throw new MissingValueException(MathAction.ADD);
        double b = stack.pop();
        double a = stack.pop();
        stack.push(a + b);
    }

    public void sub() throws MissingValueException {
        if(stack.size() < 2) throw new MissingValueException(MathAction.SUB);
        double b = stack.pop();
        double a = stack.pop();
        stack.push(a - b);
    }

    public void mul() throws MissingValueException {
        if(stack.size() < 2) throw new MissingValueException(MathAction.MUL);
        double b = stack.pop();
        double a = stack.pop();
        stack.push(a * b);
    }

    public void div() throws MissingValueException {
        if(stack.size() < 2) throw new MissingValueException(MathAction.DIV);
        double b = stack.pop();
        double a = stack.pop();
        stack.push(a / b);
    }

    public Optional<Double> at(int index) {
        if(index >= stack.size()) {
            return Optional.empty();
        }
        return Optional.of(stack.get(index));
    }

    public enum MathAction {
        ADD,
        SUB,
        MUL,
        DIV
    }

    public static Optional<Double> eval(String expression) throws MissingValueException {
        StackCalculator stackCalculator = new StackCalculator();
        String[] tokens = expression.split(" ");
        for (String token : tokens) {
            switch (token.trim()) {
                case "+" -> {
                    stackCalculator.add();
                }
                case "-" -> {
                    stackCalculator.sub();
                }
                case "*" -> {
                    stackCalculator.mul();
                }
                case "/" -> {
                    stackCalculator.div();
                }
                default -> {
                    try {
                        stackCalculator.push(Double.parseDouble(token));
                    } catch (Exception exception) {
                        return Optional.empty();
                    }
                }
            }
        }
        if(stackCalculator.empty()) {
            return Optional.empty();
        } else {
            return stackCalculator.pop();
        }
    }

}
