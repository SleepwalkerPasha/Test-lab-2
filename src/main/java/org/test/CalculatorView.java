package org.test;

import javax.swing.*;
import java.awt.*;

public class CalculatorView {

    private static final int WINDOW_WIDTH = 800;

    private static final int WINDOW_HEIGHT = 500;

    private static final Font FONT = new Font("Arial", Font.BOLD, 30);

    private final JFrame frame;

    private final JTextField textField;

    private final JButton button;

    private final JLabel label;

    private final JPanel panel;

    public CalculatorView() {
        this.panel = new JPanel();
        this.frame = new JFrame("Calculator");
        this.textField = new JTextField("");
        this.button = new JButton("Calculate");
        this.label = new JLabel("Input expression with 2 values and 1 operation", SwingConstants.CENTER);
    }

    public JTextField getTextField() {
        return textField;
    }

    public JButton getButton() {
        return button;
    }

    public JLabel getLabel() {
        return label;
    }

    public void display(){
        this.frame.setVisible(true);
    }

    public void setup(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.setResizable(false);

        // TextField setup
        textField.setColumns(20);
        textField.setFont(FONT);
        textField.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT / 3));

        // Button setup
        button.setFont(FONT);
        button.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT / 3));

        // Label setup
        label.setFont(FONT);
        label.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT / 3));
        panel.add(textField);
        panel.add(button);
        panel.add(label);
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        panel.setMaximumSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        frame.getContentPane().add(panel);
        frame.setLocationRelativeTo(null);
    }
}
