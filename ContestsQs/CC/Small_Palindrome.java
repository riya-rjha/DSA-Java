import java.util.*;

public class Small_Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            StringBuilder sb = new StringBuilder("");
            int halfOnes = x / 2;
            int halfTwos = y / 2;
            while (halfTwos-- > 0) {
                sb.append("2");
            }
            while (halfOnes-- > 0) {
                sb.append("1");
            }
            StringBuilder firstHalf = new StringBuilder(sb);
            // System.out.println("firs: " + firstHalf);
            StringBuilder secondHalf = new StringBuilder(sb).reverse();
            // System.out.println("sec: " + secondHalf);
            System.out.println(secondHalf.append(firstHalf));
        }
        sc.close();
    }
}