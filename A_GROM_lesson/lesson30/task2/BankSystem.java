package A_GROM_lesson.lesson30.task2;

public interface BankSystem {
    void withdraw(User user, int amount);
    void fund(User user, int amount);
    void transferMoney(User fromUser, User toUser, int amount);
    void paySalary(User user);
}
