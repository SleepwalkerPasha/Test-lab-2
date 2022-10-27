package cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.data.Offset;
import org.test.Calculator;
import org.test.CalculatorPresenter;
import org.test.CalculatorView;

import static org.assertj.core.api.Assertions.assertThat;

public class StepDefinitions {
    private final Calculator model = new Calculator();

    private final CalculatorView view = new CalculatorView();

    private final CalculatorPresenter presenter = new CalculatorPresenter(model, view);

    @Given("expression is {double} {string} {double}")
    public void expressionIs(Double firstArg, String operator, Double secondArg){
        presenter.start();
        view.getTextField().setText(firstArg.toString() + " " + operator + " " + secondArg);
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }

    @When("calculate is pressed")
    public void calculateIsPressed(){
        view.getButton().doClick(500);
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }

    @Then("displays {double}")
    public void displaysAnswer(Double answer){
        assertThat(answer).isCloseTo(Double.valueOf(view.getLabel().getText()), Offset.offset(0.00001));
    }

    @Then("displays error {string}")
    public void displaysError(String error){
        assertThat(error).isEqualTo("Cannot calculate result");
    }
}
