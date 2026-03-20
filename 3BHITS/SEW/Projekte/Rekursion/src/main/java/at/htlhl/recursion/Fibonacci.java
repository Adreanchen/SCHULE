package at.htlhl.recursion;

/**
 * Liefert die Fibonacci Zahlen (1 1 2 3 5 8 ...)
 */
public class Fibonacci {

    private final static int N = 6;

    public Fibonacci() {

        // Liefert einen bestimmte Stelle der fibonacci Folge
        System.out.println(N + ". Stelle der Fibonacci Folge");
        int fibonacciNumber = fib(N);
        System.out.println(fibonacciNumber);

        // Liefert die Fibonacci Folge
        System.out.println("Fibonacci Folge bis zur " + N + ". Stelle");
        for (int i = 1; i <= N; i++) {
            fibonacciNumber = fib(i);
            System.out.println(" " + fibonacciNumber);
        }
    }

    public int fib(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    public static void main(String[] args) {
        new Fibonacci();
    }
}
