package de.rafael.school.calculator.logic;

import java.util.Optional;
import java.util.Stack;

public class StackCalculator {

    public static Optional<Double> eval(String expression) {
        Stack<Double> stack = new Stack<>();
        String[] tokens = expression.split(" ");
        for (String token : tokens) {
            switch (token.trim()) {
                case "+" -> {
                    add(stack);
                }
                case "-" -> {
                    sub(stack);
                }
                case "*" -> {
                    mul(stack);
                }
                case "/" -> {
                    div(stack);
                }
                default -> {
                    try {
                        double value = Double.parseDouble(token);
                        stack.push(value);
                    } catch (Exception exception) {
                        return Optional.empty();
                    }
                }
            }
        }
        if(stack.empty()) {
            return Optional.empty();
        } else {
            return Optional.of(stack.pop());
        }
    }

    public static void add(Stack<Double> stack) {
        double b = stack.pop();
        double a = stack.pop();
        stack.push(a + b);
    }

    public static void sub(Stack<Double> stack) {
        double b = stack.pop();
        double a = stack.pop();
        stack.push(a - b);
    }

    public static void mul(Stack<Double> stack) {
        double b = stack.pop();
        double a = stack.pop();
        stack.push(a * b);
    }

    public static void div(Stack<Double> stack) {
        double b = stack.pop();
        double a = stack.pop();
        stack.push(a + b);
    }

    public static Optional<Double> at(Stack<Double> stack, int index) {
        if(index >= stack.size()) {
            return Optional.empty();
        }
        return Optional.of(stack.get(index));
    }

}
