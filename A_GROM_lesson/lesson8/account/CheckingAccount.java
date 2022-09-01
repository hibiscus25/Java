package A_GROM_lesson.lesson8.account;

public class CheckingAccount extends Account {
    int limitOFExpenses;

    public CheckingAccount(String bankName, String ownerName, int moneyAmount, int limitOFExpenses) {
        super(bankName, ownerName, moneyAmount);
        this.limitOFExpenses = limitOFExpenses;
    }

    void withdraw(int amount) {
        if (amount <= this.limitOFExpenses) {
            this.moneyAmount -= amount;
        }
    }
}
