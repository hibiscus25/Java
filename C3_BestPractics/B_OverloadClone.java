package C3_BestPractics;

import java.util.Date;

// клонирование лучше избегать
    // - при клонировании не запускается конструктор
    // - нет возможности работать с final fields
    // - плохо работает с временем создания объекта (Date)

public class B_OverloadClone implements Cloneable{
    int i;
    private Object[] objects;
//    private final Object[] objects;                 // c final клонирование не будет работать
    private Date creationTime;


    public B_OverloadClone() {
        System.out.println("constructor");
    }

    @Override
    protected B_OverloadClone clone() throws CloneNotSupportedException {
        B_OverloadClone result = (B_OverloadClone) super.clone();
        result.objects = this.objects;
        return result;
    }


//    public B_OverloadClone(B_OverloadClone clone) {                  // как выход можно делать таким образом
//        this.i = clone.i;
//        this.objects = clone.objects;
//        creationTime = new Date();
//    }
//
//    @Override
//    protected B_OverloadClone clone() throws CloneNotSupportedException {
//        return (B_OverloadClone) super.clone();
//    }


    public static void main(String[] args) throws CloneNotSupportedException {
        B_OverloadClone clone = new B_OverloadClone();
        B_OverloadClone  myClone = clone.clone();
        System.out.println("Условия, которые должны выполняться при клонировании");
            System.out.println("    - " + (clone != myClone));                             // ссылки не должны быть равны
            System.out.println("    - " + (clone.getClass() == myClone.getClass()));       // классы должны быть равны
            System.out.println("    - " + (clone.equals(myClone)));                        // должны быть равны по equals
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        B_OverloadClone that = (B_OverloadClone) o;
        return i == that.i;
    }
}
