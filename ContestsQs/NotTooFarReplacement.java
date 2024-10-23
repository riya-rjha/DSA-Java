import java.util.Scanner;

public class NotTooFarReplacement {

    public static void swap(int[] arr, int i, int n) {
        int temp = arr[i];
        arr[i] = arr[n];
        arr[n] = temp;
    }

    public static int calcSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static void helper(int[] arr) {
        int n = arr.length - 1;
        int val = arr[n];
        boolean isSwap = true;

        while (isSwap) {
            isSwap = false;
            for (int i = 0; i < n; i++) {
                if (arr[i] <= 2 * val) {
                    if (val < arr[i]) {
                        swap(arr, i, n);
                        val = arr[n];
                        isSwap = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n + 1];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }
            // int[] arr = {16, 4, 8, 2, 1};
            helper(arr);
            System.out.println(calcSum(arr));
            sc.close();
        }
    }
}
