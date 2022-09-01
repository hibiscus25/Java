package B_ReadMe.B29_Многопоточность;

import javax.swing.*;
import java.awt.*;

/*    Кроме блокировок (deadlock и livelock) есть ещё  — Starvation "голодание"
            - от блокировок это явление отличается тем, что потоки не заблокированы,
              а им просто не хватает ресурсов на всех.
            - поэтому пока одни потоки на себя берут всё время выполнения, другие не могут выполниться:
 */


    public class G3_Starvation {
        private static Object sharedObj = new Object();

        private static JFrame createFrame () {                                  // создаем окно
            JFrame frame = new JFrame("Starvation Demo");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setSize(new Dimension(300, 200));
            return frame;
        }

        private static class ProgressThread extends Thread {
            JProgressBar progressBar;

            ProgressThread () {
                progressBar = new JProgressBar();
                    progressBar.setString(this.getName());
                    progressBar.setStringPainted(true);
            }

            JComponent getProgressComponent () {
                return progressBar;
            }

            @Override
            public void run () {
                int c = 0;

                while (true) {
                    synchronized (sharedObj) {
                        if (c == 100)
                            c = 0;
                        progressBar.setValue(++c);
                        // try имитирует длинную задачу с ожиданием....
                        try {
                                // поток засыпает и не дает другим потокам выполнять работу
//                            Thread.sleep(100);
                                // снятие блокировки для длительной задачи дает возможность запустить другие потоки
                            sharedObj.wait(100);
                        } catch (InterruptedException e) {}
                    }
                    System.out.println(getName() + "   " + c);
                }
            }
        }

        public static void main (String[] args) {
            JFrame frame = createFrame();
                frame.setLayout(new FlowLayout(FlowLayout.LEFT));

            for (int i = 0; i < 5; i++) {
                ProgressThread progressThread = new ProgressThread();
                    frame.add(progressThread.getProgressComponent());
                    progressThread.start();
            }

            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }
    }
