package study.thread.多线程.线程安全之真安全;

public class AccountThread implements Runnable{
    private Account account;

    public AccountThread(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        double money = 5000;
        account.withdraw(money);
        System.out.println(Thread.currentThread().getName() + "对" + account.getNo() + "账户取款成功，剩余余额：" + account.getBalance());
    }
}