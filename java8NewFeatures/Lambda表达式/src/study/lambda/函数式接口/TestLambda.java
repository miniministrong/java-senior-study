package study.lambda.函数式接口;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TestLambda {
    // Consumer<T>：消费型接口（有去无回）
    public void eat(double money, Consumer<Double> con) {
        con.accept(money);
    }
    @Test
    public void testEat(){
        eat(100.00, x -> System.out.println("吃饭共计花费" + x + "元"));
    }

    // Supplier<T>：供给型接口
    // 需求：将指定类型的整数传入集合中
    public List<Integer> intToList(int numberOf, Supplier<Integer> sup) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numberOf; i++) {
            list.add(sup.get());
        }
        return list;
    }
    @Test
    public void testIntToList(){
        List<Integer> list = intToList(10, () -> (int) (Math.random() * 100));
        for (Integer in : list) {
            System.out.println(in);
        }
    }

    // Function<T, R>：函数型接口
    // 需求：用于处理字符串
    public String toStr(String s, Function<String, String> f){
        return f.apply(s);
    }
    @Test
    public void testToStr(){
        System.out.println(toStr("abcdefgh", x -> x.substring(1)));
    }

    // Predicate<T>：断言型接口
    // 需求：将满足条件的字符串放入集合中去
    @Test
    public void testPredicate(){
        List<String> strings = Arrays.asList("hello", "world", "lambda", "java");
        List<String> list = filterStr(strings, s -> s.endsWith("a"));
        for (String s : list) {
            System.out.println(s);
        }
    }
    public List<String> filterStr(List<String> list, Predicate<String> pre) {
        List<String> strList = new ArrayList<>();
        for (String s : list) {
            if (pre.test(s)) {
                strList.add(s);
            }
        }
        return strList;
    }
}
