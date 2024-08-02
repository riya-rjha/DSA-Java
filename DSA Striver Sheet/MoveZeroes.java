import java.util.ArrayList;
import java.util.Arrays;

public class MoveZeroes {

    // TC - O(n)
    // SC - O(n)
    public static ArrayList<Integer> moveZeroes(int[] nums) {
        ArrayList<Integer> temp = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                temp.add(nums[i]);
            }
            count++;
        }
        while (count != 0) {
            temp.add(0);
            count--;
        }
        return temp;
    }

    public static int[] moveZeroesOptimized(int nums[]) {
        int j = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
            else{
                count++;
            }
        }
        for (int i = nums.length - count; i < nums.length; i++) {
            nums[i] = 0;
        }
        return nums;
    }

    public static void swap(int nums[], int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void moveZeroesStriverApp(int nums[]){
        // Check for first 0th element
        // Initialize j

        int j = -1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==0){
                j = i;
                break;
            }
        }

        // Swap 0 with non zero number

        for (int i = j + 1; i < nums.length; i++) {
            if(nums[i]!=0){
                swap(nums, i, j);
                j++;
            }
        }

        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] nums = { 0, 1, 0, 3, 12 };
        int[] nums2 = { 0, 1, 0, 3, 12 };
        int[] nums3 = { 0, 1, 0, 3, 12 };
        System.out.println(moveZeroes(nums));
        int temp[] = moveZeroesOptimized(nums2);
        System.out.println(Arrays.toString(temp));
        moveZeroesStriverApp(nums3);
    }
}
