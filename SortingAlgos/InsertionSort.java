import java.util.Arrays;

public class InsertionSort {

    static void insertionSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = { 3, 10, -5, 19, -46, 296, 0, -34, 28 };
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
