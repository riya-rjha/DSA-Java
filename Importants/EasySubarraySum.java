import java.util.Arrays;

public class EasySubarraySum {

    static int checkNegNos(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                count++;
            }
        }
        return count;
    }

    static int sum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static int ans(int arr[]) {
        Arrays.sort(arr);
        if (checkNegNos(arr) >= 2) {
            arr[0] = arr[0] * (-1);
            arr[1] = arr[1] * (-1);
            return sum(arr);
        }
        return sum(arr);
    }

    public static void main(String[] args) {
        int[] arr = { -3, 4, 6, 2, -1 };
        System.out.println(ans(arr));
    }
}