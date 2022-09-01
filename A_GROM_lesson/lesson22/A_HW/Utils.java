package A_GROM_lesson.lesson22.A_HW;

public class Utils {
    private static int lLimitSimpleTransactionAmount=250;
    private static int limitTransactionsPerDayAmount=700;
    private static int limitTransactionsPerDayCount=4;
    private static String[] cities = {"Kiev","Odessa","Dnipro","Moscow"};


    public static int getlLimitSimpleTransactionAmount() {
        return lLimitSimpleTransactionAmount;
    }

    public static int getLimitTransactionsPerDayAmount() {
        return limitTransactionsPerDayAmount;
    }

    public static int getLimitTransactionsPerDayCount() {
        return limitTransactionsPerDayCount;
    }

    public static String[] getCities() {
        return cities;
    }
}
