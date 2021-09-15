package study.thread.多线程.思考题.思考题4;

/**
 * doOther方法的执行需要等待doSome方法结束吗？
 *      需要，因为静态方法是类锁，类锁只有1把
 */
public class exam {
    public static void main(String[] args) {
        MyClass mc1 = new MyClass();
        MyClass mc2 = new MyClass();
        Thread t1 = new MyThread(mc1);
        Thread t2 = new MyThread(mc2);
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        try {
            // 为了保证t1先执行
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }
}
