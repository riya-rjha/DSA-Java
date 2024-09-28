import java.util.*;

public class MinimumSession {
    public static int countSessions(int d, int x, int y) {
        int count = 1;
        int discount = 0;
        float x2 = x;
        while (x2 > y) {
            count++;
            y--;
            discount += d;
            x2 = (float) x * (100 - discount) / 100;
            if (y < 0) {
                count = -1;
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- != 0) {
            int d = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();

            System.out.println(countSessions(d, x, y));

        }
        sc.close();
    }

}