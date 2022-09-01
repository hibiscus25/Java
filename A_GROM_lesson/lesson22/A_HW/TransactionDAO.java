package A_GROM_lesson.lesson22.A_HW;

import A_GROM_lesson.lesson22.A_HW.exception.BadRequestException;
import A_GROM_lesson.lesson22.A_HW.exception.InternalServerException;
import A_GROM_lesson.lesson22.A_HW.exception.LimitExceeded;

import java.util.*;

public class TransactionDAO {
    private static Transaction[] transactions = new Transaction[10];


    //methods
    //cохранение транзакции
    public static Transaction save(Transaction transaction)  {
        try {
            validate(transaction);
        } catch (LimitExceeded e) {
            System.err.println("Error1: " + e.getMessage());
        } catch (BadRequestException e) {
            System.err.println("Error2: " + e.getMessage());
        } catch (InternalServerException e) {
            System.err.println("Error3: " + e.getMessage());
        }

        for (int i = 0; i < transactions.length; i++) {
            if (transactions[i] == null) {
                transactions[i] = transaction;
                break;
            }
        }

        // System.out.println(Arrays.toString(transactions));
        return transaction;
    }


    //вывести список всех транзакций
    public static Transaction[] transactionList() {

        return transactions;
    }

    //список транзакций по городу
    public static Transaction[] transactionList(String city) {
        int count = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                if (transaction.getCity().equals(city))
                    count++;
            }
        }

        Transaction[] transactionList = new Transaction[count];
        int number = 0;
        for (int i = 0; i < transactions.length; i++) {
            if (transactions[i] != null) {
                if (transactions[i].getCity().equals(city)) {
                    transactionList[number] = transactions[i];
                    number++;
                }
            }
        }
        return transactionList;
    }

    //массив транзакций по сумме
    public static Transaction[] transactionList(int amount) {
        int count = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                if (transaction.getAmount() == amount)
                    count++;
            }
        }

        Transaction[] transactionListAmmount = new Transaction[count];
        int number = 0;
        for (int i = 0; i < transactions.length; i++) {
            if (transactions[i] != null) {
                if (transactions[i].getAmount() == amount) {
                    transactionListAmmount[number] = transactions[i];
                    number++;
                }
            }
        }
        return transactionListAmmount;
    }


    //other method
    private static void validate(Transaction transaction) throws BadRequestException,InternalServerException {

        //cумма транзакции больше указанного лимита
        if (transaction.getAmount() > Utils.getlLimitSimpleTransactionAmount())
            throw new LimitExceeded("Transaction limit exceed " + transaction.getId() + ". Can't be saved");

        //город совершения транзакции не разрешен
        String[] city = Utils.getCities();
        int countPlaced = 0;
        for (int i = 0; i < city.length; i++) {
            countPlaced++;
            if (city[i].equals(transaction.getCity()))
                break;
            else {
                if (countPlaced == city.length)
                    throw new BadRequestException("The city is not in the list  " + transaction.getId() + ". Can't be saved");
            }

        }

        int sum = 0;
        int count = 0;
        for (Transaction tr : getTransactionsPerDay(transaction.getDateCreated())) {
            sum += tr.getAmount();
            count++;
        }

        //сумма транзакций за день больше дневного лимита
        if (sum > Utils.getLimitTransactionsPerDayAmount())
            throw new LimitExceeded("Transaction limit per day amount exceed " + transaction.getId() + ". Can't be saved");

        //количество транзакций за день больше указанного лимита
        if (count > Utils.getLimitTransactionsPerDayCount())
            throw new LimitExceeded("Transaction limit per day count exceed " + transaction.getId() + ". Can't be saved");

        //проверка на заполнение массива
        int countArray = 0;
        for (int i = 0; i < transactions.length; i++) {
            if (transactions[i] != null)
                countArray++;
        }

        if (countArray == transactions.length)
            throw new InternalServerException("Array is full. "+ transaction.getId() + ". Can't be saved");
    }

    private static Transaction[] getTransactionsPerDay(Date dateOfCurTransaction) {
        Calendar calendar = Calendar.getInstance();         //cоздается объект подкласса
        calendar.setTime(dateOfCurTransaction);                     //вбрасываем дату переданную как аргумент
        int month = calendar.get(Calendar.MONTH);                   //определяем месяц
        int day = calendar.get(Calendar.DAY_OF_MONTH);              //определяем день

        int count = 0;
        for (Transaction transaction : transactions) {              //подсчитывается сколько транзакций за указанный период
            if (transaction != null) {
                calendar.setTime(transaction.getDateCreated());     //для каждой транзакции находим месяц и день
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);

                if (trMonth == month && trDay == day)
                    count++;
            }
        }

        Transaction[] result = new Transaction[count];        //создаем массив  транзакций
        int index = 0;
        for (Transaction transaction : transactions) {         //записываем транзакции за указанный период времени
            if (transaction != null) {
                calendar.setTime(transaction.getDateCreated());         //для каждой транзакции находим месяц и день
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);

                if (trMonth == month && trDay == day) {              //заносим данные в массив
                    result[index] = transaction;
                    index++;
                }
            }
        }
        return result;                                      //возвращаем массив транзакций
    }
}
