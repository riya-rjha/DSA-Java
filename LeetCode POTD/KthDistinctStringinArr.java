import java.util.LinkedHashMap;
import java.util.Map;

public class KthDistinctStringinArr {

    // Given an array of strings
    // you have to return the string which occurs only once
    // return the first possible string

    public String kthDistinct(String[] arr, int k) {
        LinkedHashMap<String, Integer> hm = new LinkedHashMap<>();
        for (int i = 0; i < arr.length; i++) {
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1); // update for every entry
        }

        int count = 0;
        for (Map.Entry<String, Integer> entry : hm.entrySet()) {
            String key = entry.getKey();
            int val = entry.getValue();
            if (val == 1) {
                count++;
            }
            if(count == k){
                return key;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String arr[] = { "aaa","aa","a" };
        int k = 1;
        KthDistinctStringinArr abs = new KthDistinctStringinArr();
        System.out.println(abs.kthDistinct(arr, k));
    }
}
