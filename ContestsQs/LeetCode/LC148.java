import java.util.*;

public class LC148 {
    public static void main(String[] args) {
        int[] arr = { -5, -10, -5 };
        System.out.println(maxAdjacentDistance(arr));
        int[] a = { -7, 9, 5 };
        int[] b = { 7, -2, -5 };
        long k = 2;
        System.out.println(minCost(a, b, k));
    }

    static long minCost(int[] arr, int[] brr, long k) {
        int n = arr.length;

        boolean flag = true;
        for (int i = 0; i < n; i++) {
            if (arr[i] != brr[i]) {
                flag = false;
                break;
            }
        }
        if (flag)
            return k;

        long cost = 0;
        for (int i = 0; i < n; i++) {
            cost += Math.abs((long) arr[i] - brr[i]);
        }

        int[] arrCloneSorted = arr.clone();
        int[] brrCloneSorted = brr.clone();
        Arrays.sort(arrCloneSorted);
        Arrays.sort(brrCloneSorted);

        long newCost = k;
        for (int i = 0; i < n; i++) {
            newCost += Math.abs((long) arrCloneSorted[i] - brrCloneSorted[i]);
        }

        return Math.min(cost, newCost);
    }

    static int[] longestSpecialPath(int[][] edges, int[] nums) {
        int[] res = new int[2];
        List<List<Integer>> adj = new ArrayList<>();
        int v = 0;
        for (int el : nums) {
            v = Math.max(el, v);
        }
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }

        return res;
    }

    static int maxAdjacentDistance(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            int diff = Math.abs(nums[i] - nums[i - 1]);
            max = Math.max(diff, max);
        }
        max = Math.max(max, Math.abs(nums[0] - nums[nums.length - 1]));
        return max;
    }
}