public class InfiniteArray {

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
        
    }
}
