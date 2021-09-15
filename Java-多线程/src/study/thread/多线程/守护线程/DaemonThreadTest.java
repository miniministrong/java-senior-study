package study.thread.多线程.守护线程;

public class DaemonThreadTest {
    public static void main(String[] args) {
        Thread t = new BackDataThread();
        t.setName("备份数据的线程");
        // 如果要设置成守护线程，那么就得在线程开启之前将该线程设置为守护线程
        t.setDaemon(true);

        t.start();

        // 主线程
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "-->" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class BackDataThread extends Thread{
    @Override
    public void run() {
        int i = 0;
        while (true) {
            System.out.println(Thread.currentThread().getName() + "-->" + ++i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}