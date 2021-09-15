package study.stream.中间操作;

import org.junit.jupiter.api.Test;
import study.stream.Employee;

import java.util.Arrays;
import java.util.List;

public class 排序 {

    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99),
            new Employee("李四", 60, 8888.88),
            new Employee("王五", 45, 4500.00),
            new Employee("赵六", 49, 4444.44),
            new Employee("田七", 23, 2222.22),
            new Employee("周八", 30, 3333.00),
            new Employee("武九", 8, 1500.00),
            new Employee("武九", 8, 1500.00),
            new Employee("武九", 8, 1500.00)
    );
    // sorted()：自然排序
    @Test
    public void test1(){
        List<String> list = Arrays.asList("bbb", "aaa", "ccc", "eee", "ddd");
        list.stream()
                .sorted()
                .forEach(System.out::println);
    }

    // sorted(Comparator com)：定制排序
    @Test
    public void test2(){
        employees.stream()
                .sorted((e1, e2) -> {
                    if (e1.getAge() == e2.getAge()) {
                        return e1.getName().compareTo(e2.getName());
                    } else {
                        return e1.getAge() + "" .compareTo(e2.getAge() + "");
                    }
                }).forEach(System.out::println);
    }
}
