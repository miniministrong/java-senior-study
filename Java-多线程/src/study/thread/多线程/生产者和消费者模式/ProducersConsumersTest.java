package study.thread.多线程.生产者和消费者模式;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用wait方法和notify方法实现“生产者和消费者模式”。
 *
 * 模拟需求：
 * 仓库采用List集合。List集合只能存储1个元素。1个元素就表示满了，如果List集合中元素个数为0，就表示仓库空了。保证List集合中永远都是最多存储1个元素。
 * 必须做到的效果：生产1个消费1个。
 */
public class ProducersConsumersTest {
    public static void main(String[] args) {
        // 创建一个仓库对象
        List list = new ArrayList();
        // 创建两个线程对我们的仓库进行共享
        Thread t1 = new Thread(new Production(list));
        Thread t2 = new Thread(new Consumer(list));
        // 对两个线程修改线程名字
        t1.setName("生产者线程");
        t2.setName("消费者线程");

        t1.start();
        t2.start();
    }
}

// 生产者线程
class Production implements Runnable {
    private List list;
    public Production(List list) {
        this.list = list;
    }
    @Override
    public void run() {
        // 一直生产（这里使用死循环来模拟一直生产的现象）
        while (true) {
            // 由于我们需要对仓库中的货物进行增删操作，那么我们就需要使用synchronized关键字对其进行线程同步
            // 当开始生产的时候，我们不能让他进行消费
            synchronized (list) {
                // 判断：当我们的集合中的数量为0是开始生产
                // 当集合中的元素大于0的时候，表示我们的仓库中有货物，那么我们则需要将仓库中的货物消费完之后，再进行生产
                if (list.size() > 0){
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 程序执行到这里表示我们的仓库空了，集合中数量为0
                // 开始生产
                Object obj = new Object();
                list.add(obj);
                // 输出当前线程生产的货物代码
                System.out.println(Thread.currentThread().getName() + "-->" + obj);
                // 生产完之后需要唤醒消费者进行消费。
                list.notify();
            }
        }
    }
}

// 消费者线程
class Consumer implements Runnable {
    private List list;
    public Consumer(List list) {
        this.list = list;
    }
    @Override
    public void run() {
        // 一直消费（我们在这里使用死循环来表示我们在一直消费）
        while (true) {
            // 消费者与生产者都是要对我们的仓库里面的数据进行操作的，那么我们可能会遇到线程安全问题，因此我们需要使用synchronized关键字对其线程同步。
            synchronized (list) {
                // 判断：当我们集合/仓库中的数量为0时， 我们就需要将消费模式进行暂停。
                if (list.size() == 0){
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 程序执行到这里表示我们仓库中有货物等待消费
                // 此时移除集合中下标为0的数据表示我们已经对其进行消费处理
                Object obj = list.remove(0);
                // 输出当前线程中我们消费的对象
                System.out.println(Thread.currentThread().getName() + "-->" + obj);
                // 我们已经消费完了仓库中的货物，因此此时就需要我们来唤醒生产者进行生产
                list.notify();
            }
        }
    }
}