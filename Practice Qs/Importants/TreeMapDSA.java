import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.Map;

public class TreeMapDSA {

    // Java has 3 types of Maps: HashMap, LinkedHashMap & TreeMap
    // HashMap - normal order of key-value pairs
    // LinkedHashMap - maintains the order of key-value pair insertion
    // TreeMap - sorts the key value pairs on insertion

    public static void main(String[] args) {
        // HashMap - Random Insertion
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("banana", 2);
        hm.put("apple", 1);
        hm.put("cherry", 3);

        // LinkedHashMap - Random Insertion (maintains insertion order)
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        lhm.put("frog", 6);
        lhm.put("dog", 4);
        lhm.put("elephant", 5);

        // TreeMap - Random Insertion (maintains sorted order automatically)
        TreeMap<String, Integer> tm = new TreeMap<>();
        tm.put("yak", 8);
        tm.put("zebra", 9);
        tm.put("xylophone", 7);

        System.out.println("Printing elements of HashMap: ");
        for (Map.Entry<String, Integer> entry : hm.entrySet()) {
            System.out.print("Key: " + entry.getKey() + " ");
            System.out.print("Value: " + entry.getValue() + " ");
        }

        System.out.println("\nPrinting elements of LinkedHashMap: ");
        for (Map.Entry<String, Integer> entry : lhm.entrySet()) {
            System.out.print("Key: " + entry.getKey() + " ");
            System.out.print("Value: " + entry.getValue() + " ");
        }

        System.out.println("\nPrinting elements of TreeMap: ");
        for (Map.Entry<String, Integer> entry : tm.entrySet()) {
            System.out.print("Key: " + entry.getKey() + " ");
            System.out.print("Value: " + entry.getValue() + " ");
        }
    }
}
