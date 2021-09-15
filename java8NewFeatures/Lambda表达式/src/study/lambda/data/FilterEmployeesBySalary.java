package study.lambda.data;

public class FilterEmployeesBySalary implements MyPredicate<Employee>{
    @Override
    public boolean test(Employee employee) {
        return employee.getSalary() >= 5000;
    }
}
