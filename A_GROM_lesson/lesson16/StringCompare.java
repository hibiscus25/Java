package A_GROM_lesson.lesson16;

import java.util.Arrays;

public class StringCompare {
    public static void main(String[] args) {
    //equals()-cравнивает значение, а не ссылки
        System.out.println(new String("abc")==new String("abc"));            //cравнивает ссылки
        System.out.println(new String("abc").equals(new String("abc")));     //сравнивает объекты

        System.out.println("abc"=="abc");
        System.out.println("abc".equals("abc"));

        String s1="test";
        String s2="test";
        String s5=new String("test");
        System.out.println(s1==s2);

        System.out.println(s1==s5);

    //intern()-принудительно переносит в String pool(бассейн)
        String s3=new String("рррр");  //cоздается не в String Pool
        String s4="pppp";                     //cоздается в String Pool

        System.out.println(s3==s4);

        s3=s3.intern();
        System.out.println(s3==s4);

    //getBytes()-переводит String в байты согласно таблицы ASCII Table
        String str="testStringVar";
        System.out.println(Arrays.toString(str.getBytes()));  //из String в байты

        System.out.println(new String(str.getBytes()));       //из байтов в String
    }
}
