package study.thread.多线程.线程调度;

/**
 * 线程优先级
 */
public class ThreadScheduleTest01 {
    public static void main(String[] args) {
        // 设置main方法的优先级为最小优先级
        // 两种都可以
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        // Thread.currentThread().setPriority(1);
        // 查看java库中的优先级
        System.out.println("最高优先级：" + Thread.MAX_PRIORITY);
        System.out.println("最低优先级：" + Thread.MIN_PRIORITY);
        System.out.println("默认优先级：" + Thread.NORM_PRIORITY);

        // main方法的优先级
        System.out.println(Thread.currentThread().getName() + "的优先级：" + Thread.currentThread().getPriority());

        Thread t = new Thread(new MyRunnable());
        t.setName("t");
        // 设置当前线程优先级为10
        // t.setPriority(Thread.MAX_PRIORITY);
        t.setPriority(10);
        t.start();

        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + "-->" + i);
        }
    }
}
class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "的优先级是：" + Thread.currentThread().getPriority());
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + "-->" + i);
        }
    }
}