import java.util.*;

public class LongestSubArrWithSumK {
    static int lenOfLongestSubarr(int[] arr, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        int sum = 0;
        int len = 0;
        int maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }
            if (hm.containsKey(sum - k)) {
                len = i - hm.get(sum - k);
                maxLen = Math.max(maxLen, len);
            }
            if (!hm.containsKey(sum)) {
                hm.put(sum, i);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int arr[] = { 10, 5, 2, 7, 1, 9 };
        int k = 15;
        System.out.println(lenOfLongestSubarr(arr, k));
    }
}
