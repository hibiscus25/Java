package E_SWING_AWT.E;

import javax.swing .*;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;


public class E1_VerticalLayout implements LayoutManager {             // Менеджер вертикального расположения компонентов
        private Dimension size = new Dimension();

        public void addLayoutComponent(String name, Component comp) {            // Следующие два метода не используются
        }

        public void removeLayoutComponent(Component comp) {
        }

        public Dimension minimumLayoutSize(Container c) {       // Метод определения минимального размера для контейнера
            return calculateBestSize(c);
        }


        public Dimension preferredLayoutSize(Container c) {    // Метод определения предпочтительного размера для контейнера
            return calculateBestSize(c);
        }


        public void layoutContainer(Container container) {                // Метод расположения компонентов в контейнере
            Component list[] = container.getComponents();                    // Список компонентов
            int currentY = 5;
            for (int i = 0; i < list.length; i++) {
                Dimension pref = list[i].getPreferredSize();                        // Определение предпочтительного размера компонента
                list[i].setBounds(5, currentY, pref.width, pref.height);         // Размещение компонента на экране
                currentY += 5;                                                      // Учитываем промежуток в 5 пикселов
                currentY += pref.height;                                            // Смещаем вертикальную позицию компонента
            }
        }

        private Dimension calculateBestSize(Container c) {           // Метод вычисления оптимального размера контейнера
            Component[] list = c.getComponents();                                         // Вычисление длины контейнера
            int maxWidth = 0;
            for (int i = 0; i < list.length; i++) {
                int width = list[i].getWidth();
                if (width > maxWidth)                                          // Поиск компонента с максимальной длиной
                    maxWidth = width;
            }
            size.width = maxWidth + 5;                              // Размер контейнера в длину с учетом левого отступа
            int height = 0;                                                              // Вычисление высоты контейнера
            for (int i = 0; i < list.length; i++) {
                height += 5;
                height += list[i].getHeight();
            }
            size.height = height;
            return size;
        }

        public static void main(String[] args) {
            JFrame frame = new JFrame("VerticalLayoutTest");                        // Создаем окно
                frame.setSize(260, 150);                                    // Определяем размеры
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel contents = new JPanel(new E1_VerticalLayout());          // Создаем панель с менеджером вертикального расположения компонентов
                contents.add(new JButton("Продукты"));                // Добавим кнопки и текстовое поле в панель
                contents.add(new JButton("Галантерея"));
                contents.add(new JTextField(20));

            frame.setContentPane(contents);                                             // Размещаем панель в контейнере
            frame.setVisible(true);                                                     // Открываем окно
        }
    }
