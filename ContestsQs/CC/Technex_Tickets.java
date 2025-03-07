import java.util.*;

public class Technex_Tickets {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int cnt = 0;
            if (n % 2 == 0) {
                cnt = (n / 2) + 1;
            } else{
                cnt = n / 2;
            }
            System.out.println(n == 1 ? 1 : cnt);
        }
        sc.close();
    }
}