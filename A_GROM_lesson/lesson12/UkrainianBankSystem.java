package A_GROM_lesson.lesson12;

public class UkrainianBankSystem implements BankSystem {

    @Override
    //cнятие с текущего счета
    public void withdraw(User user, int amount) {
        if (!checkWithdraw(user, amount))
            return;
        user.setBalance(withdrawBalance(user, amount));
    }

    @Override
    //пополнение текущего счета
    public void fund(User user, int amount) {
        if (!fundLimits(user, amount, user.getBank().getLimitOfFunding()))
            return;
        user.setBalance(fundBalance(user, amount));
    }

    @Override
    //оплата зарплаты
    public void paySalary(User user) {
        user.setBalance(fundBalance(user, user.getSalary()));
    }

    @Override
    //перечисление денег от клиента третьему лицу
    public void transferMoney(User fromUser, User toUser, int amount) {
        if (!checkWithdraw(fromUser, amount))
            return;
        if (!fundLimits(toUser, amount, toUser.getBank().getLimitOfFunding()))
            return;

        fromUser.setBalance(withdrawBalance(fromUser, amount));
        toUser.setBalance(fundBalance(toUser, amount));
    }

    //methods for encapsulation
    //сравниваем значение лимита и баланса
    private boolean checkWithdraw(User user, int amount) {
        return checkWithdrawLimits(user, amount, user.getBank().getLimitOfWithdrawal()) &&
                checkWithdrawLimits(user, amount, user.getBalance());
    }

    // проверка суммы + комиссии на лимит (снятие)
    private boolean checkWithdrawLimits(User user, int amount, double limit) {
        if (amount + user.getBank().getCommission(amount) > limit) {
            printwithdrawalErrorMsg(amount, user);
            return false;
        }
        return true;
    }

    // проверка суммы + комиссии на лимит (пополнение)
    private boolean fundLimits(User user, int amount, double limit) {
        if (amount + user.getBank().getMonthlyRate() > limit) {
            System.err.println("Unable to top up money " + amount + "from user" + user.toString());
            return false;
        }
        return true;
    }

    //cнятие со счета за вычетом комиссии
    private double withdrawBalance(User user, int amount) {
        return user.getBalance() - amount - (amount * user.getBank().getCommission(amount));
    }

    //пополнение счета за вычетом комиссии
    private double fundBalance(User user, int amount) {
        return user.getBalance() + amount - (amount * user.getBank().getMonthlyRate());
    }

    //сообщение и выход из системы
    private void printwithdrawalErrorMsg(int amount, User user) {
        System.err.println("Can`t withdraw money " + amount + " from user " + user.toString());
    }
}
