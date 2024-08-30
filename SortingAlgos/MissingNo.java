import java.util.HashMap;

public class MissingNo {

    // Poor Approach
    static int missingNumber(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i], i);
        }
        int[] temp = new int[nums.length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = i + 1;
        }
        for (int i = 0; i < hm.size(); i++) {
            if (!hm.containsKey(temp[i])) {
                return temp[i];
            }
        }
        return 0;
    }

    // Optimized approach
    static int missingNoOptimized(int[] nums) {
        int n = nums.length;
        int sumUptoN = n * (n + 1) / 2;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sumUptoN - sum;
    }

    public static void main(String[] args) {
        int[] nums = { 9, 6, 4, 2, 3, 5, 7, 0, 1 };
        System.out.println("Missing number : " + missingNumber(nums));
        System.out.println("Missing number : " + missingNoOptimized(nums));
    }
}
