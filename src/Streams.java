import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {

        List<String> alphabet = Stream
                .iterate('a', ch -> (char)(ch + 1)).limit(26)
                .peek(n -> System.out.print(n + ","))
                .map(ch -> Character.toString(ch))
                .collect(Collectors.toList());


        System.out.println();
        alphabet.forEach(Streams::printChar);  // Consumer
        printChar(null);


        Stream.of(2, 3, 0, 1, 3)
                .map(x -> IntStream.range(0, x))
                .forEach(n -> {
                    n.forEach(System.out::print);
                    System.out.println();
                });

        Comparator comparator = new Comparator<String>() {

            @Override
            public int compare(String s1, String s2) {
                char[] ch1 = s1.toCharArray();
                char[] ch2 = s2.toCharArray();
                if (ch1[0] > ch2[0]) {
                    return -1;
                } else if (ch1[0] < ch2[0]) {
                    return 1;
                } else {
                    return 0;
                }
            }
        };

        System.out.println("Comparator reverse sort:");
        alphabet.stream()
                .sorted(comparator)
                .forEach(System.out::println);



/*--------------------------------------------------------------*/
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

    private static void printChar(String obj) {
        Optional<Object> tempObj = Optional.ofNullable(obj);
        System.out.println("Letter " + tempObj.orElse("nonObject"));
    }
}
