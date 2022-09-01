package A_GROM_lesson.lesson17.lesson17A;

public class Solutions {
    public static void main(String[] args) {
        String input="Oracle corporate citizenship efforts are steadfast clear and effective";
        System.out.println(countWords(input));
    }

    public static int countWords(String input){
        String[] ints=input.split(" ");
    return ints.length;
    }
}
