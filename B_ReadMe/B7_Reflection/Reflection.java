package B_ReadMe.B7_Reflection;

import java.lang.reflect.*;
import java.util.ArrayList;

//---------------------------------- рефлексия позволяет заглянуть внутрь класса ---------------------------------------
    interface Rombol{
        String someMethods (String s);
    }


    class superSomeClass{

    }

    class SomeClass extends superSomeClass implements Rombol{
        private static transient int i;
        final boolean Malk = true;
        String solt = "index";
        private int name = 5;

        private int il = 1;
        private final String s = "String S";
        private String s2 = "String S2";

        //------------------------------------------- конструкторы -----------------------------------------------------
            SomeClass(){
            }

            SomeClass (String s){
                this.solt = solt;
            }

            SomeClass (String solt, int i){
                this.solt = solt;
                this.i = i;
            }

        //------------------------------------------------ методы ------------------------------------------------------
        @Override
        public String someMethods(String s){
            System.out.println("this is " + solt);
            return solt;
        }

        private int somePrivate(String solt, int a, int f){
            return a;
        }

        public int somePublic(String solt, int a, int f){
            return a;
        }

        public void setData(String solt, int name, final int il) {
            this.il   = il;
            this.solt = solt;
            this.name = name;
        }

        @Override
        public String toString() {
            return "SomeClass{" +
                    "Malk=" + Malk +
                    ", solt='" + solt + '\'' +
                    ", name=" + name +
                    ", il=" + il +
                    ", s='" + s + '\'' +
                    ", s2='" + s2 + '\'' +
                    '}';
        }
    }



    public class Reflection {
        public static void main(String[] args) throws Exception{
            SomeClass some = new SomeClass();
                // получить объект класса (3 - варианта)
                Class clss  = some.getClass();
                Class clss2 = SomeClass.class;
                Class clss3 = Class.forName("B_ReadMe.B7_Reflection.SomeClass");
                System.out.println(clss.getName());
                System.out.println(clss + "      " + clss2 + "      " + clss3);

                //получить суперкласс
                System.out.println();
                System.out.println("Cуперкласс: " + clss.getSuperclass());

                //получить интерфейсы реализующиеся классом
                System.out.println();
                System.out.println("Интерфейсы: " + clss.getInterfaces());
                    //пример
                        System.out.println();
                        Class<?>   cls = ArrayList.class;
                        Class<?>[] ifs = cls.getInterfaces();
                            System.out.println("List of interfaces: ");
                            for(Class<?> ifc : ifs)
                                System.out.println (" - " + ifc.getName());

                // получить экземпляр класса
                System.out.println();
                System.out.println((SomeClass) clss.newInstance());


                // получаем доступ до конструкторов
                System.out.println();
                System.out.println("CONSTRUCTOR: ");
                Constructor [] constructors = clss.getDeclaredConstructors();
                    for (Constructor el : constructors){
                        System.out.println("- Конструктор: " + el.getName());
                        Parameter[] parameters = el.getParameters();
                        for (Parameter els : parameters){
                            System.out.println(els.getName());
                        }
                    }


                    // получаем доступ до методов
                    System.out.println();
                    System.out.println("METHOD: ");
                    Method[] methods = clss.getDeclaredMethods();
                        for (Method ela : methods){
                            System.out.println("- Метод: " + ela.getName());
                            Parameter[] param = ela.getParameters();
                                for (Parameter els : param){
                                    System.out.println(els.getName());
                                }
                            System.out.println(Modifier.toString(ela.getModifiers()));
                            System.out.println(ela.getReturnType().getName());
                    }

                            // если известно имя метода и типы его параметров, то можно получить отдельный метод класса:
                            System.out.println();
                            Class[] params = new Class[] {String.class, int.class, int.class};        //параметры метода
                            Method method = clss.getMethod("somePublic", params);
                            System.out.println(method);

                            // замена параметров, через метод  setData
                            System.out.println();
                            System.out.println(clss.getMethod("toString").invoke(some));
                                Class<?>[] param = new Class[] {String.class, int.class, int.class};
                                method = clss.getMethod("setData", param);

                                Object[] arg = {"New New", 111111, 222222};
                                method.invoke(some, arg);

                            System.out.println(clss.getMethod("toString").invoke(some));


                    // получаем доступ до полей
                    System.out.println();
                    System.out.println("FIELDS: ");
                    Field[] fields = clss.getDeclaredFields();
                        for (Field el : fields){
                            System.out.println("- Поле: " + el.getName());
                            System.out.println(el.getType().getName());
                            System.out.println(Modifier.toString(el.getModifiers()));

                            if(el.getName().equals("name")) {
                                el.setAccessible(true);                            // открываем доступ до закрытого поля
                                System.out.println(el.getInt(some));
                                el.setInt(some, 5555555);                       // меняем значение приватного поля
                                System.out.println(el.getInt(some));
                            }
                        }

                            //если известно имя метода и типы его параметров, то можно получить отдельный метод класса:
                            System.out.println();
                            Field fld = clss.getDeclaredField("solt");
                            System.out.println(fld);


                            // изменение полей класса
                            System.out.println();
                            String value = (String) fld.get(some);
                            System.out.println(value);
                            fld.set(some, "New value");
                            System.out.println(value + " - " + fld.get(some));

                            //изменение закрытых (private) полей
                                // в примере показано, что можно изменить значение закрытого поля (private), если поле не final
                            System.out.println();
                            System.out.println("0. " + some);
                            Field f = clss.getDeclaredField("il");
                                  f.setAccessible(true);
                                  f.setInt(some, 47);
                            System.out.println("1. " + some);

                                // поле не меняется так как final (при этом исключения не вызывается)
                                // если не открыть доступ к полю setAccessible(true) будет java.lang.IllegalAccessException.
                            f = clss.getDeclaredField("s");
                                  f.setAccessible(true);
                                  f.set(some, "MODIFY S");
                            System.out.println("2. " + some);

                            f = clss.getDeclaredField("s2");
                                  f.setAccessible(true);
                                  f.set(some, "MODIFY S2");
                            System.out.println("3. " + some);
        }
    }


