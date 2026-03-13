package at.htl.Einlage;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // keineAhnung();

        System.out.println(fib(50));
    }

    public static int fib(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 1;
        } else {
            return fib(n-1) + fib(n-2);
        }
    }

    private static void keineAhnung() {
        SparEinlage[] SE = new SparEinlage[11];
        Random random = new Random();
        float gesamtZinsen = 0.0f;

        System.out.println("### Ergebnisse der SparEinlagen-Berechnung ###");
        System.out.println("----------------------------------------------");
        System.out.printf("| %-4s | %-12s | %-12s |\n", "Nr.", "Betrag", "Zinsen (3.5%)");
        System.out.println("----------------------------------------------");

        for (int i = 0; i < SE.length; i++) {
            SE[i] = new SparEinlage();
            SE[i].setBetrag(random.nextFloat(300.00f, 1300.00f));
            gesamtZinsen += SE[i].berechneZinsen();
            System.out.printf("| %-5d | %-12.2f | %-12.2f |\n", i + 1, SE[i].getBetrag(), SE[i].berechneZinsen());
        }

        System.out.println("----------------------------------------------");
        System.out.printf("| %-5s | %-12s | %-12.2f |\n", "SUMME", "", gesamtZinsen);
        System.out.println("----------------------------------------------");
    }
}