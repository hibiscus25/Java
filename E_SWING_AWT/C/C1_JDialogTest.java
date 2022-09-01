package E_SWING_AWT.C;

import javax.swing.*;
import java.awt.event.*;

public class C1_JDialogTest extends JFrame {
    private static final long serialVersionUID = 1L;

    public C1_JDialogTest() {
        super("DialogWindows");

        setDefaultCloseOperation(EXIT_ON_CLOSE);                                      // Выход из программы при закрытии

        JButton button1 = new JButton("Немодальное окно");                  // Кнопки для создания диалоговых окон
            button1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                     JDialog dialog = createDialog("Немодальное", false);
                     dialog.setVisible(true);
                }
            });

        JButton button2 = new JButton("Модальное окно");
            button2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                     JDialog dialog = createDialog("Модальное", true);
                     dialog.setVisible(true);
                }
            });

        JPanel contents = new JPanel();                              // Создание панели содержимого с размещением кнопок
            contents.add(button1);
            contents.add(button2);
            setContentPane(contents);

        setSize(350, 100);                                           // Определение размера и открытие окна
        setVisible(true);
    }


    /**
     * Функция создания диалогового окна.
            * @param title - заголовок окна
            * @param modal - флаг модальности
     */
    private JDialog createDialog(String title, boolean modal) {
        JDialog dialog = new JDialog(this, title, modal);
            dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            dialog.setSize(180, 90);
        return dialog;
    }

    public static void main(String[] args) {
        new C1_JDialogTest();
    }
}
