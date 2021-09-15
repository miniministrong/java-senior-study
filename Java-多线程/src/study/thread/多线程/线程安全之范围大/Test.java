package study.thread.多线程.线程安全之范围大;

/**
 * 使用线程同步机制，解决线程安全问题
 */
public class Test {
    public static void main(String[] args) {
        AccountThread act_01 = new AccountThread(new Account("act-01", 10000.0));
        Thread t1 = new Thread(act_01);
        Thread t2 = new Thread(act_01);
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();
    }
}