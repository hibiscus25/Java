package A_GROM_lesson.lesson8.A_HW;

public class Demo {
    public static Student createHighestParent(String firstName, String lastName, int group, Course[] coursesTaken) {
        Student student = new Student(firstName, lastName, group,coursesTaken);
        return student;
    }

    public static SpecialStudent createLowestChild(String firstName, String lastName, int group, Course[] coursesTaken, long secretKey, String email) {
        SpecialStudent specialStudent = new SpecialStudent(firstName, lastName,group, coursesTaken, secretKey, email);
        return specialStudent;
    }

}
