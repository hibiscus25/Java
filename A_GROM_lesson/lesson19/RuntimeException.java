package A_GROM_lesson.lesson19;

public class RuntimeException {
    public static void main(String[] args) {
        //arithmetic exception
        arithmeticException(2);

        try {
            arithmeticException(0);
        } catch (ArithmeticException e) {
            System.out.println("something wrong");
        }

        npe(new Object());
        npe(null);
    }

    private static void arithmeticException(int a) {
        System.out.println(10 / a);
    }

    private static void npe(Object object) {
        if (object != null) {
            System.out.println(object.hashCode());
        }
    }
}
