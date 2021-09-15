package study.thread.多线程.思考题.思考题1;

public class MyThread extends Thread{
    private MyClass myClass;

    public MyThread(MyClass myClass) {
        this.myClass = myClass;
    }

    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("t1")){
            myClass.doSome();
        }
        if (Thread.currentThread().getName().equals("t2")){
            myClass.doOther();
        }
    }
}
