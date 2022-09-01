package E_SWING_AWT.E;

import java.awt.*;
import javax.swing.*;

public class E4_GridLayoutTest extends JFrame {

    public E4_GridLayoutTest(){
        super("GridLayoutTest");
        setSize(320, 320);
        setLocation(100, 100);
        setDefaultCloseOperation( EXIT_ON_CLOSE );

        JPanel grid = new JPanel();                                 // Вспомогательная панель
        /**
         * Первые два параметра конструктора GridLayout определяют количество строк и столбцов в таблице
         * Вторые 2 параметра - расстояние между ячейками по горизонтали и вертикали
         */
        GridLayout layout = new GridLayout(2, 0, 5, 12);
            grid.setLayout(layout);

        for (int i = 0; i < 8; i++) {                              // Создаем 8 кнопок
            grid.add(new JButton("Кнопка " + i));
        }

        getContentPane().add(grid);                               // Размещаем нашу панель в панели содержимого
        pack();                                                   // Устанавливаем оптимальный размер окна
        setVisible(true);                                         // Открываем окно
    }

    public static void main(String[] args) {
        new E4_GridLayoutTest();
    }
}
