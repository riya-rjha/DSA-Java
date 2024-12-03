import java.util.*;

public class LC426 {
    static int smallestNumber(int n) {
        for (int i = n; i < 10000; i++) {
            String binStr = Integer.toBinaryString(i);
            if (!binStr.contains("0")) {
                return i;
            }
        }
        return 1;
    }

    static int getLargestOutlier(int[] nums) {
        Map<Integer, Integer> hm = new TreeMap<>();
        for (int el : nums) {
            hm.put(el, hm.getOrDefault(el, 0) + 1);
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int max = Integer.MIN_VALUE;
        for (int el : nums) {
            int remainingSum = sum - el;
            hm.put(el, hm.get(el) - 1);
            if (hm.get(el) == 0) {
                hm.remove(el);
            }
            if (remainingSum % 2 == 0) {
                int currEl = remainingSum / 2;
                if (hm.containsKey(currEl)) {
                    max = Math.max(max, el);
                }
            }
            hm.put(el, hm.getOrDefault(el, 0) + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        int n = 514;
        System.out.println(smallestNumber(n));
        int[] nums = { -85, -85, 828 };
        System.out.println(getLargestOutlier(nums));
        int[][] edges1 = { { 0, 1 }, { 0, 2 }, { 2, 3 }, { 2, 4 } };
        int[][] edges2 = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 2, 7 }, { 1, 4 }, { 4, 5 }, { 4, 6 } };
        int k = 2;
        System.out.println(Arrays.toString(maxTargetNodes(edges1, edges2, k)));
    }
}