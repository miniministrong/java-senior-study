package study.thread.多线程;

/**
 * 实现线程的第一种方式：继承java.lang.Thread，重写run()方法
 */
public class ThreadTest02 {
    public static void main(String[] args) {
        // 创建线程对象
        MyThread myThread = new MyThread();
        // 而我们如果直接在main方法中调用run方法的话，那么我们就没有创建出新的栈，run方法直接在main方法中执行结束，
        // 才会继续进行下一行代码，跟我们普通的java代码执行顺序是一样的。
        // myThread.run();
        // 启动线程
        // start()方法的作用仅仅是为了开辟出一个分支栈，开辟完栈之后这行代码瞬间结束。
        // 而我们继承了Thread的MyThread类会去自动调用run方法
        // run方法放在分支线程的栈底，而main方法在主栈的栈底，由此可见，run和main是同级的。
        myThread.start();
        // 在main方法中的代码
        for (int i = 0; i < 1000; i++) {
            System.out.println("主线程-->" + i);
        }
    }
}

class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("分支线程-->" + i);
        }
    }
}