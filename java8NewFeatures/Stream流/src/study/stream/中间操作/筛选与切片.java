package study.stream.中间操作;

import org.junit.jupiter.api.Test;
import study.stream.Employee;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


public class 筛选与切片 {
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

    // filter：过滤掉符合条件的数据
    // 内部迭代：迭代操作由Stream API完成
    @Test
    public void test1(){
        // 中间操作：不会执行任何操作
        employees.stream()
                .filter(employee -> {
                    System.out.println("Stream API的中间操作");
                    return employee.getAge() > 35;
                });
    }
    // 外部迭代：自己对数据进行迭代
    @Test
    public void test2(){
        Iterator<Employee> it = employees.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    // limit：取出这些数据的前几个
    // 如果根据条件找到了所有我们所需要的操作，中间操作就不会再去执行，这个操作叫做：短路操作。
    // 短路操作也可以用来提高效率
    @Test
    public void test3(){
        employees.stream()
                .filter(employee -> {
                    System.out.println("短路！");
                    return employee.getSalary() > 5000;
                })
                .limit(1);
    }

    // skip(n)：在我们查找到所有符合条件的数据之后跳过前几个数据
    @Test
    public void test4(){
        employees.stream()
                .filter(employee -> employee.getSalary() < 5000)
                .skip(2);
    }

    // distinct：去除重复元素，必须重写实例类的hashCode和equals方法
    @Test
    public void test5(){
        employees.stream()
                .distinct();
    }
}
