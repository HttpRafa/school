package de.rafael.arguments;

import org.jetbrains.annotations.NotNull;

public class ArgumentsMain {

    public static void main(String @NotNull [] args) {
        float a = Float.parseFloat(args[0]);
        float b = Float.parseFloat(args[1]);

        float y = a * b;

        System.out.println(y);
    }

}
