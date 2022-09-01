package A_GROM_lesson.lesson10.abstractbigexample;

public abstract class Employee {
    private String name;
    private int age;
    private int yearsOfExperience;

    private String curPosition;

    private int salaryPerMonth;
    private BankAccount bankAccount;
    private Company[] companiesWorked = new Company[10];
    private String[] positionsWorked = new String[10];

    abstract void paySalary();
//    {     int newBalance= bankAccount.getBalance()+salaryPerMonth;
//        bankAccount.setBalance(newBalance);}

    void changePosition(String newPosition) {
        //cохранить текущую позицию в истории
        //поменять позицию
        savePositionToHistory();
        curPosition = newPosition;
    }

    private void savePositionToHistory(){
        int index = 0;
        for (String pos : positionsWorked) {
            if (pos == null) {
                positionsWorked[index] = curPosition;
                break;
            }
            index++;
        }
    }

    int getBalance() {
        return bankAccount.getBalance();
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public int getSalaryPerMonth() {
        return salaryPerMonth;
    }

    public String getName() {
        return name;
    }
}
