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
//                .peek(n -> System.out.print(n + ","))
                .collect(Collectors.toList());

        System.out.println("\nGeneric method reference:");
        alphabet.forEach(Streams::printEvrthg);  // Consumer
        printEvrthg("abc");
        printEvrthg(3456);
        printEvrthg(true);
        printEvrthg(null);


        /*Stream.of(2, 3, 0, 1, 3)
                .map(x -> IntStream.range(0, x))
                .forEach(n -> {
                    n.forEach(System.out::print);
                    System.out.println();
                });*/

        /**
         * Tried to use anonymous class and comparator for reversed sort
         */
        Comparator<Character> comparator = new Comparator<Character>() {

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

    }

    /* Method will be changed

    private static void printChar(Object obj) {
        Optional<Object> tempObj = Optional.ofNullable(obj);
        System.out.println("Letter " + tempObj.orElse("nonObject"));
    }
     */

    /**
     * Using Generic
     */
    private static <T> void printEvrthg(T obj) {
        Optional<T> tempObj = Optional.ofNullable(obj);
        System.out.println(tempObj.isPresent() ? ("Letter " + obj) : ("nonObject"));
    }
}
