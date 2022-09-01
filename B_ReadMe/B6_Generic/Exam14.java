package B_ReadMe.B6_Generic;

//------------------------------------------ <X extends Cуперкласс & Интерфейс> ----------------------------------------
    interface Gaccoun{
        void showGaccount();
    }

    interface Laccoun{
        void showLaccount();
    }

    //----------------------------------------------------------------------------
    public class Exam14 {
        long id;
        int sum;

        Exam14(long id, int sum){
            this.id = id;
            this.sum = sum;
        }

        void superShow(){
            System.out.println("Cуперкласс");
        }
    }

    //----------------------------------------------------------------------------
    class Trans extends Exam14 implements Gaccoun, Laccoun{
        Exam14 froms;
        Exam14 tos;

        Trans(long id, int sum, Exam14 from, Exam14 to){
            super(id, sum);
            this.froms = from;
            this.tos = to;
        }

        @Override
        public void showGaccount() {
            super.superShow();
            System.out.println("Первый интерфейс");
        }

        @Override
        public void showLaccount(){
            System.out.println("Первый объект суперкласса: " + froms.id + "   " + froms.sum);
            System.out.println("Второй объект суперкласса: " + tos.id + "   " + tos.sum);
        }
    }

    //----------------------------------------------------------------------------
    class TransGen <T extends Exam14 & Gaccoun & Laccoun> {
        T trans;

        TransGen(T trans){
            this.trans = trans;
        }

        public void print(){
            trans.showGaccount();
            trans.showLaccount();
            System.out.println("Конец класса generic");
        }
    }

    //----------------------------------------------------------------------------
    class FinishHelp{
        public static void main(String[] args) {
            Exam14 e1 = new Exam14(35,45);
            Exam14 e2 = new Exam14(55,65);

            TransGen<Trans> gen = new TransGen(new Trans(20, 40, e1, e2));

            gen.print();
        }
    }



