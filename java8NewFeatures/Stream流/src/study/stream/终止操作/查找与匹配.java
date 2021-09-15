package study.stream.终止操作;

import org.junit.jupiter.api.Test;
import study.stream.Employee;
import study.stream.Status;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class 查找与匹配 {
    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99, Status.FREE),
            new Employee("李四", 60, 8888.88, Status.BUSY),
            new Employee("王五", 45, 4500.00, Status.VOCATION),
            new Employee("赵六", 49, 4444.44, Status.FREE),
            new Employee("田七", 23, 2222.22, Status.BUSY)
    );

    // allMatch：检查是否匹配所有元素
    @Test
    public void test1(){
        boolean b = employees.stream()
                .allMatch(employee -> employee.getStatus().equals(Status.FREE));
        System.out.println(b);
    }
    // anyMatch：检查是否至少匹配一个元素
    @Test
    public void test2(){
        boolean b = employees.stream()
                .anyMatch(employee -> employee.getStatus().equals(Status.VOCATION));
        System.out.println(b);
    }

    // noneMatch：检查是否没有匹配所有元素
    @Test
    public void test3(){
        boolean b = employees.stream()
                .noneMatch(employee -> employee.getStatus().equals(Status.FREE));
        System.out.println(b);
    }
    // findFirst：返回第一个元素
    @Test
    public void test4(){
        Optional<Employee> op = employees.stream()
                .sorted((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
                .findFirst();
        System.out.println(op.get());
    }
    // findAny：返回当前流中的任意元素
    @Test
    public void test5(){
        Optional<Employee> op = employees.stream()
                .filter(employee -> employee.getStatus().equals(Status.FREE))
                .findAny();
        System.out.println(op.get());
    }
    // count：返回流中元素的总个数
    @Test
    public void test6(){
        long count = employees.stream()
                .count();
        System.out.println(count);
    }
    // max：返回流中最大值
    @Test
    public void test7(){
        Optional<Employee> max = employees.stream()
                .max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(max);
    }
    // min：返回流中最小值
    @Test
    public void test8(){
        Optional<Double> min = employees.stream()
                .map(Employee::getSalary)
                .min((Double::compare));
        System.out.println(min);
    }
}
