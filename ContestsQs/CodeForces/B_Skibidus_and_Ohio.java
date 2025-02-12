import java.util.*;

public class B_Skibidus_and_Ohio {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int cnt = 0;
            for (int i = 0; i < s.length() - 1; i++) {
                if (s.charAt(i) == s.charAt(i + 1)) {
                    cnt++;
                    break;
                }
            }
            System.out.println(s.length() > 1 && cnt == 1 ? "1" : s.length());
        }
        sc.close();
    }
}