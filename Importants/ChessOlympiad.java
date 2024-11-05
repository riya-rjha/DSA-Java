import java.util.*;

public class ChessOlympiad {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int d = sc.nextInt();
        int l = sc.nextInt();
        int rem = w + d + l;
        float w1 = w + d * .5f;
        float w2 = l + d * .5f;

        while (rem != 4) {
            w1 = w1 + 1;
            rem++;
        }
        if (rem == 4 && w1 > w2) {
            System.out.println("YES");
        }
        if (rem == 4 && w1 <= w2) {
            System.out.println("NO");
        }
        sc.close();
    }
}
