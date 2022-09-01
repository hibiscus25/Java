package F_other;

//--------------------------------------- переопределения Equals -------------------------------------------------------
public class E1_OverloadEquals {
    public static void main(String[] args) {
        TableBook x = new TableBook("one");
        TableBook y = new TableBook("one");
        TableBook z = new TableBook("one");


        //для сравнения всегда должны выполняться следующие условия
             //reflexive
            System.out.println("- reflexive");
            System.out.println(x.equals(x));           // всегда должен быть true
            System.out.println("");

            //symmetric
            System.out.println("- symmetric");
            System.out.println(x.equals(y));           // если x.equals(y)
            System.out.println(y.equals(x));           // тогда должно быть, что y.equals(x)
            System.out.println("");

            //transitive
            System.out.println("- transitive");
            System.out.println(x.equals(y));           // если x.equals(y)
            System.out.println(y.equals(z));           // а y.equals(z)
            System.out.println(x.equals(z));           // тогда x.equals(z)
            System.out.println("");

            //consistent
            System.out.println("- consistent");
            System.out.println(x.equals(y));           // cколько бы раз не вызывали x.equals(y)
            System.out.println(x.equals(y));           // должен всегда возвращать одно значение:  true или false
            System.out.println(x.equals(y));
            System.out.println(x.equals(y));
            System.out.println(x.equals(y));
            System.out.println("");

            //not null
            System.out.println("- not null");
            System.out.println(x.equals(null));        // всегда должен быть false
            System.out.println("");
    }
}

    class TableBook{
        String title;

        public TableBook(String title){
            this.title = title;
        }

        //базовый переопределенный метод
//        @Override
//        public boolean equals(Object o) {
//            if (this == o)                                  // проверка:  один и тот же объект
//                return true;
//
//            if (o == null                                   // проверка:  объект не равен null
//                    ||  getClass() != o.getClass())    // проверка:  совпадают ли классы
//                return false;
//
//            F_other.TableBook tableBook = (F_other.TableBook) o;
//            return title.equals(tableBook.title);
//        }

        // переопределенный метод 1
//        @Override
//        public boolean equals(Object o) {
//            if(o instanceof F_other.TableBook)
//                return o != null && this.title.equals(((F_other.TableBook) o).title);
//            return false;
//        }

        // переопределенный метод 2 - убираем проверку o != null &&, так как
                // System.out.println(null instanceof F_other.TableBook);   - всегда будет false
        @Override
        public boolean equals(Object o) {
            if(o instanceof TableBook)
                return this.title.equals(((TableBook) o).title);
            return false;
        }
    }