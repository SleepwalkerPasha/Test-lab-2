package org.test;

import java.awt.event.ActionEvent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.test.CalculatorOperation.*;

public class CalculatorPresenter {

    private final Calculator calculator;

    private final CalculatorView calculatorView;

    public CalculatorPresenter(Calculator calculator, CalculatorView calculatorView) {
        this.calculator = calculator;
        this.calculatorView = calculatorView;
    }

    public void start(){
        calculatorView.setup();
        calculatorView.display();
        calculatorView.getButton().addActionListener(this::onButtonClicked);
    }
    private Pattern pattern = Pattern.compile("(\\d+\\.?\\d*)\\s*([+,\\-,*,/])\\s*(\\d+\\.?\\d*)");

    private Matcher matcher;


    public CalculatorExpression parseExp(String string) throws IllegalArgumentException{
        matcher = pattern.matcher(string);
        if (matcher.matches()){
            try {
                var leftOperand = Double.parseDouble(matcher.group(1));
                var rightOperand = Double.parseDouble(matcher.group(3));
                return switch (matcher.group(2)){
                    case "+" -> new CalculatorExpression(leftOperand, rightOperand, PLUS);
                    case "-" -> new CalculatorExpression(leftOperand, rightOperand, MINUS);
                    case "*" -> new CalculatorExpression(leftOperand, rightOperand, MULTIPLY);
                    case "/" -> new CalculatorExpression(leftOperand, rightOperand, DIVIDE);
                    default -> throw new IllegalArgumentException("Input correct operator");
                };
            }catch (NumberFormatException e){
                throw new IllegalArgumentException("Can't parse values to Double");
            }
        }else {
            throw new IllegalArgumentException("Input correct values and operator");
        }
    }

    public void onButtonClicked(ActionEvent event) {
        var inputText = calculatorView.getTextField().getText();
        try {
            var expression = parseExp(inputText);
            var result = calculator.calculate(expression);
            result.result().ifPresent(value -> calculatorView.getLabel().setText(value.toString()));
            result.errorMessage().ifPresent(value -> calculatorView.getLabel().setText(value));
        }catch (IllegalArgumentException exception){
            calculatorView.getLabel().setText(exception.getMessage());
        }
    }
}
