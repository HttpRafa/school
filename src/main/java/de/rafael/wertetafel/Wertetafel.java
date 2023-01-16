package de.rafael.wertetafel;

public class Wertetafel {

    private double start;
    private double end;
    private double step;

    /**
     * Dieser Code ist ein Konstruktor für eine Klasse namens "Wertetafel". Der Konstruktor erwartet ein Array von Strings als Parameter.
     * Innerhalb des Konstruktors, wird überprüft, ob die Länge des Arrays mindestens 3 Elemente enthält. Wenn dies der Fall ist,
     * werden die ersten drei Elemente des Arrays als "start", "end" und "step" Variablen gespeichert.
     * Danach werden die Werte der Variablen "start", "end" und "step" auf der Konsole ausgegeben.
     * Der erste Block Code "
     * if(pList.length < 3) {
     *      return;
     * }
     * " ist auskommentiert und hat keine Funktion in diesem Konstruktor.
     * @param pList String Array
     */
    public Wertetafel(String[] pList) {
        /*
        Nicht wichtig

        if(pList.length < 3) {
            return;
        }
         */

        if(pList.length >= 3) {
            start = Double.parseDouble(pList[0]);
            end = Double.parseDouble(pList[1]);
            step = Double.parseDouble(pList[2]);
            System.out.println("Start: " + start);
            System.out.println("End: " + end);
            System.out.println("Step: " + step);
        }
    }

    /**
     * Dieser Code ist eine Methode namens "print" in derselben Klasse "Wertetafel".
     * Die Methode hat keine Parameter und führt eine Schleife aus, die mit der "start" Variable beginnt und solange fortfährt,
     * bis "x" die "end" Variable erreicht hat. In jeder Schleifeniteration wird "x" um den "step" Wert erhöht.
     * Innerhalb der Schleife, wird die Methode "f(x)" aufgerufen mit dem aktuellen Wert von "x", und das Ergebnis wird in eine Variable "y" gespeichert.
     * Danach wird der Wert von "x" und "y" auf der Konsole ausgegeben.
     * Der erste Block Code "
     * if(end >= 0 || step >= 0) {
     *      System.out.println("End or Step is zero | end: " + end + " step: " + step); return;
     * }
     * " ist auskommentiert und hat keine Funktion in dieser Methode.
     */
    public void print() {
        /*
        Nicht wichtig

        if(end >= 0 || step >= 0) {
            System.out.println("End or Step is zero | end: " + end + " step: " + step);
            return;
        }
         */

        for(double x = start; x <= end; x += step) {
            double y = f(x);

            System.out.println(x + " | " + y);
        }
    }

    /**
     * Dies ist eine private Methode namens "f" in derselben Klasse "Wertetafel". Die Methode hat einen double-Wert als Parameter, welcher als "x" bezeichnet wird.
     * Die Methode berechnet das Ergebnis von (x * x) - 2 und gibt diesen double-Wert zurück.
     * Es ist eine private Methode und kann nur innerhalb der Klasse "Wertetafel" aufgerufen werden, nicht von außerhalb.
     * @param x X
     * @return Y
     */
    private double f(double x) {
        return (x * x) - 2;
    }

    /**
     * Dies ist eine öffentliche Methode namens "getStart" in derselben Klasse "Wertetafel". Die Methode hat keine Parameter und gibt den Wert der Variablen "start" zurück.
     * Es ist eine öffentliche Methode, das bedeutet, dass sie von jedem Teil des Programms aufgerufen werden kann, auch von außerhalb der Klasse "Wertetafel".
     * Der Rückgabewert ist ein double-Wert, der den Wert der "start" Variable repräsentiert.
     * @return start
     */
    public double getStart() {
        return start;
    }

    /**
     * Dies ist eine öffentliche Methode namens "getEnd" in derselben Klasse "Wertetafel". Die Methode hat keine Parameter und gibt den Wert der Variablen "end" zurück.
     * Es ist eine öffentliche Methode, das bedeutet, dass sie von jedem Teil des Programms aufgerufen werden kann, auch von außerhalb der Klasse "Wertetafel".
     * Der Rückgabewert ist ein double-Wert, der den Wert der "end" Variable repräsentiert.
     * @return end
     */
    public double getEnd() {
        return end;
    }

    /**
     * Dies ist eine öffentliche Methode namens "getStep" in derselben Klasse "Wertetafel". Die Methode hat keine Parameter und gibt den Wert der Variablen "step" zurück.
     * Es ist eine öffentliche Methode, das bedeutet, dass sie von jedem Teil des Programms aufgerufen werden kann, auch von außerhalb der Klasse "Wertetafel".
     * Der Rückgabewert ist ein double-Wert, der den Wert der "step" Variable repräsentiert.
     * @return step
     */
    public double getStep() {
        return step;
    }

}
