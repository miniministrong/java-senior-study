package study.lambda.方法引用;

import org.junit.jupiter.api.Test;
import study.lambda.data.Employee;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.*;

public class TestLambdaRef {
    @Test
    public void test1(){
        PrintStream ps1 = System.out;
        Consumer<String> con = x -> ps1.println(x);

        PrintStream ps = System.out;
        Consumer<String> con1 = ps::println;

        Consumer<String> con2 = System.out::println;
        con2.accept("abcdef");
    }
    @Test
    public void test2(){
        Employee employee = new Employee("张三", 18, 1000);

        Supplier<String> str = () -> employee.getName();
        System.out.println(str.get());

        Supplier<Integer> i = employee::getAge;
        System.out.println(i.get());
    }

    @Test
    public void test3(){
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);

        Comparator<Integer> con = Integer::compare;
    }

    @Test
    public void test4(){
        BiPredicate<String, String> bi = (x, y) -> x.equals(y);

        BiPredicate<String, String> bip = String::equals;
    }

    @Test
    public void test5(){
        Supplier<Employee> sup = () -> new Employee();
        // 构造器引用
        Supplier<Employee> su = Employee::new;
        System.out.println(su.get());
    }

    @Test
    public void test6(){
        Function<Integer, Employee> fun0 = (x) -> new Employee(x);
        Function<Integer, Employee> fun = Employee::new;

        BiFunction<Integer, Integer, Employee> bi0 = (x, y) -> new Employee(x, y);
        BiFunction<Integer, Integer, Employee> bi = Employee::new;
    }

    @Test
    public void test7(){
        Function<Integer, String[]> fun = (x) -> new String[10];
        System.out.println(fun.apply(10).length);

        Function<Integer, String[]> fun1 = String[]::new;
        System.out.println(fun1.apply(20).length);
    }

}
