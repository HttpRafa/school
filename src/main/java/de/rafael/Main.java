package de.rafael;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Rechteck rechteck = new Rechteck(5, 6);
        float f = rechteck.fläche();
        float u = rechteck.umfang();

        System.out.println(f + " | " + u);

        // Output: 30.0 | 22.0

        // ---------------------------------------------

        System.out.println(Arrays.toString(args));

        float a = Float.parseFloat(args[0]);
        float b = Float.parseFloat(args[1]);
        float c = Float.parseFloat(args[2]);

        float z = a + b + c;
        System.out.println(z);

        // Output:  [5, 6, 7]
        //          18.0

    }

}