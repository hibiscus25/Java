package E_SWING_AWT.E;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class E11A_LoginDialog extends JDialog {
    private static final long serialVersionUID = 1L;

    public JTextField tfLogin, tfPassword;
    public JButton btnOk, btnCancel;

    public E11A_LoginDialog(JFrame parent){
            super(parent, "Вход в систему");

            addWindowListener(new WindowAdapter() {               // При выходе из диалогового окна работа заканчивается
                public void windowClosing(WindowEvent we) {
                    dispose();
                    System.exit(0);
                }
            });

            getContentPane().add(createGUI());                                    // добавляем расположение в центр окна
            pack();                                                                    // задаем предпочтительный размер
            setVisible(true);                                                                   // выводим окно на экран
    }

    private JPanel createGUI(){                      // этот метод будет возвращать панель с созданным расположением
            // Создание панели для размещение компонентов
            JPanel panel = E11B_BoxLayoutUtils.createVerticalPanel();

            // Определение отступов от границ ранели. Для этого используем пустую рамку
            panel.setBorder (BorderFactory.createEmptyBorder(12,12,12,12));

            // Создание панели для размещения метки и текстового поля логина
            JPanel name = E11B_BoxLayoutUtils.createHorizontalPanel();
            JLabel nameLabel = new JLabel("Имя:");
            name.add(nameLabel);
            name.add(Box.createHorizontalStrut(12));
            tfLogin = new JTextField(15);
            name.add(tfLogin);

            // Создание панели для размещения метки и текстового поля пароля
            JPanel password = E11B_BoxLayoutUtils.createHorizontalPanel();
            JLabel passwrdLabel = new JLabel("Пароль:");
            password.add(passwrdLabel);
            password.add(Box.createHorizontalStrut(12));
            tfPassword = new JTextField(15);
            password.add(tfPassword);

            // Создание панели для размещения кнопок управления
            JPanel flow = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0) );
            JPanel grid = new JPanel( new GridLayout( 1,2,5,0) );
            btnOk = new JButton("OK");
            btnCancel = new JButton("Отмена");
            grid.add(btnOk    );
            grid.add(btnCancel);
            flow.add(grid);

            // Выравнивание вложенных панелей по горизонтали
            E11B_BoxLayoutUtils.setGroupAlignmentX(new JComponent[] { name, password, panel, flow },
                    Component.LEFT_ALIGNMENT);

            // Выравнивание вложенных панелей по вертикали
            E11B_BoxLayoutUtils.setGroupAlignmentY(new JComponent[] { tfLogin, tfPassword, nameLabel, passwrdLabel},
                    Component.CENTER_ALIGNMENT);

            // Определение размеров надписей к текстовым полям
            E11C_GUITools.makeSameSize(new JComponent[] { nameLabel, passwrdLabel } );
            // Определение стандартного вида для кнопок
            E11C_GUITools.createRecommendedMargin(new JButton[] { btnOk, btnCancel } );
            // Устранение "бесконечной" высоты текстовых полей
            E11C_GUITools.fixTextFieldSize(tfLogin   );
            E11C_GUITools.fixTextFieldSize(tfPassword);

            // Сборка интерфейса
            panel.add(name);
            panel.add(Box.createVerticalStrut(12));
            panel.add(password);
            panel.add(Box.createVerticalStrut(17));
            panel.add(flow);

        return panel;
    }

        public static void main(String[] args){
            new E11A_LoginDialog(new JFrame());
        }
    }
