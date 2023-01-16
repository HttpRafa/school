package de.rafael.wertetafel;

public class Wertetafel {

    private double start;
    private double end;
    private double step;

    public Wertetafel(String[] pListe) {
        if(pListe.length < 3) {
            return;
        }

        start = Double.parseDouble(pListe[0]);
        end = Double.parseDouble(pListe[1]);
        step = Double.parseDouble(pListe[2]);
        System.out.println("Start: " + start);
        System.out.println("End: " + end);
        System.out.println("Step: " + step);
    }

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

    private double f(double x) {
        return (x * x) - 2;
    }

}
