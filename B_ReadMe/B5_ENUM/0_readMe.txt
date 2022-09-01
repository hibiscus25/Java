
------------------------------------------------ ENUM ------------------------------------------------------------------
    1. Элементы enum  - это статически доступные экземпляры enum-класса.
       Их статическая доступность позволяет выполнять сравнение с помощью оператора сравнения ссылок ==.

    2. Пример использования методов ENUM для извлечения информации об объекте:
            Season season = Season.WINTER;
            System.out.println("season.name() = " + season.name() +                     //  season.name() = WINTER
                               ", season.toString() = " + season.toString() +           //  season.toString() = WINTER
                               ", season.ordinal() = " + season.ordinal());             //  season.ordinal() = 0

            - метод ordinal()                         - возвращает порядковый номер определенной константы (нумерация начинается с 0):
            - public static EnumClass[] values()      - возвращает массив всех констант перечисления
                    - необходимо иметь в виду, что ни метод valueOf(), ни метод values() не определены в классе java.lang.Enum
                    - они автоматически добавляются на этапе компиляции enum-класса.
                          Пример:
                             System.out.println(Arrays.toString(Seasson.values()));        // [WINTER, SPRING, SUMMER, AUTUMN]

    3. Можно добавлять собственные методы как в enum-класс, так и в его элементы:
                        пример1:
                                    enum Direction {
                                            UP, DOWN;
                                            public Direction opposite() {
                                                return this == UP ? DOWN : UP;
                                            }
                                    }

                        пример2 _тоже самое, но с полиморфизмом:
                                    enum Direction {
                                            UP {
                                                public Direction opposite() {
                                                    return DOWN;
                                                }
                                            },
                                            DOWN {
                                                public Direction opposite() {
                                                    return UP;
                                                }
                                            };
                                       public abstract Direction opposite();
                                    }

    4. перечисления, как и обычные классы, могут определять конструкторы, поля и методы.
            пример 1:
                     public class Program{
                         public static void main(String[] args) {
                             System.out.println(Color.RED.getCode());        // #FF0000
                             System.out.println(Color.GREEN.getCode());      // #00FF00
                         }
                     }
                         enum Color{
                             RED("#FF0000"), BLUE("#0000FF"), GREEN("#00FF00");
                             private String code;
                             Color(String code){
                                 this.code = code;
                             }
                             public String getCode(){
                                 return code;
                             }
                         }

         - Перечисление Color определяет приватное поле code для хранения кода цвета, а с помощью метода getCode оно возвращается.
             - через конструктор передается для него значение;
                 -конструктор по умолчанию private (любой другой модификатор будет считаться ошибкой);
                     - поэтому создать константы перечисления с помощью конструктора мы можем только внутри перечисления.

         пример 2:
                 Также можно определять методы для отдельных констант:
                         рublic class Program{
                             public static void main(String[] args) {
                                 Operation op = Operation.SUM;
                                     System.out.println(op.action(10, 4));           // 14
                                 op = Operation.MULTIPLY;
                                     System.out.println(op.action(6, 4));            // 24
                             }
                         }
                             enum Operation{
                                 SUM{
                                     public int action(int x, int y){
                                         return x + y;}
                                 },
                                 SUBTRACT{
                                     public int action(int x, int y){
                                         return x - y;}
                                 },
                                 MULTIPLY{
                                     public int action(int x, int y){
                                         return x * y;}
                                 };

                                  public abstract int action(int x, int y);
                             }

    5. Наследование в ENUM
        С помощью enum в Java можно реализовать иерархию классов, объекты которой создаются в единственном экземпляре
      и доступны статически.
        При этом элементы enum могут содержать собственные конструкторы.

                            enum Type {
                                INT(true) {
                                    public Object parse(String string) {
                                        return Integer.valueOf(string);
                                    }
                                },
                                INTEGER(false) {
                                    public Object parse(String string) {
                                        return Integer.valueOf(string);
                                    }
                                },
                                STRING(false) {
                                    public Object parse(String string) {
                                        return string;
                                    }
                                };

                                boolean primitive;
                                    Type(boolean primitive) {
                                        this.primitive = primitive;
                                    }

                                public boolean isPrimitive() {
                                    return primitive;
                                }

                                public abstract Object parse(String string);
                            }
        Здесь объявляется перечисление Type с тремя элементами INT, INTEGER и STRING.
        Компилятор создаст следующие классы и объекты:
                -   Type    -   класс производный от java.lang.Enum
                -   INT     -   объект 1-го класса производного от Type
                -   INTEGER -   объект 2-го класса производного от Type
                -   STRING  -   объект 3-го класса производного от Type

        Три производных класса будут созданы с полиморфным методом Object parse (String) и конструктором Type (..., boolean).
        При этом объекты классов INT, INTEGER и STRING существуют в единственном экземпляре и доступны статически.

        В этом можно убедиться, выполнив следующий код :
                System.out.println(Type.class);
                System.out.println(Type.INT.getClass() + " " + Type.INT.getClass().getSuperclass());
                System.out.println(Type.INTEGER.getClass() + " " + Type.INTEGER.getClass().getSuperclass());
                System.out.println(Type.STRING.getClass() + " " + Type.STRING .getClass().getSuperclass());

        Результат выполнения кода :
                class Type
                class Type$1 class Type
                class Type$2 class Type
                class Type$3 class Type

        Таким образом, компилятор создал класс Type и 3 nested класса, производных от Type.


    6. Декомпилированный enum-class с наследованием
        В подтверждение вышесказанному можно привести результат декомпиляции перечисления Type из примера выше:

                abstract class Type extends Enum {
                    public static Type[] values() {
                        return (Type[]) $VALUES.clone();
                    }

                    public static Type valueOf(String name) {
                        return (Type) Enum.valueOf(t / T$Type, name);
                    }

                    public boolean isPrimitive() {
                        return primitive;
                    }

                    public abstract Object parse(String s);

                    public static final Type INT;
                    public static final Type INTEGER;
                    public static final Type STRING;
                    boolean primitive;
                    private static final Type $VALUES[];

                    static {
                        INT = new Type("INT", 0, true) {
                            public Object parse(String string) { return Integer.valueOf(string); }
                        };
                        INTEGER = new Type("INTEGER", 1, false) {
                            public Object parse(String string) { return Integer.valueOf(string); }
                        };
                        STRING = new Type("STRING", 2, false) {
                            public Object parse(String string) { return string; }
                        };

                        $VALUES = (new Type[]{
                            INT, INTEGER, STRING
                        });
                    }

                    private Type(String s, int i, boolean primitive) {
                        super(s, i);
                        this.primitive = primitive;
                    }
                }

    7. В Java использование generics в enum запрещено.
                enum Type<T> {}     -        не будет скомпилирован












