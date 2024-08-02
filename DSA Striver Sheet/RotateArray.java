import java.util.Arrays;

public class RotateArray {

    // Using Extra Space
    // Works only for a few arrays
    public static void rotateI(int[] arr1, int k) {

        k = k % arr1.length;

        int arr2[] = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            arr2[i] = arr1[i];
        }

        // System.out.println(Arrays.toString(arr1));
        // System.out.println(Arrays.toString(arr2));

        for (int i = 0; i < k; i++) {
            arr1[i] = arr1[arr1.length - k + i];
        }

        // System.out.println(Arrays.toString(arr1));
        // System.out.println(Arrays.toString(arr2));

        for (int i = k; i < arr1.length; i++) {
            arr1[i] = arr2[i - k];
        }

        // System.out.println(Arrays.toString(arr1));
        // System.out.println(Arrays.toString(arr2));

    }

    public static void rotateArrStriverApproach(int arr[], int k) {
        k = k % arr.length;
        int n = arr.length;

        int[] temp = new int[k];

        for (int i = 0; i < k; i++) {
            temp[i] = arr[n - k + i];
        }

        // Shift the rest of the array
        for (int i = n - 1; i >= k; i--) {
            arr[i] = arr[i - k];
        }

        // Copy the elements from temp back to the start of the array
        for (int i = 0; i < k; i++) {
            arr[i] = temp[i];
        }

    }

    public static void reverseArr(int nums[], int start, int end) {
        while (start <= end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void reverseRotateArr(int nums[], int k) {
        int n = nums.length;
        k = k % n;
        if (k != 0) {
            // n - k gives last k elements
            reverseArr(nums, n - k, n - 1);
            reverseArr(nums, 0, n - k - 1);
            reverseArr(nums, 0, n - 1);
        }
    }

    public static void reverseRotateArrOptimized(int nums[], int k) {
        int n = nums.length;
        k = k % n;
        if (k != 0) {
            // n - k gives last k elements
            reverseArr(nums, 0, n - 1);
            reverseArr(nums, 0, k - 1);
            reverseArr(nums, k, n - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        int k = 1;
        rotateArrStriverApproach(arr, k);
        System.out.println(Arrays.toString(arr));
        int[] arr2 = { 1, 2, 3, 4, 5 };
        reverseRotateArr(arr2, k);
        System.out.println(Arrays.toString(arr2));
        // to store elements in another array
        // System.arraycopy(srcArr, startIdx, destArr, endIdx, lengthOfArr)
    }
}
