package study.thread.多线程.思考题.思考题2;

/**
 * doOther方法的执行需要等待doSome方法结束吗？
 *      需要，因为doOther有synchronized关键字
 */
public class exam {
    public static void main(String[] args) {
        MyClass mc = new MyClass();
        Thread t1 = new MyThread(mc);
        Thread t2 = new MyThread(mc);
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
