import java.util.Scanner;

public class Quintomania {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }
            int flag = 0;
            for (int i = 0; i < n - 1; i++) {
                int ans = Math.abs(arr[i] - arr[i + 1]);
                if (ans != 5 && ans != 7) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 1) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
        sc.close();
    }
}
