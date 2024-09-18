import java.util.Arrays;
import java.util.Scanner;

public class RangeMin {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- != 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            int minRange = 0;

            Arrays.sort(arr);

            int lastTwo = arr[n - 1] - arr[2];
            int firstTwo = arr[n - 3] - arr[0];
            int firstLast = arr[n - 2] - arr[1];

            minRange = Math.min(lastTwo, Math.min(firstTwo, firstLast));
            System.out.println(minRange);

            sc.close();

        }

    }
}
