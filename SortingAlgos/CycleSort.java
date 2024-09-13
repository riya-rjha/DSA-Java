public class CycleSort {

    static void swapArr(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void cyclicSort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            if (arr[i] != arr[arr[i] - 1]) {
                swapArr(arr, i, arr[i] - 1);
            } else {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = { 4, 3, 1, 2 };
        cyclicSort(arr);
        printArr(arr);
    }
}
