package A_GROM_lesson.lesson8.account;

public class Account {
    String bankName;
    String ownerName;
    int moneyAmount;

    public Account(String bankName, String ownerName, int moneyAmount) {
        this.bankName = bankName;
        this.ownerName = ownerName;
        this.moneyAmount = moneyAmount;
    }

    void depositMoney(int amount) {
        this.moneyAmount += amount;
    }

    void depositMoney() {
        this.moneyAmount += 1000;
        System.out.println("deposit was successful");
    }

    void changeOwnerName(String newOwnerName) {
        this.ownerName = newOwnerName;
    }
}
