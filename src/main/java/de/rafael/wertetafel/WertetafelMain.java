package de.rafael.wertetafel;

public class WertetafelMain {

    private static Wertetafel wertetafel;
    private static Wertetafel wertetafel2;

    public static void main(String[] args) {
        wertetafel = new Wertetafel(args);

        String[] pListe = new String[3];
        pListe[0] = "2";
        pListe[1] = "15";
        pListe[2] = "1.5";
        wertetafel2 = new Wertetafel(pListe);

        wertetafel.ausgeben();

        System.out.println("-----------------------------------");

        wertetafel2.ausgeben();
    }

}
