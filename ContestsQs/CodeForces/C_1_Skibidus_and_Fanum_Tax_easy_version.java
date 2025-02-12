import java.util.*;

public class C_1_Skibidus_and_Fanum_Tax_easy_version {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            long[] arr = new long[n];
            int[] brr = new int[m];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLong();
            }
            for (int i = 0; i < m; i++) {
                brr[i] = sc.nextInt();
            }
            int b = brr[0];
            if (n == 1) {
                System.out.println("YES");
            } else {
                int i = 0;
                while (i >= 0 && i < n - 1) {
                    if (arr[i + 1] < arr[i]) {
                        arr[i] = b - arr[i];
                        i -= 1;
                        continue;
                    } else {
                        i++;
                    }
                }
                System.out.println("arr1:" + Arrays.toString(arr));
                boolean flag = true;
                // System.out.println("arr2:" + Arrays.toString(arr));
                for (int j = 0; j < n - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        flag = false;
                        break;
                    }
                }
                if (flag)
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
        }
        sc.close();
    }
}