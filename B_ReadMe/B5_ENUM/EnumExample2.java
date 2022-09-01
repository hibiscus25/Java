package B_ReadMe.B5_ENUM;

    public class EnumExample2{
        public static void main(String[] args) {
            Level.BEGINNER.setColor("Blue");
                System.out.println(Level.BEGINNER.getColor());
                System.out.println(Level.BEGINNER.toString());
        }
    }

    // учитывая, что enum является обычным классом, можно добавлять дополнительные поля и методы
        enum Level {
            BEGINNER, INTERMEDIATE, EXPERT;

            String color;

            void setColor(String color){
                this.color = color;
            }

            public String getColor(){
                return color;
            }

            @Override
            public String toString(){
                return "Level " + name();
            }
        }


// enum Level на самом деле представляет сокращенную форму следующего класса (написано без учета добавленных полей и методов):
        /*    class Level extends Enum{
                    public static final Level BEGINNER;
                    public static final Level INTERMEDIATE;
                    public static final Level EXPERT;

                    private static final Level[] $VALUES;

                    static{
                        BEGINNER        = new Level("BEGINNER", 0);
                        INTERMEDIATE    = new Level("INTERMEDIATE", 1);
                        EXPERT          = new Level("EXPERT", 2);
                        $VALUES         = (new Level[] {BEGINNER, INTERMEDIATE, EXPERT});
                    }

                    private Level (String s, int i){
                        super (s, i);
                    }

                    public static Level[] values(){
                        return $VALUES. clone();
                    }

                    public static Level valueOf(String s){
                        return (Level) Enum.valueOf(Level, s);      ??????
                    }
                }
         */
