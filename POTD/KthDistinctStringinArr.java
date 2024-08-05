import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
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

    public String kthDistinctOptimized(String [] arr, int k){
        LinkedHashSet<String> distinctSet = new LinkedHashSet<>();
        LinkedHashSet<String> nonDistinctSet = new LinkedHashSet<>();

        int totalDistinctCount = 0;

        for (String str : arr) {
            if(!nonDistinctSet.contains(str)){
                if(!distinctSet.contains(str)){
                    distinctSet.add(str);
                    totalDistinctCount++;
                }else{
                    distinctSet.remove(str);
                    nonDistinctSet.add(str);
                    totalDistinctCount--;
                }
            }
        }

        if(totalDistinctCount < k) return "";

        for (String str : distinctSet) {
            if(distinctSet.contains(str)){
                k--;
            }
            if(k == 0){
                return str;
            }
        }

        return "";

    }

    public static void main(String[] args) {
        String arr[] = { "aaa","aa","a" };
        int k = 1;
        KthDistinctStringinArr abs = new KthDistinctStringinArr();
        System.out.println(abs.kthDistinct(arr, k));
        System.out.println(abs.kthDistinctOptimized(arr, k));
    }
}
