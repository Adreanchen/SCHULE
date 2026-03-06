package at.htlhl.calculator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        
    }
}
