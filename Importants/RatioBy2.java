import java.util.Scanner;

public class RatioBy2 {

    public static int ans(int x, int y) {
        if (x == 2 * y || y == 2 * x) {
            return 0;
        }

        int max = Math.max(x, y);
        int min = Math.min(x, y);
        int ans = 0;

        if (x == y) {
            return (x - x / 2);
        }

        int currNum = max - max / 2;
        int difference = max - min;

        if (currNum > difference) {
            ans = Math.abs(currNum - difference);
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            System.out.println(ans(x, y));
        }
        sc.close();
    }
}