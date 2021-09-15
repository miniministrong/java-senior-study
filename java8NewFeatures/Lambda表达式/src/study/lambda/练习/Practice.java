package study.lambda.练习;

import org.junit.jupiter.api.Test;
import study.lambda.data.Employee;
import study.lambda.data.MyFun;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class Practice {
    // 需求：对一个数进行运算
    @org.junit.jupiter.api.Test
    public void testOperation(){
        Integer num = operation(100, x -> x * x);
        System.out.println(num);

        System.out.println(operation(200, x -> x + 200));

    }
    public Integer operation(Integer num, MyFun mf){
        return mf.getValue(num);
    }

    // 调用Collection.sort()方法，通过定制排序比较两个Employee（先按年龄比，年龄相同按姓名比），使用Lambda作为参数传递。
    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99),
            new Employee("李四", 60, 8888.88),
            new Employee("王五", 45, 4500.00),
            new Employee("赵六", 49, 4444.44),
            new Employee("田七", 23, 2222.22),
            new Employee("周八", 30, 3333.00),
            new Employee("武九", 8, 1500.00)
    );
    @org.junit.jupiter.api.Test
    public void test2(){
        Collections.sort(employees, (e1, e2) -> {
            if (e1.getAge() == e2.getAge()) {
                return e1.getName().compareTo(e2.getName());
            } else {
                return Integer.compare(e1.getAge(), e2.getAge());
            }
        });
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }

    /**
     * 声明函数式接口，接口中声明抽象方法，public String getValue(String str);
     * 声明类TestLambda，类中编写方法使用接口作为参数，将一个字符串转换成大写，并作为方法的返回值。
     * 再将一个字符串的第2个和第4个索引位置进行截取字符串。
     */
    @Test
    public void test3(){
        System.out.println(strHandler("abcdef", str -> str.toUpperCase()));
        System.out.println(strHandler("abcdef", str -> str.substring(1, 3)));
    }
    public String strHandler(String str, MyFunction mf){
        return mf.getValue(str);
    }

    /**
     * 声明一个带两个泛型的函数式接口，泛型类型为<T,R> T为参数，R为返回值
     * 接口中声明对应抽象方法
     * 在TestLambda类中声明方法，使用接口作为参数，计算两个long型参数的和
     * 再计算两个long型参数的乘积。
     */
    public long longHandler(Long l1, Long l2, function<Long, Long> f) {
        return f.getValue(l1, l2);
    }
    @Test
    public void testLongHandler(){
        System.out.println(longHandler(1L, 2L, (l1, l2) -> l1 + l2));
        System.out.println(longHandler(10L, 13L, (l1, l2) -> l1 * l2));
    }

}
