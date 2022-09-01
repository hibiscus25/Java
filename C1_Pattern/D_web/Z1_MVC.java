package C1_Pattern.D_web;

// достает данные из модели и через контроллер помещает в представление

class Student{
    String name = "Max";
    int age = 5;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}


//----------------------------------------------------------
interface ModelLayer{
    Student getStudent();
}

class DBLayer implements ModelLayer{                                   // достает данные из БД и создает модель студента
    @Override
    public Student getStudent() {
        return new Student();
    }
}

class FileLayer implements ModelLayer{                                // достает данные из File и создает модель студента
    @Override
    public Student getStudent() {
        return new Student();
    }
}

//----------------------------------------------------------
interface View{
    void showStudent(Student student);
}

class ConsoleView implements View{
    @Override
    public void showStudent(Student student) {
        System.out.println("Student name: " + student.getName() + "\nstudent age: " + student.getAge());
    }
}

class HTMLView implements View{
    @Override
    public void showStudent(Student student) {
        System.out.println("Student name: " + student.getName() + "\nstudent age: " + student.getAge());
    }
}

//----------------------------------------------------------
class Control{
    ModelLayer modelLayer = new DBLayer();
    View view = new ConsoleView();
    void execute(){
        Student student = modelLayer.getStudent();
        view.showStudent(student);
    }
}

//----------------------------------------------------------
public class Z1_MVC {
    public static void main(String[] args) {
        Control controller = new Control();
        controller.execute();
    }
}
