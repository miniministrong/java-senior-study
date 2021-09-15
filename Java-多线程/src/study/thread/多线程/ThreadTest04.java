package study.thread.多线程;

public class ThreadTest04 {
    public static void main(String[] args) {
        // 创建线程对象，采用匿名内部类的方式
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("t线程-->" + i);
                }
            }
        });
        // 启动线程
        t.start();
        for (int i = 0; i < 100; i++) {
            System.out.println("main线程-->" + i);
        }
    }
}