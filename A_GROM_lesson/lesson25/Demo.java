package A_GROM_lesson.lesson25;

public class Demo {
    public static void main(String[] args) throws Exception {
        GeneralDAO generalDAO=new GeneralDAO();

        Order order=new Order(-1);
        generalDAO.validate(order);              //ждет все ссылки на объект - наследники IdEntity

        TestClass<String,Order,Long> testClass=new TestClass<>();
        System.out.println(testClass.doSomething("rrrrrrr"));

        int test=100;
        long variable=111;
        Long variable2=222L;
        Long variable3=new Long(222);

        generalDAO.validate(variable2);
        generalDAO.validate(variable);
        generalDAO.validate(test);    //так как используются дженерики

    }
}