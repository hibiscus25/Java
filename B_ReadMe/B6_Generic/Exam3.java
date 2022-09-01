package B_ReadMe.B6_Generic;

//---------------------------------------------- обобщенные конструкторы -----------------------------------------------
    public class Exam3 {
        private String id;
        private int sum;

        <T> Exam3(T id, int sum){
            this.id = id.toString();
            this.sum = sum;
        }

        public String getId() {
            return id;
        }
    }

    class Final{
        public static void main(String[] args) {
            Exam3 acc1 = new Exam3("first", 5000);
            Exam3 acc2 = new Exam3(11111, 4000);
                System.out.println(acc1.getId());
                System.out.println(acc2.getId());
        }
    }