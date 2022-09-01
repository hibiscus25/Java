package E_SWING_AWT.B;

import java.awt.Dimension;
import javax.swing.*;


public class B2_JFrameTest {
    public static void createGUI() {
        JFrame frame = new JFrame("B_readMe.Test frame");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setPreferredSize(new Dimension(200, 100));
            frame.pack();
            frame.setVisible(true);

        JLabel label = new JLabel("B_readMe.Test label");
            frame.getContentPane().add(label);
    }

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createGUI();
            }
        });
    }
}
