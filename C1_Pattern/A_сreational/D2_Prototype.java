package C1_Pattern.A_сreational;



class Student implements Cloneable {
    @Override
    protected Student clone() throws CloneNotSupportedException {
        return (Student) super.clone();
    }
}

// создаем объект класса и все остальные клонируем на основании его
class Cache{
    private Student student;

    public void setStudent(Student student){
        this.student = student;
    }

    public Student getStudent() throws CloneNotSupportedException{
        return student.clone();
    }
}

public class D2_Prototype {
    public static void main(String[] args) throws CloneNotSupportedException {
        Cache cache = new Cache();
            cache.setStudent(new Student());                        // кладем объект Student в Сache

        Student student = cache.getStudent();                       // достаем клон объекта Student
        Student student1 = cache.getStudent();
            System.out.println(student1 == student);
    }
}
