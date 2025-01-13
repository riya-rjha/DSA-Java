
public class LongestSubArr {

    public static int longestSubarray(int[] nums) {
        int maxEl = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxEl < nums[i]) {
                maxEl = nums[i];
            }
        }
        int count = 0;
        int maxLen = 0;
        for (int el : nums) {
            if (el == maxEl) {
                count++;
                maxLen = Math.max(maxLen, count);
            } else {
                count = 0;
            }
        }

        return maxLen;

    }

    public static void main(String[] args) {
        int[] arr = { 311155, 311155, 311155, 311155, 311155, 311155, 311155, 311155, 201191, 311155 };
        System.out.println(longestSubarray(arr));
    }
}
