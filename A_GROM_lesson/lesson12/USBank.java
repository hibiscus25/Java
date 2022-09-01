package A_GROM_lesson.lesson12;

public class USBank extends Bank {

    public USBank(long id, String bankCountry, Currency currency, int numberOfEmployee, double avrSalaryOfEmployees, long rating, long totalCapital) {
        super(id, bankCountry, currency, numberOfEmployee, avrSalaryOfEmployees, rating, totalCapital);
    }

    @Override
    //лимит на операции пополнения
    public int getLimitOfFunding() {
    //limit of funding - 10000 if EURO and no limit USD
        if (getCurrency() == Currency.EURO)
            return 10000;
        return Integer.MAX_VALUE;
    }

    @Override
    //лимит на размер снятие
    public int getLimitOfWithdrawal() {
        //limit of withdrawal = 1000 if currency is USD and 1200 if currency is EUR
        if(getCurrency() == Currency.USD)
            return 1000;
        return 1200;
    }

    @Override
    //комиссия при пополнении
    public double getMonthlyRate() {
    //monthly rate-1% with USD and 2% with EURO
        if (getCurrency() == Currency.EURO)
            return 0.02;
        else
            return 0.01;
    }

    @Override
    //комиссия при снятии
    public double getCommission(int amount) {
    //comision - 5 % if USD and up to 1000, 7 % if USD and more than 1000
    //6% if EURO and up to 1000 and 8% if EURO and more than 1000
        if (getCurrency() == Currency.USD){
            if(amount<=1000)
                return 0.05;
            else
                return 0.07;
        }
        else {
            if(amount<=1000)
                return 0.06;
            else
                return 0.08;
        }
    }
}
