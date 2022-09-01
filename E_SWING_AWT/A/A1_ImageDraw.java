package E_SWING_AWT.A;

import javax.swing.*;
import java.awt.*;

public class A1_ImageDraw extends JComponent {                 // Класс прорисовки изображения
    private Image capture;

    A1_ImageDraw(Image capture) {
        this.capture = capture;
    }

    public void paintComponent(Graphics g) {
        g.drawImage(capture, 0, 0, this);                      // Прорисовка изображения
    }
}
