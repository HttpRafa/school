package de.rafael.wertetafel;

public class Wertetafel {

    private double start;
    private double end;
    private double step;

    /**
     * This is a constructor for a class called 'Wertetafel'.
     * It takes in a parameter 'pList' which is an array of strings.
     * The constructor checks if the length of 'pList' is less than 3 and if it is, it exits the constructor without doing anything else.
     * If the length is greater than or equal to 3, it assigns the first element of 'pList' to a variable called 'start',
     * the second element to a variable called 'end', and the third element to a variable called 'step'.
     * It then prints out the values of 'start', 'end', and 'step'.
     * @param pList String Array
     */
    public Wertetafel(String[] pList) {
        if(pList.length < 3) {
            return;
        }

        start = Double.parseDouble(pList[0]);
        end = Double.parseDouble(pList[1]);
        step = Double.parseDouble(pList[2]);
        System.out.println("Start: " + start);
        System.out.println("End: " + end);
        System.out.println("Step: " + step);
    }

    /**
     * This is a method called 'print' in a class.
     * It checks if the value of 'end' is less than or equal to 0 or the value of 'step' is less than or equal to 0,
     * if any of these conditions are true,
     * it prints out a message "End or Step is zero | end: " + end + " step: " + step" and exits the method.
     * If both conditions are false,
     * it starts a for loop that starts with the value of 'start' and continues as long as 'x'
     * is less than or equal to 'end' and increments 'x' by 'step' in each iteration. In each iteration it calls
     * a function 'f(x)' and assigns the returned value to a variable 'y',
     * and then it prints out the values of 'x' and 'y' separated by '|' character.
     */
    public void print() {
        if(end <= 0 || step <= 0) {
            System.out.println("End or Step is zero | end: " + end + " step: " + step);
            return;
        }

        for(double x = start; x <= end; x += step) {
            double y = f(x);

            System.out.println(x + " | " + y);
        }
    }

    /**
     * This is a private method called "f" that takes in a parameter "x" which is a double.
     * The method simply returns the result of "(x * x) - 2" which is a mathematical expression that calculates the value of x squared minus 2.
     * @param x X
     * @return Y
     */
    private double f(double x) {
        return (x * x) - 2;
    }

}
