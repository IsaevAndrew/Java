package Practice_16;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Task2 extends JFrame {
    private JTextArea textArea;
    private JRadioButtonMenuItem blueItem;
    private JRadioButtonMenuItem redItem;
    private JRadioButtonMenuItem blackItem;
    private JRadioButtonMenuItem timesNewRomanItem;
    private JRadioButtonMenuItem msSansSerifItem;
    private JRadioButtonMenuItem courierNewItem;

    public Task2() {
        setTitle("Простой текстовый редактор");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        textArea = new JTextArea();
        textArea.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu colorMenu = new JMenu("Цвет");
        JMenu fontMenu = new JMenu("Шрифт");

        ButtonGroup colorGroup = new ButtonGroup();
        ButtonGroup fontGroup = new ButtonGroup();

        blueItem = new JRadioButtonMenuItem("Синий");
        redItem = new JRadioButtonMenuItem("Красный");
        blackItem = new JRadioButtonMenuItem("Черный");

        timesNewRomanItem = new JRadioButtonMenuItem("Times New Roman");
        msSansSerifItem = new JRadioButtonMenuItem("MS Sans Serif");
        courierNewItem = new JRadioButtonMenuItem("Courier New");

        colorGroup.add(blueItem);
        colorGroup.add(redItem);
        colorGroup.add(blackItem);

        fontGroup.add(timesNewRomanItem);
        fontGroup.add(msSansSerifItem);
        fontGroup.add(courierNewItem);

        colorMenu.add(blueItem);
        colorMenu.add(redItem);
        colorMenu.add(blackItem);

        fontMenu.add(timesNewRomanItem);
        fontMenu.add(msSansSerifItem);
        fontMenu.add(courierNewItem);

        menuBar.add(colorMenu);
        menuBar.add(fontMenu);

        blueItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setForeground(Color.BLUE);
            }
        });

        redItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setForeground(Color.RED);
            }
        });

        blackItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setForeground(Color.BLACK);
            }
        });

        timesNewRomanItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setFont(new Font("Times New Roman", Font.PLAIN, 14));
            }
        });

        msSansSerifItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setFont(new Font("MS Sans Serif", Font.PLAIN, 14));
            }
        });

        courierNewItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setFont(new Font("Courier New", Font.PLAIN, 14));
            }
        });
        blackItem.setSelected(true);
        timesNewRomanItem.setSelected(true);

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
