public class MaxAscendingArrSum {

    public static int maxAscendingSum(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = nums[i];
            System.out.println("i: " + i);
            int j = i;
            System.out.println("j: " + j);
            while (j < n - 1 && nums[j + 1] > nums[j]) {
                // System.out.println("nums: " + nums[j]);
                // System.out.println("idx: " + j);
                sum += nums[j + 1];
                // System.out.println("Sum: " + sum);
                j++;
                System.out.println("j incremented: " + j);
            }
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = { 10, 20, 30, 5, 10, 50 };
        System.out.println(maxAscendingSum(nums));
    }
}
