package study.thread.多线程.生产者和消费者模式.练习题;

/**
 * 使用wait和notify交替输出num
 */
public class AlternateOutputDigital {
    public static void main(String[] args) {
        Number number = new Number(0);
        Thread t1 = new Thread(new AnOddNumberThreads(number));
        Thread t2 = new Thread(new EvenThread(number));
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();
    }
}
// 输出奇数线程类
class AnOddNumberThreads implements Runnable{
    private Number number;

    public AnOddNumberThreads(Number number) {
        this.number = number;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (number) {
                if ((number.getNum() % 2) == 1) {
                    try {
                        number.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int num = number.getNum() + 1;
                number.setNum(num);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "-->" + num);
                number.notifyAll();
            }
        }
    }
}

// 输出偶数线程类
class EvenThread implements Runnable {
    private Number number;

    public EvenThread(Number number) {
        this.number = number;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (number) {
                if ((number.getNum() % 2) == 0) {
                    try {
                        number.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int num = number.getNum() + 1;
                number.setNum(num);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "-->" + num);
                number.notifyAll();
            }
        }
    }
}
// 数字类
class Number{
    private int num;

    public Number() {
    }

    public Number(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}