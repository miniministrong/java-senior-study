package study.thread.多线程.线程安全之真安全;

public class Account {
    private String no;
    private double balance;

    public Account() {
    }

    public Account(String no, double balance) {
        this.no = no;
        this.balance = balance;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    // 对账户取款
    public void withdraw(double money){
        // 以下这几行代码只有线程排队了，数据才是安全的。
        // 一个线程执行完，才可以让另一个线程进入。
        synchronized (this) {
            double before = this.getBalance();
            double after = before - money;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            setBalance(after);
        }
    }
}