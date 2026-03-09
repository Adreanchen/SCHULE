package at.htlhl.calculator;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class CalculatorTest {
    Calculator calculator;

    /**
     * Wird einmal aufgerufen, wenn die Klasse für den Test initialisiert wird
     */
    @BeforeAll
    public static void beforeClass() {

    }

    /**
     * Wird immer vor einer Testmethode aufgerufen
     */
    @BeforeEach
    public void setup() {
        calculator = new Calculator();
    }

    @Test
    public void multiply() {
        assertEquals(36, calculator.multiply(6, 6));
    }

    @Test
    public void testAbsoluteValue() {
        assertEquals(6, calculator.absolutValue(-6));
        assertEquals(6, calculator.absolutValue(6));
    }

    @Test
    public void add() {
        assertEquals(42, calculator.add(20, 22));
    }

    @Test
    public void subtract() {
        assertEquals(-3, calculator.subtract(8, 11));
    }

    @Test
    public void testDivide() {
        // Testen der Dividierfunktionalität
        try {
            assertEquals(3, calculator.divide(9, 3));
        } catch (CalcException e) {
            fail("Hier sollte keine Exception auftreten");
        }

        // Testen ob die Exception auslöst
        try {
            calculator.divide(9, 0);
            fail("CalcException sollte auslösen");
        } catch (CalcException e) {
            // Ignore
        }
    }

    @AfterEach
    public void tearDown() {
        calculator = null;
    }

    /**
     * Wird aufgerufen, wenn alle Tests für die Klasse abgeschlossen sind.
     */
    @AfterAll
    public static void afterClass() {

    }
}
