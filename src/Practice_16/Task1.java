package Practice_16;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Task1 extends JFrame {
    private int secretNumber;
    private int attemptsLeft = 3;
    private JTextField guessField;
    private JButton guessButton;

    public Task1() {
        setTitle("Угадай число");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);

        secretNumber = (int) (Math.random() * 21);
        System.out.println(secretNumber);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel label = new JLabel("Угадай число от 0 до 20:");
        panel.add(label, BorderLayout.NORTH);

        guessField = new JTextField(10);
        panel.add(guessField, BorderLayout.CENTER);

        guessButton = new JButton("Проверить");
        panel.add(guessButton, BorderLayout.SOUTH);

        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkGuess();
            }
        });

        add(panel);

        setVisible(true);
    }

    private void checkGuess() {
        try {
            int userGuess = Integer.parseInt(guessField.getText());

            if (userGuess == secretNumber) {
                JOptionPane.showMessageDialog(this, "Поздравляем! Вы угадали число " + secretNumber + ".", "Победа", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            } else {
                attemptsLeft--;
                String message;

                if (userGuess < secretNumber) {
                    message = "Загаданное число больше. Попробуйте еще раз.";
                } else {
                    message = "Загаданное число меньше. Попробуйте еще раз.";
                }

                if (attemptsLeft > 0) {
                    message += "\nОсталось попыток: " + attemptsLeft;
                } else {
                    message = "Вы исчерпали все попытки. Загаданное число было: " + secretNumber;
                    JOptionPane.showMessageDialog(this, message, "Проигрыш", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }

                JOptionPane.showMessageDialog(this, message, "Неверное число", JOptionPane.WARNING_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Введите целое число.", "Ошибка", JOptionPane.ERROR_MESSAGE);
        }

        guessField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Task1();
            }
        });
    }
}
