package C3_BestPractics;

import java.util.Date;



// обязательно нужно документировать
// вызывать в конструкторе метод, который переопределен запрещено
// при клонировании и сериализации конструкторы не запускаются



public class D_Inheritance {
    public static void main(String[] args) {
        Sub sub = new Sub();
        sub.overrideMe();

    }
}

class Super{
    public Super(){
        overrideMe();
    }
    public void overrideMe(){};
}

class Sub extends Super{
    private final Date date;
    public Sub(){
        date = new Date();
    }

    @Override
    public void overrideMe() {
        System.out.println(date);
    }
}