package study.thread.多线程;

/**
 * 如何安全的终止一个线程
 */
public class ThreadTest10 {
    public static void main(String[] args) {
        MyRunnable4 run = new MyRunnable4();
        Thread t = new Thread(run);
        t.setName("t");
        t.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 给布尔值赋false，表示终止线程
        run.run = false;
    }
}
class MyRunnable4 implements Runnable{
    // 打一个布尔标记
    boolean run = true;
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (run) {
                System.out.println(Thread.currentThread().getName() + "-->" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                // 在这个地方可以执行一些保存数据的操作，之后这个线程就要关闭了。
                return;
            }
        }
    }
}