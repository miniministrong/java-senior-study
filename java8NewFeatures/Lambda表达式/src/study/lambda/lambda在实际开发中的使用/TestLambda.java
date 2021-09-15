package study.lambda.lambda在实际开发中的使用;

import org.junit.jupiter.api.Test;
import study.lambda.data.Employee;
import study.lambda.data.FilterEmployeesByAge;
import study.lambda.data.FilterEmployeesBySalary;
import study.lambda.data.MyPredicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestLambda {
    // 准备一组可以在下面的需求中获得数据的数据
    // Arrays.asList()将数组转换为集合
    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99),
            new Employee("李四", 60, 8888.88),
            new Employee("王五", 45, 4500.00),
            new Employee("赵六", 49, 4444.44),
            new Employee("田七", 23, 2222.22),
            new Employee("周八", 30, 3333.00),
            new Employee("武九", 8, 1500.00)
    );
    // 需求：获取当前公司中员工年龄大于35的员工信息
    public List<Employee> filterEmployeesAge(List<Employee> list) {
        List<Employee> employees = new ArrayList<>();
        for (Employee employee : list) {
            if (employee.getAge() >= 35) {
                employees.add(employee);
            }
        }
        return employees;
    }

    @Test
    public void testFilterEmployeesAge(){
        List<Employee> list = filterEmployeesAge(employees);
        for (Employee emp : list) {
            System.out.println(emp);
        }
    }

    // 需求：获取公司中员工工资大于5000的员工信息
    public List<Employee> filterEmployeesSalary(List<Employee> list) {
        List<Employee> employees = new ArrayList<>();
        for (Employee employee : list) {
            if (employee.getSalary() >= 5000) {
                employees.add(employee);
            }
        }
        return employees;
    }

    // 优化方式一：策略设计模式
    public List<Employee> filterEmployee(List<Employee> list, MyPredicate<Employee> predicate) {
        List<Employee> employees = new ArrayList<>();
        
        for (Employee emp : list) {
            if (predicate.test(emp)){
                employees.add(emp);
            }
        }
        return employees;
    }

    @Test
    public void testFilterEmployee(){
        List<Employee> list = filterEmployee(this.employees, new FilterEmployeesByAge());
        
        for (Employee emp : list) {
            System.out.println(emp);
        }

        System.out.println("==============================");

        List<Employee> empSal = filterEmployee(employees, new FilterEmployeesBySalary());
        for (Employee emp : empSal) {
            System.out.println(emp);
        }
    }

    // 优化方式二：匿名内部类
    @Test
    public void testAnAnonymousInnerClass(){
        List<Employee> list = filterEmployee(employees, new MyPredicate<Employee>(){

            @Override
            public boolean test(Employee employee) {
                return employee.getSalary() < 5000;
            }
        });
        for (Employee emp : list) {
            System.out.println(emp);
        }
    }

    // 优化方式三：Lambda表达式
    @Test
    public void testLambda(){
        List<Employee> list = filterEmployee(employees, e -> e.getSalary() >= 5000);
        list.forEach(System.out::println);
    }

    // 优化方式四：Stream API
    @Test
    public void testStream(){
        employees.stream()
                .filter(e -> e.getSalary() >= 5000)
                .limit(2)
                .forEach(System.out::println);

        System.out.println("=========================");

        employees.stream()
                .map(Employee::getName)
                .forEach(System.out::println);
    }
}
