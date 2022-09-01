package E_SWING_AWT.A;

import javax.swing.*;
import java.awt.*;

public class A2_JWindowTest extends JWindow {
        private Image capture;                                      // изображение "рабочего стола"
        private int window_w = 500, window_h = 500;                 // размер окна

        public A2_JWindowTest() {
            super();

            setLocation(400, 400);                                   // определение положение окна на экране
            setSize (window_w, window_h);                           // определение размера окна

            try {                                                   // "вырезаем" часть изображения "рабочего стола"
                Robot robot = new Robot();
                capture = robot.createScreenCapture(new Rectangle(5, 5, window_w, window_h));
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            getContentPane().add(new A1_ImageDraw(capture));         // добавляем в интерфейс изображение
            setVisible(true);                                        // открываем окно

            try {                                                    // заканчиваем работу через 15 сек
                Thread.currentThread();
                Thread.sleep(10000);
            } catch (Exception e) { }
            System.exit(0);
        }
        
        public static void main(String[] args) {
            new A2_JWindowTest();
        }
    }
