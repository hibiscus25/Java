package B_ReadMe.B5_ENUM;

import java.util.Arrays;

enum CoffeSize {
    SMALL(100, "A"){
        public CoffeSize opposite() {
            return MEDIUM;
        }
        public int action(int x, int y){
            return x + y;
        }
    },
    MEDIUM (200, "B"){
        public CoffeSize opposite() {
            return BIG;
        }
        public int action(int x, int y){
            return x - y;
        }
    },
    BIG(300, "B"){
        public CoffeSize opposite() {
            return SMALL;
        }
        public int action(int x, int y){
            return x * y;
        }
    };

    int milliliters;
    String coffeClass;

    CoffeSize(int milliliters, String coffeClass){
        this.milliliters = milliliters;
        this.coffeClass = coffeClass;
    }

    int getMilliliters(){
        return milliliters;
    }

    String getCoffeClass(){
        return coffeClass;
    }

    public abstract CoffeSize opposite();
    public abstract int action(int x, int y);
}


class EnumExample {
    public static void main(String[] args) {
        // выводим весь массив ENUM
        System.out.println(Arrays.toString(CoffeSize.values()));

        System.out.println("--------------------------------------------------------");
        // выводим значение BIG  и значение его переменных
        CoffeSize coffeSize = CoffeSize.BIG;
        System.out.println(coffeSize.name() + "   "  + coffeSize.toString() + "   "  + coffeSize.ordinal());
        System.out.println(coffeSize.getMilliliters());
        System.out.println(coffeSize.getCoffeClass());

        System.out.println("--------------------------------------------------------");
        // выводим значение переменных SMALL
        CoffeSize coffeSize2 = CoffeSize.SMALL;
        System.out.println(coffeSize2.getMilliliters());
        System.out.println(coffeSize2.getCoffeClass());

        System.out.println("--------------------------------------------------------");
        // с помощью полиморфизма работаем с методом opposite()
        System.out.println(CoffeSize.SMALL.opposite());
        System.out.println(CoffeSize.MEDIUM.opposite());
        System.out.println(CoffeSize.BIG.opposite());

        System.out.println("--------------------------------------------------------");
        // с помощью полиморфизма работаем с методом action()
        System.out.println(CoffeSize.SMALL.action(5,3));
        System.out.println(CoffeSize.MEDIUM.action(5,3));
        System.out.println(CoffeSize.BIG.action(5,3));
    }
}

