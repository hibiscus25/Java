package A_GROM_lesson.lesson17.lesson17D;

public class Solution {
    public static void main(String[] args) {
        String address1 = "http://java.com";
        String address2 = "http://java.com";
        String address3 = "https://www.java.com";
        String address4 = "https://www.java.org";
        String address5 = "http://java.set";
        String address6 = "https://www.java.lom";
        String[] adr = {address1, address2, address3, address4, address5, address6};


        for (int i = 0; i < adr.length; i++) {
            System.out.println(validate(adr[i]));
        }
    }

    public static boolean validate(String address) {
        String[] ad = {"http://", "https://www", "com", "org", "net"};
        String a = address.substring(0, 7);                                     //http://
        String b = address.substring(0, 11);                                    //https://www
        String c = address.substring(address.length() - 3, address.length());  //com","org","net"

        if ((a.equals(ad[0]) || b.equals(ad[1])) && (c.equals(ad[1]) || c.equals(ad[2]) || c.equals(ad[3])))
            return true;

        return false;
    }

}
