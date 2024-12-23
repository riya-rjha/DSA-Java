import java.util.Arrays;

public class LC143 {

    static int digProd(int n) {
        int m = n;
        int num = 1;
        while (m != 0) {
            int ld = m % 10;
            num = num * ld;
            m = m / 10;
        }
        return num;
    }

    static int smallestNumber(int n, int t) {
        for (int i = n; i <= 100; i++) {
            if (digProd(i) % t == 0) {
                return i;
            }
        }
        return -1;
    }

    static int maxFrequency(int[] nums, int k, int ops) {
        Arrays.sort(nums);
        int left = 0, maxFreq = 1;
        long operations = 0;

        for (int right = 1; right < nums.length; right++) {
            operations += (long) (nums[right] - nums[right - 1]) * (right - left);
            while (operations > ops) {
                operations -= nums[right] - nums[left];
                left++;
            }
            maxFreq = Math.max(maxFreq, right - left + 1);
        }

        return maxFreq;
    }

    public static void main(String[] args) {
        // int n = 15, t = 3;
        // System.out.println(smallestNumber(n, t));

        int[] nums = { 5, 11, 20, 20 };
        int k = 5, numOperations = 1;
        System.out.println(maxFrequency(nums, k, numOperations));
    }
}