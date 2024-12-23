import java.util.*;

public class B_Transfusion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
                sum += arr[i];
            }
            if (sum % n != 0) {
                System.out.println("NO");
                continue;
            }
            int targetElement = sum / n;
            int sum1 = 0;
            int min = 0;
            for (int element : arr) {
                sum1 += element - targetElement;
                min = Math.min(min, sum1);
            }
            if (min >=0 )
                System.out.println("YES");
            else
                System.out.println("NO");
        }
        sc.close();
    }
}