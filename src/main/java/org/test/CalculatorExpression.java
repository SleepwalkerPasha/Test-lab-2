package org.test;

import javax.annotation.Nonnull;
import java.util.Objects;

public class CalculatorExpression {
    private final double leftOperand;

    private final double rightOperand;

    private final CalculatorOperation operation;

    public CalculatorExpression(
            double leftOperand,
            double rightOperand,
            @Nonnull CalculatorOperation operation) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
        this.operation = Objects.requireNonNull(operation, "operation must be specified");
    }

    public double leftOperand() {
        return leftOperand;
    }

    public double rightOperand() {
        return rightOperand;
    }

    public CalculatorOperation operation() {
        return operation;
    }

}
