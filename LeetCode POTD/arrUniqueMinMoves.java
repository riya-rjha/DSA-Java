import java.util.Arrays;

public class arrUniqueMinMoves {

    public static int minIncrementForUnique(int[] nums) {
        int no_of_moves = 0;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                int increment = nums[i - 1] + 1 - nums[i];
                no_of_moves += increment;
                nums[i] = nums[i - 1] + 1;
            }
        }
        return no_of_moves;
    }

    public static void main(String[] args) {
        int nums[] = { 3, 2, 1, 2, 1, 7 };
        // int nums[] = { 1, 2, 2 };
        System.out.println(minIncrementForUnique(nums));
    }
}