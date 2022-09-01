package A_GROM_lesson.lesson23;

public final class Validator {
    private String name;
    private final  static int checkCount=10;

    public Validator(String name) {
        this.name = name;
    }

    public final boolean validate(){
        //some logic 1
    return true;}

    public String getName() {
        return name;
    }

    public int getCheckCount() {
        return checkCount;
    }
}
