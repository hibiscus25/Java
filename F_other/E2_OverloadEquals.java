package F_other;


// нельзя  сравнивать  parent - child
public class E2_OverloadEquals {
    int x;

    @Override
    public boolean equals(Object obj) {
        if(obj == null || obj.getClass() != getClass())
            return false;
        E2_OverloadEquals el = (E2_OverloadEquals) obj;
        return x == el.x;
    }

    public static void main(String[] args) {
        System.out.println(new E2_OverloadEquals().equals(new EqualsSub()));        // parent - child
        System.out.println(new EqualsSub().equals(new E2_OverloadEquals()));        // child  - parent
        EqualsSub elSub = new EqualsSub();
            elSub.y = 5;
        System.out.println(new EqualsSub().equals(elSub));                          // child  - NewChild
        System.out.println(new E2_OverloadEquals().equals(elSub));                  // parent - NewChild
    }
}


class EqualsSub extends E1_OverloadEquals{
    int y;

    @Override
    public boolean equals(Object obj) {
        if(obj == null || obj.getClass() != getClass())
            return false;
        return super.equals(obj) && y == ((EqualsSub)obj).y;
    }
}