package B_ReadMe.B3_StaticBlock;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

    public class StaticBlock5 {
    //a1) cтатические блоки используются, чтобы избежать Exception
                   //если метод выкидывает Exception нельзя его обработать
        //  static int i = getI();
                   // поэтому используют инициализацию, через статический блок
            static int i;

            static int getI() throws FileNotFoundException {
                    InputStream in = new FileInputStream("");
                return 5;
            }

            static {
                try{
                    i = getI();
                }catch (FileNotFoundException e){
                }
            }

    //а2) также используется для инициализации в таком случае
            static int[] array = new int[3];

            static {
                array[0] = 1;
                array[1] = 2;
                array[2] = 3;

            }

    //------------------------------------------------------------------------------------------------------------------
    //б)  пример как работают блоки инициализации
            static {
                argument = 10;
            }

            static int argument = 0;

            static {
                ++argument;
            }
            // в таком случае все преобразуется в такой блок:
                                    //  static int argument = 0;
                                    //  static {
                                    //          argument = 10;
                                    //          argument = 0;
                                    //          ++argument;
                                    //  }

   //------------------------------------------------------------------------------------------------------------------
   // в) нельзя сделать  статическими:
        //       - интерфейсы верхнего уровня       -               static interface Caram{}
        //       - классы верхнего уровня           -               static class Car{ }

        // но можно сделать статическими
        //       - внутренние интерфейсы
        //       - внутренние классы

        static int am;
        int bam;

        static  interface Caram{             // при этом IDEA подсказывает, что static можно не указывать,
            int inter = am;
            //      int inters = bam;            но интерфейс имеет доступ только к статическим полям
        }

        static class Car{                   // класс имеет доступ как до статических полей так и до нестатических полей
            int m = am;
        //  int s = bam;                    //ошибка
            int s = new StaticBlock5().bam;
        }



        public static void main(String[] args) {
            new StaticBlock5();
                System.out.println(argument);
        }
    }
