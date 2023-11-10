package Practice_15;

import javax.swing.*;
import java.awt.*;
public class Task2 extends JFrame {
    private JComboBox<String> menuComboBox;
    public Task2() {
        setTitle("Выбор меню");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        JPanel menuPanel = new JPanel();
        menuComboBox = new JComboBox<>();
        menuComboBox.addItem("Australia");
        menuComboBox.addItem("China");
        menuComboBox.addItem("England");
        menuComboBox.addItem("Russia");
        menuPanel.add(menuComboBox);
        setLayout(new BorderLayout());
        add(menuPanel, BorderLayout.NORTH);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Task2();
            }
        });
    }
}