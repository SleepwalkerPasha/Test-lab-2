package org.test;



public class Calculator {

    public CalculatorResult calculate(CalculatorExpression calculatorExpression){
        return switch (calculatorExpression.operation()){
            case PLUS -> sum(calculatorExpression.leftOperand(),calculatorExpression.rightOperand());
            case MINUS -> subtract(calculatorExpression.leftOperand(),calculatorExpression.rightOperand());
            case DIVIDE -> divide(calculatorExpression.leftOperand(),calculatorExpression.rightOperand());
            case MULTIPLY -> multiply(calculatorExpression.leftOperand(),calculatorExpression.rightOperand());
        };
    }

    private CalculatorResult sum(double a, double b) {
        return new CalculatorResult(a + b, null, true);
    }

    private CalculatorResult subtract(double a, double b) {
        return new CalculatorResult(a - b, null, true);
    }

    private CalculatorResult multiply(double a, double b) {
        return new CalculatorResult(a * b, null, true);
    }

    private CalculatorResult divide(double a, double b) throws IllegalArgumentException {
        return b == 0.0
                ? CalculatorResult.empty()
                : new CalculatorResult(
                a / b,
                null,
                true
        );

    }
}