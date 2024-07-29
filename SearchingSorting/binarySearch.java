public class BinarySearch {

    public static int binSearch(int nums[], int target) {
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
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 4, 6, 9, 11, 12, 14, 20, 36, 48 };
        int arr2[] = { 48, 36, 20, 14, 12, 11, 9, 6, 4, 2 };
        int idx = binSearch(arr, 21);
        int idx2 = binSearch(arr2, 20);
        if (idx != -1) {
            System.out.println("Element found at position " + idx);
        } else {
            System.out.println("Element not found!");
        }
        if (idx2 != -1) {
            System.out.println("Element found at position " + idx2);
        } else {
            System.out.println("Element not found!");
        }
    }

}
