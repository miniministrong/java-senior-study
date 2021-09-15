package study.stream.练习;

import org.junit.jupiter.api.Test;
import study.stream.Employee;
import study.stream.Status;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TestStreamAPI {
    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99, Status.FREE),
            new Employee("李四", 60, 8888.88, Status.BUSY),
            new Employee("王五", 45, 4500.00, Status.VOCATION),
            new Employee("赵六", 49, 4444.44, Status.FREE),
            new Employee("田七", 23, 2222.22, Status.BUSY)
    );
    // 给定一个数字列表，如何返回一个由每个数的平方构成的表？给定[1, 2, 3, 4, 5]，应该返回[1, 4, 9, 16, 25]
    @Test
    public void test1(){
        // 准备一个数组来接收我们给定的数字列表
        Integer[] nums = new Integer[]{1, 2, 3, 4, 5};
        Arrays.stream(nums)
                .map(x -> x * x)
                .forEach(System.out::println);
    }
    // 使用map和reduce方法数一数流中有多少个Employee呢？
    @Test
    public void test2(){
        Optional<Integer> reduce = employees.stream()
                .map(e -> 1)
                .reduce(Integer::sum);
        System.out.println(reduce.get());
    }
}
