package study.lambda.data;

public class FilterEmployeesByAge implements MyPredicate<Employee>{
    @Override
    public boolean test(Employee employee) {
        return employee.getAge() >= 35;
    }
}
