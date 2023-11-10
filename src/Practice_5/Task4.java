package Practice_5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Task4 extends JFrame {
    private JLabel animationLabel;
    private Timer timer;
    private int currentFrame = 0;
    private int totalFrames = 5;

    public Task4() {
        setTitle("Простая анимация");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon frameIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("frame" + currentFrame + ".png")));
        animationLabel = new JLabel(frameIcon);
        add(animationLabel);

        timer = new Timer(250, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentFrame++;
                if (currentFrame >= totalFrames) {
                    timer.stop();
                }

                ImageIcon newFrameIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("frame" + currentFrame + ".png")));
                animationLabel.setIcon(newFrameIcon);
            }
        });

        timer.start();
        setVisible(true);
    }

    public static void main(String[] args) {
        new Task4();
    }
}
