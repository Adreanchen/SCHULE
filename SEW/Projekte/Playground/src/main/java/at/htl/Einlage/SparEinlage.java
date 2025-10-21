package at.htl.Einlage;

public class SparEinlage extends Einlage {
    // Konstanter Zinssatz von 3,5%
    private static final float ZINSSATZ = 0.035f;
    /**
     * Berechnet die Zinsen für die aktuelle Einlage.
     * @return Der berechnete Zinsbetrag.
     */
    public float berechneZinsen() {
        // Zinsen = Betrag * Zinssatz
        return this.betrag * ZINSSATZ;
    }
}