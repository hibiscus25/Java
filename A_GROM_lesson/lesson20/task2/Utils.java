package A_GROM_lesson.lesson20.task2;

public class Utils {
    private int lLimitSimpleTransactionAmount=250;
    private int limitTransactionsPerDayAmount=700;
    private int limitTransactionsPerDayCount=4;
    private String[] cities = {"Kiev","Odessa","Dnipro","Moscow"};


    public int getlLimitSimpleTransactionAmount() {
        return lLimitSimpleTransactionAmount;
    }

    public int getLimitTransactionsPerDayCount() {
        return limitTransactionsPerDayCount;
    }

    public int getLimitTransactionsPerDayAmount() {
        return limitTransactionsPerDayAmount;
    }

    public String[] getCities() {
        return cities;
    }
}
