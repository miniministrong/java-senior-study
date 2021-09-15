package study.stream.中间操作;

import org.junit.jupiter.api.Test;
import study.stream.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class 映射 {
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

    // map：接收Lambda，将元素转换成其他形式或提取信息。接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
    @Test
    public void test1(){
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee");
        list.stream()
                .map(s -> s.toUpperCase());

        System.out.println("===========================");

        employees.stream()
                .map(Employee::getName);
    }
    // flatMap：接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有的流连接成一个流。
    @Test
    public void test2(){
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee");
        Stream<Stream<Character>> stream = list.stream()
                .map(映射::filterCharacter);
        stream.forEach(characterStream -> {
            characterStream.forEach(System.out::println);
        });

        System.out.println("=========================");

        list.stream()
                .flatMap(映射::filterCharacter)
                .forEach(System.out::println);
    }
    public static Stream<Character> filterCharacter(String str){
        List<Character> list = new ArrayList<>();

        for (Character c : str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }
}
