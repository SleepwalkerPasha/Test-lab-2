package org.test;

public class Main {
    public static void main(String[] args) {
        var view = new CalculatorView();
        var model = new Calculator();
        var presenter = new CalculatorPresenter(model, view);
        presenter.start();
    }
}