package study.thread.多线程;

public class ThreadTest06 {
    public static void main(String[] args) {
        // 让当前线程进入睡眠状态，睡眠5秒
        /*try {
            Thread.sleep(1000 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        // 5s之后执行此处的代码
        // System.out.println("hello world");

        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "-->" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
