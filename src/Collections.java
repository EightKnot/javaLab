import java.util.Comparator;
import java.util.HashMap;

public class Collections {
    public static void main(String[] args) {

        HashMap<Object, Object> objectHashMap = new HashMap<>();
        objectHashMap.put(1, new String("ABC"));
        objectHashMap.put("abcd", 'q');
        objectHashMap.put(4.5, true);

        objectHashMap.forEach((o1, o2) -> System.out.println("Key:" + o1 + " Value:" + o2));

    }
}
