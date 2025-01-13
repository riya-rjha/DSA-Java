import java.util.Arrays;

public class FirstAndLastOccurrence {

    public int[] searchRange(int[] nums, int target) {
        int[] ans = { -1, -1 };
        ans[0] = helperFunction(nums, target, true); // find first occurrence
        ans[1] = helperFunction(nums, target, false); // find last occurrence
        return ans;
    }

    public int helperFunction(int nums[], int target, boolean isFirstOccurrence) {
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            }
            else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                idx = mid;
                if (isFirstOccurrence) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        int nums[] = { 5, 7, 7, 7, 7, 8, 8, 10 };
        // int nums[] = { 1 };
        int target = 7;
        FirstAndLastOccurrence searchRangeAns = new FirstAndLastOccurrence();
        System.out.println(Arrays.toString(searchRangeAns.searchRange(nums, target)));
    }
}
