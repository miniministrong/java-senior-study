package study.thread.多线程.实现线程的第三种方式;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask; // JUC包下的，java的并发包。JDK8新特性

/**
 * 实现线程的第三种方式
 */
public class FutureCallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建一个FutureTask类实现Callable接口
        FutureTask task = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception { // 可以抛出异常，并且call方法相当于run方法，只不过是有返回值的
                System.out.println("call begin");
                Thread.sleep(1000 * 10);
                System.out.println("call over");
                int i = 100;
                int j = 20;
                return i + j;
            }
        });
        // 创建一个线程对象
        Thread t = new Thread(task);
        t.start();
        // 获取t线程的执行结果
        // get方法会导致main方法线程的阻塞，因为get方法是需要等一个线程的执行结果。
        Object obj = task.get();
        System.out.println("线程执行结果：" + obj);

        System.out.println("hello world");
    }
}
