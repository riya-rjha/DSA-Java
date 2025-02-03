public class LongestIncreasing {

    public static int longestMonotonicSubarray(int[] nums) {
        int maxLen = 1;
        int incLen = 1;
        int decLen = 1;
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                incLen++;
                decLen = 1;
            } else if (nums[i] < nums[i - 1]) {
                decLen++;
                incLen = 1;
            } else {
                incLen = 1;
                decLen = 1;
            }
            maxLen = Math.max(maxLen, Math.max(incLen, decLen));
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 2, 1 };
        System.out.println(longestMonotonicSubarray(nums));
    }
}