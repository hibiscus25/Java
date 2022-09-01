package A_GROM_lesson.lesson16;

public class StringUsage {
    public static void main(String[] args){
    //1-вариант создания String
        String test="someString";
        String result=test+"_end";
        System.out.println(result);

    //2-вариант создания String
        char charVariable='t';
        char charVariable1='o';
        char[] chars={charVariable,charVariable1};

    //3-вариант создания String
        String test1=new String(chars);
        System.out.println(test1);

        String test2=new String("hello there");
        System.out.println(test2);

    }
}
