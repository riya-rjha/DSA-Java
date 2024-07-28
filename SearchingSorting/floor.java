public class floor {
    // Return the largest number in the array
    // smaller than or equal to the target number

    public static int floorNo(int nums[], int target) {
        int start = 0;
        int end = nums.length - 1;
        boolean isAscending = true;
        if (nums[start] > nums[end]) {
            isAscending = false;
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (isAscending) {
                if (target >= nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (target <= nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return end;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 3, 5, 9, 14, 16, 18 };
        int target = 0;
        int idx = floorNo(arr, target);
        if (idx != -1) {
            System.out.println(arr[idx]);
        }
        else{
            System.out.println("Index is -1");
        }
    }
}
