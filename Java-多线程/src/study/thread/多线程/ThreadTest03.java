package study.thread.多线程;

/**
 * 实现线程的第二种方式：创建一个类去实现Runnable接口
 */
public class ThreadTest03 {
    public static void main(String[] args) {
        // 创建一个可运行的类
        MyRunnable runnable = new MyRunnable();
        // 使用Thread类的构造方法将这个可运行的类传进去
        Thread thread = new Thread(runnable);
        // 启动线程
        thread.start();
        for (int i = 0; i < 100; i++) {
            System.out.println("主线程-->" + i);
        }
    }
}

// 可运行的类，不是一个线程类，他不能创建线程
class MyRunnable implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("分支线程-->" + i);
        }
    }
}