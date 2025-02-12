import java.util.*;

public class Streaj_Star {

    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int x = sc.nextInt();
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = sc.nextInt();
                }
                int ans = 1;
                int max = 1;
                for (int j = 0; j < n; j++) {
                    int[] temp = arr.clone();
                    temp[j] *= x;
                    ans = 1;
                    for (int i = 1; i < n; i++) {
                        if (temp[i] >= temp[i - 1]) {
                            ans++;
                        } else {
                            ans = 1;
                        }
                        max = Math.max(max, ans);
                    }
                }
                System.out.println(max);
            }
            sc.close();
    }
}