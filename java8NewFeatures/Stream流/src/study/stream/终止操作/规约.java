package study.stream.终止操作;

import org.junit.jupiter.api.Test;
import study.stream.Employee;
import study.stream.Status;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class 规约 {
    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99, Status.FREE),
            new Employee("李四", 60, 8888.88, Status.BUSY),
            new Employee("王五", 45, 4500.00, Status.VOCATION),
            new Employee("赵六", 49, 4444.44, Status.FREE),
            new Employee("田七", 23, 2222.22, Status.BUSY)
    );
    // reduce(T identity, BinaryOperator) / reduce(BinaryOperator)：可以将流中元素反复结合起来，得到一个值
    @Test
    public void test1(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sum = list.stream()
                .reduce(0, (x, y) -> x + y);
        System.out.println(sum);

        System.out.println("=========================");
        Optional<Double> op = employees.stream()
                .map(Employee::getSalary)
                .reduce(Double::sum);
        System.out.println(op.get());
    }
}
