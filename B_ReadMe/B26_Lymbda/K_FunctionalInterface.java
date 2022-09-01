package B_ReadMe.B26_Lymbda;

import java.util.Scanner;
import java.util.function.*;
import java.util.function.Function;


public class K_FunctionalInterface {
    public static void main(String[] args) {
        Predicate<Integer> isPositive = x -> x > 3;
            System.out.println(isPositive.test(5));                                 // true
            System.out.println(isPositive.test(-7));                                // false

        BinaryOperator<Integer> multiply = (x, y) -> x * y;
            System.out.println(multiply.apply(3, 5));                           // 15
            System.out.println(multiply.apply(10, -2));                         // -20

        UnaryOperator<Integer> square = x -> x*x;
            System.out.println(square.apply(5));                                   // 25

        Function<Integer, String> convert = k -> String.valueOf(k) + " долларов";
            System.out.println(convert.apply(5));                                 // 5 долларов

        Consumer<Integer> printer = x-> System.out.printf("%d долларов \n", x);
            printer.accept(600);                                                  // 600 долларов


        class Us{
            private String name;

            Us(String n){
                this.name=n;
            }

            String getName(){
                return name;
            }
        }

        Supplier<Us> userFactory = ()->{    Scanner in = new Scanner(System.in);
                                                System.out.println("Введите имя: ");        // Введите имя
                                                String name = in.nextLine();                // коля
                                            return new Us(name);
                                        };
            Us us = userFactory.get();
            System.out.println("Имя user: " + us.getName());                                // Имя user:  коля
    }
}