package at.htl.fehlerbehandlung;

public class AppThrows {
    protected int squareAdvanced(int value, int lowerBound, int upperBound) throws SquareException {
        if (value < lowerBound || value > upperBound) {
            throw new SquareException("Out of bounds");
        }
        return value * value;
    }

    public static void main(String[] args) {
        AppThrows appThrows = new AppThrows();
        try {
            int squared = appThrows.squareAdvanced(5,2, 4);
            System.out.println("Square value: " + squared);
        } catch (SquareException sex) {
            System.err.println("SquareException: " + sex.getMessage());
        }
    }
}
