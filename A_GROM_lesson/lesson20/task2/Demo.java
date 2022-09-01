package A_GROM_lesson.lesson20.task2;

import java.util.*;

public class Demo {
    public static void main(String[] args) {
        Transaction transaction = new Transaction(01, "Kiev", 100, "debet", TransactionType.INCOME, new Date(171515151515l));
        Transaction transaction1 = new Transaction(02, "Dnipro", 100, "debet", TransactionType.OUTCOME, new Date(171515151515l));
        Transaction transaction2 = new Transaction(03, "Dnipro", 20, "dedet", TransactionType.INCOME, new Date(171515151515l));
        Transaction transaction3 = new Transaction(04, "Kiev", 10, "debet", TransactionType.INCOME, new Date(14848151515l));
        Transaction transaction4 = new Transaction(05, "Odessa", 300, "debet", TransactionType.INCOME, new Date(171515151515l));
        Transaction transaction5 = new Transaction(06, "Moscow", 20, "debet", TransactionType.OUTCOME, new Date(14848151515l));
        Transaction transaction6 = new Transaction(07, "Kiev", 127, "debet", TransactionType.INCOME, new Date(171515151515l));
        Transaction transaction7 = new Transaction(8, "Odessa", 185, "debet", TransactionType.OUTCOME, new Date(14848151515l));
        Transaction transaction8 = new Transaction(9, "Dnipro", 220, "debet", TransactionType.INCOME, new Date(151515151515l));
        Transaction transaction9 = new Transaction(10, "Not city", 195, "debet", TransactionType.OUTCOME, new Date(151515777515l));
        Transaction transaction10 = new Transaction(1515, "Kiev", 700, "debet", TransactionType.INCOME, new Date(14848151515l));
        Transaction transaction11 = new Transaction(4854, "Odessa", 240, "debet", TransactionType.OUTCOME, new Date(171515151515l));
        Transaction transaction12 = new Transaction(8787, "Dnipro", 220, "debet", TransactionType.INCOME, new Date(14848151515l));

        Transaction[] transactions = {transaction, transaction1, transaction2, transaction3, transaction4, transaction5, transaction6, transaction7, transaction8, transaction9, transaction10, transaction11, transaction12};


        Controller controller = new Controller();
        controller.save(transaction);
        System.out.println();
        controller.save(transaction1);
        controller.save(transaction2);
        controller.save(transaction3);
        controller.save(transaction4);
        controller.save(transaction5);
        controller.save(transaction6);

        for (Transaction trans : transactions) {
            controller.save(trans);
        }

        System.out.println(Arrays.toString(controller.transactionList()));
        System.out.println(Arrays.toString(controller.transactionList("Dnipro")));
        System.out.println(Arrays.toString(controller.transactionList(100)));

    }
}
