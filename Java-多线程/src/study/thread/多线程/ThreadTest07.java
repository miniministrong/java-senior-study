package study.thread.多线程;

/**
 * t.sleep()会让哪个线程进入睡眠状态？
 */
public class ThreadTest07 {
    public static void main(String[] args) {
        Thread t = new MyThread3();
        t.setName("t");
        t.start();

        try {
            // 下面这行代码会不会让我们的t线程睡眠5s呢？不会
            // 因为我们的sleep()方法是静态方法，如果你用对象去调用sleep()方法的话，那么他还是会变成Thread.sleep()
            // 因此主程序main方法会睡眠5秒
            t.sleep(1000 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("hello world");
    }
}

class MyThread3 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println(Thread.currentThread().getName() + "-->" + i);
        }
    }
}