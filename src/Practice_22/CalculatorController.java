package Practice_22;

import javax.swing.*;
import java.awt.*;
import java.util.EmptyStackException;
import java.util.Stack;

interface View {
    void displayResult(String result);

    void displayException(Exception e);
}

public class CalculatorController extends JFrame {
    private Calculator model;
    private View view;

    public CalculatorController(Calculator model, View view) {
        this.model = model;
        this.view = view;
    }

    public void updateView() {
        view.displayResult(model.getResult());
    }

    public String getResult() {
        return model.getResult();
    }

    public void setResult(String expression) {
        try {
            model.setExpression(expression);
        } catch (EmptyStackException e) {
            view.displayException(e);
            clearDisplay();
        }
    }

    private JTextField display;
    private String currentInput;
    private String returnValue = "";
    private boolean isNewInput;

    public CalculatorController(Calculator model) {
        this.model = model;
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 350);

        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.PLAIN, 32));
        display.setHorizontalAlignment(JTextField.RIGHT);
        add(display, BorderLayout.NORTH);

        JPanel buttonPanel = createButtonPanel();

        add(buttonPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 20, 20));

        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.PLAIN, 18));
            button.addActionListener(e -> returnValue = handleButtonClick(label));
            buttonPanel.add(button);
        }

        return buttonPanel;
    }

    public String handleButtonClick(String label) {
        if (label.equals("=")) {
            isNewInput = true;
            setResult(display.getText());
            display.setText(model.getResult());
        } else {
            display.setText(display.getText() + label);
        }
        return "";
    }

    public void clearDisplay() {
        display.setText("");
    }

    public JTextField getDisplay() {
        return display;
    }

    public String getCurrentInput() {
        return currentInput;
    }

    public void setCurrentInput(String currentInput) {
        this.currentInput = currentInput;
    }

    public String getReturnValue() {
        return returnValue;
    }

    public void setReturnValue(String returnValue) {
        this.returnValue = returnValue;
    }

    public boolean isNewInput() {
        return isNewInput;
    }

    public void setNewInput(boolean isNewInput) {
        this.isNewInput = isNewInput;
    }

    public static void main(String[] args) {
        Calculator model = new Calculator();
        CalculatorController controller = new CalculatorController(model);
    }
}

class Calculator {
    private String expression;

    public String getResult() {
        return expression;
    }

    public void setExpression(String expression) {
        try {
            this.expression = expression;
            calculate();
        } catch (EmptyStackException e) {
            this.expression = "";
            System.out.println("Exception: " + e.toString());
        }
    }

    public static boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')')
            return false;
        return (op1 != '*' && op1 != '/') ||
                (op2 != '+' && op2 != '-');
    }

    private static double applyOp(char op, double b, double a) {
        return switch (op) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> a / b;
            default -> 0;
        };
    }

    private void calculate() {
        try {
            boolean flag = false;
            char[] tokens = expression.toCharArray();
            Stack<Double> values = new Stack<>();
            Stack<Character> ops = new Stack<>();
            for (int i = 0; i < tokens.length; i++) {
                switch (tokens[i]) {
                    case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' -> {
                        StringBuilder s = new StringBuilder();
                        while (i < tokens.length && (tokens[i] >= '0' && tokens[i] <= '9' || tokens[i] == '.')) {
                            s.append(tokens[i++]);
                        }
                        values.push(Double.parseDouble(s.toString()));
                        i--;
                    }
                    case '(' -> ops.push(tokens[i]);
                    case ')' -> {
                        while (ops.peek() != '(') {
                            values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                        }
                        ops.pop();
                    }
                    case '+', '-', '*', '/' -> {
                        while (!ops.empty() && hasPrecedence(tokens[i], ops.peek())) {
                            values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                        }
                        ops.push(tokens[i]);
                    }
                }
            }
            while (!ops.empty() && !flag)
                values.push(applyOp(ops.pop(), values.pop(), values.pop()));

            this.expression = values.pop().toString();
        } catch (Exception e) {
            this.expression = "";
            System.out.println("Exception: " + e.toString());
        }
    }
}

class CalculatorView implements View {
    public void displayResult(String result) {
        System.out.printf("Result: %s\n", result);
    }

    public void displayException(Exception e) {
        System.out.println("Exception: " + e.toString());
    }
}
