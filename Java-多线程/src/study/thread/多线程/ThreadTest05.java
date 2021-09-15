package study.thread.多线程;

/**
 * 如果不对我们的线程更改名字，那么线程名字是什么呢？
 *      Thread-0
 *      Thread-1
 */
public class ThreadTest05 {
    public void doSome(){
        // this.getName();
        // super.getName();
        String t = Thread.currentThread().getName();
        System.out.println("---------------------------->" + t);
    }
    public static void main(String[] args) {
        ThreadTest05 t = new ThreadTest05();
        t.doSome();

        // 获取当前线程对象
        Thread currentThread = Thread.currentThread();
        System.out.println(currentThread.getName());    // main方法的线程名就是main

        // 创建线程对象
        MyThread2 t1 = new MyThread2();
        // 设置当前线程的线程名
        t1.setName("t1");
        // 获取当前线程的名字
        String threadName = t1.getName();
        System.out.println(threadName); // 线程名修改了之后，打印出来的线程名也随之修改t1
        t1.start();


        MyThread2 t2 = new MyThread2();
        t2.setName("t2");
        System.out.println(t2.getName());
        t2.start();
    }
}

class MyThread2 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "-->" + i);
            // 以下两种方式在这个类中有用，是因为当前类继承了Thread，而Thread类中正好含义getName()方法
            // 如果在别的方法中使用该方法，是会报错的，但是使用Thread.currentThread().getName()这样不会报错。
            // System.out.println(super.getName() + "-->" + i);
            // System.out.println(this.getName() + "-->" + i);
        }
    }
}