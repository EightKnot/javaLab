import javax.lang.model.UnknownEntityException;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {

        List<Character> alphabet = Stream
                .iterate('a', ch -> (char)(ch + 1)).limit(26)
                .peek(n -> System.out.print(n + ","))
                .collect(Collectors.toList());


        System.out.println("\nGeneric method reference:");
        alphabet.forEach(Streams::printChar);  // Consumer
        printChar("abc");
        printChar(3456);
        printChar(true);
        printChar(null);


        Stream.of(2, 3, 0, 1, 3)
                .map(x -> IntStream.range(0, x))
                .forEach(n -> {
                    n.forEach(System.out::print);
                    System.out.println();
                });

        /**
         * Tried to use anonymous class and comparator for reversed sort
         */
        Comparator comparator = new Comparator<Character>() {

            @Override
            public int compare(Character ch1, Character ch2) {
                if (ch1 > ch2) {
                    return -1;
                } else if (ch1 < ch2) {
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

    /* Method to change
    
    private static void printChar(Object obj) {
        Optional<Object> tempObj = Optional.ofNullable(obj);
        System.out.println("Letter " + tempObj.orElse("nonObject"));
    }
     */

    /**
     * Using Generic
     */
    private static <T> void printChar(T obj) {
        Optional<T> tempObj = Optional.ofNullable(obj);
        System.out.println(tempObj.isPresent() ? ("Letter " + obj) : ("nonObject"));
    }
}
