package study.thread.多线程;

/**
 * 唤醒睡眠的程序：终断线程的睡眠
 */
public class ThreadTest08 {
    public static void main(String[] args) {
        MyRunnable2 run = new MyRunnable2();
        Thread t = new Thread(run);
        t.setName("t");
        t.start();
        try {
            Thread.sleep(1000 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 终断sleep()的执行（这种终断机制依靠了java中的异常处理机制）
        t.interrupt();
    }
}

class MyRunnable2 implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "--> begin");
        // 这里的异常sleep不能被抛出，因为父类中的run方法没有抛出任何异常，而子类重写父类方法无法抛出更多的异常。
        try {
            Thread.sleep(1000 * 60 * 60 * 24 * 365);
        } catch (InterruptedException e) {
            // 如果不想打印信息可以注释掉
            // e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "--> end");
    }
}