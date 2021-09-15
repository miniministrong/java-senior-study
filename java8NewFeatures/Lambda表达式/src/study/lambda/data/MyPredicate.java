package study.lambda.data;

@FunctionalInterface
public interface MyPredicate<T> {
    public boolean test(T t);
}