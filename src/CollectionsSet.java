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

        Set<Person> mySet3 = new TreeSet<>((p1, p2) -> p1.getName().compareTo(p2.getName()));
        mySet3.add(new Person("Anton", 33));
        mySet3.add(new Person("Pavel", 27));
        mySet3.add(new Person("Kolian", 28));
        System.out.println("TreeSet:");
        mySet3.forEach(p -> System.out.println(p.getName() + " - " + p.getAge()));
    }
}
