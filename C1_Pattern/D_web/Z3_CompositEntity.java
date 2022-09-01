package C1_Pattern.D_web;

class DependentObject1{
    String getData(){
        return "one";
    }
}

class DependentObject2{
    String getData(){
        return "two";
    }
}

//--------------------------------------------------------
class CoarseGainedObject{                                           // объединяем в один
    DependentObject1 dp1 = new DependentObject1();
    DependentObject2 dp2 = new DependentObject2();

    public String[] getData(){
        return new String[]{dp1.getData(), dp2.getData()};
    }
}

//--------------------------------------------------------
class CompositeEntity{                                              // объект, через который будем дергать
    CoarseGainedObject coarseGainedObject = new CoarseGainedObject();

    public String[] getData(){
        return coarseGainedObject.getData();
    }
}

//--------------------------------------------------------
public class Z3_CompositEntity {
    public static void main(String[] args) {
        CompositeEntity comp = new CompositeEntity();
        for(String s : comp.getData())
            System.out.println(s);
    }
}
