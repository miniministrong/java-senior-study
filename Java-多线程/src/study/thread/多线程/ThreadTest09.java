package study.thread.多线程;

/**
 * 终止一个线程的执行
 */
public class ThreadTest09 {
    public static void main(String[] args) {
        MyRunnable3 run = new MyRunnable3();
        Thread t = new Thread(run);
        t.setName("t");
        t.start();
        try {
            Thread.sleep(1000 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 已过时，因为相对来说不安全，如果在线程正在执行的时候，突然线程终止，有可能里面的数据会丢失。
        t.stop();
    }
}
class MyRunnable3 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "-->" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}