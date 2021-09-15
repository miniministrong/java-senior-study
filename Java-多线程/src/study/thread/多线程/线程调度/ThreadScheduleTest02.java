package study.thread.多线程.线程调度;

/**
 * yield()方法：让位，让当前线程暂停，回到就绪状态
 */
public class ThreadScheduleTest02 {
    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnable2());
        t.setName("t");
        t.start();
        for (int i = 0; i < 10000; i++) {
            System.out.println(Thread.currentThread().getName() + "-->" + i);
        }
    }
}
class MyRunnable2 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            if (i % 100 == 0) {
                Thread.yield();
            }
            System.out.println(Thread.currentThread().getName() + "-->" + i);
        }
    }
}