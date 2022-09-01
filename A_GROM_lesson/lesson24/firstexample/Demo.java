package A_GROM_lesson.lesson24.firstexample;

public class Demo<T> {

//  private printUser(User user){
//     //print
//  }

//  private printSolution(Solution solution) {
//     //print
//  }

//  private printChannel(Channel channel){
        //print
//  }

    public void print(T t){
        System.out.println(t);
    }


//    private static void calculatePrice(FirstOrder firstOrder) {
//        System.out.println(firstOrder.getPrice());
//    }
//
//    private static void calculatePrice(SecondOrder secondOrder) {
//        System.out.println(secondOrder.getPrice());
//    }

    private static void calculatePrice(AbstractOrder abstractOrder) {
        System.out.println(abstractOrder.getPrice());
    }


    public static void main(String[] args) {
        calculatePrice(new FirstOrder());
        calculatePrice(new SecondOrder());
    }
}


