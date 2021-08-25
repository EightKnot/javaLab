import java.util.*;

public class CollectionsSet {
    public static void main(String[] args) {

        Set<Integer> mySet1 = new HashSet<>();
        mySet1.add(1);
        mySet1.add(100);
        mySet1.add(10);
        mySet1.add(10);
        System.out.println("HashSet:");
        mySet1.forEach(System.out::println);

        System.out.println("--------------------------------");

        Set<Integer> mySet2 = new LinkedHashSet<>(mySet1);
        mySet2.add(10);
        System.out.println("LinkedHashSet:");
        mySet2.forEach(System.out::println);

        System.out.println("--------------------------------");

        Set<Integer> mySet3 = new TreeSet<>(mySet1);
        mySet3.add(10);
        System.out.println("TreeSet:");
        mySet3.forEach(System.out::println);
    }
}
