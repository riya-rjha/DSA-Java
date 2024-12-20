import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class ArrayScoreAfterMarking {

    class Solution {
        // TLE
        public int findMin(List<Boolean> arr, int[] nums) {
            int idx = -1;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                if (arr.get(i) != true) {
                    // System.out.println(nums[i]+" "+ arr.get(i));
                    if (nums[i] < min) {
                        min = nums[i];
                        idx = i;
                    }
                }
            }
            return idx;
        }

        public long findScore(int[] nums) {
            List<Boolean> arr = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                arr.add(false);
            }
            long sum = 0;
            for (int i = 0; i < arr.size(); i++) {
                int currIdx = findMin(arr, nums);
                // System.out.println("Curr: " + currIdx);
                if (currIdx == -1) {
                    return sum;
                }
                arr.set(currIdx, true);
                // System.out.println(arr.get(currIdx)+" true/false for " + nums[currIdx]);
                int left = currIdx - 1;
                int right = currIdx + 1;
                if (left >= 0) {
                    arr.set(left, true);
                }
                if (right <= nums.length - 1) {
                    arr.set(right, true);
                }
                sum += nums[currIdx];
            }
            return sum;
        }

        // Optimized
        // Using PriorityQueue (Min Heap)
        public long findScoreOptimized(int[] nums) {
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                } else {
                    return a[0] - b[0];
                }
            }); // Sort on the basis of values
            long sum = 0;
            for (int i = 0; i < nums.length; i++) {
                pq.offer(new int[] { nums[i], i });
            }
            boolean[] marked = new boolean[nums.length];
            Arrays.fill(marked, false);
            while (!pq.isEmpty()) {
                int curr[] = pq.poll();
                int val = curr[0];
                int idx = curr[1];
                if (marked[idx]) {
                    continue;
                }
                marked[idx] = true;
                int left = idx - 1;
                int right = idx + 1;
                if (left >= 0) {
                    marked[left] = true;
                }
                if (right < nums.length) {
                    marked[right] = true;
                }
                sum += val;
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        ArrayScoreAfterMarking asm = new ArrayScoreAfterMarking();
        Solution s = asm.new Solution();
        int[] nums = { 2, 5, 6, 6, 10 };
        System.out.println(s.findScore(nums));
        System.out.println(s.findScoreOptimized(nums));
    }
}
