package A_GROM_lesson.lesson24.firstexample;

public class Main {
    private static void demo(){

        User user=new User(1);
        Solution solution=new Solution("test1");

        Demo<User> demo1=new Demo<>();
        demo1.print(user);
            //    demo.print(solution) - не могу создать

        Demo<Solution> demo2=new Demo<>();
        demo2.print(solution);
    }

    public static void main(String[] args) {
        demo();
    }
}
