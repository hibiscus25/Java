package A_GROM_lesson.lesson25;

public class GeneralDAO {

    private void print(Order order) {                                        //не использует дженерик
        System.out.println("order is: " + order.toString());
    }

    public <T extends IdEntity> void validate(T t) throws Exception {        //использует дженерик
        if (t.getId() <= 0)
            throw new Exception(("id can`t be negative"));
    }

    public <K> void validate(K k) {
        if (k.equals(100))
            System.out.println("true");
        else
            System.out.println("false");
    }
}
