import java.util.*;

public class MinOperationsThreshold {

    public static int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int el : nums) {
            pq.add((long) el);
        }
        int cnt = 0;
        while (pq.size() >= 2 && pq.peek() < k) {
            long a = pq.poll();
            long b = pq.poll();
            long ans = a * 2 + b;
            pq.add(ans);
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 2, 4, 9 };
        int k = 20;
        System.out.println(minOperations(nums, k));
    }
}