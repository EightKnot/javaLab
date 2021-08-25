import java.util.*;

public class CollectionsList {
    public static void main(String[] args) {

        Set<Character> stringSet = Set.of('a', 'c', 'b');

        List<Set<Character>> myList1 = new ArrayList<>();  // Is it a polymorphism?
        myList1.add(stringSet);
        myList1.add(stringSet);
        myList1.add(stringSet);
        //myList1.add(10);
        System.out.println("ArrayList:");
        myList1.forEach(System.out::println);

        System.out.println("--------------------------------");

        List<Character> myList2 = new LinkedList<>(stringSet);
        System.out.println("LinkedList:");
        myList2.forEach(System.out::println);

        System.out.println("Set the element with index 1, method returned: " + myList2.set(1, 'w'));
        myList2.forEach(System.out::println);

        System.out.println("Aster shuffle the list:");
        Collections.shuffle(myList2);
        myList2.forEach(System.out::println);
    }
}
