package E_SWING_AWT.D;

import javax.swing.*;

public class D1_JFrameDecorations {
    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);                                  // Подключение украшений для окон
        JFrame frame = new JFrame("Oкнo с рамкой");                              // Создание окна с рамкой
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                     // Определение способа завершения работы программы
            frame.setSize(200, 200);
            frame.setVisible(true);

        JDialog.setDefaultLookAndFeelDecorated(true);                               // Подключение украшений для окон
        JDialog dialog = new JDialog(frame, "Диалоговое окно");                 // Создание диалогового окна
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);               // Определение способа завершения работы диалогового окна
            dialog.setSize(150, 100);

        dialog.getRootPane().setWindowDecorationStyle(JRootPane.INFORMATION_DIALOG);  // Определение типа оформления диалогового окна
            dialog.setVisible(true);
    }
}
