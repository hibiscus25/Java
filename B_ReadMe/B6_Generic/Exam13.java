package B_ReadMe.B6_Generic;

//---------------------------------------------- <X extends Интерфейс> -------------------------------------------------
    interface Gaccountable{
        String getId();
        int getSum();
        void setSum(int sum);
    }


    public class Exam13 implements Gaccountable{
        private String id;
        private int sum;

        Exam13(String id, int sum){
            this.id = id;
            this.sum = sum;
        }

        public String getId() {
            return id;
        }

        public int getSum() {
            return sum;
        }

        public void setSum(int sum) {
            this.sum = sum;
        }
    }


    class Transactionss<T extends Gaccountable>{             //подходит класс имплементирующий интерфейс Gaccountable
        private T from;
        private T to;
        private int sum;

        Transactionss(T from, T to, int sum){
            this.from = from;
            this.to = to;
            this.sum = sum;
        }

        public void execute(){
            if (from.getSum() > sum){
                from.setSum(from.getSum() - sum);
                to.setSum(to.getSum() + sum);
                System.out.printf("Account %s: %d \nAccount %s: %d \n", from.getId(), from.getSum(),to.getId(), to.getSum());
            }
            else
                System.out.printf("Operation is invalid");

            }
        }


        class Programa{
            public static void main(String[] args) {
                Exam13 a1 = new Exam13("1235rwr", 5000);
                Exam13 a2 = new Exam13("2373", 4300);

                Transactionss<Exam13> t1 = new Transactionss<Exam13>(a1, a2, 1560);
                t1.execute();
            }
        }
