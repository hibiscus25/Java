package A_GROM_lesson.lesson10.polyexample;

public class Demo {
    public static void main(String[] args) {
        Human human=new Human("B_readMe.Test");
        run(human);

        System.out.println("");

        User user=new User("Jack");
        run(user);
    }
    private static void run (Human human){
        human.run();
    }
}
