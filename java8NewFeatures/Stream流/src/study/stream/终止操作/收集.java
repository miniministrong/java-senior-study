package study.stream.终止操作;

import org.junit.jupiter.api.Test;
import study.stream.Employee;
import study.stream.Status;

import java.util.*;
import java.util.stream.Collectors;

public class 收集 {
    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99, Status.FREE),
            new Employee("李四", 60, 8888.88, Status.BUSY),
            new Employee("王五", 45, 4500.00, Status.VOCATION),
            new Employee("赵六", 49, 4444.44, Status.FREE),
            new Employee("田七", 23, 2222.22, Status.BUSY)
    );
    // 收集到List集合中
    @Test
    public void test1(){
        employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
    // 收集到Set集合中去
    @Test
    public void test2(){
        employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toSet())
                .forEach(System.out::println);
    }
    // 收集到HashSet集合中
    @Test
    public void test3(){
        employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(HashSet::new))
                .forEach(System.out::println);
    }
    // 收集成总数
    @Test
    public void test4(){
        Long collect = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.counting());
        System.out.println(collect);
    }
    // 平均值
    @Test
    public void test5(){
        Double collect = employees.stream()
                .collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(collect);
    }
    // 总和
    @Test
    public void test6(){
        Double collect = employees.stream()
                .collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println(collect);
    }
    // 最大值
    @Test
    public void test7(){
        Optional<Employee> collect = employees.stream()
                .collect(Collectors.maxBy((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())));
        System.out.println(collect.get());
    }
    // 最小值
    @Test
    public void test8(){
        Optional<Double> collect = employees.stream()
                .map(Employee::getSalary)
                .collect(Collectors.minBy(Double::compare));
        System.out.println(collect.get());
    }
    // 按照状态分组
    @Test
    public void test9(){
        Map<Status, List<Employee>> collect = employees.stream()
                .collect(Collectors.groupingBy(Employee::getStatus));
        System.out.println(collect);
    }
    // 多级分组
    @Test
    public void test10(){
        Map<Status, Map<String, List<Employee>>> collect = employees.stream()
                .collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy(e -> {
                    if (((Employee) e).getAge() <= 35) {
                        return "青年";
                    } else if (((Employee) e).getAge() <= 50) {
                        return "中年";
                    } else {
                        return "老年";
                    }
                })));
        System.out.println(collect);
    }
    // 分区
    @Test
    public void test11(){
        Map<Boolean, List<Employee>> map = employees.stream()
                .collect(Collectors.partitioningBy(e -> e.getSalary() > 8000));
        System.out.println(map);
    }
    //
    @Test
    public void test12(){
        DoubleSummaryStatistics dss = employees.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println("最大值：" + dss.getMax());
        System.out.println("最小值：" + dss.getMin());
    }
    // 连接字符串
    @Test
    public void test13(){
        String str = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining());
        System.out.println(str);
    }
}
