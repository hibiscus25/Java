package A_GROM_lesson.lesson19;


public class ThrowExample {
    public static void main(String[] args) {
        //test();

        useOfTestMethod();
    }

    private static String[] array = {"text", "soks", "test", "fex"};

    private static void test() throws Exception {
        for (String element : array) {
            if (element == null)
                throw new Exception("null is detected");

        }
        System.out.println("done");
    }

    private static void useOfTestMethod(){
        try {
            //some code
            test();
            //some code
        }catch(Exception e){
            System.out.println("error: "+e.getMessage());
        }
    }
}
