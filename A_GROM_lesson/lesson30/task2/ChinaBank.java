package A_GROM_lesson.lesson30.task2;

public class ChinaBank extends Bank {

    public ChinaBank(long id, String bankCountry, Currency currency, int numberOfEmployee, double avrSalaryOfEmployees, long rating, long totalCapital) {
        super(id, bankCountry, currency, numberOfEmployee, avrSalaryOfEmployees, rating, totalCapital);
    }

    @Override
    //лимит на операции пополнения
    public int getLimitOfFunding() {
        //limit of funding - 5000 if EUR  and 10 000 if USD
        if (getCurrency() == Currency.EURO)
            return 5000;
        return 10000;
    }

    @Override
    //лимит на размер снятие
    public int getLimitOfWithdrawal() {
        //limit of withdrawal = 100 if currency is USD and 150 if currency is EURO
        if (getCurrency() == Currency.USD)
            return 100;
        return 150;
    }

    @Override
    //комиссия при пополнении
    public double getMonthlyRate() {
        //montly rate - 1 % with USD  and 0 % with EUR
        if (getCurrency() == Currency.USD)
            return 0.01;
        return 0;
    }

    @Override
    //комиссия при снятии
    public double getCommission(int amount) {
        //commision - 3 % if USD and up to 1000, 5 % if USD and more than 1000
        //10% if EURO and up to 1000 and 11% if EURO and more than 1000
        if (getCurrency() == Currency.USD) {
            if (amount <= 1000)
                return 0.03;
            else
                return 0.05;
        } else {
            if (amount <= 1000)
                return 0.1;
            else
                return 0.11;
        }
    }
}
