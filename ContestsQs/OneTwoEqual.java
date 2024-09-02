import java.util.Scanner;

public class OneTwoEqual {

    public static boolean checkAns(int a, int b) {
        // Check when sum = 0 not possible

        // no of ones are odd, then sum also becomes odd
        if (a % 2 != 0) {
            return false;
        }

        if (a == 0 && b % 2 != 0) { // because when b is even, then +2 and -2
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t != 0) {
                int a = sc.nextInt(); // no of 1's
                int b = sc.nextInt(); // no of 2's
                if (checkAns(a, b)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
                t--;
            }
        }
    }
}
