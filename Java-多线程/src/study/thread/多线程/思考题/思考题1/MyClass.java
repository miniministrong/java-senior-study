package study.thread.多线程.思考题.思考题1;

public class MyClass {
    public synchronized void doSome(){
        System.out.println("doSome begin");
        try {
            Thread.sleep(1000 * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("doSome over");
    }

    public void doOther(){
        System.out.println("doOther begin");
        System.out.println("doOther over");
    }
}
