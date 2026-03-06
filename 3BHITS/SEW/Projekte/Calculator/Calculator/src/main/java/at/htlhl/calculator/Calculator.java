package at.htlhl.calculator;

public class Calculator {

    public Calculator() {

    }

    public int add(int operand1, int operand2) {
        return operand1 + operand2;
    }

    public int subtract(int operand1, int operand2) {
        return operand1 - operand2;
    }

    public int multiply(int operand1, int operand2) {
        return operand1 * operand2;
    }

    public int absolutValue(int number) { // es gibt Math.abs ohne library ja wir machens so!
        if (number < 0) {
            return number * (-1);
        }
        return number;
    }

    public int divide(int zaehler, int nenner) throws CalcException {
        if (nenner == 0) {
            throw new CalcException("Division by zero is not allowed."); // "Nenner ist 0"
        }
        return zaehler / nenner;
    }
}
