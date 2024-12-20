package CodeForces;
import java.util.*;

public class C_Hard_Problem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int m = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int firstRow = m;
            int secondRow = m;
            long count = 0;

            if (a < firstRow) {
                count += a;
                firstRow = firstRow - a;
            } else {
                count += firstRow;
                firstRow = 0;
            }

            if (b < secondRow) {
                count += b;
                secondRow = secondRow - b;
            } else {
                count += secondRow;
                secondRow = 0;
            }

            if (c <= firstRow) {
                count += c;
                firstRow = firstRow - c;
                c = 0;
            } else {
                count += firstRow;
                c = c - firstRow;
                firstRow = 0;
            }

            if (c <= secondRow) {
                count += c;
                secondRow = secondRow - c;
                c = 0;
            } else {
                count += secondRow;
                c = c - secondRow;
                secondRow = 0;
            }

            System.out.println(count);
        }
        sc.close();
    }
}
