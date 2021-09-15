package study.lambda.lambda;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.function.Consumer;

public class TestLambda {
    // 第一种：无参、无返回值
    @Test
    public void test1(){
        // 原来的方法
        Runnable run = new Runnable() {
            // jdk7之前，需要自己加上final，8之后自动添加final关键字，可以在内部类中调用，但是不能运算，因为是final修饰的
            int num = 0;
            @Override
            public void run() {
                System.out.println("hello world");
            }
        };
        run.run();
        System.out.println("===========================");

        // 使用Lambda表达式
        Runnable runnable = () -> System.out.println("Hello World!");
        runnable.run();
    }

    // 有1个参数、无返回值
    @Test
    public void test2(){
        Consumer<String> consumer = x -> System.out.println(x);
        consumer.accept("此时左侧的x可以加小括号也可以不加");
    }

    // 有2个参数、有返回值，并且要执行多条语句
    @Test
    public void test3(){
        Comparator<Integer> con = (x, y) -> {
            System.out.println("函数式接口");
            return Integer.compare(x, y);
        };
    }

    // 有2个参数、有返回值，只执行一条语句
    @Test
    public void test4(){
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
    }
}
