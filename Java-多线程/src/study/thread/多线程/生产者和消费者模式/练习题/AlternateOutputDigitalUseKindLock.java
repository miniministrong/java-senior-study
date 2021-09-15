package study.thread.多线程.生产者和消费者模式.练习题;

/**
 * 使用类锁作为安全锁将两个线程的数字交替输出
 */
public class AlternateOutputDigitalUseKindLock {
    public static int count = 0;
    // 创建一个类锁
    public static final Object obj = new Object();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (obj) {
                        if ((count & 1) == 1) {
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println(Thread.currentThread().getName() + "-->" + count++);
                        }
                    }
                }
            }
        },"奇数线程").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (obj) {
                        if ((count & 1) == 0) {
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println(Thread.currentThread().getName() + "-->" + count++);
                        }
                    }
                }
            }
        },"偶数线程").start();
    }
}