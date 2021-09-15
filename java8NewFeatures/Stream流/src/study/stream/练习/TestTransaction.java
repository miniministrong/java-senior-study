package study.stream.练习;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestTransaction {
    List<Transaction> transactions = null;

    @BeforeEach
    public void before() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        transactions = Arrays.asList(
                new Transaction(brian, 2011, 3000),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
    }
    // 找出2011年发生的所有交易，并按交易额排序（从低到高）
    @Test
    public void test1(){
        transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted((t1, t2) -> Integer.compare(t1.getValue(), t2.getValue()))
                .forEach(System.out::println);
    }
    // 交易员都在哪些不同的城市工作过？
    @Test
    public void test2(){
        transactions.stream()
                // .map(Transaction::getTrader)
                // .map(Trader::getCity)
                .map(t -> t.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);
    }
    // 查找所有来自剑桥的交易员，并按姓名排序
    @Test
    public void test3(){
        transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .sorted((t1, t2) -> t1.getTrader().getName().compareTo(t2.getTrader().getName()))
                .map(Transaction::getTrader)
                .forEach(System.out::println);
    }
    // 返回所有交易员的姓名字符串，按字母顺序排序
    @Test
    public void test4(){
        transactions.stream()
                .map(t -> t.getTrader().getName())
                .sorted()
                .distinct()
                .forEach(System.out::println);
        System.out.println("================将所有交易员的名字排序之后连接成为一个字符串===============");
        String str = transactions.stream()
                .map(t -> t.getTrader().getName())
                .sorted()
                .distinct()
                .reduce("", String::concat);
        System.out.println(str);
        System.out.println("================将所有交易员的名字连接成为一个字符串之后排序=================");
        transactions.stream()
                .map(t -> t.getTrader().getName())
                .flatMap(TestTransaction::filterCharacter)
                .sorted((s1, s2) -> s1.compareToIgnoreCase(s2))
                .forEach(System.out::print);

    }
    public static Stream<String> filterCharacter(String str){
        List<String> list = new ArrayList<>();
        for (Character c : str.toCharArray()) {
            list.add(c.toString());
        }
        return list.stream();
    }
    // 有没有交易员是在米兰工作的？
    @Test
    public void test5(){
        boolean b = transactions.stream()
                .anyMatch(t -> t.getTrader().getCity().equals("Milan"));
        System.out.println(b);
    }
    // 打印生活在剑桥的交易员的所有交易额
    @Test
    public void test6(){
        Integer sum = transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .collect(Collectors.summingInt(Transaction::getValue));
        System.out.println(sum);
    }
    // 所有交易中，最高的交易额是多少
    @Test
    public void test7(){
        Optional<Integer> max = transactions.stream()
                .map(t -> t.getValue())
                .max(Integer::compare);
        System.out.println(max.get());
    }
    // 找到交易额最小的交易
    @Test
    public void test8(){
        Optional<Transaction> min = transactions.stream()
                .min((t1, t2) -> Integer.compare(t1.getValue(), t2.getValue()));
                // .collect(Collectors.minBy((t1, t2) -> Integer.compare(t1.getValue(), t2.getValue())));
        System.out.println(min.get());
    }
}