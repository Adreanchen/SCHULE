package at.htl.Einlage;

public class Einlage {
    // Privates Attribut (durch '#' im UML-Diagramm dargestellt)
    protected float betrag;

    // Konstruktor (durch '+' im UML-Diagramm dargestellt)
    public Einlage() {
        this.betrag = 0.0f;
    }

    // Setter-Methode
    public void setBetrag(float betrag) {
        this.betrag = betrag;
    }

    // Getter-Methode
    public float getBetrag() {
        return betrag;
    }
}