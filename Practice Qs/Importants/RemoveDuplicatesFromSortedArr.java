import java.util.*;

public class RemoveDuplicatesFromSortedArr {

    // TC - O(n * log n + N )
    public static int removeDuplicates(int[] nums) {
        // Maintains order of adding elements
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        // for (int i = 0; i < set.size(); i++) {
        // System.out.println(set.toArray()[i]);
        // }
        int idx = 0;
        for (int el : set) {
            nums[idx] = el;
            // System.out.println(nums[idx]);
            idx++;
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        return idx;
    }

    // Optimized
    // 2 pointer approach
    // TC - O(n)

    public static int removeDuplicates2(int nums[]) {
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                nums[j + 1] = nums[i];
                j++;
            }
        }
        return j + 1;
    }

    public static void main(String[] args) {
        int arr[] = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        System.out.println(removeDuplicates(arr));
        int arr2[] = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        System.out.println(removeDuplicates2(arr2));
    }
}
