import java.util.Scanner;

public class LargestSubSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            int inMax = 0;
            int lastMax = 0;
            if (s.charAt(0) == s.charAt(s.length() - 1)) {
                System.out.println(n);
            } else {
                char st = s.charAt(0);
                for (int i = n - 1; i >= 0; i--) {
                    if (st == s.charAt(i)) {
                        inMax = i + 1;
                        break;
                    }
                }
                char end = s.charAt(n - 1);
                for (int i = 0; i < n; i++) {
                    if (end == s.charAt(i)) {
                        lastMax = n - i;
                        break;
                    }
                }
                int ans = 0;
                ans = inMax > lastMax ? inMax : lastMax;
                System.out.println(ans);
            }
        }
        sc.close();
    }
}
