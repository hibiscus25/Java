package B_ReadMe.B6_Generic;

//-------------------------------------------- <X extends Суперкласс<Тип> ----------------------------------------------
    public class Exam12<T> {
        private T id;
        private int sum;

        Exam12(T id, int sum){
            this.id = id;
            this.sum = sum;
        }

        public T getId() {
            return id;
        }

        public int getSum() {
            return sum;
        }

        public void setSum(int sum) {
            this.sum = sum;
        }
    }


    class Transactions<T extends Exam12<String>>{       //подходит Суперкласс и его наследники с типом String
        private T from;
        private T to;
        private int sum;

        Transactions(T from, T to, int sum){
            this.from = from;
            this.to = to;
            this.sum = sum;
        }

        public void execute(){
            if (from.getSum() > sum){
                from.setSum(from.getSum() - sum);
                to.setSum(to.getSum() + sum);
                System.out.printf("Account %s: %d \nAccount %s: %d \n",
                        from.getId(), from.getSum(),to.getId(), to.getSum());
            }
            else
                System.out.printf("Operation is invalid");
        }
    }


    class Programs{
        public static void main(String[] args) {
            Exam12<String> a1 = new Exam12<String>("1876", 4500);
            Exam12<String> a2 = new Exam12<String>("3476", 1500);

            Transactions<Exam12<String>> t1 = new Transactions<Exam12<String>>(a1,a2, 4000);
            Transactions<Exam12<String>> t2 = new Transactions<Exam12<String>>(a1,a2, 4000);

            t1.execute();
            t2.execute();
        }
    }
