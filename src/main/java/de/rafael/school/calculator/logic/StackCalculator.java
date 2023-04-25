package de.rafael.school.calculator.logic;

import de.rafael.school.calculator.errors.MissingValueException;

import java.util.Arrays;
import java.util.Optional;

public class StackCalculator {

    private int stackPointer = 0;
    private int stackSize = 4;
    private double[] stack = new double[stackSize];

    public void clear() {
        stackPointer = 0;
    }

    public int size() {
        return stackPointer;
    }

    public boolean empty() {
        return stackPointer == 0;
    }

    public void push(double value) {
        stack[stackPointer] = value;
        stackPointer++;

    }

    public Optional<Double> pop() {
        if(empty()) return Optional.empty();
        stackPointer--;
        double value = stack[stackPointer];
        return Optional.of(value);
    }

    public Optional<Double> at(int index) {
        if(index > stackPointer) {
            return Optional.empty();
        }
        return Optional.of(stack[index]);
    }

    public void set(int index, double value) {
        stack[index] = value;
    }

    public void add() throws MissingValueException {
        if(size() < 2) {
            throw new MissingValueException(MathAction.DIV);
        }
        Optional<Double> b = pop();
        var a = pop();
        if(a.isPresent() && b.isPresent()) {
            push(a.get() + b.get());
        } else {
            throw new MissingValueException(MathAction.DIV);
        }
    }

    public void sub() throws MissingValueException {
        if(size() < 2) {
            throw new MissingValueException(MathAction.SUB);
        }
        var b = pop();
        var a = pop();
        if(a.isPresent() && b.isPresent()) {
            push(a.get() - b.get());
        } else {
            throw new MissingValueException(MathAction.SUB);
        }
    }

    public void mul() throws MissingValueException {
        if(size() < 2) {
            throw new MissingValueException(MathAction.MUL);
        }
        var b = pop();
        var a = pop();
        if(a.isPresent() && b.isPresent()) {
            push(a.get() * b.get());
        } else {
            throw new MissingValueException(MathAction.MUL);
        }
    }

    public void div() throws MissingValueException {
        if(size() < 2) {
            throw new MissingValueException(MathAction.DIV);
        }
        var b = pop();
        var a = pop();
        if(a.isPresent() && b.isPresent()) {
            push(a.get() / b.get());
        } else {
            throw new MissingValueException(MathAction.DIV);
        }
    }

    public void swap() throws MissingValueException {
        Optional<Double> i0 = at(0);
        Optional<Double> i1 = at(1);
        if(i0.isPresent() && i1.isPresent()) {
            set(1, i0.get());
            set(0, i1.get());
        } else {
            throw new MissingValueException(MathAction.SWAP);
        }
    }

    public enum MathAction {
        ADD,
        SUB,
        MUL,
        DIV,

        SWAP
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
