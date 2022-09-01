package E_SWING_AWT.E;

import java.awt.*;
import javax.swing.*;

public class E5_ManagerLayoutsTest extends JFrame {

    public E5_ManagerLayoutsTest() {
        super("ManagerLayoutsTest");

        setSize(320, 240);
        setLocation(100, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel grid = new JPanel(new GridLayout(1, 2, 5, 0));       // Создание панели с табличным расположением
            grid.add(new JButton("OK"));                                             // Добавление кнопок в панель
            grid.add(new JButton("Отмена"));

                        // Создание панели с последовательным расположением  компонентов и выравниванием по правому краю
        JPanel flow = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            flow.add(grid);

        Container container = getContentPane();                                          // Получение панели содержимого
            container.add(flow, BorderLayout.SOUTH);                        // Размещение панели с кнопками внизу справа

        setVisible(true);
    }

    public static void main(String[] args) {
        new E5_ManagerLayoutsTest();
    }
}