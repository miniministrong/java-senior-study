package study.thread.多线程.线程安全;

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
        // 获取账户原有的存款
        double before = this.getBalance();
        // 计算账户取走剩余的存款
        double after = before - money;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 更新余额
        setBalance(after);
    }
}