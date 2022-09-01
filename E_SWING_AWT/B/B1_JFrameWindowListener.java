package E_SWING_AWT.B;

import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class B1_JFrameWindowListener extends JFrame {
    private static final long serialVersionUID = 1L;
    private static int    counter = 0;                                      // счетчик
    private static JLabel label   = null;
    private static String TEMPL   = "Закрытие окна (попыток %d)";

    public B1_JFrameWindowListener () {
      JFrame frame = new JFrame("JFrameWindowListener");               // cоздание окна с заголовком
         frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);        // не закрывать окно по нажатию на кнопку с крестиком
         frame.addWindowListener(new WindowListener() {                     // подключение слушателя окна
                public void windowActivated  (WindowEvent event) {}
                public void windowClosed     (WindowEvent event) {}
                public void windowDeactivated(WindowEvent event) {}
                public void windowDeiconified(WindowEvent event) {}
                public void windowIconified  (WindowEvent event) {}
                public void windowOpened     (WindowEvent event) {}

                public void windowClosing (WindowEvent event) {             // метод обработки события "Закрытие окна"
                    if (++counter == 3) {
                        event.getWindow().setVisible(false);
                        System.exit(0);
                    } else
                        label.setText(String.format(TEMPL, counter));
                }
         });

         label = new JLabel(String.format(TEMPL, counter));
            frame.getContentPane().add(label);

            frame.setPreferredSize(new Dimension(250, 250));
            frame.pack();
            frame.setVisible(true);
    }

    public static void main(String[] args) {
         JFrame.setDefaultLookAndFeelDecorated(true);
         new B1_JFrameWindowListener();
    }
}
