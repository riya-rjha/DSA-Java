import java.util.HashMap;

class Solution {
    // Optimized Solution
    public int minSubarray(int[] nums, int p) {
        int totSum = 0;
        for (int num : nums) {
            totSum = (totSum + num) % p;
        }
        int remainder = totSum % p;
        if (remainder == 0) {
            return 0;
        }
        int minLen = nums.length;
        int currSum = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            currSum = (currSum + nums[i]) % p;
            int diff = (currSum - remainder + p) % p;
            if (hm.containsKey(diff)) {
                minLen = Math.min(minLen, i - hm.get(diff));
            }
            hm.put(currSum, i);
        }
        return minLen == nums.length ? -1 : minLen;
    }

    // Brute Force
    // TLE - O(n^2)
    public int minSubArrBruteForce(int[] nums, int p) {
        int totSum = 0;
        for (int num : nums) {
            totSum += num;
        }
        if (totSum % p == 0) {
            return 0;
        }
        int minLen = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int subArrSum = 0;
            for (int j = i; j < nums.length; j++) {
                subArrSum += nums[j];
                int diff = totSum - subArrSum;
                if (diff % p == 0) {
                    minLen = Math.min(minLen, j - i + 1);
                }
            }
        }
        return minLen == nums.length ? -1 : minLen;
    }
}

public class MakeSumDivisible {
    public static void main(String[] args) {
        int[] nums = { 6, 3, 5, 2 };
        int p = 9;
        Solution ans = new Solution();
        System.out.println(ans.minSubarray(nums, p));
        System.out.println(ans.minSubArrBruteForce(nums, p));
    }
}
