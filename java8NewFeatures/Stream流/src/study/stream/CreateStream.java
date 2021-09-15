package study.stream;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 创建Stream
 */
public class CreateStream {
    // 通过Collection中的stream()或者parallelStream()来创建Stream
    @Test
    public void test1(){
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();
    }

    // 通过Arrays中的静态方法stream()获取数组流
    @Test
    public void test2(){
        Integer[] ints = new Integer[10];
        Stream<Integer> stream = Arrays.stream(ints);
    }

    // 通过Stream类中的静态方法of()
    @Test
    public void test3(){
        Stream<String> stream = Stream.of("abc", "def", "hij", "kli");
    }

    // 创建无限流
    @Test
    public void test4(){
        // 通过迭代的方法
        Stream<Integer> stream = Stream.iterate(0, x -> x + 2);
        // 通过生成的方法
        Stream.generate(() -> Math.random());
    }
}
