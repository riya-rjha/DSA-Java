import java.util.HashMap;
import java.util.Map;

public class MakeElUnique {

    static int minIncrements(int[] arr) {
        int count = 0;
        int n = arr.length;
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> num : hm.entrySet()) {
            int val = num.getValue();
            while (val != 1) {
                count++;
                val--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = { 7, 9, 3, 1, 3};
        System.out.println(minIncrements(arr));
    }
}
