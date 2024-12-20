import java.util.Scanner;

public class C_Hard_Problem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int m = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int ans = 0;
            int rem = 0;
            ans += Math.min(m, a);
            rem += m - Math.min(m, a);
            ans += Math.min(m, b);
            rem += m - Math.min(m, b);
            ans += Math.min(c, rem);
            System.out.println(ans);
        }
        sc.close();
    }
}