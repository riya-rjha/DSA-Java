import java.util.Arrays;

public class SelectionSort {

    static int maxEl(int arr[], int start, int end) {
        int currMax = Integer.MIN_VALUE;
        int idx = 0;
        for (int i = start; i <= end; i++) {
            if (arr[i] > currMax) {
                currMax = arr[i];
                idx = i;
            }
        }
        return idx;
    }

    static void selectionSort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int idx = arr.length - i - 1;
            int currMaxIdx = maxEl(arr, 0, idx);
            // Swapping Logic
            int temp = arr[currMaxIdx];
            arr[currMaxIdx] = arr[idx];
            arr[idx] = temp;
        }
    }

    public static void main(String[] args) {
        int arr[] = { 64, 242, -245, -1, 0, 25, -52, 3 };
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
