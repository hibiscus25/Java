package B_ReadMe.B1_JavaDoc;

/**
 * @author SSSimonenko
 * @version 1.1
 * @since 1.0
 * This is my Main class, here I will write my <strong>code</strong> (описание класса)
 * <img src ="doc-files/java.png" alt="bla"/>
 */
public class ExamJavaDoc {
    /**
     * This is int fields where I will store my values      (описание полей класса)
     */
    int myFields;

    /**
     * This is fields return i          (описание метода)
     * @param i some int value
     * @param s some othere String value
     * @throws RuntimeException if something goes wrong this exception will be throw
     * @return i from params
     */
    int getMyFields(int i, String s) throws RuntimeException{
        return i;
    }

    /**
     * @deprecated  please une newMethod()      (метод не используется)
     */
    void oldMethod(){
    }

    /**
     * This is some description with some link{@link OtherClass#otherMethod()}
     * @see OtherClass#otherMethod()
     * @see "chapter 1"
     */
    void newMethod(){
    }

    /**
     * Here start point of the program
     * @params args command line values
     */
    public static void main(String[] args) {

    }
}
