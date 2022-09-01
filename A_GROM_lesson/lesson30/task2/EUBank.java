package A_GROM_lesson.lesson30.task2;

public class EUBank extends Bank {

    public EUBank(long id, String bankCountry, Currency currency, int numberOfEmployee, double avrSalaryOfEmployees, long rating, long totalCapital) {
        super(id, bankCountry, currency, numberOfEmployee, avrSalaryOfEmployees, rating, totalCapital);
    }




    @Override
    //лимит на операции пополнения
    public int getLimitOfFunding() {
        //limit of funding - 20000 if EUR  and 10000 if USD
        if (getCurrency() == Currency.EURO)
            return 20000;
        return 10000;
    }

    @Override
    //лимит на размер снятие
    public int getLimitOfWithdrawal() {
        //limit of = 2000 if currency  is USD and 2200 if currency s EURO
        if (getCurrency() == Currency.USD)
            return 2000;
        return 2200;
    }

    @Override
    //комиссия при пополнении
    public double getMonthlyRate() {
        //montly rate - 0 % with USD  and 1 % with EUR
        if (getCurrency() == Currency.USD)
            return 0;
        return 0.01;
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
