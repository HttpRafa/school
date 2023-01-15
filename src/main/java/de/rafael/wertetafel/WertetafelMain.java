package de.rafael.wertetafel;

public class WertetafelMain {

    private static Wertetafel wertetafel;
    private static Wertetafel wertetafel2;

    public static void main(String[] args) {
        wertetafel = new Wertetafel(args);

        String[] pListe = new String[3];
        wertetafel2 = new Wertetafel(pListe);

        wertetafel.ausgeben();
        wertetafel2.ausgeben();
    }

}
