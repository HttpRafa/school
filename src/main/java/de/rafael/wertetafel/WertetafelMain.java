package de.rafael.wertetafel;

public class WertetafelMain {

    private static Wertetafel table1;
    private static Wertetafel table2;

    public static void main(String[] args) {
        for(int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }

        table1 = new Wertetafel(args);

        String[] pList = new String[3];
        pList[0] = "2";
        pList[1] = "15";
        pList[2] = "1.5";
        table2 = new Wertetafel(pList);

        table1.print();

        System.out.println("-----------------------------------");

        table2.print();
    }

}
