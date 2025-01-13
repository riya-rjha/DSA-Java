import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class FrequencyOfLimitedRangeEl {

    public static void frequencyCount(int arr[], int N, int P) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < N; i++) {
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
        }
        Arrays.fill(arr, 0);
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            if (entry.getKey() - 1 < arr.length) {
                arr[entry.getKey() - 1] = entry.getValue();
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 2, 3, 5 };
        int N = arr.length;
        int p = 5;
        frequencyCount(arr, N, p);
        System.out.println(Arrays.toString(arr));
    }
}
