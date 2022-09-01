package A_GROM_lesson.lesson30.task2;

public class User {
    private long id;                    //id-клиента
    private String name;                //имя клиента
    private double balance;             //текущий баланс
    private int monthOfEmployment;      //количество отработанных месяцев
    private String companyName;         //название компании
    private int salary;                 //размер зарплаты
    private Bank bank;                  //банк: USBank | EUBank | ChinaBank

    public User(long id, String name, double balance, int monthOfEmployment, String companyName, int salary, Bank bank) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.monthOfEmployment = monthOfEmployment;
        this.companyName = companyName;
        this.salary = salary;
        this.bank = bank;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public int getMonthOfEmployment() {
        return monthOfEmployment;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getSalary() {
        return salary;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setMonthOfEmployment(int monthOfEmployment) {
        this.monthOfEmployment = monthOfEmployment;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", monthOfEmployment=" + monthOfEmployment +
                ", companyName='" + companyName + '\'' +
                ", salary=" + salary +
                ", bank=" + bank +
                '}';
    }
}
