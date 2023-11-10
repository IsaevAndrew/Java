package Practice_15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Calculator extends JFrame {
    private JTextField display;
    private double currentValue;
    private String currentOperator;
    private boolean newInput;

    public Calculator() {
        setTitle("Калькулятор");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);

        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.PLAIN, 32));
        display.setHorizontalAlignment(JTextField.RIGHT);
        add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4));

        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.PLAIN, 18));
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    onButtonClick(label);
                }
            });
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private void onButtonClick(String label) {
        if (label.matches("[0-9]+") || label.equals(".")) {
            if (newInput) {
                display.setText("");
                newInput = false;
            }
            display.setText(display.getText() + label);
        } else if (label.equals("=")) {
            calculate();
            newInput = true;
        } else if (label.matches("[+\\-*/]")) {
            if (!newInput) {
                calculate();
            }
            currentOperator = label;
            currentValue = Double.parseDouble(display.getText());
            newInput = true;
        }
    }

    private void calculate() {
        if (currentOperator != null) {
            double secondValue = Double.parseDouble(display.getText());
            switch (currentOperator) {
                case "+":
                    currentValue += secondValue;
                    break;
                case "-":
                    currentValue -= secondValue;
                    break;
                case "*":
                    currentValue *= secondValue;
                    break;
                case "/":
                    if (secondValue != 0) {
                        currentValue /= secondValue;
                    } else {
                        JOptionPane.showMessageDialog(this, "Деление на ноль недопустимо.", "Ошибка", JOptionPane.ERROR_MESSAGE);
                        currentValue = 0;
                    }
                    break;
            }
            display.setText(String.valueOf(currentValue));
            currentOperator = null;
        }
    }
}

public class Task4 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Calculator();
            }
        });
    }
}
