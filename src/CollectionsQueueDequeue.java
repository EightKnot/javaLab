import java.util.*;

public class CollectionsQueueDequeue {
    public static void main(String[] args) {

        LinkedList<Integer> myQueue = new LinkedList<>();  // LinkedList extends AbstractSequentialList implements List, Queue, Deque
        myQueue.add(1);
        myQueue.add(100);
        myQueue.add(10);
        myQueue.add(10);
        myQueue.offerFirst(1000);
        myQueue.offerLast(2000);
        myQueue.add(0, 3000);
        System.out.println("Dequeue (LinkedList):");
        myQueue.forEach(System.out::println);
    }
}
