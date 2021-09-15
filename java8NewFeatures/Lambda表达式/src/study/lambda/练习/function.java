package study.lambda.练习;

@FunctionalInterface
public interface function<T,R> {
    public R getValue(T t1, T t2);
}
