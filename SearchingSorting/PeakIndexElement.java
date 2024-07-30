public class PeakIndexElement {

    // Brute Force - O(m * log n) (M operations to calculate max element & then
    // further log N complexity for binary search)
    public int peakElement(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public int peakIndexInMountainArrayI(int[] arr) {
        int max = Integer.MIN_VALUE;
        int idx = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                idx = i;
            }
        }
        return peakElement(arr, max, 0, idx);
    }

    // Optimized approach
    // Since the array is a mountain array, first half would be in ascending order
    // And the second half would be in descending order
    // Use binary search

    public int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        PeakIndexElement ans = new PeakIndexElement();
        int nums[] = { 0, 1, 3, 8, 10, 8, 5, 3, 2 };
        System.out.println(ans.peakIndexInMountainArray(nums));
    }
}
