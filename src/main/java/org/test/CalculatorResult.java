package org.test;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Optional;


public class CalculatorResult {
    @Nullable
    private final Double result;

    @Nullable
    private final String errorMessage;

    private final boolean isValid;

    public CalculatorResult(@Nullable Double result, @Nullable String errorMessage, boolean isValid) {
        if (result == null && errorMessage == null) {
            throw new IllegalArgumentException("Cannot create result with result and error message == null.");
        }
        if (result != null && errorMessage != null) {
            throw new IllegalArgumentException("Cannot create with both result and error specified");
        }
        this.result = result;
        this.errorMessage = errorMessage;
        this.isValid = isValid;
    }

    public static CalculatorResult empty() {
        return new CalculatorResult(null, "Cannot calculate result", false);
    }

    @Nonnull
    public Optional<Double> result() {
        return Optional.ofNullable(result);
    }

    @Nonnull
    public Optional<String> errorMessage() {
        return Optional.ofNullable(errorMessage);
    }

    public boolean isValid() {
        return isValid;
    }

}
