import java.util.function.*;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        /*-Functional interfaces-*/
        Predicate<Integer> predicate = x -> x > 5;
        System.out.println(predicate.test(6));   //true

        Consumer<Integer> consumer = x -> System.out.println(x);   //System.out::println;
        consumer.accept(5);

        Function<Integer, String> function = x -> x.toString();   //Object::toString;
        System.out.println(function.apply(5));

        Supplier<String> supplier = () -> new String("A");
        System.out.println(supplier.get());

        UnaryOperator<Integer> unaryOperator = x -> x * x;
        System.out.println(unaryOperator.apply(5));

        BinaryOperator<Integer> binaryOperator = (x, y) -> x * y;
        System.out.println(binaryOperator.apply(5, 5));
    }
}
