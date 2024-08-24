import java.util.Arrays;

public class BubbleSort {

    public static void bubbleSortAlgo(int arr[]) {
        boolean isSwap = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    isSwap = true;
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
            if (!isSwap) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = { 3, 10, -5, 19, -46, 296, 0, -34, 28 };
        bubbleSortAlgo(arr);
        System.out.println(Arrays.toString(arr));
    }
}
