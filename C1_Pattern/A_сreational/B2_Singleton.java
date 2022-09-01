package C1_Pattern.A_сreational;

class Singelton{
    int i = 1;                                              // для примера
    static Singelton singelton = new Singelton();

    private Singelton(){

    }

    public static Singelton getInstance(){
        return singelton;
    }
}


// всегда будет создаваться только один объект
public class B2_Singleton {
    public static void main(String[] args) {
        Singelton singelton = Singelton.getInstance();
        Singelton singelton2 = Singelton.getInstance();
        Singelton singelton3 = Singelton.getInstance();
            singelton.i = 5;
            System.out.println(singelton2.i + "   " + singelton3.i);
    }
}


