import java.util.*;

public class A_Fibonacciness {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int a1 = sc.nextInt();
            int a2 = sc.nextInt();
            int a4 = sc.nextInt();
            int a5 = sc.nextInt();
            int max = 0;
            int cnt = 0;
            for (int a3 = -100; a3 <= 100; a3++) {
                cnt = 0;
                if (a3 == a1 + a2) cnt++;
                if (a4 == a2 + a3) cnt++;
                if(a5 == a4 + a3) cnt++;
                max = Math.max(max, cnt);
            }
            System.out.println(max);
        }
        sc.close();
    }
}