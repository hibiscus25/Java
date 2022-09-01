package E_SWING_AWT.E;

import java.awt.*;
import javax.swing.*;

public class E2_BorderLayoutTest extends JFrame {

    public E2_BorderLayoutTest(){
        super("BorderLayoutTest");

        setDefaultCloseOperation( EXIT_ON_CLOSE );
        setSize(250, 250);

        Container container = getContentPane();                 // Панель содержимого
            /**
             *  Размещаем в панели компоненты
             *  В качестве параметров можно использовать
             *  строки и константы класса BorderLayout
             */
            container.add(new JButton("Север" ), "North");
            container.add(new JButton("Юг"    ), "South");
            container.add(new JLabel ("Запад" ), BorderLayout.WEST);
            container.add(new JLabel ("Восток"), BorderLayout.EAST);
            container.add(new JButton("Центр"));         // При отсутствии 2-го параметра компонент размещается в центре

            setVisible(true);                                 // Открываем окно
    }

    public static void main(String[] args) {
        new E2_BorderLayoutTest();
    }
}
