package at.htl.fehlerbehandlung;

import java.util.ArrayList;

/**
 * Fehlerbehandlung
 */

public class App {

    public static void main(String[] args) {
        try {
            // int wert = Integer.valueOf("Keine Zahl");
            int wert = Integer.valueOf("10");

            ArrayList<String> nameList = null;
            nameList.add("Tim");
        } catch (NumberFormatException nfex) {
            System.err.println("Can't parse Integer: " + nfex.getMessage());
        } catch (NullPointerException npex) {
            System.err.println("Nullpointerexception aufgetreten");
        }
    }
}
