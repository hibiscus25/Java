package B_ReadMe.B6_Generic;

//------------------------------------ cоздание статического обобщенного метода ----------------------------------------
    public class Exam4 {
        static <X> void show (X arg){
            System.out.println(arg);
        }


        static <X> void show (X[] array){
            System.out.print("|");
            for(X el:array){
                System.out.print(el + " | ");
            }
            System.out.println("");
        }


        static <X>  X getElement (X[] array, int index){
            return array [index];
        }


    public static void main(String[] args) {
        Integer[] nums={1,3,7,2};
        Character[] symbs={'A','B','C','D','Y'};

        // static <X> void show (X arg)
            System.out.println("Вызов метода show()");
            System.out.print("C текстовым аргументом: ");
            show("обобщенный метод");
            System.out.print("C int - аргументом: ");
            show(123);
            System.out.print("C double - аргументом: ");
            show(123.45);
            System.out.print("C char - аргументом: ");
            show('A');

        // static <X> void show (X[] array)
            System.out.print("Целочисленный массив: ");
            show(nums);
            System.out.print("Символьный массив: ");
            show(symbs);

        // static <X>  X getElement (X[] array, int index)
            System.out.println("Вызов метода getElement()");
            System.out.print("Целочисленный массив: *");
            for(int k=0;k<nums.length;k++){
                System.out.print(getElement(nums,k)+"*");
            }
            System.out.print("\nCимвольный массив: *");
            for(int k=0;k<symbs.length;k++){
                System.out.print(getElement(symbs,k)+"*");
            }
            System.out.println("");
        }
    }
