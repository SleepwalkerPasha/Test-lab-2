import org.junit.Test;
import org.mockito.Mockito;
import org.test.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;


public class CalculatorPresenterTest {
    private Calculator calculator = Mockito.mock(Calculator.class);

    private CalculatorView view = new CalculatorView();

    private CalculatorPresenter calculatorPresenter = new CalculatorPresenter(calculator, view);

    @Test
    public void shouldCalculate() throws InterruptedException {
        given(calculator.calculate(any())).willReturn(new CalculatorResult(0.0, null, false));
        this.calculatorPresenter.start();
        try {
            Thread.sleep(1500);
            view.getTextField().setText("10+10");
            Thread.sleep(1500);
            view.getButton().doClick(500);
            Thread.sleep(1500);

            assertThat(view.getLabel().getText()).isEqualTo("0.0");
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }

    }
}
