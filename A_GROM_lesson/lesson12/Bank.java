package A_GROM_lesson.lesson12;

public abstract class Bank {
    private long id;
    String bankCountry;
    private Currency currency;
    private int numberOfEmployee;
    private double avrSalaryOfEmployees;
    private long rating;
    private long totalCapital;

    public Bank(long id, String bankCountry, Currency currency, int numberOfEmployee, double avrSalaryOfEmployees, long rating, long totalCapital) {
        this.id = id;
        this.bankCountry = bankCountry;
        this.currency = currency;
        this.numberOfEmployee = numberOfEmployee;
        this.avrSalaryOfEmployees = avrSalaryOfEmployees;
        this.rating = rating;
        this.totalCapital = totalCapital;
    }

    public abstract int getLimitOfFunding();
    public abstract int getLimitOfWithdrawal();
    public abstract double getMonthlyRate();
    public abstract double getCommission(int amount);

    public double moneyPaidMonthlyForSalary(){
        return numberOfEmployee*avrSalaryOfEmployees;}

    public long getId() {
        return id;
    }

    public String getBankCountry() {
        return bankCountry;
    }

    public Currency getCurrency() {
        return currency;
    }

    public int getNumberOfEmployee() {
        return numberOfEmployee;
    }

    public double getAvrSalaryOfEmployees() {
        return avrSalaryOfEmployees;
    }

    public long getRating() {
        return rating;
    }

    public long getTotalCapital() {
        return totalCapital;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setBankCountry(String bankCountry) {
        this.bankCountry = bankCountry;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public void setNumberOfEmployee(int numberOfEmployee) {
        this.numberOfEmployee = numberOfEmployee;
    }

    public void setAvrSalaryOfEmployees(double avrSalaryOfEmployees) {
        this.avrSalaryOfEmployees = avrSalaryOfEmployees;
    }

    public void setRating(long rating) {
        this.rating = rating;
    }

    public void setTotalCapital(long totalCapital) {
        this.totalCapital = totalCapital;
    }
}
