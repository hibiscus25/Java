package E_SWING_AWT.E;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;

public class E6_GridBagLayoutTest {
    /**
     * Метод определения интерфейса панели @param container
     */
    public static void createPanelUI(Container container){
        JButton button;

        container.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        container.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.HORIZONTAL;       // По умолчанию натуральная высота, максимальная ширина
            constraints.weightx = 0.5;
            constraints.gridy   = 0  ;                              // нулевая ячейка таблицы по вертикали

        button = new JButton("Школа");
            constraints.gridx = 0;                                  // нулевая ячейка таблицы по горизонтали
            container.add(button, constraints);

        button = new JButton("Институт");
            constraints.gridx = 1;                                  // первая ячейка таблицы по горизонтали
            container.add(button, constraints);

        button = new JButton("Академия");
            constraints.gridx = 2;                                  // вторая ячейка таблицы по горизонтали
            container.add(button, constraints);

        button = new JButton("Высокая кнопка размером в 2 ячейки");
            constraints.ipady     = 45;                                                    // кнопка высокая
            constraints.weightx   = 0.0;
            constraints.gridwidth = 2;                                                     // размер кнопки в две ячейки
            constraints.gridx     = 0;                                                     // нулевая ячейка по горизонтали
            constraints.gridy     = 1;                                                     // первая ячейка по вертикали
            container.add(button, constraints);

        button = new JButton("Семья");
            constraints.ipady     = 0;                                                  // установить первоначальный размер кнопки
            constraints.weighty   = 1.0;                                                // установить отступ
            constraints.anchor    = GridBagConstraints.PAGE_END;                        // установить кнопку в конец окна
            constraints.insets    = new Insets(5, 0, 0, 0);      // граница ячейки по Y
            constraints.gridwidth = 2;                                                  // размер кнопки в 2 ячейки
            constraints.gridx     = 1;                                                  // первая ячейка таблицы по горизонтали
            constraints.gridy     = 2;                                                  // вторая ячейка по вертикали
            container.add(button, constraints);
    }

    public static void main(String[] args){
        JFrame frame = new JFrame("GridBagLayoutTest");                             // Создание окна
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createPanelUI(frame.getContentPane());                                           // Определить панель содержания

        frame.pack();                                                                    // Показать окно
        frame.setVisible(true);
    }
}
