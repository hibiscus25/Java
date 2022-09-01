package A_GROM_lesson.lesson8.phone;


public class Demo {
    public Demo() {
    }

    public static void main(String[] args) {
        IPhone iPhone = new IPhone(110, 10.0D, "China", true);
        iPhone.deleteIPhoneFromDb();
        iPhone.orderPhone();
    }
}
