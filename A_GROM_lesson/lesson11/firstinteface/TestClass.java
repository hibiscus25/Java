package A_GROM_lesson.lesson11.firstinteface;

public class TestClass implements FirstInterface {
    private int test = 10;


    @Override
    public void send() {
        //some logic
    }

    @Override
    public String receive() {
        //some logic
        return null;
    }
}
