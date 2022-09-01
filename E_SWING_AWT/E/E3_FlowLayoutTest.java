package E_SWING_AWT.E;

import java.awt.*;
import javax.swing.*;

public class E3_FlowLayoutTest extends JFrame {

    public E3_FlowLayoutTest(){
        super("FlowLayout");
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        setSize(300, 120);

        Container container = getContentPane();                          // панель содержимого
                /**
                * Определение последовательного расположения с выравниванием компонентов по центру
                */
                container.setLayout (new FlowLayout(FlowLayout.CENTER));

                container.add( new JButton("Школа"));               // добавляем компоненты
                container.add( new JButton("Институт"));
                container.add( new JButton("Академия"));

                setVisible(true);                                        // открываем окно
    }

    public static void main(String[] args) {
        new E3_FlowLayoutTest();
    }
}
