import org.junit.Test;
import org.test.Calculator;
import org.test.CalculatorExpression;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;
import static org.test.CalculatorOperation.*;

public class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @Test
    public void shouldCalculatePlus(){
        var result = calculator.calculate(new CalculatorExpression(1.0, 2.0, PLUS));
        assertThat(result.result()).isPresent();
        assertThat(result.result().get()).isCloseTo(3.0, offset(1e-16));
    }

    @Test
    public void shouldCalculateMinus(){
        var result = calculator.calculate(new CalculatorExpression(1.0, 2.0, MINUS));
        assertThat(result.result()).isPresent();
        assertThat(result.result().get()).isCloseTo(-1.0, offset(1e-16));
    }

    @Test
    public void shouldCalculateMultiply(){
        var result = calculator.calculate(new CalculatorExpression(1.0, 2.0, MULTIPLY));
        assertThat(result.result()).isPresent();
        assertThat(result.result().get()).isCloseTo(2.0, offset(1e-16));
    }

    @Test
    public void shouldCalculateDivide(){
        var result = calculator.calculate(new CalculatorExpression(1.0, 2.0, DIVIDE));
        assertThat(result.result()).isPresent();
        assertThat(result.result().get()).isCloseTo(0.5, offset(1e-16));
    }

    @Test
    public void shouldReturnEmptyResultWhenDividedByZero(){
        var result = calculator.calculate(new CalculatorExpression(1.0, 0.0, DIVIDE));
        assertThat(result.result()).isEmpty();
        assertThat(result.errorMessage()).isPresent();
    }
}
