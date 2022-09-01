package A_GROM_lesson.lesson8.account;

public class SavingAccount extends Account {
    int savingPerMonth;

    public SavingAccount(String bankName, String ownerName, int moneyAmount, int savingPerMonth) {
        super(bankName, ownerName, moneyAmount);
        this.savingPerMonth = savingPerMonth;
    }

    void changeOwnerName(String newOwnerName) {
        if (newOwnerName != "Jack" && newOwnerName != "Ann") {
            System.out.println("Sorry,you can`t change owner name of this saving account");
        } else {
            this.ownerName = newOwnerName;
        }

    }
}
