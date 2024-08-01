import java.util.Arrays;

public class LeftRotateArrByOnePlace {

    // Using Extra Space
    public static void rotate(int[] arr1, int k) {

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

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        int k = 3;
        rotate(arr, k);
        System.out.println(Arrays.toString(arr));
    }
}
