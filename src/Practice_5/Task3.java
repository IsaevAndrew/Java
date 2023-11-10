package Practice_5;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Task3 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Task3 <imageFilePath>");
            return;
        }

        String imagePath = args[0];
        File imageFile = new File(imagePath);

        if (!imageFile.exists() || !imageFile.isFile()) {
            System.out.println("Invalid image file path.");
            return;
        }

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Image Viewer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            ImageIcon imageIcon = new ImageIcon(imagePath);
            JLabel label = new JLabel(imageIcon);

            frame.getContentPane().add(label, BorderLayout.CENTER);
            frame.pack();
            frame.setVisible(true);
        });
    }
}
