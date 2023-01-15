package de.rafael.wertetafel;

public class Wertetafel {

    private double derStartwert;
    private double derEndwert;
    private double dieSchrittweite;

    public Wertetafel(String[] pListe) {
        if(pListe.length < 3) {
            return;
        }

        derStartwert = Double.parseDouble(pListe[0]);
        derEndwert = Double.parseDouble(pListe[1]);
        dieSchrittweite = Double.parseDouble(pListe[2]);
    }

    public void ausgeben() {
        for(double x = derStartwert; x <= derEndwert; x += dieSchrittweite) {
            double y = f(x);

            System.out.println(x + " | " + y);
        }
    }

    private double f(double x) {
        return (x * x) - 2;
    }

}
