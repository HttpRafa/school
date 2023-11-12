package datenhaltung;

import java.util.Random;

public class Datensatz {

    private String derName;
    private String derOrt;
    private String derVorname;
    private String diePLZ;
    private String dieStrasse;
    private String dieHausNummer;
    private String dieTelNummer;
    private String dieVorwahl;

    public Datensatz() {
        derName = "";
        derOrt = "";
        derVorname = "";
        diePLZ = "";
        dieStrasse = "";
        dieHausNummer = "";
        dieTelNummer = "";
        dieVorwahl = "";
    }

    public Datensatz(String s) {

    }

    public Datensatz(String pName, String pOrt, String pVorname, String pPLZ, String pStrasse, String pHausNummer, String pTelNummer, String pVorwahl) {
        derName = pName;
        derOrt = pOrt;
        derVorname = pVorname;
        diePLZ = pPLZ;
        dieStrasse = pStrasse;
        dieHausNummer = pHausNummer;
        dieTelNummer = pTelNummer;
        dieVorwahl = pVorwahl;
    }

    public String getName() {
        return derName;
    }

    public String getOrt() {
        return derOrt;
    }

    public String getVorname() {
        return derVorname;
    }

    public String getPLZ() {
        return diePLZ;
    }

    public String getStrasse() {
        return dieStrasse;
    }

    public String getHausNummer() {
        return dieHausNummer;
    }

    public String getTelNummer() {
        return dieTelNummer;
    }

    public String getVorwahl() {
        return dieVorwahl;
    }

}
