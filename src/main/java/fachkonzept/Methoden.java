package fachkonzept;

import datenhaltung.Datensatz;

public class Methoden {

    private int derZeiger;
    private int dieFeldgroße = 100;
    private Datensatz[] dasDatenfeld = new Datensatz[dieFeldgroße];

    public boolean delete() {
        int derZeiger2 = derZeiger;
        while (dasDatenfeld[derZeiger2] != null) {
            dasDatenfeld[derZeiger2] = dasDatenfeld[derZeiger2 + 1];
            derZeiger2++;
        }
        if(derZeiger > 0 && dasDatenfeld[derZeiger] == null) {
            derZeiger--;
        }
        return true;
    }

    public boolean insert(Datensatz datensatz) {
        if(dasDatenfeld[derZeiger] == null) {
            dasDatenfeld[derZeiger] = datensatz;
            return true;
        } else {
            if(dasDatenfeld[dieFeldgroße - 1] == null) {
                int derZeiger2 = dieFeldgroße - 1;
                while (derZeiger2 > derZeiger) {
                    dasDatenfeld[derZeiger2] = dasDatenfeld[derZeiger2 - 1];
                    derZeiger2--;
                }
                dasDatenfeld[derZeiger] = datensatz;
                return true;

            } else {
                return false;
            }
        }
    }

    public Datensatz erstesElement() {
        derZeiger = 0;
        if(dasDatenfeld[derZeiger] == null) {
            return new Datensatz();
        } else {
            return dasDatenfeld[derZeiger];
        }
    }

    public Datensatz letztesElement() {
        if(dasDatenfeld[derZeiger] == null) {
            return new Datensatz();
        } else {
            while (dasDatenfeld[derZeiger + 1] != null) {
                derZeiger++;
            }
            return dasDatenfeld[derZeiger];
        }
    }

    public Datensatz rechts() {
        if(dasDatenfeld[derZeiger] == null) {
            return new Datensatz();
        } else {
            if(dasDatenfeld[derZeiger + 1] != null) {
                derZeiger++;
            }
            return dasDatenfeld[derZeiger];
        }
    }

    public Datensatz links() {
        if(derZeiger > 0) {
            derZeiger--;
        }
        if(dasDatenfeld[derZeiger] == null) {
            return new Datensatz();
        } else {
            return dasDatenfeld[derZeiger];
        }
    }

}
