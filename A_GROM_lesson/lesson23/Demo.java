package A_GROM_lesson.lesson23;

public class Demo {
    public static void main(String[] args) {
        Validator validator1=new Validator("Привет");
        System.out.println(validator1.getCheckCount());

        Validator validator2=new Validator("Гром");
        System.out.println(validator2.getCheckCount());

    }
}
